/**
 *
 */
package com.xjy.autotest.generate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Created by ychaoyang on 2017/09/26.
 */
public class GenerateYijiApiCase extends GenerateBaseFile {
	protected final static Logger log = LoggerFactory.getLogger(GenerateYijiApiCase.class);

	public static void main(String[] args) {
		String serviceNo = "customerRegister";
		String author = "ychaoyang";
		new GenerateYijiApiCase().generate(serviceNo, author, GenerateYijiApiCase.class);
	}

	/**
     * 生成测试代码
	 */
	public void generate(String serviceNo, String author, Class<?> claz) {
		//获取请求参数
//		String url = "http://119.23.161.195:9084/apiService/getServiceByNo.html?serviceNo=";
		String url = "http://openapi.xjiye.com/apiService/getServiceByNo.html?serviceNo=";
		String html = httpGet(url + serviceNo + "_1.0");
		//全部数据
		JSONObject result = JSON.parseObject(html);
		//data
		JSONObject data = JSON.parseObject(result.getString("data"));
		if (null == data.getString("requestInfo")) {
			log.info("服务码不存在，请确认服务码!");
			return;
		}
		//requestInfo
		JSONObject requestInfo = JSON.parseObject(data.getString("requestInfo"));
		//把字符串转成 JSONArray对象
		JSONArray parameters = JSONArray.parseArray(requestInfo.getString("parameters"));
//		System.out.println(parameters);
		List<ApiParameter> pars = new ArrayList<ApiParameter>();
		Map<String, Object> map = new HashMap<>();
		if (parameters.size() > 0) {
			for (int i = 0; i < parameters.size(); i++) {
				ApiParameter par = new ApiParameter();
				JSONObject parameter = parameters.getJSONObject(i);
				if (map.containsKey(parameter.getString("name"))) {
					continue;
				}
				map.put(parameter.getString("name"), true);
				par.setItemCode(parameter.getString("name"));
				par.setItemTitle(parameter.getString("title"));

//				par.setValType(parameter.getString("valType"));
				par.setValType("String");
				par.setFullStatus(parameter.getString("status"));
				par.setSizeScope(parameter.getString("dataLength"));
				if (!"[]".equals(parameter.getString("children"))) {
					par.setChildren(JSONArray.parseArray(parameter.getString("children")));
				}
				par.setLayer(0);
				par.setNewest(true);
				pars.add(par);
			}
		}
		//添加第二层参数
		for (int j = 0; j < pars.size(); j++) {
			ApiParameter p = pars.get(j);
			if (0 == p.getLayer() && p.getChildren() != null && p.getChildren().size() != 0) {
				addParamters(pars, p, map);
			}
		}
		ArrayList<String> ls = new ArrayList<>();
		for (int j = 0; j < pars.size(); j++) {
			ApiParameter p = pars.get(j);
			if (1 == p.getLayer() && p.getChildren() != null && p.getChildren().size() != 0) {
				addParamters(pars, p, map);
				ls.add(p.getItemCode());
			}
		}
//		System.out.println(ls);

		for (ApiParameter p : pars) {
//			System.out.println(p);
		}
		String serviceName = data.getString("serviceName").trim();
		if(serviceName.endsWith(" 服务")){
			serviceName = serviceName.replace(" 服务", "");
		}
//		System.out.println(serviceName);
		//类名
		String className = toUpperCaseFirstOne(serviceNo) + "ApiTest";
		String filePath = Thread.currentThread().getContextClassLoader()
				.getResource("ftl/").getPath().replace("/target/test-classes",
						"/src/test/resources");
		String outFile = getClassFilePath(claz).replace("\\target\\classes",
				"\\src\\test\\java").replace(claz.getName().split("\\.")[claz.getName().split("\\.").length - 1] + "" +
				".class", className + ".java");
		String packageName = claz.getPackage().getName();
		String projectName = packageName.substring(packageName.lastIndexOf(".") + 1);
//        System.out.println(packageName);
//        System.out.println(filePath);
//        System.out.println(outFile);
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
		try {
			cfg.setDirectoryForTemplateLoading(new File(filePath));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			Map<String, Object> root = new HashMap<String, Object>();
			root.put("packageName", packageName);
			root.put("projectName", projectName);
			root.put("projectUpName", projectName.toUpperCase());
			root.put("className", className);
			root.put("funcName", toLowerCaseFirstOne(className));
			root.put("serviceName", serviceName);
			root.put("author", author);
			root.put("serviceNo", serviceNo);
			root.put("time", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			ArrayList<String> lists = new ArrayList<>();
			for (ApiParameter p : pars) {
				if (null == p.getSecondCode()) {
					p.setSecondCode(p.getItemCode());
				}
				if (p.getChildren() != null && p.getChildren().size() != 0 && !lists.contains(p.getSecondCode())) {
					lists.add(p.getSecondCode());
				}
				if ("memo".equals(p.getSecondCode())) {
					p.setSecondCode(p.getSecondCode() + "1");
				}
			}
			root.put("pars", pars);
			root.put("childlist", lists);
//			System.out.println(lists);
			Template template = cfg.getTemplate("generateYijiApiCase.ftl");
			if (new File(outFile).exists()) {
				log.info("该文件已存在，{}", outFile);
				log.info("是否覆盖？Y:继续/N:返回");
				Scanner s = new Scanner(System.in);
				String line = s.nextLine();
				if (!"Y".equalsIgnoreCase(line)) {
					return;
				}
			}
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
			try {
				template.process(root, out);
				System.out.println("更新成功 " + outFile);
			} catch (TemplateException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * 获取参数
     */
    public static void addParamters(List<ApiParameter> pars, ApiParameter apiParam, Map<String, Object> map) {
        if (!map.containsKey(apiParam.getItemCode())) {
            map.put(apiParam.getItemCode(), true);
        }
        if (apiParam.getChildren() != null && apiParam.getChildren().size() != 0) {

            JSONArray params = apiParam.getChildren();
            for (int i = 0; i < params.size(); i++) {
                JSONObject parameter = params.getJSONObject(i);
                String mapName = "";
                if (null != apiParam.getSecondCode()) {
                    mapName = apiParam.getSecondCode() + "_" + parameter.getString("name");
                } else {
                    mapName = apiParam.getItemCode() + "_" + parameter.getString("name");
                }
                if (!map.containsKey(parameter.getString("name"))) {
                    mapName = parameter.getString("name");
                }
                if (map.containsKey(mapName)) {
                    continue;
                }
                map.put(mapName, true);

                ApiParameter parchild = new ApiParameter();
                parchild.setItemCode(parameter.getString("name"));
                parchild.setSecondCode(mapName);
                parchild.setItemTitle(parameter.getString("title"));
                // parchild.setValType(parameter.getString("valType"));
                parchild.setValType("String");
                parchild.setFullStatus(parameter.getString("status"));
                parchild.setSizeScope(parameter.getString("dataLength"));
                if (!"[]".equals(parameter.getString("children"))) {
                    parchild.setChildren(JSONArray.parseArray(parameter.getString("children")));
                }
                if (null != apiParam.getSecondCode()) {
                    parchild.setFather(apiParam.getSecondCode());
                } else {
                    parchild.setFather(apiParam.getItemCode());
                }
                parchild.setLayer(apiParam.getLayer() + 1);
                parchild.setNewest(true);
                if (null == parchild.getItemCode()) {
                    System.out.println("有问题");
                }
                pars.add(parchild);
            }
        }

    }


}

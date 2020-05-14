package com.xjy.autotest.generate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.base.AutoTestBase;
import common.util.StringUtils;
import dal.dao.rap.TbProjectDAO;
import dal.model.rap.TbProjectDOExample;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import javafx.application.Application;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ychaoyang on 2017/8/16.
 */
@Service
public class GenerateApiCase extends AutoTestBase {

	@Autowired
	TbProjectDAO tbProjectDAO;

	protected final static Logger log = LoggerFactory.getLogger(GenerateApiCase.class);

	private static Pattern BRACE = Pattern.compile("\\{\\w+\\}");
	private static Pattern COLON = Pattern.compile(":\\w+");


	/**
	 * 生成测试代码
	 *
	 * @param requestUrl 接口地址 例子：message/queryList
	 * @param packag     包名 例子:jhy
	 * @param projectId  项目号
	 * @param author     作者
	 * @param claz       类名
	 */
	public void generate(String requestUrl, String packag, int projectId, String author, Class<?> claz) {
		String serviceName = "";
		String requestType = "";
		String menuName = "";
		if (requestUrl.trim().startsWith("/")) {
			requestUrl = requestUrl.trim().substring(1);
		}
		//获取请求参数
		JSONArray parameters = getParametersFromRap(requestUrl, projectId);
		if (0 == parameters.size()) {
			return;
		}
		List<ApiParameter> pars = new ArrayList<ApiParameter>();
		Map<String, Object> map = new HashMap<>();
		if (parameters.size() > 0) {
			for (int i = 0; i < parameters.size(); i++) {
				ApiParameter par = new ApiParameter();
				JSONObject parameter = parameters.getJSONObject(i);
				if (StringUtils.isNotBlank(parameter.getString("requestType"))) {
					requestType = parameter.getString("requestType");
					serviceName = parameter.getString("serviceName").trim();
					menuName = parameter.getString("menuName");
					continue;
				}
				if (map.containsKey(parameter.getString("identifier"))) {
					continue;
				}
				map.put(parameter.getString("name"), true);
				par.setItemCode(parameter.getString("identifier"));
				if (StringUtils.isNotBlank(parameter.getString("name"))) {
					par.setItemTitle(parameter.getString("name"));
				}

				par.setParamType(parameter.getString("dataType"));
				par.setValType("String");
				if (!"[]".equals(parameter.getString("parameterList"))) {
					par.setChildren(JSONArray.parseArray(parameter.getString("parameterList")));
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
		String serviceNo = "";
		if (requestUrl.contains("/")) {
			if (requestUrl.split("/").length > 1) {
				serviceNo += requestUrl.split("/")[0];
				for (int i = 1; i < requestUrl.split("/").length; i++) {
					String str = requestUrl.split("/")[i];
					if (StringUtils.isBlank(str)) {
						continue;
					}
					Matcher m = BRACE.matcher(str);
					if (m.find()) {
						serviceNo += str;
					} else {
						serviceNo += toUpperCaseFirstOne(requestUrl.split("/")[i]);
					}
				}
			}
		} else {
			serviceNo = requestUrl.trim();
		}

		Matcher m = BRACE.matcher(serviceNo);
		String requestOrder = null;
		if (m.find()) {
			String text = m.group();
			if (text.length() > 2) {
				String pp = text.substring(1, text.length() - 1);
				if (pp.length() != 0) {
					requestOrder = pp;
					ApiParameter par = new ApiParameter();
					par.setItemCode(pp);
					par.setValType("String");
					par.setLayer(-1);
					par.setNewest(true);
					pars.add(par);

				}
			}
			serviceNo = serviceNo.replace(text, "");
			requestUrl = requestUrl.replace(text, "");
		}
		Matcher m1 = COLON.matcher(serviceNo);
		if (m1.find()) {
			String text = m1.group();
			if (text.length() > 1) {
				String pp = text.substring(1);
				if (pp.length() != 0) {
					requestOrder = pp;
					ApiParameter par = new ApiParameter();
					par.setItemCode(pp);
					par.setValType("String");
					par.setLayer(-1);
					par.setNewest(true);
					pars.add(par);

				}
			}
			serviceNo = serviceNo.replace(text, "");
			requestUrl = requestUrl.replace(text, "");
		}
		//类名
		String className = toUpperCaseFirstOne(serviceNo) + "ApiTest";
		String filePath = Thread.currentThread().getContextClassLoader()
				.getResource("ftl/").getPath().replace("/target/test-classes",
						"/src/test/resources");
		String outFile = getClassFilePath(claz)
				.replace("\\target\\classes", "\\src\\test\\java")
				.replace("/target/classes", "/src/test/java")
				.replace(claz.getName().split("\\.")[claz.getName().split("\\.").length - 1] + ".class",
						packag.replace(".", "\\"));
		String classFile = getClassFilePath(claz)
				.replace("\\target\\classes", "\\src\\test\\java")
				.replace("/target/classes", "/src/test/java")
				.replace("\\"+claz.getName().split("\\.")[claz.getName().split("\\.").length - 1] + ".class", "\\"+packag.replace(".", "\\") + "\\"+className + ".java")
				.replace("/"+claz.getName().split("\\.")[claz.getName().split("\\.").length - 1] + ".class",  "/"+packag.replace(".", "\\") + "/"+className + ".java");
		String packageName = "com.xjy.autotest." + packag.replace("/", ".");
		String projectName = packag.indexOf(".") == -1 ? packag : packag.substring(0, packag.indexOf("."));
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
		try {
			cfg.setDirectoryForTemplateLoading(new File(filePath));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			String baseName = null;
			if ("jhy".equals(projectName) || "jhy2c".equals(projectName) || "pos".equals(projectName)) {
				baseName = "Jhy";
			} else {
				baseName = toUpperCaseFirstOne(projectName);
			}
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("packageName", packageName);
			root.put("projectName", projectName);
			root.put("projectId", projectId);
			root.put("baseName", baseName);
			root.put("className", className);
			root.put("funcName", toLowerCaseFirstOne(className));
			root.put("author", author);
			root.put("requestUrl", requestUrl.trim().startsWith("api") ? requestUrl.trim().substring(4) : requestUrl
					.trim());
			root.put("requestOrder", requestOrder);
			root.put("serviceName", serviceName);
			root.put("requestType", requestType);
			root.put("menuName", menuName);
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
			Template template = cfg.getTemplate("generateApiCase.ftl");
			File f = new File(outFile);
			if (!f.exists()) {
				f.mkdirs();
			}
			if (new File(classFile).exists()) {
				logger.error("该文件已存在，{}", classFile);
				throw new Exception();
			}
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(classFile)));
			try {
				template.process(root, out);
				System.out.println("更新成功" + classFile);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
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
					mapName = apiParam.getSecondCode() + "_" + parameter.getString("identifier");
				} else {
					mapName = apiParam.getItemCode() + "_" + parameter.getString("identifier");
				}
				if (!map.containsKey(parameter.getString("identifier"))) {
					mapName = parameter.getString("identifier");
				}
				if (map.containsKey(mapName)) {
					continue;
				}
				map.put(mapName, true);

				ApiParameter parchild = new ApiParameter();
				parchild.setItemCode(parameter.getString("identifier"));
				parchild.setSecondCode(mapName);
				parchild.setItemTitle(parameter.getString("name"));
				// parchild.setValType(parameter.getString("dataType"));
				parchild.setValType("String");
				if (!"[]".equals(parameter.getString("parameterList"))) {
					parchild.setChildren(JSONArray.parseArray(parameter.getString("parameterList")));
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

	public JSONArray getParametersFromRap(String requestUrl, int projectId) {
		JSONArray jsonArray = new JSONArray();
//		String loginUrl = "http://172.18.1.209/account/doLogin.do?account=huairen&password=123456";
//		String queryUrl = "http://172.18.1.209/workspace/loadWorkspace.do?projectId=" + projectId;
//
//		HttpGet httpGet = new HttpGet(loginUrl);
//		httpGet.addHeader("UM_distinctid", "15de920434732c-0f242a664097e8-293e1d4e-1fa400-15de9204348689");
//		httpGet.addHeader("CNZZDATA5879641", "cnzz_eid=1060701586-1502852054-&ntime=1502852054");
//		httpGet.addHeader("JSESSIONID", "EF003F6A0AA19A5E3338F483B4F88EF9");
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		try {
//			CloseableHttpResponse response = httpclient.execute(httpGet);
//			response.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		String result = "";
//		httpGet.setURI(URI.create(queryUrl));
//		try {
//			CloseableHttpResponse response = httpclient.execute(httpGet);
//			if (200 == response.getStatusLine().getStatusCode()) {
//				result = EntityUtils.toString(response.getEntity(), "UTF-8").replace("\\'", "");
//			}
//			response.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if (StringUtils.isBlank(result)) {
//			System.out.println("未查询到数据...");
//			return null;
//		}

		String result = "";
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dal/dal-db.xml", "dal/dal-db-rap" +
//				".xml");
		//TbProjectDAO tbProjectDAO = applicationContext.getBean(TbProjectDAO.class);
		TbProjectDOExample exam = new TbProjectDOExample();
		exam.createCriteria().andIdEqualTo(projectId);
		result = tbProjectDAO.selectByExample(exam).get(0).getProjectData().toString().replace("\\'", "\'");
		JSONObject json1 = JSON.parseObject(result);
		JSONObject json2 = json1;
		for (Object object : json2.getJSONArray("moduleList")) {
			JSONObject json3 = (JSONObject) JSONObject.toJSON(object);
			String menuName = json3.getString("name");
			for (Object object1 : json3.getJSONArray("pageList")) {
				JSONObject json4 = (JSONObject) JSONObject.toJSON(object1);
				for (Object object2 : json4.getJSONArray("actionList")) {
					JSONObject json5 = (JSONObject) JSONObject.toJSON(object2);
					if (json5.getString("requestUrl").trim().replace("/", "")
							.equals(requestUrl.trim().replace("/", ""))) {
						JSONObject json = new JSONObject();
						json.put("serviceName", json5.getString("name"));
						json.put("requestType", json5.getString("requestType"));
						json.put("menuName", menuName);
						jsonArray = json5.getJSONArray("requestParameterList");
						jsonArray.add(json);
					}
				}
			}
		}
		return jsonArray;
	}


}

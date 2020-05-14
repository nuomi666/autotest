/**
 *
 */
package com.xjy.autotest.generate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ychaoyang on 2017/09/26.
 */
public class GenerateXybApiCase extends GenerateBaseFile {
    protected final static Logger log = LoggerFactory.getLogger(GenerateXybApiCase.class);

    public static void main(String[] args) {
        String serviceNo = "customerRegister";
        String author = "ychaoyang";
        new GenerateXybApiCase().generate(serviceNo, "", author, GenerateXybApiCase.class);
    }

    /**
     * 生成测试代码
     */
    public void generate(String serviceNo, String packag, String author, Class<?> claz) {
        //获取请求参数
        //String url = "http://192.168.2.235:8087/apiService/getServiceByNo.json?serviceNo=";
        String url = "http://opendoc.shenmapay.com/apiService/getServiceByNo.json?serviceNo=";
        String html = httpGet(url + serviceNo);
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
                if (map.containsKey(parameter.getString("itemCode"))) {
                    continue;
                }
                map.put(parameter.getString("itemCode"), true);
                par.setItemCode(parameter.getString("itemCode"));
                par.setItemTitle(parameter.getString("itemTitle"));

//				par.setValType(parameter.getString("valType"));
                par.setValType("String");
                par.setFullStatus(parameter.getString("fullStatus"));
                //par.setSizeScope(parameter.getString("dataLength"));
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
        if (serviceName.endsWith(" 服务")) {
            serviceName = serviceName.replace(" 服务", "");
        }
//		System.out.println(serviceName);
        //类名
        String className = toUpperCaseFirstOne(serviceNo.split("_").length > 2 ? serviceNo.split("_")[1] : serviceNo.split("_")[0]) + "ApiTest";
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
                .replace("\\" + claz.getName().split("\\.")[claz.getName().split("\\.").length - 1] + ".class", "\\" + packag.replace(".", "\\") + "\\" + className + ".java")
                .replace("/" + claz.getName().split("\\.")[claz.getName().split("\\.").length - 1] + ".class", "/" + packag.replace(".", "\\") + "/" + className + ".java");
        String packageName = "com.xjy.autotest." + packag.replace("/", ".");
        String projectName = packag.indexOf(".") == -1 ? packag : packag.substring(0, packag.indexOf("."));
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
            root.put("serviceNo", serviceNo.split("_").length > 2 ? serviceNo.split("_")[1] : serviceNo.split("_")[0]);
            root.put("time", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
            List<String> strs = new ArrayList<>();
            strs.add("merchOrderNo");
            strs.add("partnerId");
            strs.add("service");
            strs.add("version");
            strs.add("signType");
            strs.add("sign");
            strs.add("context");
            strs.add("returnUrl");
            strs.add("notifyUrl");
            ArrayList<String> lists = new ArrayList<>();
            for (ApiParameter p : pars) {
                if (null == p.getSecondCode()) {
                    p.setSecondCode(p.getItemCode());
                }
                if (p.getChildren() != null && p.getChildren().size() != 0 && !lists.contains(p.getSecondCode())) {
                    lists.add(p.getSecondCode());
                }
                if (strs.contains(p.getSecondCode())) {
                    p.setSecondCode(p.getSecondCode() + "1");
                    strs.add(p.getSecondCode());
                }
            }
            root.put("pars", pars);
            root.put("childlist", lists);
//			System.out.println(lists);
            Template template = cfg.getTemplate("GenerateXybApiCase.ftl");
            File f = new File(outFile);
            if (!f.exists()) {
                f.mkdirs();
            }
            if (new File(classFile).exists()) {
                log.error("测试用例已存在，{}", classFile);
                throw new Exception("测试用例已存在");
            }
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(classFile)));
            template.process(root, out);
            System.out.println("更新成功" + classFile);
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
                    mapName = apiParam.getSecondCode() + "_" + parameter.getString("itemCode");
                } else {
                    mapName = apiParam.getItemCode() + "_" + parameter.getString("itemCode");
                }
                if (!map.containsKey(parameter.getString("itemCode"))) {
                    mapName = parameter.getString("itemCode");
                }
                if (map.containsKey(mapName)) {
                    continue;
                }
                map.put(mapName, true);

                ApiParameter parchild = new ApiParameter();
                parchild.setItemCode(parameter.getString("itemCode"));
                parchild.setSecondCode(mapName);
                parchild.setItemTitle(parameter.getString("itemTitle"));
                // parchild.setValType(parameter.getString("valType"));
                parchild.setValType("String");
                parchild.setFullStatus(parameter.getString("fullStatus"));
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

package com.xjy.autotest.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjy.autotest.utils.ProcessObject;
import com.xjy.autotest.utils.StringUtils;
import com.xjy.common.util.CodeUtils;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.security.DigestUtil;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import service.PaySignature;
import service.PlatformPayException;

import javax.persistence.Column;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ychaoyang on 2017/7/20.
 */

public class AutoTestBase {

    protected final Logger logger = LoggerFactory.getLogger(AutoTestBase.class);

    protected RestTemplate restTemplate = new RestTemplate();

    public static final String ES_URL = "http://192.168.2.127:9200/_sql?sql=";


    /**
     * 暂停*秒
     *
     * @param time
     */
    protected static void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取用户加密密码
     *
     * @param userId   用户id
     * @param password 明文密码
     * @return
     */
    public static String getUserPassword(String userId, String password) {
        StringBuffer content = new StringBuffer();
        content.append(userId.substring(15, 20));
        content.append(password);
        content.append(userId.substring(10, 14));
        return DigestUtil.digestWithMD5(content.toString());
    }

    /**
     * MD5加密
     *
     * @param password
     * @return
     */
    protected String md5Digest(String password) {
        String securedpwd = null;
        try {
            securedpwd = CodeUtils.md5Digest(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return securedpwd;
    }

    /**
     * MD5加密
     *
     * @param map
     * @return
     */
    protected String md5ByMap(String key, Map<String, String> map) {
        String securedpwd = null;
        String content = formatUrlMap(map, false, false);
        print(content.replace("&", "") + key);
        try {
            securedpwd = CodeUtils.md5Digest(content.replace("&", "") + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return securedpwd;
    }

    /**
     * rsa公钥加密
     *
     * @param publicKey
     * @param map
     * @return
     */
    protected String rsaEncrypt(String publicKey, Map<String, String> map) {
        print(map);
        String content = formatUrlMap(map, false, false);
//        String content = PaySignature.getSignContent(map);
        String biz_content = "";
        try {
            biz_content = PaySignature.rsaEncrypt(content, publicKey, "UTF-8");
        } catch (PlatformPayException e) {
            e.printStackTrace();
        }
        return biz_content;
    }

    /**
     * rsa私钥签名
     */
    protected String rsaSign(String privateKey, String biz_content) {
        String sign = "";
        try {
            sign = PaySignature.rsaSign(biz_content, privateKey, "UTF-8");
        } catch (PlatformPayException e) {
            e.printStackTrace();
        }
        return sign;
    }

    protected void assertEquals(Object expected, Object actual) {
        Assertions.assertEquals(expected, actual);
    }

    protected void assertNotEquals(Object expected, Object actual) {
        Assertions.assertNotEquals(expected, actual);
    }

    protected void assertTrue(boolean condition) {
        Assertions.assertTrue(condition);
    }

    protected void assertFalse(boolean condition) {
        Assertions.assertFalse(condition);
    }

    protected void assertNull(Object actual) {
        Assertions.assertNull(actual);
    }

    protected void assertNotNull(Object actual) {
        Assertions.assertNotNull(actual);
    }

    protected void assertExecutedTrue(int testId, ResponseEntity<String> response) {
        print("执行到第[" + testId + "]条用例");
        print(response.toString());
        assertTrue(200 == response.getStatusCode().value());
        JSONObject responseObject = JSON.parseObject(response.getBody().toString());
        assertEquals("100", responseObject.getString("msgcode"));
    }

    protected void assertExecutedFalse(int testId, ResponseEntity<String> response) {
        print("执行到第[" + testId + "]条用例");
        print(response.toString());
        assertTrue(200 == response.getStatusCode().value());
        JSONObject responseObject = JSON.parseObject(response.getBody().toString());
        assertFalse("100".equals(responseObject.getString("msgcode")));
    }

    protected void assertResultTrue(int testId, StandardResultInfo result) {
        print("执行到第[" + testId + "]条用例");
        print(result);
        assertTrue(result != null);
        assertTrue(result.success());
    }

    protected void assertResultFalse(int testId, StandardResultInfo result) {
        print("执行到第[" + testId + "]条用例");
        print(result);
        assertTrue(result != null);
        assertTrue(result.fail());
    }

    protected void assertResultProcessing(int testId, StandardResultInfo result) {
        print("执行到第[" + testId + "]条用例");
        print(result);
        assertTrue(result != null);
        assertTrue(result.processing());
    }

    /**
     * @param result
     * @param status
     * @param code
     */
    protected void assertResult(int testId, Status status, String code, StandardResultInfo result) {
        print("执行到第[" + testId + "]条用例");
        print("执行到第[" + testId + "]条用例" + result);
//		logWriter("执行到第[" + testId + "]条用例" + result);
        assertTrue(result != null);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
    }

    protected void assertResultInfo(int testId, StandardResultInfo expectResult, StandardResultInfo result) {
        print("执行到第[" + testId + "]条用例");
        print(result);
        assertTrue(expectResult != null);
        assertTrue(result != null);
        assertEquals(expectResult.getStatus(), result.getStatus());
        assertEquals(expectResult.getCode(), result.getCode());
        if (StringUtils.isNotBlank(expectResult.getDescription())) {
            assertEquals(expectResult.getDescription(), result.getDescription());
        }
        if (StringUtils.isNotBlank(expectResult.getMessage())) {
            assertEquals(expectResult.getMessage(), result.getMessage());
        }
        assertEquals(expectResult, result);
    }

    /**
     * 首字母转小写
     *
     * @param s
     * @return
     */
    protected String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    protected String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 得到当前类的路径
     *
     * @param clazz
     * @return
     */
    protected String getClassFilePath(Class<?> clazz) {
        try {
            return java.net.URLDecoder.decode(getClassFile(clazz).getAbsolutePath(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 取得当前类所在的文件
     *
     * @param clazz
     * @return
     */
    protected File getClassFile(Class<?> clazz) {
        URL path = clazz.getResource(clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1) + ".classs");
        if (path == null) {
            String name = clazz.getName().replaceAll("[.]", "/");
            path = clazz.getResource("/" + name + ".class");
        }
        return new File(path.getFile());
    }

    protected void print(Object object) {
        String str = "";
        if (object instanceof List) {
            logger.info("========================================");
            List list = (List) object;
            logger.info("List size:" + list.size());
            for (int i = 0; i < list.size(); i++) {

                str = list.get(i).toString();
                logger.info(str);
            }
            logger.info("========================================");
            return;
        } else if (object == null) {

            str = "null";
        } else {
            str = object.toString();
        }

        logger.info("========================================");
        logger.info(str);
        logger.info("========================================");
    }

    /**
     * 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串<br>
     * 实现步骤: <br>
     *
     * @param paraMap    要排序的Map对象
     * @param urlEncode  是否需要URLENCODE
     * @param keyToLower 是否需要将Key转换为全小写
     *                   true:key转化成小写，false:不转化
     * @return
     */
    protected static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower) {
        String buff = "";
        Map<String, String> tmpMap = paraMap;
        try {
            List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });
            // 构造URL 键值对的格式
            StringBuilder buf = new StringBuilder();
            for (Map.Entry<String, String> item : infoIds) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    if (StringUtils.isNotBlank(item.getValue())) {
                        String key = item.getKey();
                        String val = item.getValue();
                        if (urlEncode) {
                            val = URLEncoder.encode(val, "utf-8");
                        }
                        if (keyToLower) {
                            buf.append(key.toLowerCase() + "=" + val);
                        } else {
                            buf.append(key + "=" + val);
                        }
                        buf.append("&");
                    }
                }
            }
            buff = buf.toString();
            if (buff.isEmpty() == false) {
                buff = buff.substring(0, buff.length() - 1);
            }
        } catch (Exception e) {
            return null;
        }
        return buff;
    }

    /**
     * 得到当前类的属性对应的数据库字段名
     *
     * @param cla
     * @return
     */
    protected static String getColumnName(Class cla, String fieldName) {
        String columnName = null;
        for (Field field : cla.getDeclaredFields()) {
            if (!field.getName().equals(fieldName)) {
                continue;
            }
            if (field.isAnnotationPresent(Column.class)) {
                columnName = field.getAnnotation(Column.class).name();
            } else {
                columnName = field.getName();
            }
        }
        return columnName;
    }

    /**
     * 根据json转化成对象
     *
     * @param json
     * @return
     */
    protected static Object jsonToObject(JSONObject json, Class<?> clz) {
        try {
            Object obj = clz.newInstance();

            String columnName = "";
            for (Field field : clz.getDeclaredFields()) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                if (field.isAnnotationPresent(Column.class)) {
                    columnName = field.getAnnotation(Column.class).name();
                } else {
                    columnName = field.getName();
                }

                if ("raw_update_time".equals(columnName)) {
                    continue;
                }
                String value = json.getString(columnName);
                if (StringUtils.isNotBlank(value) && Date.class.equals(field.getType())) {
                    value = value.replace("T"," ");
                }
                field.set(obj, ProcessObject.processing(field.getType(), value));
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据json转化成对象
     *
     * @param sql
     * @return
     */
    protected JSONObject getObjectFromES(String sql) {
        print(ES_URL + sql);
        ResponseEntity<String> response = restTemplate.exchange(ES_URL + sql, HttpMethod.GET, null, String.class);
        //结果验证
        JSONObject result = JSONObject.parseObject(response.getBody());
        JSONObject jsonObject = result.getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source");
        return jsonObject;

    }
}

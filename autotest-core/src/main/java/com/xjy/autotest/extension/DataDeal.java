package com.xjy.autotest.extension;

import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvWriter;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.ProcessObject;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.util.money.Money;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by ychaoyang on 2017/7/14.
 */
public class DataDeal {
    static {
        System.setProperty("xyb.appCode", "T11");
    }

    private static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create("AutoTestExtension",
            "DataDeal");

    protected static final Logger logger = LoggerFactory.getLogger(DataDeal.class);


    public static List<Object> getParams(ExtensionContext context, String file) {

        if (file.startsWith("/")) {
            file = file.substring(1);
        }
        Method m = context.getTestMethod().get();
        List<Parame> args = getVariables(context);

        String filePath = Thread.currentThread().getContextClassLoader().getResource("autotest/" + file).getPath();
        File fl = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fl));
            List<String> result = new ArrayList<>();
            String[] pars;
            int lineNo = 0;
            String[] header = null;
            String line = null;
            List<Object> obs = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                ++lineNo;
                if (lineNo == 1) {
                    header = splitContent(line);
                } else {
                    if (line.contains("~")) {
                        line = line.replace("~", "");
                    }
                    if (line.contains("～")) {
                        line = line.replace("～", "");
                    }
                    List<String> list = new ArrayList<>();
                    HashMap<String, Object> map = parseLine(header, line, lineNo);
                    obs.add(map);
                    for (int n = 0; n < args.size(); n++) {
                        String name = args.get(n).getName();
                        if (null != map.get(name)) {
                            String val = map.get(name).toString().trim();
                            list.add(val);
                        } else {
                            list.add("");
                        }
                    }
                    StringBuffer str = new StringBuffer();
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        str.append(iterator.next() + ",");
                    }
                    if (0 != str.length()) {
                        result.add(str.deleteCharAt(str.length() - 1).toString());
                    }
                }
            }
            int times = result.size();
            String methodName = context.getTestMethod().get().getName();
            context.getStore(NAMESPACE).put("methodName", methodName);
            context.getStore(NAMESPACE).put("times", times);
//			return result.toArray(new String[result.size()]);
            return obs;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //过滤json
    private static Pattern pattern = Pattern.compile("\"\\{\"\".*?\\}\"");
    //过滤数组
    private static Pattern pattern1 = Pattern.compile("\"\\[.*?\\]\"");
    //过滤字符串
    private static Pattern pattern2 = Pattern.compile("\".*?\"");

    public static String[] splitContent(String input) {
        //过滤所有的json字符串
        Matcher match = pattern.matcher(input);
        while (match.find()) {
            if (!StringUtils.isBlank(match.group())) {
                //throw new ParameterResolutionException("参数转换出错: " + match.group());
                String json1 = match.group();
                String fmt_json = json1.replace(",", "Δ")
                        .replace("\"\"", "\"");
                fmt_json = fmt_json.substring(1, fmt_json.length() - 1);
                input = replace(input, json1, fmt_json);
            }
        }
        //过滤数组
        Matcher match1 = pattern1.matcher(input);
        while (match1.find()) {
            if (!StringUtils.isBlank(match1.group())) {
                String arr = match1.group();
                String str2 = arr.replace(",", "Δ");
                if (!arr.equals(str2)) {
                    str2 = str2.replace("\"\"", "");
                    str2 = str2.substring(1, str2.length() - 1);
                }
                input = replace(input, arr, str2);
            }
        }
        //过滤字符串
        Matcher match2 = pattern2.matcher(input);
        while (match2.find()) {
            if (!StringUtils.isBlank(match2.group())) {
                String json3 = match2.group();
                String str3 = json3.replace(",", "Δ");
                if (!json3.equals(str3)) {
                    str3 = str3.substring(1, json3.length() - 1);
                }
                input = replace(input, json3, str3);
            }
        }
        ArrayList<String> result = new ArrayList();
        char character = 0;
        StringBuilder value = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {
            char previousCharacter = character;
            character = input.charAt(i);
            if (character != 44 && character != 124) {
                value.append(character);
            } else if (previousCharacter == 92) {
                value.setCharAt(value.length() - 1, character);
            } else {
                result.add(value.toString().trim());
                value = new StringBuilder();
            }
        }

        result.add(value.toString().trim());
        return (String[]) result.toArray(new String[0]);
    }

    public static String replace(String text, String repl, String with) {
        return replace(text, repl, with, -1);
    }

    public static String replace(String text, String repl, String with, int max) {
        if ((text == null) || (repl == null) || (with == null) || (repl.length() == 0)
                || (max == 0)) {
            return text;
        }

        StringBuffer buf = new StringBuffer(text.length());
        int start = 0;
        int end = 0;

        while ((end = text.indexOf(repl, start)) != -1) {
            buf.append(text.substring(start, end)).append(with);
            start = end + repl.length();

            if (--max == 0) {
                break;
            }
        }

        buf.append(text.substring(start));
        return buf.toString();
    }

    private static HashMap<String, Object> parseLine(String[] header, String line, int lineNo) {
        HashMap<String, Object> parMap = new HashMap<>();
        String[] params = splitContent(line);
        if (params.length != header.length) {
            throw new RuntimeException("数据文件:" + " 第" + lineNo + "行格式错误");
        } else {
            for (int i = 0; i < header.length; ++i) {
                parMap.put(header[i], StringUtils.isBlank(params[i]) ? null : params[i]);
            }

        }
        return parMap;
    }


    /**
     * 获取方法的参数
     *
     * @param context
     * @return
     */
    public static List<Parame> getVariables(ExtensionContext context) {
        List<Parame> list = new ArrayList<Parame>();
        Parameter[] parameters = context.getTestMethod().get().getParameters();
        LocalVariableTableParameterNameDiscoverer u =
                new LocalVariableTableParameterNameDiscoverer();
        String[] params = u.getParameterNames(context.getTestMethod().get());
        for (int i = 0; i < parameters.length; i++) {
            Parame p = new Parame();
            p.setName(params[i].trim());
            p.setType(parameters[i].getType());
            list.add(p);
        }

        return list;
    }

    public static void createCsvFile(List<Parame> list, String filePath) {
        File excelfile = new File(filePath);
        if (!excelfile.exists()) {
            try {
                String dir = filePath.substring(0, filePath.lastIndexOf("/"));
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                }
                List<String> strs = new ArrayList<>();
                CsvWriter cwriter = new CsvWriter(filePath);
                for (Iterator<Parame> it = list.iterator(); it.hasNext(); ) {
                    Parame p = (Parame) it.next();
                    Class clz = p.getType();
                    if (DataDeal.isJavaClass(clz) || clz.isEnum() || DataDeal.isProcessObject(clz)) {
                        if (!strs.contains(p.getName())) {
                            strs.add(p.getName());
                        }
                    } else {
                        strs = getFieldFromClass(clz, strs, p.getName());
                    }
                }
                for (String s : strs) {
                    cwriter.write(s, true);
                }
                cwriter.endRecord();
                for (String s : strs) {
                    String value ;
                    if ("testId".equals(s)) {
                        value = "1001";
                    } else if ("resultCode".equals(s)) {
                        value = "EXECUTE_SUCCESS";
                    } else if ("requestNo".equals(s)) {
                        value = "requestNo";
                    } else if ("protocol".equals(s)) {
                        value = "HTTP_FORM_JSON";
                    } else if ("version".equals(s)) {
                        value = "~1.0.0";
                    } else if ("partnerId".equals(s)) {
                        value = "";
                    } else if ("securityCheckCode".equals(s)) {
                        value = "";
                    } else if ("signType".equals(s)) {
                        value = "MD5";
                    } else if ("merchOrderNo".equals(s)) {
                        value = "OID";
                    } else if ("context".equals(s)) {
                        value = "context";
                    } else if ("notifyUrl".equals(s)) {
                        value = "http://rx.autotest.fun/api/receive.json";
                    } else if ("returnUrl".equals(s)) {
                        value = "http://rx.autotest.fun/api/receive.json";
                    } else if ("code".equals(s)) {
                        value = "~comn_00_0000";
                    } else if ("status".equals(s)) {
                        value = "SUCCESS";
                    } else {
                        value = "";
                    }
                    cwriter.write(value, true);
                }
                cwriter.flush();// 刷新数据
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.info("csv文件已存在!");
        }
    }

    public static Object mapToObject(Map<String, String> map, Class<?> clz, String name) throws Exception {
        if (map == null)
            return null;
        Object obj = clz.newInstance();
        List<Field> fields = new ArrayList<>();
        fields = getClassAllFields(clz, fields);
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            char ch = name.charAt(name.length() - 1);
            String str1 = field.getName() + ch + "_" + name.substring(0, name.length() - 1);
            String str2 = field.getName() + ch;
            String str3 = field.getName() + "_" + name;
            String str = null;
            if (Character.isDigit(ch)) {
                if (map.containsKey(str1)) {
                    str = map.get(str1);
                } else if (map.containsKey(str2)) {
                    str = map.get(str2);
                }
                if (StringUtils.isBlank(str)) {
                    continue;
                }
                if ("OID".equals(str)) {
                    str = OID.newID();
                }
                if ("GID".equals(str)) {
                    str = GID.newGID();
                }
                if ("TIME".equals(str) || "DATE".equals(str)) {
                    str = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
                }
                field.set(obj, ProcessObject.processing(field.getType(), str));
                continue;
            } else if (map.containsKey(str3)) {
                str = map.get(str3);
                if (StringUtils.isBlank(str)) {
                    continue;
                }
                if ("OID".equals(str)) {
                    str = OID.newID();
                }
                if ("GID".equals(str)) {
                    str = GID.newGID();
                }
                if ("TIME".equals(str) || "DATE".equals(str)) {
                    str = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
                }
                field.set(obj, ProcessObject.processing(field.getType(), str));
                continue;
            }
            str = map.get(field.getName());
            if (StringUtils.isBlank(str)) {
                continue;
            }
            if ("OID".equals(str)) {
                str = OID.newID();
            }
            if ("GID".equals(str)) {
                str = GID.newGID();
            }
            if ("TIME".equals(str)) {
                str = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
            }
            field.set(obj, ProcessObject.processing(field.getType(), str));
        }
        return obj;
    }

    public static List<String> getFieldFromClass(Class clz, List<String> strs, String name) {
        strs.add(name + "-->");
        List<Field> fields = new ArrayList<>();
        fields = getClassAllFields(clz, fields);
        for (Field field : fields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            char ch = name.charAt(name.length() - 1);
            String str1 = field.getName() + ch + "_" + name.substring(0, name.length() - 1);
            String str2 = field.getName() + ch;
            String str3 = field.getName() + "_" + name;
            if (!strs.contains(field.getName())) {
                strs.add(field.getName());
            } else if (Character.isDigit(ch)) {
                if (!strs.contains(str2)) {
                    strs.add(str2);
                } else if (!strs.contains(str1)) {
                    strs.add(str1);
                }
            } else if (!strs.contains(str3)) {
                strs.add(str3);
            }
        }
        return strs;
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param
     * @param
     * @return
     */
    public static List<Field> getClassAllFields(Class<?> clazz, List<Field> allGenericFields) {
        // 如果clazz为空则直接返回
        if (clazz == null) {
            return allGenericFields;
        }
        Object parent = clazz.getGenericSuperclass();
        // 如果有父类并且父类不是Object 则递归调用
        if (null != parent && !Object.class.equals(parent)) {
            if (parent instanceof Class) {
                getClassAllFields((Class<?>) parent, allGenericFields);
            }
            if (parent instanceof ParameterizedTypeImpl) {
                ParameterizedTypeImpl parameterizedType = (ParameterizedTypeImpl) parent;
                getClassAllFields(parameterizedType.getRawType(), allGenericFields);
            }
        }

        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            // 如果clazz存在声明的属性
            for (int i = 0; i < fields.length; i++)
                allGenericFields.add(fields[i]);
        }

        return allGenericFields;
    }

    public static boolean isJavaClass(Class<?> clz) {
        return clz != null && clz.getClassLoader() == null;
    }

    public static boolean isProcessObject(Class<?> clz) {
        boolean bool = false;
        if (clz == null) {
            return bool;
        }
        if (JSONObject.class.getName().equals(clz.getName())
                || Money.class.getName().equals(clz.getName())
        ) {
            return true;
        }
        return bool;
    }

    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}

package com.xjy.autotest.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import javassist.Modifier;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProcessObject {
    private static final Logger logger = Logger.getLogger(ProcessObject.class);

    public static Object processing(Class cl, String con) {
        Object o = null;
        String fieldType = cl.getName();
        try {
            if (String.class.getName().equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    return con;
                } else {
                    if ("OID".equals(con)) {
                        return OID.newID();
                    }
                    if ("GID".equals(con)) {
                        return GID.newGID();
                    }
                    return con.replace("Δ", ",");
                }
            } else if (Integer.class.getName().equals(fieldType) || "int".equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    if (Integer.class.getName().equals(fieldType)) {
                        return null;
                    }
                    con = "0";
                }
                o = Integer.parseInt(con);
                return o;
            } else if (Short.class.getName().equals(fieldType) || "short".equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    if (Short.class.getName().equals(fieldType)) {
                        return null;
                    }
                    con = "0";
                }
                o = Short.parseShort(con);
                return o;
            } else if (Character.class.getName().equals(fieldType) || "char".equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    if (Character.class.getName().equals(fieldType)) {
                        return null;
                    }
                    con = "0";
                }
                o = con.charAt(0);
                return o;
            } else if (Byte.class.getName().equals(fieldType) || "byte".equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    if (Byte.class.getName().equals(fieldType)) {
                        return null;
                    }
                    con = "0";
                }
                o = con.getBytes()[0];
                return o;
            } else if (Long.class.getName().equals(fieldType) || "long".equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    if (Long.class.getName().equals(fieldType)) {
                        return null;
                    }
                    con = "0";
                }
                o = Long.parseLong(con);
                return o;
            } else if (Double.class.getName().equals(fieldType) || "double".equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    if (Double.class.getName().equals(fieldType)) {
                        return null;
                    }
                    con = "0";
                }
                o = Double.parseDouble(con);
                return o;
            } else if (Boolean.class.getName().equals(fieldType) || "boolean".equals(fieldType)) {
                o = Boolean.parseBoolean(con);
                return o;
            } else if (Float.class.getName().equals(fieldType) || "float".equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    if (Float.class.getName().equals(fieldType)) {
                        return null;
                    }
                    con = "0";
                }
                o = Float.parseFloat(con);
                return o;
            } else if ((cl.getModifiers() & Modifier.ENUM) != 0) {
                if (StringUtils.isNotBlank(con)) {
                    o = Enum.valueOf(cl, con);
                }
                return o;
            } else if (ArrayList.class.getName().equals(fieldType) || List.class.getName().equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    return null;
                }
                String[] strs = con.substring(1, con.length() - 1)
                        .replace("[", "")
                        .replace("]", "")
                        .split("Δ");
                List<String> ls = new ArrayList<String>();
                for (String str : strs) {
                    ls.add(str);
                }
                o = ls;
                return o;
            } else if (Date.class.getName().equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    return null;
                }
                if ("TIME".equals(con) || "DATE".equals(con)) {
                    con = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
                }
                Date date = DateUtils.parseDate2(con);
                if (date != null) {
                    return date;
                }
                return new Class[0];
            } else if (BigDecimal.class.getName().equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    return null;
                }
                o = new BigDecimal(con);
                return o;
            } else if (com.xjy.common.util.Money.class.getName().equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    return null;
                }
                o = new com.xjy.common.util.Money(con);
                return o;
            } else if (com.xyb.adk.common.util.money.Money.class.getName().equals(fieldType)) {
                if (StringUtils.isBlank(con)) {
                    return null;
                }
                o = new com.xyb.adk.common.util.money.Money(con);
                return o;
            } else if (JSONObject.class.getName().equals(fieldType)) {
                return StringUtils.isBlank(con) ? con : JSON.parse(con.replace("Δ", ","));
            } else {
                o = StringUtils.isBlank(con) ? null : con;
            }
        } catch (RuntimeException e) {
            logger.error("参数类型:" + fieldType + " 不能转换,参数值为:" + con.replace("Δ", ","));
            throw e;
        }

        return o;
    }
}

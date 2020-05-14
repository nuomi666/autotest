package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-02-09
 * @Desc: 物业类型
 **/
public enum PropertyType {



    RESIDENCE("RESIDENCE","住宅"),

    BUSINESS("BUSINESS","商业"),

    INDUSTRY("INDUSTRY","工业"),

    ENTERPRISE("ENTERPRISE","事业单位"),

    BENEFIT("BENEFIT","公益性"),


    ;





    private String code;

    private String message;

    private PropertyType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static PropertyType getByCode(String code) {
        for (PropertyType result : values()) {
            if (result.code().equals(code)) {
                return result;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public static java.util.List<String> getAllEnumCode() {
        java.util.List<String> list = new java.util.ArrayList<String>(values().length);
        for (PropertyType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<PropertyType> getAllEnum() {
        java.util.List<PropertyType> list = new java.util.ArrayList<PropertyType>(values().length);
        for (PropertyType _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举描述
     *
     * @return List<ListType>
     */
    public static java.util.List<String> getAllEnumMessage() {
        java.util.List<String> list = new java.util.ArrayList<String>(values().length);
        for (PropertyType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

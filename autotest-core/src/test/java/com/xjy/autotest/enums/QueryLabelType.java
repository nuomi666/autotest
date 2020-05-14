package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-01-29
 * @Desc: 搜索标签枚举
 **/
public enum QueryLabelType {

    TITLE("TITLE","标题"),
    PREMISES("PREMISES","楼盘"),
    NUMBERID("NUMBERID","编号"),
    ADDRESS("ADDRESS","地址")
    ;

    private String code;

    private String message;

    private QueryLabelType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static QueryLabelType getByCode(String code) {
        for (QueryLabelType result : values()) {
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
        for (QueryLabelType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<QueryLabelType> getAllEnum() {
        java.util.List<QueryLabelType> list = new java.util.ArrayList<QueryLabelType>(values().length);
        for (QueryLabelType _enum : values()) {
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
        for (QueryLabelType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

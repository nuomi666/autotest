package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-01-29
 * @Desc: 特色标签枚举
 **/
public enum FeatureType {

    BOTIQUE("BOTIQUE","精品"),
    BARGAIN("BARGAIN","特价房"),
    SCHOOL("SCHOOL","学区"),
    NEED("NEED","刚需房"),
    INVEST("INVEST","投资"),
    DWELL("DWELL","自住"),
    FOROLD("FOROLD","养老"),
    DIRECT("DIRECT","拎包入住"),
    BOUTIQUE("BOUTIQUE","精装修"),
    LOW_PRICE("LOWPRICE","低价出租"),
    URGENCY("URGENCY","紧急出租"),
    FULL_SET("FULL_SET","全配"),
    CONVENIENCE("CONVENIENCE","交通便利")
    ;

    private String code;

    private String message;

    private FeatureType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static FeatureType getByCode(String code) {
        for (FeatureType result : values()) {
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
        for (FeatureType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<FeatureType> getAllEnum() {
        java.util.List<FeatureType> list = new java.util.ArrayList<FeatureType>(values().length);
        for (FeatureType _enum : values()) {
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
        for (FeatureType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

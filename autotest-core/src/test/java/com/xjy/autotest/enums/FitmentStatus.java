package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/22-14:31
 * @Desc: 装修情况
 **/
public enum FitmentStatus {

    ROUGHCAST("ROUGHCAST","毛坯"),

    GENERAL_DECORATION("GENERAL_DECORATION","普通装修"),

    MEDIUM_DECORATION("MEDIUM_DECORATION","中等装修"),

    FINE_DECORATION("FINE_DECORATION","精装修"),

    LUXURY_DECORATION("LUXURY_DECORATION","豪华装修")

    ;

    private String code;

    private String message;

    private FitmentStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static FitmentStatus getByCode(String code) {
        for (FitmentStatus result : values()) {
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
        for (FitmentStatus _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<FitmentStatus> getAllEnum() {
        java.util.List<FitmentStatus> list = new java.util.ArrayList<FitmentStatus>(values().length);
        for (FitmentStatus _enum : values()) {
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
        for (FitmentStatus _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/22-9:35
 * @Desc: 玛雅业务类型
 **/
public enum MayaBusinessType {

    SALE("SALE","出售"),

    RENT("RENT","出租"),

    BOTH("BOTH","租售")

    ;

    private String code;

    private String message;

    private MayaBusinessType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static MayaBusinessType getByCode(String code) {
        for (MayaBusinessType result : values()) {
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
        for (MayaBusinessType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<MayaBusinessType> getAllEnum() {
        java.util.List<MayaBusinessType> list = new java.util.ArrayList<MayaBusinessType>(values().length);
        for (MayaBusinessType _enum : values()) {
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
        for (MayaBusinessType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

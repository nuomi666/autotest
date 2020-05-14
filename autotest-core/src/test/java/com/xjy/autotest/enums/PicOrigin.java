package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-02-2018/2/7-9:40
 * @Desc:
 **/
public enum PicOrigin {

    HOUSING_SOURCE("HOUSING_SOURCE","房源"),

    PREMISES("PREMISES","楼盘")

    ;

    private String code;

    private String message;

    private PicOrigin(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static PicOrigin getByCode(String code) {
        for (PicOrigin result : values()) {
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
        for (PicOrigin _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<PicOrigin> getAllEnum() {
        java.util.List<PicOrigin> list = new java.util.ArrayList<PicOrigin>(values().length);
        for (PicOrigin _enum : values()) {
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
        for (PicOrigin _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

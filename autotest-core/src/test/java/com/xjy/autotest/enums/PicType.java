package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/22-11:42
 * @Desc:
 **/
public enum PicType {



    TITLE_PIC("TITLE_PIC","标题图片"),

    MAIN_REST("MAIN_REST","主卧"),

    MINOR_REST("MINOR_REST","次卧"),

    MAIN_WASH("MAIN_WASH","主卫"),


    ;



    ;

    private String code;

    private String message;

    private PicType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static PicType getByCode(String code) {
        for (PicType result : values()) {
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
        for (PicType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<PicType> getAllEnum() {
        java.util.List<PicType> list = new java.util.ArrayList<PicType>(values().length);
        for (PicType _enum : values()) {
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
        for (PicType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

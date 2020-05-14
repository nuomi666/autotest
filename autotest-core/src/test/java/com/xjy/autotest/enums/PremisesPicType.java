package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-02-11
 * @Desc: 楼盘图片类型
 **/
public enum PremisesPicType {



    TITLE_PIC("TITLE_PIC","主图"),

    MIDDLE("MIDDLE","中庭")

    ;

    private String code;

    private String message;

    private PremisesPicType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static PremisesPicType getByCode(String code) {
        for (PremisesPicType result : values()) {
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
        for (PremisesPicType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<PremisesPicType> getAllEnum() {
        java.util.List<PremisesPicType> list = new java.util.ArrayList<PremisesPicType>(values().length);
        for (PremisesPicType _enum : values()) {
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
        for (PremisesPicType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-02-11
 * @Desc: 楼盘类型
 **/
public enum PremisesType {
    MUCHFLOOR("MUCHFLOOR","多层"),
    ALONE("ALONE","独栋"),
    DOUBLE("DOUBLE","双拼"),
    UNIONS("UNIONS","联排"),
    LITTLE_HIGH("LITTLE_HIGH","小高层"),
    OTHER("OTHER","其他")

    ;

    private String code;

    private String message;

    private PremisesType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static PremisesType getByCode(String code) {
        for (PremisesType result : values()) {
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
        for (PremisesType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<PremisesType> getAllEnum() {
        java.util.List<PremisesType> list = new java.util.ArrayList<PremisesType>(values().length);
        for (PremisesType _enum : values()) {
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
        for (PremisesType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

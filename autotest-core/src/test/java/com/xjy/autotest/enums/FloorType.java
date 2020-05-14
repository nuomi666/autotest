package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/22-14:40
 * @Desc:
 **/
public enum FloorType {

    LOW("LOW","底层"),

    MIDDLE_LOW("MIDDLE_LOW","中低层"),

    MIDDLE_HIGH("MIDDLE_HIGH","中高层"),

    TOP("TOP","顶层")

    ;

    private String code;

    private String message;

    private FloorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static FloorType getByCode(String code) {
        for (FloorType result : values()) {
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
        for (FloorType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<FloorType> getAllEnum() {
        java.util.List<FloorType> list = new java.util.ArrayList<FloorType>(values().length);
        for (FloorType _enum : values()) {
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
        for (FloorType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/22-14:50
 * @Desc:
 **/
public enum OrientationType {

    FORWARD_EAST("FORWARD_EAST","朝东"),

    FORWARD_WEST("FORWARD_WEST","朝西"),

    FORWARD_NORTH("FORWARD_NORTH","朝北"),

    FORWARD_SOUTH("FORWARD_SOUTH","朝南"),

    SOUTH_NORTH_TRANSPARENT("SOUTH_NORTH_TRANSPARENT","南北通透"),

    EAST_WEST("EAST_WEST","东西")

    ;

    private String code;

    private String message;

    private OrientationType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static OrientationType getByCode(String code) {
        for (OrientationType result : values()) {
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
        for (OrientationType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<OrientationType> getAllEnum() {
        java.util.List<OrientationType> list = new java.util.ArrayList<OrientationType>(values().length);
        for (OrientationType _enum : values()) {
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
        for (OrientationType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

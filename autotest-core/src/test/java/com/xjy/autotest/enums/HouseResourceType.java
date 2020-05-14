package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/22-11:46
 * @Desc: 房源类型
 **/
public enum HouseResourceType {

    RESIDENCE("RESIDENCE","住宅"),

    APARTMENT("APARTMENT","公寓"),

    VILLA("VILLA","别墅"),

    GARDEN_HOUSE("GARDEN_HOUSE","花园洋房")

    ;

    private String code;

    private String message;

    private HouseResourceType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static HouseResourceType getByCode(String code) {
        for (HouseResourceType result : values()) {
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
        for (HouseResourceType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<HouseResourceType> getAllEnum() {
        java.util.List<HouseResourceType> list = new java.util.ArrayList<HouseResourceType>(values().length);
        for (HouseResourceType _enum : values()) {
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
        for (HouseResourceType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

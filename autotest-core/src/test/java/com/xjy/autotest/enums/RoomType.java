package com.xjy.autotest.enums;

/**
 * @Author: xiongmao
 * @Date: 2018-01-30
 * @Desc: 房间类型
 **/
public enum RoomType {

    MAIN_REST("MAIN_REST","主卧"),

    MINOR_REST("MINOR_REST","次卧"),

    MAIN_WASH("MAIN_WASH","主卫")

    ;

    private String code;

    private String message;

    private RoomType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static RoomType getByCode(String code) {
        for (RoomType result : values()) {
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
        for (RoomType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<RoomType> getAllEnum() {
        java.util.List<RoomType> list = new java.util.ArrayList<RoomType>(values().length);
        for (RoomType _enum : values()) {
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
        for (RoomType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

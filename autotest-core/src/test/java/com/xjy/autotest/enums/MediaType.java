package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/29-10:10
 * @Desc:
 **/
public enum MediaType {

    PANORAMA("PANORAMA","全景图"),

    SCENE_GRAPH("SCENE_GRAPH","场景图"),

    MV("MV","视频")

    ;

    private String code;

    private String message;

    private MediaType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static MediaType getByCode(String code) {
        for (MediaType result : values()) {
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
        for (MediaType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<MediaType> getAllEnum() {
        java.util.List<MediaType> list = new java.util.ArrayList<MediaType>(values().length);
        for (MediaType _enum : values()) {
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
        for (MediaType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

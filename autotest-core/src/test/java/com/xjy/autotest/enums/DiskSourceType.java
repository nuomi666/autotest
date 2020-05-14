package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/23-10:17
 * @Desc:
 **/
public enum DiskSourceType {

    PUBLIC_DISK("PUBLIC_DISK","公盘"),

    PRIVATE_DISK("PRIVATE_DISK","私盘")

    ;

    private String code;

    private String message;

    private DiskSourceType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static DiskSourceType getByCode(String code) {
        for (DiskSourceType result : values()) {
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
        for (DiskSourceType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<DiskSourceType> getAllEnum() {
        java.util.List<DiskSourceType> list = new java.util.ArrayList<DiskSourceType>(values().length);
        for (DiskSourceType _enum : values()) {
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
        for (DiskSourceType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

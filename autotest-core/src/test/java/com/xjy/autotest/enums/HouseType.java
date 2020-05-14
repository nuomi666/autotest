package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-02-2018/2/2-15:41
 * @Desc:
 **/
public enum HouseType {

    ONE_TO_ONE("ONE_TO_ONE","一室一厅"),
    ONE_TO_TWO("ONE_TO_TWO","一室二厅"),
    TWO_TO_ONE("TWO_TO_ONE","二室一厅"),
    TWO_TO_TWO("TWO_TO_TWO", "二室二厅"),
    THREE_TO_ONE("THREE_TO_ONE","三室一厅"),
    THREE_TO_TWO("THREE_TO_TWO","三室二厅"),
    FOUR_TO_TWO("FOUR_TO_TWO","四室二厅"),
    FIVE_UP("FIVE_UP","五室及以上");

    ;

    private String code;

    private String message;

    private HouseType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static HouseType getByCode(String code) {
        for (HouseType result : values()) {
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
        for (HouseType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<HouseType> getAllEnum() {
        java.util.List<HouseType> list = new java.util.ArrayList<HouseType>(values().length);
        for (HouseType _enum : values()) {
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
        for (HouseType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

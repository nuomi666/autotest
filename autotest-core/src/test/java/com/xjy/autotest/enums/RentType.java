package com.xjy.autotest.enums;

/**
 * @Author: Jax
 * @Date: 2018-01-2018/1/22-11:20
 * @Desc:
 **/
public enum RentType {


    ONE_DEPOSIT_AND_THREE_PAY("ONE_DEPOSIT_AND_THREE_PAY","押一付三")


    ;

    private String code;

    private String message;

    private RentType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

    public static RentType getByCode(String code) {
        for (RentType result : values()) {
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
        for (RentType _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 获取全部枚举
     *
     * @return List<ListType>
     */
    public static java.util.List<RentType> getAllEnum() {
        java.util.List<RentType> list = new java.util.ArrayList<RentType>(values().length);
        for (RentType _enum : values()) {
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
        for (RentType _enum : values()) {
            list.add(_enum.message);
        }
        return list;
    }

}

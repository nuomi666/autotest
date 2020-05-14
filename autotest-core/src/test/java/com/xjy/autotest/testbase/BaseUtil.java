package com.xjy.autotest.testbase;

import com.xyb.adk.common.util.security.DigestUtil;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author nuomi@xinyebang.com
 * @date 2018/11/6
 */
public class BaseUtil {
    /**
     * 随机产生指定位数的数字
     *
     * @param num
     * @return
     */
    public static String generateNo(int num) {
        String randomNo = "";
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            randomNo += random.nextInt(10);
        }
        return randomNo;
    }

    /**
     * 对密码进行MD5加密（加好油商户）
     *
     * @param password
     * @param slat
     * @return
     */
    public static String encrypt(String password, String slat) {
        if (StringUtils.isEmpty(slat)) {
            return DigestUtil.digestWithMD5(password);
        }
        return DigestUtil.digestWithMD5(password + slat.substring(2));
    }

    /**
     * 对密码进行MD5加密（清结算会员）
     *
     * @param userId
     * @param password
     * @return
     */
    public static String getPwdEnum(String userId, String password) {
        if (StringUtils.isEmpty(userId)) {
            userId = "S0301808271500000069";
        }
        if (StringUtils.isEmpty(password)) {
            password = "123456";
        }
        StringBuffer content = new StringBuffer();
        content.append(userId.substring(15, 20));
        content.append(password);
        content.append(userId.substring(10, 14));
        return DigestUtil.digestWithMD5(content.toString());
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static String div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }
}

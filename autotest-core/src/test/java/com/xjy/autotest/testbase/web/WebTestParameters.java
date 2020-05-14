package com.xjy.autotest.testbase.web;

import com.xjy.autotest.base.SpringBootTestBase;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by ychaoyang on 2017/9/6.
 */
public class WebTestParameters extends SpringBootTestBase {

    @Value("${test.url.boss}")
    protected String testUrlBoss;

    @Value("${test.url.gas}")
    protected String testUrlGas;

    public static final String USER_NAME_JHY = "test233";

    public static final String PASS_WORD_JHY = "123456";


}

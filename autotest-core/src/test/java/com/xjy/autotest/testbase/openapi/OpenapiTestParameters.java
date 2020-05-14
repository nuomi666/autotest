package com.xjy.autotest.testbase.openapi;

import com.xjy.autotest.base.SpringBootTestBase;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by yu on 2017/9/28.
 */
public class OpenapiTestParameters extends SpringBootTestBase {

    @Value("${test.url.openapi}")
    protected String openapiTestUrl;

    @Value("${test.partner.id}")
    protected  String pId ;
    
    @Value("${test.partner.key}")
    protected  String secretKey ;


    protected static final String NOTIFY_URL = "http://rx.autotest.fun/api/receive.json";

}

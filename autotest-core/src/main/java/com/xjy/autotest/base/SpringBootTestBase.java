package com.xjy.autotest.base;

import com.xjy.autotest.Main;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huairen
 * Created on 18/3/8.
 */
@SpringBootTest(
        classes = Main.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class SpringBootTestBase extends AutoTestBase {

    static {
        System.setProperty("xyb.appCode", "T11");
        System.setProperty("server.port", "9005");
    }

    public static final String DUBBO_VERSION = "1.0.0";

    public static final String DUBBO_VERSION_1 = "1.0";

    public static final String REDIS_PREFIX = "gas-user:";

    public static final String QUERY_NOTIFY_URL = "http://192.168.2.227:9006/query";

}

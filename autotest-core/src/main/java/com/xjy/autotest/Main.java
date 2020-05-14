package com.xjy.autotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * 因springboot启动时会加载很多不需要的bean,造成启动时间过长
 * 调试时可按如下调整：
 * 一、先注释掉Main类上的注解@SpringBootApplication
 * 二、在Main类上加上注解@Configuration以及注解@Import({
 * <p>
 * DubboAutoConfiguration.class,
 * })
 * 三、在@Import注解中按需添加相应的TestBase类
 * 四、TestBase类需要重新生成一次
 * 五、该配置不要push到服务器上，谢谢
 */
//@Configuration
//@Import({
//        DubboAutoConfiguration.class,
////        UserTestBase.class,
//        RedisAutoConfiguration.class,
//        //PayTestBase.class,
//        //PromotionTestBase.class,
//        //CashierTestBase.class,
//        //ClearTestBase.class,
////        MerchantTestBase.class,
////        Gas_userTestBase.class,
////        Gas_silverboltTestBase.class,
////        Gas_marketpcTestBase.class,
////        GasMerchantInitDataBase.class,
////        GasUserInitDataBase.class,
//        Gas_merchantTestBase.class,
//})
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);
    }
}

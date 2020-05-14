package com.xjy.autotest.boss.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author ychaoyang
 * Created on 18/9/11.
 */
public class MobileWebTest {

    @BeforeAll
    static void init() {
        System.setProperty("webdriver.chrome.driver", Thread.currentThread().getContextClassLoader()
                .getResource("webdriver/" + "chromedriver").getPath());
        //去掉浏览器驱动提示
        System.setProperty("chromeoptions.args", "disable-infobars");

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPad");
        // 配置ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);

        //设置页面超时时间
        Configuration.timeout = 6000;
        //错误页面截图
        Configuration.screenshots = false;
    }

    @AfterEach
    void tearDown() {
        close();
    }

    @Test
    void test(){
        open("https://m.zhihu.com");
        sleep(3000);
    }


}

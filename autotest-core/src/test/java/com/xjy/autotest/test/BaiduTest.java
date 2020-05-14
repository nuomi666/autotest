package com.xjy.autotest.test;

import com.xjy.autotest.testbase.web.WebTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by ychaoyang on 2017/8/7.
 */
public class BaiduTest extends WebTestBase {

    @Test
    @DisplayName("测试百度搜索页面测试")
   public void baiduTest() {
        //打开chrome浏览器
        //open("http://www.baidu.com");
        //        //$(By.id("kw")).setValue("junit");
        //        //$(By.id("su")).click();
        //        //print(title());
        //        //sleep(2);
    }


}


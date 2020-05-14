package com.xjy.autotest.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;

/**
 * @author huairen
 * Created on 18/3/7.
 */
public class SelenideTest {

	@Test
	public void searchTest() {
		System.setProperty("webdriver.chrome.driver", Thread.currentThread().getContextClassLoader()
				.getResource("webdriver/" + "chromedriver.exe").getPath());
		Configuration.browser = "chrome";
		//open("http://baidu.com");
		//$(By.id("kw")).setValue("selenide");
		//$(By.id("su")).click();
		//$(By.className("op_dict_text2")).shouldHave(text("硒化物"));
		//System.out.println($(By.className("op_dict_text2")).text());
		System.out.println(title());
		System.out.println();
	}

}

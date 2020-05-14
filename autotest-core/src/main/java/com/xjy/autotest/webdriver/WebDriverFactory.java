package com.xjy.autotest.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by ychaoyang on 2017/8/21.
 */
public class WebDriverFactory {

    private static WebDriver driver;
    private static ThreadLocal<WebDriver> ThreadDriver = new ThreadLocal<WebDriver>();


    public static WebDriver getDriver() {
        driver = ThreadDriver.get();
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", Thread.currentThread().getContextClassLoader()
                    .getResource("webdriver/" + "chromedriver.exe").getPath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            //chrome不打开浏览器执行用例
//            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            ThreadDriver.set(driver);
        }
        return driver;
    }

    /**
     * quit the driver
     */
    public static void quit() {
        //关闭浏览器
        try {
            if (driver != null)
                driver.quit();
            WebDriverFactory.ThreadDriver.set(null);
        } finally {
            driver = null;
        }
    }

}


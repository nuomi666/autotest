package com.xjy.autotest.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by ychaoyang on 2017/8/21.
 */
public class BasePage {
    protected final Logger logger = LoggerFactory.getLogger(BasePage.class);

    protected WebDriver driver;

    public BasePage() {
        driver = WebDriverFactory.getDriver();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    protected void getUrl(String url) {
        driver.get(url);
    }

    /**
     * 键入内容
     *
     * @param webElement
     * @param text
     */
    protected void sendKeys(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * 点击元素，当not clickable时暂停2秒再点击
     *
     * @param webElement
     */
    protected void click(WebElement webElement) {
        int num = 0;
        while (num < 5) {
            try {
                webElement.click();
            } catch (Exception e) {
                sleep(1);
                num++;
            }
            num = 5;
        }
    }

    /**
     * 暂停* 秒
     *
     * @param time
     */
    protected void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从一个table的单元格中得到文本值
     *
     * @param webElement       用于得到table对象
     * @param tableCellAddress 的格式为row.column, 行列从0开始.
     * @param tableCellAddress 一个单元格地址, 如. "1.4"
     * @return 从一个table的单元格中得到文本值
     */
    public String getCellText(WebElement webElement, String tableCellAddress) {
        //得到table元素对象
        WebElement table = webElement;
        //得到其对应行、列。
        int index = tableCellAddress.trim().indexOf('.');//返回"."所在位置的索引值
        int row = Integer.parseInt(tableCellAddress.substring(0, index));
        int cell = Integer.parseInt(tableCellAddress.substring(index + 1));
        //得到table表中所有行对象，并得到所要查询的行对象。
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement theRow = rows.get(row);
        //调用getCell方法得到对应的列对象，然后得到要查询的文本。
        String text = getCell(theRow, cell).getText();
        logger.info("找到文本，其内容为：" + text);
        return text;
    }

    private static WebElement getCell(WebElement Row, int cell) {
        WebElement target = null;
        //列里面"<th>"、"<td>"两种标签分开处理
        List<WebElement> cellsTd = Row.findElements(By.tagName("td"));
        if (cellsTd.size() > 0) {
            target = cellsTd.get(cell);
            return target;
        }
        List<WebElement> cellsTh = Row.findElements(By.tagName("th"));
        if (cellsTh.size() > 0) {
            target = cellsTh.get(cell);
        }
        return target;
    }
}
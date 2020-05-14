package com.xjy.autotest.gas.pages.order;

import com.codeborne.selenide.SelenideElement;
import com.xjy.autotest.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author ychaoyang
 * Created on 2020-2-18.
 */
public class PaymentOrderPage extends OrderCenterPage {

    /**
     * 通过条件搜索消费/充值订单
     *
     * @param bizNo
     * @param stationCode
     * @param stationName
     * @param mobile
     * @param carNumber
     * @param finishTime   2020年2月12日
     * @param tradePayType
     * @param status
     * @return
     */
    public DepositOrderPage searchOrder(
            String bizNo,
            String stationCode,
            String stationName,
            String mobile,
            String carNumber,
            String finishTime,
            String finishTime1,
            String tradePayType,
            String status
    ) {
        if (StringUtils.isNotBlank(bizNo)) {
            $("#bizNo").setValue(bizNo);
        }
        if (StringUtils.isNotBlank(stationCode)) {
            $("#stationCode").setValue(stationCode);
        }
        if (StringUtils.isNotBlank(stationName)) {
            $("#stationName").setValue(stationName);
        }
        if (StringUtils.isNotBlank(mobile)) {
            $("#mobile").setValue(mobile);
        }
        if (StringUtils.isNotBlank(carNumber)) {
            $("#carNumber").setValue(carNumber);
        }
        if (StringUtils.isNotBlank(finishTime)) {
            $("#finishTime").click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-date").click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-start-date.ant-calendar-selected-date.ant-calendar-selected-day").click();
            while (StringUtils.isNotBlank($("input[placeholder=\"开始时间\"", 1).val())) {
                $("input[placeholder=\"开始时间\"", 1).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"开始时间\"", 1).val(finishTime);
            while (StringUtils.isNotBlank($("input[placeholder=\"结束时间\"", 1).val())) {
                $("input[placeholder=\"结束时间\"", 1).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"结束时间\"", 1).val(finishTime1);
            $(".ant-calendar-ok-btn").click();
        }
        if (StringUtils.isNotBlank(tradePayType)) {
            $("#tradePayType").click();
            $$(byText(tradePayType)).last().click();
        }
        if (StringUtils.isNotBlank(status)) {
            $("#status").click();
            $$(byText(status)).last().click();
        }
        //第2个button按钮是搜索
        $("button[type=\"button\"]", 1).click();
        return new DepositOrderPage();
    }

    /**
     * 通过条件查询消费退款订单
     *
     * @param tradeNo
     * @param bizNo
     * @param stationCode
     * @param stationName
     * @param mobile
     * @param carNumber
     * @param finishTime
     * @param finishTime1
     * @param tradePayType
     * @param status
     * @return
     */
    public PaymentOrderPage searchPaymentRefundOrder(
            String tradeNo,
            String bizNo,
            String stationCode,
            String stationName,
            String mobile,
            String carNumber,
            String finishTime,
            String finishTime1,
            String tradePayType,
            String status
    ) {
        if (StringUtils.isNotBlank(tradeNo)) {
            $("#tradeNo").setValue(tradeNo);
        }
        //#bizNo在消费订单页面有相同的元素，选择第二个元素，下同
        if (StringUtils.isNotBlank(bizNo)) {
            $("#bizNo", 1).setValue(bizNo);
        }
        if (StringUtils.isNotBlank(stationCode)) {
            $("#stationCode", 1).setValue(stationCode);
        }
        if (StringUtils.isNotBlank(stationName)) {
            $("#stationName", 1).setValue(stationName);
        }
        if (StringUtils.isNotBlank(mobile)) {
            $("#mobile", 1).setValue(mobile);
        }
        if (StringUtils.isNotBlank(carNumber)) {
            $("#carNumber", 1).setValue(carNumber);
        }
        if (StringUtils.isNotBlank(finishTime)) {
            $("#finishTime", 1).click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-date").click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-start-date.ant-calendar-selected-date.ant-calendar-selected-day").click();
            while (StringUtils.isNotBlank($("input[placeholder=\"开始时间\"", 2).val())) {
                $("input[placeholder=\"开始时间\"", 2).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"开始时间\"", 2).val(finishTime);
            while (StringUtils.isNotBlank($("input[placeholder=\"结束时间\"", 2).val())) {
                $("input[placeholder=\"结束时间\"", 2).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"结束时间\"", 2).val(finishTime1);
            $(".ant-calendar-ok-btn").click();
        }
        if (StringUtils.isNotBlank(tradePayType)) {
            $("#tradePayType", 1).click();
            $$(byText(tradePayType)).last().click();
        }
        if (StringUtils.isNotBlank(status)) {
            $("#status", 1).click();
            $$(byText(status)).last().click();
        }
        //第4个button按钮是搜索
        $("button[type=\"button\"]", 3).click();
        return this;
    }

    /**
     * 检查消费订单明细
     *
     * @param bizNo
     * @param stationCode
     * @param stationName
     * @param mobile
     * @param carNumber
     * @param finishTime
     * @param tradePayType
     * @param status
     */
    public void checkOrderData(
            String bizNo,
            String stationCode,
            String stationName,
            String mobile,
            String carNumber,
            String finishTime,
            String tradePayType,
            String status
    ) {
        if (StringUtils.isNotBlank(bizNo)) {
            getDataCell(1, 1).shouldHave(text(bizNo));
        }
        if (StringUtils.isNotBlank(stationCode)) {
            getDataCell(1, 2).shouldHave(text(stationCode));
        }
        if (StringUtils.isNotBlank(stationName)) {
            getDataCell(1, 3).shouldHave(text(stationName));
        }
        if (StringUtils.isNotBlank(mobile)) {
            getDataCell(1, 11).shouldHave(text(mobile));
        }
        if (StringUtils.isNotBlank(carNumber)) {
            getDataCell(1, 12).shouldHave(text(carNumber));
        }
        //getDataCell(1, 13).shouldHave(text(finishTime));
        if (StringUtils.isNotBlank(tradePayType)) {
            getDataCell(1, 14).shouldHave(text(tradePayType));
        }
        if (StringUtils.isNotBlank(status)) {
            getDataCell(1, 15).shouldHave(text(status));
        }
    }

    /**
     * 检查退款订单数据
     *
     * @param bizNo
     * @param tradeNo
     * @param stationCode
     * @param stationName
     * @param mobile
     * @param carNumber
     * @param finishTime
     * @param tradePayType
     * @param status
     */
    public void checkRefundOrderData(
            String bizNo,
            String tradeNo,
            String stationCode,
            String stationName,
            String mobile,
            String carNumber,
            String finishTime,
            String tradePayType,
            String status
    ) {
        if (StringUtils.isNotBlank(bizNo)) {
            getCell(1, 1).shouldHave(text(bizNo));
        }
        if (StringUtils.isNotBlank(tradeNo)) {
            getCell(1, 2).shouldHave(text(tradeNo));
        }
        if (StringUtils.isNotBlank(stationCode)) {
            getCell(1, 3).shouldHave(text(stationCode));
        }
        if (StringUtils.isNotBlank(stationName)) {
            getCell(1, 4).shouldHave(text(stationName));
        }
        if (StringUtils.isNotBlank(mobile)) {
            getCell(1, 6).shouldHave(text(mobile));
        }
        if (StringUtils.isNotBlank(carNumber)) {
            getCell(1, 7).shouldHave(text(carNumber));
        }
        //getDataCell(1, 13).shouldHave(text(finishTime));
        if (StringUtils.isNotBlank(tradePayType)) {
            getCell(1, 10).shouldHave(text(tradePayType));
        }
        if (StringUtils.isNotBlank(status)) {
            getCell(1, 11).shouldHave(text(status));
        }
    }

    public SelenideElement getCell(int tr, int td) {
        return $("table.ant-table-fixed",2).$("tbody.ant-table-tbody > tr:nth-child(" + tr + ") > td:nth-child(" + td + ")");
    }


}

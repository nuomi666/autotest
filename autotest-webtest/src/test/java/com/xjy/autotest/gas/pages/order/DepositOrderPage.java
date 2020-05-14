package com.xjy.autotest.gas.pages.order;

import com.xjy.autotest.utils.StringUtils;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * @author ychaoyang
 * Created on 2020-2-19.
 */
public class DepositOrderPage extends PaymentOrderPage {

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
    public void checkDepositOrder(
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
            getDataCell(1, 8).shouldHave(text(mobile));
        }
        if (StringUtils.isNotBlank(carNumber)) {
            getDataCell(1, 9).shouldHave(text(carNumber));
        }
        //getDataCell(1, 11).shouldHave(text(finishTime));
        if (StringUtils.isNotBlank(tradePayType)) {
            getDataCell(1, 12).shouldHave(text(tradePayType));
        }
        if (StringUtils.isNotBlank(status)) {
            getDataCell(1, 13).shouldHave(text(status));
        }
    }

    /**
     * 通过条件查询消费退款订单
     *
     * @param depositNo
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
    public DepositOrderPage searchDepositRefundOrder(
            String depositNo,
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
        if (StringUtils.isNotBlank(depositNo)) {
            $("#depositNo").setValue(depositNo);
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
     * 检查充退订单数据
     *
     * @param bizNo
     * @param depositNo
     * @param stationCode
     * @param stationName
     * @param mobile
     * @param carNumber
     * @param finishTime
     * @param tradePayType
     * @param status
     */
    public void checkDepositRefundOrder(
            String bizNo,
            String depositNo,
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
        if (StringUtils.isNotBlank(depositNo)) {
            getCell(1, 2).shouldHave(text(depositNo));
        }
        if (StringUtils.isNotBlank(stationCode)) {
            getCell(1, 3).shouldHave(text(stationCode));
        }
        if (StringUtils.isNotBlank(stationName)) {
            getCell(1, 4).shouldHave(text(stationName));
        }
        if (StringUtils.isNotBlank(mobile)) {
            getCell(1, 7).shouldHave(text(mobile));
        }
        if (StringUtils.isNotBlank(carNumber)) {
            getCell(1, 8).shouldHave(text(carNumber));
        }
        //getDataCell(1, 13).shouldHave(text(finishTime));
        if (StringUtils.isNotBlank(tradePayType)) {
            getCell(1, 11).shouldHave(text(tradePayType));
        }
        if (StringUtils.isNotBlank(status)) {
            getCell(1, 12).shouldHave(text(status));
        }
    }

}

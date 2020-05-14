package com.xjy.autotest.gas.test.report;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.order.DepositOrderPage;
import com.xjy.autotest.gas.pages.report.ClassReportPage;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.dao.gas_silverbolt.GasTradeOilMapper;
import dal.dao.gas_silverbolt.GasTradeOrderMapper;
import dal.model.gas_silverbolt.GasTradeOrderDO;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2020-03-02.
 */
public class ClassReportSearchWebTest extends WebTestBase {

    @Autowired
    GasTradeOrderMapper gasTradeOrderMapper;

    @Autowired
    GasTradeOilMapper gasTradeOilMapper;

    @AutoTest(file = "gas/classReportSearchWebTestSuccess.csv")
    @DisplayName("班结报表查询--成功用例")
    public void classReportSearchWebTestSuccess(
            int testId,
            int tr,
            String partnerId,
            String operateName,
            String payType,
            String refundType,
            String beginTime,
            String finishTime,
            String stationName,
            String oils,
            String counts,
            Double amounts,
            Double refunds,
            Double favourAmounts,
            Double settleAmounts
    ) {
        //打开加好油中台页面
        open(testUrlGas);
        //打开班结报表页面
        ClassReportPage classReportPage = new GasLoginPage()
                .login(USER_NAME_JHY, PASS_WORD_JHY)
                .reportCenter()
                .classReport()
                .searchClassReport(operateName);
        //查询第tr行上班时间
        beginTime = classReportPage.findBeginTime(tr);
        //查询第tr行下班时间
        finishTime = classReportPage.findEndTime(tr);

        //查询支付订单号
        List<String> payBizNos = gasTradeOrderMapper
                .findbizNosByTime(partnerId, operateName, payType, beginTime, finishTime);
        Map<String, Object> payMap = gasTradeOrderMapper.findGasTradeOrderByBizNos(payBizNos);
        //支付笔数
        counts = payMap.get("counts").toString();
        //支付金额
        amounts = Double.valueOf(payMap.get("amounts").toString()) / 100.0;
        //优惠金额
        favourAmounts = Double.valueOf(payMap.get("favourAmounts").toString()) / 100.0;
        //退款前结算金额
        settleAmounts = Double.valueOf(payMap.get("settleAmounts").toString()) / 100.0;

        //查询退款订单号
        List<String> refundBizNos = gasTradeOrderMapper
                .findbizNosByTime(partnerId, operateName, refundType, beginTime, finishTime);
        if (!refundBizNos.isEmpty()) {
            Map<String, Object> refundMap = gasTradeOrderMapper.findGasTradeOrderByBizNos(refundBizNos);
            //退款金额
            refunds = Double.valueOf(refundMap.get("amounts").toString()) / 100.0;
        } else {
            refunds = 0.0;
        }
        //退款后结算金额
        settleAmounts = settleAmounts - refunds;
        //油品升数
        oils = gasTradeOilMapper.findOilsByBizNos(payBizNos);

        //验证页面数据
        classReportPage.checkData(tr, stationName, oils, counts, amounts, refunds, favourAmounts, settleAmounts);

    }
}

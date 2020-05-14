package com.xjy.autotest.gas.test.order;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.order.DepositOrderPage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2020-2-19.
 */
public class DepositOrderSearchWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    /**
     * 1001 根据全部查询条件查询
     * 1002 根据订单号查询
     */
    @AutoTest(file = "gas/depositOrderSearchWebTestSuccess.csv")
    @DisplayName("充值订单查询--成功用例")
    public void depositOrderSearchWebTestSuccess(
            int testId,
            String userName,
            String password,
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
        //清除数据
        //打开加好油中台页面
        open(testUrlGas);
        //登录并查询充值订单
        DepositOrderPage depositOrderPage = new GasLoginPage()
                .login(USER_NAME_JHY, PASS_WORD_JHY)
                .orderCenter()
                .depositOrder()
                .searchOrder(bizNo, stationCode, stationName, mobile, carNumber, finishTime, finishTime1, tradePayType, status);
        //页面数据验证
        depositOrderPage.checkDepositOrder(bizNo, stationCode, stationName, mobile, carNumber, finishTime, tradePayType, status);
        //数据库数据验证
        //删除数据

    }
}

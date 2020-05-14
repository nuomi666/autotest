package com.xjy.autotest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.pay.api.common.enums.NotifyCategory;
import com.xyb.pay.api.settlement.order.withdraw.DelayWithdrawOrder;
import com.xyb.pay.api.settlement.service.WithdrawService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;


/**
 * @author ychaoyang
 * Created on 2018/11/21.
 */
@Disabled
public class WithdrawServiceDelayWithdrawTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    WithdrawService withdrawService;

    /**
     * 1001 提现
     * 1002 提现
     * 1003 提现失败
     */
    @AutoTest(file = "pay/withdrawServiceDelayWithdrawTestSuccess.csv")
    @DisplayName("--成功用例")
    public void withdrawServiceDelayWithdrawTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DelayWithdrawOrder order
    ) {
         if (testId != 1001 ) {
             return;
         }
        // 清除数据
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setNotifyCategory(NotifyCategory.DUBBO);
        order.setNotifyGroup("2222");
        order.setNotifyVersion("1.0");
        order.setPartnerId("20180615001234567893");
        order.setBankCard("6226660901612855");
        // 调用接口
        BizResult result = withdrawService.delayWithdraw(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

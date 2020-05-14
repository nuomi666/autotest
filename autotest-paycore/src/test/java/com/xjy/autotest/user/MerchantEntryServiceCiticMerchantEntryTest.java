package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.merchant.entry.MerchantEntryService;
import com.xyb.user.api.order.merchant.entry.CiticMerchantEntryOrder;


/**
 * @author ychaoyang
 * Created on 2018/11/19.
 */
@Disabled
public class MerchantEntryServiceCiticMerchantEntryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    MerchantEntryService merchantEntryService;

    /**
     * 1001 子商户进件
     * 1002 子商户已进件，重复进件
     * 1003 子商户进件
     */
    @AutoTest(file = "user/merchantEntryServiceCiticMerchantEntryTestSuccess.csv")
    @DisplayName("--成功用例")
    public void merchantEntryServiceCiticMerchantEntryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CiticMerchantEntryOrder order
    ) {
        if (testId != 1001) {
            return;
        }
        // 清除数据
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        // 调用接口
        BizResult result = merchantEntryService.citicMerchantEntry(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 gid传空
     * 1002 reqId传空
     * 1003 partnerId传空
     * 1004 merchantOrderNo传空
     * 1005 platPartnerId传空
     * 1006 platMerchantOrderNo传空
     * 1008 subMerchantName传空
     * 1009 subMerchantAbbr传空
     * 1010 subMerchantAddress传空
     * 1011 subMerchantContact传空
     * 1012 subMerchantContactPhone传空
     * 1013 subMerchantEmail传空
     */
    @AutoTest(file = "user/merchantEntryServiceCiticMerchantEntryTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void merchantEntryServiceCiticMerchantEntryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CiticMerchantEntryOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        // 调用接口
        BizResult result = merchantEntryService.citicMerchantEntry(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 未配置渠道
     * 1002 邮箱格式数据错误
     * 1003 商户简称超长
     * 1004 商户号不存在
     */
    @AutoTest(file = "user/merchantEntryServiceCiticMerchantEntryTestFailTwo.csv")
    @DisplayName("进件失败--失败用例")
    public void merchantEntryServiceCiticMerchantEntryTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CiticMerchantEntryOrder order
    ) {
        if (testId != 1004) {
            return;
        }
        // 清除数据
        // 准备数据
        // 测试过程
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        // 调用接口
        BizResult result = merchantEntryService.citicMerchantEntry(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

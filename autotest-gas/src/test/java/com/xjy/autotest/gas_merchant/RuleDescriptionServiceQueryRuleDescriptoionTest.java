package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.RuleDescriptionService;
import com.xyb.gas.merchant.api.info.RuleDescriptionInfo;
import com.xyb.gas.merchant.api.order.RuleDescriptionOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/12/30.
 */
public class RuleDescriptionServiceQueryRuleDescriptoionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    RuleDescriptionService ruleDescriptionService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/ruleDescriptionServiceQueryRuleDescriptoionTestSuccess.csv")
    @DisplayName("查询商家配置公众号会员规则说明--成功用例")
    public void ruleDescriptionServiceQueryRuleDescriptoionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String ruleType,
            String dec,
            String decxx,
            RuleDescriptionOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasRuleDescriptionByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasRuleDescriptionByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        gasMerchantTestBase.insertGasRuleDescription(0, order.getPlatPartnerId(), order.getPlatPartnerId(),
                order.getRuleType().code(), null, null, dec);
        //干扰数据
        gasMerchantTestBase.insertGasRuleDescription(0, platPartnerId, platPartnerId, ruleType,
                null, null, decxx);
        // 测试过程
        // 调用接口
        BizCollectionResult<RuleDescriptionInfo> result = ruleDescriptionService.queryRuleDescriptoion(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        ruleDescriptionAssert(result.getInfos().iterator().next(),
                order.getPlatPartnerId(),
                order.getRuleType().code(), dec);
        // 清除数据
        gasMerchantTestBase.cleanGasRuleDescriptionByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanGasRuleDescriptionByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/ruleDescriptionServiceQueryRuleDescriptoionTestFailOne.csv")
    @DisplayName("查询商家配置公众号会员规则说明--参数非法")
    public void ruleDescriptionServiceQueryRuleDescriptoionTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RuleDescriptionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setRuleType(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizCollectionResult<RuleDescriptionInfo> result = ruleDescriptionService.queryRuleDescriptoion(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 会员中心规则说明校验
     */
    private void ruleDescriptionAssert(
            RuleDescriptionInfo dec,
            String platPartnerId,
            String ruleType,
            String description
    ) {
        assertEquals(platPartnerId, dec.getPartnerId());
        assertEquals(platPartnerId, dec.getPlatPartnerId());
        assertEquals(ruleType, dec.getRuleType().code());
        assertEquals(description, dec.getDescription());
    }
}

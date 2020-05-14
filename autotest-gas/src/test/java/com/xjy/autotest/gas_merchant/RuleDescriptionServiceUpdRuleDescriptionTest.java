package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.RuleDescriptionService;
import com.xyb.gas.merchant.api.order.DesciptionOrder;
import com.xyb.gas.merchant.api.order.UpdRuleDescriptionOrder;
import dal.model.gas_merchant.GasRuleDescriptionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/12/30.
 */
public class RuleDescriptionServiceUpdRuleDescriptionTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    RuleDescriptionService ruleDescriptionService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/ruleDescriptionServiceUpdRuleDescriptionTestSuccess.csv")
    @DisplayName("修改公从号会员规则说明配置--成功用例")
    public void ruleDescriptionServiceUpdRuleDescriptionTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String ruleType,
            String dec,
            UpdRuleDescriptionOrder order,
            DesciptionOrder desciptionOrder,
            DesciptionOrder desciptionOrder1
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasRuleDescriptionByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        gasMerchantTestBase.insertGasRuleDescription(0, null, order.getPlatPartnerId(),
                ruleType, null, null, dec);
        // 测试过程
        List<DesciptionOrder> desciptionOrderList = new ArrayList<DesciptionOrder>();
        desciptionOrderList.add(desciptionOrder);
        if (testId == 1003) {
            desciptionOrderList.add(desciptionOrder1);
        }
        order.setDesciptionOrderList(desciptionOrderList);
        // 调用接口
        SimpleResult result = ruleDescriptionService.updRuleDescription(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasRuleDescriptionDO> ruleDecs =
                gasMerchantTestBase.findGasRuleDescriptionByPlatPartnerId(order.getPlatPartnerId());
        if (testId == 1001) {
            List<String> ruleTypes = new ArrayList<>();
            assertEquals(2, ruleDecs.size());
            for (GasRuleDescriptionDO ruleDec : ruleDecs) {
                if (ruleType.equals(ruleDec.getRuleType())) {
                    ruleDescriptionAssert(ruleDec, order.getPlatPartnerId(), ruleType, dec);
                }
                if (desciptionOrder.getRuleType().code().equals(ruleDec.getRuleType())) {
                    ruleDescriptionAssert(ruleDec, order.getPlatPartnerId(), desciptionOrder.getRuleType().code(),
                            desciptionOrder.getDescription());
                }
                ruleTypes.add(ruleDec.getRuleType());
            }
            assertTrue(ruleTypes.contains(ruleType));
            assertTrue(ruleTypes.contains(desciptionOrder.getRuleType().code()));
        }
        if (testId == 1002) {
            assertEquals(1, ruleDecs.size());
            for (GasRuleDescriptionDO ruleDec : ruleDecs) {
                ruleDescriptionAssert(ruleDec, order.getPlatPartnerId(), desciptionOrder.getRuleType().code(),
                        desciptionOrder.getDescription());
            }
        }
        if (testId == 1003) {
            List<String> ruleTypes = new ArrayList<>();
            assertEquals(2, ruleDecs.size());
            for (GasRuleDescriptionDO ruleDec : ruleDecs) {
                if (desciptionOrder.getRuleType().code().equals(ruleDec.getRuleType())) {
                    ruleDescriptionAssert(ruleDec, order.getPlatPartnerId(), desciptionOrder.getRuleType().code(),
                            desciptionOrder.getDescription());
                }
                if (desciptionOrder1.getRuleType().code().equals(ruleDec.getRuleType())) {
                    ruleDescriptionAssert(ruleDec, order.getPlatPartnerId(), desciptionOrder1.getRuleType().code(),
                            desciptionOrder1.getDescription());
                }
                ruleTypes.add(ruleDec.getRuleType());
            }
            assertTrue(ruleTypes.contains(desciptionOrder.getRuleType().code()));
            assertTrue(ruleTypes.contains(desciptionOrder1.getRuleType().code()));
        }
        // 清除数据
        gasMerchantTestBase.cleanGasRuleDescriptionByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/ruleDescriptionServiceUpdRuleDescriptionTestFailOne.csv")
    @DisplayName("修改公从号会员规则说明配置--参数非法")
    public void ruleDescriptionServiceUpdRuleDescriptionTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UpdRuleDescriptionOrder order,
            DesciptionOrder desciptionOrder
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<DesciptionOrder> desciptionOrderList = new ArrayList<DesciptionOrder>();
        if (testId == 1001) {
            desciptionOrder.setRuleType(null);
        }
        desciptionOrderList.add(desciptionOrder);
        order.setDesciptionOrderList(desciptionOrderList);
        if (testId == 1002) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1003) {
            order.setDesciptionOrderList(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = ruleDescriptionService.updRuleDescription(order);
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
            GasRuleDescriptionDO dec,
            String platPartnerId,
            String ruleType,
            String description
    ) {
        assertEquals(null, dec.getPartnerId());
        assertEquals(platPartnerId, dec.getPlatPartnerId());
        assertEquals(ruleType, dec.getRuleType());
        assertEquals(description, dec.getDescription());
    }
}

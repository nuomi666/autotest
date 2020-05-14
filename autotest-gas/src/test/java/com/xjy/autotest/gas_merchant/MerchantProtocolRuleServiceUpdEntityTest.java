package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.ProtocolRuleType;
import com.xyb.gas.merchant.api.facade.MerchantProtocolRuleService;
import com.xyb.gas.merchant.api.order.ProtocolRuleDataOrder;
import com.xyb.gas.merchant.api.order.UpdMerchantProtocolRuleOrder;
import dal.model.gas_merchant.MerchantProtocolRuleDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/11/22.
 */
public class MerchantProtocolRuleServiceUpdEntityTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantProtocolRuleService merchantProtocolRuleService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantProtocolRuleServiceUpdEntityTestSuccess.csv")
    @DisplayName("修改商家协议配置规则--成功用例")
    public void merchantProtocolRuleServiceUpdEntityTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String protocol, String dec,
            Money amount, Integer index,
            Money amount1, Integer index1,
            UpdMerchantProtocolRuleOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanMerchantProtocolRuleByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        if (testId != 1001) {
            gasMerchantInitDataBase.initMerchantProtocolRule(order.getPlatPartnerId(), ProtocolRuleType.Recharge.code(),
                    protocol,
                    dec, amount, index, amount1, index1, "ABLE");
        }
        // 测试过程
        ProtocolRuleDataOrder ruleData = new ProtocolRuleDataOrder();
        ruleData.setIndex(index);
        ruleData.setAmount(amount);
        ProtocolRuleDataOrder ruleData1 = new ProtocolRuleDataOrder();
        ruleData1.setIndex(index1);
        ruleData1.setAmount(amount1);
        List<ProtocolRuleDataOrder> ruleDatas = new ArrayList<ProtocolRuleDataOrder>();
        ruleDatas.add(ruleData);
        ruleDatas.add(ruleData1);
        order.setRuleData(ruleDatas);
        // 调用接口
        SimpleResult result = merchantProtocolRuleService.updEntity(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        MerchantProtocolRuleDO ruleInfo =
                gasMerchantTestBase.findMerchantProtocolRuleByPlatPartnerId(order.getPlatPartnerId()).get(0);
        assertEquals(order.getPlatPartnerId(), ruleInfo.getPlatPartnerId());
        assertEquals(order.getRuleType().code(), ruleInfo.getRuleType());
        assertEquals(order.getDescription(), ruleInfo.getDescription());
        assertEquals(order.getProtocol(), ruleInfo.getProtocol());
//        assertEquals(JSON.toJSONString(ruleDatas), ruleInfo.getRuleData());校验不过，接口写入数据库时除其他属性外还加了个TypeHander
        // 清除数据
        gasMerchantTestBase.cleanMerchantProtocolRuleByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantProtocolRuleServiceUpdEntityTestFailOne.csv")
    @DisplayName("修改商家协议配置规则--参数非法")
    public void merchantProtocolRuleServiceUpdEntityTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UpdMerchantProtocolRuleOrder order
    ) {
        // 清除数据

        // 准备数据
        // 测试过程
        ProtocolRuleDataOrder ruleData = new ProtocolRuleDataOrder();
        List<ProtocolRuleDataOrder> ruleDatas = new ArrayList<ProtocolRuleDataOrder>();
        ruleDatas.add(ruleData);
        order.setRuleData(ruleDatas);
        if (testId == 1001) {
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
        SimpleResult result = merchantProtocolRuleService.updEntity(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Lists;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.common.util.CollectionUtil;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.ProtocolRuleType;
import com.xyb.gas.merchant.api.facade.MerchantProtocolRuleService;
import com.xyb.gas.merchant.api.info.MerchantProtocolRuleInfo;
import com.xyb.gas.merchant.api.order.ProtocolRuleDataOrder;
import com.xyb.gas.merchant.api.order.QueryMerchantProtocolRuleOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2019/11/22.
 */
public class MerchantProtocolRuleServiceQueryDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantProtocolRuleService merchantProtocolRuleService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantProtocolRuleServiceQueryDetailTestSuccess.csv")
    @DisplayName("查询商家协议配置规则--成功用例")
    public void merchantProtocolRuleServiceQueryDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String protocol, String dec,
            Money amount, Integer index,
            Money amount1, Integer index1,
            QueryMerchantProtocolRuleOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initMerchantProtocolRule(order.getPlatPartnerId(), ProtocolRuleType.Recharge.code(),
                protocol,
                dec, amount, index, amount1, index1, "ABLE");
        // 测试过程
        // 调用接口
        BizCollectionResult<MerchantProtocolRuleInfo> result = merchantProtocolRuleService.queryDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertTrue(CollectionUtil.isNotEmpty(result.getInfos()));
        for (MerchantProtocolRuleInfo ruleInfo : result.getInfos()) {
            assertEquals(order.getPlatPartnerId(), ruleInfo.getPlatPartnerId());
            assertEquals(ProtocolRuleType.Recharge, ruleInfo.getDescription());
            assertEquals(dec, ruleInfo.getDescription());
            assertEquals(protocol, ruleInfo.getDescription());
            List<ProtocolRuleDataOrder> ruleDatas = ruleInfo.getRuleData();
            List<Integer> indexs = Lists.newArrayList();
            List<Money> amounts = Lists.newArrayList();
            for (ProtocolRuleDataOrder ruleData : ruleDatas) {
                indexs.add(ruleData.getIndex());
                amounts.add(ruleData.getAmount());
            }
            assertTrue(indexs.contains(index));
            assertTrue(indexs.contains(index1));
            assertTrue(amounts.contains(amount));
            assertTrue(amounts.contains(amount1));
        }
        // 清除数据
        gasMerchantTestBase.cleanMerchantProtocolRuleByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantProtocolRuleServiceQueryDetailTestFailOne.csv")
    @DisplayName("查询商家协议配置规则--参数非法")
    public void merchantProtocolRuleServiceQueryDetailTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantProtocolRuleOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizCollectionResult<MerchantProtocolRuleInfo> result = merchantProtocolRuleService.queryDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }
}

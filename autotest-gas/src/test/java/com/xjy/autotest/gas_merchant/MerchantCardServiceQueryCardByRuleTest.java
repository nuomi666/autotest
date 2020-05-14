package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.CardBizType;
import com.xyb.gas.merchant.api.enums.CardType;
import com.xyb.gas.merchant.api.facade.MerchantCardService;
import com.xyb.gas.merchant.api.info.MerchantCardInfo;
import com.xyb.gas.merchant.api.order.QueryMerchantCardOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/10/16.
 */
public class MerchantCardServiceQueryCardByRuleTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantCardService merchantCardService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceQueryCardByRuleTestSuccess.csv")
    @DisplayName("查询制卡卡号--成功用例")
    public void merchantCardServiceQueryCardByRuleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String account, String cardNo,
            String cardNo1, String cardNo2,
            QueryMerchantCardOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initGasMerchantCard(platPartnerId, order.getRuleId(), account, cardNo, cardNo1, cardNo2,
                null);
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        BizCollectionResult<MerchantCardInfo> result = merchantCardService.queryCardByRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        Collection<MerchantCardInfo> cardInfos = result.getInfos();
        assertEquals(3, cardInfos.size());
        List<String> cardNos = new ArrayList<>();
        for (MerchantCardInfo cardInfo : cardInfos) {
            assertEquals(platPartnerId, cardInfo.getPlatPartnerId());
            assertEquals(platPartnerId, cardInfo.getPartnerId());
            assertEquals(null, cardInfo.getParentCardNo());
            assertEquals(CardType.ENTITY, cardInfo.getCardType());
            assertEquals(CardBizType.DEFAULT, cardInfo.getTag());
            assertEquals(null, cardInfo.getInternalNo());
            cardNos.add(cardInfo.getCardNo());
        }
        assertTrue(cardNos.contains(cardNo));
        assertTrue(cardNos.contains(cardNo1));
        assertTrue(cardNos.contains(cardNo2));
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantCardByPlatPartnerId(platPartnerId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceQueryCardByRuleTestFailOne.csv")
    @DisplayName("查询制卡卡号--参数非法")
    public void merchantCardServiceQueryCardByRuleTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantCardOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setGid(null);
        }
        if (testId == 1002) {
            order.setRuleId(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizCollectionResult<MerchantCardInfo> result = merchantCardService.queryCardByRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001数据不存在
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceQueryCardByRuleTestFailTwo.csv")
    @DisplayName("查询制卡卡号--失败用例")
    public void merchantCardServiceQueryCardByRuleTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantCardOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantCardByCardRuleId(order.getRuleId());
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        BizCollectionResult<MerchantCardInfo> result = merchantCardService.queryCardByRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }
}

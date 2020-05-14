package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.CardBizType;
import com.xyb.gas.merchant.api.enums.CardType;
import com.xyb.gas.merchant.api.facade.MerchantCardService;
import com.xyb.gas.merchant.api.order.AddMerchantCardRuleOrder;
import dal.model.gas_merchant.GasMerchantCardDO;
import dal.model.gas_merchant.GasMerchantCardRuleDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class MerchantCardServiceAddCardRuleTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantCardService merchantCardService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001暂时只用于制默认业务的实体卡
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceAddCardRuleTestSuccess.csv")
    @DisplayName("增加制卡规则--成功用例")
    public void merchantCardServiceAddCardRuleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddMerchantCardRuleOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantCardByPartnerId(order.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantCardRuleByPartnerId(order.getPartnerId());
        // 准备数据
        // 测试过程
        Set<Integer> excludeCardNos = Sets.newHashSet();
        excludeCardNos.add(1);
        if (testId == 1003) {
            excludeCardNos.add(10);
        }
        Set<Integer> excludeNumbers = Sets.newHashSet();
        excludeNumbers.add(0);
        if (testId == 1003) {
            excludeNumbers.add(6);
        }
        if (testId >= 1002) {
            order.setExcludeCardNos(excludeCardNos);
            order.setExcludeNumbers(excludeNumbers);
        }
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantCardService.addCardRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//		assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            Long id = cardRuleAssert(order.getPlatPartnerId(), order.getRangeStart().intValue(),
                    order.getRangeEnd().intValue(),
                    JSON.toJSONString(order.getExcludeCardNos()), JSON.toJSONString(order.getExcludeNumbers()), 20);
            cardAssert(20, order.getPlatPartnerId(), CardType.ENTITY.code(), CardBizType.DEFAULT.code(), id);
        } else if (testId == 1002) {
            Long id = cardRuleAssert(order.getPlatPartnerId(), order.getRangeStart().intValue(),
                    order.getRangeEnd().intValue(),
                    JSON.toJSONString(order.getExcludeCardNos()), JSON.toJSONString(order.getExcludeNumbers()), 17);
            cardAssert(17, order.getPlatPartnerId(), CardType.ENTITY.code(), CardBizType.DEFAULT.code(), id);
        } else if (testId == 1003) {
            Long id = cardRuleAssert(order.getPlatPartnerId(), order.getRangeStart().intValue(),
                    order.getRangeEnd().intValue(),
                    JSON.toJSONString(order.getExcludeCardNos()), JSON.toJSONString(order.getExcludeNumbers()), 15);
            cardAssert(15, order.getPlatPartnerId(), CardType.ENTITY.code(), CardBizType.DEFAULT.code(), id);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantCardByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantCardRuleByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001暂时只用于制默认业务的实体卡
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceAddCardRuleTestFailOne.csv")
    @DisplayName("增加制卡规则--参数非法")
    public void merchantCardServiceAddCardRuleTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddMerchantCardRuleOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantCardByPartnerId(order.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantCardRuleByPartnerId(order.getPartnerId());
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setGid(null);
        }
        if (testId == 1002) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantCardService.addCardRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//		assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 制卡规则表校验
     */
    private Long cardRuleAssert(
            String platPartnerId,
            int rangeStart,
            int rangeEnd,
            String excludeCardNo,
            String excludeNumber,
            int validCount
    ) {
        List<GasMerchantCardRuleDO> cardRules =
                gasMerchantTestBase.findGasMerchantCardRuleByPlatPartnerId(platPartnerId);
        assertTrue(cardRules.size() > 0);
        for (GasMerchantCardRuleDO cardRule : cardRules) {
            assertEquals(rangeStart, cardRule.getRangeStart());
            assertEquals(rangeEnd, cardRule.getRangeEnd());
            assertEquals(excludeCardNo, cardRule.getExcludeCardNo());
            assertEquals(excludeNumber, cardRule.getExcludeNumber());
            assertEquals(validCount, cardRule.getValidCount());
        }
        return cardRules.get(0).getId();
    }

    /**
     * 商户卡列表校验
     */
    private void cardAssert(
            int count,
            String platPartnerId,
            String cardType,
            String tag,
            Long cardRuleId
    ) {
        List<GasMerchantCardDO> cards = gasMerchantTestBase.findGasMerchantCardByPlatPartnerId(platPartnerId);
        assertEquals(count, cards.size());
        for (GasMerchantCardDO card : cards) {
            assertEquals(cardType, card.getCardType());
            assertEquals(tag, card.getTag());
            assertEquals(cardRuleId, card.getCardRuleId());
        }
    }
}

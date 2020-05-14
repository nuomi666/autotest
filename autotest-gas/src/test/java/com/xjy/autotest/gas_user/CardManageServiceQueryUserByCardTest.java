package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.user.api.CardManageService;
import com.xyb.gas.user.api.enums.CardBizType;
import com.xyb.gas.user.api.enums.CardStatus;
import com.xyb.gas.user.api.enums.CardType;
import com.xyb.gas.user.api.order.QueryUserByCardOrder;
import com.xyb.gas.user.api.result.QueryUserByCardResult;
import com.xyb.gas.user.api.result.info.UserCardInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/14.
 */
public class CardManageServiceQueryUserByCardTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    CardManageService cardManageService;

    @Autowired
    GasUserInitDataBase gasUserInitDataBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001.查询单个会员的虚拟卡信息
     * 1002.查询单个会员的实体卡信息
     * 1003.查询多个会员的卡信息
     * 1004.传入一个会员的实体卡和虚拟卡查询卡信息
     */
    @AutoTest(file = "gas_user/cardManageServiceQueryUserByCardTestSuccess.csv")
    @DisplayName("根据卡号列表查询相关卡信息--成功用例")
    public void cardManageServiceQueryUserByCardTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String userId1,
            String nickName1, String mobile1,
            String entityNo, String innerNo,
            String cardStatus,
            QueryUserByCardOrder order
    ) {
        // 清除数据
        // 准备数据
        //商户
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商户", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "18825814769", "ABLE");
        //实体卡
        gasMerchantInitDataBase.initGasMerchantCard(partnerId, 1L, "Admin", entityNo,
                null, null, null);
        //会员1
        Map<String, Object> params = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                registerFrom,
                null, null, null, null, null, null);
        String cardNo = params.get("accountNo").toString();
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, entityNo, innerNo,
                null, CardType.ENTITY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                cardNo, cardStatus, null, null);
        //会员2
        Map<String, Object> params1 = gasUserInitDataBase.initUser(partnerId, userId1, null, nickName1, mobile1,
                registerFrom,
                null, null, null, null, null, null);
        String cardNo1 = params1.get("accountNo").toString();
        // 测试过程
        List<String> cards = new ArrayList<String>();
        if (testId != 1002) {
            cards.add(cardNo);
        }
        if (testId == 1003) {
            cards.add(cardNo1);
        }
        if (testId == 1002 || testId == 1004) {
            cards.add(entityNo);
        }
        order.setCards(cards);
        // 调用接口
        QueryUserByCardResult result = cardManageService.queryUserByCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserCardInfo> cardInfos = result.getList();
        if (testId == 1001) {
            assertEquals(1, cardInfos.size());
            userCardAssert(cardInfos.get(0), partnerId,
                    userId, cardNo, null,
                    CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                    cardNo, CardStatus.NORMAL.code(), Money.zero());
        }
        if (testId == 1002) {
            assertEquals(1, cardInfos.size());
            userCardAssert(cardInfos.get(0), partnerId,
                    userId, entityNo, innerNo,
                    CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                    cardNo, cardStatus, Money.zero());
        }
        if (testId == 1003) {
            assertEquals(2, cardInfos.size());
            List<String> cards1 = new ArrayList<String>();
            for (UserCardInfo cardInfo : cardInfos) {
                cards1.add(cardInfo.getCardNo());
                if (cardNo.equals(cardInfo.getCardNo())) {
                    userCardAssert(cardInfo, partnerId,
                            userId, cardNo, null,
                            CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                            cardNo, CardStatus.NORMAL.code(), Money.zero());
                }
                if (cardNo1.equals(cardInfo.getCardNo())) {
                    userCardAssert(cardInfo, partnerId,
                            userId1, cardNo1, null,
                            CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                            cardNo1, CardStatus.NORMAL.code(), Money.zero());
                }
            }
            assertTrue(cards1.contains(cardNo));
            assertTrue(cards1.contains(cardNo1));
        }
        if (testId == 1004) {
            assertEquals(2, cardInfos.size());
            List<String> cards1 = new ArrayList<String>();
            for (UserCardInfo cardInfo : cardInfos) {
                cards1.add(cardInfo.getCardNo());
                if (cardNo.equals(cardInfo.getCardNo())) {
                    userCardAssert(cardInfo, partnerId,
                            userId, cardNo, null,
                            CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                            cardNo, CardStatus.NORMAL.code(), Money.zero());
                }
                if (entityNo.equals(cardInfo.getCardNo())) {
                    userCardAssert(cardInfo, partnerId,
                            userId, entityNo, innerNo,
                            CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                            cardNo, cardStatus, Money.zero());
                }
            }
            assertTrue(cards1.contains(cardNo));
            assertTrue(cards1.contains(entityNo));
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanUserByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByUserId(userId1);
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.cleanUserCardInfoByUserId(userId1);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantCardByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByUserId(userId1);
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/cardManageServiceQueryUserByCardTestFailOne.csv")
    @DisplayName("根据卡号列表查询相关卡信息--参数非法")
    public void cardManageServiceQueryUserByCardTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryUserByCardOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> cards = new ArrayList<String>();
        cards.add(OID.newID());
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setCards(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        QueryUserByCardResult result = cardManageService.queryUserByCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/cardManageServiceQueryUserByCardTestFailTwo.csv")
    @DisplayName("根据卡号列表查询相关卡信息--失败用例")
    public void cardManageServiceQueryUserByCardTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String cardNo,
            QueryUserByCardOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> cards = new ArrayList<String>();
        cards.add(cardNo);
        order.setCards(cards);
        // 调用接口
        QueryUserByCardResult result = cardManageService.queryUserByCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 卡表校验
     */
    private void userCardAssert(
            UserCardInfo cardInfo,
            String partnerId,
            String userId,
            String cardNo,
            String innalNo,
            String cardType,
            String tag,
            String accNo,
            String status,
            Money balance
    ) {
        assertEquals(partnerId, cardInfo.getPlatPartnerId());
        assertEquals(userId, cardInfo.getUserId());
        assertEquals(cardNo, cardInfo.getCardNo());
        assertEquals(innalNo, cardInfo.getInternalNo());
        assertEquals(null, cardInfo.getParentCardAccountNo());
        assertEquals(cardType, cardInfo.getCardType().code());
        assertEquals(tag, cardInfo.getTag().code());
        assertEquals(accNo, cardInfo.getAccountNo());
        assertEquals(status, cardInfo.getStatus().code());
        assertEquals(balance, cardInfo.getBalance());
    }
}

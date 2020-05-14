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
import com.xyb.gas.user.api.QueryUserService;
import com.xyb.gas.user.api.enums.CardBizType;
import com.xyb.gas.user.api.enums.CardStatus;
import com.xyb.gas.user.api.enums.CardType;
import com.xyb.gas.user.api.order.QueryCardListByUserOrder;
import com.xyb.gas.user.api.result.UserCardListResult;
import com.xyb.gas.user.api.result.info.UserCardInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/15.
 */
public class QueryUserServiceQueryCardListByUserTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    QueryUserService queryUserService;

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
     * 1001.查询用户下的所有卡
     * 1002.加上卡类型查询用户的卡
     * 1003.加上卡状态查询用户的卡
     */
    @AutoTest(file = "gas_user/queryUserServiceQueryCardListByUserTestSuccess.csv")
    @DisplayName("根据用户查询用户下的卡--成功用例")
    public void queryUserServiceQueryCardListByUserTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String entityNo,
            String innerNo, String cardStatus,
            QueryCardListByUserOrder order
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
        //会员
        Map<String, Object> params = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                registerFrom,
                null, null, null, null, null, null);
        String cardNo = params.get("accountNo").toString();
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, entityNo, innerNo,
                null, CardType.ENTITY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                cardNo, cardStatus, null, null);
        // 测试过程
        // 调用接口
        UserCardListResult result = queryUserService.queryCardListByUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserCardInfo> cardInfos = result.getList();
        if (testId == 1001) {
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
        if (testId == 1002) {
            assertEquals(1, cardInfos.size());
            userCardAssert(cardInfos.get(0), partnerId,
                    userId, entityNo, innerNo,
                    CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                    cardNo, cardStatus, Money.zero());
        }
        if (testId == 1003) {
            assertEquals(1, cardInfos.size());
            userCardAssert(cardInfos.get(0), partnerId,
                    userId, cardNo, null,
                    CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                    cardNo, CardStatus.NORMAL.code(), Money.zero());
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserCardInfoByUserId(userId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantCardByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasUserByUserId(userId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_user/queryUserServiceQueryCardListByUserTestFailOne.csv")
    @DisplayName("根据用户查询用户下的卡--参数非法")
    public void queryUserServiceQueryCardListByUserTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCardListByUserOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        UserCardListResult result = queryUserService.queryCardListByUser(order);
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
    @AutoTest(file = "gas_user/queryUserServiceQueryCardListByUserTestFailTwo.csv")
    @DisplayName("根据用户查询用户下的卡--失败用例")
    public void queryUserServiceQueryCardListByUserTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCardListByUserOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserCardInfoByUserId(order.getUserId());
        // 准备数据
        // 测试过程
        // 调用接口
        UserCardListResult result = queryUserService.queryCardListByUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 卡信息
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

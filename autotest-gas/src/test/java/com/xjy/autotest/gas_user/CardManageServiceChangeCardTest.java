package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.CardManageService;
import com.xyb.gas.user.api.enums.CardBizType;
import com.xyb.gas.user.api.enums.CardStatus;
import com.xyb.gas.user.api.enums.CardType;
import com.xyb.gas.user.api.order.ChangeCardOrder;
import dal.model.gas_user.UserCardInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/13.
 */
public class CardManageServiceChangeCardTest extends SpringBootTestBase {

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
     * 只有过期和挂失状态能换卡,不传新卡号则不会更换卡面号
     * 1001.更换过期的卡
     * 1002.更换挂失的卡
     */
    @AutoTest(file = "gas_user/cardManageServiceChangeCardTestSuccess.csv")
    @DisplayName("更换实体卡--成功用例")
    public void cardManageServiceChangeCardTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String cardNo,
            String innerNo, String cardStatus,
            String cardNoxx, String innerNoxx,
            ChangeCardOrder order
    ) {
        // 清除数据
        // 准备数据
        //商户
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商户", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "18825814769", "ABLE");
        //实体卡
        gasMerchantInitDataBase.initGasMerchantCard(partnerId, 1L, "Admin", cardNo,
                cardNoxx, null, null);
        //会员
        Map<String, Object> params = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                registerFrom,
                null, null, null, null, null, null);
        String accountNo = params.get("accountNo").toString();
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, cardNo, innerNo,
                null, CardType.ENTITY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                accountNo, cardStatus, null, null);
        // 测试过程
        order.setOldCardNo(cardNo);
        if (testId == 1002) {
            order.setNewCardNo(cardNoxx);
        }
        order.setInternalNo(innerNoxx);
        // 调用接口
        SimpleResult result = cardManageService.changeCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserCardInfoDO> cardInfos = userTestBase.findUserCardInfoByCardNo(cardNo);
        if (testId == 1002) {
            assertEquals(0, cardInfos.size());
        } else {
            cardAssert(cardInfos.get(0), partnerId,
                    userId, cardNo, innerNoxx,
                    CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                    accountNo, "GAS_DUMMY_DEFAULT", CardStatus.NORMAL.code());
        }
        List<UserCardInfoDO> cardInfosxx = userTestBase.findUserCardInfoByCardNo(cardNoxx);
        if (testId == 1001) {
            assertEquals(0, cardInfosxx.size());
        } else {
            cardAssert(cardInfosxx.get(0), partnerId,
                    userId, cardNoxx, innerNoxx,
                    CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                    accountNo, "GAS_DUMMY_DEFAULT", CardStatus.NORMAL.code());
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
    @AutoTest(file = "gas_user/cardManageServiceChangeCardTestFailOne.csv")
    @DisplayName("更换实体卡--参数非法")
    public void cardManageServiceChangeCardTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ChangeCardOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setOldCardNo(null);
        }
        if (testId == 1003) {
            order.setInternalNo(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = cardManageService.changeCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 只有过期和挂失状态能换卡
     * 1001.卡不存在
     * 1002.卡状态不正确
     */
    @AutoTest(file = "gas_user/cardManageServiceChangeCardTestFailTwo.csv")
    @DisplayName("更换实体卡--失败用例")
    public void cardManageServiceChangeCardTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String cardNo,
            String innerNo, String cardStatus,
            String cardNoxx, String innerNoxx,
            ChangeCardOrder order
    ) {
        // 清除数据
        // 准备数据
        //商户
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商户", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "18825814769", "ABLE");
        //实体卡
        gasMerchantInitDataBase.initGasMerchantCard(partnerId, 1L, "Admin", cardNo,
                cardNoxx, null, null);
        //会员
        Map<String, Object> params = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                registerFrom,
                null, null, null, null, null, null);
        String accountNo = params.get("accountNo").toString();
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, cardNo, innerNo,
                null, CardType.ENTITY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                accountNo, cardStatus, null, null);
        // 测试过程
        if (testId != 1001) {
            order.setOldCardNo(cardNo);
        }
        order.setNewCardNo(cardNoxx);
        order.setInternalNo(innerNoxx);
        // 调用接口
        SimpleResult result = cardManageService.changeCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserCardInfoDO> cardInfos = userTestBase.findUserCardInfoByCardNo(cardNo);
        cardAssert(cardInfos.get(0), partnerId,
                userId, cardNo, innerNo,
                CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                accountNo, "GAS_DUMMY_DEFAULT", cardStatus);
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
     * 卡表校验
     */
    private void cardAssert(
            UserCardInfoDO cardInfo,
            String partnerId,
            String userId,
            String cardNo,
            String innalNo,
            String cardType,
            String tag,
            String accNo,
            String accTag,
            String status
    ) {
        assertEquals(partnerId, cardInfo.getPlatPartnerId());
        assertEquals(userId, cardInfo.getUserId());
        assertEquals(cardNo, cardInfo.getCardNo());
        assertEquals(innalNo, cardInfo.getInternalNo());
        assertEquals(null, cardInfo.getParentCardAccountNo());
        assertEquals(cardType, cardInfo.getCardType());
        assertEquals(tag, cardInfo.getTag());
        assertEquals(accNo, cardInfo.getAccountNo());
        assertEquals(accTag, cardInfo.getAccountTag());
        assertEquals(status, cardInfo.getStatus());
    }
}

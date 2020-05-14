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
import com.xyb.gas.user.api.order.UpdateCardStatusOrder;
import dal.model.gas_user.UserCardInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/14.
 */
public class CardManageServiceUpdateCardStatusTest extends SpringBootTestBase {

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
     * 过期挂失应该是只有实体卡才有的状态，不会影响虚拟卡
     * 但在对虚拟卡做冻结注销操作时，没有同步修改实体卡的状态，设计有问题
     * 1001.修改虚拟卡，正常→冻结
     * 1002.修改虚拟卡，正常→注销
     * 1003.修改实体卡，过期→正常
     * 1004.修改实体卡，正常→挂失
     */
    @AutoTest(file = "gas_user/cardManageServiceUpdateCardStatusTestSuccess.csv")
    @DisplayName("修改卡的状态--成功用例")
    public void cardManageServiceUpdateCardStatusTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String entityNo,
            String innerNo, String cardStatus,
            UpdateCardStatusOrder order
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
        if (testId <= 1002) {
            order.setCardNo(cardNo);
        } else {
            order.setCardNo(entityNo);
        }
        // 调用接口
        SimpleResult result = cardManageService.updateCardStatus(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserCardInfoDO> cardInfos = userTestBase.findUserCardInfoByCardNo(entityNo);
        if (testId == 1003 || testId == 1004) {
            cardAssert(cardInfos.get(0), partnerId,
                    userId, entityNo, innerNo,
                    CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", order.getStatus().code());
        } else {
            cardAssert(cardInfos.get(0), partnerId,
                    userId, entityNo, innerNo,
                    CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", cardStatus);
        }
        List<UserCardInfoDO> cardInfosxx = userTestBase.findUserCardInfoByCardNo(cardNo);
        if (testId == 1002) {//注销做的物理删除
            assertEquals(0, cardInfosxx.size());
        } else if (testId == 1001) {
            cardAssert(cardInfosxx.get(0), partnerId,
                    userId, cardNo, null,
                    CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", order.getStatus().code());
        } else {
            cardAssert(cardInfosxx.get(0), partnerId,
                    userId, cardNo, null,
                    CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", CardStatus.NORMAL.code());
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(userId);
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
    @AutoTest(file = "gas_user/cardManageServiceUpdateCardStatusTestFailOne.csv")
    @DisplayName("修改卡的状态--参数非法")
    public void cardManageServiceUpdateCardStatusTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UpdateCardStatusOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setCardNo(null);
        }
        if (testId == 1002) {
            order.setStatus(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = cardManageService.updateCardStatus(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.卡不存在
     * 1002.修改卡的状态不正确
     */
    @AutoTest(file = "gas_user/cardManageServiceUpdateCardStatusTestFailTwo.csv")
    @DisplayName("修改卡的状态--失败用例")
    public void cardManageServiceUpdateCardStatusTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String entityNo,
            String innerNo, String cardStatus,
            UpdateCardStatusOrder order
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
        if (testId == 1002) {
            order.setCardNo(cardNo);
        }
        // 调用接口
        SimpleResult result = cardManageService.updateCardStatus(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserCardInfoDO> cardInfos = userTestBase.findUserCardInfoByCardNo(entityNo);
        cardAssert(cardInfos.get(0), partnerId,
                userId, entityNo, innerNo,
                CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                cardNo, "GAS_DUMMY_DEFAULT", cardStatus);
        List<UserCardInfoDO> cardInfosxx = userTestBase.findUserCardInfoByCardNo(cardNo);
        cardAssert(cardInfosxx.get(0), partnerId,
                userId, cardNo, null,
                CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                cardNo, "GAS_DUMMY_DEFAULT", CardStatus.NORMAL.code());
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
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

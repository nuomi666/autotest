package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.InitData.GasUserInitDataBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.CardManageService;
import com.xyb.gas.user.api.enums.CardBizType;
import com.xyb.gas.user.api.enums.CardStatus;
import com.xyb.gas.user.api.enums.CardType;
import com.xyb.gas.user.api.order.QuerySingleCardOrder;
import com.xyb.gas.user.api.result.info.CardInfo;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/14.
 */
public class CardManageServiceQuerySingleCardTest extends SpringBootTestBase {

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
     * 1001.查询虚拟卡
     * 1002.查询实体卡
     */
    @AutoTest(file = "gas_user/cardManageServiceQuerySingleCardTestSuccess.csv")
    @DisplayName("根据卡号、用户ID查询卡的信息--成功用例")
    public void cardManageServiceQuerySingleCardTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String entityNo,
            String innerNo, String cardStatus,
            QuerySingleCardOrder order
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
        if (testId == 1001) {
            order.setCardNo(cardNo);
        }
        if (testId == 1002) {
            order.setCardNo(entityNo);
        }
        // 调用接口
        BizResult<CardInfo> result = cardManageService.querySingleCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        CardInfo cardInfo = result.getInfo();
        if (testId == 1001) {
            cardAssert(cardInfo, partnerId,
                    userId, cardNo, null,
                    CardType.DUMMY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", CardStatus.NORMAL.code());
        }
        if (testId == 1002) {
            cardAssert(cardInfo, partnerId,
                    userId, entityNo, innerNo,
                    CardType.ENTITY.code(), CardBizType.DEFAULT.code(),
                    cardNo, "GAS_DUMMY_DEFAULT", cardStatus);
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
    @AutoTest(file = "gas_user/cardManageServiceQuerySingleCardTestFailOne.csv")
    @DisplayName("根据卡号、用户ID查询卡的信息--成功用例")
    public void cardManageServiceQuerySingleCardTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QuerySingleCardOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setCardNo(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizResult<CardInfo> result = cardManageService.querySingleCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.会员不存在
     * 1002.卡不存在
     */
    @AutoTest(file = "gas_user/cardManageServiceQuerySingleCardTestFailTwo.csv")
    @DisplayName("根据卡号、用户ID查询卡的信息--失败用例")
    public void cardManageServiceQuerySingleCardTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom,
            QuerySingleCardOrder order
    ) {
        // 清除数据
        // 准备数据
        //商户
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商户", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "18825814769", "ABLE");
        //会员
        Map<String, Object> params = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                registerFrom,
                null, null, null, null, null, null);
        // 测试过程
        // 调用接口
        BizResult<CardInfo> result = cardManageService.querySingleCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
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
            CardInfo cardInfo,
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
        assertEquals(cardType, cardInfo.getCardType().code());
        assertEquals(tag, cardInfo.getTag().code());
        assertEquals(accNo, cardInfo.getAccountNo());
        assertEquals(accTag, cardInfo.getAccountTag());
        assertEquals(status, cardInfo.getStatus());
    }
}

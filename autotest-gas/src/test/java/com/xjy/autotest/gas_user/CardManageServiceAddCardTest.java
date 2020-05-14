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
import com.xyb.gas.user.api.order.AddCardOrder;
import dal.model.gas_user.UserCardInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/13.
 */
public class CardManageServiceAddCardTest extends SpringBootTestBase {

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
     * 目前就只验证了绑定实体卡的功能，车队卡后面再加，逻辑有可能变
     * 1001.会员有虚拟卡，绑定实体卡
     * 1002.新增卡（车队卡）
     */
    @AutoTest(file = "gas_user/cardManageServiceAddCardTestSuccess.csv")
    @DisplayName("添加虚拟卡/绑定实体卡--成功用例")
    public void cardManageServiceAddCardTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom,
            AddCardOrder order
    ) {
        // 清除数据
        // 准备数据
        //商户
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商户", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "18825814769", "ABLE");
        //实体卡
        gasMerchantInitDataBase.initGasMerchantCard(partnerId, 1L, "Admin", order.getCardNo(),
                null, null, null);
        //会员
        Map<String, Object> params = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                registerFrom,
                null, null, null, null, null, null);
        String accountNo = params.get("accountNo").toString();
        // 测试过程
        // 调用接口
        SimpleResult result = cardManageService.addCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<UserCardInfoDO> cardInfos = userTestBase.findUserCardInfoByCardNo(order.getCardNo());
        cardAssert(cardInfos.get(0), partnerId,
                userId, order.getCardNo(), order.getInternalNo(),
                order.getCardType().code(),
                order.getTag().code(), accountNo, "GAS_DUMMY_DEFAULT", "NORMAL");
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
    @AutoTest(file = "gas_user/cardManageServiceAddCardTestFailOne.csv")
    @DisplayName("添加虚拟卡/绑定实体卡--参数非法")
    public void cardManageServiceAddCardTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddCardOrder order
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
            order.setCardType(null);
        }
        if (testId == 1004) {
            order.setTag(null);
        }
        if (testId == 1005) {
            order.setInternalNo(null);
        }
        if (testId == 1006) {
            order.setGid(null);
        }
        if (testId == 1007) {
            order = null;
        }
        // 调用接口
        SimpleResult result = cardManageService.addCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.用户不存在
     * 1002.实体卡不存在
     * 1003.实体卡已经使用
     */
    @AutoTest(file = "gas_user/cardManageServiceAddCardTestFailTwo.csv")
    @DisplayName("添加虚拟卡/绑定实体卡--失败用例")
    public void cardManageServiceAddCardTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String userId,
            String nickName, String mobile,
            String registerFrom, String cardNo,
            AddCardOrder order
    ) {
        // 清除数据
        // 准备数据
        //商户
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商户", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "18825814769", "ABLE");
        //实体卡
        gasMerchantInitDataBase.initGasMerchantCard(partnerId, 1L, "Admin", cardNo,
                null, null, null);
        //会员
        Map<String, Object> params = gasUserInitDataBase.initUser(partnerId, userId, null, nickName, mobile,
                registerFrom,
                null, null, null, null, null, null);
        String accountNo = params.get("accountNo").toString();
        if (testId == 1003) {
            userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, cardNo, OID.newID(),
                    null, CardType.ENTITY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                    OID.newID(), CardStatus.NORMAL.code(), null, null);
        }
        // 测试过程
        if (testId != 1002) {
            order.setCardNo(cardNo);
        }
        // 调用接口
        SimpleResult result = cardManageService.addCard(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
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

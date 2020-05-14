package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.*;
import com.xyb.gas.merchant.api.facade.UserLoginService;
import com.xyb.gas.merchant.api.info.UserWorkStatisticsInfo;
import com.xyb.gas.merchant.api.info.printinfo.OperatorWorkFavourInfo;
import com.xyb.gas.merchant.api.info.printinfo.OperatorWorkGoodsInfo;
import com.xyb.gas.merchant.api.info.printinfo.OperatorWorkOilInfo;
import com.xyb.gas.merchant.api.info.printinfo.OperatorWorkTradeInfo;
import com.xyb.gas.merchant.api.order.UserLogoutPosOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/01/03.
 */
public class UserLoginServiceLogoutPosTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserLoginService userLoginService;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLogoutPosTestSuccess.csv")
    @DisplayName("登出pos机--成功用例")
    public void userLoginServiceLogoutPosTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String model,
            String merchantStatus, String account,
            String password, String operatorMobile,
            String goodsCode, String goodsName,
            String goodsCode1, String goodsName1,
            //订单
            String depositBizNo, String depositBizNo1,
            String depositBizNo2, String backBizNo,
            String tradeNo, String tradeNo1,
            String tradeNo2, String bizNo,
            UserLogoutPosOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantResourceByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantDeviceByDeviceCode(order.getDeviceCode());
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasTradeOrderByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradeOilByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradeFavourByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradePointsRedeemByPartnerId(partnerId);
        silverboltTestBase.cleanGasTerminalLoginByPartnerId(partnerId);
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date logoutTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, -55, 0);
        Date loginTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        Date depositTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, -50, 0);
        Date depositTime1 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, -40, 0);
        Date depositTime2 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, -30, 0);
        Date depositBackTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, -25, 0);
        Date paymentTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, -33, 0);
        Date paymentTime1 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, -25, 0);
        Date paymentTime2 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -2, 0, 0);
        Date refundTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, -10, 0);
        Date exchangeTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, -15, 0);
        //已经登录的收银员
        Map<String, Object> operator = gasMerchantInitDataBase.initPosGasRole(partnerId, mobile,
                sourceKey, model, merchantStatus, UserType.DEVICE.code(),
                UserStatus.NORMAL.code(), account, password, operatorMobile,
                order.getDeviceCode(), UserLoginStatus.login.code(), "1", goodsCode, goodsName);
        Long roleId = Long.valueOf(operator.get("roleId").toString());
        Long resourceId = Long.valueOf(operator.get("resourceId").toString());
        String operatorId = operator.get("userId").toString();
        String stationId = operator.get("stationId").toString();
        //登录
        gasMerchantTestBase.insertGasLoginLog(0L, "POS", operatorId, account, partnerId, partnerId,
                "自动化测试商家", stationId, "自动化测试油站",
                "用户名", order.getDeviceCode(), loginTime, null, loginTime, loginTime);
        //油品2
        gasMerchantTestBase.insertGasGoods(0L, GoodsType.OIL.code(), GoodsGroupType.GASOLINE.code(), null, goodsName1,
                goodsCode1, null, null
                , null, null, null, null);
        gasMerchantTestBase.insertGasMerchantGoods(0L, partnerId, partnerId, goodsName1, goodsCode1,
                GoodsType.OIL.code(), null, null, null,
                GoodsGroupType.GASOLINE.code(), null, null, "ABLE", null, null);
        silverboltTestBase.insertGasGoods(0L, GoodsType.OIL.code(), GoodsGroupType.GASOLINE.code(), null, goodsName1,
                goodsCode1, null, null, null);
        silverboltTestBase.insertGasMerchantGoods(0L, partnerId, goodsName1, goodsCode1, GoodsType.OIL.code()
                , null, null, "ABLE", null, null, null, null);
        gasMerchantTestBase.insertGasStationOilGun(0L, partnerId, partnerId, stationId, "2", goodsCode1,
                null, null, 2);
        //登录记录
        silverboltTestBase.insertGasTerminalLogin(0L, operatorId, partnerId, stationId, "自动化测试油站", account,
                "用户名", "POS", order.getDeviceCode(), loginTime, null, loginTime, loginTime);
        //充值
        silverboltTestBase.insertGasTradeOrder(0L, "DEPOSIT", null, depositBizNo, OID.newID(), GID.newGID(), null,
                partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301912261100092133", null, null, null, "NORMAL", "18825814733",
                "GRADE_COMMON", null, null, OID.newID(), "DUMMY",
                "DEFAULT", null, 2800L, null, null, null, null, null,
                null, null, OID.newID(), "CASH", "ACCOUNT", 1100L, 1100L,
                0L, 0L, 1100L, 0L, "充值订单", "success", "finished",
                depositTime, depositTime, depositTime, depositTime);
        silverboltTestBase.insertGasTradeOrder(0L, "DEPOSIT", null, depositBizNo2, OID.newID(), GID.newGID(), null,
                partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301910091700092082", null, null, null, "NORMAL", "18623562770",
                "GRADE_COMMON", null, null, OID.newID(), "DUMMY",
                "DEFAULT", null, 3500L, null, null, null, null, null,
                null, null, OID.newID(), "WECHAT", "KEY", 1100L, 1000L,
                100L, 0L, 1000L, 0L, "充值订单1", "success", "finished",
                depositTime1, depositTime1, depositTime1, depositTime1);
        //充退
        silverboltTestBase.insertGasTradeOrder(0L, "DEPOSIT", null, depositBizNo1, OID.newID(), GID.newGID(), null,
                partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301910081000092081", null, null, null, "NORMAL", "13389678497",
                "GRADE_COMMON", null, null, "1jwtkqzo8gs031hge7p8", "DUMMY",
                "DEFAULT", null, 2300L, null, null, null, null, null,
                null, null, OID.newID(), "CASH", "ACCOUNT", 1100L, 1000L,
                100L, 0L, 1000L, 0L, "充值订单2", "success", "refunded",
                depositTime2, depositTime2, depositTime2, depositBackTime);
        silverboltTestBase.insertGasTradeOrder(0L, "DEPOSIT_BACK", null, backBizNo, OID.newID(), GID.newGID(),
                depositBizNo1, partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301910081000092081", null, null, null, "NORMAL", "13389678497",
                "GRADE_COMMON", null, null, "1jwtkqzo8gs031hge7p8", "DUMMY",
                "DEFAULT", null, 1200L, null, null, null, null, null,
                null, null, OID.newID(), "CASH", "ACCOUNT", 1100L, 1000L,
                100L, 0L, 1000L, 0L, "充值订单2充退", "success", "finished",
                depositBackTime, depositBackTime, depositBackTime, depositBackTime);
        //付款
        silverboltTestBase.insertGasTradeOrder(0L, "PAYMENT", "OIL", tradeNo, OID.newID(), GID.newGID(), null,
                partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                null, null, null, null, null, null,
                "GRADE_COMMON", null, null, null, null,
                null, null, null, "GASOLINE", goodsCode, goodsName, 30000L, 0L,
                0L, 0L, OID.newID(), "CASH", "ACCOUNT", 30000L, 30000L,
                0L, 0L, 30000L, 0L, "付款订单", "success", "finished",
                paymentTime, paymentTime, paymentTime, paymentTime);
        silverboltTestBase.insertGasTradeOrder(0L, "PAYMENT", "OIL", tradeNo1, OID.newID(), GID.newGID(), null,
                partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301910081000092081", null, null, null, "NORMAL", "13389678497",
                "GRADE_COMMON", null, null, "1jwtkqzo8gs031hge7p8", "DUMMY",
                "DEFAULT", null, null, "GASOLINE", goodsCode, goodsName, 30000L, 1700L,
                0L, 0L, OID.newID(), "WECHAT", "PUBLIC", 30000L, 28300L,
                1700L, 0L, 28300L, 0L, "付款订单1", "success", "finished",
                paymentTime1, paymentTime1, paymentTime1, paymentTime1);
        //退款
        silverboltTestBase.insertGasTradeOrder(0L, "PAYMENT", "OIL", tradeNo2, OID.newID(), GID.newGID(), null,
                partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301910081000092081", null, null, null, "NORMAL", "13389678497",
                "GRADE_COMMON", null, null, "1jwtkqzo8gs031hge7p8", "DUMMY",
                "DEFAULT", null, null, "GASOLINE", goodsCode1, goodsName1, 10000L, 2000L,
                0L, 0L, OID.newID(), "CASH", "ACCOUNT", 10000L, 8000L,
                2000L, 0L, 8000L, 0L, "付款订单2", "success", "refunded",
                paymentTime2, paymentTime2, paymentTime2, refundTime);
        silverboltTestBase.insertGasTradeOrder(0L, "REFUND", "OIL", bizNo, OID.newID(), GID.newGID(), tradeNo2,
                partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301910081000092081", null, null, null, "NORMAL", "13389678497",
                "GRADE_COMMON", null, null, "1jwtkqzo8gs031hge7p8", "DUMMY",
                "DEFAULT", null, null, "GASOLINE", goodsCode1, goodsName1, 10000L, 2000L,
                0L, 0L, OID.newID(), "CASH", "ACCOUNT", 10000L, 8000L,
                2000L, 0L, 8000L, 0L, "退款订单", "success", "finished",
                refundTime, refundTime, refundTime, refundTime);
        //油品
        silverboltTestBase.insertGasTradeOil(0L, tradeNo, "PAYMENT", null, partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                null, null, null, null, null,
                null, "GRADE_COMMON", null, null,
                null, null, "GASOLINE", goodsCode, goodsName, 800L, 750L,
                40.0, "1", 30000L, 0L, "CASH", "ACCOUNT",
                "success", "finished", paymentTime, paymentTime, paymentTime, paymentTime);
        silverboltTestBase.insertGasTradeOil(0L, tradeNo1, "PAYMENT", null, partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301910081000092081", null, null, null, "NORMAL", "13389678497",
                "GRADE_COMMON", null, null, "1jwtkqzo8gs031hge7p8", null,
                "GASOLINE", goodsCode, goodsName, 800L, 750L,
                13.33, "1", 10000L, 2000L, "CASH", "ACCOUNT",
                "success", "finished", paymentTime1, paymentTime1, paymentTime1, paymentTime1);
        silverboltTestBase.insertGasTradeOil(0L, tradeNo2, "PAYMENT", null, partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301910081000092081", null, null, null, "NORMAL", "13389678497",
                "GRADE_COMMON", null, null,
                "1jwtkqzo8gs031hge7p8", null, "GASOLINE", goodsCode1, goodsName1, 810L, 800L,
                12.5, "2", 10000L, 2000L, "CASH", "ACCOUNT",
                "success", "refunded", paymentTime2, paymentTime2, paymentTime2, refundTime);
        silverboltTestBase.insertGasTradeOil(0L, bizNo, "REFUND", tradeNo2, partnerId, "自动化测试商家", stationId,
                "test001", "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(),
                "S0301910081000092081", null, null, null, "NORMAL", "13389678497",
                "GRADE_COMMON", null, null,
                "1jwtkqzo8gs031hge7p8", null, "GASOLINE", goodsCode1, goodsName1, 810L, 800L,
                12.5, "2", 10000L, 2000L, "CASH", "ACCOUNT",
                "success", "finished", refundTime, refundTime, refundTime, refundTime);
        //优惠
        silverboltTestBase.insertGasTradeFavour(0L, tradeNo1, "PAYMENT", null, partnerId, "自动化测试商家", stationId,
                "test001",
                "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(), "S0301910081000092081", null,
                null, "NORMAL", "13389678497", "1jwtkqzo8gs031hge7p8", "CASH", "ACCOUNT", "1jmA4cdobss101hge96i",
                OID.newID(), "新优惠券2", "GAS", "COUPON_FAVOUR", "OVER", null, 200L,
                "success", "finished", paymentTime1, paymentTime1, paymentTime1, paymentTime1);
        silverboltTestBase.insertGasTradeFavour(0L, tradeNo1, "PAYMENT", null, partnerId, "自动化测试商家", stationId,
                "test001",
                "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(), "S0301910081000092081", null,
                null, "NORMAL", "13389678497", "1jwtkqzo8gs031hge7p8", "CASH", "ACCOUNT", null,
                "1jod2umvmgg041hge6uy", "会员活动日", "GAS", "CAMPAIGN_FAVOUR", "fullReduce", null, 1500L,
                "success", "finished", paymentTime1, paymentTime1, paymentTime1, paymentTime1);
        silverboltTestBase.insertGasTradeFavour(0L, tradeNo2, "PAYMENT", null, partnerId, "自动化测试商家", stationId,
                "test001",
                "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(), "S0301910081000092081", null,
                null, "NORMAL", "13389678497", "1jwtkqzo8gs031hge7p8", "CASH", "ACCOUNT", "1jmA4ba33gs101hge96i",
                OID.newID(), "新优惠券1", "GAS", "COUPON_FAVOUR", "OVER", null, 500L,
                "success", "refunded", paymentTime2, paymentTime2, paymentTime2, refundTime);
        silverboltTestBase.insertGasTradeFavour(0L, tradeNo2, "PAYMENT", null, partnerId, "自动化测试商家", stationId,
                "test001",
                "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(), "S0301910081000092081", null,
                null, "NORMAL", "13389678497", "1jwtkqzo8gs031hge7p8", "CASH", "ACCOUNT", null,
                "1jod2umvmgg041hge6uy", "会员活动日", "GAS", "CAMPAIGN_FAVOUR", "fullReduce", null, 1500L,
                "success", "refunded", paymentTime2, paymentTime2, paymentTime2, refundTime);
        silverboltTestBase.insertGasTradeFavour(0L, bizNo, "REFUND", tradeNo2, partnerId, "自动化测试商家", stationId,
                "test001",
                "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(), "S0301910081000092081", null,
                null, "NORMAL", "13389678497", "1jwtkqzo8gs031hge7p8", "CASH", "ACCOUNT", "1jmA4ba33gs101hge96i",
                OID.newID(), "新优惠券1", "GAS", "COUPON_FAVOUR", "OVER", null, 500L,
                "success", "finished", refundTime, refundTime, refundTime, refundTime);
        silverboltTestBase.insertGasTradeFavour(0L, bizNo, "REFUND", tradeNo2, partnerId, "自动化测试商家", stationId,
                "test001",
                "自动化测试油站", operatorId, "用户名", "POS", order.getDeviceCode(), "S0301910081000092081", null,
                null, "NORMAL", "13389678497", "1jwtkqzo8gs031hge7p8", "CASH", "ACCOUNT", null,
                "1jod2umvmgg041hge6uy", "会员活动日", "GAS", "CAMPAIGN_FAVOUR", "fullReduce", null, 1500L,
                "success", "finished", refundTime, refundTime, refundTime, refundTime);
        //兑换
        silverboltTestBase.insertGasTradePointsRedeem(0L, OID.newID(), OID.newID(), GID.newGID(), partnerId, "自动化测试商家",
                stationId, "test001", null, operatorId, "用户名",
                "POS", order.getDeviceCode(), "S0301910251500092112", null, null,
                null, "18825814711", "1jr3r2x530g021hge6uv", "ENTITY", "充气娃娃",
                null, null, 1, "SELF", "金开大道互联网产业园13幢3楼",
                500, "积分兑换", "success", "finished", exchangeTime,
                exchangeTime, exchangeTime, exchangeTime);
        silverboltTestBase.insertGasTradePointsRedeem(0L, OID.newID(), OID.newID(), GID.newGID(), partnerId, "自动化测试商家",
                stationId, "test001", null, operatorId, "用户名",
                "POS", order.getDeviceCode(), "S0301910251500092112", null, null,
                null, "18825814711", "1jui9q51v0g021hge6uv", "ENTITY", "红豆大红豆",
                null, null, 1, "SELF", "金开大道互联网产业园13幢3楼",
                100, "积分兑换", "processing", "wait_cancel", exchangeTime,
                exchangeTime, exchangeTime, exchangeTime);

        silverboltTestBase.insertGasTradePointsRedeem(0L, OID.newID(), OID.newID(), GID.newGID(), partnerId, "自动化测试商家",
                stationId, "test001", null, operatorId, "用户名",
                "POS", order.getDeviceCode(), "S0301910081000092081", null, null,
                null, "13389678497", "1jr3r2x530g021hge6uv", "ENTITY", "充气娃娃",
                null, null, 1, "SELF", "金开大道互联网产业园13幢3楼",
                500, "积分兑换", "success", "finished", exchangeTime,
                exchangeTime, exchangeTime, exchangeTime);
        silverboltTestBase.insertGasTradePointsRedeem(0L, OID.newID(), OID.newID(), GID.newGID(), partnerId, "自动化测试商家",
                stationId, "test001", null, operatorId, "用户名",
                "POS", order.getDeviceCode(), "S0301910081000092081", null, null,
                null, "13389678497", "1jui9q51v0g021hge6uv", "ENTITY", "红豆大红豆",
                null, null, 1, "SELF", "金开大道互联网产业园13幢3楼",
                100, "积分兑换", "success", "finished", exchangeTime,
                exchangeTime, exchangeTime, exchangeTime);
        // 测试过程
        order.setUserId(operatorId);
        // 调用接口
        BizResult<UserWorkStatisticsInfo> result = userLoginService.signOutPos(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals("用户名", result.getInfo().getUserName());
        assertEquals("自动化测试油站", result.getInfo().getStationName());
        assertEquals("自动化测试商家", result.getInfo().getSupplierName());
        assertEquals(loginTime, result.getInfo().getLoginTime());
//        assertEquals(DateUtils.getSqlDate(), result.getInfo().getLogoutTime());
        List<OperatorWorkFavourInfo> favourInfoList = result.getInfo().getFavourInfoList();
        assertEquals(3, favourInfoList.size());
        List<String> favourNames = new ArrayList<>();
        for (OperatorWorkFavourInfo favourfo : favourInfoList) {
            favourNames.add(favourfo.getFavourName());
            if ("会员活动日".equals(favourfo.getFavourName())) {
                favourfoAssert(favourfo, "CAMPAIGN_FAVOUR",
                        "会员活动日", 0,
                        Money.zero());
            }
            if ("新优惠券1".equals(favourfo.getFavourName())) {
                favourfoAssert(favourfo, "COUPON_FAVOUR",
                        "新优惠券1", -1,
                        new Money(-5, 0));
            }
            if ("新优惠券2".equals(favourfo.getFavourName())) {
                favourfoAssert(favourfo, "COUPON_FAVOUR",
                        "新优惠券2", 1,
                        new Money(2, 0));
            }
        }

        assertTrue(favourNames.contains("会员活动日"));
        assertTrue(favourNames.contains("新优惠券1"));
        assertTrue(favourNames.contains("新优惠券2"));

        List<OperatorWorkGoodsInfo> goodsInfoList = result.getInfo().getGoodsInfoList();
        assertEquals(0, goodsInfoList.size());

        List<OperatorWorkOilInfo> oilInfoList = result.getInfo().getOilInfoList();
        assertEquals(2, oilInfoList.size());
        List<String> oilNames = new ArrayList<>();
        for (
                OperatorWorkOilInfo oilInfo : oilInfoList) {
            oilNames.add(oilInfo.getOilName());
            if (goodsName.equals(oilInfo.getOilName())) {
                oilInfoAssert(oilInfo, goodsName, 2l,
                        53.33, new Money(400, 0));
            }
            if (goodsName1.equals(oilInfo.getOilName())) {
                oilInfoAssert(oilInfo, goodsName1, -1l,
                        -12.5, new Money(-100, 0));
            }
        }

        assertTrue(oilNames.contains(goodsName));
        assertTrue(oilNames.contains(goodsName1));

        List<OperatorWorkTradeInfo> tradeInfoList = result.getInfo().getTradeInfoList();
        assertEquals(2, tradeInfoList.size());
        List<String> paymentTypes = new ArrayList<>();
        for (
                OperatorWorkTradeInfo paymentInfo : tradeInfoList) {
            paymentTypes.add(paymentInfo.getTradePayType());
            if ("CASH".equals(paymentInfo.getTradePayType())) {
                paymentInfoAssert(paymentInfo, "CASH",
                        new Money(300, 0), new Money(100, 0),
                        new Money(-20, 0), new Money(220, 0), 1l);
            }
            if ("WECHAT".equals(paymentInfo.getTradePayType())) {
                paymentInfoAssert(paymentInfo, "WECHAT", new Money(300, 0),
                        new Money(0, 0), new Money(17, 0),
                        new Money(283, 0), 1l);
            }
        }
        assertTrue(paymentTypes.contains("WECHAT"));
        assertTrue(paymentTypes.contains("CASH"));

        List<OperatorWorkTradeInfo> depositInfoList = result.getInfo().getDepositInfoList();
        assertEquals(2, depositInfoList.size());
        List<String> depositTypes = new ArrayList<>();
        for (
                OperatorWorkTradeInfo depositInfo : depositInfoList) {
            depositTypes.add(depositInfo.getTradePayType());
            if ("WECHAT".equals(depositInfo.getTradePayType())) {
                paymentInfoAssert(depositInfo, "WECHAT",
                        new Money(22, 0), new Money(11, 0),
                        new Money(0, 0), new Money(11, 0), 1l);
            }
            if ("CASH".equals(depositInfo.getTradePayType())) {
                paymentInfoAssert(depositInfo, "CASH", new Money(11, 0),
                        new Money(0, 0), new Money(10, 0),
                        new Money(1, 0), 2l);
            }
        }
        assertTrue(depositTypes.contains("WECHAT"));
        assertTrue(depositTypes.contains("CASH"));

        List<OperatorWorkGoodsInfo> redeemGoodsInfoList = result.getInfo().getRedeemGoodsInfoList();
        assertEquals(2, redeemGoodsInfoList.size());
        List<String> goodsNames = new ArrayList<>();
        for (
                OperatorWorkGoodsInfo redeemGoods : redeemGoodsInfoList) {
            goodsNames.add(redeemGoods.getGoodsName());
            if ("充气娃娃".equals(redeemGoods.getGoodsName())) {
                cancleInfoAssert(redeemGoods, "充气娃娃", 2, null);
            }
            if ("红豆大红豆".equals(redeemGoods.getGoodsName())) {
                cancleInfoAssert(redeemGoods, "红豆大红豆", 1, null);
            }
        }
        assertTrue(goodsNames.contains("充气娃娃"));
        assertTrue(goodsNames.contains("红豆大红豆"));

        List<OperatorWorkGoodsInfo> goodsFavourList = result.getInfo().getGoodsFavourList();
        assertEquals(0, goodsFavourList.size());

        List<OperatorWorkGoodsInfo> oilFavourList = result.getInfo().getOilFavourList();
        assertEquals(2, oilFavourList.size());
        List<String> oilNames1 = new ArrayList<>();
        for (
                OperatorWorkGoodsInfo oilFavour : oilFavourList) {
            oilNames1.add(oilFavour.getGoodsName());
            if (goodsName.equals(oilFavour.getGoodsName())) {
                cancleInfoAssert(oilFavour, goodsName, 1, new Money(20, 0));
            }
            if (goodsName1.equals(oilFavour.getGoodsName())) {
                cancleInfoAssert(oilFavour, goodsName1, -1, new Money(-20, 0));
            }
        }
        assertTrue(oilNames1.contains(goodsName));
        assertTrue(oilNames1.contains(goodsName1));
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByRoleId(roleId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasDeviceResourceById(resourceId);
        gasMerchantTestBase.cleanGasMerchantResourceByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasStationOilGunByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByDeviceCode(order.getDeviceCode());
        gasMerchantTestBase.cleanGasLoginLogByUserId(operatorId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasTradeOrderByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradeOilByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradeFavourByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradePointsRedeemByPartnerId(partnerId);
        silverboltTestBase.cleanGasTerminalLoginByUserId(operatorId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLogoutPosTestFailOne.csv")
    @DisplayName("登出pos机--参数非法")
    public void userLoginServiceLogoutPosTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            UserLogoutPosOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setUserId(null);
        }
        if (testId == 1002) {
            order.setDeviceCode(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizResult<UserWorkStatisticsInfo> result = userLoginService.signOutPos(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.商户不存在
     * 1002.收银员不存在
     * 1003.pos机不存在
     * 1004.账号已经登出
     */
    @AutoTest(file = "gas_merchant/userLoginServiceLogoutPosTestFailTwo.csv")
    @DisplayName("登出pos机--失败用例")
    public void userLoginServiceLogoutPosTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String mobile,
            String sourceKey, String model,
            String merchantStatus, String account,
            String password, String operatorMobile,
            String goodsCode, String goodsName,
            String goodsCode1, String goodsName1,
            String deviceCode,
            UserLogoutPosOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantResourceByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantDeviceByDeviceCode(order.getDeviceCode());
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasTradeOrderByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradeOilByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradeFavourByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradePointsRedeemByPartnerId(partnerId);
        silverboltTestBase.cleanGasTerminalLoginByPartnerId(partnerId);
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date loginTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        //已经登录的收银员
        Map<String, Object> operator = gasMerchantInitDataBase.initPosGasRole(partnerId, mobile,
                sourceKey, model, merchantStatus, UserType.DEVICE.code(),
                UserStatus.NORMAL.code(), account, password, operatorMobile,
                deviceCode, UserLoginStatus.login.code(), "1", goodsCode, goodsName);
        Long roleId = Long.valueOf(operator.get("roleId").toString());
        Long resourceId = Long.valueOf(operator.get("resourceId").toString());
        String operatorId = operator.get("userId").toString();
        String stationId = operator.get("stationId").toString();
        //登录
        if (testId != 1004) {
            gasMerchantTestBase.insertGasLoginLog(0L, "POS", operatorId, account, partnerId, partnerId,
                    "自动化测试商家", stationId, "自动化测试油站",
                    "用户名", deviceCode, loginTime, null, loginTime, loginTime);
        }
        //油品2
        gasMerchantTestBase.insertGasGoods(0L, GoodsType.OIL.code(), GoodsGroupType.GASOLINE.code(), null, goodsName1,
                goodsCode1, null, null
                , null, null, null, null);
        gasMerchantTestBase.insertGasMerchantGoods(0L, partnerId, partnerId, goodsName1, goodsCode1,
                GoodsType.OIL.code(), null, null, null,
                GoodsGroupType.GASOLINE.code(), null, null, "ABLE", null, null);
        silverboltTestBase.insertGasGoods(0L, GoodsType.OIL.code(), GoodsGroupType.GASOLINE.code(), null, goodsName1,
                goodsCode1, null, null, null);
        silverboltTestBase.insertGasMerchantGoods(0L, partnerId, goodsName1, goodsCode1, GoodsType.OIL.code()
                , null, null, "ABLE", null, null, null, null);
        gasMerchantTestBase.insertGasStationOilGun(0L, partnerId, partnerId, stationId, "2", goodsCode1,
                null, null, 2);
        // 测试过程
        if (testId != 1002) {
            order.setUserId(operatorId);
        }
        if (testId != 1003) {
            order.setDeviceCode(deviceCode);
        }
        // 调用接口
        BizResult<UserWorkStatisticsInfo> result = userLoginService.signOutPos(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantRoleByRoleId(roleId);
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasDeviceResourceById(resourceId);
        gasMerchantTestBase.cleanGasMerchantResourceByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantStationByStationId(stationId);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasStationOilGunByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        gasMerchantTestBase.cleanGasMerchantDeviceByDeviceCode(order.getDeviceCode());
        gasMerchantTestBase.cleanGasLoginLogByUserId(operatorId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.cleanGasTradeOrderByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradeOilByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradeFavourByPartnerId(partnerId);
        silverboltTestBase.cleanGasTradePointsRedeemByPartnerId(partnerId);
        silverboltTestBase.cleanGasTerminalLoginByUserId(operatorId);
    }

    /**
     * 优惠信息
     */
    private void favourfoAssert(
            OperatorWorkFavourInfo favourfo,
            String favourType,
            String favourName,
            long favourCount,
            Money favourAmount
    ) {
        assertEquals(favourName, favourfo.getFavourName());
        assertEquals(favourType, favourfo.getFavourType());
        assertEquals(favourCount, favourfo.getFavourCount());
        assertEquals(favourAmount, favourfo.getFavourAmount());
    }

    /**
     * 油品信息
     */
    private void oilInfoAssert(
            OperatorWorkOilInfo oil,
            String oilName,
            long oilCount,
            double oilLiter,
            Money oilAmount
    ) {
        assertEquals(oilName, oil.getOilName());
        assertEquals(oilCount, oil.getOilCount());
        assertEquals(oilLiter, oil.getOilLiter());
        assertEquals(oilAmount, oil.getOilAmount());
    }

    /**
     * 交易信息
     */
    private void paymentInfoAssert(
            OperatorWorkTradeInfo payment,
            String tradePayType,
            Money orderAmount,
            Money refundAmount,
            Money favourAmount,
            Money payAmount,
            Long tradeTypeCount
    ) {
        assertEquals(tradePayType, payment.getTradePayType());
        assertEquals(orderAmount, payment.getOrderAmount());
        assertEquals(refundAmount, payment.getRefundAmount());
        assertEquals(favourAmount, payment.getFavourAmount());
        assertEquals(payAmount, payment.getPayAmount());
        assertEquals(tradeTypeCount, payment.getTradeTypeCount());
    }

    /**
     * 核销信息
     */
    private void cancleInfoAssert(
            OperatorWorkGoodsInfo favour,
            String goodsName,
            long goodsCount,
            Money goodsAmount
    ) {
        assertEquals(goodsName, favour.getGoodsName());
        assertEquals(goodsCount, favour.getGoodsCount());
        assertEquals(goodsAmount, favour.getGoodsAmount());
    }
}

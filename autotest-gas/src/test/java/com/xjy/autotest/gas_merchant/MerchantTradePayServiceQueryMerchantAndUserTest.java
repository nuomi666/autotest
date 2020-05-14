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
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.CollectionModel;
import com.xyb.gas.merchant.api.enums.SourceType;
import com.xyb.gas.merchant.api.enums.UserStatus;
import com.xyb.gas.merchant.api.enums.UserType;
import com.xyb.gas.merchant.api.facade.MerchantTradePayService;
import com.xyb.gas.merchant.api.info.MerchantAndUserInfo;
import com.xyb.gas.merchant.api.info.MerchantInfo;
import com.xyb.gas.merchant.api.info.MerchantUserInfo;
import com.xyb.gas.merchant.api.order.QueryMerchantAndUserOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author nuomi
 * Created on 2019/12/18.
 */
public class MerchantTradePayServiceQueryMerchantAndUserTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantTradePayService merchantTradePayService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 场景：商户平台交易
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantTradePayServiceQueryMerchantAndUserTestSuccess.csv")
    @DisplayName("验证并获取商户及用户信息--成功用例")
    public void merchantTradePayServiceQueryMerchantAndUserTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerName,
            String shortName, String mobile,
            String sourceKey, String merchantStatus,
            String userId, String userName,
            UserType userType,
            QueryMerchantAndUserOrder order
    ) {
        // 清除数据
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
        Date lastLoginTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        Date lastLoginSuccessTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -3, 0, 0);
        Date lastLogOutTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        //商家信息
        gasMerchantInitDataBase.initGasMerchants(partnerId, null, partnerName, null, shortName, null, mobile, null,
                sourceKey, null, merchantStatus, null, "Merchant", null, rawAddTime, null);
        //操作员信息
        gasMerchantInitDataBase.initGasMerchantUserWithTime(partnerId, userId, userName, OID.newID(), userType.code(),
                mobile, "123456", "nuomi", lastLoginTime, lastLoginSuccessTime, lastLogOutTime);
        // 测试过程
        order.setUserId(userId);
        // 调用接口
        BizResult<MerchantAndUserInfo> result = merchantTradePayService.queryMerchantAndUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        MerchantInfo merchant = result.getInfo().getMerchantInfo();
        MerchantUserInfo merchantUser = result.getInfo().getMerchantUserInfo();
        //商家信息
        merchantAssert(merchant, partnerId, partnerName, shortName,
                mobile, "1jc7w1m29ks031hge7p8", "001iys5hlniks541g00",
                null, null, null,
                "0*60*60*1000+0*60*1000+0" + "*1000", "1",
                rawAddTime, SourceType.WeChat, sourceKey, false, null, CollectionModel.Merchant);
        //操作员信息
        merchantUserAssert(merchantUser, userId, userName,
                partnerId, mobile, "nuomi", lastLoginTime, lastLoginSuccessTime, lastLogOutTime);
        // 清除数据
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantUserByUserId(userId);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantTradePayServiceQueryMerchantAndUserTestFailOne.csv")
    @DisplayName("验证并获取商户及用户信息--参数非法")
    public void merchantTradePayServiceQueryMerchantAndUserTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantAndUserOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setUserId(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizResult<MerchantAndUserInfo> result = merchantTradePayService.queryMerchantAndUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.商家不存在
     * 1002.用户不存在
     * 1003.操作员不是该商户下的
     */
    @AutoTest(file = "gas_merchant/merchantTradePayServiceQueryMerchantAndUserTestFailTwo.csv")
    @DisplayName("验证并获取商户及用户信息--失败用例")
    public void merchantTradePayServiceQueryMerchantAndUserTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerId1, String partnerName,
            String shortName, String mobile,
            String sourceKey, String merchantStatus,
            String userId, String userName,
            UserType userType,
            QueryMerchantAndUserOrder order
    ) {
        // 清除数据
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date rawAddTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -3, -4, 0, 0);
        Date lastLoginTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        Date lastLoginSuccessTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -3, 0, 0);
        Date lastLogOutTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, -1, 0, 0);
        //商家信息
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchants(partnerId, null, partnerName, null, shortName, null, mobile, null,
                    sourceKey, null, merchantStatus, null, "Merchant", null, rawAddTime, null);
        }
        //操作员信息
        if (testId == 1003) {
            gasMerchantInitDataBase.initGasMerchantUserWithTime(partnerId1, userId, userName, OID.newID(),
                    userType.code(),
                    mobile, "123456", "nuomi", lastLoginTime, lastLoginSuccessTime, lastLogOutTime);
        } else {
            gasMerchantInitDataBase.initGasMerchantUserWithTime(partnerId, userId, userName, OID.newID(),
                    userType.code(),
                    mobile, "123456", "nuomi", lastLoginTime, lastLoginSuccessTime, lastLogOutTime);
        }
        // 测试过程
        if (testId != 1002) {
            order.setUserId(userId);
        }
        // 调用接口
        BizResult<MerchantAndUserInfo> result = merchantTradePayService.queryMerchantAndUser(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId1);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantUserByUserId(userId);
        silverboltTestBase.cleanGasMerchantUserByUserId(userId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId);
    }

    /**
     * 商户信息
     */
    private void merchantAssert(MerchantInfo merchant,
                                String platPartnerId,
                                String partnerName,
                                String shortName,
                                String mobileNo,
                                String accountNo,
                                String marketAccountNo,
                                String email,
                                String headImgUrl,
                                Date queryDepth,
                                String dayTime,
                                String monthTime,
                                Date rawAddTime,
                                SourceType sourceType,
                                String sourceKey,
                                boolean authorized,
                                String authorizerRefreshToken,
                                CollectionModel collectionModel
    ) {
        assertEquals(platPartnerId, merchant.getPlatPartnerId());//开发没返回
        assertEquals(platPartnerId, merchant.getPartnerId());
        assertEquals(partnerName, merchant.getPartnerName());
        assertEquals(shortName, merchant.getShortName());
        assertEquals(mobileNo, merchant.getMobileNo());
        assertEquals(accountNo, merchant.getAccountNo());
        assertEquals(marketAccountNo, merchant.getMarketAccountNo());
        assertEquals("ABLE", merchant.getStatus().code());
        assertEquals(email, merchant.getEmail());
        assertEquals(headImgUrl, merchant.getHeadImgUrl());
        assertEquals(queryDepth, merchant.getQueryDepth());
        assertEquals(dayTime, merchant.getDayTime());
        assertEquals(monthTime, merchant.getMonthTime());
        assertEquals(rawAddTime, merchant.getRawAddTime());
        assertEquals(sourceKey, merchant.getSourceKey());
        assertEquals(sourceType, merchant.getSourceType());
        assertEquals(authorized, merchant.isAuthorized());
        assertEquals(authorizerRefreshToken, merchant.getAuthorizerRefreshToken());
        assertEquals(collectionModel, merchant.getCollectionModel());
    }

    /**
     * 操作员信息
     */
    private void merchantUserAssert(MerchantUserInfo merchantUser,
                                    String userId,
                                    String userName,
                                    String partnerId,
                                    String mobileNo,
                                    String account,
                                    Date lastLoginTime,
                                    Date lastLoginSuccessTime,
                                    Date lastLogoutSuccessTime
    ) {
        assertEquals(userId, merchantUser.getUserId());
        assertEquals(userName, merchantUser.getUserName());
        assertEquals(partnerId, merchantUser.getPlatPartnerId());
        assertEquals(partnerId, merchantUser.getPartnerId());
        assertEquals(mobileNo, merchantUser.getMobileNo());
        assertEquals(account, merchantUser.getAccount());
        assertEquals(UserStatus.NORMAL, merchantUser.getStatus());
        assertEquals(5, merchantUser.getLoginErrorLimit());
        assertEquals(0, merchantUser.getLoginErrorCount());
        assertEquals(lastLoginTime, merchantUser.getLastLoginTime());
        assertEquals(lastLoginSuccessTime, merchantUser.getLastLoginSuccessTime());
        assertEquals(lastLogoutSuccessTime, merchantUser.getLastLogoutSuccessTime());
    }
}

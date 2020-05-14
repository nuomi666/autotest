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
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.gas.merchant.api.enums.SourceType;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.order.RegisterMerchantOrder;
import com.xyb.gas.merchant.api.result.RegisterMerchantResult;
import com.xyb.user.api.enums.AccountType;
import dal.model.gas_merchant.GasMerchantDO;
import dal.model.gas_merchant.GasMerchantSourceDataDO;
import dal.model.merchant.MerchantInfoDO;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/08/06.
 */
public class MerchantServiceRegisterTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    UserTestBase userTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 商家模式：商家下的油站不具有独立收银功能；商家油站模式：商家下的油站具有独立收银功能，油站相当于一个签约商
     * 1001只填入必填选项,新增的商家的为商家模式
     * 1002填入所有参数,新增的商家的为商家油站模式
     */
    @AutoTest(file = "gas_merchant/merchantServiceRegisterTestSuccess.csv")
    @DisplayName("商户注册--成功用例")
    public void merchantServiceRegisterTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RegisterMerchantOrder registerMerchantOrder
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantByPartnerName(registerMerchantOrder.getPartnerName());
        merchantTestBase.cleanGasMerchantSourceDataBySourceTypeAndSourceKey("WeChat",
                registerMerchantOrder.getSourceKey());
        silverboltTestBase.cleanGasMerchantByPartnerName(registerMerchantOrder.getPartnerName());
        // 准备数据
        // 测试过程
        registerMerchantOrder.setGid(GID.newGID());
        // 调用接口
        RegisterMerchantResult result =
                merchantService.register(registerMerchantOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        //数据库校验
        //商户信息
        gasMerchantAssert(1, registerMerchantOrder.getPartnerName(),
                registerMerchantOrder.getShortName(),
                registerMerchantOrder.getMobileNo(),
                registerMerchantOrder.getEmail(),
                registerMerchantOrder.getStatus().code(),
                registerMerchantOrder.getHeadImgUrl(),
                registerMerchantOrder.getQueryDepth(),
                registerMerchantOrder.getCollectionModel().code());
        //商户来源信息
        gasMerchantSourceDataAssert(1, result.getInfo().getPartnerId(),
                registerMerchantOrder.getSourceKey());
        //清结算商户信息
        xybMerchantBypartnerId(result.getInfo().getPartnerId(),
                registerMerchantOrder.getPartnerName(), registerMerchantOrder.getShortName(),
                "PLATFORM");
        //资金账户
        accountByUserIdAssert(3, result.getInfo().getPartnerId(),
                result.getInfo().getAccountNo(),
                result.getInfo().getMarketAccountNo());
        sleep(2);
        //分析系统商户信息
        gasSilverboltMerchantAssert(1, registerMerchantOrder.getPartnerName()
                , registerMerchantOrder.getShortName(),
                registerMerchantOrder.getMobileNo(),
                registerMerchantOrder.getEmail(),
                registerMerchantOrder.getStatus().code(),
                registerMerchantOrder.getHeadImgUrl(),
                registerMerchantOrder.getQueryDepth());
        // 清除数据
        merchantTestBase.cleanGasMerchantByPartnerId(result.getInfo().getPartnerId());
        merchantTestBase.cleanGasMerchantSourceDataBySourceTypeAndSourceKey("WeChat",
                registerMerchantOrder.getSourceKey());
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(result.getInfo().getPartnerId());
        xybUserTestBase.cleanUserByUserId(result.getInfo().getPartnerId());
        userTestBase.cleanAccountByUserId(result.getInfo().getPartnerId());
        silverboltTestBase.cleanGasMerchantByPartnerId(result.getInfo().getPartnerId());
    }

    /**
     * 1001商户名为空
     * 1002商户简称为空
     * 1003商户来源标识为空
     * 1004统一流水号为空
     * 1005手机格式错误
     * 1006邮箱格式错误
     * 1007order为空
     * 1008商户模式为空
     */
    @AutoTest(file = "gas_merchant/merchantServiceRegisterTestFailOne.csv")
    @DisplayName("商户注册--参数非法")
    public void merchantServiceRegisterTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RegisterMerchantOrder registerMerchantOrder
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        registerMerchantOrder.setGid(GID.newGID());
        if (testId == 1001) {
            registerMerchantOrder.setPartnerName(null);
        }
        if (testId == 1002) {
            registerMerchantOrder.setShortName(null);
        }
        if (testId == 1003) {
            registerMerchantOrder.setSourceKey(null);
        }
        if (testId == 1004) {
            registerMerchantOrder.setGid(null);
        }
        if (testId == 1007) {
            registerMerchantOrder = null;
        }
        if (testId == 1008) {
            registerMerchantOrder.setCollectionModel(null);
        }
        // 调用接口
        RegisterMerchantResult result =
                merchantService.register(registerMerchantOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001商户名已存在
     * 1002商户来源标识已存在
     */
    @AutoTest(file = "gas_merchant/merchantServiceRegisterTestFailTwo.csv")
    @DisplayName("商户注册--失败用例")
    public void merchantServiceRegisterTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerName, String sourceKey,
            String shortName, String accountNo, String marketAccountNo,
            String mobile, String merchantStatus,
            RegisterMerchantOrder registerMerchantOrder
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantByPartnerName(registerMerchantOrder.getPartnerName());
        // 准备数据
        String poolAccountNo = "1jhb00i98ws031hge7p0";//资金池账户，没卵用
        gasMerchantInitDataBase.initGasMerchant(partnerId, partnerName,
                sourceKey, shortName, accountNo, marketAccountNo,
                poolAccountNo, "Merchant", mobile, merchantStatus);
        // 测试过程
        registerMerchantOrder.setGid(GID.newGID());
        // 调用接口
        RegisterMerchantResult result =
                merchantService.register(registerMerchantOrder);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId);
        userTestBase.cleanAccountByUserId(partnerId);
        merchantTestBase.cleanGasMerchantByPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
    }

    /**
     * 断言商家信息表
     *
     * @param count
     * @param partnerName
     * @param shortName
     * @param mobileNo
     * @param email
     * @param status
     * @param headImgUrl
     * @param queryDepth
     */
    private void gasMerchantAssert(
            int count,
            String partnerName,
            String shortName,
            String mobileNo,
            String email,
            String status,
            String headImgUrl,
            Date queryDepth,
            String model
    ) {
        List<GasMerchantDO> merchantInfos =
                merchantTestBase.findGasMerchantByPartnerName(partnerName);
        assertEquals(count, merchantInfos.size());
        for (GasMerchantDO merchantInfo : merchantInfos) {
            assertNotEquals(null, merchantInfo.getPartnerId());
            assertEquals(partnerName, merchantInfo.getPartnerName());
            assertEquals(shortName, merchantInfo.getShortName());
            assertEquals(mobileNo, merchantInfo.getMobileNo());
            assertEquals(email, merchantInfo.getEmail());
            assertNotEquals(null, merchantInfo.getAccountNo());
            assertNotEquals(null, merchantInfo.getMarketAccountNo());
            assertEquals(status, merchantInfo.getStatus());
            assertEquals(headImgUrl, merchantInfo.getHeadImgUrl());
            assertEquals(model, merchantInfo.getCollectionModel());
            if (queryDepth != null && DateUtils.formatDate(queryDepth) != "") {
                assertEquals(DateUtils.formatDate(queryDepth),
                        DateUtils.formatDate(merchantInfo.getQueryDepth()));
            } else {
                assertEquals(null, merchantInfo.getQueryDepth());
            }
            //刚注册的  创建时间等于更新时间？？
            assertEquals(merchantInfo.getRawAddTime(),
                    merchantInfo.getRawUpdateTime());
        }
    }

    /**
     * 断言清结算商户信息
     */
    private void xybMerchantBypartnerId(String partnerId,
                                        String partnerName, String shortName,
                                        String partnerType) {
        List<MerchantInfoDO> merchantInfos = xybMerchantTestBase.findMerchantInfoByPartnerId(partnerId);
        assertEquals(partnerId, merchantInfos.get(0).getPartnerId());
        assertEquals(null, merchantInfos.get(0).getPlatPartnerId());
        assertEquals(null, merchantInfos.get(0).getIndustryLine());
        assertEquals(null, merchantInfos.get(0).getOutPartnerId());
        assertEquals(partnerName, merchantInfos.get(0).getPartnerName());
        assertEquals(shortName, merchantInfos.get(0).getPartnerAbbrName());
        assertEquals(null, merchantInfos.get(0).getPartnerRegisterAddress());
        assertEquals("INSIDE", merchantInfos.get(0).getRegisterFrom());
        assertEquals(partnerType, merchantInfos.get(0).getPartnerType());
        assertEquals("ACTIVE", merchantInfos.get(0).getPartnerStatus());
//        assertEquals(realName, merchantInfos.get(0).getSecurityCode());
        assertEquals(null, merchantInfos.get(0).getOwnService());
        assertEquals("MD5", merchantInfos.get(0).getDigestType());
        assertEquals(DateUtil.dtSimpleFormat(merchantInfos.get(0).getRawAddTime()),
                DateUtil.dtSimpleFormat(merchantInfos.get(0).getRawUpdateTime()));
    }

    /**
     * 断言商户来源信息表
     *
     * @param count
     * @param partnerId
     * @param sourceKey
     */
    private void gasMerchantSourceDataAssert(
            int count,
            String partnerId,
            String sourceKey
    ) {
        List<GasMerchantSourceDataDO> SourceDataInfos =
                merchantTestBase.findGasMerchantSourceDataByPartnerId(partnerId);
        assertEquals(count, SourceDataInfos.size());
        for (GasMerchantSourceDataDO SourceDataInfo : SourceDataInfos) {
            assertEquals(partnerId, SourceDataInfo.getPartnerId());
            assertEquals(sourceKey, SourceDataInfo.getSourceKey());
            assertEquals(SourceType.WeChat.code(),
                    SourceDataInfo.getSourceType());
            //刚注册的  创建时间等于更新时间？？
            assertEquals(SourceDataInfo.getRawAddTime(),
                    SourceDataInfo.getRawUpdateTime());
            assertEquals(Byte.valueOf("0"), SourceDataInfo.getAuthorized());
            assertEquals(null, SourceDataInfo.getAuthorizerRefreshToken());
            assertEquals(null, SourceDataInfo.getAuthorizerAccessToken());
            assertEquals(null, SourceDataInfo.getAuthorizerAccessTokenTime());
            assertEquals(null, SourceDataInfo.getSourceInfo());
            assertEquals(null, SourceDataInfo.getFuncInfo());
        }
    }

    /**
     * 根据userId查询断言account表
     *
     * @param total
     * @param userId
     * @param accountNo
     * @param marcketAccountNo
     */
    private void accountByUserIdAssert(int total, String userId,
                                       String accountNo,
                                       String marcketAccountNo) {
        List<AccountDO> accountDOS = userTestBase.findAccountByUserId(userId);
        if (total <= 0) {
            return;
        }
        assertEquals(total, accountDOS.size());
        for (AccountDO accountDO : accountDOS) {
            assertEquals("S0301806081400000015", accountDO.getPlatPartnerId());
            assertEquals(userId, accountDO.getPartnerId());
            //基本不会有业务场景变化所以直接校验--------------------------------------------------------------------------------
            assertNotNull(accountDO.getId());
            //初始化的账户属性值
            assertEquals(null, accountDO.getBandAccountNo());
            assertEquals(0L, accountDO.getBalance());
            assertEquals(0L, accountDO.getFreezeBalance());
            assertEquals(0L, accountDO.getCreditAmount());
            assertEquals(0L, accountDO.getHisInAmount());
            assertEquals(0L, accountDO.getHisOutAmount());
            assertEquals("111", accountDO.getPayModel());
            assertEquals("ACTIVE", accountDO.getStatus());
//            assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil
//            .dtSimpleFormat(accountDO.getRawUpdateTime()));
//            assertEquals(DateUtil.dtSimpleFormat(DateUtil.now()), DateUtil
//            .dtSimpleFormat(accountDO.getRawAddTime()));
            if (accountNo.equals(accountDO.getAccountNo())) {
                assertEquals(accountNo, accountDO.getTag());
                assertEquals(null, accountDO.getMemo());
                assertEquals(AccountType.NORMAL.code(),
                        accountDO.getAccountType());
            } else if (marcketAccountNo.equals(accountDO.getAccountNo())) {
                assertEquals("gas_merchant_market_account_tag",
                        accountDO.getTag());
                assertEquals("营销账号", accountDO.getMemo());
                assertEquals(AccountType.NORMAL.code(),
                        accountDO.getAccountType());
            } else {//营销池账户
                assertEquals("POOL", accountDO.getTag());
                assertEquals(null, accountDO.getMemo());
                assertEquals(AccountType.POOL.code(),
                        accountDO.getAccountType());
            }
        }
    }

    /**
     * 断言商家信息表
     *
     * @param count
     * @param partnerName
     * @param shortName
     * @param mobileNo
     * @param email
     * @param status
     * @param headImgUrl
     * @param queryDepth
     */
    private void gasSilverboltMerchantAssert(
            int count,
            String partnerName,
            String shortName,
            String mobileNo,
            String email,
            String status,
            String headImgUrl,
            Date queryDepth
    ) {
        List<dal.model.gas_silverbolt.GasMerchantDO> merchantInfos =
                silverboltTestBase.findGasMerchantByPartnerName(partnerName);
        assertEquals(count, merchantInfos.size());
        for (dal.model.gas_silverbolt.GasMerchantDO merchantInfo :
                merchantInfos) {
            assertNotEquals(null, merchantInfo.getPartnerId());
            assertEquals(partnerName, merchantInfo.getPartnerName());
            assertEquals(shortName, merchantInfo.getShortName());
            assertEquals(mobileNo, merchantInfo.getMobileNo());
            assertEquals(email, merchantInfo.getEmail());
            assertNotEquals(null, merchantInfo.getAccountNo());
            assertNotEquals(null, merchantInfo.getMarketAccountNo());
            assertEquals(status, merchantInfo.getStatus());
            assertEquals(headImgUrl, merchantInfo.getHeadImgUrl());
            if (queryDepth != null && DateUtils.formatDate(queryDepth) != "") {
                assertEquals(DateUtils.formatDate(queryDepth),
                        DateUtils.formatDate(merchantInfo.getQueryDepth()));
            } else {
                assertEquals(null, merchantInfo.getQueryDepth());
            }
            //刚注册的  创建时间等于更新时间？？
            assertEquals(merchantInfo.getRawAddTime(),
                    merchantInfo.getRawUpdateTime());
        }
    }
}

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
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.gas.merchant.api.enums.SourceType;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.order.UpdMerchantOrder;
import dal.model.gas_merchant.GasMerchantDO;
import dal.model.gas_merchant.GasMerchantSourceDataDO;
import dal.model.merchant.MerchantInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class MerchantServiceUpdateTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

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
     * 修改实现的逻辑是：根据传入的商户号修改商户信息，传入空则修改为空，若不想修改则入参需要传入跟原来的值一样,目前不支持修改商家模式
     * 1001不做任何修改
     * 1002只传必填项，其他为空
     * 1003传入所有参数
     */
    @AutoTest(file = "gas_merchant/merchantServiceUpdateTestSuccess.csv")
    @DisplayName("修改商户信息--成功用例")
    public void merchantServiceUpdateTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerId1,
            String partnerName, String partnerName1,
            String shortName, String shortName1,
            String mobile, String mobile1,
            String sourceKey, String sourceKey1,
            String merchantStatus, String merchantStatus1,
            Date rawAddTime, Date rawUpdateTime,
            UpdMerchantOrder order
    ) {
        // 清除数据

        // 准备数据
        //资金账号
        String accountNo = "1jc7w1m29ks031hge7p8";
        String marketAccountNo = "001iys5hlniks541g00";
        String accountNo1 = "1jc81da19gs031hge7p8";
        String marketAccountNo1 = "001iys5hlniks0368h00";
        gasMerchantInitDataBase.initGasMerchants(partnerId, partnerId1, partnerName, partnerName1, shortName,
                shortName1, mobile, mobile1, sourceKey, sourceKey1, merchantStatus, merchantStatus1, "Merchant",
                "Merchant", rawAddTime, rawUpdateTime);
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantService.update(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        //商户信息
        gasMerchantAssert(1, order.getPartnerId(), order.getPartnerName(), order.getShortName(), order.getMobileNo(),
                order.getEmail(), accountNo, marketAccountNo, order.getStatus().code(), order.getHeadImgUrl(),
                order.getQueryDepth(), rawAddTime, rawUpdateTime);
        //商户来源信息
        gasMerchantSourceDataAssert(1, order.getPartnerId(), order.getSourceKey(), rawAddTime, rawUpdateTime);
        //清结算商户信息
        xybMerchantBypartnerId(order.getPartnerId(), order.getPartnerName(), order.getShortName(),
                "PLATFORM", rawAddTime, rawUpdateTime);
        //分析系统商户信息
        gasSilverboltMerchantAssert(1, order.getPartnerName(), order.getShortName(), order.getMobileNo(),
                order.getEmail(), order.getStatus().code(), order.getHeadImgUrl(), order.getQueryDepth());
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPartnerId(partnerId1);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(partnerId1);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId1);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId1);
        userTestBase.cleanAccountByAccountNo(accountNo);
        userTestBase.cleanAccountByAccountNo(marketAccountNo);
        userTestBase.cleanAccountByAccountNo(accountNo1);
        userTestBase.cleanAccountByAccountNo(marketAccountNo1);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
    }

    /**
     * 1001商户号为空
     * 1002商户名为空
     * 1003商户简称为空
     * 1004商户来源标识为空
     * 1005统一流水号为空
     * 1006手机格式错误
     * 1007邮箱格式错误
     * 1008order为空
     */
    @AutoTest(file = "gas_merchant/merchantServiceUpdateTestFailOne.csv")
    @DisplayName("修改商户信息--参数非法")
    public void merchantServiceUpdateTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UpdMerchantOrder order
    ) {
        // 清除数据

        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setPartnerName(null);
        }
        if (testId == 1003) {
            order.setShortName(null);
        }
        if (testId == 1004) {
            order.setSourceKey(null);
        }
        if (testId == 1005) {
            order.setGid(null);
        }
        if (testId == 1008) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantService.update(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001商户不存在
     * 1002修改的商户名已经被使用
     * 1003appid已经被使用
     */
    @AutoTest(file = "gas_merchant/merchantServiceUpdateTestFailTwo.csv")
    @DisplayName("修改商户信息--失败用例")
    public void merchantServiceUpdateTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            UpdMerchantOrder order,
            String partnerId, String partnerId1,
            String partnerName, String partnerName1,
            String shortName, String shortName1,
            String mobile, String mobile1,
            String sourceKey, String sourceKey1,
            String merchantStatus, String merchantStatus1,
            Date rawAddTime, Date rawUpdateTime
    ) {
        // 清除数据

        // 准备数据
        //资金账号
        String accountNo = "1jc7w1m29ks031hge7p8";
        String marketAccountNo = "001iys5hlniks541g00";
        String accountNo1 = "1jc81da19gs031hge7p8";
        String marketAccountNo1 = "001iys5hlniks0368h00";
        if (testId != 1001) {
            gasMerchantInitDataBase.initGasMerchants(partnerId, partnerId1, partnerName, partnerName1, shortName,
                    shortName1, mobile, mobile1, sourceKey, sourceKey1, merchantStatus, merchantStatus1, "Merchant",
                    "Merchant", rawAddTime, rawUpdateTime);
        }
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantService.update(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        gasMerchantTestBase.cleanGasMerchantByPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPartnerId(partnerId1);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantSourceDataByPartnerId(partnerId1);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId1);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId1);
        userTestBase.cleanAccountByAccountNo(accountNo);
        userTestBase.cleanAccountByAccountNo(marketAccountNo);
        userTestBase.cleanAccountByAccountNo(accountNo1);
        userTestBase.cleanAccountByAccountNo(marketAccountNo1);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
    }

    /**
     * 断言商家信息表
     *
     * @param count
     * @param partnerId
     * @param partnerName
     * @param shortName
     * @param mobileNo
     * @param email
     * @param accountNo
     * @param marketAccountNo
     * @param status
     * @param headImgUrl
     * @param queryDepth
     * @param rawAddTime
     * @param rawUpdateTime
     */
    private void gasMerchantAssert(
            int count,
            String partnerId,
            String partnerName,
            String shortName,
            String mobileNo,
            String email,
            String accountNo,
            String marketAccountNo,
            String status,
            String headImgUrl,
            Date queryDepth,
            Date rawAddTime,
            Date rawUpdateTime
    ) {
        List<GasMerchantDO> merchantInfos = gasMerchantTestBase.findGasMerchantByPartnerId(partnerId);
        assertEquals(count, merchantInfos.size());
        for (GasMerchantDO merchantInfo : merchantInfos) {
            assertEquals(partnerId, merchantInfo.getPartnerId());
            assertEquals(partnerName, merchantInfo.getPartnerName());
            assertEquals(shortName, merchantInfo.getShortName());
            assertEquals(mobileNo, merchantInfo.getMobileNo());
            assertEquals(email, merchantInfo.getEmail());
            assertEquals(accountNo, merchantInfo.getAccountNo());
            assertEquals(marketAccountNo, merchantInfo.getMarketAccountNo());
            assertEquals(status, merchantInfo.getStatus());
            assertEquals(headImgUrl, merchantInfo.getHeadImgUrl());
            if (queryDepth != null && DateUtils.formatDate(queryDepth) != "") {
                assertEquals(DateUtils.formatDate(queryDepth), DateUtils.formatDate(merchantInfo.getQueryDepth()));
            } else {
                assertEquals(null, merchantInfo.getQueryDepth());
            }
            assertEquals(rawAddTime, merchantInfo.getRawAddTime());
            assertNotEquals(rawUpdateTime, merchantInfo.getRawUpdateTime());
        }
    }

    /**
     * 断言商户来源信息表
     *
     * @param count
     * @param partnerId
     * @param sourceKey
     * @param rawAddTime
     * @param rawUpdateTime
     */
    private void gasMerchantSourceDataAssert(
            int count,
            String partnerId,
            String sourceKey,
            Date rawAddTime,
            Date rawUpdateTime
    ) {
        List<GasMerchantSourceDataDO> SourceDataInfos =
                gasMerchantTestBase.findGasMerchantSourceDataByPartnerId(partnerId);
        assertEquals(count, SourceDataInfos.size());
        for (GasMerchantSourceDataDO SourceDataInfo : SourceDataInfos) {
            assertEquals(partnerId, SourceDataInfo.getPartnerId());
            assertEquals(sourceKey, SourceDataInfo.getSourceKey());
            assertEquals(SourceType.WeChat.code(), SourceDataInfo.getSourceType());
            assertEquals(rawAddTime, SourceDataInfo.getRawAddTime());
            assertNotEquals(rawUpdateTime, SourceDataInfo.getRawUpdateTime());
            assertEquals(Byte.valueOf("0"), SourceDataInfo.getAuthorized());
            assertEquals(null, SourceDataInfo.getAuthorizerRefreshToken());
            assertEquals(null, SourceDataInfo.getAuthorizerAccessToken());
            assertEquals(null, SourceDataInfo.getAuthorizerAccessTokenTime());
            assertEquals(null, SourceDataInfo.getSourceInfo());
            assertEquals(null, SourceDataInfo.getFuncInfo());
        }
    }

    /**
     * 断言清结算商户信息
     */
    private void xybMerchantBypartnerId(String partnerId,
                                        String partnerName, String shortName,
                                        String partnerType, Date rawAddTime,
                                        Date rawUpdateTime) {
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
        assertEquals(DateUtil.dtSimpleFormat(rawAddTime),
                DateUtil.dtSimpleFormat(merchantInfos.get(0).getRawAddTime()));
        assertNotEquals(DateUtil.dtSimpleFormat(rawUpdateTime),
                DateUtil.dtSimpleFormat(merchantInfos.get(0).getRawUpdateTime()));
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
        for (dal.model.gas_silverbolt.GasMerchantDO merchantInfo : merchantInfos) {
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
                assertEquals(DateUtils.formatDate(queryDepth), DateUtils.formatDate(merchantInfo.getQueryDepth()));
            } else {
                assertEquals(null, merchantInfo.getQueryDepth());
            }
            //刚注册的  创建时间等于更新时间？？
            assertEquals(merchantInfo.getRawAddTime(), merchantInfo.getRawUpdateTime());
        }
    }
}

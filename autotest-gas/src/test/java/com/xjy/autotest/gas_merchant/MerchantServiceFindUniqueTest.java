package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.info.MerchantInfo;
import com.xyb.gas.merchant.api.order.QueryMerchantOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/11/26.
 */
public class MerchantServiceFindUniqueTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 1001.只传入商户ID查询
     * 1002.只传入来源信息查询
     * 1003.传入所有数据查询
     */
    @AutoTest(file = "gas_merchant/merchantServiceFindUniqueTestSuccess.csv")
    @DisplayName("查询商户信息--成功用例")
    public void merchantServiceFindUniqueTestSuccess(
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
            String model, String model1,
            QueryMerchantOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initGasMerchants(partnerId, partnerId1, partnerName, partnerName1, shortName,
                shortName1, mobile, mobile1, sourceKey, sourceKey1, merchantStatus, merchantStatus1, model, model1,
                null, null);
        // 测试过程
        // 调用接口
        BizResult<MerchantInfo> result = merchantService.findUnique(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(partnerId, result.getInfo().getPartnerId());
        assertEquals(partnerId, result.getInfo().getPlatPartnerId());
        assertEquals(partnerName, result.getInfo().getPartnerName());
        assertEquals(shortName, result.getInfo().getShortName());
        assertEquals(mobile, result.getInfo().getMobileNo());
        assertEquals("1jc7w1m29ks031hge7p8", result.getInfo().getAccountNo());
        assertEquals("001iys5hlniks541g00", result.getInfo().getMarketAccountNo());
        assertEquals("ABLE", result.getInfo().getStatus().code());
        assertEquals(null, result.getInfo().getEmail());
        assertEquals(null, result.getInfo().getHeadImgUrl());
//        assertEquals(DateUtils.getSqlDate(), result.getInfo().getQueryDepth());
        assertEquals("0*60*60*1000+0*60*1000+0" +
                "*1000", result.getInfo().getDayTime());
        assertEquals("1", result.getInfo().getMonthTime());
//        assertEquals(partnerId, result.getInfo().getRawAddTime());
        assertEquals("WeChat", result.getInfo().getSourceType().code());
        assertEquals(sourceKey, result.getInfo().getSourceKey());
        assertEquals(false, result.getInfo().isAuthorized());
        assertEquals(null, result.getInfo().getAuthorizerRefreshToken());
        assertEquals(model, result.getInfo().getCollectionModel().code());
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId1);
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.cleanUserByUserId(partnerId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId1);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId1);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId1);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId1);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
    }

    /**
     * 1001.商户号为空时，只传来源类型
     * 1002.商户号为空时，只传来源标识
     * 1003.商户号为空时，来源类型和来源标识也为空
     * 1004.gid为空
     * 1005.order为空
     */
    @AutoTest(file = "gas_merchant/merchantServiceFindUniqueTestFailOne.csv")
    @DisplayName("查询商户信息--参数非法")
    public void merchantServiceFindUniqueTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryMerchantOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        BizResult<MerchantInfo> result = merchantService.findUnique(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据

    }
}

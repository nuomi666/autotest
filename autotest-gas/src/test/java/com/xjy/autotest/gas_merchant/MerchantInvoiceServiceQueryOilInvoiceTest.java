package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.GoodsGroupType;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantInvoiceService;
import com.xyb.gas.merchant.api.info.invoice.MerchantQueryInvoiceInfo;
import com.xyb.gas.merchant.api.order.invoice.QueryOilInvoiceRateOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/02/26.
 */
public class MerchantInvoiceServiceQueryOilInvoiceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantInvoiceService merchantInvoiceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceQueryOilInvoiceTestSuccess.csv")
    @DisplayName("查询税号相关信息--成功用例")
    public void merchantInvoiceServiceQueryOilInvoiceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String taxGoodsRate, String taxGoodsCode,
            String taxGoodsName, String taxCompany,
            String taxCode, String taxAddress,
            String taxMobile, String taxDrawer,
            String taxBankNo, String taxReviewer,
            String taxPayee, String taxAppId,
            String taxKey, String taxCertPath,
            String taxCertPwd,
            QueryOilInvoiceRateOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasInvoiceCompanyByStationId(order.getStationId());
        // 准备数据
        gasMerchantTestBase.insertGasMerchantGoods(0l, order.getPlatPartnerId(), order.getPlatPartnerId(), null, null,
                GoodsType.OIL.code(), GoodsGroupType.GASOLINE.code(), null, Double.valueOf(taxGoodsRate),
                taxGoodsCode, taxGoodsName, 1, "ABLE",
                null, null);
        gasMerchantTestBase.insertGasInvoiceCompany(0l, order.getPlatPartnerId(), order.getStationId(), taxCompany,
                taxCode,
                taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer, taxPayee,
                taxAppId, taxKey, taxCertPath, taxCertPwd, null, null);
        // 测试过程
        // 调用接口
        BizResult<MerchantQueryInvoiceInfo> result = merchantInvoiceService.queryOilInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        taxAssert(result.getInfo(), order.getPlatPartnerId(),
                order.getStationId(), null, null,
                taxAppId, taxKey, taxCertPath, taxCertPwd,
                taxCompany, taxCode, taxAddress, taxMobile,
                taxDrawer, taxBankNo, taxReviewer, taxPayee,
                Double.valueOf(taxGoodsRate), taxGoodsCode, taxGoodsName);
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasInvoiceCompanyByStationId(order.getStationId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceQueryOilInvoiceTestFailOne.csv")
    @DisplayName("查询税号相关信息--参数非法")
    public void merchantInvoiceServiceQueryOilInvoiceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryOilInvoiceRateOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setStationId(null);
        }
        if (testId == 1003) {
            order.setOilCode(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        BizResult<MerchantQueryInvoiceInfo> result = merchantInvoiceService.queryOilInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.未查询到商户与该商品关联信息
     * 1002.商户发票信息配置不全
     * 1003.商户未配置开票信息
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceQueryOilInvoiceTestFailTwo.csv")
    @DisplayName("查询税号相关信息--失败用例")
    public void merchantInvoiceServiceQueryOilInvoiceTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String taxGoodsRate, String taxGoodsCode,
            String taxGoodsName, String taxCompany,
            String taxCode, String taxAddress,
            String taxMobile, String taxDrawer,
            String taxBankNo, String taxReviewer,
            String taxPayee, String taxAppId,
            String taxKey, String taxCertPath,
            String taxCertPwd,
            QueryOilInvoiceRateOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasInvoiceCompanyByStationId(order.getStationId());
        // 准备数据
        if (testId != 1001) {
            gasMerchantTestBase.insertGasMerchantGoods(0l, order.getPlatPartnerId(), order.getPlatPartnerId(), null,
                    null, GoodsType.OIL.code(), GoodsGroupType.GASOLINE.code(), null, Double.valueOf(taxGoodsRate),
                    taxGoodsCode, taxGoodsName, 1, "ABLE",
                    null, null);
        }
        if (testId != 1003) {
            gasMerchantTestBase.insertGasInvoiceCompany(0l, order.getPlatPartnerId(), order.getStationId(), taxCompany,
                    taxCode,
                    taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer, taxPayee,
                    taxAppId, taxKey, taxCertPath, taxCertPwd, null, null);
        }
        // 测试过程
        // 调用接口
        BizResult<MerchantQueryInvoiceInfo> result = merchantInvoiceService.queryOilInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasInvoiceCompanyByStationId(order.getStationId());
    }

    /**
     * 税率相关信息
     */
    private void taxAssert(
            MerchantQueryInvoiceInfo info,
            String platPartnerId,
            String stationId,
            String stationCode,
            String stationName,
            String taxAppId,
            String taxKey,
            String taxCertPath,
            String taxCertPwd,
            String taxCompany,
            String taxCode,
            String taxAddress,
            String taxMobile,
            String taxDrawer,
            String taxBankNo,
            String taxReviewer,
            String taxPayee,
            Double taxGoodsRate,
            String taxGoodsCode,
            String taxGoodsName
    ) {
        assertEquals(platPartnerId, info.getPlatPartnerId());
        assertEquals(stationId, info.getStationId());
        assertEquals(stationCode, info.getStationCode());
        assertEquals(stationName, info.getStationName());
        assertEquals(taxAppId, info.getTaxAppId());
        assertEquals(taxKey, info.getTaxKey());
        assertEquals(taxCertPath, info.getTaxCertPath());
        assertEquals(taxCertPwd, info.getTaxCertPwd());
        assertEquals(taxCompany, info.getTaxCompany());
        assertEquals(taxAddress, info.getTaxAddress());
        assertEquals(taxGoodsCode, info.getTaxGoodsCode());
        assertEquals(taxGoodsName, info.getTaxGoodsName());
        assertEquals(taxCode, info.getTaxCode());
        assertEquals(taxMobile, info.getTaxMobile());
        assertEquals(taxDrawer, info.getTaxDrawer());
        assertEquals(taxBankNo, info.getTaxBankNo());
        assertEquals(taxReviewer, info.getTaxReviewer());
        assertEquals(taxPayee, info.getTaxPayee());
        assertEquals(taxGoodsRate, info.getTaxGoodsRate());
    }
}

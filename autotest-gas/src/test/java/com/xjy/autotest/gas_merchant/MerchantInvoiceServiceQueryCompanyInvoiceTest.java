package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantInvoiceService;
import com.xyb.gas.merchant.api.info.invoice.MerchantCompanyInfo;
import com.xyb.gas.merchant.api.order.invoice.QueryInvoiceCompanyOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2020/02/26.
 */
public class MerchantInvoiceServiceQueryCompanyInvoiceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantInvoiceService merchantInvoiceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceQueryCompanyInvoiceTestSuccess.csv")
    @DisplayName("查询商户开票信息配置--成功用例")
    public void merchantInvoiceServiceQueryCompanyInvoiceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String taxCompany, String taxCode,
            String taxAddress, String taxMobile,
            String taxDrawer, String taxBankNo,
            String taxReviewer, String taxPayee,
            String taxAppId, String taxKey,
            String taxCertPath, String taxCertPwd,
            QueryInvoiceCompanyOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceCompanyByStationId(order.getStationId());
        // 准备数据
        if (testId == 1002) {
            gasMerchantTestBase.insertGasInvoiceCompany(0l, order.getPlatPartnerId(), order.getStationId(), taxCompany,
                    taxCode, taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer, taxPayee,
                    taxAppId, taxKey, taxCertPath, taxCertPwd, null, null);
        }
        // 测试过程
        // 调用接口
        BizResult<MerchantCompanyInfo> result = merchantInvoiceService.queryCompanyInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(null, result.getInfo());
        } else {
            taxAssert(result.getInfo(), order.getPlatPartnerId(),
                    order.getStationId(), null, null,
                    taxAppId, taxKey, taxCertPath, taxCertPwd,
                    taxCompany, taxCode, taxAddress, taxMobile,
                    taxDrawer, taxBankNo, taxReviewer, taxPayee);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceCompanyByStationId(order.getStationId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceQueryCompanyInvoiceTestFailOne.csv")
    @DisplayName("查询商户开票信息配置--参数非法")
    public void merchantInvoiceServiceQueryCompanyInvoiceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryInvoiceCompanyOrder order
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
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizResult<MerchantCompanyInfo> result = merchantInvoiceService.queryCompanyInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 税率相关信息
     */
    private void taxAssert(
            MerchantCompanyInfo info,
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
            String taxPayee
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
        assertEquals(taxCode, info.getTaxCode());
        assertEquals(taxMobile, info.getTaxMobile());
        assertEquals(taxDrawer, info.getTaxDrawer());
        assertEquals(taxBankNo, info.getTaxBankNo());
        assertEquals(taxReviewer, info.getTaxReviewer());
        assertEquals(taxPayee, info.getTaxPayee());
    }
}

package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantInvoiceService;
import com.xyb.gas.merchant.api.order.invoice.ModifyInvoiceCompanyOrder;
import dal.model.gas_merchant.GasInvoiceCompanyDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/02/26.
 */
public class MerchantInvoiceServiceModifyInvoiceCompanyTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantInvoiceService merchantInvoiceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 修改油站时同时修改网关缓存信息
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceModifyInvoiceCompanyTestSuccess.csv")
    @DisplayName("配置商户开票信息服务--成功用例")
    public void merchantInvoiceServiceModifyInvoiceCompanyTestSuccess(
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
            ModifyInvoiceCompanyOrder order
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
        BizResult result = merchantInvoiceService.modifyInvoiceCompany(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasInvoiceCompanyDO> comanyInfos =
                gasMerchantTestBase.findGasInvoiceCompanyByStationId(order.getStationId());
        taxAssert(comanyInfos.get(0), order.getPlatPartnerId(),
                order.getStationId(), order.getTaxAppId(), order.getTaxKey(),
                order.getTaxCertPath(), order.getTaxCertPwd(),
                order.getTaxCompany(), order.getTaxCode(), order.getTaxAddress(),
                order.getTaxMobile(), order.getTaxDrawer(), order.getTaxBankNo(),
                order.getTaxReviewer(), order.getTaxPayee());
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceCompanyByStationId(order.getStationId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceModifyInvoiceCompanyTestFailOne.csv")
    @DisplayName("配置商户开票信息服务--参数非法")
    public void merchantInvoiceServiceModifyInvoiceCompanyTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyInvoiceCompanyOrder order
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
            order.setTaxAppId(null);
        }
        if (testId == 1004) {
            order.setTaxKey(null);
        }
        if (testId == 1005) {
            order.setTaxCertPath(null);
        }
        if (testId == 1006) {
            order.setTaxCertPwd(null);
        }
        if (testId == 1007) {
            order.setTaxCompany(null);
        }
        if (testId == 1008) {
            order.setTaxCode(null);
        }
        if (testId == 1009) {
            order.setTaxAddress(null);
        }
        if (testId == 1010) {
            order.setTaxMobile(null);
        }
        if (testId == 1011) {
            order.setTaxDrawer(null);
        }
        if (testId == 1012) {
            order.setGid(null);
        }
        if (testId == 1013) {
            order = null;
        }
        // 调用接口
        BizResult result = merchantInvoiceService.modifyInvoiceCompany(order);
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
            GasInvoiceCompanyDO info,
            String platPartnerId,
            String stationId,
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

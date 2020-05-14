package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantInvoiceService;
import com.xyb.gas.merchant.api.order.invoice.QueryInvoiceCompanyOrder;
import dal.model.gas_merchant.GasInvoiceCompanyDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/02/26.
 */
public class MerchantInvoiceServiceDeleteCompanyInvoiceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantInvoiceService merchantInvoiceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceDeleteCompanyInvoiceTestSuccess.csv")
    @DisplayName("删除商户开票信息配置--成功用例")
    public void merchantInvoiceServiceDeleteCompanyInvoiceTestSuccess(
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
        gasMerchantTestBase.insertGasInvoiceCompany(0l, order.getPlatPartnerId(), order.getStationId(), taxCompany,
                taxCode, taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer, taxPayee,
                taxAppId, taxKey, taxCertPath, taxCertPwd, null, null);
        // 测试过程
        // 调用接口
        BizResult result = merchantInvoiceService.deleteCompanyInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasInvoiceCompanyDO> comanyInfos =
                gasMerchantTestBase.findGasInvoiceCompanyByStationId(order.getStationId());
        assertTrue(comanyInfos.size() == 0);
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceCompanyByStationId(order.getStationId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceDeleteCompanyInvoiceTestFailOne.csv")
    @DisplayName("删除商户开票信息配置--参数非法")
    public void merchantInvoiceServiceDeleteCompanyInvoiceTestFailOne(
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
        BizResult result = merchantInvoiceService.deleteCompanyInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

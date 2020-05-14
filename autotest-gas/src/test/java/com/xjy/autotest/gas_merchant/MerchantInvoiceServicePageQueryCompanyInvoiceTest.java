package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantInvoiceService;
import com.xyb.gas.merchant.api.info.invoice.MerchantCompanyInfo;
import com.xyb.gas.merchant.api.order.invoice.PageQueryInvoiceCompanyOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * @author nuomi
 * Created on 2020/02/27.
 */
public class MerchantInvoiceServicePageQueryCompanyInvoiceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantInvoiceService merchantInvoiceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001.只传入商户ID查询，查询一条数据
     * 1002.只传入商户ID查询，查询多条数据,每页显示两条，显示第一页
     * 1003.只传入商户ID查询，查询多条数据,每页显示两条，显示第二页
     * 1004.传入商户ID和油站查询
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServicePageQueryCompanyInvoiceTestSuccess.csv")
    @DisplayName("分页查询商户油站发票配置信息--成功用例")
    public void merchantInvoiceServicePageQueryCompanyInvoiceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String stationId,
            String stationId1, String stationId2,
            String taxCompany, String taxCode,
            String taxAddress, String taxMobile,
            String taxDrawer, String taxBankNo,
            String taxReviewer, String taxReviewer1,
            String taxReviewer2, String taxPayee,
            String taxPayee1, String taxPayee2,
            String taxAppId, String taxKey,
            String taxCertPath, String taxCertPwd,
            PageQueryInvoiceCompanyOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceCompanyByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasInvoiceCompanyByPlatPartnerId(platPartnerId);
        // 准备数据
        Date rawAddTime = DateUtils.parseDate("2019-12-13");
        Date rawAddTime1 = DateUtils.parseDate("2019-12-30");
        Date rawAddTime2 = DateUtils.parseDate("2020-01-13");
        gasMerchantTestBase.insertGasInvoiceCompany(0l, order.getPlatPartnerId(), stationId, taxCompany,
                taxCode, taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer, taxPayee,
                taxAppId, taxKey, taxCertPath, taxCertPwd, rawAddTime, rawAddTime);
        gasMerchantTestBase.insertGasInvoiceCompany(0l, order.getPlatPartnerId(), stationId1, taxCompany,
                taxCode, taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer1, taxPayee1,
                taxAppId, taxKey, taxCertPath, taxCertPwd, rawAddTime1, rawAddTime1);
        gasMerchantTestBase.insertGasInvoiceCompany(0l, order.getPlatPartnerId(), stationId2, taxCompany,
                taxCode, taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer2, taxPayee2,
                taxAppId, taxKey, taxCertPath, taxCertPwd, rawAddTime2, rawAddTime2);
        //干扰数据
        gasMerchantTestBase.insertGasInvoiceCompany(0l, platPartnerId, stationId, taxCompany,
                taxCode, taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer, taxPayee,
                taxAppId, taxKey, taxCertPath, taxCertPwd, rawAddTime, rawAddTime);
        // 测试过程
        if (testId == 1004) {
            order.setStationId(stationId);
        }
        // 调用接口
        PagedResult<MerchantCompanyInfo> result =
                merchantInvoiceService.pageQueryCompanyInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1002) {
            assertEquals(2, result.getInfoList().size());
            taxAssert(result.getInfoList().get(0), order.getPlatPartnerId(),
                    stationId2, null, null,
                    taxAppId, taxKey, taxCertPath, taxCertPwd,
                    taxCompany, taxCode, taxAddress, taxMobile,
                    taxDrawer, taxBankNo, taxReviewer2, taxPayee2);
            taxAssert(result.getInfoList().get(1), order.getPlatPartnerId(),
                    stationId1, null, null,
                    taxAppId, taxKey, taxCertPath, taxCertPwd,
                    taxCompany, taxCode, taxAddress, taxMobile,
                    taxDrawer, taxBankNo, taxReviewer1, taxPayee1);
        } else {
            assertEquals(1, result.getInfoList().size());
            taxAssert(result.getInfoList().get(0), order.getPlatPartnerId(),
                    stationId, null, null,
                    taxAppId, taxKey, taxCertPath, taxCertPwd,
                    taxCompany, taxCode, taxAddress, taxMobile,
                    taxDrawer, taxBankNo, taxReviewer, taxPayee);
        }
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceCompanyByPlatPartnerId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasInvoiceCompanyByPlatPartnerId(platPartnerId);
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServicePageQueryCompanyInvoiceTestFailOne.csv")
    @DisplayName("分页查询商户油站发票配置信息--参数非法")
    public void merchantInvoiceServicePageQueryCompanyInvoiceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryInvoiceCompanyOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<MerchantCompanyInfo> result =
                merchantInvoiceService.pageQueryCompanyInvoice(order);
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

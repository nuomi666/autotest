package com.xjy.autotest.gas.test.station;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.MerchantInvoicePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_merchant.GasInvoiceCompanyDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/26.
 */
public class MerchantInvoiceCompanyUpdWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @AutoTest(file = "gas/merchantInvoiceCompanyUpdWebTestSuccess.csv")
    @DisplayName("编辑商户开票信息--成功用例")
    public void merchantInvoiceCompanyUpdWebTestSuccess(
            int testId,
            String userName,
            String password,
            String platPartnerId,
            String stationName,
            String taxCompany,
            String taxCompany1,
            String taxCode,
            String taxCode1,
            String taxAddress,
            String taxAddress1,
            String taxMobile,
            String taxMobile1,
            String taxDrawer,
            String taxDrawer1,
            String taxAppId,
            String taxAppId1,
            String taxKey,
            String taxKey1,
            String taxCertPwd,
            String taxCertPwd1,
            String fileName,
            String fileName1,
            String taxBankNo,
            String taxBankNo1,
            String taxReviewer,
            String taxReviewer1,
            String taxPayee,
            String taxPayee1
    ) {
        //清除数据
        gasMerchantTestBase.cleanGasInvoiceCompanyByPlatPartnerId(platPartnerId);
        //准备数据
        String stationId = gasMerchantTestBase.findGasMerchantStationByStationName(stationName).get(0).getStationId();
        gasMerchantTestBase.insertGasInvoiceCompany(0l, platPartnerId, stationId, taxCompany,
                taxCode, taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer, taxPayee,
                taxAppId, taxKey, "/media/jhy/jhy/img/invoice/" + fileName, taxCertPwd, null, null);
        String stationCode =
                gasMerchantTestBase.findGasMerchantStationByStationName(stationName).get(0).getStationCode();
        //打开浏览器测试页面
        open(testUrlGas);
        //更新发票信息
        MerchantInvoicePage merchantInvoicePage = new GasLoginPage()
                .login(userName, password)
                .stationCenter()
                .invoiceManager()
                .merchantInvoiceCompanyUpd(stationName, taxCompany1, taxCode1, taxAddress1,
                        taxMobile1, taxDrawer1, taxAppId1, taxKey1, taxCertPwd1, fileName1,
                        taxBankNo1, taxReviewer1, taxPayee1);
        //页面数据验证
        merchantInvoicePage.checkData(stationCode, stationName, taxCompany1, taxCode1,
                taxAddress1, taxMobile1, taxDrawer1, taxBankNo1, taxReviewer1, taxPayee1);
        //数据库数据验证
        List<GasInvoiceCompanyDO> comanyInfos =
                gasMerchantTestBase.findGasInvoiceCompanyByStationId(stationId);
        taxAssert(comanyInfos.get(0), platPartnerId,
                stationId, taxAppId1, taxKey1, "/media/jhy/jhy/img/invoice/" + fileName1,
                taxCertPwd1, taxCompany1, taxCode1, taxAddress1,
                taxMobile1, taxDrawer1, taxBankNo1, taxReviewer1, taxPayee1);
        //删除油站
        gasMerchantTestBase.cleanGasInvoiceCompanyByPlatPartnerId(platPartnerId);
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

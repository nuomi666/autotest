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
public class MerchantInvoiceCompanySetWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @AutoTest(file = "gas/merchantInvoiceCompanySetWebTestSuccess.csv")
    @DisplayName("配置商户开票信息--成功用例")
    public void merchantInvoiceCompanySetWebTestSuccess(
            int testId,
            String userName,
            String password,
            String platPartnerId,
            String stationName,
            String taxCompany,
            String taxCode,
            String taxAddress,
            String taxMobile,
            String taxDrawer,
            String taxAppId,
            String taxKey,
            String taxCertPwd,
            String fileName,
            String taxBankNo,
            String taxReviewer,
            String taxPayee
    ) {
        //清除数据
        gasMerchantTestBase.cleanGasInvoiceCompanyByPlatPartnerId(platPartnerId);
        //准备数据
        String stationId = gasMerchantTestBase.findGasMerchantStationByStationName(stationName).get(0).getStationId();
        String stationCode =
                gasMerchantTestBase.findGasMerchantStationByStationName(stationName).get(0).getStationCode();
        //打开浏览器测试页面
        open(testUrlGas);
        //开票设置
        MerchantInvoicePage merchantInvoicePage = new GasLoginPage()
                .login(userName, password)
                .stationCenter()
                .invoiceManager()
                .merchantInvoiceCompanySet(stationName, taxCompany, taxCode, taxAddress,
                        taxMobile, taxDrawer, taxAppId, taxKey, taxCertPwd, fileName,
                        taxBankNo, taxReviewer, taxPayee);
        //页面数据验证
        merchantInvoicePage.checkData(stationCode, stationName, taxCompany, taxCode,
                taxAddress, taxMobile, taxDrawer, taxBankNo, taxReviewer, taxPayee);
        //数据库数据验证
        List<GasInvoiceCompanyDO> comanyInfos =
                gasMerchantTestBase.findGasInvoiceCompanyByStationId(stationId);
        taxAssert(comanyInfos.get(0), platPartnerId,
                stationId, taxAppId, taxKey, "/media/jhy/jhy/img/invoice/" + fileName,
                taxCertPwd, taxCompany, taxCode, taxAddress,
                taxMobile, taxDrawer, taxBankNo, taxReviewer, taxPayee);

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

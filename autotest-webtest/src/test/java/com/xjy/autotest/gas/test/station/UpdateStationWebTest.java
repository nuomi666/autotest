package com.xjy.autotest.gas.test.station;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.StationManagePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import com.xyb.adk.common.util.DateUtil;
import dal.model.gas_merchant.GasMerchantStationDO;
import dal.model.gas_merchant.GasStationGoodsDO;
import dal.model.merchant.MerchantInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class UpdateStationWebTest extends WebTestBase {
    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @AutoTest(file = "gas/UpdateStationWebTestSuccess.csv")
    @DisplayName("编辑油站--成功用例")
    public void UpdateStationWebTestSuccess(
            int testId,
            String userName, String password,
            String platPartnerId, String partnerId,
            String stationCode, String stationName,
            String phone, String addr, String oilCode,
            String oilName, String oilCode1,
            String oilName1, String stationCodexx,
            String stationNamexx, String phonexx,
            String addrxx, String addOil,
            String statusCode, String stationStatus
    ) {
        //清除数据
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCodexx);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCodexx);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationNamexx);
        //创建油站数据
        //准备数据
        Map<String, Object> params = gasMerchantInitDataBase.initStationsForUpdate(platPartnerId, partnerId,
                stationCode, stationName, phone, addr, oilCode, oilName,
                oilCode1, oilName1, statusCode);
        String stationId = params.get("stationId").toString();
        String delOil = null;
        if (testId != 1001) {
            delOil = oilName;
        }
        //打开浏览器测试页面
        open(testUrlGas);
        //编辑油站信息
        StationManagePage stationManagePage = new GasLoginPage()
                .login(userName, password)
                .stationCenter()
                .stationManage()
                .editStation(stationCode, stationCodexx,
                        stationNamexx, phonexx, delOil,
                        addOil, addrxx);
        //页面验证数据
        if (testId == 1001) {
            stationManagePage.checkData(stationCode, stationName, phone, addr, stationStatus);
        } else {
            stationManagePage.checkData(stationCodexx, stationNamexx, phonexx, addrxx, stationStatus);
        }
        //数据库数据验证
        //商户油站
        GasMerchantStationDO gasMerDO =
                gas_merchantTestBase.findGasMerchantStationByStationId(stationId).get(0);
        if (testId == 1001) {
            assertEquals(stationCode, gasMerDO.getStationCode());
            assertEquals(stationName, gasMerDO.getStationName());
            assertEquals(phone, gasMerDO.getPhoneNo());
            assertEquals(addr, gasMerDO.getStationAddress());
        } else {
            assertEquals(stationCodexx, gasMerDO.getStationCode());
            assertEquals(stationNamexx, gasMerDO.getStationName());
            assertEquals(phonexx, gasMerDO.getPhoneNo());
            assertEquals(addrxx, gasMerDO.getStationAddress());
        }
        assertEquals(statusCode, gasMerDO.getStatus());
        //油站油号
        List<GasStationGoodsDO> stationGoodsDOS = gas_merchantTestBase.findGasStationGoodsByStationId(stationId);
        List<String> oils = new ArrayList<>();
        for (GasStationGoodsDO goodsInfo : stationGoodsDOS) {
            oils.add(goodsInfo.getGoodsName());
        }
        if (testId == 1001) {
            assertEquals(3, stationGoodsDOS.size());
            assertTrue(oils.contains(oilName));
            assertTrue(oils.contains(oilName1));
            assertTrue(oils.contains(addOil));
        }
        if (testId == 1002) {
            assertEquals(1, stationGoodsDOS.size());
            assertTrue(oils.contains(oilName1));
        }
        if (testId == 1003) {
            assertEquals(2, stationGoodsDOS.size());
            assertTrue(oils.contains(oilName1));
            assertTrue(oils.contains(addOil));
        }
        //分析
        dal.model.gas_silverbolt.GasMerchantStationDO gasMerDO1 =
                silverboltTestBase.findGasMerchantStationByStationId(stationId).get(0);
        if (testId == 1001) {
            assertEquals(stationCode, gasMerDO1.getStationCode());
            assertEquals(stationName, gasMerDO1.getStationName());
            assertEquals(phone, gasMerDO1.getPhoneNo());
            assertEquals(addr, gasMerDO1.getStationAddress());
        } else {
            assertEquals(stationCodexx, gasMerDO1.getStationCode());
            assertEquals(stationNamexx, gasMerDO1.getStationName());
            assertEquals(phonexx, gasMerDO1.getPhoneNo());
            assertEquals(addrxx, gasMerDO1.getStationAddress());
        }
        assertEquals(statusCode, gasMerDO1.getStatus());
        //清结算商户信息
//        List<MerchantInfoDO> merchantInfos =
//                xybMerchantTestBase.findMerchantInfoByPartnerId(gasMerchantStationDO.getPartnerId());
//        if (testId == 1001) {
//            xybMerchantByplatPartnerId(merchantInfos.get(0), gasMerchantStationDO.getPlatPartnerId(),
//                    gasMerchantStationDO.getPartnerId(),
//                    null, stationNamexx, "PARTNER");
//        }
        //清除数据
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCodexx);
        gas_merchantTestBase.cleanGasStationGoodsByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationNamexx);
    }

    /**
     * 断言清结算商户信息
     */
    private void xybMerchantByplatPartnerId(MerchantInfoDO info, String platPartnerId,
                                            String partnerId,
                                            String partnerName, String shortName,
                                            String partnerType) {
        assertEquals(partnerId, info.getPartnerId());
        assertEquals(platPartnerId, info.getPlatPartnerId());
        assertEquals(null, info.getIndustryLine());
        assertEquals(null, info.getOutPartnerId());
        assertEquals(partnerName, info.getPartnerName());
        assertEquals(shortName, info.getPartnerAbbrName());
        assertEquals(null, info.getPartnerRegisterAddress());
        assertEquals("INSIDE", info.getRegisterFrom());
        assertEquals(partnerType, info.getPartnerType());
        assertEquals("ACTIVE", info.getPartnerStatus());
//        assertEquals(realName, merchantInfos.get(0).getSecurityCode());
        assertEquals(null, info.getOwnService());
        assertEquals("MD5", info.getDigestType());
        assertEquals(DateUtil.dtSimpleFormat(info.getRawAddTime()),
                DateUtil.dtSimpleFormat(info.getRawUpdateTime()));
    }
}

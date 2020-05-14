package com.xjy.autotest.gas.test.station;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.StationManagePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import com.xyb.adk.common.util.DateUtil;
import dal.model.gas_merchant.GasMerchantStationDO;
import dal.model.merchant.MerchantInfoDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2019-11-14.
 */
public class AddStationWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @AutoTest(file = "gas/addStationWebTestSuccess.csv")
    @DisplayName("新增油站--成功用例")
    public void addStationWebTestSuccess(
            int testId,
            String userName,
            String password,
            String stationCode,
            String stationName,
            String phoneNo,
            String stationAddress,
            String stationStatus
    ) {
        //清除数据
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
        //打开浏览器测试页面
        open(testUrlGas);
        //登录并新增油站
        StationManagePage stationManagePage = new GasLoginPage()
                .login(userName, password)
                .stationCenter()
                .stationManage()
                .addStation(stationCode, stationName, phoneNo, stationAddress);
        //页面数据验证
        stationManagePage.checkData(stationCode, stationName, phoneNo, stationAddress, stationStatus);
        //数据库数据验证
        GasMerchantStationDO gasMerchantStationDO =
                gas_merchantTestBase.findGasMerchantStationByStationCode(stationCode).get(0);
        assertEquals(stationName, gasMerchantStationDO.getStationName());
        assertEquals(phoneNo, gasMerchantStationDO.getPhoneNo());
        assertEquals(stationAddress, gasMerchantStationDO.getStationAddress());
        assertEquals("ABLE", gasMerchantStationDO.getStatus());
        if (testId == 1002) {//油站模式
            assertNotEquals(gasMerchantStationDO.getPartnerId(), gasMerchantStationDO.getPlatPartnerId());
        } else {
            assertEquals(gasMerchantStationDO.getPartnerId(), gasMerchantStationDO.getPlatPartnerId());
        }
        //清结算商户信息
//        List<MerchantInfoDO> merchantInfos =
//                xybMerchantTestBase.findMerchantInfoByPartnerId(gasMerchantStationDO.getPartnerId());
//        if (testId == 1002) {
//            xybMerchantByplatPartnerId(merchantInfos.get(0), gasMerchantStationDO.getPlatPartnerId(),
//                    gasMerchantStationDO.getPartnerId(),
//                    null, stationName, "PARTNER");
//        } else {
//            xybMerchantByplatPartnerId(merchantInfos.get(0), gasMerchantStationDO.getPlatPartnerId(),
//                    gasMerchantStationDO.getPartnerId(),
//                    null, stationName, "PLATFORM");
//        }
        //删除油站
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
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
package com.xjy.autotest.gas.test.station;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.StationManagePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_merchant.GasMerchantUserDO;
import dal.model.gas_merchant.GasStationOilGunDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/16.
 */
public class UpdateOilGunWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @AutoTest(file = "gas/updateOilGunWebTest.csv")
    @DisplayName("配置油枪--成功用例")
    public void updateOilGunWebTest(
            int testId,
            String userName,
            String password,
            String oldOilGun,
            String oilGun,
            String oilGun1,
            String platPartnerId,
            String partnerId,
            String stationCode,
            String stationName,
            String oilCode,
            String oilCode1,
            String oilName,
            String oilName1,
            String addr) {
        //清除数据
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
        //准备数据
        //油站
        Map<String, Object> params = gasMerchantInitDataBase.initStationsForUpdate(platPartnerId, partnerId,
                stationCode, stationName, null, addr, oilCode, oilName,
                oilCode1, oilName1, "ABLE");
        String stationId = params.get("stationId").toString();
        //配置油枪
        if (testId == 1002) {
            gas_merchantTestBase.cleanGasStationOilGunByStationId(stationId);
            gas_merchantTestBase.insertGasStationOilGun(0L, partnerId, platPartnerId, stationId, oldOilGun, oilCode,
                    null, null, 1);
        }
        //获取登录员信息
        GasMerchantUserDO operator =
                gas_merchantTestBase.findGasMerchantUserByUqKeyAndUserType(userName, "BOSS").get(0);
        //油枪
        StationManagePage.OilGunPageOrder oilGunPageOrder = new StationManagePage().new OilGunPageOrder();
        oilGunPageOrder.setOilGun(oilGun);
        oilGunPageOrder.setOilName(oilName);
        StationManagePage.OilGunPageOrder oilGunPageOrder1 = new StationManagePage().new OilGunPageOrder();
        oilGunPageOrder1.setOilGun(oilGun1);
        oilGunPageOrder1.setOilName(oilName1);
        List<String> oldOilGuns = new ArrayList<>();
        if (testId == 1002) {
            oldOilGuns.add(oldOilGun);
        }
        List<StationManagePage.OilGunPageOrder> newOilGuns = new ArrayList<>();
        newOilGuns.add(oilGunPageOrder);
        newOilGuns.add(oilGunPageOrder1);
        //打开加好油中台页面
        open(testUrlGas);
        //配置油枪
        StationManagePage stationManagePage = new GasLoginPage()
                .login(userName, password)
                .stationCenter()
                .stationManage()
                .editOilGun(stationCode, oldOilGuns, newOilGuns);
        //数据验证
        sleep(3);
        //页面元素校验
//        StationManagePage.checkOilGunData(stationCode, newOilGuns);
        //数据库数据验证
        List<GasStationOilGunDO> oilGunInfos =
                gas_merchantTestBase.findGasStationOilGunByStationId(stationId);
        assertEquals(2, oilGunInfos.size());
        for (GasStationOilGunDO oilGunInfo : oilGunInfos) {
            if (oilGun.equals(oilGunInfo.getOilGunNo())) {
                assertEquals(oilCode, oilGunInfo.getGoodsCode());
            }
            if (oilGun1.equals(oilGunInfo.getOilGunNo())) {
                assertEquals(oilCode1, oilGunInfo.getGoodsCode());
            }
        }
        //删除站长信息
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        gas_merchantTestBase.cleanGasStationGoodsByStationId(stationId);
        gas_merchantTestBase.cleanGasStationOilGunByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
    }
}

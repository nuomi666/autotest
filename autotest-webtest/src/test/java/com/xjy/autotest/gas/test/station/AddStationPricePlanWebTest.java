package com.xjy.autotest.gas.test.station;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.MerchantPricePlanManagePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import com.xjy.autotest.utils.DateUtils;
import dal.model.gas_merchant.GasMerchantGoodsDO;
import dal.model.gas_merchant.GasMerchantGoodsPricePlanDO;
import dal.model.gas_merchant.GasMerchantUserDO;
import dal.model.gas_merchant.GasStationGoodsPricePlanDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/12.
 */
public class AddStationPricePlanWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @AutoTest(file = "gas/addStationPricePlanWeb.csv")
    @DisplayName("新增油价计划--成功用例")
    public void addStationPricePlanWeb(
            int testId,
            String username,
            String password,
            String priceName,
            String platPartnerId,
            String partnerId,
            String partnerId1,
            String stationCode,
            String stationCode1,
            String stationName,
            String stationName1,
            String oilCode,
            String oilCode1,
            String oilName,
            String oilName1,
            String addr,
            String addr1) {
        //清除数据
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode1);
        gas_merchantTestBase.cleanGasMerchantGoodsPricePlanByPriceName(priceName);
        gas_merchantTestBase.cleanGasStationGoodsPricePlanByPriceName(priceName);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode1);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName1);
        //准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, 0, 10);
        List<String> stations = new ArrayList<>();
        List<String> oils = new ArrayList<>();
        //油站
        Map<String, Object> params = gasMerchantInitDataBase.initStationsForUpdate(platPartnerId, partnerId,
                stationCode, stationName, null, addr, oilCode, oilName,
                oilCode1, oilName1, "ABLE");
        Map<String, Object> params1 = gasMerchantInitDataBase.initStationsForUpdate(platPartnerId, partnerId1,
                stationCode1, stationName1, null, addr1, oilCode, oilName,
                oilCode1, oilName1, "ABLE");
        String stationId = params.get("stationId").toString();
        String stationId1 = params1.get("stationId").toString();
        stations.add(stationName);
        stations.add(stationName1);
        //获取登录员信息
        GasMerchantUserDO operator =
                gas_merchantTestBase.findGasMerchantUserByUqKeyAndUserType(username, "BOSS").get(0);
        //油品
        List<GasMerchantGoodsDO> merchantGoodsDOS =
                gas_merchantTestBase.findGasMerchantGoodsByPlatPartnerId(platPartnerId);
        for (GasMerchantGoodsDO merchantGoodsDO : merchantGoodsDOS) {
            if ("OIL".equals(merchantGoodsDO.getGoodsType())) {
                oils.add(merchantGoodsDO.getGoodsName());
            }
        }
        //打开加好油中台页面
        open(testUrlGas);
        //新增油价
        MerchantPricePlanManagePage oilPriceManagerPage = new GasLoginPage()
                .login(username, password)
                .stationCenter()
                .oilPriceManager()
                .addMerchantPricePlan(priceName, effectTime, stations, oils);
        //数据验证
        GasMerchantGoodsPricePlanDO merchantPrice =
                gas_merchantTestBase.findGasMerchantGoodsPricePlanByPriceName(priceName).get(0);
        List<GasStationGoodsPricePlanDO> stationPrices =
                gas_merchantTestBase.findGasStationGoodsPricePlanByMerchantPlanId(merchantPrice.getPlanId());
        //页面元素校验
        oilPriceManagerPage.checkData(priceName, effectTime, operator.getUserName(), merchantPrice.getRawAddTime());
        //数据库数据验证
        List<String> stationsxx = new ArrayList<>();
        for (GasStationGoodsPricePlanDO price : stationPrices) {
            assertEquals(effectTime, price.getEffectTime());
            stationsxx.add(price.getStationId());
        }
        assertEquals(2, stationsxx.size());
        assertTrue(stationsxx.contains(stationId));
        assertTrue(stationsxx.contains(stationId1));
        //删除站长信息
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode1);
        gas_merchantTestBase.cleanGasStationGoodsByStationId(stationId);
        gas_merchantTestBase.cleanGasStationGoodsByStationId(stationId1);
        gas_merchantTestBase.cleanGasMerchantGoodsPricePlanByPriceName(priceName);
        gas_merchantTestBase.cleanGasStationGoodsPricePlanByPriceName(priceName);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName1);
    }
}

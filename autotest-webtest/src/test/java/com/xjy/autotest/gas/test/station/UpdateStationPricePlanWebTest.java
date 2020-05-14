package com.xjy.autotest.gas.test.station;

import com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.StationPricePlanManagePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import dal.model.gas_merchant.GasMerchantUserDO;
import dal.model.gas_merchant.GasStationGoodsPricePlanDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/13.
 */
public class UpdateStationPricePlanWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @AutoTest(file = "gas/updateStationPricePlanWebTest.csv")
    @DisplayName("编辑油站油价计划--成功用例")
    public void updateStationPricePlanWebTest(
            int testId,
            String username,
            String password,
            String planId,
            String priceName,
            String priceNamexx,
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
        gas_merchantTestBase.cleanGasMerchantGoodsPricePlanByPriceName(priceName);
        gas_merchantTestBase.cleanGasMerchantGoodsPricePlanByPriceName(priceNamexx);
        gas_merchantTestBase.cleanGasStationGoodsPricePlanByPlanId(planId);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
        //准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, 0, 10);
        Date effectTimexx = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 1, 0, 30);
        List<String> oils = new ArrayList<>();
        oils.add(oilName);
        oils.add(oilName1);
        //油站
        Map<String, Object> params = gasMerchantInitDataBase.initStationsForUpdate(platPartnerId, partnerId,
                stationCode, stationName, null, addr, oilCode, oilName,
                oilCode1, oilName1, "ABLE");
        String stationId = params.get("stationId").toString();
        //获取登录员信息
        GasMerchantUserDO operator =
                gas_merchantTestBase.findGasMerchantUserByUqKeyAndUserType(username, "BOSS").get(0);
        //油站油价
        Set<GoodsPriceOrder> goodsPriceOrders = new HashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsName(oilName);
        priceOrder.setGoodsCode(oilCode);
        priceOrder.setGoodsPrice(new Money(3.5));
        priceOrder.setListedPrice(new Money(3.8));
        priceOrder.setGoodsType(GoodsType.OIL);
        GoodsPriceOrder priceOrder1 = new GoodsPriceOrder();
        priceOrder1.setGoodsName(oilName1);
        priceOrder1.setGoodsCode(oilCode1);
        priceOrder1.setGoodsPrice(new Money(3.6));
        priceOrder1.setListedPrice(new Money(3.7));
        priceOrder1.setGoodsType(GoodsType.OIL);
        goodsPriceOrders.add(priceOrder);
        goodsPriceOrders.add(priceOrder1);
        //准备一个油站创建的油价
        gas_merchantTestBase.insertGasStationGoodsPricePlan(0l, planId, null, priceName, null,
                platPartnerId, stationId, effectTime, "Y", "1k52xtphusg021hge6uv", "jh", null, null,
                JSON.toJSONString(goodsPriceOrders));
        //打开加好油中台页面
        open(testUrlGas);
        //新增站长
        StationPricePlanManagePage stationPriceManagerPage = new GasLoginPage()
                .login(username, password)
                .stationCenter()
                .stationPricePlanManage()
                .editStationPricePlan(stationName, priceNamexx, effectTimexx, oils);
        //数据验证
        sleep(3);
        List<GasStationGoodsPricePlanDO> stationPricesxx =
                gas_merchantTestBase.findGasStationGoodsPricePlanByPriceName(priceNamexx);
        //页面元素校验
        stationPriceManagerPage.checkData(stationName, priceNamexx, effectTimexx, operator.getUserName(),
                stationPricesxx.get(0).getRawAddTime());
        //数据库数据验证
        List<GasStationGoodsPricePlanDO> prices =
                gas_merchantTestBase.findGasStationGoodsPricePlanByPlanId(planId);
        priceAssert(prices.get(0), partnerId,
                stationId, planId, priceNamexx,
                JSON.toJSONString(goodsPriceOrders), operator.getUserId(),
                operator.getUserName(), effectTimexx);
        //删除站长信息
        gas_merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        gas_merchantTestBase.cleanGasStationGoodsByStationId(stationId);
        gas_merchantTestBase.cleanGasMerchantGoodsPricePlanByPriceName(priceName);
        gas_merchantTestBase.cleanGasMerchantGoodsPricePlanByPriceName(priceNamexx);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerAbbrName(stationName);
    }

    /**
     * 油站油价信息
     */
    private void priceAssert(GasStationGoodsPricePlanDO price,
                             String partnerId,
                             String stationId,
                             String planId,
                             String name,
                             String goodsInfo,
                             String operatorId,
                             String operatorName,
                             Date effectTime
    ) {
        assertEquals(partnerId, price.getPlatPartnerId());
        assertEquals(partnerId, price.getPartnerId());
        assertEquals(stationId, price.getStationId());
        assertEquals(planId, price.getPlanId());
        assertEquals(null, price.getMerchantPlanId());
        assertEquals(name, price.getPriceName());
        assertNotEquals(goodsInfo, price.getGoodsInfo());
        assertEquals(effectTime, price.getEffectTime());
        assertEquals("Y", price.getDeleteFlag());
        assertEquals(operatorId, price.getOperatorId());
        assertEquals(operatorName, price.getOperatorName());
//        assertNotEquals(price.getRawAddTime(), price.getRawUpdateTime());
    }
}

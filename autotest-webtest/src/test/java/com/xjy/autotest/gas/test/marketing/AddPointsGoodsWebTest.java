package com.xjy.autotest.gas.test.marketing;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.marketing.PointsManagePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import com.xyb.adk.common.util.DateUtil;
import dal.model.gas_merchant.GasMallExchangeGoodsDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2020-02-26.
 */
public class AddPointsGoodsWebTest extends WebTestBase {
    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @AutoTest(file = "gas/addPointsGoodsWebTestSuccess.csv")
    @DisplayName("新增积分兑换商品--成功用例")
    public void addPointsGoodsWebTestSuccess(
            int testId,
            String goodsType,
            String entityGoodsName,
            String upload,
            String entityGoodsDescription,
            String entityExchangePoint,
            String entityStoreNum,
            String entityOneExchangeTimes,
            String entityForSaleTime,
            String entityInvalidTime,
            List<String> entityGainStations
    ) {
        //清除数据
        gas_merchantTestBase.cleanGasMallExchangeGoodsByGoodsName(entityGoodsName);
        //打开加好油中台页面
        open(testUrlGas);
        //准备数据
        upload = "autotest/gas/goods.jpeg";
        //登录新增积分商品
        PointsManagePage pointsManagePage = new GasLoginPage()
                .login(USER_NAME_JHY, PASS_WORD_JHY)
                .marketingCenter()
                .points()
                .addGoods(goodsType, entityGoodsName, upload, entityGoodsDescription,
                        entityExchangePoint, entityStoreNum, entityOneExchangeTimes, entityForSaleTime, entityInvalidTime, entityGainStations);
        //页面数据验证
        pointsManagePage.checkdata(entityGoodsName, entityExchangePoint, entityStoreNum);
        //删除记录
        //数据库数据验证
        GasMallExchangeGoodsDO gasMallExchangeGoodsDO = gas_merchantTestBase.findGasMallExchangeGoodsByGoodsName(entityGoodsName).get(0);
        assertEquals(goodsType, gasMallExchangeGoodsDO.getGoodsType());
        assertEquals(entityGoodsDescription, gasMallExchangeGoodsDO.getGoodsDescription());
        assertEquals(entityForSaleTime, DateUtil.simpleFormat(gasMallExchangeGoodsDO.getForSaleTime()));
        assertEquals(entityInvalidTime, DateUtil.simpleFormat(gasMallExchangeGoodsDO.getInvalidTime()));
        assertEquals(entityExchangePoint, gasMallExchangeGoodsDO.getExchangePoint() + "");
        assertEquals(entityStoreNum, gasMallExchangeGoodsDO.getStoreNum() + "");
        assertEquals(entityOneExchangeTimes, gasMallExchangeGoodsDO.getOneExchangeTimes() + "");
        //删除数据
        gas_merchantTestBase.cleanGasMallExchangeGoodsByGoodsName(entityGoodsName);

    }
}

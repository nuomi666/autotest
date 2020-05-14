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

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2020-02-26.
 */
public class AddPointsCouponWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @AutoTest(file = "gas/addPointsCouponWebTestSuccess.csv")
    @DisplayName("新增积分兑换优惠券--成功用例")
    public void addPointsCouponWebTestSuccess(
            int testId,
            String goodsType,
            String couponGoodsName,
            String couponExchangePoint,
            String couponStoreNum,
            String couponOneExchangeTimes,
            String couponForSaleTime,
            String couponInvalidTime,
            String couponGoodsDescription
    ) {
        //清除数据
        gas_merchantTestBase.cleanGasMallExchangeGoodsByGoodsName(couponGoodsName);
        //打开加好油中台页面
        open(testUrlGas);
        //登录新增积分兑换优惠券
        PointsManagePage pointsManagePage = new GasLoginPage()
                .login(USER_NAME_JHY, PASS_WORD_JHY)
                .marketingCenter()
                .points()
                .addCoupon(goodsType, couponGoodsName, couponExchangePoint,
                        couponStoreNum, couponOneExchangeTimes, couponForSaleTime, couponInvalidTime, couponGoodsDescription);
        //页面数据验证
        pointsManagePage.checkdata(couponGoodsName, couponExchangePoint, couponStoreNum);
        //删除记录
        //数据库数据验证
        GasMallExchangeGoodsDO gasMallExchangeGoodsDO = gas_merchantTestBase.findGasMallExchangeGoodsByGoodsName(couponGoodsName).get(0);
        assertEquals(goodsType, gasMallExchangeGoodsDO.getGoodsType());
        assertEquals(couponGoodsDescription, gasMallExchangeGoodsDO.getGoodsDescription());
        assertEquals(couponForSaleTime, DateUtil.simpleFormat(gasMallExchangeGoodsDO.getForSaleTime()));
        assertEquals(couponInvalidTime, DateUtil.simpleFormat(gasMallExchangeGoodsDO.getInvalidTime()));
        assertEquals(couponExchangePoint, gasMallExchangeGoodsDO.getExchangePoint() + "");
        assertEquals(couponStoreNum, gasMallExchangeGoodsDO.getStoreNum() + "");
        assertEquals(couponOneExchangeTimes, gasMallExchangeGoodsDO.getOneExchangeTimes() + "");
        //删除数据
        gas_merchantTestBase.cleanGasMallExchangeGoodsByGoodsName(couponGoodsName);

    }
}

package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.order.DeleteStatipnPricePlanOrder;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import dal.model.gas_merchant.GasStationGoodsPricePlanDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author nuomi
 * Created on 2020/01/08.
 */
public class MerchantStationServiceDeleteStatipnPricePlanTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceDeleteStatipnPricePlanTestSuccess.csv")
    @DisplayName("删除油站执行油价--成功用例")
    public void merchantStationServiceDeleteStatipnPricePlanTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId,
            String stationId,
            String goodsName,
            String goodsCode,
            Money price,
            Money listedPrice,
            DeleteStatipnPricePlanOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByPlanId(order.getPlanId());
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date effectTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 1, 0, 0);
        Set<GoodsPriceOrder> goodsPriceOrders = new HashSet();
        GoodsPriceOrder priceOrder = new GoodsPriceOrder();
        priceOrder.setGoodsName(goodsName);
        priceOrder.setGoodsCode(goodsCode);
        priceOrder.setGoodsPrice(price);
        priceOrder.setListedPrice(listedPrice);
        priceOrder.setGoodsType(GoodsType.OIL);
        goodsPriceOrders.add(priceOrder);
        merchantTestBase.insertGasStationGoodsPricePlan(0l, order.getPlanId(), null, "测试油价11", partnerId,
                partnerId, stationId, effectTime, "Y", null, null, null, null,
                JSON.toJSONString(goodsPriceOrders));
        // 测试过程
        // 调用接口
        BizResult result = merchantStationService.deleteStatipnPricePlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasStationGoodsPricePlanDO> prices =
                merchantTestBase.findGasStationGoodsPricePlanByPlanId(order.getPlanId());
        assertEquals(0, prices.size());
        // 清除数据
        merchantTestBase.cleanGasStationGoodsPricePlanByPlanId(order.getPlanId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceDeleteStatipnPricePlanTestFailOne.csv")
    @DisplayName("删除油站执行油价--参数非法")
    public void merchantStationServiceDeleteStatipnPricePlanTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeleteStatipnPricePlanOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlanId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult result = merchantStationService.deleteStatipnPricePlan(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.ExchangeType;
import com.xyb.gas.merchant.api.enums.GainStyle;
import com.xyb.gas.merchant.api.facade.MallExchangeGoodsService;
import com.xyb.gas.merchant.api.order.DeleteMallExchangeGoodsOrder;
import dal.model.gas_merchant.GasMallExchangeGoodsDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/29.
 */
public class MallExchangeGoodsServiceDeleteTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MallExchangeGoodsService mallExchangeGoodsService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.删除优惠券
     * 1002.删除实物
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceDeleteTestSuccess.csv")
    @DisplayName("删除积分商城商品--成功用例")
    public void mallExchangeGoodsServiceDeleteTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeleteMallExchangeGoodsOrder order,
            String goodsId, String goodsName,
            ExchangeType exchangeType, GainStyle gainStyle, String station
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        List<String> gainStations = new ArrayList<String>();
        if (testId == 1002) {
            gainStations.add(station);
        }
        Map<String, Object> param = gasMerchantInitDataBase.initMallExchangeGoodsSimple(order.getPlatPartnerId(),
                goodsId, goodsName, exchangeType.code(), "sss", gainStyle.code(),
                JSON.toJSONString(gainStations));
        Long id = Long.valueOf(param.get("id").toString());
        // 测试过程
        order.setId(id);
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = mallExchangeGoodsService.deleteMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMallExchangeGoodsDO> genMallExchangeGoodsDOS = gasMerchantTestBase.findGasMallExchangeGoodsById(id);
        assertTrue(genMallExchangeGoodsDOS.size() == 0);
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsById(order.getId());
    }

    /**
     * 1001.id为空
     * 1002.gid为空
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceDeleteTestFailOne.csv")
    @DisplayName("删除积分商城商品--参数非法")
    public void mallExchangeGoodsServiceDeleteTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeleteMallExchangeGoodsOrder order,
            Long id
    ) {
        // 清除数据

        // 准备数据

        // 测试过程
        order.setId(id);
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = mallExchangeGoodsService.deleteMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001.积分商城商品不存在
     * 1002.积分商城商品不属于该商户
     */
    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceDeleteTestFailTwo.csv")
    @DisplayName("删除积分商城商品--失败用例")
    public void mallExchangeGoodsServiceDeleteTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeleteMallExchangeGoodsOrder order,
            String goodsId, String goodsName,
            ExchangeType exchangeType, GainStyle gainStyle, String station
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        List<String> gainStations = new ArrayList<String>();
        if (testId == 1002) {
            gainStations.add(station);
        }
        Map<String, Object> param = gasMerchantInitDataBase.initMallExchangeGoodsSimple("S0301909161100092061",
                goodsId, goodsName, exchangeType.code(), "sss", gainStyle.code(),
                JSON.toJSONString(gainStations));
        Long id = Long.valueOf(param.get("id").toString());
        // 测试过程
        if (testId == 1002) {
            order.setId(id);
        }
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = mallExchangeGoodsService.deleteMallExchangeGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMallExchangeGoodsDO> genMallExchangeGoodsDOS1 = gasMerchantTestBase.findGasMallExchangeGoodsById(id);
        assertTrue(genMallExchangeGoodsDOS1.size() == 1);
        // 清除数据
        gasMerchantTestBase.cleanGasMallExchangeGoodsById(id);
    }
}

package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.info.GoodsInfo;
import com.xyb.gas.merchant.api.order.QueryStationGoodsOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/08.
 */
public class MerchantStationServiceQueryStationGoodsCodeTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceQueryStationGoodsCodeTestSuccess.csv")
    @DisplayName("查询油站配置商品信息--成功用例")
    public void merchantStationServiceQueryStationGoodsCodeTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String stationId,
            String goodsName, String goodsCode,
            String goodsName1, String goodsCode1,
            QueryStationGoodsOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasStationGoodsByStationId(stationId);
        // 准备数据
        gasMerchantInitDataBase.initGasStationGoods(platPartnerId, stationId,
                goodsName, goodsCode, goodsName1, goodsCode1,
                null, null);
        // 测试过程
        order.setStationId(stationId);
        // 调用接口
        BizCollectionResult<GoodsInfo> result = merchantStationService.queryStationGoodsCode(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        assertEquals(2, result.getInfos().size());
        List<String> oilCodes = new ArrayList<>();
        for (GoodsInfo oilInfo : result.getInfos()) {
            oilCodes.add(oilInfo.getGoodsCode());
            if (goodsCode.equals(oilInfo.getGoodsCode())) {
                oilAssert(oilInfo, null, goodsCode, goodsName);
            }
            if (goodsCode1.equals(oilInfo.getGoodsCode())) {
                oilAssert(oilInfo, null, goodsCode1, goodsName1);
            }
        }
        assertTrue(oilCodes.contains(goodsCode));
        assertTrue(oilCodes.contains(goodsCode1));
        // 清除数据
        merchantTestBase.cleanGasStationGoodsByStationId(stationId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceQueryStationGoodsCodeTestFailOne.csv")
    @DisplayName("查询油站配置商品信息--参数非法")
    public void merchantStationServiceQueryStationGoodsCodeTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryStationGoodsOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setStationId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizCollectionResult<GoodsInfo> result = merchantStationService.queryStationGoodsCode(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 油品信息
     */
    private void oilAssert(GoodsInfo oil,
                           Long goodsId,
                           String goodsCode,
                           String goodsName
    ) {
        assertEquals(null, oil.getId());
        assertEquals(goodsCode, oil.getGoodsCode());
        assertEquals(goodsName, oil.getGoodsName());
        assertEquals(GoodsType.OIL, oil.getGoodsType());
        assertEquals(null, oil.getGoodsGroupType());
        assertEquals(null, oil.getOrderNo());
    }
}

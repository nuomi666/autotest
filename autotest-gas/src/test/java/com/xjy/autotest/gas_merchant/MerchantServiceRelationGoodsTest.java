package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.order.RelationMerchantGoodsOrder;
import dal.model.gas_merchant.GasMerchantGoodsDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class MerchantServiceRelationGoodsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceRelationGoodsTestSuccess.csv")
    @DisplayName("关联商品--成功用例")
    public void merchantServiceRelationGoodsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RelationMerchantGoodsOrder order,
            RelationMerchantGoodsOrder.MerchantGoodsOrder oilGoodsOrder,
            RelationMerchantGoodsOrder.MerchantGoodsOrder goodsOrder
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantGoodsByPartnerId(order.getPartnerId());
        // 准备数据
        // 测试过程
        List<RelationMerchantGoodsOrder.MerchantGoodsOrder> goodOrders = new ArrayList<>();
        goodOrders.add(oilGoodsOrder);
        if (testId == 1002) {
            goodOrders.add(goodsOrder);
        }
        order.setOrders(goodOrders);
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantService.relationGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//		assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantGoodsDO> merchantGoodsInfos =
                gasMerchantTestBase.findGasMerchantGoodsByPartnerId(order.getPartnerId());
        if (testId == 1001) {
            assertTrue(merchantGoodsInfos.size() == 1);
            for (GasMerchantGoodsDO merchantGoodsInfo : merchantGoodsInfos) {
                assertEquals(oilGoodsOrder.getGoodsCode(), merchantGoodsInfo.getGoodsCode());
                assertEquals(oilGoodsOrder.getGoodsName(), merchantGoodsInfo.getGoodsName());
                assertEquals(oilGoodsOrder.getGoodsType().code(), merchantGoodsInfo.getGoodsType());
                assertEquals(oilGoodsOrder.getOrderNo(), merchantGoodsInfo.getOrderNo());
            }
        } else {
            assertTrue(merchantGoodsInfos.size() == 2);
            for (GasMerchantGoodsDO merchantGoodsInfo : merchantGoodsInfos) {
                if (oilGoodsOrder.getGoodsType().code().equals(merchantGoodsInfo.getGoodsType())) {
                    assertEquals(oilGoodsOrder.getGoodsCode(), merchantGoodsInfo.getGoodsCode());
                    assertEquals(oilGoodsOrder.getGoodsName(), merchantGoodsInfo.getGoodsName());
                    assertEquals(oilGoodsOrder.getOrderNo(), merchantGoodsInfo.getOrderNo());
                }
                if (goodsOrder.getGoodsType().code().equals(merchantGoodsInfo.getGoodsType())) {
                    assertEquals(goodsOrder.getGoodsCode(), merchantGoodsInfo.getGoodsCode());
                    assertEquals(goodsOrder.getGoodsName(), merchantGoodsInfo.getGoodsName());
                    assertEquals(goodsOrder.getOrderNo(), merchantGoodsInfo.getOrderNo());
                }
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantGoodsByPartnerId(order.getPartnerId());
    }
}

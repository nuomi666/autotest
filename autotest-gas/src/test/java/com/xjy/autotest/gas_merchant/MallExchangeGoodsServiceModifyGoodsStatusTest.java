//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.facade.MallExchangeGoodsService;
//import com.xyb.gas.merchant.api.order.ChangeMallExchangeGoodsStatusOrder;
//import dal.model.gas_merchant.GasMallExchangeGoodsDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/10/08.
// */
//public class MallExchangeGoodsServiceModifyGoodsStatusTest extends SpringBootTestBase {
//
//    @Reference(version = DUBBO_VERSION_1)
//    MallExchangeGoodsService mallExchangeGoodsService;
//
//    @Autowired
//    Gas_merchantTestBase gasMerchantTestBase;
//
//    /**
//     * 1001.接口已废弃
//     */
//    @AutoTest(file = "gas_merchant/mallExchangeGoodsServiceModifyGoodsStatusTestSuccess.csv")
//    @DisplayName("修改积分商品状态--成功用例")
//    public void mallExchangeGoodsServiceModifyGoodsStatusTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            ChangeMallExchangeGoodsStatusOrder order,
//            GasMallExchangeGoodsDO gasMallExchangeGoodsDO,
//            GasMallExchangeGoodsDO gasMallExchangeGoodsDO1
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO.getPartnerId());
//        gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO1.getPartnerId());
//        // 准备数据
//        gasMerchantTestBase.insertGasMallExchangeGoods(gasMallExchangeGoodsDO);
//        gasMerchantTestBase.insertGasMallExchangeGoods(gasMallExchangeGoodsDO1);
//        // 测试过程
//        List<GasMallExchangeGoodsDO> mallExchangeGoodsDOS =
//                gasMerchantTestBase.findGasMallExchangeGoodsByGoodsId(gasMallExchangeGoodsDO.getGoodsId());
//        List<GasMallExchangeGoodsDO> mallExchangeGoodsDOS1 =
//                gasMerchantTestBase.findGasMallExchangeGoodsByGoodsId(gasMallExchangeGoodsDO1.getGoodsId());
//        long id = mallExchangeGoodsDOS.get(0).getId();
//        long idxx = mallExchangeGoodsDOS1.get(0).getId();
//        order.setId(id);
//        order.setGid(GID.newGID());
//        // 调用接口
//        SimpleResult result = mallExchangeGoodsService.changeMallExchangeGoodsStatus(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        List<GasMallExchangeGoodsDO> genMallExchangeGoodsDOS = gasMerchantTestBase.findGasMallExchangeGoodsById(id);
//        List<GasMallExchangeGoodsDO> genMallExchangeGoodsDOS1 = gasMerchantTestBase.findGasMallExchangeGoodsById
//        (idxx);
//        assertTrue(genMallExchangeGoodsDOS.size() > 0);
//        for (GasMallExchangeGoodsDO genMallExchangeGoodsDO : genMallExchangeGoodsDOS) {
//            assertEquals(mallExchangeGoodsDOS.get(0).getExchangePoint(), genMallExchangeGoodsDO.getExchangePoint());
//            assertEquals(0, genMallExchangeGoodsDO.getExchangedCount().intValue());
//            assertEquals(0, genMallExchangeGoodsDO.getFreezeStoreNum().intValue());
//            assertEquals(mallExchangeGoodsDOS.get(0).getOneExchangeTimes(),
//                    genMallExchangeGoodsDO.getOneExchangeTimes());
//            assertEquals(mallExchangeGoodsDOS.get(0).getStoreNum(), genMallExchangeGoodsDO.getStoreNum());
//            assertEquals(mallExchangeGoodsDOS.get(0).getGainStyle(), genMallExchangeGoodsDO.getGainStyle());
//            assertEquals(mallExchangeGoodsDOS.get(0).getGoodsName(), genMallExchangeGoodsDO.getGoodsName());
//            //assertEquals(mallExchangeGoodsDOS.get(0).getGainStations(),genMallExchangeGoodsDO1.getGainStation());
//            assertEquals(mallExchangeGoodsDOS.get(0).getGoodsImg(), genMallExchangeGoodsDO.getGoodsImg());
//            assertEquals(mallExchangeGoodsDOS.get(0).getGoodsDescription(),
//                    genMallExchangeGoodsDO.getGoodsDescription());
//            assertEquals(mallExchangeGoodsDOS.get(0).getGoodsType(), genMallExchangeGoodsDO.getGoodsType());
//            assertEquals(mallExchangeGoodsDOS.get(0).getInvalidTime(), genMallExchangeGoodsDO.getInvalidTime());
//            assertEquals(mallExchangeGoodsDOS.get(0).getPartnerId(), genMallExchangeGoodsDO.getPartnerId());
//        }
//        assertTrue(genMallExchangeGoodsDOS1.size() > 0);
//        for (GasMallExchangeGoodsDO genMallExchangeGoodsDO1 : genMallExchangeGoodsDOS1) {
//            assertEquals(mallExchangeGoodsDOS1.get(0).getExchangePoint(), genMallExchangeGoodsDO1.getExchangePoint());
//            assertEquals(0, genMallExchangeGoodsDO1.getExchangedCount().intValue());
//            assertEquals(0, genMallExchangeGoodsDO1.getFreezeStoreNum().intValue());
//            assertEquals(mallExchangeGoodsDOS1.get(0).getOneExchangeTimes(),
//                    genMallExchangeGoodsDO1.getOneExchangeTimes());
//            assertEquals(mallExchangeGoodsDOS1.get(0).getStoreNum(), genMallExchangeGoodsDO1.getStoreNum());
//            assertEquals(mallExchangeGoodsDOS1.get(0).getGainStyle(), genMallExchangeGoodsDO1.getGainStyle());
//            assertEquals(mallExchangeGoodsDOS1.get(0).getGoodsName(), genMallExchangeGoodsDO1.getGoodsName());
//            //assertEquals(mallExchangeGoodsDOS1.get(0).getGainStations(),genMallExchangeGoodsDO1.getGainStation());
//            assertEquals(mallExchangeGoodsDOS1.get(0).getGoodsImg(), genMallExchangeGoodsDO1.getGoodsImg());
//            assertEquals(mallExchangeGoodsDOS1.get(0).getGoodsDescription(),
//                    genMallExchangeGoodsDO1.getGoodsDescription());
//            assertEquals(mallExchangeGoodsDOS1.get(0).getGoodsType(), genMallExchangeGoodsDO1.getGoodsType());
//            assertEquals(mallExchangeGoodsDOS1.get(0).getInvalidTime(), genMallExchangeGoodsDO1.getInvalidTime());
//            assertEquals(mallExchangeGoodsDOS1.get(0).getPartnerId(), genMallExchangeGoodsDO1.getPartnerId());
//        }
//        // 清除数据
//        gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO.getPartnerId());
//        gasMerchantTestBase.cleanGasMallExchangeGoodsByPartnerId(gasMallExchangeGoodsDO1.getPartnerId());
//    }
//}

package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.GoodsGroupType;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantDeviceService;
import com.xyb.gas.merchant.api.info.StationOilGunInfo;
import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author nuomi
 * Created on 2019/11/15.
 */
public class MerchantDeviceServiceQueryOilGunTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantDeviceService merchantDeviceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceQueryOilGunTestSuccess.csv")
    @DisplayName("查询油站油枪信息--成功用例")
    public void merchantDeviceServiceQueryOilGunTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            //油品
            String platPartnerId, String stationId,
            String goodsName, String goodsCode,
            String goodsName1, String goodsCode1,
            String goodsName2, String goodsCode2,
            //油枪
            String oilGunNo, int sortNo,
            String oilGunNo1, int sortNo1,
            String oilGunNo2, int sortNo2,
            CommonBaseOrder order
    ) {
        // 清除数据
        // 准备数据
        //商家油号
        gasMerchantInitDataBase.initGasMerchantGoods(platPartnerId, GoodsGroupType.GASOLINE.code(),
                GoodsType.OIL.code(), goodsName, goodsCode,
                GoodsGroupType.GASOLINE.code(), GoodsType.OIL.code(), goodsName1, goodsCode1,
                GoodsGroupType.DIESEL_OIL.code(), GoodsType.OIL.code(), goodsName2,
                goodsCode2);
        gasMerchantInitDataBase.initGasStationOilGun(platPartnerId, stationId, oilGunNo, goodsCode, sortNo, oilGunNo1
                , goodsCode1, sortNo1, oilGunNo2, goodsCode2, sortNo2);
        // 测试过程
        order.setId(stationId);
        // 调用接口
        BizCollectionResult<StationOilGunInfo> result = merchantDeviceService.queryOilGun(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        for (StationOilGunInfo gunInfo : result.getInfos()) {
            assertEquals(platPartnerId, gunInfo.getPlatPartnerId());
            assertEquals(stationId, gunInfo.getStationId());
            if (oilGunNo.equals(gunInfo.getOilGunNo())) {
                assertEquals(goodsName, gunInfo.getGoodsName());
                assertEquals(goodsCode, gunInfo.getGoodsCode());
                assertEquals(sortNo, gunInfo.getSortNo());
            }
            if (oilGunNo1.equals(gunInfo.getOilGunNo())) {
                assertEquals(goodsName1, gunInfo.getGoodsName());
                assertEquals(goodsCode1, gunInfo.getGoodsCode());
                assertEquals(sortNo1, gunInfo.getSortNo());
            }
            if (oilGunNo2.equals(gunInfo.getOilGunNo())) {
                assertEquals(goodsName2, gunInfo.getGoodsName());
                assertEquals(goodsCode2, gunInfo.getGoodsCode());
                assertEquals(sortNo2, gunInfo.getSortNo());
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode2);
        gasMerchantTestBase.cleanGasStationOilGunByStationId(stationId);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode2);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantDeviceServiceQueryOilGunTestFailOne.csv")
    @DisplayName("查询油站油枪信息--参数非法")
    public void merchantDeviceServiceQueryOilGunTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonBaseOrder order
    ) {
        // 清除数据
        // 准备数据

        // 测试过程
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
        BizCollectionResult<StationOilGunInfo> result = merchantDeviceService.queryOilGun(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据

    }
}

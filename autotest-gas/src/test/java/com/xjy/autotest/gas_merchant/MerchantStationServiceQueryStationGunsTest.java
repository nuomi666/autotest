package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.info.StationOilGunInfo;
import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/08.
 */
public class MerchantStationServiceQueryStationGunsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceQueryStationGunsTestSuccess.csv")
    @DisplayName("查询油站油枪配置信息--成功用例")
    public void merchantStationServiceQueryStationGunsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String stationId, String stationCode,
            String stationName, String goodsName,
            String goodsName1,
            String goodsCode, String goodsCode1,
            String oilGun, String oilGun1,
            CommonBaseOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasStationOilGunByStationId(stationId);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        // 准备数据
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, stationId, stationName, stationCode,
                null, EnableStatus.ABLE.code(), goodsName, goodsCode, oilGun, null, null);
        if (testId == 1002) {
            merchantTestBase.insertGasMerchantGoods(0L, platPartnerId, platPartnerId, goodsName1, goodsCode1,
                    GoodsType.OIL.code(), null, null, null,
                    null, null, null, "ABLE", null, null);
            merchantTestBase.insertGasStationOilGun(0L, platPartnerId, platPartnerId, stationId, oilGun1, goodsCode1,
                    null, null, 2);
        }
        // 测试过程
        order.setId(stationId);
        // 调用接口
        BizCollectionResult<StationOilGunInfo> result = merchantStationService.queryStationGuns(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(1, result.getInfos().size());
            oilGunAssert(result.getInfos().iterator().next(), platPartnerId,
                    stationId, oilGun, goodsCode, goodsName, 1);
        }
        if (testId == 1002) {
            assertEquals(2, result.getInfos().size());
            List<String> oilGunNos = new ArrayList<>();
            for (StationOilGunInfo oilGunInfo : result.getInfos()) {
                oilGunNos.add(oilGunInfo.getOilGunNo());
                if (oilGun.equals(oilGunInfo.getOilGunNo())) {
                    oilGunAssert(oilGunInfo, platPartnerId,
                            stationId, oilGun, goodsCode, goodsName, 1);
                }
                if (oilGun1.equals(oilGunInfo.getOilGunNo())) {
                    oilGunAssert(oilGunInfo, platPartnerId,
                            stationId, oilGun1, goodsCode1, goodsName1, 2);
                }
            }
            assertTrue(oilGunNos.contains(oilGun));
            assertTrue(oilGunNos.contains(oilGun1));
        }
        // 清除数据
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasStationOilGunByStationId(stationId);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceQueryStationGunsTestFailOne.csv")
    @DisplayName("查询油站油枪配置信息--参数非法")
    public void merchantStationServiceQueryStationGunsTestFailOne(
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
        BizCollectionResult<StationOilGunInfo> result = merchantStationService.queryStationGuns(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 油枪信息
     */
    private void oilGunAssert(StationOilGunInfo oilGun,
                              String partnerId,
                              String stationId,
                              String oilGunNo,
                              String goodsCode,
                              String goodsName,
                              int sortNo
    ) {
        assertEquals(partnerId, oilGun.getPlatPartnerId());
        assertEquals(partnerId, oilGun.getPartnerId());
        assertEquals(stationId, oilGun.getStationId());
        assertEquals(oilGunNo, oilGun.getOilGunNo());
        assertEquals(goodsName, oilGun.getGoodsName());
        assertEquals(goodsCode, oilGun.getGoodsCode());
        assertEquals(null, oilGun.getGoodsGroupType());
        assertEquals(sortNo, oilGun.getSortNo());
    }
}

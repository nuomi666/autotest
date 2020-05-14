package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.order.ManageOilGunOrder;
import com.xyb.gas.merchant.api.order.OilGunOrder;
import dal.model.gas_merchant.GasStationOilGunDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/01/08.
 */
public class MerchantStationServiceManageOilGunTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceManageOilGunTestSuccess.csv")
    @DisplayName("油站油枪配置--成功用例")
    public void merchantStationServiceManageOilGunTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String stationId,
            String goodsCode,
            String goodsCode1,
            String gunNo,
            String gunNo1,
            int sortNo,
            int sortNo1,
            ManageOilGunOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasStationOilGunByStationId(stationId);
        // 准备数据
        // 测试过程
        List<OilGunOrder> oilGunOrderList = new ArrayList<OilGunOrder>();
        OilGunOrder oilGunOrder = new OilGunOrder();
        oilGunOrder.setGoodsCode(goodsCode);
        oilGunOrder.setOilGunNo(gunNo);
        oilGunOrder.setSortNo(sortNo);
        OilGunOrder oilGunOrder1 = new OilGunOrder();
        oilGunOrder1.setGoodsCode(goodsCode1);
        oilGunOrder1.setOilGunNo(gunNo1);
        oilGunOrder1.setSortNo(sortNo1);
        oilGunOrderList.add(oilGunOrder);
        if (testId == 1002) {
            oilGunOrderList.add(oilGunOrder1);
        }
        order.setOilGunOrderList(oilGunOrderList);
        order.setStationId(stationId);
        // 调用接口
        SimpleResult result = merchantStationService.manageOilGun(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasStationOilGunDO> oilGuns = merchantTestBase.findGasStationOilGunByStationId(stationId);
        if (testId == 1001) {
            assertEquals(1, oilGuns.size());
            oilGunAssert(oilGuns.get(0), order.getPartnerId(),
                    stationId, gunNo, goodsCode, sortNo);
        }
        if (testId == 1002) {
            assertEquals(2, oilGuns.size());
            List<String> oilGunNos = new ArrayList<>();
            for (GasStationOilGunDO oilGunInfo : oilGuns) {
                oilGunNos.add(oilGunInfo.getOilGunNo());
                if (gunNo.equals(oilGunInfo.getOilGunNo())) {
                    oilGunAssert(oilGunInfo, order.getPartnerId(),
                            stationId, gunNo, goodsCode, sortNo);
                }
                if (gunNo1.equals(oilGunInfo.getOilGunNo())) {
                    oilGunAssert(oilGunInfo, order.getPartnerId(),
                            stationId, gunNo1, goodsCode1, sortNo1);
                }
            }
            assertTrue(oilGunNos.contains(gunNo));
            assertTrue(oilGunNos.contains(gunNo1));
        }
        // 清除数据
        merchantTestBase.cleanGasStationOilGunByStationId(stationId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceManageOilGunTestFailOne.csv")
    @DisplayName("油站油枪配置--参数非法")
    public void merchantStationServiceManageOilGunTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String stationId,
            String goodsCode,
            String gunNo,
            int sortNo,
            ManageOilGunOrder order
    ) {
        // 清除数据
        merchantTestBase.cleanGasStationOilGunByStationId(stationId);
        // 准备数据
        // 测试过程
        List<OilGunOrder> oilGunOrderList = new ArrayList<OilGunOrder>();
        OilGunOrder oilGunOrder = new OilGunOrder();
        oilGunOrder.setGoodsCode(goodsCode);
        oilGunOrder.setOilGunNo(gunNo);
        oilGunOrder.setSortNo(sortNo);
        oilGunOrderList.add(oilGunOrder);
        order.setOilGunOrderList(oilGunOrderList);
        if (testId == 1001) {
            order.setStationId(null);
        }
        if (testId == 1002) {
            order.setOilGunOrderList(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantStationService.manageOilGun(order);
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
    private void oilGunAssert(GasStationOilGunDO oilGun,
                              String partnerId,
                              String stationId,
                              String oilGunNo,
                              String goodsCode,
                              int sortNo
    ) {
        assertEquals(partnerId, oilGun.getPlatPartnerId());
        assertEquals(partnerId, oilGun.getPartnerId());
        assertEquals(stationId, oilGun.getStationId());
        assertEquals(oilGunNo, oilGun.getOilGunNo());
        assertEquals(goodsCode, oilGun.getGoodsCode());
        assertEquals(sortNo, oilGun.getSortNo());
    }
}

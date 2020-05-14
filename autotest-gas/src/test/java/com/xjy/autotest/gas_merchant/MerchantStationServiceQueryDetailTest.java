package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.enums.GoodsType;
import com.xyb.gas.merchant.api.facade.MerchantStationService;
import com.xyb.gas.merchant.api.info.MerchantStationDetailInfo;
import com.xyb.gas.merchant.api.info.StationOilGunInfo;
import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/28.
 */
public class MerchantStationServiceQueryDetailTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantStationService merchantStationService;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceQueryDetailTestSuccess.csv")
    @DisplayName("查询油站详情--成功用例")
    public void merchantStationServiceQueryDetailTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String stationCode, String stationName,
            String oilGunNo, String oilGunNo1,
            String goodsCode, String goodsCode1,
            String goodsName, String goodsName1,
            int sortNo, int sortNo1,
            CommonBaseOrder order
    ) {
        // 清除数据
        // 准备数据
        Date rawAddTime = DateUtils.parseDate2("2019-11-20 14:19:47");
        //油站
        gasMerchantInitDataBase.initStationsWithOilGun(platPartnerId, order.getId(), stationName, stationCode,
                null, EnableStatus.ABLE.code(), goodsName, goodsCode, oilGunNo, rawAddTime, rawAddTime);
        //油枪2
        merchantTestBase.insertGasMerchantGoods(0L, platPartnerId, platPartnerId, goodsName1, goodsCode1,
                GoodsType.OIL.code(), null, null, null,
                null, null, null, "ABLE", null, null);
        merchantTestBase.insertGasStationOilGun(0L, platPartnerId, platPartnerId, order.getId(), oilGunNo1, goodsCode1,
                null, null, 2);
        // 测试过程
        // 调用接口
        BizResult<MerchantStationDetailInfo> result = merchantStationService.queryDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        MerchantStationDetailInfo stationInfo = result.getInfo();
        assertEquals(platPartnerId, stationInfo.getPlatPartnerId());
        assertEquals(platPartnerId, stationInfo.getPartnerId());
        assertEquals(order.getId(), stationInfo.getStationId());
        assertEquals(stationCode, stationInfo.getStationCode());
        assertEquals(stationName, stationInfo.getStationName());
        assertEquals("金开大道互联网产业园13幢3楼", stationInfo.getStationAddress());
        assertEquals(EnableStatus.ABLE, stationInfo.getStatus());
        assertEquals(null, stationInfo.getPhoneNo());
        assertEquals(false, stationInfo.getConnectOilMachine().booleanValue());
        assertEquals(500000L, stationInfo.getProvinceId());
        assertEquals("重庆市", stationInfo.getProvinceName());
        assertEquals(500100L, stationInfo.getCityId());
        assertEquals("市辖区", stationInfo.getCityName());
        assertEquals(500112L, stationInfo.getDistrictId());
        assertEquals("渝北区", stationInfo.getDistrictName());
        assertEquals(rawAddTime, stationInfo.getRawAddTime());
        assertEquals(rawAddTime, stationInfo.getRawUpdateTime());
        List<StationOilGunInfo> oilGunInfos = stationInfo.getOilGunInfos();
        assertEquals(platPartnerId, oilGunInfos.get(0).getPlatPartnerId());
        assertEquals(platPartnerId, oilGunInfos.get(0).getPartnerId());
        assertEquals(order.getId(), oilGunInfos.get(0).getStationId());
        assertEquals(oilGunNo, oilGunInfos.get(0).getOilGunNo());
        assertEquals(goodsCode, oilGunInfos.get(0).getGoodsCode());
        assertEquals(goodsName, oilGunInfos.get(0).getGoodsName());
        assertEquals(sortNo, oilGunInfos.get(0).getSortNo());
        assertEquals(platPartnerId, oilGunInfos.get(1).getPlatPartnerId());
        assertEquals(platPartnerId, oilGunInfos.get(1).getPartnerId());
        assertEquals(order.getId(), oilGunInfos.get(1).getStationId());
        assertEquals(oilGunNo1, oilGunInfos.get(1).getOilGunNo());
        assertEquals(goodsCode1, oilGunInfos.get(1).getGoodsCode());
        assertEquals(goodsName1, oilGunInfos.get(1).getGoodsName());
        assertEquals(sortNo1, oilGunInfos.get(1).getSortNo());
        // 清除数据
        merchantTestBase.cleanGasMerchantGoodsByPlatPartnerId(platPartnerId);
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        merchantTestBase.cleanGasStationOilGunByStationId(order.getId());
        merchantTestBase.cleanGasMerchantStationByStationId(order.getId());
        silverboltTestBase.cleanGasMerchantStationByStationId(order.getId());
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
        silverboltTestBase.cleanGasMerchantGoodsByPartnerId(platPartnerId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantStationServiceQueryDetailTestFailOne.csv")
    @DisplayName("查询油站详情--参数非法")
    public void merchantStationServiceQueryDetailTestFailOne(
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
        BizResult<MerchantStationDetailInfo> result = merchantStationService.queryDetail(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

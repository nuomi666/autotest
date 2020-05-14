package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.BasicManageService;
import com.xyb.gas.merchant.api.info.GoodsInfo;
import com.xyb.gas.merchant.api.order.common.CommonAbstractOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2019/10/09.
 */
public class BasicManageServiceQueryGoodsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    BasicManageService basicManageService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;


    /**
     * 1001.查询油品
     * 1002.查询商品
     */
    @AutoTest(file = "gas_merchant/basicManageServiceQueryGoodsTestSuccess.csv")
    @DisplayName("查询单个商品--成功用例")
    public void basicManageServiceQueryGoodsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonAbstractOrder order,
            Long id, String goodsCode, String goodsType, String goodsGroupType,
            String goodsName, Date rawAddTime, Date rawUpdateTime
    ) {
        // 清除数据

        // 准备数据
        Map<String, Object> params = gasMerchantInitDataBase.initGasGoods(goodsCode, goodsType, goodsGroupType,
                goodsName, rawAddTime, rawUpdateTime);
        for (String key : params.keySet()) {
            if ("goodsId".equals(key)) {
                id = Long.valueOf(params.get(key).toString());
            }
        }
        // 测试过程
        order.setId(id);
        order.setGid(GID.newGID());
        // 调用接口
        BizResult<GoodsInfo> result = basicManageService.queryGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        GoodsInfo goodsInfo = result.getInfo();
        assertEquals(goodsCode, goodsInfo.getGoodsCode());
        assertEquals(goodsName, goodsInfo.getGoodsName());
        assertEquals(goodsGroupType, goodsInfo.getGoodsGroupType());
        assertEquals(goodsType, goodsInfo.getGoodsType());
        assertEquals(null, goodsInfo.getOrderNo());
        // 清除数据
        gasMerchantTestBase.cleanGasGoodsById(order.getId());
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
    }

    /**
     * 1001.id为空
     * 1002.gid为空
     * 1003.order为空
     */
    @AutoTest(file = "gas_merchant/basicManageServiceQueryGoodsTestFailOne.csv")
    @DisplayName("查询单个商品--参数非法")
    public void basicManageServiceQueryGoodsTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonAbstractOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setId(null);
        }
        order.setGid(GID.newGID());
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<GoodsInfo> result = basicManageService.queryGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001.未查询到数据
     */
    @AutoTest(file = "gas_merchant/basicManageServiceQueryGoodsTestFailTwo.csv")
    @DisplayName("查询单个商品--失败用例")
    public void basicManageServiceQueryGoodsTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonAbstractOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasGoodsById(order.getId());
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        // 调用接口
        BizResult<GoodsInfo> result = basicManageService.queryGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        GoodsInfo goodsInfo = result.getInfo();
        // 清除数据
        gasMerchantTestBase.cleanGasGoodsById(order.getId());
    }
}

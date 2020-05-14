package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.BasicManageService;
import com.xyb.gas.merchant.api.order.ManageGoodsOrder;
import dal.model.gas_merchant.GasGoodsDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/26.
 */
public class BasicManageServiceManageGoodsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    BasicManageService basicManageService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001新增商品，只传必填项
     * 1002新增油品，传入所有项
     * 1003根据id更新已有油品
     * 1004根据id更新已有油品为商品
     */
    @AutoTest(file = "gas_merchant/basicManageServiceManageGoodsTestSuccess.csv")
    @DisplayName("添加商品--成功用例")
    public void basicManageServiceManageGoodsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            Long id,
            String goodsCode, String goodsType, String goodsGroupType,
            String goodsName, Date rawAddTime, Date rawUpdateTime,
            ManageGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(order.getGoodsCode());
        // 准备数据
        if (testId == 1003 || testId == 1004) {
            Map<String, Object> params = gasMerchantInitDataBase.initGasGoods(goodsCode, goodsType, goodsGroupType,
                    goodsName, rawAddTime, rawUpdateTime);
            for (String key : params.keySet()) {
                if ("goodsId".equals(key)) {
                    id = Long.valueOf(params.get(key).toString());
                }
            }
        }
        // 测试过程
        if (testId == 1003 || testId == 1004) {
            order.setId(id);
        }
        // 调用接口
        SimpleResult result = basicManageService.manageGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        sleep(3);
        // 数据验证
        if (testId == 1003) {
            gasGoodsAssert(1, order.getGoodsCode(), order.getGoodsGroupType().code(), null, order.getGoodsName(),
                    order.getGoodsType().code(), order.getOrderNo(), rawAddTime, DateUtils.getSqlDate());
        } else {
            gasGoodsAssert(1, order.getGoodsCode(), order.getGoodsGroupType().code(), null, order.getGoodsName(),
                    order.getGoodsType().code(), order.getOrderNo(), DateUtils.getSqlDate(), DateUtils.getSqlDate());
        }
        // 清除数据
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(order.getGoodsCode());
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(order.getGoodsCode());
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/basicManageServiceManageGoodsTestFailOne.csv")
    @DisplayName("添加商品--参数非法")
    public void basicManageServiceManageGoodsTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ManageGoodsOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setGoodsCode(null);
        }
        if (testId == 1002) {
            order.setGoodsName(null);
        }
        if (testId == 1003) {
            order.setGoodsType(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = basicManageService.manageGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        //assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * 1001已存在相同商品
     * 1002更新的商品不存在
     */
    @AutoTest(file = "gas_merchant/basicManageServiceManageGoodsTestFailTwo.csv")
    @DisplayName("添加商品--失败用例")
    public void basicManageServiceManageGoodsTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            Long id,
            String goodsCode, String goodsType, String goodsGroupType,
            String goodsName, Date rawAddTime, Date rawUpdateTime,
            ManageGoodsOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasGoodsById(id);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        // 准备数据
        if (testId == 1001) {
            Map<String, Object> params = gasMerchantInitDataBase.initGasGoods(goodsCode, goodsType, goodsGroupType,
                    goodsName, rawAddTime, rawUpdateTime);
            for (String key : params.keySet()) {
                if ("goodsId".equals(key)) {
                    id = Long.valueOf(params.get(key).toString());
                }
            }
        }
        // 测试过程
        if (testId == 1002) {
            order.setId(id);
        }
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = basicManageService.manageGoods(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//		assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
        gasMerchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
    }

    /**
     * 断言商品信息
     *
     * @param count
     * @param goodsCode
     * @param goodsGroupType
     * @param groupId
     * @param goodsName
     * @param goodsType
     * @param orderNo
     * @param rawAddTime
     * @param rawUpdateTime
     */
    private void gasGoodsAssert(
            Integer count,
            String goodsCode,
            String goodsGroupType,
            Long groupId,
            String goodsName,
            String goodsType,
            Integer orderNo,
            Date rawAddTime,
            Date rawUpdateTime
    ) {
        List<GasGoodsDO> goods = gasMerchantTestBase.findGasGoodsByGoodsCode(goodsCode);
        assertEquals(count, goods.size());
        for (GasGoodsDO gasGoodsDO : goods) {
            assertEquals(goodsType, gasGoodsDO.getGoodsType());
            assertEquals(goodsGroupType, gasGoodsDO.getGoodsGroupType());
            assertEquals(groupId, gasGoodsDO.getGroupId());
            assertEquals(goodsName, gasGoodsDO.getGoodsName());
            assertEquals(goodsCode, gasGoodsDO.getGoodsCode());
            assertEquals(orderNo, gasGoodsDO.getOrderNo());
            assertEquals(DateUtils.formatDate(rawAddTime), DateUtils.formatDate(gasGoodsDO.getRawAddTime()));
            assertEquals(DateUtils.formatDate(rawUpdateTime), DateUtils.formatDate(gasGoodsDO.getRawUpdateTime()));
        }
        //分析数据校验
        List<dal.model.gas_silverbolt.GasGoodsDO> goods1 = silverboltTestBase.findGasGoodsByGoodsCode(goodsCode);
        assertEquals(count, goods1.size());
        for (dal.model.gas_silverbolt.GasGoodsDO gasGoodsDO : goods1) {
            assertEquals(goodsType, gasGoodsDO.getGoodsType());
            assertEquals(goodsGroupType, gasGoodsDO.getGoodsGroupType());
            assertEquals(groupId, gasGoodsDO.getGroupId());
            assertEquals(goodsName, gasGoodsDO.getGoodsName());
            assertEquals(goodsCode, gasGoodsDO.getGoodsCode());
            assertEquals(orderNo, gasGoodsDO.getOrderNo());
            assertEquals(DateUtils.formatDate(rawAddTime), DateUtils.formatDate(gasGoodsDO.getRawAddTime()));
            assertEquals(DateUtils.formatDate(rawUpdateTime), DateUtils.formatDate(gasGoodsDO.getRawUpdateTime()));
        }
    }
}

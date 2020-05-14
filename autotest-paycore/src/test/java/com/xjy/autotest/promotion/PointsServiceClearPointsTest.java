package com.xjy.autotest.promotion;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.promotion.InstructionDO;
import dal.model.promotion.PointsDO;
import dal.model.promotion.PointsLogDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.promotion.api.points.params.PointsResult;
import com.xyb.promotion.api.points.PointsService;
import com.xyb.promotion.api.points.params.ClearPointsOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/02/21.
 */
@DisplayName("清理积分")
public class PointsServiceClearPointsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "points.default")
    PointsService pointsService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 清理100积分
     * 1002 清理500积分
     * 1003 清理全部积分
     * 1004 清理100积分,重复请求
     */
    @AutoTest(file = "promotion/pointsServiceClearPointsTestSuccess.csv")
    @DisplayName("清理积分--成功用例")
    public void pointsServiceClearPointsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ClearPointsOrder order,
            PointsDO pointsDO
    ) {
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
        // 准备数据
        promotionTestBase.insertPoints(pointsDO);
        // 测试过程
        if (testId == 1004) {
            pointsService.clearPoints(order);
        }
        // 调用接口
        PointsResult result = pointsService.clearPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        long point = order.getPoints().longValue();
        if (testId == 1003) {
            point = pointsDO.getPoints();
        }
        if(testId == 1004){
            assertTrue(result.isIdempotent());
        }
        // 数据验证
        PointsDO pointsDO1 = promotionTestBase.findPointsByUserId(order.getUserId()).get(0);
        assertEquals(order.getPartnerId(), pointsDO1.getPartnerId());
        assertEquals(order.getPlatPartnerId(), pointsDO1.getPlatPartnerId());
        assertEquals(order.getUserId(), pointsDO1.getUserId());
        assertEquals(pointsDO.getPoints() - point, pointsDO1.getPoints());
        assertEquals(point + pointsDO.getHistorySubtractPoints(), pointsDO1.getHistorySubtractPoints());
        assertEquals(result.getPoints().longValue(), pointsDO1.getPoints());

        PointsLogDO pointsLogDO = promotionTestBase.findPointsLogByMerchantOrderNo(order.getMerchantOrderNo()).get(0);
        assertEquals(pointsDO1.getPointId(), pointsLogDO.getPointId());
        assertEquals(order.getGid(), pointsLogDO.getGid());
        assertEquals(order.getReqId(), pointsLogDO.getReqId());
        assertEquals(order.getPlatPartnerId(), pointsLogDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), pointsLogDO.getPlatMerchantOrderNo());
        assertEquals(order.getPartnerId(), pointsLogDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), pointsLogDO.getMerchantOrderNo());
        assertEquals(order.getUserId(), pointsLogDO.getUserId());
        assertEquals(point, pointsLogDO.getPoints());
        assertEquals(result.getInstructionId(), pointsLogDO.getInstructionId());
        if (testId <= 1002 || testId == 1004) {
            assertEquals("SUBTRACT", pointsLogDO.getType());
        }
        if (testId == 1003) {
            assertEquals("CLEAR", pointsLogDO.getType());
        }
        assertNotNull(pointsLogDO.getRawAddTime());
        assertNotNull(pointsLogDO.getRawUpdateTime());
        String instructionId = result.getInstructionId();
        InstructionDO instructionDO = promotionTestBase.findInstructionByInstructionId(instructionId).get(0);
        assertEquals(order.getGid(), instructionDO.getGid());
        assertEquals(order.getReqId(), instructionDO.getReqId());
        assertEquals(order.getPlatPartnerId(), instructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), instructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getPartnerId(), instructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), instructionDO.getMerchantOrderNo());
        assertEquals("clearPoints", instructionDO.getInstructionType());
        assertEquals("SUCCESS", instructionDO.getStatus());
        assertEquals(result.getFinishTime(), instructionDO.getRawUpdateTime());
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
    }

    /**
     * 1001 points传空
     */
    @AutoTest(file = "promotion/pointsServiceClearPointsTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void pointsServiceClearPointsTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ClearPointsOrder order,
            PointsDO pointsDO
    ) {
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
        // 准备数据
        // 测试过程
        // 调用接口
        PointsResult result = pointsService.clearPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
    }

    /**
     * 1001 会员不存在
     * 1002 积分不足
     * 1003 清理-1积分
     */
    @AutoTest(file = "promotion/pointsServiceClearPointsTestFailTwo.csv")
    @DisplayName("清理积分失败--失败用例")
    public void pointsServiceClearPointsTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ClearPointsOrder order,
            PointsDO pointsDO
    ) {
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
        // 准备数据
        if (testId != 1001) {
            promotionTestBase.insertPoints(pointsDO);
        }
        // 测试过程
        // 调用接口
        PointsResult result = pointsService.clearPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        if (testId != 1001) {
            PointsDO pointsDO1 = promotionTestBase.findPointsByUserId(order.getUserId()).get(0);
            assertEquals(pointsDO, pointsDO1);
        }
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
    }
}

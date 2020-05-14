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
import com.xyb.promotion.api.points.params.AddPointsOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/02/21.
 */
@DisplayName("叠加积分")
public class PointsServiceAddPointsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "points.default")
    PointsService pointsService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 新用户增加100积分
     * 1002 老用户增加200积分
     * 1003 老用户增加200积分,重复请求
     */
    @AutoTest(file = "promotion/pointsServiceAddPointsTestSuccess.csv")
    @DisplayName("叠加积分--成功用例")
    public void pointsServiceAddPointsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddPointsOrder order,
            PointsDO pointsDO
    ) {
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
        // 准备数据
        if (testId != 1001) {
            promotionTestBase.insertPoints(pointsDO);
        }
        if(testId == 1003){
            pointsService.addPoints(order);
        }
        // 测试过程
        // 调用接口
        PointsResult result = pointsService.addPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        if(testId == 1003){
            assertTrue(result.isIdempotent());
        }
        // 数据验证
        PointsDO pointsDO1 = promotionTestBase.findPointsByUserId(order.getUserId()).get(0);
        assertEquals(order.getPartnerId(), pointsDO1.getPartnerId());
        assertEquals(order.getPlatPartnerId(), pointsDO1.getPlatPartnerId());
        assertEquals(order.getUserId(), pointsDO1.getUserId());
        if (testId == 1001) {
            assertEquals(order.getPoints().longValue(), pointsDO1.getPoints());
            assertEquals(order.getPoints().longValue(), pointsDO1.getHistoryAddPoints());
            assertEquals(result.getPoints(), order.getPoints());
        }
        if (testId >= 1002) {
            assertEquals(order.getPoints().longValue() + pointsDO.getPoints(), pointsDO1.getPoints());
            assertEquals(order.getPoints().longValue() + pointsDO.getHistoryAddPoints(), pointsDO1.getHistoryAddPoints());
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
            assertEquals(order.getPoints().longValue(), pointsLogDO.getPoints());
            assertEquals(result.getInstructionId(), pointsLogDO.getInstructionId());
            assertEquals(result.getFinishTime(), pointsLogDO.getRawAddTime());
            assertEquals("ADD", pointsLogDO.getType());
            assertNotNull(pointsLogDO.getRawAddTime());
            assertNotNull(pointsLogDO.getRawUpdateTime());
        }
        String instructionId = result.getInstructionId();
        InstructionDO instructionDO = promotionTestBase.findInstructionByInstructionId(instructionId).get(0);
        assertEquals(order.getGid(), instructionDO.getGid());
        assertEquals(order.getReqId(), instructionDO.getReqId());
        assertEquals(order.getPlatPartnerId(), instructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), instructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getPartnerId(), instructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), instructionDO.getMerchantOrderNo());
        assertEquals("addPoints", instructionDO.getInstructionType());
        assertEquals("SUCCESS", instructionDO.getStatus());
        assertEquals(result.getFinishTime(), instructionDO.getRawUpdateTime());
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());

    }

    /**
     * 1001 userId传空
     * 1002 points传空
     */
    @AutoTest(file = "promotion/pointsServiceAddPointsTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void pointsServiceAddPointsTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddPointsOrder order,
            PointsDO pointsDO
    ) {
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
        // 准备数据
        // 测试过程
        // 调用接口
        PointsResult result = pointsService.addPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
    }

    /**
     * 1001 积分为0
     * 1002 积分为-1
     */
    @AutoTest(file = "promotion/pointsServiceAddPointsTestFailTwo.csv")
    @DisplayName("叠加积分失败--失败用例")
    public void pointsServiceAddPointsTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            AddPointsOrder order,
            PointsDO pointsDO
    ) {
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());
        // 准备数据
        // 测试过程
        // 调用接口
        PointsResult result = pointsService.addPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1002) {
            assertEquals(0, promotionTestBase.findPointsByUserId(order.getUserId()).size());
        }
        // 清除数据
        promotionTestBase.cleanPointsByUserId(order.getUserId());
        promotionTestBase.cleanPointsLogByUserId(order.getUserId());

    }
}

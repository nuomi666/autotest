package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.points.PointsService;
import com.xyb.promotion.api.points.params.AddPointsOrder;
import com.xyb.promotion.api.points.params.ClearPointsOrder;
import com.xyb.promotion.api.points.params.PointsResult;
import com.xyb.promotion.api.points.params.ReversePointsOrder;
import dal.model.promotion.InstructionDO;
import dal.model.promotion.PointsDO;
import dal.model.promotion.PointsLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/03/12.
 */
public class PointsServiceReversePointsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "points.default")
    PointsService pointsService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 撤销新增积分操作
     * 1002 撤销清理积分操作
     * 1003 撤销清零积分操作
     * 1004 重复撤销新增积分操作
     * 1005 重复撤销清理积分操作
     * 1006 重复撤销清零积分操作
     */
    @AutoTest(file = "promotion/pointsServiceReversePointsTestSuccess.csv")
    @DisplayName("撤销积分操作--成功用例")
    public void pointsServiceReversePointsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ReversePointsOrder order,
            AddPointsOrder addPointsOrder,
            ClearPointsOrder clearPointsOrder,
            PointsDO pointsDO
    ) {
        // 清除数据
        promotionTestBase.cleanPointsByUserId(clearPointsOrder.getUserId());
        promotionTestBase.cleanPointsLogByUserId(clearPointsOrder.getUserId());
        // 准备数据
        promotionTestBase.insertPoints(pointsDO);
        // 测试过程
        if (testId == 1001 || testId == 1004) {
            PointsResult result1 = pointsService.addPoints(addPointsOrder);
            print(result1);
        } else {
            PointsResult result2 = pointsService.clearPoints(clearPointsOrder);
            print(result2);
        }
        if (testId == 1001 || testId == 1004) {
            order.setOriginReqId(addPointsOrder.getReqId());
        } else {
            order.setOriginReqId(clearPointsOrder.getReqId());
        }
        PointsResult result1 = null;
        if (testId >= 1004) {
            result1 = pointsService.reversePoints(order);
        }
        // 调用接口
        PointsResult result = pointsService.reversePoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        if (testId >= 1004) {
            assertEquals(result1.getFinishTime(), result.getFinishTime());
            assertEquals(result1.getPoints(), result.getPoints());
            assertEquals(result1.getInstructionId(), result.getInstructionId());
            assertTrue(result.isIdempotent());
        }
        // 数据验证
        PointsDO pointsDO1 = promotionTestBase.findPointsByUserId(addPointsOrder.getUserId()).get(0);
        assertEquals(pointsDO.getPoints(), pointsDO1.getPoints());
        assertEquals(result.getPoints().longValue(), pointsDO1.getPoints());

        PointsLogDO pointsLogDO = promotionTestBase.findPointsLogByReqId(order.getOriginReqId()).get(0);
        if (testId == 1001 || testId == 1004) {
            assertEquals(addPointsOrder.getGid(), pointsLogDO.getGid());
            assertEquals(addPointsOrder.getPlatPartnerId(), pointsLogDO.getPlatPartnerId());
            assertEquals(addPointsOrder.getPlatMerchantOrderNo(), pointsLogDO.getPlatMerchantOrderNo());
            assertEquals(addPointsOrder.getPartnerId(), pointsLogDO.getPartnerId());
            assertEquals(addPointsOrder.getMerchantOrderNo(), pointsLogDO.getMerchantOrderNo());
            assertEquals(addPointsOrder.getUserId(), pointsLogDO.getUserId());
            assertEquals(addPointsOrder.getPoints().longValue(), pointsLogDO.getPoints());
            assertEquals("ADD_REVERSED", pointsLogDO.getType());
        } else {
            assertEquals(clearPointsOrder.getGid(), pointsLogDO.getGid());
            assertEquals(clearPointsOrder.getPlatPartnerId(), pointsLogDO.getPlatPartnerId());
            assertEquals(clearPointsOrder.getPlatMerchantOrderNo(), pointsLogDO.getPlatMerchantOrderNo());
            assertEquals(clearPointsOrder.getPartnerId(), pointsLogDO.getPartnerId());
            assertEquals(clearPointsOrder.getMerchantOrderNo(), pointsLogDO.getMerchantOrderNo());
            assertEquals(clearPointsOrder.getUserId(), pointsLogDO.getUserId());
            if (testId == 1002 || testId == 1005) {
                assertEquals(clearPointsOrder.getPoints().longValue(), pointsLogDO.getPoints());
                assertEquals("SUBTRACT_REVERSED", pointsLogDO.getType());
            } else {
                assertEquals(pointsDO.getPoints(), pointsLogDO.getPoints());
                assertEquals("CLEAR_REVERSED", pointsLogDO.getType());
            }
        }
        String instructionId = result.getInstructionId();
        InstructionDO instructionDO = promotionTestBase.findInstructionByInstructionId(instructionId).get(0);
        assertEquals(order.getGid(), instructionDO.getGid());
        assertEquals(order.getReqId(), instructionDO.getReqId());
        assertEquals(order.getPlatPartnerId(), instructionDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), instructionDO.getPlatMerchantOrderNo());
        assertEquals(order.getPartnerId(), instructionDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), instructionDO.getMerchantOrderNo());
        assertEquals("reversePoints", instructionDO.getInstructionType());
        assertEquals("SUCCESS", instructionDO.getStatus());
        assertEquals(result.getFinishTime(), instructionDO.getRawUpdateTime());
        // 清除数据
    }
}

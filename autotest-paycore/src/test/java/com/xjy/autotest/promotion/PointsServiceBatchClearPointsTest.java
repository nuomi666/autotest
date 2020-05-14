package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.points.PointsService;
import com.xyb.promotion.api.points.params.BatchClearPointsOrder;
import com.xyb.promotion.api.points.params.BatchPointsResult;
import dal.model.promotion.PointsDO;
import dal.model.promotion.PointsLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author huairen
 * Created on 2019/02/21.
 */
@DisplayName("批量清除积分")
public class PointsServiceBatchClearPointsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "points.default")
    PointsService pointsService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 批量清除1个会员积分1次100积分
     * 1002 批量清除1个会员积分2次300积分
     * 1003 批量清除1个会员积分全部积分
     * 1004 批量清除2个会员积分300+300积分
     * 1005 批量清除3个会员积分100+200+300积分
     * 1006 批量清除3个会员积分不传时间
     * 1007 批量清除2个会员积分300+300积分，重复清除积分
     * 1008 批量清除1个会员积分101有效积分
     * 1009 批量清除1个会员积分0有效积分
     */
    @AutoTest(file = "promotion/pointsServiceBatchClearPointsTestSuccess.csv")
    @DisplayName("批量清除积分--成功用例")
    public void pointsServiceBatchClearPointsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            BatchClearPointsOrder order,
            String userId,
            String userId1,
            String userId2,
            String sType,
            PointsDO pointsDO,
            PointsDO pointsDO1,
            PointsDO pointsDO2,
            PointsLogDO pointsLogDO,
            PointsLogDO pointsLogDO1,
            PointsLogDO pointsLogDO2

    ) {
        // 清除数据
        promotionTestBase.cleanPointsByUserId(userId);
        promotionTestBase.cleanPointsByUserId(userId1);
        promotionTestBase.cleanPointsByUserId(userId2);
        promotionTestBase.cleanPointsLogByUserId(userId);
        promotionTestBase.cleanPointsLogByUserId(userId1);
        promotionTestBase.cleanPointsLogByUserId(userId2);
        // 准备数据
        promotionTestBase.insertPoints(pointsDO);
        promotionTestBase.insertPoints(pointsDO1);
        promotionTestBase.insertPoints(pointsDO2);
        promotionTestBase.insertPointsLog(pointsLogDO);
        promotionTestBase.insertPointsLog(pointsLogDO1);
        promotionTestBase.insertPointsLog(pointsLogDO2);
        // 测试过程
        List<String> userIds = new ArrayList<String>();
        userIds.add(userId);
        if (testId >= 1004 && testId <= 1007) {
            userIds.add(userId1);
        }
        if (testId >= 1005 && testId <= 1007) {
            userIds.add(userId2);
        }
        order.setUserIds(userIds);
        if (testId == 1007) {
            pointsService.batchClearPoints(order);
        }
        // 调用接口
        BatchPointsResult result = pointsService.batchClearPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        PointsDO pDO = promotionTestBase.findPointsByUserId(userId).get(0);
        PointsDO pDO1 = promotionTestBase.findPointsByUserId(userId1).get(0);
        PointsDO pDO2 = promotionTestBase.findPointsByUserId(userId2).get(0);
        if (testId == 1001) {
            assertEquals(pointsDO.getPoints() - pointsLogDO.getPoints(), pDO.getPoints());
            assertEquals(order.getDate(), pDO.getLastClearTime());
        }
        if (testId == 1002) {
            assertEquals(pointsDO.getPoints() - pointsLogDO.getPoints() - pointsLogDO1.getPoints()
                    , pDO.getPoints());
            assertEquals(order.getDate(), pDO.getLastClearTime());
        }
        if (testId == 1003) {
            assertEquals(pointsDO.getPoints() - pointsLogDO.getPoints() - pointsLogDO1.getPoints() - pointsLogDO2.getPoints()
                    , pDO.getPoints());
            assertEquals(order.getDate(), pDO.getLastClearTime());
        }
        if (testId == 1004 || testId == 1007) {
            assertEquals(pointsDO.getPoints() - pointsLogDO.getPoints()
                    , pDO.getPoints());
            assertEquals(pointsDO1.getPoints() - pointsLogDO2.getPoints()
                    , pDO1.getPoints());
            assertEquals(order.getDate(), pDO.getLastClearTime());
            assertEquals(order.getDate(), pDO1.getLastClearTime());
        }
        if (testId == 1005) {
            assertEquals(pointsDO.getPoints() - pointsLogDO.getPoints()
                    , pDO.getPoints());
            assertEquals(pointsDO1.getPoints() - pointsLogDO1.getPoints()
                    , pDO1.getPoints());
            assertEquals(pointsDO2.getPoints() - pointsLogDO2.getPoints()
                    , pDO2.getPoints());
            assertEquals(order.getDate(), pDO.getLastClearTime());
            assertEquals(order.getDate(), pDO1.getLastClearTime());
            assertEquals(order.getDate(), pDO2.getLastClearTime());
        }
        if (testId == 1006) {
            assertEquals(0L, pDO.getPoints());
            assertEquals(0L, pDO1.getPoints());
            assertEquals(0L, pDO1.getPoints());
            assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd")
                    , DateUtils.formatDate(pDO.getLastClearTime(), "yyyy-MM-dd"));
            assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd")
                    , DateUtils.formatDate(pDO1.getLastClearTime(), "yyyy-MM-dd"));
            assertEquals(DateUtils.formatDate(new Date(), "yyyy-MM-dd")
                    , DateUtils.formatDate(pDO2.getLastClearTime(), "yyyy-MM-dd"));
        }
        if (testId == 1008) {
            assertEquals(pointsDO.getPoints() + pointsLogDO.getPoints() - pointsLogDO1.getPoints()
                    , pDO.getPoints());
            assertEquals(order.getDate(), pDO.getLastClearTime());
        }
        if (testId == 1009) {
            assertEquals(pointsDO.getPoints()
                    , pDO.getPoints());
            assertEquals(order.getDate(), pDO.getLastClearTime());
        }
        PointsLogDO pLogDO = null;
        PointsLogDO pLogDO1 = null;
        PointsLogDO pLogDO2 = null;
        pLogDO = promotionTestBase.findPointsLogByMerchantOrderNo(order.getMerchantOrderNo()).stream().filter(plDO -> userId.equals(plDO.getUserId())).findFirst().get();
        assertEquals(pointsDO.getPointId(), pLogDO.getPointId());
        assertEquals(order.getGid(), pLogDO.getGid());
        assertEquals(order.getReqId(), pLogDO.getReqId());
        assertEquals(order.getPlatPartnerId(), pLogDO.getPlatPartnerId());
        assertEquals(order.getPlatMerchantOrderNo(), pLogDO.getPlatMerchantOrderNo());
        assertEquals(order.getPartnerId(), pLogDO.getPartnerId());
        assertEquals(order.getMerchantOrderNo(), pLogDO.getMerchantOrderNo());
        assertEquals(userId, pLogDO.getUserId());
        if (testId != 1007) {
            assertEquals(result.getInstructionId(), pLogDO.getInstructionId());
        }
        assertEquals(sType, pLogDO.getType());
        assertNotNull(pLogDO.getRawAddTime());
        assertNotNull(pLogDO.getRawUpdateTime());
        if (testId == 1001) {
            assertEquals(pointsLogDO.getPoints(), pLogDO.getPoints());
        }
        if (testId == 1002) {
            assertEquals(pointsLogDO.getPoints() + pointsLogDO1.getPoints(), pLogDO.getPoints());
        }
        if (testId == 1003) {
            assertEquals(pointsLogDO.getPoints() + pointsLogDO1.getPoints() + pointsLogDO2.getPoints(), pLogDO.getPoints());
        }
        if (testId == 1004 || testId == 1007) {
            assertEquals(pointsLogDO.getPoints(), pLogDO.getPoints());
        }
        if (testId == 1005) {
            assertEquals(pointsLogDO.getPoints(), pLogDO.getPoints());
        }
        if (testId == 1006) {
            assertEquals(pointsDO.getPoints(), pLogDO.getPoints());
        }
        if (testId == 1008) {
            assertEquals(pointsLogDO1.getPoints() - pointsLogDO.getPoints(), pLogDO.getPoints());
        }
        if (testId == 1009) {
            assertEquals(0L, pLogDO.getPoints());
        }
        if (testId >= 1004 && testId <= 1007) {
            pLogDO1 = promotionTestBase.findPointsLogByMerchantOrderNo(order.getMerchantOrderNo()).stream().filter(plDO -> userId1.equals(plDO.getUserId())).findFirst().get();
            assertEquals(pointsDO1.getPointId(), pLogDO1.getPointId());
            assertEquals(order.getGid(), pLogDO1.getGid());
            assertEquals(order.getReqId(), pLogDO1.getReqId());
            assertEquals(order.getPlatPartnerId(), pLogDO1.getPlatPartnerId());
            assertEquals(order.getPlatMerchantOrderNo(), pLogDO1.getPlatMerchantOrderNo());
            assertEquals(order.getPartnerId(), pLogDO1.getPartnerId());
            assertEquals(order.getMerchantOrderNo(), pLogDO1.getMerchantOrderNo());
            assertEquals(userId1, pLogDO1.getUserId());
            if (testId != 1007) {
                assertEquals(result.getInstructionId(), pLogDO1.getInstructionId());
            }
            assertEquals(sType, pLogDO1.getType());
            assertNotNull(pLogDO1.getRawAddTime());
            assertNotNull(pLogDO1.getRawUpdateTime());
            if (testId == 1004 || testId == 1007) {
                assertEquals(pointsLogDO2.getPoints(), pLogDO1.getPoints());
            }
            if (testId == 1005) {
                assertEquals(pointsLogDO1.getPoints(), pLogDO1.getPoints());
            }
            if (testId == 1006) {
                assertEquals(pointsDO1.getPoints(), pLogDO1.getPoints());
            }
        }
        if (testId == 1005 || testId == 1006) {
            pLogDO2 = promotionTestBase.findPointsLogByMerchantOrderNo(order.getMerchantOrderNo()).stream().filter(plDO -> userId2.equals(plDO.getUserId())).findFirst().get();
            assertEquals(pointsDO2.getPointId(), pLogDO2.getPointId());
            assertEquals(order.getGid(), pLogDO2.getGid());
            assertEquals(order.getReqId(), pLogDO2.getReqId());
            assertEquals(order.getPlatPartnerId(), pLogDO2.getPlatPartnerId());
            assertEquals(order.getPlatMerchantOrderNo(), pLogDO2.getPlatMerchantOrderNo());
            assertEquals(order.getPartnerId(), pLogDO2.getPartnerId());
            assertEquals(order.getMerchantOrderNo(), pLogDO2.getMerchantOrderNo());
            assertEquals(userId2, pLogDO2.getUserId());
            assertEquals(result.getInstructionId(), pLogDO2.getInstructionId());
            assertEquals(sType, pLogDO2.getType());
            assertNotNull(pLogDO2.getRawAddTime());
            assertNotNull(pLogDO2.getRawUpdateTime());
            if (testId == 1005) {
                assertEquals(pointsLogDO2.getPoints(), pLogDO2.getPoints());
            }
            if (testId == 1006) {
                assertEquals(pointsDO1.getPoints(), pLogDO1.getPoints());
            }
        }
        // 清除数据
        promotionTestBase.cleanPointsByUserId(userId);
        promotionTestBase.cleanPointsByUserId(userId1);
        promotionTestBase.cleanPointsByUserId(userId2);
    }

    /**
     * 1001 userIds传空
     */
    @AutoTest(file = "promotion/pointsServiceBatchClearPointsTestFailOne.csv")
    @DisplayName("参数缺省--失败用例")
    public void pointsServiceBatchClearPointsTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            BatchClearPointsOrder order,
            String userId,
            String userId1,
            String userId2,
            String sType,
            PointsDO pointsDO,
            PointsDO pointsDO1,
            PointsDO pointsDO2,
            PointsLogDO pointsLogDO,
            PointsLogDO pointsLogDO1,
            PointsLogDO pointsLogDO2

    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> userIds = new ArrayList<String>();
        userIds.add(userId);
        if (testId == 1002) {
            order.setUserIds(null);
        }
        // 调用接口
        BatchPointsResult result = pointsService.batchClearPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001 userId不存在
     */
    @AutoTest(file = "promotion/pointsServiceBatchClearPointsTestFailTwo.csv")
    @DisplayName("批量清除积分--失败用例")
    public void pointsServiceBatchClearPointsTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            BatchClearPointsOrder order,
            String userId,
            String userId1,
            String userId2,
            String sType,
            PointsDO pointsDO,
            PointsDO pointsDO1,
            PointsDO pointsDO2,
            PointsLogDO pointsLogDO,
            PointsLogDO pointsLogDO1,
            PointsLogDO pointsLogDO2
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> userIds = new ArrayList<String>();
        userIds.add(userId);
        order.setUserIds(userIds);
        // 调用接口
        BatchPointsResult result = pointsService.batchClearPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

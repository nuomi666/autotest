package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.points.PointsService;
import com.xyb.promotion.api.points.params.QueryPointsOrder;
import com.xyb.promotion.api.points.params.QueryPointsResult;
import dal.model.promotion.PointsDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/02/25.
 */
public class PointsServiceQueryPointsTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "points.default")
    PointsService pointsService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 查询会员1积分
     * 1002 查询会员2积分
     * 1003 查询会员3积分
     * 1004 查询商户积分
     * 1005 查询平台户积分
     * 1006 查询会员积分为0
     * 1007 查询商户积分为0
     * 1008 查询平台商积分为0
     */
    @AutoTest(file = "promotion/pointsServiceQueryPointsTestSuccess.csv")
    @DisplayName("查询积分--成功用例")
    public void pointsServiceQueryPointsTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryPointsOrder order,
            PointsDO pointsDO,
            PointsDO pointsDO1,
            PointsDO pointsDO2
    ) {
        // 清除数据
        promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
        promotionTestBase.cleanPointsByUserId(pointsDO1.getUserId());
        promotionTestBase.cleanPointsByUserId(pointsDO2.getUserId());
        promotionTestBase.cleanPointsByPartnerId(order.getPartnerId());
        promotionTestBase.cleanPointsByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        if (testId <= 1006) {
            promotionTestBase.insertPoints(pointsDO);
            promotionTestBase.insertPoints(pointsDO1);
            promotionTestBase.insertPoints(pointsDO2);
        }
        // 测试过程
        // 调用接口
        QueryPointsResult result = pointsService.queryPoints(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(pointsDO.getPoints(), result.getPoints());
            assertEquals(pointsDO.getHistoryAddPoints(), result.getHistoryAddPoints().longValue());
            assertEquals(pointsDO.getHistorySubtractPoints(), result.getHistorySubtractPoints());
        }
        if (testId == 1002) {
            assertEquals(pointsDO1.getPoints(), result.getPoints());
            assertEquals(pointsDO1.getHistoryAddPoints(), result.getHistoryAddPoints());
            assertEquals(pointsDO1.getHistorySubtractPoints(), result.getHistorySubtractPoints());
        }
        if (testId == 1003) {
            assertEquals(pointsDO2.getPoints(), result.getPoints());
            assertEquals(pointsDO2.getHistoryAddPoints(), result.getHistoryAddPoints());
            assertEquals(pointsDO2.getHistorySubtractPoints(), result.getHistorySubtractPoints());
        }
        if (testId == 1004) {
            assertEquals(pointsDO.getPoints() + pointsDO1.getPoints(), result.getPoints());
            assertEquals(pointsDO.getHistoryAddPoints() + pointsDO1.getHistoryAddPoints(), result.getHistoryAddPoints());
            assertEquals(pointsDO.getHistorySubtractPoints() + pointsDO1.getHistorySubtractPoints(), result.getHistorySubtractPoints());
        }
        if (testId == 1005) {
            assertEquals(pointsDO.getPoints() + pointsDO1.getPoints() + pointsDO2.getPoints(), result.getPoints());
            assertEquals(pointsDO.getHistoryAddPoints() + pointsDO1.getHistoryAddPoints() + pointsDO2.getHistoryAddPoints(), result.getHistoryAddPoints());
            assertEquals(pointsDO.getHistorySubtractPoints() + pointsDO1.getHistorySubtractPoints() + pointsDO2.getHistorySubtractPoints(), result.getHistorySubtractPoints());
        }
        if (testId >= 1006) {
            assertEquals(0L, result.getPoints());
            assertEquals(0L, result.getHistoryAddPoints());
            assertEquals(0L, result.getHistorySubtractPoints());
        }
        // 清除数据
        promotionTestBase.cleanPointsByUserId(pointsDO.getUserId());
        promotionTestBase.cleanPointsByUserId(pointsDO1.getUserId());
        promotionTestBase.cleanPointsByUserId(pointsDO2.getUserId());
        promotionTestBase.cleanPointsByPartnerId(order.getPartnerId());
        promotionTestBase.cleanPointsByPlatPartnerId(order.getPlatPartnerId());
    }
}

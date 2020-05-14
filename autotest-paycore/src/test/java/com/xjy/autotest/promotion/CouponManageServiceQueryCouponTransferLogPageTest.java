package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.params.CouponTransferLogInfo;
import com.xyb.promotion.api.coupon.params.QueryCouponTransferLogPageOrder;
import com.xyb.promotion.api.coupon.params.QueryCouponTransferLogPageResult;
import dal.model.promotion.CouponTransferLogDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/07/19.
 */
public class CouponManageServiceQueryCouponTransferLogPageTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 查询券转赠记录,1条
     * 1002 查询券转赠记录,2条
     * 1003 查询券转赠记录,3条,分页10条/页
     * 1004 查询券转赠记录,3条,分页1条/页,查询第一页
     * 1005 查询券转赠记录,3条,分页1条/页,查询第2页
     * 1006 查询券转赠记录,3条,分页1条/页,查询第3页
     * 1007 根据接收方查询券转赠记录,3条,分页10条/页
     * 1008 根据券名称查询券转赠记录,3条,分页10条/页
     */
    @AutoTest(file = "promotion/couponManageServiceQueryCouponTransferLogPageTestSuccess.csv")
    @DisplayName("查询券转赠记录--成功用例")
    public void couponManageServiceQueryCouponTransferLogPageTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCouponTransferLogPageOrder order,
            Page page,
            CouponTransferLogDO couponTransDO,
            CouponTransferLogDO couponTransDO1,
            CouponTransferLogDO couponTransDO2
    ) {
        // 清除数据
        promotionTestBase.cleanCouponTransferLogByPartnerId(couponTransDO.getPartnerId());
        promotionTestBase.cleanCouponTransferLogByPartnerId(couponTransDO1.getPartnerId());
        promotionTestBase.cleanCouponTransferLogByPartnerId(couponTransDO2.getPartnerId());
        // 准备数据
        promotionTestBase.insertCouponTransferLog(couponTransDO);
        promotionTestBase.insertCouponTransferLog(couponTransDO1);
        promotionTestBase.insertCouponTransferLog(couponTransDO2);
        // 测试过程
        if (testId == 1004) {
            page = new Page(1, 1);
        }
        if (testId == 1005) {
            page = new Page(2, 1);
        }
        if (testId == 1006) {
            page = new Page(3, 1);
        }
        order.setPage(page);
        // 调用接口
        QueryCouponTransferLogPageResult result = couponManageService.queryCouponTransferLogPage(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(1, result.getPageResult().getTotal());
            assertEquals(1, result.getPageResult().getRecords().size());
            CouponTransferLogInfo info = result.getPageResult().getRecords().get(0);
            assertEquals(couponTransDO.getDonorUserId(), info.getDonorUserId());
            assertEquals(couponTransDO.getReceiveUserId(), info.getReceiveUserId());
            assertEquals(couponTransDO.getOldCouponId(), info.getCouponId());
            assertEquals(couponTransDO.getTakenTime(), info.getTakenTime());
            assertEquals(couponTransDO.getCanApplyTime(), info.getCanApplyTime());
            assertEquals(couponTransDO.getValidEndTime(), info.getValidEndTime());
            assertEquals(couponTransDO.getInstructionId(), info.getInstructionId());
        }
        if (testId == 1002) {
            assertEquals(2, result.getPageResult().getTotal());
            assertEquals(2, result.getPageResult().getRecords().size());
        }
        if (testId == 1003) {
            assertEquals(3, result.getPageResult().getTotal());
            assertEquals(3, result.getPageResult().getRecords().size());
        }
        if (testId == 1004) {
            assertEquals(3, result.getPageResult().getTotal());
            assertEquals(1, result.getPageResult().getCurrent());
            assertEquals(1, result.getPageResult().getRecords().size());
            CouponTransferLogInfo info = result.getPageResult().getRecords().get(0);
            assertEquals(couponTransDO.getDonorUserId(), info.getDonorUserId());
            assertEquals(couponTransDO.getReceiveUserId(), info.getReceiveUserId());
            assertEquals(couponTransDO.getOldCouponId(), info.getCouponId());
            assertEquals(couponTransDO.getTakenTime(), info.getTakenTime());
            assertEquals(couponTransDO.getCanApplyTime(), info.getCanApplyTime());
            assertEquals(couponTransDO.getValidEndTime(), info.getValidEndTime());
            assertEquals(couponTransDO.getInstructionId(), info.getInstructionId());
        }
        if (testId == 1005) {
            assertEquals(3, result.getPageResult().getTotal());
            assertEquals(2, result.getPageResult().getCurrent());
            assertEquals(1, result.getPageResult().getRecords().size());
            CouponTransferLogInfo info = result.getPageResult().getRecords().get(0);
            assertEquals(couponTransDO1.getDonorUserId(), info.getDonorUserId());
            assertEquals(couponTransDO1.getReceiveUserId(), info.getReceiveUserId());
            assertEquals(couponTransDO1.getOldCouponId(), info.getCouponId());
            assertEquals(couponTransDO1.getTakenTime(), info.getTakenTime());
            assertEquals(couponTransDO1.getCanApplyTime(), info.getCanApplyTime());
            assertEquals(couponTransDO1.getValidEndTime(), info.getValidEndTime());
            assertEquals(couponTransDO1.getInstructionId(), info.getInstructionId());
        }
        if (testId == 1006) {
            assertEquals(3, result.getPageResult().getTotal());
            assertEquals(3, result.getPageResult().getCurrent());
            assertEquals(1, result.getPageResult().getRecords().size());
            CouponTransferLogInfo info = result.getPageResult().getRecords().get(0);
            assertEquals(couponTransDO2.getDonorUserId(), info.getDonorUserId());
            assertEquals(couponTransDO2.getReceiveUserId(), info.getReceiveUserId());
            assertEquals(couponTransDO2.getOldCouponId(), info.getCouponId());
            assertEquals(couponTransDO2.getTakenTime(), info.getTakenTime());
            assertEquals(couponTransDO2.getCanApplyTime(), info.getCanApplyTime());
            assertEquals(couponTransDO2.getValidEndTime(), info.getValidEndTime());
            assertEquals(couponTransDO2.getInstructionId(), info.getInstructionId());
        }
        if (testId == 1007) {
            assertEquals(3, result.getPageResult().getTotal());
            assertEquals(3, result.getPageResult().getRecords().size());
        }
        if (testId == 1008) {
            assertEquals(1, result.getPageResult().getTotal());
            assertEquals(1, result.getPageResult().getRecords().size());
            CouponTransferLogInfo info = result.getPageResult().getRecords().get(0);
            assertEquals(couponTransDO1.getDonorUserId(), info.getDonorUserId());
            assertEquals(couponTransDO1.getReceiveUserId(), info.getReceiveUserId());
            assertEquals(couponTransDO1.getOldCouponId(), info.getCouponId());
            assertEquals(couponTransDO1.getTakenTime(), info.getTakenTime());
            assertEquals(couponTransDO1.getCanApplyTime(), info.getCanApplyTime());
            assertEquals(couponTransDO1.getValidEndTime(), info.getValidEndTime());
            assertEquals(couponTransDO1.getInstructionId(), info.getInstructionId());
        }
        // 清除数据
    }
}

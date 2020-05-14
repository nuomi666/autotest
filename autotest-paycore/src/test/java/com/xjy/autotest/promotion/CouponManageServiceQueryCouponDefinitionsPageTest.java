package com.xjy.autotest.promotion;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.PromotionTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.promotion.api.coupon.CouponManageService;
import com.xyb.promotion.api.coupon.params.CouponDefinitionInfo;
import com.xyb.promotion.api.coupon.params.QueryCouponDefinitionsPageOrder;
import com.xyb.promotion.api.coupon.params.QueryCouponDefinitionsPageResult;
import dal.model.promotion.CouponDefinitionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author huairen
 * Created on 2019/01/29.
 */
public class CouponManageServiceQueryCouponDefinitionsPageTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "coupon.default")
    CouponManageService couponManageService;

    @Autowired
    PromotionTestBase promotionTestBase;

    /**
     * 1001 查询商户的券
     * 1002 查询平台商的券
     * 1003 查询新建的券
     * 1004 查询新建的券1张
     * 1005 查询失效的券1张
     * 1006 查询券内部名称的券
     * 1007 查询券内部名称的券
     * 1008 查询券内部名称的券
     * 1009 分页查询查第一页
     * 1010 分页查询查第二页
     * 1011 分页查询查第三页
     */
    @AutoTest(file = "promotion/couponManageServiceQueryCouponDefinitionsPageTestSuccess.csv")
    @DisplayName("分页查询券定义--成功用例")
    public void couponManageServiceQueryCouponDefinitionsPageTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            QueryCouponDefinitionsPageOrder order,
            Page page,
            // 准备数据
            CouponDefinitionDO couponDefinitionDO,
            CouponDefinitionDO couponDefinitionDO1,
            CouponDefinitionDO couponDefinitionDO2
    ) {
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByPartnerId(order.getPartnerId());
        promotionTestBase.cleanCouponDefinitionByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        promotionTestBase.insertCouponDefinition(couponDefinitionDO);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO1);
        promotionTestBase.insertCouponDefinition(couponDefinitionDO2);
        // 测试过程
        order.setPage(page);
        // 调用接口
        QueryCouponDefinitionsPageResult result = couponManageService.queryCouponDefinitionsPage(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        if (testId <= 1003) {
            assertEquals(3, result.getPageResult().getRecords().size());
        }
        CouponDefinitionInfo couponDefinitionInfo = null;
        if (testId >= 1004) {
            assertEquals(1, result.getPageResult().getRecords().size());
            couponDefinitionInfo = result.getPageResult().getRecords().get(0);
        }
        if (testId == 1004) {
            assertEquals(couponDefinitionDO.getDefinitionId(), couponDefinitionInfo.getDefinitionId());
            assertEquals(couponDefinitionDO.getDefinitionStatus(), couponDefinitionInfo.getDefinitionStatus().name());
            assertEquals(couponDefinitionDO.getName(), couponDefinitionInfo.getName());
            assertEquals(couponDefinitionDO.getInnerName(), couponDefinitionInfo.getInnerName());
            assertEquals(couponDefinitionDO.getDefinitionJson(), couponDefinitionInfo.getDefinitionJson());
            assertEquals(couponDefinitionDO.getOverlay(), couponDefinitionInfo.getOverlay());
            assertEquals(couponDefinitionDO.getTakeCount() + "", couponDefinitionInfo.getTakeCount() + "");
            assertEquals(couponDefinitionDO.getCouponType(), couponDefinitionInfo.getCouponType().name());
        }
        if (testId == 1005) {
            assertEquals(couponDefinitionDO2.getDefinitionId(), couponDefinitionInfo.getDefinitionId());
        }
        if (testId == 1006) {
            assertEquals(couponDefinitionDO.getDefinitionId(), couponDefinitionInfo.getDefinitionId());
        }
        if (testId == 1007) {
            assertEquals(couponDefinitionDO1.getDefinitionId(), couponDefinitionInfo.getDefinitionId());
        }
        if (testId == 1008) {
            assertEquals(couponDefinitionDO2.getDefinitionId(), couponDefinitionInfo.getDefinitionId());
        }
        if (testId >= 1009) {
            assertEquals(3, result.getPageResult().getTotal());
            assertEquals(3, result.getPageResult().getPages());
            assertEquals(order.getPage().getSize(), result.getPageResult().getSize());
            assertEquals(order.getPage().getCurrent(), result.getPageResult().getCurrent());
        }
        // 数据验证
        // 清除数据
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO1.getDefinitionId());
        promotionTestBase.cleanCouponDefinitionByDefinitionId(couponDefinitionDO2.getDefinitionId());
    }
}

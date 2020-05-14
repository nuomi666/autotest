package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.PageInfo;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.ApplyGoodsType;
import com.xyb.gas.merchant.api.enums.PaywayActionType;
import com.xyb.gas.merchant.api.enums.PaywayModelType;
import com.xyb.gas.merchant.api.enums.PaywayTerminalType;
import com.xyb.gas.merchant.api.facade.MerchantPaywayService;
import com.xyb.gas.merchant.api.info.payway.QueryMerchantPaywayInfo;
import com.xyb.gas.merchant.api.order.payway.PageQueryMerchantPaywayOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2019/11/19.
 */
public class MerchantPaywayServicePageQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantPaywayService merchantPaywayService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServicePageQueryTestSuccess.csv")
    @DisplayName("查询商家支付配置方式列表--成功用例")
    public void merchantPaywayServicePageQueryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId, String payWayCode, String payWayName,
            String payWayCode1, String payWayName1,
            String payWayCode2, String payWayName2,
            String payWayType,
            String barCode, ApplyGoodsType applyGoodsType,
            PaywayTerminalType paywayTerminalType, PaywayTerminalType paywayTerminalType1,
            PaywayTerminalType paywayTerminalType2,
            PaywayModelType paywayModelType, PaywayModelType paywayModelType1,
            PaywayModelType paywayModelType2, PaywayActionType paywayActionType,
            String payWayStatus, boolean print,
            PageQueryMerchantPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode, payWayName, payWayType, payWayCode,
                barCode, null, applyGoodsType,
                paywayTerminalType, paywayModelType, paywayActionType, payWayStatus, print);
        //2
        gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode1, payWayName1, null, payWayCode1,
                null, null, applyGoodsType,
                paywayTerminalType1, paywayModelType1, paywayActionType, payWayStatus, print);
        //3
        gasMerchantInitDataBase.initGasMerchantPayway(platPartnerId, payWayCode2, payWayName2, null, payWayCode2,
                null, null, applyGoodsType,
                paywayTerminalType2, paywayModelType2, paywayActionType, payWayStatus, print);
        // 测试过程
        // 调用接口
        PagedResult<QueryMerchantPaywayInfo> result = merchantPaywayService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        PageInfo page = result.getPageInfo();
        assertEquals(order.getPageNo(), page.getPageNo());
        assertEquals(order.getPageSize(), page.getPageSize());
        if (testId <= 1003) {
            assertEquals(3l, page.getTotalCount());
        } else {
            assertEquals(1l, page.getTotalCount());
        }
        List<QueryMerchantPaywayInfo> payWayInfos = result.getInfoList();
        if (testId == 1001) {
            assertEquals(3, payWayInfos.size());
        } else if (testId == 1002) {
            assertEquals(2, payWayInfos.size());
        } else {
            assertEquals(1, payWayInfos.size());
        }
        if (testId <= 1003) {//返回的数据无序的，就这么校验了
            for (QueryMerchantPaywayInfo payWayInfo : payWayInfos) {
                if (payWayCode.equals(payWayInfo.getChannelCode())) {
                    assertEquals(null, payWayInfo.getChannelFunction());
                    assertEquals(platPartnerId, payWayInfo.getPartnerId());
                    assertEquals(payWayCode, payWayInfo.getPaywayCode());
                    assertEquals(null, payWayInfo.getPaywayIcon());
                    assertEquals(payWayName, payWayInfo.getPaywayName());
                    assertEquals(null, payWayInfo.getPaywaySmallIcon());
                    assertEquals(payWayType, payWayInfo.getPaywayType());
                }
                if (payWayCode1.equals(payWayInfo.getChannelCode())) {
                    assertEquals(null, payWayInfo.getChannelFunction());
                    assertEquals(platPartnerId, payWayInfo.getPartnerId());
                    assertEquals(payWayCode1, payWayInfo.getPaywayCode());
                    assertEquals(null, payWayInfo.getPaywayIcon());
                    assertEquals(payWayName1, payWayInfo.getPaywayName());
                    assertEquals(null, payWayInfo.getPaywaySmallIcon());
                    assertEquals(null, payWayInfo.getPaywayType());
                }
                if (payWayCode2.equals(payWayInfo.getChannelCode())) {
                    assertEquals(null, payWayInfo.getChannelFunction());
                    assertEquals(platPartnerId, payWayInfo.getPartnerId());
                    assertEquals(payWayCode2, payWayInfo.getPaywayCode());
                    assertEquals(null, payWayInfo.getPaywayIcon());
                    assertEquals(payWayName2, payWayInfo.getPaywayName());
                    assertEquals(null, payWayInfo.getPaywaySmallIcon());
                    assertEquals(null, payWayInfo.getPaywayType());
                }
            }
        }
        if (testId >= 1004) {
            assertEquals(1, payWayInfos.size());
            for (QueryMerchantPaywayInfo payWayInfo : payWayInfos) {
                assertEquals(payWayCode, payWayInfo.getChannelCode());
                assertEquals(null, payWayInfo.getChannelFunction());
                assertEquals(platPartnerId, payWayInfo.getPartnerId());
                assertEquals(payWayCode, payWayInfo.getPaywayCode());
                assertEquals(null, payWayInfo.getPaywayIcon());
                assertEquals(payWayName, payWayInfo.getPaywayName());
                assertEquals(null, payWayInfo.getPaywaySmallIcon());
                assertEquals(payWayType, payWayInfo.getPaywayType());
                //下面数据开发很懒  暂时没返
                assertEquals(null, payWayInfo.getPaywaySceneInfo());
                assertEquals(null, payWayInfo.getPaywayAttributeInfo());
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId, payWayCode);
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId, payWayCode1);
        gasMerchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId, payWayCode2);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId, payWayCode);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId, payWayCode2);
        silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId, payWayCode1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantPaywayServicePageQueryTestFailOne.csv")
    @DisplayName("查询商家支付配置方式列表--参数非法")
    public void merchantPaywayServicePageQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryMerchantPaywayOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult<QueryMerchantPaywayInfo> result = merchantPaywayService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }
}

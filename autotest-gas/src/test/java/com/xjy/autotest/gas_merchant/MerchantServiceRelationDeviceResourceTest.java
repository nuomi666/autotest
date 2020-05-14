package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.order.RelationMerchantDeviceResourceOrder;
import dal.model.gas_merchant.GasMerchantResourceDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class MerchantServiceRelationDeviceResourceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceRelationDeviceResourceTestSuccess.csv")
    @DisplayName("配置终端菜单--成功用例")
    public void merchantServiceRelationDeviceResourceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RelationMerchantDeviceResourceOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantResourceByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        // 测试过程
        Set<Long> resourceIds = Sets.newHashSet();
        resourceIds.add(1L);
        if (testId == 1002) {
            resourceIds.add(2L);
        }
        order.setResourceIds(resourceIds);
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantService.relationDeviceResource(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasMerchantResourceDO> merchantResources =
                gasMerchantTestBase.findGasMerchantResourceByPlatPartnerId(order.getPlatPartnerId());
        assertTrue(merchantResources.size() > 0);
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantResourceByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceRelationDeviceResourceTestFailOne.csv")
    @DisplayName("配置终端菜单--参数非法")
    public void merchantServiceRelationDeviceResourceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RelationMerchantDeviceResourceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setDeviceType(null);
        }
        if (testId != 1003) {
            Set<Long> resourceIds = Sets.newHashSet();
            resourceIds.add(1L);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantService.relationDeviceResource(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

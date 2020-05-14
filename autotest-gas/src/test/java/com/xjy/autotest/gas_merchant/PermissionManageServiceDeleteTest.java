package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.PermissionManageService;
import com.xyb.gas.merchant.api.order.permission.RemovePermissionOrder;
import dal.model.gas_merchant.PermissionDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/03.
 */
public class PermissionManageServiceDeleteTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    PermissionManageService permissionManageService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServiceDeleteTestSuccess.csv")
    @DisplayName("删除权限--成功用例")
    public void permissionManageServiceDeleteTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String deviceType,
            String name,
            String permissionCode,
            String url,
            String category,
            String resourceType,
            int orderNo,
            RemovePermissionOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanPermissionByPermissionId(order.getPermissionId());
        // 准备数据
        gasMerchantTestBase.insertPermission(0L, deviceType, order.getPermissionId(), null, name,
                permissionCode, url, category, resourceType,
                orderNo, null, null, null, null);
        // 测试过程
        // 调用接口
        SimpleResult result = permissionManageService.delete(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<PermissionDO> Permission = gasMerchantTestBase.findPermissionByPermissionId(order.getPermissionId());
        assertEquals(0, Permission.size());
        // 清除数据
        gasMerchantTestBase.cleanPermissionByPermissionId(order.getPermissionId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/permissionManageServiceDeleteTestFailOne.csv")
    @DisplayName("删除权限--参数非法")
    public void permissionManageServiceDeleteTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RemovePermissionOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPermissionId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        SimpleResult result = permissionManageService.delete(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.facade.MerchantUserService;
//import com.xyb.gas.merchant.api.info.RoleAuthorithInfo;
//import com.xyb.gas.merchant.api.order.common.CommonAbstractOrder;
//import com.xyb.gas.merchant.api.result.BizCollectionResult;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * @author nuomi
// * Created on 2020/01/07.
// */
//public class MerchantUserServiceGetRoleAuthorityTest extends SpringBootTestBase {
//
//    @Reference(version = DUBBO_VERSION_1)
//    MerchantUserService merchantUserService;
//
//    @Autowired
//    Gas_merchantTestBase gasMerchantTestBase;
//
//    @Autowired
//    GasMerchantInitDataBase gasMerchantInitDataBase;
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServiceGetRoleAuthorityTestSuccess.csv")
//    @DisplayName("获取角色权限列表--成功用例")
//    public void merchantUserServiceGetRoleAuthorityTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            Long resourceId,
//            Long resourceId1,
//            CommonAbstractOrder order
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasMerchantRoleResourceByRoleId(order.getId());
//        // 准备数据
//        gasMerchantInitDataBase.initGasRoleResource(order.getId(), resourceId, resourceId1, null);
//        // 测试过程
//        // 调用接口
//        BizCollectionResult<RoleAuthorithInfo> result = merchantUserService.getRoleAuthority(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        List<Long> resourceIds = new ArrayList<>();
//        for (RoleAuthorithInfo info : result.getInfos()) {
//            resourceIds.add(info.getResourceId());
//            assertEquals(order.getId(), info.getRoleId());
//        }
//        assertTrue(resourceIds.contains(resourceId));
//        assertTrue(resourceIds.contains(resourceId1));
//        // 清除数据
//        gasMerchantTestBase.cleanGasMerchantRoleResourceByRoleId(order.getId());
//    }
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServiceGetRoleAuthorityTestFailOne.csv")
//    @DisplayName("获取角色权限列表--参数非法")
//    public void merchantUserServiceGetRoleAuthorityTestFailOne(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            CommonAbstractOrder order
//    ) {
//        // 清除数据
//        // 准备数据
//        // 测试过程
//        if (testId == 1001) {
//            order.setId(null);
//        }
//        if (testId == 1002) {
//            order.setGid(null);
//        }
//        if (testId == 1003) {
//            order = null;
//        }
//        // 调用接口
//        BizCollectionResult<RoleAuthorithInfo> result = merchantUserService.getRoleAuthority(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        // 清除数据
//    }
//}

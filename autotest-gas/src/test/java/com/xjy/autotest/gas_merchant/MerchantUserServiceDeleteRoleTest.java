//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.OID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.enums.RoleType;
//import com.xyb.gas.merchant.api.enums.UserType;
//import com.xyb.gas.merchant.api.facade.MerchantUserService;
//import com.xyb.gas.merchant.api.order.DeleteRoleOrder;
//import dal.model.gas_merchant.GasRoleDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi
// * Created on 2020/01/07.
// */
//public class MerchantUserServiceDeleteRoleTest extends SpringBootTestBase {
//
//    @Reference(version = DUBBO_VERSION_1)
//    MerchantUserService merchantUserService;
//
//    @Autowired
//    Gas_merchantTestBase gasMerchantTestBase;
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServiceDeleteRoleTestSuccess.csv")
//    @DisplayName("删除角色--成功用例")
//    public void merchantUserServiceDeleteRoleTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            String parentName, String roleName,
//            DeleteRoleOrder order
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName);
//        // 准备数据
//        gasMerchantTestBase.insertGasRole(0L, RoleType.Supplier.code(), null, parentName, null, null, null);
//        Long parentId = gasMerchantTestBase.findGasRoleByRoleName(parentName).get(0).getId();
//        //干扰数据
//        gasMerchantTestBase.insertGasRole(0L, RoleType.Station.code(), parentId, roleName, null, null,
//                null);
//        Long roleId = gasMerchantTestBase.findGasRoleByRoleName(roleName).get(0).getId();
//        // 测试过程
//        order.setId(parentId);
//        // 调用接口
//        SimpleResult result = merchantUserService.deleteRole(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        List<GasRoleDO> roles = gasMerchantTestBase.findGasRoleById(parentId);
//        assertEquals(0, roles.size());
//        List<GasRoleDO> roles1 = gasMerchantTestBase.findGasRoleById(roleId);
//        assertEquals(1, roles1.size());
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName);
//    }
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServiceDeleteRoleTestFailOne.csv")
//    @DisplayName("删除角色--参数非法")
//    public void merchantUserServiceDeleteRoleTestFailOne(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            DeleteRoleOrder order
//    ) {
//        // 清除数据
//        // 准备数据
//        // 测试过程
//        if (testId == 1001) {
//            order.setId(-1);
//        }
//        if (testId == 1002) {
//            order.setGid(null);
//        }
//        if (testId == 1003) {
//            order = null;
//        }
//        // 调用接口
//        SimpleResult result = merchantUserService.deleteRole(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        // 清除数据
//    }
//
//    /**
//     * 1001.角色被使用
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServiceDeleteRoleTestFailTwo.csv")
//    @DisplayName("删除角色--失败用例")
//    public void merchantUserServiceDeleteRoleTestFailTwo(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            String partnerId, String parentName,
//            DeleteRoleOrder order
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
//        // 准备数据
//        gasMerchantTestBase.insertGasRole(0L, RoleType.Supplier.code(), null, parentName, null, null, null);
//        Long parentId = gasMerchantTestBase.findGasRoleByRoleName(parentName).get(0).getId();
//        //干扰数据
//        gasMerchantTestBase.insertGasMerchantUser(0L, OID.newID(), parentId, UserType.BOSS.code(), partnerId,
//                partnerId, null, null,
//                null, null, null, null, null, null, null, null, null, null, null, null, null);
//        // 测试过程
//        order.setId(parentId);
//        // 调用接口
//        SimpleResult result = merchantUserService.deleteRole(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        List<GasRoleDO> roles = gasMerchantTestBase.findGasRoleById(parentId);
//        assertEquals(1, roles.size());
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
//    }
//}

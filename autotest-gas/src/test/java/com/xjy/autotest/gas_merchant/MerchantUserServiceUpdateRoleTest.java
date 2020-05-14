//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.enums.RoleType;
//import com.xyb.gas.merchant.api.facade.MerchantUserService;
//import com.xyb.gas.merchant.api.order.UpdateRoleOrder;
//import dal.model.gas_merchant.GasRoleDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//import java.util.List;
//
//
///**
// * @author nuomi
// * Created on 2020/01/07.
// */
//public class MerchantUserServiceUpdateRoleTest extends SpringBootTestBase {
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
//    @AutoTest(file = "gas_merchant/merchantUserServiceUpdateRoleTestSuccess.csv")
//    @DisplayName("修改单个角色--成功用例")
//    public void merchantUserServiceUpdateRoleTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            String parentName, String roleName,
//            String memo, String memo1,
//            UpdateRoleOrder order
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
//        // 准备数据
//        Date rawAddtime = DateUtils.parseDate("2019-12-13");
//        Date rawAddtime1 = DateUtils.parseDate("2019-12-14");
//        gasMerchantTestBase.insertGasRole(0L, RoleType.Supplier.code(), null, parentName, memo, rawAddtime,
//        rawAddtime);
//        Long parentId = gasMerchantTestBase.findGasRoleByRoleName(parentName).get(0).getId();
//        gasMerchantTestBase.insertGasRole(0L, RoleType.Station.code(), parentId, roleName, memo1, rawAddtime1,
//                rawAddtime1);
//        Long roleId = gasMerchantTestBase.findGasRoleByRoleName(roleName).get(0).getId();
//        // 测试过程
//        if (testId == 1001) {
//            order.setId(parentId);
//        } else {
//            order.setId(roleId);
//        }
//        // 调用接口
//        SimpleResult result = merchantUserService.updateRole(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        List<GasRoleDO> gasRoles = gasMerchantTestBase.findGasRoleById(order.getId());
//        if (testId == 1001) {
//            gasRoleAssert(gasRoles.get(0), order.getRoleName(), RoleType.Supplier.code(),
//                    order.getParentId(), order.getMemo());
//        } else {
//            gasRoleAssert(gasRoles.get(0), order.getRoleName(), RoleType.Station.code(),
//                    order.getParentId(), order.getMemo());
//        }
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
//    }
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServiceUpdateRoleTestFailOne.csv")
//    @DisplayName("修改单个角色--参数非法")
//    public void merchantUserServiceUpdateRoleTestFailOne(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            UpdateRoleOrder order
//    ) {
//        // 清除数据
//        // 准备数据
//        // 测试过程
//        if (testId == 1001) {
//            order.setRoleName(null);
//        }
//        if (testId == 1002) {
//            order.setId(null);
//        }
//        if (testId == 1003) {
//            order.setGid(null);
//        }
//        if (testId == 1004) {
//            order = null;
//        }
//        // 调用接口
//        SimpleResult result = merchantUserService.updateRole(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        // 清除数据
//    }
//
//    /**
//     * 1001.角色不存在
//     * 1002.修改角色的父级id为本身
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServiceUpdateRoleTestFailTwo.csv")
//    @DisplayName("修改单个角色--失败用例")
//    public void merchantUserServiceUpdateRoleTestFailTwo(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            String parentName, String memo,
//            UpdateRoleOrder order
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
//        // 准备数据
//        Date rawAddtime = DateUtils.parseDate("2019-12-13");
//        Date rawAddtime1 = DateUtils.parseDate("2019-12-14");
//        gasMerchantTestBase.insertGasRole(0L, RoleType.Supplier.code(), null, parentName, memo, rawAddtime,
//        rawAddtime);
//        Long parentId = gasMerchantTestBase.findGasRoleByRoleName(parentName).get(0).getId();
//        // 测试过程
//        if (testId == 1002) {
//            order.setId(parentId);
//            order.setParentId(parentId);
//        }
//        // 调用接口
//        SimpleResult result = merchantUserService.updateRole(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        List<GasRoleDO> gasRoles = gasMerchantTestBase.findGasRoleById(order.getId());
//        if (testId == 1002) {
//            gasRoleAssert(gasRoles.get(0), parentName, RoleType.Supplier.code(),
//                    null, memo);
//        }
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(order.getRoleName());
//    }
//
//    /**
//     * 角色信息
//     *
//     * @param roleName
//     * @param roleType
//     * @param parentId
//     * @param memo
//     * @return
//     */
//    private void gasRoleAssert(
//            GasRoleDO gasRole,
//            String roleName,
//            String roleType,
//            Long parentId,
//            String memo
//    ) {
//        assertEquals(roleName, gasRole.getRoleName());
//        assertEquals(roleType, gasRole.getRoleType());
//        assertEquals(parentId, gasRole.getParentId());
//        assertEquals(memo, gasRole.getMemo());
//    }
//
//}

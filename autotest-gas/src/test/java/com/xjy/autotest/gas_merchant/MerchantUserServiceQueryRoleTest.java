//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.result.BizResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.enums.RoleType;
//import com.xyb.gas.merchant.api.facade.MerchantUserService;
//import com.xyb.gas.merchant.api.info.RoleDetailInfo;
//import com.xyb.gas.merchant.api.order.common.CommonAbstractOrder;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
//
///**
// * @author nuomi
// * Created on 2020/01/07.
// */
//public class MerchantUserServiceQueryRoleTest extends SpringBootTestBase {
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
//    @AutoTest(file = "gas_merchant/merchantUserServiceQueryRoleTestSuccess.csv")
//    @DisplayName("查询单个角色--成功用例")
//    public void merchantUserServiceQueryRoleTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            String parentName, String roleName,
//            String memo, String memo1,
//            CommonAbstractOrder order
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName);
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
//        BizResult<RoleDetailInfo> result = merchantUserService.queryRole(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        if (testId == 1001) {
//            gasRoleAssert(result.getInfo(), parentId, parentName, RoleType.Supplier.code(),
//                    null, null, memo, rawAddtime);
//        }
//        if (testId == 1002) {
//            gasRoleAssert(result.getInfo(), roleId, roleName, RoleType.Station.code(),
//                    parentId, parentName, memo1, rawAddtime1);
//        }
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName);
//    }
//
//    /**
//     * 1001
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServiceQueryRoleTestFailOne.csv")
//    @DisplayName("查询单个角色--参数非法")
//    public void merchantUserServiceQueryRoleTestFailOne(
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
//        BizResult<RoleDetailInfo> result = merchantUserService.queryRole(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        // 清除数据
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
//            RoleDetailInfo gasRole,
//            Long roleId,
//            String roleName,
//            String roleType,
//            Long parentId,
//            String parentName,
//            String memo,
//            Date time
//    ) {
//        assertEquals(roleId, gasRole.getId());
//        assertEquals(roleName, gasRole.getRoleName());
//        assertEquals(roleType, gasRole.getRoleType().code());
//        assertEquals(parentId, gasRole.getParentId());
//        assertEquals(parentName, gasRole.getParentRoleName());
//        assertEquals(memo, gasRole.getMemo());
//        assertEquals(time, gasRole.getRawAddTime());
////        assertEquals(time, gasRole.getRawUpdateTime());开发没返回
//    }
//}

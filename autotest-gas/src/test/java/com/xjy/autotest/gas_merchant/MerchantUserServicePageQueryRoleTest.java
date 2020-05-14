//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xjy.autotest.utils.DateUtils;
//import com.xyb.adk.common.lang.result.PagedResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.enums.RoleType;
//import com.xyb.gas.merchant.api.facade.MerchantUserService;
//import com.xyb.gas.merchant.api.info.RoleDetailInfo;
//import com.xyb.gas.merchant.api.order.common.CommonPageQueryOrder;
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
//public class MerchantUserServicePageQueryRoleTest extends SpringBootTestBase {
//
//    @Reference(version = DUBBO_VERSION_1)
//    MerchantUserService merchantUserService;
//
//    @Autowired
//    Gas_merchantTestBase gasMerchantTestBase;
//
//    /**
//     * 1001.输入关键字查询，每页显示十条，显示第一页
//     * 1002.不输入关键字查询，每页显示十条，显示第一页
//     * 1003.不输入关键字查询，每页显示两条，显示第一页
//     * 1004.不输入关键字查询，每页显示两条，显示第二页
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServicePageQueryRoleTestSuccess.csv")
//    @DisplayName("分页查询角色--成功用例")
//    public void merchantUserServicePageQueryRoleTestSuccess(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            String parentName, String roleName,
//            String roleName1, String memo,
//            String memo1, String memo2,
//            CommonPageQueryOrder order
//    ) {
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName1);
//        // 准备数据
//        Date rawAddtime = DateUtils.parseDate("2019-12-13");
//        Date rawAddtime1 = DateUtils.parseDate("2019-12-14");
//        Date rawAddtime2 = DateUtils.parseDate("2019-12-15");
//        gasMerchantTestBase.insertGasRole(0L, RoleType.Supplier.code(), null, parentName, memo, rawAddtime,
//        rawAddtime);
//        Long parentId = gasMerchantTestBase.findGasRoleByRoleName(parentName).get(0).getId();
//        gasMerchantTestBase.insertGasRole(0L, RoleType.Station.code(), parentId, roleName, memo1, rawAddtime1,
//                rawAddtime1);
//        Long roleId = gasMerchantTestBase.findGasRoleByRoleName(roleName).get(0).getId();
//        gasMerchantTestBase.insertGasRole(0L, RoleType.Terminal.code(), parentId, roleName1, memo2, rawAddtime2,
//                rawAddtime2);
//        Long roleId1 = gasMerchantTestBase.findGasRoleByRoleName(roleName1).get(0).getId();
//        // 测试过程
//        // 调用接口
//        PagedResult<RoleDetailInfo> result = merchantUserService.pageQueryRole(order);
//        // 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//        // 数据验证
//        List<RoleDetailInfo> infos = result.getInfoList();
//        if (testId == 1001 || testId == 1004) {
//            assertEquals(1, infos.size());
//            gasRoleAssert(infos.get(0), parentId, parentName, RoleType.Supplier.code(),
//                    null, null, memo, rawAddtime);
//        }
//        if (testId == 1002) {
//            assertEquals(3, infos.size());
//            gasRoleAssert(infos.get(0), roleId1, roleName1, RoleType.Terminal.code(),
//                    parentId, parentName, memo2, rawAddtime2);
//            gasRoleAssert(infos.get(1), roleId, roleName, RoleType.Station.code(),
//                    parentId, parentName, memo1, rawAddtime1);
//            gasRoleAssert(infos.get(2), parentId, parentName, RoleType.Supplier.code(),
//                    null, null, memo, rawAddtime);
//        }
//        if (testId == 1003) {
//            assertEquals(2, infos.size());
//            gasRoleAssert(infos.get(0), roleId1, roleName1, RoleType.Terminal.code(),
//                    parentId, parentName, memo2, rawAddtime2);
//            gasRoleAssert(infos.get(1), roleId, roleName, RoleType.Station.code(),
//                    parentId, parentName, memo1, rawAddtime1);
//        }
//        // 清除数据
//        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName);
//        gasMerchantTestBase.cleanGasRoleByRoleName(roleName1);
//    }
//
//    /**
//     *
//     */
//    @AutoTest(file = "gas_merchant/merchantUserServicePageQueryRoleTestFailOne.csv")
//    @DisplayName("分页查询角色--参数非法")
//    public void merchantUserServicePageQueryRoleTestFailOne(
//            // 基本参数
//            int testId,
//            Status status,
//            String code,
//            // 业务参数
//            CommonPageQueryOrder order
//    ) {
//        // 清除数据
//        // 准备数据
//        // 测试过程
//        if (testId == 1001) {
//            order.setGid(null);
//        }
//        if (testId == 1002) {
//            order = null;
//        }
//        // 调用接口
//        PagedResult<RoleDetailInfo> result = merchantUserService.pageQueryRole(order);
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

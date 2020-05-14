package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.info.RoleInfo;
import com.xyb.gas.merchant.api.order.FindByRoleTypeOrder;
import com.xyb.gas.merchant.api.result.BizCollectionResult;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class MerchantServiceQueryMerchantRoleTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceQueryMerchantRoleTestSuccess.csv")
    @DisplayName("查询商户关联的角色--成功用例")
    public void merchantServiceQueryMerchantRoleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String roleName, String parentName,
            RoleType roleType, RoleType parentType,
            FindByRoleTypeOrder order
    ) {
        // 清除数据
        // 准备数据
        Long roleId = null;
        Long parentId = null;
        Map<String, Object> roleIds = gasMerchantInitDataBase.initGasRole(roleName, parentName, roleType.code(),
                parentType.code());
        roleId = Long.valueOf(roleIds.get("parentId").toString());
        parentId = Long.valueOf(roleIds.get("childId").toString());
        gasMerchantInitDataBase.initGasMerchantRole(order.getPartnerId(), roleId, parentId, null, null, null);
        // 测试过程
        List<RoleType> roleTypes = new ArrayList<>();
        roleTypes.add(roleType);
        if (testId >= 1002) {
            roleTypes.add(parentType);
        }
        // 调用接口
        BizCollectionResult<RoleInfo> result = merchantService.queryMerchantRole(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        for (RoleInfo roleInfo : result.getInfos()) {
            if (roleType.equals(roleInfo.getRoleType())) {
                assertEquals(roleId, roleInfo.getId());
                assertEquals(roleName, roleInfo.getRoleName());
                assertEquals(parentId, roleInfo.getParentId());
            }
            if (parentType.equals(roleInfo.getRoleType())) {
                assertEquals(parentId, roleInfo.getId());
                assertEquals(parentName, roleInfo.getRoleName());
                assertEquals(null, roleInfo.getParentId());
            }
        }
        // 清除数据
        gasMerchantTestBase.cleanGasRoleByRoleName(roleName);
        gasMerchantTestBase.cleanGasRoleByRoleName(parentName);
        gasMerchantTestBase.cleanGasMerchantRoleByRoleId(roleId);
        gasMerchantTestBase.cleanGasMerchantRoleByRoleId(parentId);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantServiceQueryMerchantRoleTestFailOne.csv")
    @DisplayName("查询商户关联的角色--参数非法")
    public void merchantServiceQueryMerchantRoleTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            FindByRoleTypeOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
            order.setPartnerId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizCollectionResult<RoleInfo> result = merchantService.queryMerchantRole(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }
}

package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Sets;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.RoleType;
import com.xyb.gas.merchant.api.facade.MerchantService;
import com.xyb.gas.merchant.api.order.RelationMerchantRoleOrder;
import dal.model.gas_merchant.GasMerchantRoleDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author nuomi@xyb.com
 * Created on 2018/09/27.
 */
public class MerchantServiceRelationRoleTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantService merchantService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 平台商模式时，为了兼容以前的商户模式，入参中的签约商ID和平台商ID任意传一个就行
     * 1001.只传平台商ID，关联一个角色
     * 1002.传入平台商和签约商ID，且相同，关联多个角色
     * 1003.传入平台商和签约商ID，且不同，关联多个角色
     * 1004.只传入签约商ID，做更新
     */
    @AutoTest(file = "gas_merchant/merchantServiceRelationRoleTestSuccess.csv", project = "gas_merchant")
    @DisplayName("商户关联角色--成功用例")
    public void merchantServiceRelationRoleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RelationMerchantRoleOrder order,
            Long roleId,
            Long roleId1
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(order.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        gasMerchantInitDataBase.initGasMerchant(order.getPlatPartnerId(), "糯米测试", "1jlita2wxmpo11hge7qi", "糯米",
                "S0301909271400000053", "001ifzzx5gwsf0368h00", "001ifzfw5yhdf0368h00",
                "Merchant", null, "ABLE");
        Map<String, Object> roles = gasMerchantInitDataBase.initGasRole("站长", "商家", RoleType.Station.code(),
                RoleType.Supplier.code());
        roleId = Long.valueOf(roles.get("parentId").toString());
        roleId1 = Long.valueOf(roles.get("childId").toString());
        if (testId == 1004) {
            gasMerchantInitDataBase.initGasMerchantRole(order.getPartnerId(), roleId, null, null, null, null);
        }
        // 测试过程
        Set<Long> roleIds = Sets.newHashSet();
        roleIds.add(roleId);
        if (testId >= 1002) {
            roleIds.add(roleId1);
        }
        if (testId == 1001) {
            order.setPartnerId(null);
        }
        if (testId == 1004) {
            order.setPlatPartnerId(null);
        }
        order.setRoleIds(roleIds);
        order.setGid(GID.newGID());
        // 调用接口
        SimpleResult result = merchantService.relationRole(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            gasMerchantRoleAssert(1, order.getPlatPartnerId(), roleId, null);
        }
        if (testId == 1002 || testId == 1003) {
            gasMerchantRoleAssert(2, order.getPlatPartnerId(), roleId, roleId1);
        }
        if (testId == 1004) {
            gasMerchantRoleAssert(2, order.getPartnerId(), roleId, roleId1);
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPartnerId());
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(order.getPlatPartnerId());
        xybUserTestBase.cleanUserByUserId(order.getPartnerId());
        xybUserTestBase.cleanUserByUserId(order.getPlatPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPartnerId());
        xybUserTestBase.cleanAccountByUserId(order.getPlatPartnerId());
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(order.getPartnerId());
        gasMerchantTestBase.cleanGasMerchantRoleByPlatPartnerId(order.getPlatPartnerId());
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPartnerId());
        silverboltTestBase.cleanGasMerchantByPartnerId(order.getPlatPartnerId());
    }

    /**
     * 平台商模式时，为了兼容以前的商户模式，入参中的签约商ID和平台商ID任意传一个就行
     * 1001.签约商ID和平台商ID都为空
     * 1002.角色为空
     * 1003.gid为空
     * 1004.order为空
     */
    @AutoTest(file = "gas_merchant/merchantServiceRelationRoleTestFailOne.csv", project = "gas_merchant")
    @DisplayName("商户关联角色--参数非法")
    public void merchantServiceRelationRoleTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            RelationMerchantRoleOrder order,
            Long roleId
    ) {
        // 清除数据

        // 准备数据

        // 测试过程
        Set<Long> roleIds = Sets.newHashSet();
        roleIds.add(roleId);
        order.setRoleIds(roleIds);
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setPartnerId(null);
            order.setPlatPartnerId(null);
        }
        if (testId != 1002) {
            order.setRoleIds(roleIds);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = merchantService.relationRole(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证

        // 清除数据
    }

    /**
     * @param count
     * @param platPartnerId
     * @param roleId
     * @param roleId1
     */
    private void gasMerchantRoleAssert(
            int count,
            String platPartnerId,
            Long roleId,
            Long roleId1
    ) {
        List<GasMerchantRoleDO> gasMerchantRoles =
                gasMerchantTestBase.findGasMerchantRoleByPlatPartnerId(platPartnerId);
        if (count <= 0) {
            return;
        } else {
            assertTrue(gasMerchantRoles.size() == count);
            Set<Long> roles = Sets.newHashSet();
            for (GasMerchantRoleDO merchantRole : gasMerchantRoles) {
                assertEquals(platPartnerId, merchantRole.getPlatPartnerId());
                roles.add(merchantRole.getRoleId());
            }
            if (roleId != null && StringUtils.isNotBlank(roleId.toString())) {
                assertTrue(roles.contains(roleId));
            }
            if (roleId1 != null && StringUtils.isNotBlank(roleId1.toString())) {
                assertTrue(roles.contains(roleId1));
            }
        }
    }
}

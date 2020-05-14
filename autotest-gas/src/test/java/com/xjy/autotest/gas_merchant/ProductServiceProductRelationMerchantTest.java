package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.ProductService;
import com.xyb.gas.merchant.api.order.product.ProductRelationMerchantOrder;
import dal.model.gas_merchant.MerchantProductDO;
import dal.model.gas_merchant.RolePermissionDO;
import dal.model.gas_merchant.RoleProductDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author nuomi
 * Created on 2020/04/09.
 */
public class ProductServiceProductRelationMerchantTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    ProductService productService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceProductRelationMerchantTestSuccess.csv")
    @DisplayName("产品关联商户信息--成功用例")
    public void productServiceProductRelationMerchantTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String roleNo,
            String roleNo1,
            String roleNo2,
            String platPartnerId,
            String platPartnerId1,
            String platPartnerId2,
            String productName,
            String permissionName,
            String permissionCode,
            String resourceType,
            String type,
            String category,
            ProductRelationMerchantOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId1);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId2);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo1);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo1);
        // 准备数据
        gasMerchantTestBase.insertRole(0L, roleNo, "00000000000000000000", "Supplier", platPartnerId2,
                "商家管理员", "系统预设商家管理员", null, null);
        gasMerchantTestBase.insertRole(0L, roleNo1, "00000000000000000000", "Station", platPartnerId2,
                "站长", "系统预设站长", null, null);
        gasMerchantTestBase.insertRole(0L, roleNo2, "00000000000000000000", "Terminal", platPartnerId2,
                "收银员", "系统预设收银员", null, null);
        Map<String, Object> params = gasMerchantInitDataBase.initMerchantProduct(platPartnerId, platPartnerId1,
                productName, type,
                category, permissionName, permissionCode, resourceType, 1);
        String permissionId = params.get("permissionId").toString();
        String productId = params.get("productId").toString();
        String merchantRoleNo = params.get("merchantRoleNo").toString();
        String merchantRoleNo1 = params.get("merchantRoleNo1").toString();
        String stationRoleNo = params.get("stationRoleNo").toString();
        String stationRoleNo1 = params.get("stationRoleNo1").toString();
        // 测试过程
        order.setProductId(productId);
        List<String> merchantList = new ArrayList<String>();
        if (testId == 1002 || testId == 1003) {
            merchantList.add(platPartnerId2);
        }
        if (testId == 1003) {
            merchantList.add(platPartnerId1);
        }
        merchantList.add(platPartnerId);
        order.setMerchantList(merchantList);
        // 调用接口
        SimpleResult result = productService.productRelationMerchant(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        sleep(2);
        // 数据验证
        List<MerchantProductDO> merchantProductDOS =
                gasMerchantTestBase.findMerchantProductByPlatPartnerId(platPartnerId);
        assertEquals(1, merchantProductDOS.size());
        assertEquals(platPartnerId, merchantProductDOS.get(0).getPlatPartnerId());
        assertEquals(productId, merchantProductDOS.get(0).getProductId());
        List<MerchantProductDO> merchantProductDOS1 =
                gasMerchantTestBase.findMerchantProductByPlatPartnerId(platPartnerId1);
        if (testId == 1003) {
            assertEquals(1, merchantProductDOS1.size());
            assertEquals(platPartnerId1, merchantProductDOS1.get(0).getPlatPartnerId());
            assertEquals(productId, merchantProductDOS1.get(0).getProductId());
        } else {
            assertEquals(0, merchantProductDOS1.size());
        }
        List<MerchantProductDO> merchantProductDOS2 =
                gasMerchantTestBase.findMerchantProductByPlatPartnerId(platPartnerId2);
        if (testId == 1002 || testId == 1003) {
            assertEquals(1, merchantProductDOS2.size());
            assertEquals(platPartnerId2, merchantProductDOS2.get(0).getPlatPartnerId());
            assertEquals(productId, merchantProductDOS2.get(0).getProductId());
        } else {
            assertEquals(0, merchantProductDOS2.size());
        }
        List<RoleProductDO> roleProductDOS = gasMerchantTestBase.findRoleProductByRoleNo(roleNo);
        List<RoleProductDO> roleProductDOS1 = gasMerchantTestBase.findRoleProductByRoleNo(roleNo1);
        List<RoleProductDO> roleProductDOS2 = gasMerchantTestBase.findRoleProductByRoleNo(merchantRoleNo);
        List<RoleProductDO> roleProductDOS3 = gasMerchantTestBase.findRoleProductByRoleNo(stationRoleNo);
        List<RoleProductDO> roleProductDOS4 = gasMerchantTestBase.findRoleProductByRoleNo(merchantRoleNo1);
        List<RoleProductDO> roleProductDOS5 = gasMerchantTestBase.findRoleProductByRoleNo(stationRoleNo1);
        List<RolePermissionDO> rolePermissionDOS = gasMerchantTestBase.findRolePermissionByRoleNo(roleNo);
        List<RolePermissionDO> rolePermissionDOS1 = gasMerchantTestBase.findRolePermissionByRoleNo(roleNo1);
        List<RolePermissionDO> rolePermissionDOS2 = gasMerchantTestBase.findRolePermissionByRoleNo(merchantRoleNo);
        List<RolePermissionDO> rolePermissionDOS3 = gasMerchantTestBase.findRolePermissionByRoleNo(stationRoleNo);
        List<RolePermissionDO> rolePermissionDOS4 = gasMerchantTestBase.findRolePermissionByRoleNo(merchantRoleNo1);
        List<RolePermissionDO> rolePermissionDOS5 = gasMerchantTestBase.findRolePermissionByRoleNo(stationRoleNo1);
        if (testId == 1003) {
            assertEquals(1, roleProductDOS.size());
            assertEquals(1, rolePermissionDOS.size());
            assertEquals(productId, roleProductDOS.get(0).getProductId());
            assertEquals(productId, rolePermissionDOS.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS.get(0).getPermissionId());
        } else {
            assertEquals(0, roleProductDOS.size());
            assertEquals(0, rolePermissionDOS.size());
        }
        if (testId == 1001) {
            assertEquals(0, roleProductDOS1.size());
            assertEquals(0, rolePermissionDOS1.size());
        } else {
            assertEquals(1, roleProductDOS1.size());
            assertEquals(1, rolePermissionDOS1.size());
            assertEquals(productId, roleProductDOS1.get(0).getProductId());
            assertEquals(productId, rolePermissionDOS1.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS1.get(0).getPermissionId());
        }
        if (testId == 1002) {
            assertEquals(0, roleProductDOS2.size());
            assertEquals(0, rolePermissionDOS2.size());
        } else {
            assertEquals(1, roleProductDOS2.size());
            assertEquals(1, rolePermissionDOS2.size());
            assertEquals(productId, roleProductDOS2.get(0).getProductId());
            assertEquals(productId, rolePermissionDOS2.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS2.get(0).getPermissionId());
        }
        if (testId == 1001) {
            assertEquals(0, roleProductDOS3.size());
            assertEquals(0, rolePermissionDOS3.size());
        } else {
            assertEquals(1, roleProductDOS3.size());
            assertEquals(1, rolePermissionDOS3.size());
            assertEquals(productId, roleProductDOS3.get(0).getProductId());
            assertEquals(productId, rolePermissionDOS3.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS3.get(0).getPermissionId());
        }
        if (testId == 1003) {
            assertEquals(1, roleProductDOS4.size());
            assertEquals(1, rolePermissionDOS4.size());
            assertEquals(productId, roleProductDOS4.get(0).getProductId());
            assertEquals(productId, rolePermissionDOS4.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS4.get(0).getPermissionId());
        } else {
            assertEquals(0, roleProductDOS4.size());
            assertEquals(0, rolePermissionDOS4.size());
        }
        if (testId == 1003) {
            assertEquals(1, roleProductDOS5.size());
            assertEquals(1, rolePermissionDOS5.size());
            assertEquals(productId, roleProductDOS5.get(0).getProductId());
            assertEquals(productId, rolePermissionDOS5.get(0).getProductId());
            assertEquals(permissionId, rolePermissionDOS5.get(0).getPermissionId());
        } else {
            assertEquals(0, roleProductDOS5.size());
            assertEquals(0, rolePermissionDOS5.size());
        }
        // 清除数据
        gasMerchantTestBase.cleanProductByProductId(productId);
        gasMerchantTestBase.cleanPermissionByPermissionId(permissionId);
        gasMerchantTestBase.cleanProductPermissionByProductId(productId);
        gasMerchantTestBase.cleanMerchantProductByProductId(productId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId1);
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId2);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo);
        gasMerchantTestBase.cleanRoleProductByRoleNo(roleNo1);
        gasMerchantTestBase.cleanRoleProductByRoleNo(merchantRoleNo);
        gasMerchantTestBase.cleanRoleProductByRoleNo(stationRoleNo);
        gasMerchantTestBase.cleanRoleProductByRoleNo(merchantRoleNo1);
        gasMerchantTestBase.cleanRoleProductByRoleNo(stationRoleNo1);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(roleNo1);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(merchantRoleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(stationRoleNo);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(merchantRoleNo1);
        gasMerchantTestBase.cleanRolePermissionByRoleNo(stationRoleNo1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceProductRelationMerchantTestFailOne.csv")
    @DisplayName("产品关联商户信息--参数非法")
    public void productServiceProductRelationMerchantTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            ProductRelationMerchantOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> merchantList = new ArrayList<String>();
        if (testId != 1002) {
            merchantList.add(platPartnerId);
        }
        order.setMerchantList(merchantList);
        if (testId == 1001) {
            order.setProductId(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        SimpleResult result = productService.productRelationMerchant(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/productServiceProductRelationMerchantTestFailTwo.csv")
    @DisplayName("产品关联商户信息--失败用例")
    public void productServiceProductRelationMerchantTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            ProductRelationMerchantOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanProductByProductId(order.getProductId());
        // 准备数据
        if (testId == 1002) {
            gasMerchantTestBase.insertProduct(0L, order.getProductId(), "营销中心", "BOSS",
                    "MERCHANT", "DISABLE", "营销中心", null, null);
        }
        // 测试过程
        List<String> merchantList = new ArrayList<String>();
        merchantList.add(platPartnerId);
        order.setMerchantList(merchantList);
        // 调用接口
        SimpleResult result = productService.productRelationMerchant(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        gasMerchantTestBase.cleanRoleByPlatPartnerId(platPartnerId);
        gasMerchantTestBase.cleanProductByProductId(order.getProductId());
    }
}

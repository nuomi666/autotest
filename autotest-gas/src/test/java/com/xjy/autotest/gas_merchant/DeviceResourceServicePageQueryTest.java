package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.PageInfo;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.DeviceType;
import com.xyb.gas.merchant.api.enums.ResourceType;
import com.xyb.gas.merchant.api.facade.DeviceResourceService;
import com.xyb.gas.merchant.api.info.ResourceInfo;
import com.xyb.gas.merchant.api.order.PageQueryDeviceResourceOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/10/14.
 */
public class DeviceResourceServicePageQueryTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    DeviceResourceService deviceResourceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.只传必填项，查询出4条，每页显示10条，显示第一页
     * 1002.只传必填项，查询出4条，每页显示2条，显示第一页
     * 1003.只传必填项，查询出4条，每页显示2条，显示第二页
     * 1004.只传必填项，查询出2条，每页显示2条，显示第一页
     * 1005.传入终端类型和资源类型，查询出3条，每页显示2条，显示第二页
     * 1006.传入所有项，查询出1条，每页显示10条，显示第一页
     */
    @AutoTest(file = "gas_merchant/deviceResourceServicePageQueryTestSuccess.csv")
    @DisplayName("分页查询终端资源--成功用例")
    public void deviceResourceServicePageQueryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            DeviceType deviceType, DeviceType deviceType1,
            ResourceType fatherType, ResourceType fatherType1, ResourceType type, ResourceType type1,
            String fatherName, String fatherName1,
            String childName, String childName1, String fatherCode, String fatherCode1, String childCode,
            String childCode1,
            PageQueryDeviceResourceOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(fatherCode);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(fatherCode1);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(childCode);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(childCode1);
        // 准备数据
        Date rawAddTime = DateUtils.parseDate("2019-10-11");
        Date rawAddTime1 = DateUtils.parseDate("2019-10-21");
        Date rawAddTime2 = DateUtils.parseDate("2019-11-01");
        Date rawAddTime3 = DateUtils.parseDate("2019-11-20");
        gasMerchantTestBase.insertGasDeviceResource(0L, deviceType.code(), null, fatherName, fatherCode, null,
                fatherType.code(),
                null, "图标1", "memo1", rawAddTime, rawAddTime);
        Long parentId = gasMerchantTestBase.findGasDeviceResourceByName(fatherName).get(0).getId();
        gasMerchantTestBase.insertGasDeviceResource(0L, deviceType.code(), parentId, childName, childCode, null,
                type.code(), null, "图标2"
                , "memo2", rawAddTime1, rawAddTime1);
        Long childId = gasMerchantTestBase.findGasDeviceResourceByName(childName).get(0).getId();
        gasMerchantTestBase.insertGasDeviceResource(0L, deviceType1.code(), null, fatherName1, fatherCode1, null,
                fatherType1.code(),
                null, "图标3", "memo3", rawAddTime2, rawAddTime2);
        Long parentId1 = gasMerchantTestBase.findGasDeviceResourceByName(fatherName1).get(0).getId();
        gasMerchantTestBase.insertGasDeviceResource(0L, deviceType1.code(), parentId1, childName1, childCode1, null,
                type1.code(), null, "图标4"
                , "memo4", rawAddTime3, rawAddTime3);
        Long childId1 = gasMerchantTestBase.findGasDeviceResourceByName(childName1).get(0).getId();
        // 测试过程
        order.setGid(GID.newGID());
        if (testId != 1005 && testId != 1006) {
            order.setResourceType(null);
        }
        if (testId != 1006) {
            order.setName(null);
        }
        // 调用接口
        PagedResult<ResourceInfo> result = deviceResourceService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        PageInfo pageInfo = result.getPageInfo();
        List<ResourceInfo> resourceInfos = result.getInfoList();
        assertEquals(order.getPageSize(), pageInfo.getPageSize());
        assertEquals(order.getPageNo(), pageInfo.getPageNo());
        if (testId <= 1003) {
            assertEquals(4l, pageInfo.getTotalCount());
            if (testId == 1001) {
                assertEquals(4, resourceInfos.size());
                deviceResourceAssert(resourceInfos.get(0), parentId1, childId1, fatherName1, childName1,
                        fatherCode1, childCode1, type1.code(), null, null,
                        "图标4", "memo4");
                deviceResourceAssert(resourceInfos.get(1), null, parentId1, null, fatherName1,
                        null, fatherCode1, fatherType1.code(), null, null,
                        "图标3", "memo3");
                deviceResourceAssert(resourceInfos.get(2), parentId, childId, fatherName, childName,
                        fatherCode, childCode, type.code(), null, null,
                        "图标2", "memo2");
                deviceResourceAssert(resourceInfos.get(3), null, parentId, null, fatherName,
                        null, fatherCode, fatherType.code(), null, null,
                        "图标1", "memo1");
            } else if (testId == 1002) {
                assertEquals(2, resourceInfos.size());
                deviceResourceAssert(resourceInfos.get(0), parentId1, childId1, fatherName1, childName1,
                        fatherCode1, childCode1, type1.code(), null, null,
                        "图标4", "memo4");
                deviceResourceAssert(resourceInfos.get(1), null, parentId1, null, fatherName1,
                        null, fatherCode1, fatherType1.code(), null, null,
                        "图标3", "memo3");
            } else {
                assertEquals(2, resourceInfos.size());
                deviceResourceAssert(resourceInfos.get(0), parentId, childId, fatherName, childName,
                        fatherCode, childCode, type.code(), null, null,
                        "图标2", "memo2");
                deviceResourceAssert(resourceInfos.get(1), null, parentId, null, fatherName,
                        null, fatherCode, fatherType.code(), null, null,
                        "图标1", "memo1");
            }
        }
        if (testId == 1004) {
            assertEquals(2l, pageInfo.getTotalCount());
            assertEquals(2, resourceInfos.size());
            deviceResourceAssert(resourceInfos.get(0), parentId, childId, fatherName, childName,
                    fatherCode, childCode, type.code(), null, null,
                    "图标2", "memo2");
            deviceResourceAssert(resourceInfos.get(1), null, parentId, null, fatherName,
                    null, fatherCode, fatherType.code(), null, null,
                    "图标1", "memo1");
        }
        if (testId == 1005) {
            assertEquals(3l, pageInfo.getTotalCount());
            assertEquals(1, resourceInfos.size());
//            deviceResourceAssert(resourceInfos.get(0), parentId1, childId1, fatherName1, childName1,
//                    fatherCode1, childCode1, type1.code(), null, null,
//                    "图标4", "memo4");
//            deviceResourceAssert(resourceInfos.get(1), null, parentId1, null, fatherName1,
//                    null, fatherCode1, fatherType1.code(), null, null,
//                    "图标3", "memo3");
            deviceResourceAssert(resourceInfos.get(0), null, parentId, null, fatherName,
                    null, fatherCode, fatherType.code(), null, null,
                    "图标1", "memo1");
        }
        if (testId == 1006) {
            assertEquals(1l, pageInfo.getTotalCount());
            assertEquals(1, resourceInfos.size());
            deviceResourceAssert(resourceInfos.get(0), null, parentId, null, fatherName,
                    null, fatherCode, fatherType.code(), null, null,
                    "图标1", "memo1");
        }
        // 清除数据
        gasMerchantTestBase.cleanGasDeviceResourceByCode(fatherCode);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(fatherCode1);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(childCode);
        gasMerchantTestBase.cleanGasDeviceResourceByCode(childCode1);
    }

    /**
     * 1001.deviceType为空
     * 1002.gid为空
     * 1003.order为空
     */
    @AutoTest(file = "gas_merchant/deviceResourceServicePageQueryTestFailOne.csv")
    @DisplayName("分页查询终端资源--参数非法")
    public void deviceResourceServicePageQueryTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            PageQueryDeviceResourceOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setDeviceType(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        PagedResult result = deviceResourceService.pageQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    private void deviceResourceAssert(
            ResourceInfo resourceInfo,
            Long parentId,
            Long childId,
            String parentName,
            String childName,
            String parentCode,
            String childCode,
            String resourceType,
            String url,
            Integer orderNo,
            String icon,
            String memo
    ) {
        assertEquals(parentId, resourceInfo.getParentId());
        assertEquals(parentName, resourceInfo.getParentName());
        assertEquals(parentCode, resourceInfo.getParentCode());
        assertEquals(childId, resourceInfo.getId());
        assertEquals(childName, resourceInfo.getName());
        assertEquals(childCode, resourceInfo.getCode());
        assertEquals(url, resourceInfo.getUrl());
        assertEquals(resourceType, resourceInfo.getResourceType().code());
        assertEquals(orderNo, resourceInfo.getOrderNo());
        assertEquals(icon, resourceInfo.getIcon());
        assertEquals(memo, resourceInfo.getMemo());
    }
}

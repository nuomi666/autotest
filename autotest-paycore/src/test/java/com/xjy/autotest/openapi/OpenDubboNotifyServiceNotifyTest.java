package com.xjy.autotest.openapi;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.*;

import com.xyb.openapi.facade.result.NotifyApiResult;
import com.xyb.openapi.facade.api.OpenDubboNotifyService;
import com.xyb.openapi.facade.order.NotifyApiOrder;


/**
 * @author huairen
 * Created on 2019/01/17.
 */
public class OpenDubboNotifyServiceNotifyTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION, group = "openapi-notify")
    OpenDubboNotifyService openDubboNotifyService;

    /**
     * 1001 调用异步通知
     */
    @AutoTest(file = "openapi/openDubboNotifyServiceNotifyTestSuccess.csv")
    @DisplayName("调用异步通知--成功用例")
    public void openDubboNotifyServiceNotifyTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            NotifyApiOrder order,
            String partnerId,
            String orderNo,
            String state,
            String memo
    ) {
        // 清除数据
        // 准备数据
        orderNo = OID.newID();
        // 测试过程
        order.setGid(GID.newGID());
        Map<String, String> data = new HashMap<>();
        data.put("partnerId", partnerId);
        data.put("orderNo", orderNo);
        data.put("state", state);
        data.put("memo", memo);
        order.setData(data);
        // 调用接口
        NotifyApiResult result = openDubboNotifyService.notify(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

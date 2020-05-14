package com.xjy.autotest.gateway;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.cashier.api.order.route.PayConfigOrder;
import com.xyb.cashier.api.result.route.RouteResult;
import com.xyb.cashier.api.service.RouteApiService;
import com.xyb.gateway.api.enums.FileTypeEnum;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.io.FileOutputStream;
import java.util.*;

import com.xyb.gateway.api.result.GateWayDownloadFileResult;
import com.xyb.gateway.api.service.GateWayFileService;
import com.xyb.gateway.api.order.GateWayDownloadFileOrder;


/**
 * @author ychaoyang
 * Created on 2018/11/13.
 */
public class GateWayFileServiceGatewayDownloadFileTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    GateWayFileService gateWayFileService;

    @Reference(version = DUBBO_VERSION, group = "cashier")
    RouteApiService routeApiService;

    /**
     * 1001 下载清分结果文件
     * 1002 下载余额明细文件
     * 1003 下载提现结果文件
     * 1004 下载退汇结果文件
     */
    @AutoTest(file = "gateway/gateWayFileServiceGatewayDownloadFileTestSuccess.csv")
    @DisplayName("--成功用例")
    public void gateWayFileServiceGatewayDownloadFileTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWayDownloadFileOrder order,
            PayConfigOrder payConfigOrder
    ) throws Exception {
        if (testId != 1004) {
            return;
        }
        // 清除数据
        // 准备数据
        payConfigOrder.setGid(GID.newGID());
        RouteResult routeResult = routeApiService.findPayConfigInfo(payConfigOrder);
        print(routeResult);
        // 测试过程
        order.setChannelPartnerId(routeResult.getInfo().getChannelPartnerId());
        order.setSettleChannelId(routeResult.getInfo().getSettleChannelId());
        order.setParams(routeResult.getInfo().getParams());
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        if (testId == 1001) {
            order.setFileDate(DateUtils.changeDays(new Date(), -1));
        }
        if (testId == 1002) {
            order.setFileDate(new Date());
        }
        if (testId == 1003) {
            //order.setFileDate(DateUtils.changeDays(new Date(), -3));
            order.setFileDate(new Date());
        }
        if (testId == 1004) {
            order.setFileDate(new Date());
        }
        // 调用接口
        GateWayDownloadFileResult result = gateWayFileService.gatewayDownloadFile(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        //assertEquals(code, result.getCode());
        String channelId = "1003";
        String filePath = "D:/" + channelId + "001" + DateUtils.formatDate(DateUtils.changeDays(new Date(), -1), "yyyyMMdd") + "01" + ".zip";
        if (testId == 1002) {
            filePath = "D:/" + DateUtils.formatDate(new Date(), "yyyyMMdd") + "余额01" + ".zip";
        }
        if (testId == 1003) {
            filePath = "D:/" + DateUtils.formatDate(new Date(), "yyyyMMdd") + "提现01" + ".zip";
        }
        if (testId == 1004) {
            filePath = "D:/" + DateUtils.formatDate(new Date(), "yyyyMMdd") + "退汇01" + ".zip";
        }
        save2file(result.getFile(), filePath);
        // 数据验证
        // 清除数据
        print("------------写文件成功-----------");
        print(filePath);
    }

    public static void save2file(byte[] bytes, String filename) throws Exception {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(filename);
            fos.write(bytes);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception var8) {
                ;
            }

        }

    }
}

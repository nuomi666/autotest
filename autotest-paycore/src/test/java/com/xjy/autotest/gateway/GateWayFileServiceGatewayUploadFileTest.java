package com.xjy.autotest.gateway;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.cashier.api.info.route.RouteInfo;
import com.xyb.cashier.api.order.route.PayConfigOrder;
import com.xyb.cashier.api.result.route.RouteResult;
import com.xyb.cashier.api.service.RouteApiService;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.io.*;
import java.util.*;

import com.xyb.gateway.api.base.GatewayResult;
import com.xyb.gateway.api.service.GateWayFileService;
import com.xyb.gateway.api.order.GateWayUploadFileOrder;
import org.junit.jupiter.api.Test;
import sun.awt.geom.AreaOp;


/**
 * @author ychaoyang
 * Created on 2018/11/12.
 */
public class GateWayFileServiceGatewayUploadFileTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    GateWayFileService gateWayFileService;

    @Reference(version = DUBBO_VERSION, group = "cashier")
    RouteApiService routeApiService;

    String depositFileName = "100107000000000" + "002" + DateUtils.formatDate(new Date(), "yyyyMMdd") + "01";

    static String channelId = "1003";
    static Date recordDate = DateUtils.changeDays(new Date(), -1);
    static String recordFileName = "100107000000000" + channelId + "001" + DateUtils.formatDate(recordDate, "yyyyMMdd") + "01";


    /**
     * 1001 平台商户业务订单明细--清分
     * 1002 子商户提现明细
     */
    @AutoTest(file = "gateway/gateWayFileServiceGatewayUploadFileTestSuccess.csv")
    @DisplayName("平台商户业务订单明细--成功用例")
    public void gateWayFileServiceGatewayUploadFileTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWayUploadFileOrder order,
            PayConfigOrder payConfigOrder
    ) throws Exception {
        if (testId != 1001) {
            return;
        }
        // 清除数据
        // 准备数据
        payConfigOrder.setGid(GID.newGID());
        RouteResult routeResult = routeApiService.findPayConfigInfo(payConfigOrder);
        print(routeResult);
        RouteInfo routeInfo = routeResult.getInfo();
        Map<String, Object> params = routeInfo.getParams();
        // 测试过程
        order.setChannelPartnerId(routeInfo.getChannelPartnerId());
        order.setSettleChannelId(routeInfo.getSettleChannelId());
        //order.setParams(routeInfo.getParams());
        order.setReqId(OID.newID());
        order.setGid(GID.newGID());
        order.setMerchantOrderNo("merchNo" + System.currentTimeMillis());
        order.setPlatMerchantOrderNo("pmerchNo" + System.currentTimeMillis());
        if (testId == 1001) {
            //genRecordFile();
            order.setFileContentCount(4002);
            order.setFileDate(recordDate);
            order.setFileName(recordFileName);
            String filePath = "D:/" + recordFileName + ".txt";
            byte[] file = read4file(filePath);
            order.setFile(file);
            params.put("file", file);
            order.setParams(params);
        }
        if (testId == 1002) {
            //genDepositFile();
            order.setFileContentCount(3);
            order.setFileDate(new Date());
            order.setFileName(depositFileName);
            String filePath = "D:/" + depositFileName + ".txt";
            byte[] file = read4file(filePath);
            order.setFile(file);
            params.put("file", file);
            order.setParams(params);
        }
        print(order);
        // 调用接口
        GatewayResult result = gateWayFileService.gatewayUploadFile(order);
        // 结果验证
        print(order.getFileName());
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @Test
    public void genRecordFile() {
        List<String> list = new ArrayList<>();
        list.add(getRecord("100107000042053", channelId, 60000, "1"));
        list.add(getRecord("100107000042053", channelId, 60000, "2"));
        for (int i = 0; i < 500; i++) {
            list.add(getRecord("100107000042053", channelId, 10000, "1"));
            list.add(getRecord("100107000042053", channelId, 20000, "1"));
            list.add(getRecord("100107000042053", channelId, 30000, "1"));
            list.add(getRecord("100107000042053", channelId, 40000, "1"));
        }
        for (int i = 0; i < 2000; i++) {
            list.add(getRecord("100107000042063", channelId, 20000, "1"));
        }
        String filePath = "D:/" + recordFileName + ".txt";
        writeFile(list, filePath);
        print("---------生成清分文件成功---------");
        print(filePath);
    }

    @Test
    public void genDepositFile() {
        List<String> list = new ArrayList<>();
        long amount1 = 99914055;//99884055
        long amount2 = 40208775;
        list.add(getDeposit("100107000042053", "6229980700041788", 200000000));
        list.add(getDeposit("100107000042063", "6215853622553010", 10000000));
        list.add(getDeposit("100107000042378", "6226900718502566", 30000));
        String filePath = "D:/" + depositFileName + ".txt";
        writeFile(list, filePath);
        print("-----------生成提现文件成功----------");
    }

    public static byte[] read4file(String filename) throws Exception {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;

        try {
            fis = new FileInputStream(filename);
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[128];
            boolean var4 = false;

            int n;
            while ((n = fis.read(bytes)) > 0) {
                baos.write(bytes, 0, n);
            }
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }

                if (baos != null) {
                    baos.close();
                }
            } catch (Exception var10) {
                ;
            }

        }

        return baos.toByteArray();
    }

    public void writeFile(List<String> list, String filePath) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
            for (int i = 0; i < list.size(); i++) {
                osw.write(list.get(i));
                osw.write("\r\n");
            }
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件写入失败");
        }
    }

    public static String addGap(String str, int length) {
        int len = str == null ? 0 : str.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        for (int i = 0; i < length - len; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static String addZero(String str, int length) {
        int len = str == null ? 0 : str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length - len; i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String getRecord(String subMerchId, String channelId, long amount, String type) {
        StringBuilder data = new StringBuilder();
        data.append("100107000000000");//平台商户编号15
        data.append(subMerchId);//子商户编号15
        data.append(DateUtils.formatDate(recordDate, "yyyyMMdd"));//交易日期
        data.append(DateUtils.formatDate(new Date(), "HHmmss"));//交易时间
        data.append(addGap(channelId, 60));//支付渠道名称
        data.append(addGap(OID.newID(), 64));//平台商户业务订单号
        data.append(addGap(OID.newID(), 64));//平台商户支付订单号
        data.append(addGap(OID.newID(), 64));//支付渠道交易流水号
        data.append(addGap(OID.newID(), 64));//平台商户业务子订单号
        data.append(addGap(type, 2));//支付订单交易类型,1-支付,2-退货
        data.append(addGap(type, 2));//业务订单交易类型,1 -实时交易支付,2 -实时交易退货
        data.append("1");//清算资金来源,1-支付渠道
        data.append("2");//渠道手续费承担方式,1-平台商户承担/2-子商户承担
        data.append(addZero(amount + "", 14));//原始订单金额
        data.append(addZero(amount + "", 14));//原始支付金额
        data.append(addZero("0", 14));//平台优惠金额
        data.append(addZero(new Money(amount * 0.001).divide(100).getCent() + "", 14));//平台分成金额
        data.append(addZero("0", 14));//平台垫款金额
        data.append(addZero(new Money(amount * 0.0025).divide(100).getCent() + "", 14));//渠道手续费
        return data.toString();
    }

    public static String getDeposit(String subMerchId, String settleAccount, long amount) {
        StringBuilder data = new StringBuilder();
        data.append("100107000000000");//平台商户编号15
        data.append(subMerchId);//子商户编号15
        data.append(DateUtils.formatDate(new Date(), "yyyyMMdd"));//交易日期
        data.append(DateUtils.formatDate(new Date(), "HHmmss"));//交易时间
        data.append(addGap(OID.newID(), 64));//平台商户提现流水号
        data.append(addGap(settleAccount, 32));//子商户结算账户
        data.append(addZero(amount + "", 14));//提现金额
        data.append(addZero("0", 14));//平台垫款金额
        return data.toString();
    }

    public static void main(String[] args) {
        System.out.println();
    }

}

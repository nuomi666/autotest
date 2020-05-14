package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.enums.InvoiceOrderType;
import com.xyb.gas.merchant.api.facade.MerchantInvoiceService;
import com.xyb.gas.merchant.api.info.invoice.CheckInvoiceConfigInfo;
import com.xyb.gas.merchant.api.info.invoice.InvoicePaywayInfo;
import com.xyb.gas.merchant.api.order.invoice.CheckInvoiceOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/02/25.
 */
public class MerchantInvoiceServiceCheckInvoiceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantInvoiceService merchantInvoiceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.订单可开票
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceCheckInvoiceTestSuccess.csv")
    @DisplayName("校验是否可开票--成功用例")
    public void merchantInvoiceServiceCheckInvoiceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String oilCode, String oilCode1,
            String payWay, String payWay1,
            EnableStatus payStatus, EnableStatus payStatus1,
            CheckInvoiceOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date orderTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -1, 0, 0, 0);
        List<String> invoiceOils = new ArrayList<String>();
        invoiceOils.add(oilCode);
        invoiceOils.add(oilCode1);
        InvoicePaywayInfo invoicePaywayInfo = new InvoicePaywayInfo();
        invoicePaywayInfo.setPayway(payWay);
        invoicePaywayInfo.setStatus(payStatus);
        InvoicePaywayInfo invoicePaywayInfo1 = new InvoicePaywayInfo();
        invoicePaywayInfo1.setPayway(payWay1);
        invoicePaywayInfo1.setStatus(payStatus1);
        List<InvoicePaywayInfo> invoicePayway = new ArrayList<InvoicePaywayInfo>();
        invoicePayway.add(invoicePaywayInfo);
        invoicePayway.add(invoicePaywayInfo1);
        gasMerchantTestBase.insertGasInvoiceConfig(0l, order.getPlatPartnerId(), 4L, 20L,
                null, JSONObject.toJSONString(invoiceOils), JSONObject.toJSONString(invoicePayway,
                        SerializerFeature.WriteClassName), null, null);
        // 测试过程
        order.setOrderTime(orderTime);
        // 调用接口
        BizResult<CheckInvoiceConfigInfo> result = merchantInvoiceService.checkInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        Money favourAmount = order.getDiscountAmount().add(order.getThirdDiscountAmount());
        Money invoiceAmount = order.getOrderAmount().subtract(favourAmount);
        invoiceAssert(result.getInfo(), "SUCCESS", null,
                invoiceAmount, order.getOrderAmount().subtract(order.getThirdDiscountAmount()),
                order.getDiscountAmount(), order.getThirdDiscountAmount());
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceCheckInvoiceTestFailOne.csv")
    @DisplayName("校验是否可开票--参数非法")
    public void merchantInvoiceServiceCheckInvoiceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CheckInvoiceOrder order
    ) {
        // 清除数据
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date orderTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -1, 0, 0, 0);
        // 测试过程
        order.setOrderTime(orderTime);
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setTradePayType(null);
        }
        if (testId == 1003) {
            order.setOrderTime(null);
        }
        if (testId == 1004) {
            order.setOrderNo(null);
        }
        if (testId == 1005) {
            order.setCode(null);
        }
        if (testId == 1006) {
            order.setOrderType(InvoiceOrderType.GOODS);
        }
        if (testId == 1007) {
            order.setGid(null);
        }
        if (testId == 1008) {
            order = null;
        }
        // 调用接口
        BizResult<CheckInvoiceConfigInfo> result = merchantInvoiceService.checkInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        Money favourAmount = order.getDiscountAmount().add(order.getThirdDiscountAmount());
        Money invoiceAmount = order.getOrderAmount().subtract(favourAmount);
        invoiceAssert(result.getInfo(), "SUCCESS", null,
                invoiceAmount, order.getOrderAmount(),
                order.getDiscountAmount(), order.getThirdDiscountAmount());
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 1001.油品不可开票
     * 1002.开票金额不足
     * 1003.支付方式不支持开票
     * 1004.超过开票有效期
     * 1005.未配置开票规则
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceCheckInvoiceTestFailTwo.csv")
    @DisplayName("校验是否可开票--失败用例")
    public void merchantInvoiceServiceCheckInvoiceTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String oilCode, String oilCode1,
            String payWay, String payWay1,
            EnableStatus payStatus, EnableStatus payStatus1,
            CheckInvoiceOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date orderTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -5, 0, 0, 0);
        Date orderTime1 = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, -2, 0, 0, 0);
        List<String> invoiceOils = new ArrayList<String>();
        invoiceOils.add(oilCode);
        invoiceOils.add(oilCode1);
        InvoicePaywayInfo invoicePaywayInfo = new InvoicePaywayInfo();
        invoicePaywayInfo.setPayway(payWay);
        invoicePaywayInfo.setStatus(payStatus);
        InvoicePaywayInfo invoicePaywayInfo1 = new InvoicePaywayInfo();
        invoicePaywayInfo1.setPayway(payWay1);
        invoicePaywayInfo1.setStatus(payStatus1);
        List<InvoicePaywayInfo> invoicePayway = new ArrayList<InvoicePaywayInfo>();
        invoicePayway.add(invoicePaywayInfo);
        invoicePayway.add(invoicePaywayInfo1);
        if (testId != 1005) {
            gasMerchantTestBase.insertGasInvoiceConfig(0l, order.getPlatPartnerId(), 4L, 160L,
                    null, JSONObject.toJSONString(invoiceOils), JSONObject.toJSONString(invoicePayway,
                            SerializerFeature.WriteClassName), null, null);
        }
        // 测试过程
        if (testId == 1004) {
            order.setOrderTime(orderTime);
        } else {
            order.setOrderTime(orderTime1);
        }
        // 调用接口
        BizResult<CheckInvoiceConfigInfo> result = merchantInvoiceService.checkInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        Money favourAmount = order.getDiscountAmount().add(order.getThirdDiscountAmount());
        Money invoiceAmount = order.getOrderAmount().subtract(favourAmount);
//        invoiceAssert(result.getInfo(), "FAIL", null,
//                invoiceAmount, order.getOrderAmount(),
//                order.getDiscountAmount(), order.getThirdDiscountAmount());
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     * 开票信息
     */
    private void invoiceAssert(
            CheckInvoiceConfigInfo info,
            String invoiceStatus,
            String message,
            Money invoiceAmount,
            Money orderAmount,
            Money discountAmount,
            Money thirdDiscountAmount
    ) {
        assertEquals(invoiceStatus, info.getInvoiceStatus().code());
        assertEquals(message, info.getInvoiceMessage());
        assertEquals(invoiceAmount, info.getInvoiceAmount());
        assertEquals(orderAmount, info.getOrderAmount());
        assertEquals(discountAmount, info.getDiscountAmount());
        assertEquals(thirdDiscountAmount, info.getThirdDiscountAmount());
    }
}

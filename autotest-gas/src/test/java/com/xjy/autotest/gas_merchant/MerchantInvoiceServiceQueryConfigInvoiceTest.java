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
import com.xyb.gas.merchant.api.facade.MerchantInvoiceService;
import com.xyb.gas.merchant.api.info.invoice.InvoicePaywayInfo;
import com.xyb.gas.merchant.api.info.invoice.MerchantInvoiceConfigInfo;
import com.xyb.gas.merchant.api.order.common.CommonBaseOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/02/26.
 */
public class MerchantInvoiceServiceQueryConfigInvoiceTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantInvoiceService merchantInvoiceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceQueryConfigInvoiceTestSuccess.csv")
    @DisplayName("查询商户开票限制配置信息--成功用例")
    public void merchantInvoiceServiceQueryConfigInvoiceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String oilCode, String oilCode1,
            String payWay, String payWay1,
            EnableStatus payStatus, EnableStatus payStatus1,
            String remark,
            CommonBaseOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(order.getId());
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
        if (testId != 1001) {
            gasMerchantTestBase.insertGasInvoiceConfig(0l, order.getId(), 4L, 20L,
                    remark, JSONObject.toJSONString(invoiceOils), JSONObject.toJSONString(invoicePayway,
                            SerializerFeature.WriteClassName), null, null);
        }
        // 测试过程
        // 调用接口
        BizResult<MerchantInvoiceConfigInfo> result = merchantInvoiceService.queryConfigInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        if (testId == 1001) {
            assertEquals(null, result.getInfo());
        } else {
            assertEquals(4, result.getInfo().getExpireTime().intValue());
            assertEquals(new Money(0, 20), result.getInfo().getMinInvoiceAmount());
            assertEquals(remark, result.getInfo().getRemark());
            assertEquals(JSONObject.toJSONString(invoiceOils),
                    JSONObject.toJSONString(result.getInfo().getInvoiceOils()));
            assertEquals(JSONObject.toJSONString(invoicePayway),
                    JSONObject.toJSONString(result.getInfo().getInvoicePayway()));
        }
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(order.getId());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceQueryConfigInvoiceTestFailOne.csv")
    @DisplayName("查询商户开票限制配置信息--参数非法")
    public void merchantInvoiceServiceQueryConfigInvoiceTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonBaseOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setId(null);
        }
        if (testId == 1002) {
            order.setGid(null);
        }
        if (testId == 1003) {
            order = null;
        }
        // 调用接口
        BizResult<MerchantInvoiceConfigInfo> result = merchantInvoiceService.queryConfigInvoice(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

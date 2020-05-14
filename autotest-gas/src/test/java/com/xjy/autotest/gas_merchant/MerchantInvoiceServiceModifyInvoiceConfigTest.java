package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.enums.EnableStatus;
import com.xyb.gas.merchant.api.facade.MerchantInvoiceService;
import com.xyb.gas.merchant.api.info.invoice.InvoicePaywayInfo;
import com.xyb.gas.merchant.api.order.invoice.ModifyInvoiceConfigOrder;
import dal.model.gas_merchant.GasInvoiceConfigDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/02/25.
 */
public class MerchantInvoiceServiceModifyInvoiceConfigTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantInvoiceService merchantInvoiceService;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    /**
     * 1001.新增开票规则
     * 1002.更新开票规则
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceModifyInvoiceConfigTestSuccess.csv")
    @DisplayName("新增发票限制配置信息--成功用例")
    public void merchantInvoiceServiceModifyInvoiceConfigTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyInvoiceConfigOrder order,
            String oilCode, String oilCode1,
            String payWay, String payWay1,
            EnableStatus payStatus, EnableStatus payStatus1
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(order.getPlatPartnerId());
        // 准备数据
        List<String> invoiceOils = new ArrayList<String>();
        invoiceOils.add(oilCode);
        InvoicePaywayInfo invoicePaywayInfo = new InvoicePaywayInfo();
        invoicePaywayInfo.setPayway(payWay);
        invoicePaywayInfo.setStatus(payStatus);
        List<InvoicePaywayInfo> invoicePayway = new ArrayList<InvoicePaywayInfo>();
        invoicePayway.add(invoicePaywayInfo);
        if (testId == 1002) {
            gasMerchantTestBase.insertGasInvoiceConfig(0l, order.getPlatPartnerId(), 1L, 20L,
                    null, null, null, null, null);
        }
        // 测试过程
        if (testId == 1002) {
            invoiceOils.add(oilCode1);
        }
        InvoicePaywayInfo invoicePaywayInfo1 = new InvoicePaywayInfo();
        invoicePaywayInfo1.setPayway(payWay1);
        invoicePaywayInfo1.setStatus(payStatus1);
        if (testId == 1002) {
            invoicePayway.add(invoicePaywayInfo1);
        }
        order.setInvoiceOils(invoiceOils);
        order.setInvoicePayway(invoicePayway);
        // 调用接口
        BizResult result = merchantInvoiceService.modifyInvoiceConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<GasInvoiceConfigDO> invoiceConfigs =
                gasMerchantTestBase.findGasInvoiceConfigByPlatPartnerId(order.getPlatPartnerId());
        invoiceConfigAssert(invoiceConfigs.get(0), order.getPlatPartnerId(),
                Long.valueOf(order.getExpireTime()),
                Long.valueOf(order.getMinInvoiceAmount().getCent()),
                order.getRemark(),
                JSONObject.toJSONString(order.getInvoiceOils()),
                JSONObject.toJSONString(order.getInvoicePayway(),
                        SerializerFeature.WriteClassName));
        // 清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(order.getPlatPartnerId());
    }

    /**
     *
     */
    @AutoTest(file = "gas_merchant/merchantInvoiceServiceModifyInvoiceConfigTestFailOne.csv")
    @DisplayName("新增发票限制配置信息--参数非法")
    public void merchantInvoiceServiceModifyInvoiceConfigTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            ModifyInvoiceConfigOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1002) {
            order.setExpireTime(null);
        }
        if (testId == 1003) {
            order.setGid(null);
        }
        if (testId == 1004) {
            order = null;
        }
        // 调用接口
        BizResult result = merchantInvoiceService.modifyInvoiceConfig(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 发票配置信息
     */
    private void invoiceConfigAssert(
            GasInvoiceConfigDO info,
            String platPartnerId,
            Long expireTime,
            Long minInvoiceAmount,
            String remark,
            String invoiceOils,
            String invoicePayway
    ) {
        assertEquals(platPartnerId, info.getPlatPartnerId());
        assertEquals(expireTime, info.getExpireTime());
        assertEquals(minInvoiceAmount, info.getMinInvoiceAmount());
        assertEquals(remark, info.getRemark());
        assertEquals(invoiceOils, info.getInvoiceOils());
        assertEquals(invoicePayway, info.getInvoicePayway());
//        assertEquals(rawAddTime, info.getRawAddTime());
//        assertEquals(rawUpdateTime, info.getRawUpdateTime());
    }
}

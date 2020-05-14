package com.xjy.autotest.gas.test.station;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.MerchantInvoicePage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_merchant.GasInvoiceConfigDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/23.
 */
public class MerchantInvoiceSetWebTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @AutoTest(file = "gas/merchantInvoiceSetWebTestSuccess.csv")
    @DisplayName("开票规则设置--成功用例")
    public void merchantInvoiceSetWebTestSuccess(
            int testId,
            String userName,
            String password,
            String platPartnerId,
            String goodsCode,
            String goodsCode1,
            String tradeType,
            String tradeType1,
            String expireTime,
            String minInvoiceAmount,
            String remark
    ) {
        //清除数据
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(platPartnerId);
        //准备数据
        List<String> goodsCodes = new ArrayList<>();
        goodsCodes.add(goodsCode);
        goodsCodes.add(goodsCode1);
        List<String> tradeTypes = new ArrayList<>();
        tradeTypes.add(tradeType);
        tradeTypes.add(tradeType1);
        //打开浏览器测试页面
        open(testUrlGas);
        //开票设置
        MerchantInvoicePage merchantInvoicePage = new GasLoginPage()
                .login(userName, password)
                .stationCenter()
                .invoiceManager()
                .merchantInvoiceSet(expireTime, minInvoiceAmount, remark, goodsCodes, tradeTypes);
        //页面数据验证
//        merchantInvoicePage.checkData(stationCode, stationName, phoneNo, stationAddress, stationStatus);
        //数据库数据验证
        GasInvoiceConfigDO gasInvoiceConfigDO =
                gasMerchantTestBase.findGasInvoiceConfigByPlatPartnerId(platPartnerId).get(0);
        invoiceConfigAssert(gasInvoiceConfigDO, platPartnerId,
                Long.valueOf(expireTime), Long.valueOf(minInvoiceAmount),
                remark, JSONObject.toJSONString(goodsCodes),
                JSONObject.toJSONString(tradeTypes,
                        SerializerFeature.WriteClassName));

        //删除油站
        gasMerchantTestBase.cleanGasInvoiceConfigByPlatPartnerId(platPartnerId);
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

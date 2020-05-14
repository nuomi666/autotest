package com.xjy.autotest.gas.pages.station;

import com.codeborne.selenide.SelenideElement;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.StringUtils;
import org.openqa.selenium.Keys;

import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/20.
 */
public class MerchantInvoicePage {

    public MerchantInvoicePage merchantInvoiceQuery(String bizNo, String mobile, String email,
                                                    String invoiceType, String status, Date startTime,
                                                    Date endTime) {
        if (StringUtils.isNotBlank(bizNo)) {
            $("#tradeNo").setValue(bizNo);
        }
        if (StringUtils.isNotBlank(mobile)) {
            $("#mobile").setValue(mobile);
        }
        if (StringUtils.isNotBlank(email)) {
            $("#emailAddr").setValue(email);
        }
        if (StringUtils.isNotBlank(invoiceType)) {
            $("#invoiceType").click();
            $$(byText(invoiceType)).last().click();
        }
        if (StringUtils.isNotBlank(status)) {
            $("#state").click();
            $$(byText(status)).last().click();
        }
        if (startTime != null && endTime != null) {
            $("#finishTime", 1).click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-date").click();
            $(".ant-calendar-cell.ant-calendar-today.ant-calendar-selected-start-date.ant-calendar-selected-date" +
                    ".ant-calendar-selected-day").click();
            while (StringUtils.isNotBlank($("input[placeholder=\"开始时间\"", 2).val())) {
                $("input[placeholder=\"开始时间\"", 2).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"开始时间\"", 2).val(DateUtils.formatDate(startTime, "yyyy-MM-dd"));
            while (StringUtils.isNotBlank($("input[placeholder=\"结束时间\"", 2).val())) {
                $("input[placeholder=\"结束时间\"", 2).sendKeys(Keys.BACK_SPACE);
            }
            $("input[placeholder=\"结束时间\"", 2).val(DateUtils.formatDate(endTime, "yyyy-MM-dd"));
            $(".ant-calendar-ok-btn").click();
        }
        $(byText("搜索")).parent().click();
        return this;
    }

    public MerchantInvoicePage merchantInvoiceSet(String expireTime, String minInvoiceAmount, String remark,
                                                  List<String> goodsCodes, List<String> tradeTypes) {
        $(byText("开票设置")).click();
        if (StringUtils.isNotBlank(expireTime)) {
            $("#expireTime").setValue(expireTime);
        }
        if (StringUtils.isNotBlank(minInvoiceAmount)) {
            $("#minInvoiceAmount").setValue(minInvoiceAmount);
        }
        for (String goodsCode : goodsCodes) {
            $("input[value=\"" + goodsCode + "\"]").parent().click();
        }
        for (String tradeType : tradeTypes) {
            $("input[value=\"" + tradeType + "\"]").parent().click();
        }
        if (StringUtils.isNotBlank(remark)) {
            $("#remark").setValue(remark);
        }
        //点击"保存"按钮
        $("button[type=\"submit\"]").click();
        sleep(1000);
        return this;
    }

    public MerchantInvoicePage merchantInvoiceCompanySet(String stationName, String taxCompany, String taxCode,
                                                         String taxAddress, String taxMobile, String taxDrawer,
                                                         String taxAppId, String taxKey, String taxCertPwd,
                                                         String taxCertPath, String taxBankNo, String taxReviewer,
                                                         String taxPayee) {
        $(byText("开票信息")).click();
        //新增
        $(byLinkText("新增")).click();
        //选择油站
        $("#stationId").click();
        $$(byText(stationName)).last().click();
        //企业名称
        $("#taxCompany").setValue(taxCompany);
        //纳税人识别号
        $("#taxCode").setValue(taxCode);
        //企业地址
        $("#taxAddress").setValue(taxAddress);
        //企业电话
        $("#taxMobile").setValue(taxMobile);
        //开票人
        $("#taxDrawer").setValue(taxDrawer);
        //APPID
        $("#taxAppId").setValue(taxAppId);
        //秘钥
        $("#taxKey").setValue(taxKey);
        //证书密码
        $("#taxCertPwd").setValue(taxCertPwd);
        //上传证书
//        $(".ant-btn").parent().sendKeys("E:\\taxCertPath\110109500321654.pfx");
//        SelenideElement input = $(".ant-btn").parent().$("input[type=\"file\"]");
//        input.sendKeys("E:\\taxCertPath\110109500321654.pfx");
        $("input[type=\"file\"]").uploadFromClasspath("autotest/gas/" + taxCertPath);
        //开票企业银行账号
        if (StringUtils.isNotBlank(taxBankNo)) {
            $("#taxBankNo").setValue(taxBankNo);
        }
        //复核人
        if (StringUtils.isNotBlank(taxReviewer)) {
            $("#taxReviewer").setValue(taxReviewer);
        }
        //收款人
        if (StringUtils.isNotBlank(taxPayee)) {
            $("#taxPayee").setValue(taxPayee);
        }
        //点击"保存"按钮
        $("button[type=\"submit\"]").click();
        sleep(1000);
        return this;
    }

    public MerchantInvoicePage merchantInvoiceCompanyUpd(String stationName, String taxCompany, String taxCode,
                                                         String taxAddress, String taxMobile, String taxDrawer,
                                                         String taxAppId, String taxKey, String taxCertPwd,
                                                         String taxCertPath, String taxBankNo, String taxReviewer,
                                                         String taxPayee) {
        //进入开票信息页面
        $(byText("开票信息")).click();
        //选择油站
        $("#stationId").click();
        $$(byText(stationName)).last().click();
        //搜索(第二个搜索按钮)
        $(byText("搜 索"), 1).parent().click();
        //编辑
        $(byLinkText("编辑")).click();
        //企业名称
        $("#taxCompany").setValue(taxCompany);
        //纳税人识别号
        $("#taxCode").setValue(taxCode);
        //企业地址
        $("#taxAddress").setValue(taxAddress);
        //企业电话
        $("#taxMobile").setValue(taxMobile);
        //开票人
        $("#taxDrawer").setValue(taxDrawer);
        //APPID
        $("#taxAppId").setValue(taxAppId);
        //秘钥
        $("#taxKey").setValue(taxKey);
        //证书密码
        $("#taxCertPwd").setValue(taxCertPwd);
        //上传证书
        $("input[type=\"file\"]").uploadFromClasspath("autotest/gas/" + taxCertPath);
        //开票企业银行账号
        if (StringUtils.isNotBlank(taxBankNo)) {
            $("#taxBankNo").setValue(taxBankNo);
        }
        //复核人
        if (StringUtils.isNotBlank(taxReviewer)) {
            $("#taxReviewer").setValue(taxReviewer);
        }
        //收款人
        if (StringUtils.isNotBlank(taxPayee)) {
            $("#taxPayee").setValue(taxPayee);
        }
        //点击"保存"按钮
        $("button[type=\"submit\"]").click();
        sleep(1000);
        return this;
    }

    /**
     * 验证开票信息是否正确
     */
    public void checkData(String stationCode, String stationName, String taxCompany, String taxCode,
                          String taxAddress, String taxMobile, String taxDrawer, String taxBankNo,
                          String taxReviewer, String taxPayee) {
        //进入开票信息页面
        $(byText("开票信息")).click();
        //选择油站
        $("#stationId").click();
        $$(byText(stationName)).last().click();
        //搜索(第二个搜索按钮)
        $(byText("搜 索"), 1).parent().click();
        getDataCell(1, 1).shouldHave(text(stationCode));
        getDataCell(1, 2).shouldHave(text(stationName));
        getDataCell(1, 3).shouldHave(text(taxCompany));
        getDataCell(1, 4).shouldHave(text(taxCode));
        getDataCell(1, 5).shouldHave(text(taxAddress));
        getDataCell(1, 6).shouldHave(text(taxMobile));
        getDataCell(1, 7).shouldHave(text(taxDrawer));
        getDataCell(1, 8).shouldHave(text(taxBankNo));
        getDataCell(1, 9).shouldHave(text(taxReviewer));
        getDataCell(1, 10).shouldHave(text(taxPayee));
    }

    /**
     * 根据行号列号获取发票信息表格元素
     *
     * @param tr 行号
     * @param td 列号
     * @return
     */
    public SelenideElement getDataCell(int tr, int td) {
        return $("tbody.ant-table-tbody > tr:nth-child(" + tr + ") > td:nth-child(" + td + ")");
    }
}

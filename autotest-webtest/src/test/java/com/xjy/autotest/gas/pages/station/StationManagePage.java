package com.xjy.autotest.gas.pages.station;

import com.codeborne.selenide.SelenideElement;
import com.xjy.autotest.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * 油站管理页面
 *
 * @author ychaoyang
 * Created on 2019-11-14.
 */
public class StationManagePage {

    /**
     * 新增油站
     *
     * @param stationCode
     * @param stationName
     * @param phoneNo
     * @param stationAddress
     * @return
     */
    public StationManagePage addStation(String stationCode, String stationName, String phoneNo, String stationAddress) {
        $(byLinkText("新增")).click();
        $("#stationCode").setValue(stationCode);
        $("#stationName").setValue(stationName);
        $("#phoneNo").setValue(phoneNo);
        $(".anticon.anticon-down.ant-cascader-picker-arrow").click();
        $("li[title=\"重庆市\"]").click();
        $("li[title=\"市辖区\"]").click();
        $("li[title=\"渝北区\"]").click();
        $("#stationAddress").setValue(stationAddress);
        //选中全部油号
        $("span.ant-checkbox").click();
        //右移
        $("button[type=\"button\"]").click();
        //保存
        $("button[type=\"submit\"]").click();
        sleep(2000);
        //重新进入油站管理页面，刷新刚刚新增的油站数据
        $(byLinkText("油站管理")).click();
        return this;
    }

    /**
     * 编辑油站信息
     *
     * @param stationCode
     * @param stationName
     * @param phoneNo
     * @param stationAddress
     * @return
     */
    public StationManagePage editStation(String code, String stationCode, String stationName, String phoneNo,
                                         String oilName, String oilNamexx,
                                         String stationAddress) {
        //通过油站编码搜索
        $(".ant-input").setValue(code);
        $(".ant-input-suffix").click();
        getManageCell(1, 1).$(By.linkText("编辑")).click();
        if (StringUtils.isNotBlank(stationCode)) {
            $("#stationCode").setValue(stationCode);
        }
        if (StringUtils.isNotBlank(stationName)) {
            $("#stationName").setValue(stationName);
        }
        if (StringUtils.isNotBlank(phoneNo)) {
            $("#phoneNo").setValue(phoneNo);
        }
        if (StringUtils.isNotBlank(stationAddress)) {
            $("#stationAddress").setValue(stationAddress);
        }
        //删除油号
        if (StringUtils.isNotBlank(oilName)) {
            $(byTitle(oilName)).click();
            //左移
            $("button[type=\"button\"]", 1).click();
        }
        //分配油号
        if (StringUtils.isNotBlank(oilNamexx)) {
            $(byTitle(oilNamexx)).click();
            //右移
            $("button[type=\"button\"]", 0).click();
        }
//        //选中全部油号
//        $("span.ant-checkbox").click();
//        //右移
//        $("button[type=\"button\"]").click();
        //保存
        $("button[type=\"submit\"]").click();
        sleep(1000);
        return this;
    }

    /**
     * 配置油枪
     *
     * @param code
     * @param oldOilGuns
     * @param newOilGuns
     * @return
     */
    public StationManagePage editOilGun(String code, List<String> oldOilGuns, List<OilGunPageOrder> newOilGuns) {
        //通过油站编码搜索
        $(".ant-input").setValue(code);
        $(".ant-input-suffix").click();
        getManageCell(1, 1).$(By.linkText("配置油枪")).click();
        //如果是修改已经配置过了的油枪信息，可以先删除再新增
        if (oldOilGuns.size() > 0) {
            $(".anticon.anticon-delete").click();
        }
        if (newOilGuns.size() > 0) {
            int i = 0;
            for (OilGunPageOrder newOilGun : newOilGuns) {
                //填写油枪
                $(By.linkText("新增油枪")).click();
                $("span.ant-input-wrapper.ant-input-group", i).$("input").setValue(newOilGun.getOilGun());
                //选择油号
                $(".ant-select-selection__rendered", i).click();
                $$(byText(newOilGun.getOilName())).last().click();
                i++;
            }
        }
        //保存
        $("button[type=\"submit\"]").click();
        sleep(1000);
        return this;
    }

    /**
     * 删除油站
     *
     * @param stationCode
     * @return
     */
    public StationManagePage deleteStation(String stationCode) {
        //获取油站所在行行号
        int tr = getStationTr(stationCode);
        //若存在该油站则进行删除
        if (tr >= 1) {
            getManageCell(tr, 1).$(By.linkText("删除")).click();
        }
        return this;
    }


    /**
     * 验证油站数据是否正确
     *
     * @param stationCode
     * @param stationName
     * @param phoneNo
     * @param stationAddress
     */
    public void checkData(String stationCode, String stationName, String phoneNo, String stationAddress,
                          String status) {
        //重新进入油站管理页面，刷新刚刚新增的油站数据
        $(byLinkText("油站管理")).click();
        int tr = getStationTr(stationCode);
        getDataCell(tr, 1).shouldHave(text(stationCode));
        getDataCell(tr, 2).shouldHave(text(stationName));
        getDataCell(tr, 5).shouldHave(text(stationAddress));
        getDataCell(tr, 6).shouldHave(text(phoneNo));
        getStatus(tr).shouldHave(text(status));
    }

    /**
     * 验证油枪配置是否正确
     *
     * @param stationCode
     * @param newOilGuns
     */
    public static void checkOilGunData(String stationCode, List<OilGunPageOrder> newOilGuns) {
        //进入油枪配置页面
        $(".ant-input").setValue(stationCode);
        $(".ant-input-suffix").click();
        $(By.linkText("配置油枪")).click();
        if (newOilGuns.size() > 0) {
            for (int i = 0; i < newOilGuns.size(); i++) {
                $(".ant-input", i).shouldHave(text(newOilGuns.get(i).getOilGun()));
                $(".ant-select-selection-selected-value", i).shouldHave(text(newOilGuns.get(i).getOilName()));
            }
        }
    }

    /**
     * 根据油站代码获取油站所在行号
     *
     * @param stationCode
     * @return
     */
    public int getStationTr(String stationCode) {
        for (int a = 1; a < 10; a++) {
            if (stationCode.equals($("tbody.ant-table-tbody > tr:nth-child(" + a + ") > td:nth-child(" + 1 + ")").text())) {
                return a;
            }
        }
        return 0;
    }

    /**
     * 根据行号列号获取油站数据表格元素
     *
     * @param tr 行号
     * @param td 列号
     * @return
     */
    public SelenideElement getDataCell(int tr, int td) {
        return $("tbody.ant-table-tbody > tr:nth-child(" + tr + ") > td:nth-child(" + td + ")");
    }

    /**
     * 根据行号列号获取油站管理表格元素
     *
     * @param tr 行号
     * @param td 列号
     * @return
     */
    public SelenideElement getManageCell(int tr, int td) {
        return $("tbody.ant-table-tbody", 1).$("tr:nth-child(" + tr + ") > td:nth-child(" + td + ")");
    }

    /**
     * 根据行号获取油站状态
     *
     * @param tr 行号
     * @return
     */
    public SelenideElement getStatus(int tr) {
        return $("span.ant-switch-inner", tr - 1);
    }

    @Getter
    @Setter
    public class OilGunPageOrder {
        private String oilGun;
        private String oilName;
    }
}

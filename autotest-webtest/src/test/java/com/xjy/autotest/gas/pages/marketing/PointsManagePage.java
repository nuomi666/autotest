package com.xjy.autotest.gas.pages.marketing;

import com.xjy.autotest.utils.StringUtils;
import org.openqa.selenium.By;

import java.io.File;
import java.net.URL;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author ychaoyang
 * Created on 2020-02-26.
 */
public class PointsManagePage extends MarketingCenterPage {

    /**
     * 新增积分兑换优惠券
     *
     * @param goodsType
     * @param couponGoodsName
     * @param couponExchangePoint
     * @param couponStoreNum
     * @param couponOneExchangeTimes
     * @param couponForSaleTime
     * @param couponGoodsDescription
     * @return
     */
    public PointsManagePage addCoupon(
            String goodsType,
            String couponGoodsName,
            String couponExchangePoint,
            String couponStoreNum,
            String couponOneExchangeTimes,
            String couponForSaleTime,
            String couponInvalidTime,
            String couponGoodsDescription
    ) {
        $(byLinkText("新增")).click();
        //选择商户类型
        $("input[value=\"ENTITY\"]").parent().parent().click();
        $("input[value=\"" + goodsType + "\"]").parent().parent().click();
        //选择优惠券名称
        $("#couponGoodsName").click();
        $(byText(couponGoodsName)).click();
        //所需积分
        $("#couponExchangePoint").setValue(couponExchangePoint);
        //库存数量
        $("#couponStoreNum").setValue(couponStoreNum);
        //每人兑换次数
        $("#couponOneExchangeTimes").setValue(couponOneExchangeTimes);
        //上架时间
        $("#couponForSaleTime").click();
        $(".ant-calendar-input").setValue(couponForSaleTime);
        $(".ant-calendar-ok-btn").click();
        //下架时间
        $("#couponInvalidTime").click();
        $(".ant-calendar-input").setValue(couponInvalidTime);
        $(".ant-calendar-ok-btn").click();
        //商品介绍
        $("#couponGoodsDescription").setValue(couponGoodsDescription);
        //保存
        $("button[type=\"submit\"]").click();
        return this;
    }

    /**
     * 添加积分兑换商品
     *
     * @param goodsType
     * @param entityGoodsName
     * @param upload
     * @param entityGoodsDescription
     * @param entityExchangePoint
     * @param entityStoreNum
     * @param entityOneExchangeTimes
     * @param entityForSaleTime
     * @param entityInvalidTime
     * @param entityGainStations
     * @return
     */
    public PointsManagePage addGoods(
            String goodsType,
            String entityGoodsName,
            String upload,
            String entityGoodsDescription,
            String entityExchangePoint,
            String entityStoreNum,
            String entityOneExchangeTimes,
            String entityForSaleTime,
            String entityInvalidTime,
            List<String> entityGainStations
    ) {
        $(byLinkText("新增")).click();
        //选择商户类型
        $("input[value=\"" + goodsType + "\"]").parent().parent().click();
        //商品名称
        $("#entityGoodsName").setValue(entityGoodsName);
        //图片
        String resource = Thread.currentThread().getContextClassLoader().getResource(upload).getPath();
        //$("input[type=\"file\"]").parent().click();
        //$("#entityGoodsImg").setValue(resource);
        $("input[type=\"file\"]").uploadFromClasspath(upload);
        //描述
        $("#entityGoodsDescription").setValue(entityGoodsDescription);
        //需要积分
        $("#entityExchangePoint").setValue(entityExchangePoint);
        //库存
        $("#entityStoreNum").setValue(entityStoreNum);
        //每人兑换次数
        $("#entityOneExchangeTimes").setValue(entityOneExchangeTimes);
        //上架时间
        $("#entityForSaleTime").click();
        $(".ant-calendar-input").setValue(entityForSaleTime);
        $(".ant-calendar-ok-btn").click();
        //下架时间
        $("#entityInvalidTime").click();
        $(".ant-calendar-input").setValue(entityInvalidTime);
        $(".ant-calendar-ok-btn").click();
        //选择油站
        $("#entityGainStation").click();
        for (String entityGainStation : entityGainStations) {
            $(byText(entityGainStation)).click();
        }
        //保存
        $("button[type=\"submit\"]").click();
        return this;
    }

    /**
     * 检查数据
     *
     * @param couponGoodsName
     * @param couponExchangePoint
     * @param couponStoreNum
     */
    public void checkdata(
            String couponGoodsName,
            String couponExchangePoint,
            String couponStoreNum
    ) {
        $("input[placeholder=\"商品名称\"]").setValue(couponGoodsName);
        $(".ant-input-suffix").click();
        if (StringUtils.isNotBlank(couponGoodsName)) {
            getDataCell(1, 2).shouldHave(text(couponGoodsName));
        }
        if (StringUtils.isNotBlank(couponExchangePoint)) {
            getDataCell(1, 5).shouldHave(text(couponExchangePoint));
        }
        if (StringUtils.isNotBlank(couponStoreNum)) {
            getDataCell(1, 6).shouldHave(text(couponStoreNum));
        }
    }

}

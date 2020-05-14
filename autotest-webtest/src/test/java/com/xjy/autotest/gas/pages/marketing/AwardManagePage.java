package com.xjy.autotest.gas.pages.marketing;

import com.xjy.autotest.utils.StringUtils;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byLinkText;

/**
 * @author ychaoyang
 * Created on 2020-2-24.
 */
public class AwardManagePage extends MarketingCenterPage {

    /**
     * 新增抽奖活动
     *
     * @param name
     * @param title
     * @param lifeCycle
     * @param beginTime
     * @param finishTime
     * @param description
     * @param prizeNames
     * @param stockNums
     * @param awards
     * @param money
     * @param points
     * @param couponName
     * @param couponNum
     * @return
     */
    public AwardManagePage addAward(
            String name,
            String title,
            String lifeCycle,
            String beginTime,
            String finishTime,
            String description,
            List<String> prizeNames,
            List<String> stockNums,
            List<String> awards,
            String money,
            String points,
            String couponName,
            String couponNum
    ) {
        $(byLinkText("新增抽奖")).click();
        //抽奖名称
        $("#name").setValue(name);
        //页面标题
        $("#title").setValue(title);
        //有效期
        if ("FOREVER".equals(lifeCycle)) {
            $("input[value=\"" + lifeCycle + "\"]").parent().click();
        }
        if ("TIME_SLOT".equals(lifeCycle)) {
            $("input[value=\"" + lifeCycle + "\"]").parent().click();
            //选择日期
            $("#range-time-picker").click();
            $("td[title=\"" + beginTime + "\"] > div").click();
            $("td[title=\"" + finishTime + "\"] > div").click();
            $(".ant-calendar-ok-btn").click();
        }
        //抽奖规则
        $("#description").setValue(description);
        for (int i = 0; i < prizeNames.size(); i++) {
            //奖品设置
            $("#award-set").click();
            //奖品名称
            $("#prizeName").setValue(prizeNames.get(i));
            //奖品数量
            $("#stockNum").setValue(stockNums.get(i));
            //奖品
            String award = awards.get(i);
            $("input[value=\"" + award + "\"]").parent().click();
            if ("MONEY".equals(award)) {
                $("#money").setValue(money);
            }
            if ("POINTS".equals(award)) {
                $("#points").setValue(points);
            }
            if ("COUPON".equals(award)) {
                $(byText("请选择优惠券")).parent().click();
                //优惠券名称
                $(byText(couponName)).click();
                $("input[placeholder=\"请输入赠送张数\"]").setValue(couponNum);
            }
            //确认
            $(".ant-btn.ant-btn-primary", 2).click();
        }
        //保存
        $("button[type=\"submit\"]").click();
        return this;
    }

    /**
     * 检查抽奖数据
     *
     * @param name
     */
    public void checkAward(
            String name
    ) {
        $("#name").setValue(name);
        $(byText("搜 索")).parent().click();
        if (StringUtils.isNotBlank(name)) {
            getDataCell(1, 1).shouldHave(text(name));
        }
    }

}

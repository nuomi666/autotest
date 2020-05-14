package com.xjy.autotest.gas.pages.report;

import com.codeborne.selenide.Condition;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author ychaoyang
 * Created on 2020-03-03.
 */
public class ClassReportPage extends ReportCenterPage {

    public ClassReportPage searchClassReport(String operateName) {
        //根据员工姓名搜索
        $("input[placeholder=\"员工姓名\"]").setValue(operateName);
        $(".ant-input-suffix").click();
        return this;
    }

    /**
     * 验证页面数据
     *
     * @param tr
     * @param stationName
     * @param oils
     * @param counts
     * @param amounts
     * @param refunds
     * @param favourAmounts
     * @param settleAmounts
     */
    public void checkData(
            int tr,
            String stationName,
            String oils,
            String counts,
            Double amounts,
            Double refunds,
            Double favourAmounts,
            Double settleAmounts
    ) {
        getDataCell(tr, 3).shouldHave(text(stationName));
        getDataCell(tr, 5).shouldHave(text(oils));
        getDataCell(tr, 6).shouldHave(text(counts));
        Assert.assertEquals(Double.valueOf(getDataCell(tr, 7).text()), amounts);
        Assert.assertEquals(Double.valueOf(getDataCell(tr, 8).text()), refunds);
        Assert.assertEquals(Double.valueOf(getDataCell(tr, 9).text()), favourAmounts);
        Assert.assertEquals(Double.valueOf(getDataCell(tr, 10).text()), Double.valueOf(String.format("%.2f", settleAmounts)));
    }

    /**
     * 查询上班时间
     *
     * @param tr 第几行数据
     * @return
     */
    public String findBeginTime(int tr) {
        return getDataCell(tr, 1).text();
    }

    /**
     * 查询下班时间
     *
     * @param tr 第几行数据
     * @return
     */
    public String findEndTime(int tr) {
        return getDataCell(tr, 2).text();
    }

}

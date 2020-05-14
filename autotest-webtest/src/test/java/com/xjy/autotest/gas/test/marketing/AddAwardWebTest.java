package com.xjy.autotest.gas.test.marketing;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.marketing.ActivityManagePage;
import com.xjy.autotest.gas.pages.marketing.AwardManagePage;
import com.xjy.autotest.testbase.Gas_marketpcTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_marketpc.LuckDrawCampaignDO;
import dal.model.gas_marketpc.LuckDrawPrizeDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2020-2-24.
 */
public class AddAwardWebTest extends WebTestBase {

    @Autowired
    Gas_marketpcTestBase gas_marketpcTestBase;

    @AutoTest(file = "gas/addAwardWebTestSuccess.csv")
    @DisplayName("新增奖品--成功用例")
    public void addAwardWebTestSuccess(
            int testId,
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
        //清除数据
        gas_marketpcTestBase.cleanLuckDrawCampaignByName(name);
        //准备数据
        //打开加好油中台页面
        open(testUrlGas);
        //登录并新增奖品
        AwardManagePage awardManagePage = new GasLoginPage()
                .login(USER_NAME_JHY, PASS_WORD_JHY)
                .marketingCenter()
                .award()
                .addAward(name, title, lifeCycle, beginTime, finishTime, description,
                        prizeNames, stockNums, awards, money, points, couponName, couponNum);
        //页面数据验证
        awardManagePage.checkAward(name);
        //数据库数据验证
        LuckDrawCampaignDO luckDrawCampaignDO = gas_marketpcTestBase.findLuckDrawCampaignByName(name).get(0);
        assertEquals(title, luckDrawCampaignDO.getTitle());
        assertEquals(description, luckDrawCampaignDO.getDescription());
        assertEquals("ABLE", luckDrawCampaignDO.getStatus());
        assertEquals(lifeCycle, luckDrawCampaignDO.getLifeCycle());
        String campaignNo = luckDrawCampaignDO.getCampaignNo();
        for (int i = 0; i < awards.size(); i++) {
            LuckDrawPrizeDO luckDrawPrizeDO = gas_marketpcTestBase.findLuckDrawPrizeByCampaignNoAndPrizeType(campaignNo, awards.get(i)).get(0);
            assertEquals(prizeNames.get(i), luckDrawPrizeDO.getPrizeName());
            assertEquals(stockNums.get(i), luckDrawPrizeDO.getStockNum() + "");
            if ("MONEY".equals(awards.get(i))) {
                assertEquals(money, luckDrawPrizeDO.getPrizeDetail());
            }
            if ("POINTS".equals(awards.get(i))) {
                assertEquals(points, luckDrawPrizeDO.getPrizeDetail());
            }
        }
        //删除记录
        awardManagePage.delete(0);
        sleep(1);
        assertEquals("DISABLE", gas_marketpcTestBase.findLuckDrawCampaignByName(name).get(0).getStatus());
        //删除数据
        gas_marketpcTestBase.cleanLuckDrawCampaignByName(name);
        gas_marketpcTestBase.cleanLuckDrawPrizeByCampaignNo(campaignNo);

    }
}

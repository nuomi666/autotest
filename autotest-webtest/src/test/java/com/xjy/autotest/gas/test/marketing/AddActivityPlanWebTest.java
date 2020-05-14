package com.xjy.autotest.gas.test.marketing;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.marketing.ActivityPlanManagePage;
import com.xjy.autotest.testbase.Gas_marketpcTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import com.xjy.autotest.utils.DateUtils;
import dal.model.gas_marketpc.SalesCampaignDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2020-2-21.
 */
public class AddActivityPlanWebTest extends WebTestBase {

    @Autowired
    Gas_marketpcTestBase gas_marketpcTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @AutoTest(file = "gas/addActivityPlanWebTestSuccess.csv")
    @DisplayName("新增活动方案--成功用例")
    public void addActivityPlanWebTestSuccess(
            int testId,
            String userName,
            String password,
            String name,
            String modelName,
            String money,
            String stationName,
            String lifeCycle,
            String beginTime,
            String finishTime
    ) {
        //清除数据
        gas_marketpcTestBase.cleanSalesCampaignByName(name);
        //准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date startTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, 10, 0);
        Date endTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 20, 0, 10, 0);
        //打开加好油中台页面
        open(testUrlGas);
        //登录并新增活动方案
        ActivityPlanManagePage activityPlanManagePage = new GasLoginPage()
                .login(userName, password)
                .marketingCenter()
                .activityPlan()
                .addActivityPlan(name, modelName, money, stationName, lifeCycle, beginTime, finishTime, startTime,
                        endTime);
        //页面数据验证
        activityPlanManagePage.checkActivityPlan(name, modelName);
        //数据库数据验证
        SalesCampaignDO salesCampaignDO = gas_marketpcTestBase.findSalesCampaignByName(name).get(0);
        assertEquals(modelName, salesCampaignDO.getDescription());
        assertEquals("ABLE", salesCampaignDO.getStatus());
        //删除记录
        activityPlanManagePage.delete(0);
        sleep(1);
        assertEquals("DISABLE", gas_marketpcTestBase.findSalesCampaignByName(name).get(0).getStatus());
        //删除数据
        gas_marketpcTestBase.cleanSalesCampaignByName(name);

    }
}

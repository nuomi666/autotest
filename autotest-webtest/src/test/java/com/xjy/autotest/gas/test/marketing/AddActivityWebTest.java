package com.xjy.autotest.gas.test.marketing;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.marketing.ActivityManagePage;
import com.xjy.autotest.testbase.Gas_marketpcTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_marketpc.SalesCampaignGroupDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2020-2-24.
 */
public class AddActivityWebTest extends WebTestBase {

    @Autowired
    Gas_marketpcTestBase gas_marketpcTestBase;

    @AutoTest(file = "gas/addActivityTestSuccess.csv")
    @DisplayName("新增活动--成功用例")
    public void addActivityWebTestSuccess(
            int testId,
            String groupName,
            String over,
            String priority,
            String name,
            String name1
    ) {
        //清除数据
        gas_marketpcTestBase.cleanSalesCampaignGroupByGroupName(groupName);
        //准备数据
        List<String> planNames = new ArrayList<>();
        planNames.add(name);
        planNames.add(name1);
        //打开加好油中台页面
        open(testUrlGas);
        //登录并新增活动
        ActivityManagePage activityManagePage = new GasLoginPage()
                .login(USER_NAME_JHY, PASS_WORD_JHY)
                .marketingCenter()
                .activity()
                .addActivity(groupName, over, priority, planNames);
        //页面数据验证
        activityManagePage.checkActivity(groupName, over, priority, planNames);
        //数据库数据验证
        SalesCampaignGroupDO salesCampaignGroupDO =
                gas_marketpcTestBase.findSalesCampaignGroupByGroupName(groupName).get(0);
        assertEquals(priority, salesCampaignGroupDO.getPriority() + "");
        assertEquals("ABLE", salesCampaignGroupDO.getEnableStatus());
        //删除记录
        activityManagePage.delete(0);
        //删除数据
        gas_marketpcTestBase.cleanSalesCampaignGroupByGroupName(groupName);

    }
}

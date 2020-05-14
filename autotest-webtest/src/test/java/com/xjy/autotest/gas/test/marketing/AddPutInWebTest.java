package com.xjy.autotest.gas.test.marketing;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.marketing.PutInPage;
import com.xjy.autotest.testbase.Gas_marketpcTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.util.DateUtil;
import dal.model.gas_marketpc.PreciseGiveDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * 新增精准投放
 *
 * @author ychaoyang
 * Created on 2020-02-26.
 */
public class AddPutInWebTest extends WebTestBase {

    @Autowired
    Gas_marketpcTestBase gas_marketpcTestBase;

    @AutoTest(file = "gas/addPutInWebTestSuccess.csv")
    @DisplayName("新增精准投放--成功用例")
    public void addPutInWebTestSuccess(
            int testId,
            String deliveryName,
            String deliveryStartTime,
            String deliveryDescription,
            String conditionType,
            String startBirth,
            String endBirth,
            String sex,
            double minBalance,
            double maxBalance,
            int minPoints,
            int maxPoints,
            String mobile,
            String mobile1,
            String stationName,
            String goodsCode,
            String goodsCode1,
            int minUnConsumDays,
            int maxUnConsumDays,
            double minTotalConsumAmount,
            double maxTotalConsumAmount,
            double minPrice,
            double maxPrice,
            String goodsType,
            double minLiters,
            double maxLiters,
            int minOilCount,
            int maxOilCount,
            double minHinghLiters,
            double maxHinghLiters,
            String basicDiscount,
            String points
    ) {
        //清除数据
        gas_marketpcTestBase.cleanPreciseGiveByName(deliveryName);
        //准备数据
        Date statisticalStartTime = DateUtils.parseDate("2020-03-01");
        Date statisticalEndTime = DateUtils.parseDate("2020-03-31");
        Date minConsumTime = DateUtils.parseDate("2020-01-01");
        Date maxConsumTime = DateUtils.getSqlDate();
        List<String> conditions = new ArrayList<>();
        if ("基础条件筛选".equals(conditionType)) {
            conditions.add("会员等级");
            conditions.add("会员生日");
            conditions.add("会员性别");
            conditions.add("账户余额");
            conditions.add("账户积分");
            conditions.add("手机号码");
        }
        if ("统计条件筛选".equals(conditionType)) {
            conditions.add("油站偏好");
            conditions.add("消费偏好");
            conditions.add("最近消费时间");
            conditions.add("未消费天数");
            conditions.add("累计消费金额");
            conditions.add("客单价");
            conditions.add("累计消费油品数量");
            conditions.add("累计消费油品次数");
            conditions.add("单次最高消费油品数量");
        }
        if ("会员分组".equals(conditionType)) {
            conditions.add("会员等级");
            conditions.add("会员生日");
            conditions.add("会员性别");
            conditions.add("会员余额");
            conditions.add("会员积分");
            conditions.add("手机号码");
        }
        List<String> grades = new ArrayList<>();
        grades.add("GRADE_SILVER");
        grades.add("GRADE_GOLD");
        List<String> mobiles = new ArrayList<>();
        mobiles.add(mobile);
        mobiles.add(mobile1);
        List<String> stations = new ArrayList<>();
        stations.add(stationName);
        List<String> goodsCodes = new ArrayList<>();
        goodsCodes.add(goodsCode);
        goodsCodes.add(goodsCode1);
        //打开加好油中台页面
        open(testUrlGas);
        //登录并新增精准投放
        PutInPage putInPage = new GasLoginPage()
                .login(USER_NAME_JHY, PASS_WORD_JHY)
                .marketingCenter()
                .putIn()
                .addPutIn(deliveryName, deliveryStartTime, deliveryDescription,
                        conditionType, conditions, grades, startBirth, endBirth,
                        sex, minBalance, maxBalance, minPoints, maxPoints,
                        mobiles, statisticalStartTime, statisticalEndTime,
                        stations, goodsCodes, minConsumTime, maxConsumTime,
                        minUnConsumDays, maxUnConsumDays, minTotalConsumAmount,
                        maxTotalConsumAmount, minPrice, maxPrice, goodsType,
                        minLiters, maxLiters, minOilCount, maxOilCount,
                        minHinghLiters, maxHinghLiters, basicDiscount, points);
        //页面数据验证
        putInPage.checkDeliveryData(deliveryName, deliveryStartTime, deliveryDescription, "未投放", "测试商家");
        //数据库数据验证
        PreciseGiveDO preciseGiveDO = gas_marketpcTestBase.findPreciseGiveByName(deliveryName).get(0);
        assertEquals(deliveryName, preciseGiveDO.getName());
        assertEquals(deliveryStartTime, DateUtil.simpleFormat(preciseGiveDO.getGiveTime()));
        assertEquals(deliveryDescription, preciseGiveDO.getMemo());
        assertEquals("INIT", preciseGiveDO.getStatus());
        //删除记录
        //删除数据
        gas_marketpcTestBase.cleanPreciseGiveByName(deliveryName);

    }

}

package com.xjy.autotest.gas.test.marketing;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.marketing.CouponManagePage;
import com.xjy.autotest.testbase.Gas_marketpcTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xjy.autotest.utils.StringUtils;
import dal.model.gas_marketpc.CouponDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author ychaoyang
 * Created on 2020-2-19.
 */
public class AddCouponWebTest extends WebTestBase {

    @Autowired
    Gas_marketpcTestBase gas_marketpcTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001 新增优惠券
     */
    @AutoTest(file = "gas/addCouponWebTestSuccess.csv")
    @DisplayName("新增优惠券--成功用例")
    public void addCouponWebTestSuccess(
            int testId,
            String userName,
            String password,
            String name,
            String namexx,
            String couponType,
            String amountData,
            String couponBizType,
            String goodsCode,
            String goodsCode1,
            String expirationType,
            String effectDay,
            String valueTime,
            String thresholdAmount,
            String useTimeUnit,
            String startHours,
            String endHours,
            String memo,
            String memoxx
    ) {
        //清除数据
        gas_marketpcTestBase.cleanCouponByCouponName(name);
        //准备数据
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(DateUtils.getSqlDate());
        Date startTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 0, 0, 10, 0);
        Date endTime = gasMerchantInitDataBase.afterDay(DateUtils.parseDate2(now), 0, 20, 0, 10, 0);
        List<String> weeks = new ArrayList<>();
        weeks.add("1");
        weeks.add("7");
        List<String> months = new ArrayList<>();
        months.add("1");
        months.add("15");
        List<String> goodsCodes = new ArrayList<>();
        if (StringUtils.isNotBlank(goodsCode)) {
            goodsCodes.add(goodsCode);
        }
        if (StringUtils.isNotBlank(goodsCode1)) {
            goodsCodes.add(goodsCode1);
        }
        //打开加好油中台页面
        open(testUrlGas);
        //登录并新增优惠券
        CouponManagePage couponManagePage = new GasLoginPage()
                .login(userName, password)
                .marketingCenter()
                .coupon()
                .addCoupon(name, couponType, amountData, couponBizType, goodsCodes,
                        expirationType, startTime, endTime, effectDay, valueTime, thresholdAmount,
                        useTimeUnit, startHours, endHours, weeks, months, memo);
        //页面数据验证
        couponManagePage.checkData(name, couponType);
        //数据库数据验证
        CouponDO coup = gas_marketpcTestBase.findCouponByCouponName(name).get(0);
        assertEquals(name, coup.getCouponName());
        assertEquals(couponBizType, coup.getCouponBizType());
        assertEquals("ABLE", coup.getStatus());
//        assertEquals(2, coup.getUseTimeUnit());
        //修改
        couponManagePage.updateCoupon(namexx, memoxx);
        couponManagePage.checkData(namexx, couponType);
        CouponDO coup1 = gas_marketpcTestBase.findCouponByCouponName(coup.getDefinitionId()).get(0);
        assertEquals(namexx, coup1.getCouponName());
        assertEquals(couponBizType, coup1.getCouponBizType());
        assertEquals("ABLE", coup1.getStatus());
        //删除
        couponManagePage.deleteCoupon("修改优惠券");
        CouponDO coup2 = gas_marketpcTestBase.findCouponByCouponName(coup.getDefinitionId()).get(0);
        assertEquals(namexx, coup2.getCouponName());
        assertEquals(couponBizType, coup2.getCouponBizType());
        assertEquals("DISABLE", coup2.getStatus());
        //删除数据
        gas_marketpcTestBase.cleanCouponByCouponName(name);
    }
}

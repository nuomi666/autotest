package com.xjy.autotest.data;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.CashierTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import dal.model.cashier.ChannelMappingDO;
import dal.model.cashier.RouteMappingDO;
import dal.model.cashier.SettleChannelMappingDO;
import dal.model.user.AccountDO;
import dal.model.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ychaoyang
 * Created on 18/9/13.
 */
public class DataOfHuairen extends SpringBootTestBase {

    @Autowired
    UserTestBase userTestBase;

    @Autowired
    CashierTestBase cashierTestBase;

    /**
     * 怀仁_清结算_会员_测试数据
     */
    @AutoTest(file = "data/huairen_user.csv")
    public void huairen_user(
            UserDO userDO,
            AccountDO accountDO
    ) {
        //清除数据
        userTestBase.cleanUserByUserId(userDO.getUserId());
        userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
        print(userDO);
        print(accountDO);
        //插入会员数据
        if (null != userDO.getUserId()) {
            userDO.setPayPassword(getUserPassword(userDO.getUserId(), userDO.getPayPassword()));
            userTestBase.insertUser(userDO);
        }
        userTestBase.insertAccount(accountDO);
        print("会员数据生成成功");
    }

    /**
     * 怀仁_清结算_路由_测试数据
     */
    @AutoTest(file = "data/huairen_cashier.csv")
    public void huairen_cashier(
            SettleChannelMappingDO settleChannelMappingDO,
            ChannelMappingDO channelMappingDO,
            RouteMappingDO routeMappingDO
    ) {
        //清除数据
        cashierTestBase.cleanSettleChannelMappingByPartnerId(settleChannelMappingDO.getPartnerId());
        cashierTestBase.cleanChannelMappingByPartnerId(channelMappingDO.getPartnerId());
        cashierTestBase.cleanRouteMappingByPartnerId(routeMappingDO.getPartnerId());
        //插入会员数据
        cashierTestBase.insertSettleChannelMapping(settleChannelMappingDO);
        if (null != channelMappingDO.getPartnerId()) {
            cashierTestBase.insertChannelMapping(channelMappingDO);
        }
        if (null != routeMappingDO.getPartnerId()) {
            cashierTestBase.insertRouteMapping(routeMappingDO);
        }
        print("会员数据生成成功");
    }

}

package com.xjy.autotest.data;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import dal.model.user.AccountDO;
import dal.model.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ychaoyang
 * Created on 18/9/13.
 */
public class DataOfNuomi extends SpringBootTestBase {

    @Autowired
    UserTestBase userTestBase;

    //@Autowired
    //CashierTestBase cashierTestBase;

    /**
     * 糯米_清结算_会员_测试数据
     */
    @AutoTest(file = "data/nuomi_user.csv")
    public void nuomi_user(
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

}

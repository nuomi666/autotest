package com.xjy.autotest.gas.test.station;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.StationOwnerManagerPage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_merchant.GasMerchantUserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author huazai
 * Created on 2019-11-20.
 */
public class AddStationOwnerWebTest extends WebTestBase {
    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @AutoTest(file = "gas/addStationOwnerWebTestSuccess.csv")
    @DisplayName("新增站长--成功用例")
    public void addStationOwner(
            int testId,
            String username,
            String password,
            String realname,
            String stationuser,
            String stationpwd,
            String phone,
            String stationName,
            String roleName) {
        //清除数据
        gas_merchantTestBase.cleanGasMerchantUserByUserName(realname);
        //打开加好油中台页面
        open(testUrlGas);
        //新增站长
        StationOwnerManagerPage stationOwnerManagerPage = new GasLoginPage()
                .login(username, password)
                .stationCenter()
                .stationManager()
                .addStationOwner(realname, stationuser, stationpwd, phone, stationName, roleName);
        //数据验证
        stationOwnerManagerPage.checkData(stationuser, realname, phone, stationName);
        //数据库数据验证
        GasMerchantUserDO gasMerchantUserDO = gas_merchantTestBase.findGasMerchantUserByUserName(realname).get(0);
        assertEquals(stationuser, gasMerchantUserDO.getAccount());
        assertEquals(phone, gasMerchantUserDO.getMobileNo());
        //TODO:验证油站和密码
        //删除站长信息
        gas_merchantTestBase.cleanGasMerchantUserByUserName(realname);


    }

}

package com.xjy.autotest.gas.test.station;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.gas.pages.GasLoginPage;
import com.xjy.autotest.gas.pages.station.StationOwnerManagerPage;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.web.WebTestBase;
import dal.model.gas_merchant.GasMerchantStationDO;
import dal.model.gas_merchant.GasMerchantUserDO;
import dal.model.gas_merchant.GasMerchantUserStationDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.open;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/3/11.
 */
public class UpdateMerchantUserTest extends WebTestBase {

    @Autowired
    Gas_merchantTestBase gas_merchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @AutoTest(file = "gas/updateMerchantUserTestSuccess.csv")
    @DisplayName("编辑角色--成功用例")
    public void updateMerchantUserTestSuccess(
            int testId,
            String username,
            String password,
            String platPartnerId,
            String realname,
            String account,
            String userPassword,
            String phone,
            String stationName,
            String realname1,
            String userPassword1,
            String phone1,
            String stationName1,
            String roleName) {
        //清除数据
        gas_merchantTestBase.cleanGasMerchantUserByUserName(realname);
        gas_merchantTestBase.cleanGasMerchantUserByUserName(realname1);
        gasMerchantInitDataBase.cleanUserUniqueKeyByUniqueKey(account);
        silverboltTestBase.cleanGasMerchantUserByUserName(realname);
        silverboltTestBase.cleanGasMerchantUserByUserName(realname1);
        //准备数据
        //打开加好油中台页面
        open(testUrlGas);
        //修改站长
        StationOwnerManagerPage stationOwnerManagerPage = new GasLoginPage()
                .login(username, password)
                .stationCenter()
                .stationManager()
                .addStationOwner(realname, account, userPassword, phone, stationName, roleName)
                .editMerchantUser(account, realname1, userPassword1, phone1, stationName1, roleName);
        //数据验证
        stationOwnerManagerPage.checkData(account, realname1, phone1, stationName1);
        //数据库数据验证
        GasMerchantUserDO gasMerchantUserDO = gas_merchantTestBase.findGasMerchantUserByUqKeyAndUserType(account,
                "BOSS").get(0);
        assertEquals(account, gasMerchantUserDO.getAccount());
        assertEquals(phone1, gasMerchantUserDO.getMobileNo());
        assertEquals(realname1, gasMerchantUserDO.getUserName());
        //油站角色关系校验
        GasMerchantUserStationDO relation = gas_merchantTestBase.findGasMerchantUserStationByUserId(gasMerchantUserDO
                .getUserId()).get(0);
        GasMerchantStationDO station = gas_merchantTestBase.findGasMerchantStationByStationName(stationName1).get(0);
        assertEquals(relation.getStationId(), station.getStationId());
        //TODO:验证油站和密码
        //删除站长信息
        gas_merchantTestBase.cleanGasMerchantUserByUserName(realname);
        gas_merchantTestBase.cleanGasMerchantUserByUserName(realname1);
        gasMerchantInitDataBase.cleanUserUniqueKeyByUniqueKey(account);
//        silverboltTestBase.cleanGasMerchantUserByUserId(gasMerchantUserDO.getUserId());
    }

}

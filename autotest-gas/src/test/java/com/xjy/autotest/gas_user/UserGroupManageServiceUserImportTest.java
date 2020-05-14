package com.xjy.autotest.gas_user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.*;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.user.api.UserGroupManageService;
import com.xyb.gas.user.api.enums.MemberType;
import com.xyb.gas.user.api.enums.Sex;
import com.xyb.gas.user.api.enums.UserGrade;
import com.xyb.gas.user.api.order.userGroup.UserGroupImportOrder;
import com.xyb.gas.user.api.result.info.UserExportInfo;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_user.UserDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * @author nuomi
 * Created on 2020/04/01.
 */
public class UserGroupManageServiceUserImportTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    UserGroupManageService userGroupManageService;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    /**
     * 根据手机号给分组添加会员，如果会员不存在则会先根据手机号注册一个会员,如果该
     * 会员已经在其他分组，则移到当前分组
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceUserImportTestSuccess.csv")
    @DisplayName("导入会员--成功用例")
    public void userGroupManageServiceUserImportTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String groupCode,
            String name,
            String name1,
            String userId,
            String userId1,
            String mobileNo,
            String mobileNo1,
            String mobileNo2,
            UserGroupImportOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByMobile(mobileNo);
        userTestBase.cleanUserByMobile(mobileNo1);
        userTestBase.cleanUserByMobile(mobileNo2);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserByMobile(mobileNo);
        silverboltTestBase.cleanGasUserByMobile(mobileNo1);
        silverboltTestBase.cleanGasUserByMobile(mobileNo2);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
        // 准备数据
        gasMerchantInitDataBase.initGasMerchant(platPartnerId, "糯米测试商家", "wxa2557eabb23b47e8",
                "糯米", OID.newID(), OID.newID(),
                OID.newID(), "Merchant", "18825814769", "ABLE");
        userTestBase.insertUserGroup(0L, order.getUserGroupNo(), platPartnerId, name, "FIXED", 0, null, null, null);
        silverboltTestBase.insertGasUserGroup(0L, order.getUserGroupNo(), platPartnerId, name, "FIXED", null, null,
                null, null, null);
        userTestBase.insertUser(0L, userId, platPartnerId, platPartnerId, mobileNo, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", null, null);
        silverboltTestBase.insertGasUser(0L, userId, platPartnerId, mobileNo, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null, null,
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        userTestBase.insertUser(0L, userId1, platPartnerId, platPartnerId, mobileNo1, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", name1, groupCode);
        silverboltTestBase.insertGasUser(0L, userId1, platPartnerId, mobileNo1, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), name1, groupCode,
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        // 测试过程
        List<String> mobileNos = new ArrayList<String>();
        mobileNos.add(mobileNo);
        if (testId == 1002) {
            mobileNos.add(mobileNo1);
        }
        if (testId == 1003) {
            mobileNos.add(mobileNo2);
        }
        order.setMobileNos(mobileNos);
        // 调用接口
        BizResult<UserExportInfo> result = userGroupManageService.userImport(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        sleep(3);
        assertEquals(0, result.getInfo().getTotalFail());
        assertEquals(mobileNos.size(), result.getInfo().getTotalSuccess());
        UserDO user = userTestBase.findUserByMobile(mobileNo).get(0);
        assertEquals(name, user.getGroupName());
        assertEquals(order.getUserGroupNo(), user.getGroupCode());
        GasUserDO gasUser = silverboltTestBase.findGasUserByMobile(mobileNo).get(0);
        assertEquals(name, gasUser.getGroupName());
        assertEquals(order.getUserGroupNo(), gasUser.getGroupCode());
        if (testId == 1002) {
            UserDO user1 = userTestBase.findUserByMobile(mobileNo1).get(0);
            assertEquals(name, user1.getGroupName());
            assertEquals(order.getUserGroupNo(), user1.getGroupCode());
            GasUserDO gasUser1 = silverboltTestBase.findGasUserByMobile(mobileNo1).get(0);
            assertEquals(name, gasUser1.getGroupName());
            assertEquals(order.getUserGroupNo(), gasUser1.getGroupCode());
        }
        if (testId == 1003) {
            UserDO user1 = userTestBase.findUserByMobile(mobileNo2).get(0);
            assertEquals(name, user1.getGroupName());
            assertEquals(order.getUserGroupNo(), user1.getGroupCode());
            GasUserDO gasUser1 = silverboltTestBase.findGasUserByMobile(mobileNo2).get(0);
            assertEquals(name, gasUser1.getGroupName());
            assertEquals(order.getUserGroupNo(), gasUser1.getGroupCode());
        }
        // 清除数据
        userTestBase.cleanUserByMobile(mobileNo);
        userTestBase.cleanUserByMobile(mobileNo1);
        userTestBase.cleanUserByMobile(mobileNo2);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        xybUserTestBase.cleanUserByUserId(platPartnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(platPartnerId);
        merchantTestBase.cleanGasMerchantByPlatPartnerId(platPartnerId);
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(platPartnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(platPartnerId);
        silverboltTestBase.cleanGasUserByMobile(mobileNo);
        silverboltTestBase.cleanGasUserByMobile(mobileNo1);
        silverboltTestBase.cleanGasUserByMobile(mobileNo2);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceUserImportTestFailOne.csv")
    @DisplayName("导入会员--参数非法")
    public void userGroupManageServiceUserImportTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String mobileNo,
            UserGroupImportOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        List<String> mobileNos = new ArrayList<String>();
        if (testId != 1003) {
            mobileNos.add(mobileNo);
        }
        order.setMobileNos(mobileNos);
        if (testId == 1001) {
            order.setUserGroupNo(null);
        }
        if (testId == 1002) {
            order.setPlatPartnerId(null);
        }
        if (testId == 1004) {
            order.setGid(null);
        }
        if (testId == 1005) {
            order = null;
        }
        // 调用接口
        BizResult<UserExportInfo> result = userGroupManageService.userImport(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_user/userGroupManageServiceUserImportTestFailTwo.csv")
    @DisplayName("导入会员--失败用例")
    public void userGroupManageServiceUserImportTestFailTwo(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String platPartnerId,
            String name,
            String userId,
            String mobileNo,
            UserGroupImportOrder order
    ) {
        // 清除数据
        userTestBase.cleanUserByMobile(mobileNo);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserByMobile(mobileNo);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
        // 准备数据
        userTestBase.insertUser(0L, userId, platPartnerId, platPartnerId, mobileNo, null, null,
                null, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), null, null, "AUTONOMY_GENERALIZE", null, null,
                "false", "default", null, null);
        silverboltTestBase.insertGasUser(0L, userId, platPartnerId, mobileNo, null, null, null,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null, null,
                null, null, null, null,
                null, null, null, null, null,
                null, null);
        // 测试过程
        List<String> mobileNos = new ArrayList<String>();
        mobileNos.add(mobileNo);
        order.setMobileNos(mobileNos);
        // 调用接口
        BizResult<UserExportInfo> result = userGroupManageService.userImport(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
        userTestBase.cleanUserByMobile(mobileNo);
        userTestBase.cleanUserGroupByUserGroupNo(order.getUserGroupNo());
        silverboltTestBase.cleanGasUserByMobile(mobileNo);
        silverboltTestBase.cleanGasUserGroupByUserGroupNo(order.getUserGroupNo());
    }
}

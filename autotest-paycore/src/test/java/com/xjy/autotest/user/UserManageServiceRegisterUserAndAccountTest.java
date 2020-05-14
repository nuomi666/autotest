package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.adk.common.util.money.Money;
import com.xyb.user.api.enums.AccountType;
import com.xyb.user.api.enums.CertifyStatus;
import com.xyb.user.api.enums.UserStatus;
import com.xyb.user.api.info.user.UserInfo;
import com.xyb.user.api.info.user.UserResultInfo;
import dal.model.user.AccountDO;
import dal.model.user.UserDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.user.UserManageService;
import com.xyb.user.api.order.user.RegisterUserAndAccountOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：用户注册并注册账户
 * Created on 2018年06月12日.
 */
public class UserManageServiceRegisterUserAndAccountTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    UserManageService userManageService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001  必填参数，站内注册，个人用户，默认账户类型，注册成功
     * 1002  全填参数，站内注册，个人用户，未激活状态，身份证注册，标准账户，注册成功
     * 1003  全填参数，外部引入注册，个人用户，未激活状态，身份证注册，信用账户，注册成功
     * 1004  全填参数，站内注册，企业用户，未激活状态，身份证注册，结算账户，注册成功
     * 1005  全填参数，站内注册，个体户用户，未激活状态，身份证注册，中间过渡账户，注册成功
     * 1006  全填参数，站内注册，个人用户，正常状态，身份证注册，系统账户，注册成功
     * 1007  全填参数，站内注册，个人用户，冻结状态，身份证注册，保证金账户，注册成功
     * 1008  全填参数，站内注册，个人用户，注销状态，身份证注册，标准账户，注册成功
     * 1009  全填参数，站内注册，个人用户，正常状态，军官证注册，标准账户，注册成功
     */
    @AutoTest(file = "user/userManageServiceRegisterUserAndAccountTestSuccess.csv")
    @DisplayName("用户注册并注册账户--成功用例")
    public void userManageServiceRegisterUserAndAccountTestSuccess(
            // 基本参数
            int testId,
            // 业务参数
            RegisterUserAndAccountOrder registerUserAndAccountOrder,
            // 数据库参数
            // 父级会员信息
            UserDO userDO,
            //结果参数
            String code,
            String description,
            String message,
            String userId
    ) {
        // 清除数据
        userTestBase.cleanUserByUserName(registerUserAndAccountOrder.getUserName());
        userTestBase.cleanAccountByUserId(userId);
        userTestBase.cleanUserByUserId(userDO.getUserId());
        // 准备数据
        //userTestBase.insertUser(userDO);
        // 测试过程
        registerUserAndAccountOrder.setMerchantUserId(OID.newID());
        if (testId == 1001) {
            registerUserAndAccountOrder.setUserStatus(null);
            registerUserAndAccountOrder.setCertType(null);
            registerUserAndAccountOrder.setCertNo(null);
            registerUserAndAccountOrder.setRegisterIp(null);
            registerUserAndAccountOrder.setCountry(null);
            registerUserAndAccountOrder.setProvince(null);
            registerUserAndAccountOrder.setCity(null);
            registerUserAndAccountOrder.setDistrict(null);
            registerUserAndAccountOrder.setAddress(null);
            registerUserAndAccountOrder.setPhone(null);
            registerUserAndAccountOrder.setMobile(null);
            registerUserAndAccountOrder.setZipCode(null);
            registerUserAndAccountOrder.setMemo(null);

            //registerUserAndAccountOrder.setPartnerId(null);
            registerUserAndAccountOrder.setTag(null);
            registerUserAndAccountOrder.setAccountType(null);
        }
        // 调用接口
        BizResult<UserResultInfo> result = userManageService.registerUserAndAccount(registerUserAndAccountOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        assertEquals(description, result.getDescription());
        // 数据验证
        assertNotNull(result.getInfo().getAccountInfo().getAccountNo());
        if (testId == 1001) {
            assertEquals(AccountType.NORMAL, result.getInfo().getAccountInfo().getAccountType());
            assertNull(result.getInfo().getAccountInfo().getMemo());
            assertNotNull(result.getInfo().getAccountInfo().getTag());
        } else {
            assertEquals(registerUserAndAccountOrder.getAccountType(), result.getInfo().getAccountInfo().getAccountType());
            assertEquals(registerUserAndAccountOrder.getMemo(), result.getInfo().getAccountInfo().getMemo());
            assertEquals(registerUserAndAccountOrder.getTag(), result.getInfo().getAccountInfo().getTag());
        }
        assertEquals(new Money(0), result.getInfo().getAccountInfo().getBalance());
        assertEquals(new Money(0), result.getInfo().getAccountInfo().getFreezeBalance());
        assertEquals(new Money(0), result.getInfo().getAccountInfo().getHisInAmount());
        assertEquals(new Money(0), result.getInfo().getAccountInfo().getHisOutAmount());

        assertNotNull(result.getInfo().getAccountInfo().getRawAddTime());
        assertNull(result.getInfo().getAccountInfo().getRawUpdateTime());

        assertNotNull(result.getInfo().getAccountInfo().getUserId());

        assertNotNull(result.getInfo().getUserInfo().getUserId());
        //assertEquals(registerUserAndAccountOrder.getPayPassword(),result.getInfo().getUserInfo().getPayPassword());
        assertEquals(CertifyStatus.NOT_CERTIFIED, result.getInfo().getUserInfo().getCertifyStatus());
        assertEquals(registerUserAndAccountOrder.getUserName(), result.getInfo().getUserInfo().getUserName());
        assertEquals(registerUserAndAccountOrder.getRegisterFrom(), result.getInfo().getUserInfo().getRegisterFrom());
        assertEquals(registerUserAndAccountOrder.getUserType(), result.getInfo().getUserInfo().getUserType());
        if (testId == 1001) {
//            assertEquals(UserStatus.NORMAL, result.getInfo().getUserInfo().getUserStatus());
        } else {
            assertEquals(registerUserAndAccountOrder.getAddress(), result.getInfo().getUserInfo().getAddress());
            assertEquals(registerUserAndAccountOrder.getCertNo(), result.getInfo().getUserInfo().getCertNo());
            assertEquals(registerUserAndAccountOrder.getCertType(), result.getInfo().getUserInfo().getCertType());
            assertEquals(registerUserAndAccountOrder.getCity(), result.getInfo().getUserInfo().getCity());
            assertEquals(registerUserAndAccountOrder.getCountry(), result.getInfo().getUserInfo().getCountry());
            assertEquals(registerUserAndAccountOrder.getDistrict(), result.getInfo().getUserInfo().getDistrict());
            assertEquals(registerUserAndAccountOrder.getMemo(), result.getInfo().getUserInfo().getMemo());
            if (testId == 1004 || testId == 1005) {
                assertEquals(result.getInfo().getUserInfo().getUserId(), result.getInfo().getUserInfo().getPartnerId());
            } else {
                assertEquals(registerUserAndAccountOrder.getPartnerId(), result.getInfo().getUserInfo().getPartnerId());
                assertEquals(registerUserAndAccountOrder.getMerchantUserId(), result.getInfo().getUserInfo().getMerchantUserId());
            }
            assertEquals(registerUserAndAccountOrder.getMobile(), result.getInfo().getUserInfo().getMobile());
            assertEquals(registerUserAndAccountOrder.getPhone(), result.getInfo().getUserInfo().getPhone());
            assertEquals(registerUserAndAccountOrder.getProvince(), result.getInfo().getUserInfo().getProvince());
            assertEquals(registerUserAndAccountOrder.getRealName(), result.getInfo().getUserInfo().getRealName());
            assertEquals(registerUserAndAccountOrder.getRegisterIp(), result.getInfo().getUserInfo().getRegisterIp());
            assertEquals(registerUserAndAccountOrder.getUserStatus(), result.getInfo().getUserInfo().getUserStatus());
            assertEquals(registerUserAndAccountOrder.getZipCode(), result.getInfo().getUserInfo().getZipCode());
        }

        //数据库校验

        UserDO DO = userTestBase.findUserByUserName(registerUserAndAccountOrder.getUserName()).get(0);

        assertEquals(getUserPassword(DO.getUserId(), registerUserAndAccountOrder.getPayPassword()), DO.getPayPassword());
        assertNotNull(DO.getRawAddTime());
        assertNotNull(DO.getRawUpdateTime());
        assertNotNull(DO.getUserId());
        assertNull(DO.getCustomerId());
        assertNotNull(DO.getId());
        assertEquals(registerUserAndAccountOrder.getUserName(), DO.getUserName());
        assertEquals(registerUserAndAccountOrder.getRegisterFrom().toString(), DO.getRegisterFrom());
        assertEquals(registerUserAndAccountOrder.getUserType().toString(), DO.getUserType());
        assertEquals(CertifyStatus.NOT_CERTIFIED.toString(), DO.getCertifyStatus());
        assertEquals(registerUserAndAccountOrder.getParentUserId(), DO.getParentUserId());
        assertEquals(registerUserAndAccountOrder.getPlatPartnerId(), DO.getPlatPartnerId());
        if (testId == 1001) {
//            assertEquals(UserStatus.NORMAL.toString(), DO.getUserStatus());
        } else {
            assertEquals(registerUserAndAccountOrder.getAddress(), DO.getAddress());
            assertEquals(registerUserAndAccountOrder.getCertNo(), DO.getCertNo());
            assertEquals(registerUserAndAccountOrder.getCertType().toString(), DO.getCertType());
            assertEquals(registerUserAndAccountOrder.getCity(), DO.getCity());
            assertEquals(registerUserAndAccountOrder.getCountry(), DO.getCountry());
            assertEquals(registerUserAndAccountOrder.getDistrict(), DO.getDistrict());
            assertEquals(registerUserAndAccountOrder.getMemo(), DO.getMemo());
            if (testId == 1004 || testId == 1005) {
                assertEquals(DO.getUserId(), DO.getPartnerId());
            } else {
                assertEquals(registerUserAndAccountOrder.getMerchantUserId(), DO.getMerchantUserId());
                assertEquals(registerUserAndAccountOrder.getPartnerId(), DO.getPartnerId());
            }
            assertEquals(registerUserAndAccountOrder.getMobile(), DO.getMobile());
            assertEquals(registerUserAndAccountOrder.getPhone(), DO.getPhone());
            assertEquals(registerUserAndAccountOrder.getProvince(), DO.getProvince());
            assertEquals(registerUserAndAccountOrder.getRealName(), DO.getRealName());
            assertEquals(registerUserAndAccountOrder.getRegisterIp(), DO.getRegisterIp());
            assertEquals(registerUserAndAccountOrder.getUserStatus().toString(), DO.getUserStatus());
            assertEquals(registerUserAndAccountOrder.getZipCode(), DO.getZipCode());
        }
        userId = userTestBase.findUserByUserName(registerUserAndAccountOrder.getUserName()).get(0).getUserId();

        AccountDO DO1 = userTestBase.findAccountByUserId(userId).stream().filter(
                (acc) -> (!"POOL".equals(acc.getTag()))).collect(Collectors.toList()).get(0);
        assertEquals(new Long(0), DO1.getHisOutAmount());
        assertEquals(new Long(0), DO1.getHisInAmount());
        assertEquals(new Long(0), DO1.getBalance());
        if (testId == 1001) {
            assertEquals(AccountType.NORMAL.toString(), DO1.getAccountType());
            assertNull(DO1.getMemo());
            assertEquals(DO1.getAccountNo(), DO1.getTag());
        } else {
            assertEquals(registerUserAndAccountOrder.getAccountType().toString(), DO1.getAccountType());
            assertEquals(registerUserAndAccountOrder.getMemo(), DO1.getMemo());
            assertEquals(registerUserAndAccountOrder.getTag(), DO1.getTag());
        }
        assertNotNull(DO1.getAccountNo());
        assertEquals(new Long(0), DO1.getFreezeBalance());
        assertNotNull(DO1.getId());
        assertNotNull(DO1.getPayModel());
        assertNotNull(DO1.getRawAddTime());
        assertNotNull(DO1.getRawUpdateTime());

        //清除数据
        userTestBase.cleanUserByUserName(registerUserAndAccountOrder.getUserName());
        userTestBase.cleanAccountByUserId(userId);
        userTestBase.cleanUserByUserId(userDO.getUserId());

    }


    /**
     * 1001  order为空，提示order不能为空
     * 1002  gid为空，提示gid不能为空
     * 1005  userType为空，提示userType不能为空
     * 1006  gid长度为34，提示gid长度只能为35
     * 1007  gid长度为36，提示gid长度只能为35
     * 1009  userName长度为51，提示userName长度只能为1-50
     * 1010  payPassword长度为21，提示payPassword长度只能为1-20
     * 1011  realName长度为65，提示realName长度只能为0-64
     * 1012  certNo长度为65，提示certNo长度只能为0-64
     * 1013  registerIp长度为17，提示registerIp长度只能为0-16
     * 1014  country长度为57，提示country长度只能为0-56
     * 1015  province长度为65，提示province长度只能为0-64
     * 1016  city长度为129，提示city长度只能为0-128
     * 1017  district长度为129，提示district长度只能为0-128
     * 1018  address长度为257，提示address长度只能为0-257
     * 1019  phone长度为17，提示phone长度只能为0-16
     * 1020  mobile长度为17，提示mobile长度只能为8-16
     * 1021  zipCode长度为7，提示zipCode长度只能为0-6
     * 1022  memo长度为257，提示memo长度只能为0-256
     * 1023  partnerId长度为21，提示partnerId长度只能为20
     * 1024  merchantUserId长度为65，提示merchantUserId长度只能为0-64
     * 1025  parentUserId为空，提示parentUserId不能为空
     */
    @AutoTest(file = "user/userManageServiceRegisterUserAndAccountTestFailOne.csv")
    @DisplayName("用户注册并注册账户--失败用例一")
    public void userManageServiceRegisterUserAndAccountTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            RegisterUserAndAccountOrder registerUserAndAccountOrder,
            //结果参数
            String code,
            String description,
            String message,
            String userId
    ) {
        // 清除数据
        userTestBase.cleanUserByUserName(registerUserAndAccountOrder.getUserName());
        userTestBase.cleanAccountByUserId(userId);
        // 准备数据
        // 测试过程
        if (testId == 1001) {
            registerUserAndAccountOrder = null;
        }
        if (testId == 1002) {
            registerUserAndAccountOrder.setGid(null);
        }
        if (testId == 1003) {
            registerUserAndAccountOrder.setUserName(null);
        }
        if (testId == 1004) {
            registerUserAndAccountOrder.setRegisterFrom(null);
        }
        if (testId == 1005) {
            registerUserAndAccountOrder.setUserType(null);
        }
        if (testId == 1025) {
            registerUserAndAccountOrder.setParentUserId(null);
        }
        if (testId == 1028) {
            registerUserAndAccountOrder.setPayPassword(null);
        }
        // 调用接口
        BizResult<UserResultInfo> result = userManageService.registerUserAndAccount(registerUserAndAccountOrder);
        // 结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        //参数校验
        assertNull(result.getInfo());
        ArrayList list = new ArrayList();
        if (testId != 1001) {
            assertEquals(list, userTestBase.findUserByUserName(registerUserAndAccountOrder.getUserName()));
        }
        //清除数据
        if (testId != 1001) {
            userTestBase.cleanUserByUserName(registerUserAndAccountOrder.getUserName());
        }
        userTestBase.cleanAccountByUserId(userId);
    }

    /**
     * 1001  用户已经存在，注册失败
     * 1002  父级用户不存在，注册失败
     */
    @AutoTest(file = "user/userManageServiceRegisterUserAndAccountTestFailTwo.csv")
    @DisplayName("用户注册并注册账户--失败用例二")
    public void userManageServiceRegisterUserAndAccountTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            RegisterUserAndAccountOrder registerUserAndAccountOrder,
            //数据库参数
            UserDO userDO,
            UserDO userDO1,
            //结果参数
            String code,
            String description,
            String message
    ) {
        //清除数据
        userTestBase.cleanUserByUserName(userDO.getUserName());
        userTestBase.cleanAccountByUserId(userDO.getUserId());
        userTestBase.cleanUserByUserId(userDO1.getUserId());
        userTestBase.cleanUserByMerchantUserId(userDO.getMerchantUserId());
        userTestBase.cleanUserByMerchantUserId(userDO1.getMerchantUserId());
        //准备数据
        if (testId == 1001) {
            userTestBase.insertUser(userDO);
        }
        userTestBase.insertUser(userDO1);
        //测试过程
        //调用接口
        BizResult<UserInfo> result = userManageService.registerUser(registerUserAndAccountOrder);
        //结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        //参数校验
        assertNull(result.getInfo());

        if (testId == 1001) {
            UserDO DO = userTestBase.findUserByUserName(registerUserAndAccountOrder.getUserName()).get(0);

            assertNotNull(DO.getRawAddTime());
            assertNotNull(DO.getRawUpdateTime());
            assertNotNull(DO.getUserId());
            assertEquals(userDO.getCustomerId(), DO.getCustomerId());
            assertNotNull(DO.getId());
            assertEquals(userDO.getUserName(), DO.getUserName());
            assertEquals(userDO.getRegisterFrom(), DO.getRegisterFrom());
            assertEquals(userDO.getUserType(), DO.getUserType());
            assertEquals(userDO.getAddress(), DO.getAddress());
            assertEquals(userDO.getCertifyStatus(), DO.getCertifyStatus());
            assertEquals(userDO.getCertNo(), DO.getCertNo());
            assertEquals(userDO.getCertType(), DO.getCertType());
            assertEquals(userDO.getCity(), DO.getCity());
            assertEquals(userDO.getCountry(), DO.getCountry());
            assertEquals(userDO.getDistrict(), DO.getDistrict());
            assertEquals(userDO.getMemo(), DO.getMemo());
            assertEquals(userDO.getMerchantUserId(), DO.getMerchantUserId());
            assertEquals(userDO.getMobile(), DO.getMobile());
            assertEquals(userDO.getPartnerId(), DO.getPartnerId());
            assertEquals(userDO.getPhone(), DO.getPhone());
            assertEquals(userDO.getProvince(), DO.getProvince());
            assertEquals(userDO.getRealName(), DO.getRealName());
            assertEquals(userDO.getRegisterIp(), DO.getRegisterIp());
            assertEquals(userDO.getUserStatus(), DO.getUserStatus());
            assertEquals(userDO.getZipCode(), DO.getZipCode());
            assertEquals(userDO.getPayPassword(), DO.getPayPassword());
        }
        ArrayList list = new ArrayList();
        assertEquals(list, userTestBase.findAccountByUserId(userDO.getUserId()));
        //清除数据
        userTestBase.cleanAccountByUserId(userDO.getUserId());
        userTestBase.cleanUserByUserName(userDO.getUserName());
        userTestBase.cleanUserByUserId(userDO1.getUserId());
    }


}


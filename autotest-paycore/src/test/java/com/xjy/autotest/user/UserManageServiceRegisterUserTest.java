package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.enums.CertifyStatus;
import com.xyb.user.api.enums.UserStatus;
import com.xyb.user.api.info.user.UserInfo;
import dal.model.user.UserDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.user.UserManageService;
import com.xyb.user.api.order.user.RegisterUserOrder;
import org.springframework.beans.factory.annotation.Autowired;

import static com.xjy.autotest.utils.DateUtils.now;


/**
 * @author lvdou
 * 服务名：用户注册(不含默认资金账户)
 * Created on 2018年06月11日.
 */
public class UserManageServiceRegisterUserTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    UserManageService userManageService;

    @Autowired
    UserTestBase userTestBase;

    /**
     * 1001  必填参数，站内注册，个人用户，注册成功
     * 1002  全填参数，站内注册，个人用户，未激活状态，身份证注册，注册成功
     * 1003  全填参数，外部引入注册，个人用户，未激活状态，身份证注册，注册成功
     * 1004  全填参数，站内注册，企业用户，未激活状态，身份证注册，注册成功
     * 1005  全填参数，站内注册，个体户用户，未激活状态，身份证注册，注册成功
     * 1006  全填参数，站内注册，个人用户，正常状态，身份证注册，注册成功
     * 1007  全填参数，站内注册，个人用户，冻结状态，身份证注册，注册成功
     * 1008  全填参数，站内注册，个人用户，注销状态，身份证注册，注册成功
     * 1009  全填参数，站内注册，个人用户，正常状态，军官证注册，注册成功
     */
    @AutoTest(file = "user/userManageServiceRegisterUserTestSuccess.csv")
    @DisplayName("用户注册(不含默认资金账户)--成功用例")
    public void userManageServiceRegisterUserTestSuccess(
            // 基本参数
            int testId,

            // 业务参数
            RegisterUserOrder registerUserOrder,
            // 数据库参数
            // 父级会员
            UserDO userDO,
            // 结果参数
            String code,
            String message,
            String description,
            CertifyStatus certifyStatus
    ) {
        // 清除数据
        userTestBase.cleanUserByUserName(registerUserOrder.getUserName());
        userTestBase.cleanUserByUserId(userDO.getUserId());
        // 准备数据
        userTestBase.insertUser(userDO);
        // 测试过程
        if (testId == 1001) {
            registerUserOrder.setUserStatus(null);
            registerUserOrder.setCertType(null);
            registerUserOrder.setCertNo(null);
            registerUserOrder.setRegisterIp(null);
            registerUserOrder.setCountry(null);
            registerUserOrder.setProvince(null);
            registerUserOrder.setCity(null);
            registerUserOrder.setDistrict(null);
            registerUserOrder.setAddress(null);
            registerUserOrder.setPhone(null);
            registerUserOrder.setMobile(null);
            registerUserOrder.setZipCode(null);
            registerUserOrder.setMemo(null);
            //registerUserOrder.setPartnerId(null);
            //registerUserOrder.setMerchantUserId(null);
        }
        // 调用接口
        BizResult<UserInfo> result = userManageService.registerUser(registerUserOrder);
        // 结果验证
        assertResult(testId, Status.SUCCESS, code, result);
        assertEquals(description, result.getDescription());
        // 数据验证
        assertNotNull(result.getInfo().getUserId());
        assertEquals(certifyStatus, result.getInfo().getCertifyStatus());
        assertEquals(registerUserOrder.getUserName(), result.getInfo().getUserName());
        assertEquals(registerUserOrder.getRegisterFrom(), result.getInfo().getRegisterFrom());
        assertEquals(registerUserOrder.getUserType(), result.getInfo().getUserType());
        //assertEquals(registerUserOrder.getPayPassword(),result.getInfo().getPayPassword());
        // if (testId == 1001) {
        //     assertEquals(UserStatus.NORMAL, result.getInfo().getUserStatus());
        // }
        if (testId != 1001) {
            assertEquals(registerUserOrder.getAddress(), result.getInfo().getAddress());
            assertEquals(registerUserOrder.getCertNo(), result.getInfo().getCertNo());
            assertEquals(registerUserOrder.getCertType(), result.getInfo().getCertType());
            assertEquals(registerUserOrder.getCity(), result.getInfo().getCity());
            assertEquals(registerUserOrder.getCountry(), result.getInfo().getCountry());
            assertEquals(registerUserOrder.getDistrict(), result.getInfo().getDistrict());
            assertEquals(registerUserOrder.getMemo(), result.getInfo().getMemo());
            if (testId != 1004 && testId != 1005) {
                assertEquals(registerUserOrder.getMerchantUserId(), result.getInfo().getMerchantUserId());
                assertEquals(registerUserOrder.getPartnerId(), result.getInfo().getPartnerId());
            }
            assertEquals(registerUserOrder.getMobile(), result.getInfo().getMobile());
            assertEquals(registerUserOrder.getPhone(), result.getInfo().getPhone());
            assertEquals(registerUserOrder.getProvince(), result.getInfo().getProvince());
            assertEquals(registerUserOrder.getRealName(), result.getInfo().getRealName());
            assertEquals(registerUserOrder.getRegisterIp(), result.getInfo().getRegisterIp());
            assertEquals(registerUserOrder.getZipCode(), result.getInfo().getZipCode());
        }

        UserDO DO = userTestBase.findUserByUserName(registerUserOrder.getUserName()).get(0);

        assertNotNull(DO.getRawAddTime());
        assertNotNull(DO.getRawUpdateTime());
        assertNotNull(DO.getUserId());
        assertNull(DO.getCustomerId());
        assertNotNull(DO.getId());
        assertEquals(registerUserOrder.getUserName(), DO.getUserName());
        assertEquals(registerUserOrder.getRegisterFrom().code(), DO.getRegisterFrom());
        assertEquals(registerUserOrder.getUserType().code(), DO.getUserType());
        assertEquals(registerUserOrder.getParentUserId(), DO.getParentUserId());
        assertEquals(getUserPassword(DO.getUserId(), registerUserOrder.getPayPassword()), DO.getPayPassword());
        if (testId == 1001) {
            // assertEquals(UserStatus.NORMAL.code(), DO.getUserStatus());
        } else {
            assertEquals(registerUserOrder.getAddress(), DO.getAddress());
            assertEquals(certifyStatus.toString(), DO.getCertifyStatus());
            assertEquals(registerUserOrder.getCertNo(), DO.getCertNo());
            assertEquals(registerUserOrder.getCertType().code(), DO.getCertType());
            assertEquals(registerUserOrder.getCity(), DO.getCity());
            assertEquals(registerUserOrder.getCountry(), DO.getCountry());
            assertEquals(registerUserOrder.getDistrict(), DO.getDistrict());
            assertEquals(registerUserOrder.getMemo(), DO.getMemo());
            if (testId != 1005) {
                if(testId != 1004) {
                    assertEquals(registerUserOrder.getMerchantUserId(), DO.getMerchantUserId());
                    assertEquals(registerUserOrder.getPartnerId(), DO.getPartnerId());
                }
            } else {
                assertEquals(DO.getUserId(), result.getInfo().getPartnerId());
            }
            assertEquals(registerUserOrder.getMobile(), DO.getMobile());
            assertEquals(registerUserOrder.getPhone(), DO.getPhone());
            assertEquals(registerUserOrder.getProvince(), DO.getProvince());
            assertEquals(registerUserOrder.getRealName(), DO.getRealName());
            assertEquals(registerUserOrder.getRegisterIp(), DO.getRegisterIp());
            assertEquals(registerUserOrder.getUserStatus().code(), DO.getUserStatus());
            assertEquals(registerUserOrder.getZipCode(), DO.getZipCode());
        }
        //清除数据
        userTestBase.cleanUserByUserName(registerUserOrder.getUserName());
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
     * 1026  parentUserId长度为19，提示parentUserId长度只能为20
     * 1027  parentUserId长度为21，提示parentUserId长度只能为20
     */
    @AutoTest(file = "user/userManageServiceRegisterUserTestFailOne.csv")
    @DisplayName("用户注册(不含默认资金账户)--失败用例一")
    public void userManageServiceRegisterUserTestFailOne(
            // 基本参数
            int testId,
            // 业务参数
            RegisterUserOrder registerUserOrder,
            //结果参数
            String code,
            String description,
            String message) {
        //清除数据
        userTestBase.cleanUserByUserName(registerUserOrder.getUserName());
        //准备数据
        //测试过程
        if (testId == 1001) {
            registerUserOrder = null;
        }
        if (testId == 1002) {
            registerUserOrder.setGid(null);
        }
        if (testId == 1003) {
            registerUserOrder.setUserName(null);
        }
        if (testId == 1004) {
            registerUserOrder.setRegisterFrom(null);
        }
        if (testId == 1005) {
            registerUserOrder.setUserType(null);
        }
        if (testId == 1025) {
            registerUserOrder.setParentUserId(null);
        }
        if (testId == 1028) {
            registerUserOrder.setPayPassword(null);
        }
        //调用接口
        BizResult<UserInfo> result = userManageService.registerUser(registerUserOrder);
        //结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        //参数校验
        assertNull(result.getInfo());
        //清除数据
        if (testId != 1001) {
            userTestBase.cleanUserByUserName(registerUserOrder.getUserName());
        }
    }

    /**
     * 1001  用户已经存在
     * 1002  父级用户不存在
     */
    @AutoTest(file = "user/userManageServiceRegisterUserTestFailTwo.csv")
    @DisplayName("用户注册(不含默认资金账户)--失败用例二")
    public void userManageServiceRegisterUserTestFailTwo(
            // 基本参数
            int testId,
            // 业务参数
            RegisterUserOrder registerUserOrder,
            //数据库参数
            UserDO userDO,
            UserDO userDO1,
            //结果参数
            String code,
            String description,
            String message) {
        //清除数据
        userTestBase.cleanUserByUserName(registerUserOrder.getUserName());
        userTestBase.cleanUserByUserName(userDO1.getUserName());
        //准备数据
        if (testId == 1001) {
            userTestBase.insertUser(userDO);
        }
        userTestBase.insertUser(userDO1);
        //测试过程
        //调用接口
        BizResult<UserInfo> result = userManageService.registerUser(registerUserOrder);
        //结果验证
        assertResult(testId, Status.FAIL, code, result);
        assertEquals(description, result.getMessage());
        //参数校验
        assertNull(result.getInfo());

        if (testId == 1001) {
            UserDO DO = userTestBase.findUserByUserName(registerUserOrder.getUserName()).get(0);

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
        //清除数据
        userTestBase.cleanUserByUserName(registerUserOrder.getUserName());
        userTestBase.cleanUserByUserName(userDO1.getUserName());
    }
}

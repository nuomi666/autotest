package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.service.user.UserManageService;
import dal.model.user.UserDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.user.api.service.user.UserValidateService;
import com.xyb.user.api.order.user.ValidatePayPasswordOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：校验支付密码
 * Created on 2018/07/13.
 */
public class UserValidateServiceValidatePayPasswordTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
	UserValidateService userValidateService;

	@Autowired
	UserTestBase userTestBase;

	/**
	 * 1001 支付密码验证成功
	 */
	@AutoTest(file = "user/userValidateServiceValidatePayPasswordTestSuccess.csv")
	@DisplayName("校验支付密码--成功用例")
	public void userValidateServiceValidatePayPasswordTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			ValidatePayPasswordOrder validatePayPasswordOrder,
			// 数据库参数
			UserDO userDO,
			// 干扰参数
			UserDO userDO1,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
		userTestBase.cleanUserByUserId(userDO1.getUserId());
		// 准备数据
        userDO.setPayPassword(getUserPassword(userDO.getUserId(),userDO.getPayPassword()));
        userDO1.setPayPassword(getUserPassword(userDO1.getUserId(),userDO1.getPayPassword()));
		userTestBase.insertUser(userDO);
		userTestBase.insertUser(userDO1);
		// 测试过程
		// 调用接口
		StandardResultInfo result = userValidateService.validatePayPassword(validatePayPasswordOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
	}

	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 gid为空，提示gid不能为空
	 * 1003 userId为空，提示userId不能为空
	 * 1004 payPassword为空，提示payPassword不能为空
	 * 1005 gid长度为34，提示gid长度只能为35
	 * 1006 gid长度为36，提示gid长度只能为35
	 * 1007 userId长度为19，提示userId长度只能为20
	 * 1008 userId长度为21，提示userId长度只能为20
	 * 1009 payPassword长度为21，提示payPassword长度只能为1-20
	 */
	@AutoTest(file = "user/userValidateServiceValidatePayPasswordTestFailOne.csv")
	@DisplayName("校验支付密码--失败用例一")
	public void userValidateServiceValidatePayPasswordTestFailOne(
			// 基本参数
			int testId,
			ValidatePayPasswordOrder validatePayPasswordOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			validatePayPasswordOrder = null;
		}
		if(testId == 1002){
			validatePayPasswordOrder.setGid(null);
		}
		if (testId == 1003) {
			validatePayPasswordOrder.setUserId(null);
		}
		if(testId == 1004){
			validatePayPasswordOrder.setPayPassword(null);
		}
		// 调用接口
		StandardResultInfo result = userValidateService.validatePayPassword(validatePayPasswordOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		// 清除数据
	}

	/**
	 * 1001 用户不存在，验证支付密码失败
	 * 1002 支付密码错误，验证支付密码失败
	 */
	@AutoTest(file = "user/userValidateServiceValidatePayPasswordTestFailTwo.csv")
	@DisplayName("校验支付密码--失败用例二")
	public void userValidateServiceValidatePayPasswordTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			ValidatePayPasswordOrder validatePayPasswordOrder,
			// 数据库参数
			UserDO userDO,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
		// 准备数据
		userTestBase.insertUser(userDO);
		// 测试过程
		// 调用接口
		StandardResultInfo result = userValidateService.validatePayPassword(validatePayPasswordOrder);
		// 结果验证
		assertResult(testId, Status.FAIL, code, result);
		assertEquals(description, result.getMessage());
		// 参数校验
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
	}
}

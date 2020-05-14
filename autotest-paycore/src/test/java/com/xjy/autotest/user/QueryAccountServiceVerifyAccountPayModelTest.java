package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.user.api.service.account.QueryAccountService;
import com.xyb.user.api.order.account.VerifyAccountPayModelOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：判断账号是否支持支付模型
 * Created on 2018年06月19日.
 */
public class QueryAccountServiceVerifyAccountPayModelTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    QueryAccountService queryAccountService;

	@Autowired
	UserTestBase userTestBase;

	/**
	 * 1001 必填参数，账号支持支付模型，判断成功
	 * 1002 全填参数，账号支持支付模型，判断成功
	 */
	@AutoTest(file = "user/queryAccountServiceVerifyAccountPayModelTestSuccess.csv")
	@DisplayName("判断账号是否支持支付模型--成功用例")
	public void queryAccountServiceVerifyAccountPayModelTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			VerifyAccountPayModelOrder verifyAccountPayModelOrder,
			// 数据库参数
			AccountDO accountDO,
			// 干扰参数
			AccountDO accountDO1,
			// 结果参数
			String code,
			String description,
			String message
	) {
		// 清除数据
		userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
		userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
		// 准备数据
		userTestBase.insertAccount(accountDO);
		userTestBase.insertAccount(accountDO1);
		// 测试过程
		if(testId == 1001){
			verifyAccountPayModelOrder.setTag(null);
		}
		// 调用接口
		SimpleResult result = queryAccountService.verifyAccountPayModel(verifyAccountPayModelOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		// 清除数据
		userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
		userTestBase.cleanAccountByAccountNo(accountDO1.getAccountNo());
	}

	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 gid为空，提示gid不能为空
	 * 1003 payModel为空，提示payModel不能为空
	 * 1004 accountNo为空，提示单据错误:accountNo:资金账号和用户id+tag,必选一种方式传参
	 * 1005 gid长度为34，提示gid长度只能为35
	 * 1006 gid长度为36，提示gid长度只能为35
	 * 1007 accountNo长度为19，提示accountNo长度只能为20
	 * 1008 accountNo长度为21，提示accountNo长度只能为20
	 */
	@AutoTest(file = "user/queryAccountServiceVerifyAccountPayModelTestOne.csv")
	@DisplayName("判断账号是否支持支付模型--失败用例一")
	public void queryAccountServiceVerifyAccountPayModelTestOne(
			// 基本参数
			int testId,
			// 业务参数
			VerifyAccountPayModelOrder verifyAccountPayModelOrder,
			// 结果参数
			String code,
			String description,
			String message
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			verifyAccountPayModelOrder = null;
		}
		if(testId == 1002){
			verifyAccountPayModelOrder.setGid(null);
		}
		if(testId == 1003){
			verifyAccountPayModelOrder.setPayModel(null);
		}
		if(testId == 1004){
			verifyAccountPayModelOrder.setAccountNo(null);
		}
		// 调用接口
		SimpleResult result = queryAccountService.verifyAccountPayModel(verifyAccountPayModelOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
	}

	/**
	 * 1001 账号不支持支付模型，判断成功
	 * 1002 账号不存在
	 */
	@AutoTest(file = "user/queryAccountServiceVerifyAccountPayModelTestFailTwo.csv")
	@DisplayName("判断账号是否支持支付模型--失败用例二")
	public void queryAccountServiceVerifyAccountPayModelTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			VerifyAccountPayModelOrder verifyAccountPayModelOrder,
			// 数据库参数
			AccountDO accountDO,
			// 结果参数
			String code,
			String description,
			String message
	){
		// 清除数据
		userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
		// 准备数据
		userTestBase.insertAccount(accountDO);
		// 测试过程
		// 调用接口
		SimpleResult result = queryAccountService.verifyAccountPayModel(verifyAccountPayModelOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		// 清除数据
		userTestBase.cleanAccountByAccountNo(accountDO.getAccountNo());
	}
}

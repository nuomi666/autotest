package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.user.UserBankCardDO;
import dal.model.user.UserDO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.SimpleResult;
import com.xyb.user.api.service.user.BankCardService;
import com.xyb.user.api.order.user.RemoveBankCardOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：移除银行卡
 * Created on 2018年06月13日.
 */
@Disabled
public class BankCardServiceRemoveBankCardTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    BankCardService bankCardService;

	@Autowired
	UserTestBase userTestBase;
	/**
	 * 1001  同一用户下两张银行卡，移除其中一张，移除成功
	 * 1002  不同用户下各有一张银行卡，移除其中一张，移除成功
	 */
	@AutoTest(file = "user/bankCardServiceRemoveBankCardTestSuccess.csv")
	@DisplayName("移除银行卡--成功用例")
	public void bankCardServiceRemoveBankCardTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			RemoveBankCardOrder removeBankCardOrder,
			// 数据库参数
			UserDO userDO,
			UserBankCardDO userBankCardDO,
			// 干扰参数
			UserDO userDO1,
			UserBankCardDO userBankCardDO1,
			// 结果参数
			String code,
			String description,
			String message
	) {
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
		userTestBase.cleanUserByUserId(userDO1.getUserId());
		userTestBase.cleanUserBankCardByUserId(userDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(userDO1.getUserId());
		// 准备数据
		userTestBase.insertUser(userDO);
		userTestBase.insertUserBankCard(userBankCardDO);
		userTestBase.insertUserBankCard(userBankCardDO1);
		if(testId == 1002){
			userTestBase.insertUser(userDO1);
		}
		// 测试过程
		// 调用接口
		SimpleResult result = bankCardService.removeBankCard(removeBankCardOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		ArrayList list = new ArrayList();
		assertEquals(list,userTestBase.findUserBankCardByBankCardNo(removeBankCardOrder.getBankCardNo()));
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
		userTestBase.cleanUserByUserId(userDO1.getUserId());
		userTestBase.cleanUserBankCardByUserId(userDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(userDO1.getUserId());
	}

	/**
	 * 1001  order为空，提示order不能为空
	 * 1002  gid为空，提示gid不能为空
	 * 1003  userId为空，提示userId不能为空
	 * 1004  bankCardNo为空，提示bankCardNo不能为空
	 * 1005  gid长度为34，提示gid长度只能为35
	 * 1006  gid长度为36，提示gid长度只能为35
	 * 1007  userId长度为19，提示userId长度只能为20
	 * 1008  userId长度为21，提示userId长度只能为20
	 */
	@AutoTest(file = "user/bankCardServiceRemoveBankCardTestFailOne.csv")
	@DisplayName("移除银行卡--成功用例")
	public void bankCardServiceRemoveBankCardTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			RemoveBankCardOrder removeBankCardOrder,
			// 结果参数
			String code,
			String description,
			String message
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			removeBankCardOrder = null;
		}
		if(testId == 1002){
			removeBankCardOrder.setGid(null);
		}
		if(testId == 1003){
			removeBankCardOrder.setUserId(null);
		}
		if(testId == 1004){
			removeBankCardOrder.setBankCardNo(null);
		}
		// 调用接口
		SimpleResult result = bankCardService.removeBankCard(removeBankCardOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 数据验证
		// 清除数据
	}

	/**
	 * 1001  用户不存在，移除银行卡失败
	 * 1002  用户下绑定的银行卡不存在，移除银行卡失败
	 * 1003  用户状态不正确，移除银行卡失败
	 */
	@AutoTest(file = "user/bankCardServiceRemoveBankCardTestFailTwo.csv")
	@DisplayName("移除银行卡--失败用例二")
	public void bankCardServiceRemoveBankCardTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			RemoveBankCardOrder removeBankCardOrder,
			// 数据库参数
			UserDO userDO,
			UserBankCardDO userBankCardDO,
			// 结果参数
			String code,
			String description,
			String message
	){
		// 清除数据

		userTestBase.cleanUserByUserId(userDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(userBankCardDO.getUserId());
		// 准备数据
		if(testId == 1002){
			userTestBase.insertUser(userDO);
		}
		if(testId == 1003){
			userTestBase.insertUser(userDO);
			userTestBase.insertUserBankCard(userBankCardDO);
		}
		// 测试过程
		// 调用接口
		SimpleResult result = bankCardService.removeBankCard(removeBankCardOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(userBankCardDO.getUserId());
	}

}

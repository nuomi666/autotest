package com.xjy.autotest.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.StandardResultInfo;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.order.account.BandAccountOrder;
import com.xyb.user.api.service.account.AccountManageService;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：账户绑定其他账户
 * Created on 2018/07/11.
 */
public class AccountManageServiceBandAccountNoTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
	AccountManageService accountManageService;

	@Autowired
	UserTestBase userTestBase;

	/**
	 * 1001 未绑定账户的账户，绑定成功
	 */
	@AutoTest(file = "user/accountManageServiceBandAccountNoTestSuccess.csv")
	@DisplayName("账户绑定其他账户--成功用例")
	public void accountManageServiceBandAccountNoTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BandAccountOrder bandAccountOrder,
			// 数据库参数
			// 被绑账号参数
			AccountDO accountDO,
			// 绑定账号参数
			AccountDO accountDO1,
			// 干扰参数
			AccountDO accountDO2,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
		userTestBase.cleanAccountByUserId(accountDO1.getUserId());
		userTestBase.cleanAccountByUserId(accountDO2.getUserId());
		// 准备数据
		userTestBase.insertAccount(accountDO);
		userTestBase.insertAccount(accountDO1);
		userTestBase.insertAccount(accountDO2);
		// 测试过程
		// 调用接口
		StandardResultInfo result = accountManageService.bandAccountNo(bandAccountOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		AccountDO DO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);

		assertEquals(accountDO.getFreezeBalance(),DO.getFreezeBalance());
		assertEquals(accountDO.getTag(),DO.getTag());
		assertNotNull(accountDO.getRawUpdateTime());
		assertEquals(accountDO.getUserId(),DO.getUserId());
		assertEquals(accountDO.getHisOutAmount(),DO.getHisOutAmount());
		assertEquals(accountDO.getHisInAmount(),DO.getHisInAmount());
		assertEquals(accountDO.getAccountType(),DO.getAccountType());
		assertEquals(accountDO.getAccountNo(),DO.getAccountNo());
		assertEquals(accountDO.getId(),DO.getId());
		assertEquals(accountDO.getMemo(),DO.getMemo());
		assertEquals(accountDO.getRawAddTime(),DO.getRawAddTime());
		assertEquals(accountDO.getPayModel(),DO.getPayModel());
		assertEquals(accountDO.getBalance(),DO.getBalance());
		assertEquals(accountDO.getStatus(),DO.getStatus());
		assertEquals(bandAccountOrder.getBandAccountNo(),DO.getBandAccountNo());

		AccountDO DO1 = userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0);

		assertEquals(accountDO1.getFreezeBalance(),DO1.getFreezeBalance());
		assertEquals(accountDO1.getTag(),DO1.getTag());
		assertNotNull(accountDO1.getRawUpdateTime());
		assertEquals(accountDO1.getUserId(),DO1.getUserId());
		assertEquals(accountDO1.getHisOutAmount(),DO1.getHisOutAmount());
		assertEquals(accountDO1.getHisInAmount(),DO1.getHisInAmount());
		assertEquals(accountDO1.getAccountType(),DO1.getAccountType());
		assertEquals(accountDO1.getAccountNo(),DO1.getAccountNo());
		assertEquals(accountDO1.getId(),DO1.getId());
		assertEquals(accountDO1.getMemo(),DO1.getMemo());
		assertEquals(accountDO1.getRawAddTime(),DO1.getRawAddTime());
		assertEquals(accountDO1.getPayModel(),DO1.getPayModel());
		assertEquals(accountDO1.getBalance(),DO1.getBalance());
		assertEquals(accountDO1.getStatus(),DO1.getStatus());
		assertEquals(accountDO1.getBandAccountNo(),DO1.getBandAccountNo());

		AccountDO DO2 = userTestBase.findAccountByAccountNo(accountDO2.getAccountNo()).get(0);

		assertEquals(accountDO2.getFreezeBalance(),DO2.getFreezeBalance());
		assertEquals(accountDO2.getTag(),DO2.getTag());
		assertNotNull(accountDO2.getRawUpdateTime());
		assertEquals(accountDO2.getUserId(),DO2.getUserId());
		assertEquals(accountDO2.getHisOutAmount(),DO2.getHisOutAmount());
		assertEquals(accountDO2.getHisInAmount(),DO2.getHisInAmount());
		assertEquals(accountDO2.getAccountType(),DO2.getAccountType());
		assertEquals(accountDO2.getAccountNo(),DO2.getAccountNo());
		assertEquals(accountDO2.getId(),DO2.getId());
		assertEquals(accountDO2.getMemo(),DO2.getMemo());
		assertEquals(accountDO2.getRawAddTime(),DO2.getRawAddTime());
		assertEquals(accountDO2.getPayModel(),DO2.getPayModel());
		assertEquals(accountDO2.getBalance(),DO2.getBalance());
		assertEquals(accountDO2.getStatus(),DO2.getStatus());
		assertEquals(accountDO2.getBandAccountNo(),DO2.getBandAccountNo());

		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
		userTestBase.cleanAccountByUserId(accountDO1.getUserId());
		userTestBase.cleanAccountByUserId(accountDO2.getUserId());
	}


	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 gid为空，提示gid不能为空
	 * 1003 accountNo为空，提示accountNo不能为空
	 * 1004 bandAccountNo为空，提示bandAccountNo不能为空
	 * 1005 gid长度为34，提示gid长度只能为35
	 * 1006 gid长度为36，提示gid长度只能为35
	 * 1007 accountNo长度为19，提示accountNo长度只能为20
	 * 1008 accountNo长度为21，提示accountNo长度只能为20
	 * 1009 bandAccountNo长度为19，提示bandAccountNo长度只能为20
	 * 1010 bandAccountNo长度为21，提示bandAccountNo长度只能为20
	 */
	@AutoTest(file = "user/accountManageServiceBandAccountNoTestFailOne.csv")
	@DisplayName("账户绑定其他账户--失败用例一")
	public void accountManageServiceBandAccountNoTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			BandAccountOrder bandAccountOrder,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			bandAccountOrder = null;
		}
		if(testId == 1002){
			bandAccountOrder.setGid(null);
		}
		if(testId == 1003){
			bandAccountOrder.setAccountNo(null);
		}
		if(testId == 1004){
			bandAccountOrder.setBandAccountNo(null);
		}
		// 调用接口
		StandardResultInfo result = accountManageService.bandAccountNo(bandAccountOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		// 清除数据
	}


	/**
	 * 1001 绑定账户不存在，绑定失败
	 * 1002 被绑账户不存在，绑定失败
	 * 1003 账户已经绑定，绑定失败
	 * 1004 账户绑定账户为自己，绑定失败
	 * 1005 绑定账户状态为冻结，绑定失败
	 * 1006 被绑账户状态为冻结，绑定失败
	 */
	@AutoTest(file = "user/accountManageServiceBandAccountNoTestFailTwo.csv")
	@DisplayName("账户绑定其他账户--失败用例二")
	public void accountManageServiceBandAccountNoTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			BandAccountOrder bandAccountOrder,
			// 数据库参数
			// 被绑账号参数
			AccountDO accountDO,
			// 绑定账号参数
			AccountDO accountDO1,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
		userTestBase.cleanAccountByUserId(accountDO1.getUserId());
		// 准备数据
		userTestBase.insertAccount(accountDO);
		userTestBase.insertAccount(accountDO1);
		// 测试过程
		// 调用接口
		StandardResultInfo result = accountManageService.bandAccountNo(bandAccountOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		AccountDO DO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);

		assertEquals(accountDO.getFreezeBalance(),DO.getFreezeBalance());
		assertEquals(accountDO.getTag(),DO.getTag());
		assertNotNull(accountDO.getRawUpdateTime());
		assertEquals(accountDO.getUserId(),DO.getUserId());
		assertEquals(accountDO.getHisOutAmount(),DO.getHisOutAmount());
		assertEquals(accountDO.getHisInAmount(),DO.getHisInAmount());
		assertEquals(accountDO.getAccountType(),DO.getAccountType());
		assertEquals(accountDO.getAccountNo(),DO.getAccountNo());
		assertEquals(accountDO.getId(),DO.getId());
		assertEquals(accountDO.getMemo(),DO.getMemo());
		assertEquals(accountDO.getRawAddTime(),DO.getRawAddTime());
		assertEquals(accountDO.getPayModel(),DO.getPayModel());
		assertEquals(accountDO.getBalance(),DO.getBalance());
		assertEquals(accountDO.getStatus(),DO.getStatus());
		assertEquals(accountDO.getBandAccountNo(),DO.getBandAccountNo());

		AccountDO DO1 = userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0);

		assertEquals(accountDO1.getFreezeBalance(),DO1.getFreezeBalance());
		assertEquals(accountDO1.getTag(),DO1.getTag());
		assertNotNull(accountDO1.getRawUpdateTime());
		assertEquals(accountDO1.getUserId(),DO1.getUserId());
		assertEquals(accountDO1.getHisOutAmount(),DO1.getHisOutAmount());
		assertEquals(accountDO1.getHisInAmount(),DO1.getHisInAmount());
		assertEquals(accountDO1.getAccountType(),DO1.getAccountType());
		assertEquals(accountDO1.getAccountNo(),DO1.getAccountNo());
		assertEquals(accountDO1.getId(),DO1.getId());
		assertEquals(accountDO1.getMemo(),DO1.getMemo());
		assertEquals(accountDO1.getRawAddTime(),DO1.getRawAddTime());
		assertEquals(accountDO1.getPayModel(),DO1.getPayModel());
		assertEquals(accountDO1.getBalance(),DO1.getBalance());
		assertEquals(accountDO1.getStatus(),DO1.getStatus());
		assertEquals(accountDO1.getBandAccountNo(),DO1.getBandAccountNo());

		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
		userTestBase.cleanAccountByUserId(accountDO1.getUserId());
	}
}

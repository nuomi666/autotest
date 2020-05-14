package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.enums.AccountStatus;
import com.xyb.user.api.info.account.AccountInfo;
import dal.model.user.AccountDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.account.AccountManageService;
import com.xyb.user.api.order.account.ModifyAccountStatusOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：修改账户状态
 * Created on 2018年06月15日.
 */
public class AccountManageServiceModifyAccountStatusTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    AccountManageService accountManageService;

	@Autowired
	UserTestBase userTestBase;
	/**
	 * 1001  必填参数，账户由激活变更为冻结，修改成功
	 * 1002  全填参数，账户由冻结变更为激活，修改成功
	 * 1003  全填参数，账户由激活变更为激活，修改成功
	 * 1004  全填参数，账户由冻结变更为冻结，修改成功
	 */
	@AutoTest(file = "user/accountManageServiceModifyAccountStatusTestSuccess.csv")
	@DisplayName("修改账户状态--成功用例")
	public void accountManageServiceModifyAccountStatusTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			ModifyAccountStatusOrder modifyAccountStatusOrder,
			// 数据库参数
			AccountDO accountDO,
			// 干扰数据
			AccountDO accountDO1,
			// 结果参数
			String code,
			String description,
			String message
	) {
		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
		userTestBase.cleanAccountByUserId(accountDO1.getUserId());
		// 准备数据
		userTestBase.insertAccount(accountDO);
		userTestBase.insertAccount(accountDO1);
		// 测试过程
		if(testId == 1001){
			modifyAccountStatusOrder.setTag(null);
		}
		// 调用接口
		BizResult<AccountInfo> result = accountManageService.modifyAccountStatus(modifyAccountStatusOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		if(testId != 1001) {
			assertEquals(modifyAccountStatusOrder.getTag(), result.getInfo().getTag());
		}
		assertEquals(accountDO.getMemo(),result.getInfo().getMemo());
		assertEquals(modifyAccountStatusOrder.getAccountStatus(),result.getInfo().getStatus());
		assertNotNull(result.getInfo().getRawUpdateTime());
		assertEquals(accountDO.getHisOutAmount(),result.getInfo().getHisOutAmount().getCent());
		assertEquals(accountDO.getHisInAmount(),result.getInfo().getHisInAmount().getCent());
		assertEquals(accountDO.getFreezeBalance(),result.getInfo().getFreezeBalance().getCent());
		assertEquals(accountDO.getAccountNo(),result.getInfo().getAccountNo());
		assertEquals(accountDO.getAccountType(),result.getInfo().getAccountType().toString());
		assertEquals(accountDO.getBalance(),result.getInfo().getBalance().getCent());
		assertNotNull(result.getInfo().getRawAddTime());
		assertEquals(accountDO.getUserId(),result.getInfo().getUserId());
		assertEquals(accountDO.getBandAccountNo(),result.getInfo().getBandAccountNo());

		AccountDO DO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);

		assertEquals(modifyAccountStatusOrder.getAccountStatus().toString(),DO.getStatus());
		assertNotNull(DO.getRawAddTime());
		assertEquals(accountDO.getPayModel(),DO.getPayModel());
		assertEquals(accountDO.getMemo(),DO.getMemo());
		assertNotNull(DO.getId());
		assertEquals(accountDO.getAccountNo(),DO.getAccountNo());
		assertEquals(accountDO.getBalance(),DO.getBalance());
		assertEquals(accountDO.getAccountType(),DO.getAccountType());
		assertEquals(accountDO.getHisInAmount(),DO.getHisInAmount());
		assertEquals(accountDO.getHisOutAmount(),DO.getHisOutAmount());
		assertEquals(accountDO.getUserId(),DO.getUserId());
		assertEquals(accountDO.getFreezeBalance(),DO.getFreezeBalance());
		assertNotNull(DO.getRawUpdateTime());
		assertEquals(accountDO.getTag(),DO.getTag());
		assertEquals(accountDO.getBandAccountNo(),DO.getBandAccountNo());
		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
		userTestBase.cleanAccountByUserId(accountDO1.getUserId());
	}


	/**
	 * 1001  order为空，提示order不能为空
	 * 1002  gid为空，提示gid不能为空
	 * 1003  accountStatus为空，提示accountStatus不能为空
	 * 1004  accountNo为空，提示accountNo不能为空
	 * 1005  gid长度为34，提示gid长度只能为35
	 * 1006  gid长度为36，提示gid长度只能为35
	 * 1007  accountNo长度为19，提示accountNo长度只能为20
	 * 1008  accountNo长度为21，提示accountNo长度只能为20
	 */
	@AutoTest(file = "user/accountManageServiceModifyAccountStatusTestFailOne.csv")
	@DisplayName("修改账户状态--失败用例一")
	public void accountManageServiceModifyAccountStatusTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			ModifyAccountStatusOrder modifyAccountStatusOrder,
			// 结果参数
			String code,
			String description,
			String message
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			modifyAccountStatusOrder = null;
		}
		if(testId == 1002){
			modifyAccountStatusOrder.setGid(null);
		}
		if(testId == 1003){
			modifyAccountStatusOrder.setAccountStatus(null);
		}
		if(testId == 1004){
			modifyAccountStatusOrder.setAccountNo(null);
		}
		// 调用接口
		BizResult<AccountInfo> result = accountManageService.modifyAccountStatus(modifyAccountStatusOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getInfo());
		// 清除数据
	}

	/**
	 * 1001  账户不存在，修改账户状态成功
	 */
	@AutoTest(file = "user/accountManageServiceModifyAccountStatusTestFailTwo.csv")
	@DisplayName("修改账户状态--失败用例二")
	public void accountManageServiceModifyAccountStatusTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			ModifyAccountStatusOrder modifyAccountStatusOrder,
			// 数据库参数
			AccountDO accountDO,
			// 结果参数
			String code,
			String description,
			String message
	){
		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
		// 准备数据
		userTestBase.insertAccount(accountDO);
		// 测试过程
		// 调用接口
		BizResult<AccountInfo> result = accountManageService.modifyAccountStatus(modifyAccountStatusOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getInfo());
		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
	}
}

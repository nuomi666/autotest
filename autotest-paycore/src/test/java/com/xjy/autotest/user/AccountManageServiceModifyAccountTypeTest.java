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
import com.xyb.user.api.order.account.ModifyAccountTypeOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：修改账户类型
 * Created on 2018年06月14日.
 */
public class AccountManageServiceModifyAccountTypeTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    AccountManageService accountManageService;

	@Autowired
	UserTestBase userTestBase;
	/**
	 * 1001  必填参数，修改账户类型为标准账户，修改成功
	 * 1002  全填参数，修改账户类型为信用账户，修改成功
	 * 1003  全填参数，修改账户类型为结算账户，修改成功
	 * 1004  全填参数，修改账户类型为中间过渡账户，修改成功
	 * 1005  全填参数，修改账户类型为系统账户，修改成功
	 * 1006  全填参数，修改账户类型为保证金账户，修改成功
	 * 1007  全填参数，不修改账户类型
	 */
	@AutoTest(file = "user/accountManageServiceModifyAccountTypeTestSuccess.csv")
	@DisplayName("修改账户类型--成功用例")
	public void accountManageServiceModifyAccountTypeTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			ModifyAccountTypeOrder modifyAccountTypeOrder,
			// 数据库参数
			AccountDO accountDO,
			// 干扰参数
			AccountDO accountDO1,
			//结果参数
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
			modifyAccountTypeOrder.setTag(null);
		}
		// 调用接口
		BizResult<AccountInfo> result = accountManageService.modifyAccountType(modifyAccountTypeOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		assertEquals(accountDO.getUserId(),result.getInfo().getUserId());
		assertEquals(accountDO.getRawAddTime(),result.getInfo().getRawAddTime());
		assertEquals(accountDO.getBalance(),result.getInfo().getBalance().getCent());
		assertEquals(modifyAccountTypeOrder.getAccountType(),result.getInfo().getAccountType());
		assertEquals(accountDO.getAccountNo(),result.getInfo().getAccountNo());
		assertEquals(accountDO.getFreezeBalance(),result.getInfo().getFreezeBalance().getCent());
		assertEquals(accountDO.getHisInAmount(),result.getInfo().getHisInAmount().getCent());
		assertEquals(accountDO.getHisOutAmount(),result.getInfo().getHisOutAmount().getCent());
		assertNotNull(result.getInfo().getRawUpdateTime());
		assertEquals(AccountStatus.ACTIVE,result.getInfo().getStatus());
		assertEquals(accountDO.getMemo(),result.getInfo().getMemo());
		assertEquals(accountDO.getBandAccountNo(),result.getInfo().getBandAccountNo());
		if(testId != 1001) {
			assertEquals(modifyAccountTypeOrder.getTag(),result.getInfo().getTag());
		}

		AccountDO DO = userTestBase.findAccountByAccountNo(modifyAccountTypeOrder.getAccountNo()).get(0);

		assertEquals(accountDO.getTag(),DO.getTag());
		assertNotNull(DO.getRawUpdateTime());
		assertEquals(accountDO.getFreezeBalance(),DO.getFreezeBalance());
		assertEquals(accountDO.getUserId(),DO.getUserId());
		assertEquals(accountDO.getHisOutAmount(),DO.getHisOutAmount());
		assertEquals(accountDO.getHisInAmount(),DO.getHisInAmount());
		assertEquals(modifyAccountTypeOrder.getAccountType().toString(),DO.getAccountType());
		assertEquals(accountDO.getBalance(),DO.getBalance());
		assertEquals(accountDO.getAccountNo(),DO.getAccountNo());
		assertEquals(accountDO.getId(),DO.getId());
		assertEquals(accountDO.getMemo(),DO.getMemo());
		assertEquals(accountDO.getPayModel(),DO.getPayModel());
		assertEquals(accountDO.getRawAddTime(),DO.getRawAddTime());
		assertEquals(AccountStatus.ACTIVE.toString(),DO.getStatus());
		assertEquals(accountDO.getBandAccountNo(),DO.getBandAccountNo());

		AccountDO DO1 = userTestBase.findAccountByAccountNo(accountDO1.getAccountNo()).get(0);

		assertEquals(accountDO1.getTag(),DO1.getTag());
		assertEquals(accountDO1.getRawUpdateTime(),DO1.getRawUpdateTime());
		assertEquals(accountDO1.getFreezeBalance(),DO1.getFreezeBalance());
		assertEquals(accountDO1.getUserId(),DO1.getUserId());
		assertEquals(accountDO1.getHisOutAmount(),DO1.getHisOutAmount());
		assertEquals(accountDO1.getHisInAmount(),DO1.getHisInAmount());
		assertEquals(accountDO1.getAccountType(),DO1.getAccountType());
		assertEquals(accountDO1.getBalance(),DO1.getBalance());
		assertEquals(accountDO1.getAccountNo(),DO1.getAccountNo());
		assertEquals(accountDO1.getId(),DO1.getId());
		assertEquals(accountDO1.getMemo(),DO1.getMemo());
		assertEquals(accountDO1.getPayModel(),DO1.getPayModel());
		assertEquals(accountDO1.getRawAddTime(),DO1.getRawAddTime());
		assertEquals(accountDO1.getStatus(),DO1.getStatus());
		assertEquals(accountDO1.getBandAccountNo(),DO1.getBandAccountNo());

		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
		userTestBase.cleanAccountByUserId(accountDO1.getUserId());
	}


	/**
	 * 1001  order为空，提示order不能为空
	 * 1002  gid为空，提示gid不能为空
	 * 1003  accountType为空，提示accountType不能为空
	 * 1004  accountNo为空，提示accountNo不能为空
	 * 1005  gid长度为34，提示gid长度只能为35
	 * 1006  gid长度为36，提示gid长度只能为35
	 * 1007  accountNo长度为19，提示accountNo长度只能为20
	 * 1008  accountNo长度为21，提示accountNo长度只能为20
	 */
	@AutoTest(file = "user/accountManageServiceModifyAccountTypeTestFailOne.csv")
	@DisplayName("修改账户类型--失败用例一")
	public void accountManageServiceModifyAccountTypeTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			ModifyAccountTypeOrder modifyAccountTypeOrder,
			// 结果参数
			String code,
			String description,
			String message
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			modifyAccountTypeOrder = null;
		}
		if(testId == 1002){
			modifyAccountTypeOrder.setGid(null);
		}
		if(testId == 1003){
			modifyAccountTypeOrder.setAccountType(null);
		}
		if(testId == 1004){
			modifyAccountTypeOrder.setAccountNo(null);
		}
		// 调用接口
		BizResult<AccountInfo> result = accountManageService.modifyAccountType(modifyAccountTypeOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getInfo());
		// 清除数据
	}

	/**
	 * 1001  账户不存在，修改失败
	 */
	@AutoTest(file = "user/accountManageServiceModifyAccountTypeTestFailTwo.csv")
	@DisplayName("修改账户类型--失败用例二")
	public void accountManageServiceModifyAccountTypeTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			ModifyAccountTypeOrder modifyAccountTypeOrder,
			// 数据库参数
			AccountDO accountDO,
			//结果参数
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
		BizResult<AccountInfo> result = accountManageService.modifyAccountType(modifyAccountTypeOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getInfo());

		AccountDO DO = userTestBase.findAccountByAccountNo(accountDO.getAccountNo()).get(0);

		assertEquals(accountDO.getTag(),DO.getTag());
		assertNotNull(DO.getRawUpdateTime());
		assertEquals(accountDO.getFreezeBalance(),DO.getFreezeBalance());
		assertEquals(accountDO.getUserId(),DO.getUserId());
		assertEquals(accountDO.getHisOutAmount(),DO.getHisOutAmount());
		assertEquals(accountDO.getHisInAmount(),DO.getHisInAmount());
		assertEquals(accountDO.getAccountType(),DO.getAccountType());
		assertEquals(accountDO.getBalance(),DO.getBalance());
		assertEquals(accountDO.getAccountNo(),DO.getAccountNo());
		assertEquals(accountDO.getId(),DO.getId());
		assertEquals(accountDO.getMemo(),DO.getMemo());
		assertEquals(accountDO.getPayModel(),DO.getPayModel());
		assertEquals(accountDO.getRawAddTime(),DO.getRawAddTime());
		assertEquals(AccountStatus.ACTIVE.toString(),DO.getStatus());
		assertEquals(accountDO.getBandAccountNo(),DO.getBandAccountNo());

		// 清除数据
		userTestBase.cleanAccountByUserId(accountDO.getUserId());
	}
}

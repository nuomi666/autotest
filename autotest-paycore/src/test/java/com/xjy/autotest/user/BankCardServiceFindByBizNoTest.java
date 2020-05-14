package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.user.BankCardInfo;
import dal.model.user.UserBankCardDO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.user.BankCardService;
import com.xyb.user.api.order.user.FindBankByBizNoOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：根据绑卡流水查询银行卡信息
 * Created on 2018年06月14日.
 */
@Disabled
public class BankCardServiceFindByBizNoTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    BankCardService bankCardService;

	@Autowired
	UserTestBase userTestBase;
	/**
	 * 1001  绑卡流水记录存在，查询银行卡信息成功
	 */
	@AutoTest(file = "user/bankCardServiceFindByBizNoTestSuccess.csv")
	@DisplayName("根据绑卡流水查询银行卡信息--成功用例")
	public void bankCardServiceFindByBizNoTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			FindBankByBizNoOrder findBankByBizNoOrder,
			// 数据库参数
			UserBankCardDO userBankCardDO,
			// 干扰数据
			UserBankCardDO userBankCardDO1,
			// 结果参数
			String code,
			String description,
			String message
	) {
		// 清除数据
		userTestBase.cleanUserBankCardByUserId(userBankCardDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(userBankCardDO1.getUserId());
		// 准备数据
		userTestBase.insertUserBankCard(userBankCardDO);
		// 干扰数据
		userTestBase.insertUserBankCard(userBankCardDO1);
		// 测试过程
		// 调用接口
		BizResult<BankCardInfo> result = bankCardService.findByBizNo(findBankByBizNoOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		assertEquals(userBankCardDO.getUserId(),result.getInfo().getUserId());
		assertEquals(userBankCardDO.getProvince(),result.getInfo().getProvince());
		assertEquals(userBankCardDO.getDefaultBind(),result.getInfo().getDefaultBind().toString());
		assertEquals(userBankCardDO.getCity(),result.getInfo().getCity());
		assertEquals(userBankCardDO.getCertType(),result.getInfo().getCertType().toString());
		assertEquals(userBankCardDO.getCertNo(),result.getInfo().getCertNo());
		assertEquals(userBankCardDO.getBizNo(),result.getInfo().getBizNo());
		assertEquals(userBankCardDO.getBankKey(),result.getInfo().getBankKey());
		assertEquals(userBankCardDO.getBankCode(),result.getInfo().getBankCode().toString());
		assertEquals(userBankCardDO.getBankCardType(),result.getInfo().getBankCardType().toString());
		assertEquals(userBankCardDO.getBankCardNo(),result.getInfo().getBankCardNo());
		assertEquals(userBankCardDO.getBankCardName(),result.getInfo().getBankCardName());
		assertEquals(userBankCardDO.getBankBindId(),result.getInfo().getBankBindId());
		assertEquals(userBankCardDO.getBankAccountType(),result.getInfo().getBankAccountType().toString());
		assertEquals(userBankCardDO.getAddress(),result.getInfo().getAddress());
		// 清除数据
		userTestBase.cleanUserBankCardByUserId(userBankCardDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(userBankCardDO1.getUserId());
	}


	/**
	 * 1001  order为空，提示order不能为空
	 * 1002  gid为空，提示gid不能为空
	 * 1003  bizNo为空，提示bizNo不能为空
	 * 1004  gid长度为34，提示gid长度只能为35
	 * 1005  gid长度为36，提示gid长度只能为35
	 * 1006  bizNo长度为19，提示bizNo长度只能为20
	 * 1007  bizNo长度为21，提示bizNo长度只能为20
	 */
	@AutoTest(file = "user/bankCardServiceFindByBizNoTestFailOne.csv")
	@DisplayName("根据绑卡流水查询银行卡信息--失败用例一")
	public void bankCardServiceFindByBizNoTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			FindBankByBizNoOrder findBankByBizNoOrder,
			//结果参数
			String code,
			String description,
			String message
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			findBankByBizNoOrder = null;
		}
		if(testId == 1002){
			findBankByBizNoOrder.setGid(null);
		}
		if(testId == 1003){
			findBankByBizNoOrder.setBizNo(null);
		}
		// 调用接口
		BizResult<BankCardInfo> result = bankCardService.findByBizNo(findBankByBizNoOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 数据验证
		// 清除数据
	}

	/**
	 * 1001  银行卡信息不存在，查询失败
	 */
	@AutoTest(file = "user/bankCardServiceFindByBizNoTestFailTwo.csv")
	@DisplayName("根据绑卡流水查询银行卡信息--失败用例二")
	public void bankCardServiceFindByBizNoTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			FindBankByBizNoOrder findBankByBizNoOrder,
			// 数据库参数
			UserBankCardDO userBankCardDO,
			// 结果参数
			String code,
			String description,
			String message
	){
		// 清除数据
		userTestBase.cleanUserBankCardByUserId(userBankCardDO.getUserId());
		// 准备数据
		userTestBase.insertUserBankCard(userBankCardDO);
		// 测试过程
		// 调用接口
		BizResult<BankCardInfo> result = bankCardService.findByBizNo(findBankByBizNoOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getInfo());
		// 清除数据
		userTestBase.cleanUserBankCardByUserId(userBankCardDO.getUserId());
	}
}

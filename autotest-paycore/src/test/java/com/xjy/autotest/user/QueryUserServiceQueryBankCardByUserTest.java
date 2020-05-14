package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.test.User;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.user.UserQueryAccountInfo;
import com.xyb.user.api.info.user.UserQueryCardInfo;
import com.xyb.user.api.info.user.UserResultInfo;
import dal.model.user.UserBankCardDO;
import dal.model.user.UserDO;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.user.QueryUserService;
import com.xyb.user.api.order.user.QueryCardByUserOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：根据用户查询关联银行卡信息
 * Created on 2018年06月13日.
 */
@Disabled
public class QueryUserServiceQueryBankCardByUserTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    QueryUserService queryUserService;

	@Autowired
	UserTestBase userTestBase;

	/**
	 * 1001  一个用户对应一张银行卡，查询成功
	 * 1002  一个用户对应多张银行卡，查询成功
	 */
	@AutoTest(file = "user/queryUserServiceQueryBankCardByUserTestSuccess.csv")
	@DisplayName("根据用户查询关联银行卡信息--成功用例")
	public void queryUserServiceQueryBankCardByUserTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			QueryCardByUserOrder queryCardByUserOrder,
			//数据库参数
			UserDO userDO,
			UserBankCardDO userBankCardDO,
			UserBankCardDO userBankCardDO1,
			//干扰参数
			UserDO userDO1,
			UserBankCardDO userBankCardDO2,
			String code,
			String description,
			String message
	) {
		// 清除数据
		userTestBase.cleanUserByUserName(userDO.getUserName());
		userTestBase.cleanUserByUserName(userDO1.getUserName());
		userTestBase.cleanUserBankCardByBankCardNo(userBankCardDO.getBankCardNo());
		userTestBase.cleanUserBankCardByBankCardNo(userBankCardDO1.getBankCardNo());
		userTestBase.cleanUserBankCardByBankCardNo(userBankCardDO2.getBankCardNo());
		// 准备数据
		userTestBase.insertUser(userDO);
		userTestBase.insertUserBankCard(userBankCardDO);
		if(testId == 1002){
			userTestBase.insertUserBankCard(userBankCardDO1);
		}
		//干扰数据
		userTestBase.insertUser(userDO1);
		userTestBase.insertUserBankCard(userBankCardDO2);
		// 测试过程
		// 调用接口
		BizResult<UserQueryCardInfo> result = queryUserService.queryBankCardByUser(queryCardByUserOrder);
		// 结果验证
		assertResult(testId,Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		//userInfo数据校验
		assertEquals(userDO.getZipCode(),result.getInfo().getUserInfo().getZipCode());
		assertEquals(userDO.getUserName(),result.getInfo().getUserInfo().getUserName());
		assertEquals(userDO.getUserType(),result.getInfo().getUserInfo().getUserType().toString());
		assertEquals(userDO.getUserStatus(),result.getInfo().getUserInfo().getUserStatus().toString());
		assertEquals(userDO.getUserId(),result.getInfo().getUserInfo().getUserId());
		assertEquals(userDO.getRegisterIp(),result.getInfo().getUserInfo().getRegisterIp());
		assertEquals(userDO.getRegisterFrom(),result.getInfo().getUserInfo().getRegisterFrom().toString());
		assertEquals(userDO.getRealName(),result.getInfo().getUserInfo().getRealName());
		assertEquals(userDO.getProvince(),result.getInfo().getUserInfo().getProvince());
		assertEquals(userDO.getPhone(),result.getInfo().getUserInfo().getPhone());
		assertEquals(userDO.getPartnerId(),result.getInfo().getUserInfo().getPartnerId());
		assertEquals(userDO.getMobile(),result.getInfo().getUserInfo().getMobile());
		assertEquals(userDO.getMerchantUserId(),result.getInfo().getUserInfo().getMerchantUserId());
		assertEquals(userDO.getMemo(),result.getInfo().getUserInfo().getMemo());
		assertEquals(userDO.getDistrict(),result.getInfo().getUserInfo().getDistrict());
		assertEquals(userDO.getCountry(),result.getInfo().getUserInfo().getCountry());
		assertEquals(userDO.getCity(),result.getInfo().getUserInfo().getCity());
		assertEquals(userDO.getCertType(),result.getInfo().getUserInfo().getCertType().toString());
		assertEquals(userDO.getCertNo(),result.getInfo().getUserInfo().getCertNo());
		assertEquals(userDO.getCertifyStatus(),result.getInfo().getUserInfo().getCertifyStatus().toString());
		assertEquals(userDO.getAddress(),result.getInfo().getUserInfo().getAddress());
		assertEquals(userDO.getParentUserId(),result.getInfo().getUserInfo().getParentUserId());
		//assertEquals(userDO.getPayPassword(),result.getInfo().getUserInfo().getPayPassword());
		//BankCardInfo数据校验
		assertEquals(userBankCardDO.getUserId(),result.getInfo().getCardInfos().get(0).getUserId());
		assertEquals(userBankCardDO.getProvince(),result.getInfo().getCardInfos().get(0).getProvince());
		assertEquals(userBankCardDO.getDefaultBind(),result.getInfo().getCardInfos().get(0).getDefaultBind().toString());
		assertEquals(userBankCardDO.getCity(),result.getInfo().getCardInfos().get(0).getCity());
		assertEquals(userBankCardDO.getCertType(),result.getInfo().getCardInfos().get(0).getCertType().toString());
		assertEquals(userBankCardDO.getCertNo(),result.getInfo().getCardInfos().get(0).getCertNo());
		assertEquals(userBankCardDO.getBizNo(),result.getInfo().getCardInfos().get(0).getBizNo());
		assertEquals(userBankCardDO.getBankKey(),result.getInfo().getCardInfos().get(0).getBankKey());
		assertEquals(userBankCardDO.getBankCode(),result.getInfo().getCardInfos().get(0).getBankCode().toString());
		assertEquals(userBankCardDO.getBankCardType(),result.getInfo().getCardInfos().get(0).getBankCardType().toString());
		assertEquals(userBankCardDO.getBankCardNo(),result.getInfo().getCardInfos().get(0).getBankCardNo());
		assertEquals(userBankCardDO.getBankCardName(),result.getInfo().getCardInfos().get(0).getBankCardName());
		assertEquals(userBankCardDO.getBankBindId(),result.getInfo().getCardInfos().get(0).getBankBindId());
		assertEquals(userBankCardDO.getBankAccountType(),result.getInfo().getCardInfos().get(0).getBankAccountType().toString());
		assertEquals(userBankCardDO.getAddress(),result.getInfo().getCardInfos().get(0).getAddress());

		if(testId == 1002){
			assertEquals(userBankCardDO1.getUserId(),result.getInfo().getCardInfos().get(1).getUserId());
			assertEquals(userBankCardDO1.getProvince(),result.getInfo().getCardInfos().get(1).getProvince());
			assertEquals(userBankCardDO1.getDefaultBind(),result.getInfo().getCardInfos().get(1).getDefaultBind().toString());
			assertEquals(userBankCardDO1.getCity(),result.getInfo().getCardInfos().get(1).getCity());
			assertEquals(userBankCardDO1.getCertType(),result.getInfo().getCardInfos().get(1).getCertType().toString());
			assertEquals(userBankCardDO1.getCertNo(),result.getInfo().getCardInfos().get(1).getCertNo());
			assertEquals(userBankCardDO1.getBizNo(),result.getInfo().getCardInfos().get(1).getBizNo());
			assertEquals(userBankCardDO1.getBankKey(),result.getInfo().getCardInfos().get(1).getBankKey());
			assertEquals(userBankCardDO1.getBankCode(),result.getInfo().getCardInfos().get(1).getBankCode().toString());
			assertEquals(userBankCardDO1.getBankCardType(),result.getInfo().getCardInfos().get(1).getBankCardType().toString());
			assertEquals(userBankCardDO1.getBankCardNo(),result.getInfo().getCardInfos().get(1).getBankCardNo());
			assertEquals(userBankCardDO1.getBankCardName(),result.getInfo().getCardInfos().get(1).getBankCardName());
			assertEquals(userBankCardDO1.getBankBindId(),result.getInfo().getCardInfos().get(1).getBankBindId());
			assertEquals(userBankCardDO1.getBankAccountType(),result.getInfo().getCardInfos().get(1).getBankAccountType().toString());
			assertEquals(userBankCardDO1.getAddress(),result.getInfo().getCardInfos().get(1).getAddress());
		}
		//清除数据
		userTestBase.cleanUserByUserName(userDO.getUserName());
		userTestBase.cleanUserByUserName(userDO1.getUserName());
		userTestBase.cleanUserBankCardByBankCardNo(userBankCardDO.getBankCardNo());
		userTestBase.cleanUserBankCardByBankCardNo(userBankCardDO1.getBankCardNo());
		userTestBase.cleanUserBankCardByBankCardNo(userBankCardDO2.getBankCardNo());
	}

	/**
	 * 1001  order为空，提示order不能为空
	 * 1002  gid为空，提示gid不能为空
	 * 1003  userId为空，提示userId不能为空
	 * 1004  gid长度为34，提示gid长度只能为35
	 * 1005  gid长度为36，提示gid长度只能为35
	 * 1006  userId长度为19，提示userId长度只能为20
	 * 1007  userId长度为21，提示userId长度只能为20
	 */
	@AutoTest(file = "user/queryUserServiceQueryBankCardByUserTestFailOne.csv")
	@DisplayName("根据用户查询关联银行卡信息--失败用例一")
	public void queryUserServiceQueryBankCardByUserTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			QueryCardByUserOrder queryCardByUserOrder,
			//结果参数
			String code,
			String description,
			String message
	){
		//清除数据
		//准备数据
		//测试过程
		if(testId == 1001){
			queryCardByUserOrder = null;
		}
		if(testId == 1002){
			queryCardByUserOrder.setGid(null);
		}
		if(testId == 1003){
			queryCardByUserOrder.setUserId(null);
		}
		//调用接口
		BizResult<UserQueryCardInfo> result = queryUserService.queryBankCardByUser(queryCardByUserOrder);
		//结果检查
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		//参数校验
		assertNull(result.getInfo());
		//清除数据
	}

	/**
	 * 1001  会员存在，会员银行卡不存在，查询数据为空
	 * 1002  会员不存在，查询数据为空
	 * 1003  会员状态不正确，查询数据为空
	 */
	@AutoTest(file = "user/queryUserServiceQueryBankCardByUserTestFailTwo.csv")
	@DisplayName("根据用户查询关联银行卡信息--失败用例二")
	public void queryUserServiceQueryBankCardByUserTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			QueryCardByUserOrder queryCardByUserOrder,
			//数据库参数
			UserDO userDO,
			//结果参数
			String code,
			String description,
			String message,
			Status status
	) {
		//清除数据
		userTestBase.cleanUserByCertNo(userDO.getCertNo());
		//准备数据
		if (testId == 1001 || testId == 1003) {
			userTestBase.insertUser(userDO);
		}
		//测试过程
		//调用接口
		BizResult<UserQueryCardInfo> result = queryUserService.queryBankCardByUser(queryCardByUserOrder);
		//结果检查
		assertResult(testId,status,code,result);
		//参数校验
		if(testId == 1002 || testId == 1003){
			assertNull(result.getInfo());
			assertEquals(description,result.getMessage());
		}else{
			assertNotNull(result.getInfo().getUserInfo());
			assertNull(result.getInfo().getCardInfos());
			assertEquals(description,result.getDescription());
		}
		//清除数据
		userTestBase.cleanUserByCertNo(userDO.getCertNo());
	}
}

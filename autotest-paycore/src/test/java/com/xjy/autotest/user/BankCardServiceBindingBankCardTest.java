package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.user.BankCardInfo;
import dal.model.user.UserBankCardDO;
import dal.model.user.UserDO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.user.BankCardService;
import com.xyb.user.api.order.user.BankCardOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：绑定银行卡
 * Created on 2018年06月13日.
 */
@Disabled
public class BankCardServiceBindingBankCardTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    BankCardService bankCardService;

	@Autowired
	UserTestBase userTestBase;
	/**
	 * 1001  必填参数，用户未绑卡，身份证开户，对私账户，借记卡
	 * 1002  全填参数，用户未绑卡，军官证开户，对私账户，贷记卡，农业银行，默认绑定
	 * 1003  全填参数，用户未绑卡，护照开户，对私账户，准贷记卡，建设银行，默认不绑定
	 * 1004  全填参数，用户未绑卡，回乡证开户，对私账户，预付费卡，工商银行，默认绑定
	 * 1005  全填参数，用户未绑卡，台胞证开户，对公账户，借记卡，中国银行，默认绑定
	 * 1006  全填参数，用户未绑卡，警官证开户，对公账户，贷记卡，东亚银行，默认绑定
	 * 1007  全填参数，用户未绑卡，士兵证开户，对公账户，准贷记卡，河北银行，默认不绑定
	 * 1008  全填参数，用户未绑卡，营业执照开户，对公账户，预付费卡，北京银行，默认绑定
	 * 1009  全填参数，用户已经绑卡，绑另一张不同银行卡
	 */
	@AutoTest(file = "user/bankCardServiceBindingBankCardTestSuccess.csv")
	@DisplayName("绑定银行卡--成功用例")
	public void bankCardServiceBindingBankCardTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BankCardOrder bankCardOrder,
			//数据库参数
			UserDO userDO,
			UserBankCardDO userBankCardDO,
			//结果参数
			String code,
			String description,
			String message
	) {
		// 清除数据
		userTestBase.cleanUserByCertNo(userDO.getCertNo());
		userTestBase.cleanUserBankCardByUserId(userDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(bankCardOrder.getUserId());
		// 准备数据
		userTestBase.insertUser(userDO);
		if(testId == 1009){
			userTestBase.insertUserBankCard(userBankCardDO);
		}
		// 测试过程
		if(testId == 1001){
			bankCardOrder.setProvince(null);
			bankCardOrder.setCity(null);
			bankCardOrder.setAddress(null);
			bankCardOrder.setBankCode(null);
			bankCardOrder.setBankKey(null);
			bankCardOrder.setBankBindId(null);
			bankCardOrder.setDefaultBind(null);
		}
		// 调用接口
		BizResult<BankCardInfo> result = bankCardService.bindingBankCard(bankCardOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		//校验info数据
		if(testId != 1001) {
			assertEquals(bankCardOrder.getProvince(), result.getInfo().getProvince());
			assertEquals(bankCardOrder.getAddress(), result.getInfo().getAddress());
			assertEquals(bankCardOrder.getCity(), result.getInfo().getCity());
			assertEquals(bankCardOrder.getBankCode(), result.getInfo().getBankCode());
			assertEquals(bankCardOrder.getBankKey(), result.getInfo().getBankKey());
			assertEquals(bankCardOrder.getBankBindId(), result.getInfo().getBankBindId());
			assertEquals(bankCardOrder.getDefaultBind(), result.getInfo().getDefaultBind());
		}
		assertEquals(bankCardOrder.getBankAccountType(),result.getInfo().getBankAccountType());
		assertEquals(bankCardOrder.getBankCardName(),result.getInfo().getBankCardName());
		assertEquals(bankCardOrder.getBankCardNo(),result.getInfo().getBankCardNo());
		assertEquals(bankCardOrder.getBankCardType(),result.getInfo().getBankCardType());
		assertNotNull(result.getInfo().getBizNo());
		assertEquals(bankCardOrder.getCertNo(),result.getInfo().getCertNo());
		assertEquals(bankCardOrder.getCertType(),result.getInfo().getCertType());
		assertEquals(bankCardOrder.getUserId(),result.getInfo().getUserId());
		//校验数据库
		UserBankCardDO DO1 = userTestBase.findUserBankCardByBankCardNo(bankCardOrder.getBankCardNo()).get(0);
		if(testId != 1001) {
				assertEquals(bankCardOrder.getAddress(), DO1.getAddress());
				assertEquals(bankCardOrder.getCity(), DO1.getCity());
				assertEquals(bankCardOrder.getDefaultBind().toString(),DO1.getDefaultBind());
				assertEquals(bankCardOrder.getProvince(), DO1.getProvince());
				assertEquals(bankCardOrder.getBankCode().toString(), DO1.getBankCode());
				assertEquals(bankCardOrder.getBankKey(), DO1.getBankKey());
				assertEquals(bankCardOrder.getBankBindId(), DO1.getBankBindId());
		}
		assertEquals(bankCardOrder.getBankCardNo(),DO1.getBankCardNo());
		assertEquals(bankCardOrder.getBankAccountType().toString(),DO1.getBankAccountType());
		assertEquals(bankCardOrder.getBankCardName(),DO1.getBankCardName());
		assertEquals(bankCardOrder.getBankCardType().toString(),DO1.getBankCardType());
		assertNotNull(DO1.getBizNo());
		assertEquals(bankCardOrder.getCertNo(),DO1.getCertNo());
		assertEquals(bankCardOrder.getBankCardNo(),DO1.getBankCardNo());
		assertEquals(bankCardOrder.getCertType().toString(),DO1.getCertType());
		assertEquals(bankCardOrder.getUserId(),DO1.getUserId());
		assertNotNull(DO1.getId());
		assertNotNull(DO1.getRawAddTime());
		assertNotNull(DO1.getRawUpdateTime());
		//清除数据
		userTestBase.cleanUserByCertNo(userDO.getCertNo());
		userTestBase.cleanUserBankCardByUserId(userDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(bankCardOrder.getUserId());
	}

	/**
	 * 1001  order为空，提示order不能为空
	 * 1002  gid为空，提示gid不能为空
	 * 1003  userId为空，提示userId不能为空
	 * 1004  bankCardNo为空，提示bankCardNo不能为空
	 * 1005  bankCardName为空，提示bankCardName不能为空
	 * 1006  certType为空，提示certType不能为空
	 * 1007  certNo为空，提示certNo不能为空
	 * 1008  bankAccountType为空，提示bankAccountType不能为空
	 * 1009  bankCardType为空，提示bankCardType不能为空
	 * 1010  gid长度为34，提示gid长度只能为35
	 * 1011  gid长度为36，提示gid长度只能为35
	 * 1012  userId长度为19，提示userId长度只能为20
	 * 1013  userId长度为21，提示userId长度只能为21
	 * 1014  bankCardNo长度为9，提示bankCardNo长度只能为10-20
	 * 1015  bankCardNo长度为21，提示bankCardNo长度只能为10-20
	 */
	@AutoTest(file = "user/bankCardServiceBindingBankCardTestFailOne.csv")
	@DisplayName("绑定银行卡--失败用例一")
	public void bankCardServiceBindingBankCardTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			BankCardOrder bankCardOrder,
			//结果参数
			String code,
			String description,
			String message
	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			bankCardOrder = null;
		}
		if(testId == 1002){
			bankCardOrder.setGid(null);
		}
		if(testId == 1003){
			bankCardOrder.setUserId(null);
		}
		if(testId == 1004){
			bankCardOrder.setBankCardNo(null);
		}
		if(testId == 1005){
			bankCardOrder.setBankCardName(null);
		}
		if(testId == 1006){
			bankCardOrder.setCertType(null);
		}
		if(testId == 1007){
			bankCardOrder.setCertNo(null);
		}
		if(testId == 1008){
			bankCardOrder.setBankAccountType(null);
		}
		if(testId == 1009){
			bankCardOrder.setBankCardType(null);
		}
		// 调用接口
		BizResult<BankCardInfo> result = bankCardService.bindingBankCard(bankCardOrder);
		// 结果验证
		assertResult(testId,Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getInfo());
		if(testId != 1001) {
			ArrayList list = new ArrayList();
			assertEquals(list, userTestBase.findUserBankCardByUserId(bankCardOrder.getUserId()));
		}
		// 清除数据

	}

	/**
	 * 1001  用户不存在，绑卡失败
	 * 1002  该用户已经绑定该银行卡，重复绑卡，绑卡失败
	 * 1003  其他用户已经绑定该银行卡，绑定成功
	 * 1004  用户状态不正确，绑卡失败
	 */
	@AutoTest(file = "user/bankCardServiceBindingBankCardTestFailTwo.csv")
	@DisplayName("绑定银行卡--失败用例二")
	public void bankCardServiceBindingBankCardTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			BankCardOrder bankCardOrder,
			//数据库参数
			UserDO userDO,
			UserDO userDO1,
			UserBankCardDO userBankCardDO,
			//结果参数
			String code,
			String description,
			String message,
			Status status
	) {
		// 清除数据
		userTestBase.cleanUserByCertNo(userDO.getCertNo());
		userTestBase.cleanUserByCertNo(userDO1.getCertNo());
		userTestBase.cleanUserBankCardByUserId(userDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(userDO1.getUserId());
		userTestBase.cleanUserById(userDO.getId());
		userTestBase.cleanUserById(userDO1.getId());
		// 准备数据
		if(testId == 1004){
			userTestBase.insertUser(userDO);
		}
		if (testId == 1002 || testId == 1003) {
			userTestBase.insertUser(userDO);
			userTestBase.insertUserBankCard(userBankCardDO);
		}
		if(testId == 1003){
			userTestBase.insertUser(userDO1);
		}
		// 测试过程
		// 调用接口
		BizResult<BankCardInfo> result = bankCardService.bindingBankCard(bankCardOrder);
		// 结果检查
		assertResult(testId,status,code,result);
		if(testId != 1003) {
			assertTrue(result.getMessage().contains(description));
		}else{
			assertEquals(description,result.getDescription());
		}
		// 参数校验
		if(testId != 1003) {
			assertNull(result.getInfo());
		}else{
			assertNotNull(result.getInfo());
		}

		ArrayList list = new ArrayList();
		if(testId == 1001 ||  testId == 1004) {
			assertEquals(list, userTestBase.findUserBankCardByBankCardNo(bankCardOrder.getBankCardNo()));
		}else{
			assertNotNull(userTestBase.findUserBankCardByBankCardNo(bankCardOrder.getBankCardNo()).get(0));
		}
		if(testId == 1003){
			assertNotNull(userTestBase.findUserBankCardByBankCardNo(bankCardOrder.getBankCardNo()).get(1));
		}
		// 清除数据
		userTestBase.cleanUserByCertNo(userDO.getCertNo());
		userTestBase.cleanUserByCertNo(userDO1.getCertNo());
		userTestBase.cleanUserBankCardByUserId(userDO.getUserId());
		userTestBase.cleanUserBankCardByUserId(userDO1.getUserId());
	}
}

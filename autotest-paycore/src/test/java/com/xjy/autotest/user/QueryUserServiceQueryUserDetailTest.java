package com.xjy.autotest.user;

import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.user.api.info.user.UserInfo;
import dal.model.user.UserDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.adk.common.lang.result.BizResult;
import com.xyb.user.api.service.user.QueryUserService;
import com.xyb.user.api.order.user.QueryUserOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：查询用户信息
 * Created on 2018/06/27.
 */
public class QueryUserServiceQueryUserDetailTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
	QueryUserService queryUserService;

	@Autowired
	UserTestBase userTestBase;

	/**
	 * 1001 根据userName和userType查询，查询成功
	 */
	@AutoTest(file = "user/queryUserServiceQueryUserDetailTestSuccess.csv")
	@DisplayName("查询用户信息--成功用例")
	public void queryUserServiceQueryUserDetailTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			QueryUserOrder queryUserOrder,
			// 数据库参数
			UserDO userDO,
			UserDO userDO1,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
		userTestBase.cleanUserByUserId(userDO1.getUserId());
		// 准备数据
		userTestBase.insertUser(userDO);
		userTestBase.insertUser(userDO1);
		// 测试过程
		// 调用接口
		BizResult<UserInfo> result = queryUserService.queryUserDetail(queryUserOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		assertEquals(userDO.getAddress(),result.getInfo().getAddress());
		assertEquals(userDO.getCertifyStatus(),result.getInfo().getCertifyStatus().toString());
		assertEquals(userDO.getCertNo(),result.getInfo().getCertNo());
		assertEquals(userDO.getCertType(),result.getInfo().getCertType().toString());
		assertEquals(userDO.getCity(),result.getInfo().getCity());
		assertEquals(userDO.getCountry(),result.getInfo().getCountry());
		assertEquals(userDO.getDistrict(),result.getInfo().getDistrict());
		assertEquals(userDO.getMemo(),result.getInfo().getMemo());
		assertEquals(userDO.getMerchantUserId(),result.getInfo().getMerchantUserId());
		assertEquals(userDO.getMobile(),result.getInfo().getMobile());
		assertEquals(userDO.getPartnerId(),result.getInfo().getPartnerId());
		assertEquals(userDO.getPhone(),result.getInfo().getPhone());
		assertEquals(userDO.getProvince(),result.getInfo().getProvince());
		assertEquals(userDO.getRealName(),result.getInfo().getRealName());
		assertEquals(userDO.getRegisterFrom(),result.getInfo().getRegisterFrom().toString());
		assertEquals(userDO.getRegisterIp(),result.getInfo().getRegisterIp());
		assertEquals(userDO.getUserId(),result.getInfo().getUserId());
		assertEquals(userDO.getUserStatus(),result.getInfo().getUserStatus().toString());
		assertEquals(userDO.getUserType(),result.getInfo().getUserType().toString());
		assertEquals(userDO.getZipCode(),result.getInfo().getZipCode());
		assertEquals(userDO.getUserName(),result.getInfo().getUserName());
		assertEquals(userDO.getParentUserId(),result.getInfo().getParentUserId());
		//assertEquals(userDO.getPayPassword(),result.getInfo().getPayPassword());
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
		userTestBase.cleanUserByUserId(userDO1.getUserId());
	}

	/**
	 * 1001 order为空，提示order不能为空
	 * 1002 gid为空，提示gid不能为空
	 * 1003 gid长度为34，提示gid长度只能为35
	 * 1004 gid长度为36，提示gid长度只能为35
	 * 1005 userName长度为51，提示userName长度只能为1-50
	 */
	@AutoTest(file = "user/queryUserServiceQueryUserDetailTestFailOne.csv")
	@DisplayName("查询用户信息--失败用例一")
	public void queryUserServiceQueryUserDetailTestFailOne(
			// 基本参数
			int testId,
			// 业务参数
			QueryUserOrder queryUserOrder,
			// 结果参数
			String code,
			String description

	){
		// 清除数据
		// 准备数据
		// 测试过程
		if(testId == 1001){
			queryUserOrder = null;
		}
		if(testId == 1002){
			queryUserOrder.setGid(null);
		}
		if(testId == 1003){
			queryUserOrder.setUserName(null);
		}
		BizResult<UserInfo> result = queryUserService.queryUserDetail(queryUserOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getInfo());
		// 清除数据
	}

	/**
	 * 1001 userName错误，用户不存在，查询失败
	 * 1002 userType错误，用户不存在，查询失败
	 */
	@AutoTest(file = "user/queryUserServiceQueryUserDetailTestFailTwo.csv")
	@DisplayName("查询用户信息--失败用例二")
	public void queryUserServiceQueryUserDetailTestFailTwo(
			// 基本参数
			int testId,
			// 业务参数
			QueryUserOrder queryUserOrder,
			// 数据库参数
			UserDO userDO,
			// 结果参数
			String code,
			String description
	){
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
		// 准备数据
		userTestBase.insertUser(userDO);
		// 测试过程
		// 调用接口
		BizResult<UserInfo> result = queryUserService.queryUserDetail(queryUserOrder);
		// 结果验证
		assertResult(testId, Status.FAIL,code,result);
		assertEquals(description,result.getMessage());
		// 参数校验
		assertNull(result.getInfo());
		// 清除数据
		userTestBase.cleanUserByUserId(userDO.getUserId());
	}
}

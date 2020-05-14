//package com.xjy.autotest.gas_merchant;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.xjy.autotest.annotation.AutoTest;
//import com.xjy.autotest.base.SpringBootTestBase;
//import com.xjy.autotest.testbase.Gas_merchantTestBase;
//import com.xyb.adk.common.lang.id.GID;
//import com.xyb.adk.common.lang.result.SimpleResult;
//import com.xyb.adk.common.lang.result.Status;
//import com.xyb.gas.merchant.api.facade.BasicManageService;
//import com.xyb.gas.merchant.api.order.base.AddDictTypeOrder;
//import dal.model.gas_merchant.GasDictTypeDO;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author nuomi@xyb.com
// * Created on 2018/09/26.
// */
//public class BasicManageServiceAddDictTypeTest extends SpringBootTestBase{
//
//	@Reference(version = DUBBO_VERSION_1)
//    BasicManageService basicManageService;
//
//	@Autowired
//	Gas_merchantTestBase gasMerchantTestBase;
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/basicManageServiceAddDictTypeTestSuccess.csv")
//	@DisplayName("新增字典类型--成功用例")
//	public void basicManageServiceAddDictTypeTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			AddDictTypeOrder order
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasDictTypeByTypeName(order.getTypeName());
//		// 准备数据
//		// 测试过程
//		order.setGid(GID.newGID());
//		if(testId==1001){
//			order.setMemo(null);
//		}
//		// 调用接口
//		SimpleResult result = basicManageService.addDictType(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<GasDictTypeDO> gasDictTypes=gasMerchantTestBase.findGasDictTypeByTypeName(order.getTypeName());
//		assertTrue(gasDictTypes.size()>0);
//		for(GasDictTypeDO gasDictType:gasDictTypes){
//			assertEquals(order.getTypeName(),gasDictType.getTypeName());
//			assertEquals(order.getTypeCode(),gasDictType.getTypeCode());
//			assertEquals(gasDictType.getRawAddTime(),gasDictType.getRawUpdateTime());
//			if(testId==1001) {
//				assertEquals(null, gasDictType.getMemo());
//			}else {
//				assertEquals(order.getMemo(), gasDictType.getMemo());
//			}
//		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasDictTypeByTypeName(order.getTypeName());
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/basicManageServiceAddDictTypeTestFailOne.csv")
//	@DisplayName("新增字典类型--参数非法")
//	public void basicManageServiceAddDictTypeTestFailOne(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			AddDictTypeOrder order
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		order.setGid(GID.newGID());
//		if(testId==1001){
//			order.setTypeCode(null);
//		}
//		if(testId==1002){
//			order.setTypeCode(null);
//		}
//		if(testId==1003){
//			order.setGid(null);
//		}
//		if(testId==1004){
//			order=null;
//		}
//		// 调用接口
//		SimpleResult result = basicManageService.addDictType(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		// 清除数据
//	}
//
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/basicManageServiceAddDictTypeTestFailTwo.csv")
//	@DisplayName("新增字典类型--失败用例")
//	public void basicManageServiceAddDictTypeTestFailTwo(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			AddDictTypeOrder order,
//			GasDictTypeDO gasDictTypeDO
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasDictTypeByTypeName(gasDictTypeDO.getTypeName());
//		// 准备数据
//		gasMerchantTestBase.insertGasDictType(gasDictTypeDO);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = basicManageService.addDictType(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<GasDictTypeDO> gasDictTypes=gasMerchantTestBase.findGasDictTypeByTypeName(order.getTypeName());
//		assertTrue(gasDictTypes.size()>0);
//		for(GasDictTypeDO gasDictType:gasDictTypes){
//			assertEquals(gasDictTypeDO.getTypeName(),gasDictType.getTypeName());
//			assertEquals(gasDictTypeDO.getTypeCode(),gasDictType.getTypeCode());
//			assertEquals(gasDictTypeDO.getRawAddTime(),gasDictType.getRawAddTime());
//			assertEquals(gasDictTypeDO.getMemo(),gasDictType.getMemo());
//		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasDictTypeByTypeName(gasDictTypeDO.getTypeName());
//	}
//}

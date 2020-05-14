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
//import com.xyb.gas.merchant.api.order.base.AddDictDataOrder;
//import dal.model.gas_merchant.GasDictDataDO;
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
//public class BasicManageServiceAddDictDataTest extends SpringBootTestBase{
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
//	@AutoTest(file = "gas_merchant/basicManageServiceAddDictDataTestSuccess.csv")
//	@DisplayName("新增字典项--成功用例")
//	public void basicManageServiceAddDictDataTestSuccess(
//			// 基本参数
//			int testId,
//            Status status,
//            String code,
//			// 业务参数
//			AddDictDataOrder order,
//			GasDictTypeDO gasDictTypeDO
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasDictTypeByTypeName(gasDictTypeDO.getTypeName());
//		gasMerchantTestBase.cleanGasDictDataByDataName(order.getDictName());
//		// 准备数据
//		gasMerchantTestBase.insertGasDictType(gasDictTypeDO);
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = basicManageService.addDictData(order);
//		// 结果验证
//        print(result);
//        assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<GasDictDataDO> gasDictDatas=gasMerchantTestBase.findGasDictDataByDataName(gasDictTypeDO.getTypeName());
//		assertTrue(gasDictDatas.size()>0);
//		for(GasDictDataDO gasDictData:gasDictDatas){
//			assertEquals(order.getTypeCode(),gasDictData.getTypeCode());
//			assertEquals(order.getDictCode(),gasDictData.getDataCode());
//			assertEquals(order.getDictName(),gasDictData.getDataName());
//			assertEquals(gasDictData.getRawAddTime(),gasDictData.getRawUpdateTime());
//		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasDictTypeByTypeName(gasDictTypeDO.getTypeName());
//		gasMerchantTestBase.cleanGasDictDataByDataName(order.getDictName());
//	}
//	/**
//	 * 1001
//	 */
//	@AutoTest(file = "gas_merchant/basicManageServiceAddDictDataTestFailOne.csv")
//	@DisplayName("新增字典项--参数非法")
//	public void basicManageServiceAddDictDataTestFailOne(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			AddDictDataOrder order,
//			GasDictTypeDO gasDictTypeDO
//	) {
//		// 清除数据
//		// 准备数据
//		// 测试过程
//		order.setGid(GID.newGID());
//		if(testId==1001){
//			order.setTypeCode(null);
//		}
//		if(testId==1002){
//			order.setDictCode(null);
//		}
//		if(testId==1003){
//			order.setDictName(null);
//		}
//		if(testId==1004){
//			order=null;
//		}
//		// 调用接口
//		SimpleResult result = basicManageService.addDictData(order);
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
//	@AutoTest(file = "gas_merchant/basicManageServiceAddDictDataTestFailTwo.csv")
//	@DisplayName("新增字典项--失败用例")
//	public void basicManageServiceAddDictDataTestFailTwo(
//			// 基本参数
//			int testId,
//			Status status,
//			String code,
//			// 业务参数
//			AddDictDataOrder order,
//			GasDictTypeDO gasDictTypeDO,
//			GasDictDataDO gasDictDataDO
//	) {
//		// 清除数据
//		gasMerchantTestBase.cleanGasDictTypeByTypeName(gasDictTypeDO.getTypeName());
//		gasMerchantTestBase.cleanGasDictDataByDataName(gasDictDataDO.getDataName());
//		// 准备数据
//		if(testId==1001) {
//			gasMerchantTestBase.insertGasDictType(gasDictTypeDO);
//		}
//		if(testId==1002) {
//			gasMerchantTestBase.insertGasDictData(gasDictDataDO);
//		}
//		// 测试过程
//		order.setGid(GID.newGID());
//		// 调用接口
//		SimpleResult result = basicManageService.addDictData(order);
//		// 结果验证
//		print(result);
//		assertEquals(status, result.getStatus());
////        assertEquals(code, result.getCode());
//		// 数据验证
//		List<GasDictDataDO> gasDictDatas=gasMerchantTestBase.findGasDictDataByDataName(gasDictTypeDO.getTypeName());
//		if(testId==1002) {
//			assertTrue(gasDictDatas.size() > 0);
//			for (GasDictDataDO gasDictData : gasDictDatas) {
//				assertEquals(gasDictDataDO.getTypeCode(), gasDictData.getTypeCode());
//				assertEquals(gasDictDataDO.getDataCode(), gasDictData.getDataCode());
//				assertEquals(gasDictDataDO.getDataName(), gasDictData.getDataName());
//				assertEquals(gasDictDataDO.getRawAddTime(), gasDictData.getRawAddTime());
//				assertEquals(gasDictDataDO.getRawUpdateTime(), gasDictData.getRawUpdateTime());
//			}
//		}
//		// 清除数据
//		gasMerchantTestBase.cleanGasDictTypeByTypeName(order.getDictName());
//		gasMerchantTestBase.cleanGasDictDataByDataName(gasDictDataDO.getDataName());
//	}
//}

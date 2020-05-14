package com.xjy.autotest.clear;

import com.baomidou.mybatisplus.plugins.Page;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.ClearTestBase;
import com.xyb.adk.common.lang.result.Status;
import dal.model.clear.BillTaskConfDO;
import org.junit.jupiter.api.DisplayName;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.xyb.clear.api.result.bill.BillTaskConfQueryResult;
import com.xyb.clear.api.service.bill.ManagerConfService;
import com.xyb.clear.api.order.bill.BillTaskConfQueryOrder;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author lvdou
 * 服务名：对账配置分页查询
 * Created on 2018/07/06.
 */
public class ManagerConfServiceQueryListTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION,group = "clear")
    ManagerConfService managerConfService;

	@Autowired
	ClearTestBase clearTestBase;
	/**
	 * 1001 无查询条件，默认分页信息
	 * 1002 无查询条件，每页两条数据，查询第一页
	 * 1003 无查询条件，每页一条数据，查询第二页
	 * 1004 无查询条件，每页一条数据，查询第三页
	 * 1005 根据channelId查询，每页一条数据，查询第一页
	 * 1006 根据useStatus查询，每页一条数据，查询第一页
	 * 1007 根据id查询，每页一条数据，查询第一页
	 * 1008 根据partnerId查询，每页一条数据，查询第一页
	 * 1009 根据所有查询条件查询，每页一条数据，查询第一页
	 * 1010 查询不到数据，处理成功，返回为空
	 */
	@AutoTest(file = "clear/managerConfServiceQueryListTestSuccess.csv")
	@DisplayName("对账配置分页查询--成功用例")
	public void managerConfServiceQueryListTestSuccess(
			// 基本参数
			int testId,
			// 业务参数
			BillTaskConfQueryOrder billTaskConfQueryOrder,
			// 分页参数
			Page page,
			// 数据库参数
			BillTaskConfDO billTaskConfDO,
			BillTaskConfDO billTaskConfDO1,
			BillTaskConfDO billTaskConfDO2,
			// 结果参数
			String code,
			String description
	) {
		// 清除数据
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO.getChannelId());
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO1.getChannelId());
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO2.getChannelId());
		// 准备数据
		clearTestBase.insertBillTaskConf(billTaskConfDO);
		clearTestBase.insertBillTaskConf(billTaskConfDO1);
		clearTestBase.insertBillTaskConf(billTaskConfDO2);
		// 测试过程
		billTaskConfQueryOrder.setPage(page);

		// 调用接口
		BillTaskConfQueryResult result = managerConfService.queryList(billTaskConfQueryOrder);
		// 结果验证
		assertResult(testId, Status.SUCCESS,code,result);
		assertEquals(description,result.getDescription());
		// 数据验证
		if(testId == 1001 || testId == 1002) {
			assertEquals(billTaskConfDO.getUseStatus(), result.getInfos().get(0).getUseStatus().toString());
			assertEquals(billTaskConfDO.getRawUpdateTime(), result.getInfos().get(0).getRawUpdateTime());
			assertEquals(billTaskConfDO.getRawAddTime(), result.getInfos().get(0).getRawAddTime());
			assertEquals(billTaskConfDO.getPartnerId(), result.getInfos().get(0).getPartnerId());
			assertEquals(billTaskConfDO.getId(), result.getInfos().get(0).getId());
			assertEquals(billTaskConfDO.getChannelId(), result.getInfos().get(0).getChannelId());
//			assertNotNull(result.getInfos().get(0).getBizNo());
			assertEquals(billTaskConfDO.getBillChannelTime(), result.getInfos().get(0).getBillChannelTime());
			assertEquals(billTaskConfDO.getBillCycle(), result.getInfos().get(0).getBillCycle());
			assertEquals(billTaskConfDO.getBillTime(), result.getInfos().get(0).getBillTime());
			assertEquals(billTaskConfDO.getMemo(), result.getInfos().get(0).getMemo());

			assertEquals(billTaskConfDO1.getUseStatus(), result.getInfos().get(1).getUseStatus().toString());
			assertEquals(billTaskConfDO1.getRawUpdateTime(), result.getInfos().get(1).getRawUpdateTime());
			assertEquals(billTaskConfDO1.getRawAddTime(), result.getInfos().get(1).getRawAddTime());
			assertEquals(billTaskConfDO1.getPartnerId(), result.getInfos().get(1).getPartnerId());
			assertEquals(billTaskConfDO1.getId(), result.getInfos().get(1).getId());
			assertEquals(billTaskConfDO1.getChannelId(), result.getInfos().get(1).getChannelId());
//			assertNotNull(result.getInfos().get(1).getBizNo());
			assertEquals(billTaskConfDO1.getBillChannelTime(), result.getInfos().get(1).getBillChannelTime());
			assertEquals(billTaskConfDO1.getBillCycle(), result.getInfos().get(1).getBillCycle());
			assertEquals(billTaskConfDO1.getBillTime(), result.getInfos().get(1).getBillTime());
			assertEquals(billTaskConfDO1.getMemo(), result.getInfos().get(1).getMemo());
		}
		if(testId == 1001) {
			assertEquals(billTaskConfDO2.getUseStatus(), result.getInfos().get(2).getUseStatus().toString());
			assertEquals(billTaskConfDO2.getRawUpdateTime(), result.getInfos().get(2).getRawUpdateTime());
			assertEquals(billTaskConfDO2.getRawAddTime(), result.getInfos().get(2).getRawAddTime());
			assertEquals(billTaskConfDO2.getPartnerId(), result.getInfos().get(2).getPartnerId());
			assertEquals(billTaskConfDO2.getId(), result.getInfos().get(2).getId());
			assertEquals(billTaskConfDO2.getChannelId(), result.getInfos().get(2).getChannelId());
//			assertNotNull(result.getInfos().get(2).getBizNo());
			assertEquals(billTaskConfDO2.getBillChannelTime(), result.getInfos().get(2).getBillChannelTime());
			assertEquals(billTaskConfDO2.getBillCycle(), result.getInfos().get(2).getBillCycle());
			assertEquals(billTaskConfDO2.getBillTime(), result.getInfos().get(2).getBillTime());
			assertEquals(billTaskConfDO2.getMemo(), result.getInfos().get(2).getMemo());
		}
		if(testId == 1003){
			assertEquals(billTaskConfDO1.getUseStatus(), result.getInfos().get(0).getUseStatus().toString());
			assertEquals(billTaskConfDO1.getRawUpdateTime(), result.getInfos().get(0).getRawUpdateTime());
			assertEquals(billTaskConfDO1.getRawAddTime(), result.getInfos().get(0).getRawAddTime());
			assertEquals(billTaskConfDO1.getPartnerId(), result.getInfos().get(0).getPartnerId());
			assertEquals(billTaskConfDO1.getId(), result.getInfos().get(0).getId());
			assertEquals(billTaskConfDO1.getChannelId(), result.getInfos().get(0).getChannelId());
//			assertNotNull(result.getInfos().get(0).getBizNo());
			assertEquals(billTaskConfDO1.getBillChannelTime(), result.getInfos().get(0).getBillChannelTime());
			assertEquals(billTaskConfDO1.getBillCycle(), result.getInfos().get(0).getBillCycle());
			assertEquals(billTaskConfDO1.getBillTime(), result.getInfos().get(0).getBillTime());
			assertEquals(billTaskConfDO1.getMemo(), result.getInfos().get(0).getMemo());
		}
		if(testId == 1004){
			assertEquals(billTaskConfDO2.getUseStatus(), result.getInfos().get(0).getUseStatus().toString());
			assertEquals(billTaskConfDO2.getRawUpdateTime(), result.getInfos().get(0).getRawUpdateTime());
			assertEquals(billTaskConfDO2.getRawAddTime(), result.getInfos().get(0).getRawAddTime());
			assertEquals(billTaskConfDO2.getPartnerId(), result.getInfos().get(0).getPartnerId());
			assertEquals(billTaskConfDO2.getId(), result.getInfos().get(0).getId());
			assertEquals(billTaskConfDO2.getChannelId(), result.getInfos().get(0).getChannelId());
//			assertNotNull(result.getInfos().get(0).getBizNo());
			assertEquals(billTaskConfDO2.getBillChannelTime(), result.getInfos().get(0).getBillChannelTime());
			assertEquals(billTaskConfDO2.getBillCycle(), result.getInfos().get(0).getBillCycle());
			assertEquals(billTaskConfDO2.getBillTime(), result.getInfos().get(0).getBillTime());
			assertEquals(billTaskConfDO2.getMemo(), result.getInfos().get(0).getMemo());
		}
		if(testId >= 1005 && testId <= 1009){
			assertEquals(billTaskConfDO.getUseStatus(), result.getInfos().get(0).getUseStatus().toString());
			assertEquals(billTaskConfDO.getRawUpdateTime(), result.getInfos().get(0).getRawUpdateTime());
			assertEquals(billTaskConfDO.getRawAddTime(), result.getInfos().get(0).getRawAddTime());
			assertEquals(billTaskConfDO.getPartnerId(), result.getInfos().get(0).getPartnerId());
			assertEquals(billTaskConfDO.getId(), result.getInfos().get(0).getId());
			assertEquals(billTaskConfDO.getChannelId(), result.getInfos().get(0).getChannelId());
//			assertNotNull(result.getInfos().get(0).getBizNo());
			assertEquals(billTaskConfDO.getBillChannelTime(), result.getInfos().get(0).getBillChannelTime());
			assertEquals(billTaskConfDO.getBillCycle(), result.getInfos().get(0).getBillCycle());
			assertEquals(billTaskConfDO.getBillTime(), result.getInfos().get(0).getBillTime());
			assertEquals(billTaskConfDO.getMemo(), result.getInfos().get(0).getMemo());
		}
		if(testId == 1010){
			assertNull(result.getInfos());
		}
		// 清除数据
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO.getChannelId());
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO1.getChannelId());
		clearTestBase.cleanBillTaskConfByChannelId(billTaskConfDO2.getChannelId());
	}

}

package com.xjy.autotest.gateway;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.cashier.api.order.route.PayConfigOrder;
import com.xyb.cashier.api.result.route.RouteResult;
import com.xyb.cashier.api.service.RouteApiService;
import com.xyb.gateway.api.base.GatewayResult;
import com.xyb.gateway.api.order.FtpUploadOrder;
import com.xyb.gateway.api.service.FtpService;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;


/**
 * @author huairen
 * Created on 2019/09/06.
 */
public class FtpServiceUploadTest extends SpringBootTestBase{

	@Reference(version = DUBBO_VERSION)
    FtpService ftpService;

	@Reference(version = DUBBO_VERSION, group = "cashier")
	RouteApiService routeApiService;

	/**
	 * 1001
	 */
	@AutoTest(file = "gateway/ftpServiceUploadTestSuccess.csv")
	@DisplayName("--成功用例")
	public void ftpServiceUploadTestSuccess(
			// 基本参数
			int testId,
            Status status,
            String code,
			// 业务参数
			FtpUploadOrder ftpUploadOrder,
			PayConfigOrder payConfigOrder
	) {
		// 清除数据
		// 准备数据
		// 测试过程
		RouteResult routeResult = routeApiService.findPayConfigInfo(payConfigOrder);
		print(routeResult);
		// 调用接口
		ftpUploadOrder.setChannelPartnerId(routeResult.getInfo().getChannelPartnerId());
		ftpUploadOrder.setSettleChannelId(routeResult.getInfo().getSettleChannelId());
		ftpUploadOrder.setParams(routeResult.getInfo().getParams());
		Map<String, String> imgs = new HashMap<>();
		imgs.put("LICENCE", "https://c-ssl.duitang.com/uploads/blog/201512/02/20151202175905_vsYEu.jpeg");
		imgs.put("ORGANIZATION", "https://c-ssl.duitang.com/uploads/item/201612/20/20161220135154_yd5Fh.jpeg");
		imgs.put("TAX", "https://c-ssl.duitang.com/uploads/blog/201510/15/20151015210110_xQUCk.jpeg");
		imgs.put("BANK_SETTLEMENT", "https://c-ssl.duitang.com/uploads/blog/201405/19/20140519122723_dseFH.jpeg");
		imgs.put("LEGAL_CERIFICATE_FRONT", "https://img.52z.com/upload/news/image/20180621/20180621055651_47663.jpg");
		imgs.put("LEGAL_CERIFICATE_BACK", "http://img-arch.pconline.com.cn/images/upload/upc/tx/photoblog/1411/17/c1/54653_1416214537161.jpg");
		ftpUploadOrder.setImgs(imgs);
		GatewayResult result = ftpService.upload(ftpUploadOrder);
		// 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
		// 数据验证
		// 清除数据
	}
}

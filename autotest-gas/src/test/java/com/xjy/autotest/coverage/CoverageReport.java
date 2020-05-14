package com.xjy.autotest.coverage;

import java.io.IOException;

//import com.yiji.framework.coverageReport.CoverageReportGenerator;

/**
 * @author 面条
 * @mail miantiao@yiji.com 修订记录： 面条 2017-3-13 下午3:14:25 创建
 *
 * 服务应用场景：该服务主要负责配合采集覆盖率报告
 *
 */
public class CoverageReport {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		//-----------------cbcustomer---------------------
		SystemConfig config = SystemConfig.xybUser;
/*		CoverageReportGenerator generator = new CoverageReportGenerator(config.getAddress(),
			config.getDumpFile(), config.getReportBaseDir(), config.getProjectBaseDir());
		generator.generateCoverageReport(false); //如果为true覆盖率不会被累加(如果为true不能再执行而获得报告，需要重新运行测试用例才可以)*/
	}

}

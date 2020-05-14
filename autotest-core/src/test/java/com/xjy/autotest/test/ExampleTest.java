package com.xjy.autotest.test;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.AutoTestBase;
import com.xyb.adk.common.util.money.Money;


/**
 * Created by ychaoyang on 2017/7/21.
 */
public class ExampleTest extends AutoTestBase {


	@AutoTest(file = "test/simpleTest.csv")
	void simpleTest(int testId, String result,Money money) {
		System.out.println("这是第 " + testId + " 条测试用例");
		System.out.println(result);
		System.out.println(money);
	}

	@AutoTest(file = "test/csvTest.csv")
//    @DisplayName("autotest读取csv数据")
	void autoTest(int testId, String result, String memo) {
		if (1001 == testId) {
			assertEquals("SUCCESS", result);
			print("memo：" + memo);
		}
		if (1002 == testId) {
			assertTrue("FAIL".equals(result));
			print("memo：" + memo);
		}

	}


}

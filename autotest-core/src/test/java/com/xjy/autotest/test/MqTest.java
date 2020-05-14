package com.xjy.autotest.test;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;

import java.lang.reflect.InvocationTargetException;

/**
 * @author ychaoyang
 * Created on 18/12/13.
 */
public class MqTest  extends SpringBootTestBase {

    @AutoTest(file = "test/simpleTest.csv")
    void simpleTest(int testId, String result) throws InvocationTargetException, IllegalAccessException {
        System.out.println("这是第 " + testId + " 条测试用例");
        System.out.println(result);
//        NotifyMessage messages = new NotifyMessage();
    }
}

package com.xjy.autotest.test;

import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MybatisTest {

    // @Autowired
    // IInvoiceInfoDAO iInvoiceInfoDAO;


    @AutoTest(file = "test/csvTest.csv")
    void test(int testId) {
        System.out.println("1111111111111");
        String id = "2c9281525fde194e015fe183f1af002c";
        // IInvoiceInfoDOExample e = new IInvoiceInfoDOExample();
        // e.createCriteria().andEntityIdEqualTo(id);
//        System.out.println(iInvoiceInfoDAO.selectByExample(e));
//        System.out.println(squidTestBase.findIInvoiceInfoByEntityId(id));
    }
}

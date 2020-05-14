package com.xjy.autotest;

import com.xjy.autotest.generate.GenerateApiCase;
import com.xjy.autotest.generate.GenerateXybApiCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = Main.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class Generator {

    @Autowired
    private GenerateApiCase generateApiCase;

    String author = "ychaoyang";
    String requestUrl = "api/motorcade/member/card";
    String packagName = "pos";
    int projectId = 33;

    @Test
    public void gen() {
        generateApiCase.generate(requestUrl, packagName, projectId, author, Generator.class);
    }

    @Test
    public void genOpenApiCase() {
        String serviceNo = "scanPay_1.0.0";
        String packag = "allinpay";
        new GenerateXybApiCase().generate(serviceNo, packag, author, Generator.class);
    }

}
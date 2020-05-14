package com.xjy.autotest;

import com.xjy.autotest.generate.GenerateFacadeCase;
import com.xyb.clear.api.service.bill.QueryBillInfoService;
import org.junit.jupiter.api.Test;

public class Generator {


    String author = "huairen";

    @Test
    public void genFacadeCase() {
        String methodName = "downBill";
        String packag = "clear";
        new GenerateFacadeCase().generate(QueryBillInfoService.class, methodName, packag, author, Generator.class);
    }

}
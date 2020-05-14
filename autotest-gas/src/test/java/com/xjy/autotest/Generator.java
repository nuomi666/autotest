package com.xjy.autotest;

import com.xjy.autotest.generate.GenerateFacadeCase;
import com.xyb.gas.merchant.api.facade.AppVersionService;
import org.junit.Test;

/**
 * @author nuomi@xinyebang.com
 * Created on 2019/8/6.
 */
public class Generator {

    String author = "nuomi";

    @Test
    public void genFacadeCase() {
        String methodName = "deleteAppVersion";
        String packag = "gas_merchant";
        new GenerateFacadeCase().generate(AppVersionService.class, methodName, packag, author,
                Generator.class);
    }
}

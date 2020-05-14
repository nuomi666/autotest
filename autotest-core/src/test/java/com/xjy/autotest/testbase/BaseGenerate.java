package com.xjy.autotest.testbase;

import com.xjy.autotest.generate.GenerateBaseFile;

/**
 * Created by ychaoyang on 2017/8/17.
 */
public class BaseGenerate {

    public static void main(String[] args) {

        String projectName = "squid";

        new GenerateBaseFile().generateBaseFile(projectName, "ychaoyang", true, BaseGenerate.class);

    }
}

package com.xjy.autotest.extension;

import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.mybatis.Dalgen;
import com.xjy.autotest.utils.ProcessObject;
import com.xjy.autotest.utils.StringUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author huairen
 * Created on 18/4/2.
 */
public class AutoTestParameterProvider implements ArgumentsProvider, AnnotationConsumer<AutoTest> {

    private String file;
    private String project;
    private List<Object[]> objects;

    @Override
    public void accept(AutoTest autoTest) {
        if (StringUtils.isBlank(autoTest.file())) {
            throw new IllegalArgumentException("csv文件路径file的值不能为空");
        }
        this.file = autoTest.file();
        this.project = autoTest.project();
        this.objects = new ArrayList<>();
    }


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        //生成mybatis代码
        if (StringUtils.isNotBlank(this.project)) {
            Dalgen dalgen = new Dalgen();
            dalgen.gen(this.project);
        }
        //获取测试方法参数列表
        List<Parame> pars = DataDeal.getVariables(context);
        URL url = Thread.currentThread().getContextClassLoader().getResource("autotest/" + this.file);
        if (null == url) {
            String filep = context.getTestClass().get().getClassLoader().getResource(".").getFile();
            String fileDir = filep.replace("target/classes/", "src/test/resources/autotest/").replace("target/test-classes/", "src/test/resources/autotest/") + file;
            DataDeal.createCsvFile(pars, fileDir);
            throw new IllegalArgumentException("找不到csv文件,创建文件成功:" + fileDir);
        }
        List<Object> args = DataDeal.getParams(context, this.file);
        for (Object ob : args) {
            HashMap<String, String> map = (HashMap) ob;
            Object[] obs = new Object[pars.size()];
            for (int i = 0; i < pars.size(); i++) {
                Parame p = pars.get(i);
                Class cl = p.getType();
                if (DataDeal.isJavaClass(cl) || cl.isEnum() || DataDeal.isProcessObject(cl)) {
                    obs[i] = ProcessObject.processing(cl, map.get(p.getName()));
                } else {
                    obs[i] = DataDeal.mapToObject(map, cl, p.getName());
                }
            }
            objects.add(obs);
        }
        return objects.stream().map(AutoTestParameterProvider::toArguments);
    }

    private static Arguments toArguments(Object item) {
        if (item instanceof Arguments) {
            return (Arguments) item;
        }
        if (item instanceof Object[]) {
            return Arguments.of((Object[]) item);
        }
        return Arguments.of(item);
    }


}

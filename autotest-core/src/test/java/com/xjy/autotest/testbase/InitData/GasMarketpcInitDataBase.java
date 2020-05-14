package com.xjy.autotest.testbase.InitData;

import com.google.common.collect.Maps;
import com.xjy.autotest.testbase.Gas_marketpcTestBase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author nuomi@xinyebang.com
 * Created on 2019/9/25.
 * 准备营销数据
 */
public class GasMarketpcInitDataBase {
    @Autowired
    Gas_marketpcTestBase marketpcTestBase;

    public Map<String, Object> initDeviceResource(String deviceType, String resourceType,
                                                  String name, String code) {
//        marketpcTestBase.cleanGasDeviceResourceByCode(code);
//        marketpcTestBase.insertGasDeviceResource(0L, deviceType, null, name, code, null, resourceType, null, null,
//                null, null, null);
//        Long parentId = marketpcTestBase.findGasDeviceResourceByName(name).get(0).getId();
        Map<String, Object> param = Maps.newHashMap();
//        param.put("partnerId", parentId);
        return param;
    }

}

package com.xjy.autotest.config;

import com.xyb.adk.common.dubbo.DubboRemoteProxyFacotry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nuomi@xinyebang.com
 * @date 2018/8/31
 */
@Configuration
public class DubboConfig {


    @Bean
    public DubboRemoteProxyFacotry dubboRemoteProxyFacotry() {
        return new DubboRemoteProxyFacotry();
    }
}

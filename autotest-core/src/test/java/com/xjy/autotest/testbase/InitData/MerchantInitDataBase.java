package com.xjy.autotest.testbase.InitData;

import com.google.common.collect.Maps;
import com.xjy.autotest.testbase.MerchantTestBase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @ClassName MerchantInitDataBase
 * @Author noodles
 * @Date 2019/7/4 17:34
 * @Version 1.0
 * 服务应用场景：该服务是在用户在电商平台完成额度申请审核通过后，接着在电商平台成功下单需要支付时，跳到支付机构收银台，点击所显示“白条支付”按钮，
 * 会调该服务完成贷款申请， 贷款申请成功后完成交易订单支付。
 * <p>
 * 开发实现逻辑：订单幂等性校验=>校验用户是否存在=>校验消金公司保证金是否足额=>校验用户授信余额是否充足=>过风控审核=>减少信用额度=>
 * 持久化订单并返回=>异步同步数据至数据中心（不影响成功） 计息公式xxxx；
 * <p>
 * 用例整体设计：（非用例项设计）该用例执行需开发的基础数据xxxx.sql；该用例的xxx数据采用sql/动态插入数据准备；
 * <p>
 * 涉及系统（表名）：系统英文名{表名（作用）}
 * <p>
 * 特别注意：
 **/
public class MerchantInitDataBase {

    @Autowired
    MerchantTestBase merchantTestBase;


    //欣业邦/爱车联顶级会员
    final String parentPartnerId = "S0000000000000000000";


    //爱车联/欣业邦顶级顶级商户信息


    /**
     * 准备好房通平台商信息，该商户业务模式是采用以好房通平台商通信，以欣业邦公众号收单，
     * 所以APPID使用的是欣业邦的。
     * 其中channelId是后台配置的，而后的子商户采用复制平台商的渠道id、APPID、appRefreshToken
     *
     * @return
     */
    public Map<String, Object> initPlatMerchant() {

        //目前该商户的会员信息是使用自动化测试环境中数据，暂时不需要去准备。
        String partnerId = "20180615001234567800";
        String appId = "wxba5b44957be67970";
        String appRefreshToken = "H5EF8F644";
        String channelId = "yst";
        merchantTestBase.cleanMerchantByPartnerId(partnerId);
        merchantTestBase.insertMerchant(0L, partnerId, parentPartnerId, null, "好房通平台商户",
                "PLATFORM", "ACTIVE", null, appId, appRefreshToken, channelId, null, null);
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", partnerId);
        param.put("appId", appId);
        param.put("channelId", channelId);
        param.put("appRefreshToken", appRefreshToken);
        return param;
    }

}

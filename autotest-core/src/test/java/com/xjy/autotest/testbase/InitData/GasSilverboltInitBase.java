package com.xjy.autotest.testbase.InitData;

import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nuomi@xinyebang.com
 * Created on 2019/11/21.
 */
@Service
public class GasSilverboltInitBase {
    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    /**
     * 支付方式字典表
     * //
     */
    public void initGasPaywayDict(String paywayCode, String paywayType,
                                  String paywayName, String paywayIcon,
                                  String paywaySmallIcon, String channelCode,
                                  String channelFunction) {
        if (StringUtils.isNotBlank(paywayCode)) {
            silverboltTestBase.cleanGasPaywayDictByPaywayCode(paywayCode);
            silverboltTestBase.insertGasPaywayDict(0L, paywayType, paywayCode, paywayName, paywayIcon,
                    paywaySmallIcon, channelCode, channelFunction, null, null);
        }
    }

    /**
     * 班结预置数据
     */
//    public void initLogoutPos(String partnerId, String terminalCode,
//                              String paywayName, String paywayIcon,
//                              String paywaySmallIcon, String channelCode,
//                              String channelFunction) {
//        if (StringUtils.isNotBlank(paywayCode)) {
//            silverboltTestBase.cleanGasPaywayDictByPaywayCode(paywayCode);
//            silverboltTestBase.insertGasTradeFavour(0L, OID.newID(), tradeType, tradeNo,
//                    partnerId, "测试商家", stationId, "test001",
//                    "糯米测试油站", operateId, "操作员666",
//                    terminalType, terminalCode, OID.newID(), null, null,
//                    "NORMAL", null, OID.newID(),
//                    tradePayType, payModel,
//                    String favourDefinitionId,
//                    String favourId,
//                    String favourName,
//                    String favourCategory,
//                    String favourType,
//                    String favourRule,
//                    String promotionWay,
//                    Long favourAmount,
//                    String status,
//                    String state,
//                    Date createTime,
//                    Date finishTime,
//                    Date rawAddTime,
//                    Date rawUpdateTime);
//        }
//    }
}

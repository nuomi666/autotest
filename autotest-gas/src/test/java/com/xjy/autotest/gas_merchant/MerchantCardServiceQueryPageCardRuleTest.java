package com.xjy.autotest.gas_merchant;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.InitData.GasMerchantInitDataBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.DateUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.result.PagedResult;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gas.merchant.api.facade.MerchantCardService;
import com.xyb.gas.merchant.api.info.MerchantCardRuleInfo;
import com.xyb.gas.merchant.api.order.common.CommonPageQueryOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/**
 * @author nuomi
 * Created on 2019/10/15.
 */
public class MerchantCardServiceQueryPageCardRuleTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION_1)
    MerchantCardService merchantCardService;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    Gas_merchantTestBase gasMerchantTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    /**
     * 1001.传入条件，查询出一个商家的2条卡规则，每页显示10条，显示第1页
     * 1002.传入条件，查询出多个商家的3条卡规则，每页显示2条，显示第1页
     * 1003.传入条件，查询出多个商家的3条卡规则，每页显示2条，显示第2页
     * 1004.不传条件，查询出来3条，每页显示10条，显示第1页
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceQueryPageCardRuleTestSuccess.csv")
    @DisplayName("分页查询制卡规则--成功用例")
    public void merchantCardServiceQueryPageCardRuleTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            String partnerId, String partnerId1,
            String partnerName, String partnerName1,
            String account, String account1,
            String memo, String memo1,
            CommonPageQueryOrder order
    ) {
        // 清除数据
        gasMerchantTestBase.cleanGasMerchantCardRuleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantCardRuleByPlatPartnerId(partnerId1);
        // 准备数据
        Date addTime = DateUtils.parseDate("2019-10-01");
        Date addTime1 = DateUtils.parseDate("2019-10-07");
        Date addTime2 = DateUtils.parseDate("2019-10-03");
        //商户信息
        gasMerchantInitDataBase.initGasMerchant(partnerId, partnerName, null, null, "1jlit82loxpo11hge7qi",
                "1jlit82lowpo11hge7qi",
                "1jlit82lpllo11hge7qi", "Merchant",
                null, "ABLE");
        gasMerchantInitDataBase.initGasMerchant(partnerId1, partnerName1, null, null, "1jlit8stfxpo11hge7qi",
                "1jlit8stfwpo11hge7qi",
                "1jlit8stfpoo11hge7qi", "Merchant",
                null, "ABLE");
        //卡规则
        gasMerchantInitDataBase.initCardRules(partnerId, account, memo, 1, 11, 10, 30, 10, 20, addTime, addTime1);
        gasMerchantInitDataBase.initCardRules(partnerId1, account1, memo1, 1, null, 9, null, 9, null, addTime2,
                null);
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1004) {
            order.setKeywords(null);
        }
        // 调用接口
        PagedResult<MerchantCardRuleInfo> result = merchantCardService.QueryPageCardRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        List<MerchantCardRuleInfo> rules = result.getInfoList();
        if (testId == 1001) {
            assertEquals(10, rules.get(1).getValidCount());
            assertEquals(addTime, rules.get(1).getRawAddTime());
            assertEquals(20, rules.get(0).getValidCount());
            assertEquals(addTime1, rules.get(0).getRawAddTime());
            for (MerchantCardRuleInfo rule : rules) {
//                assertEquals(partnerId, rule.getId());
                assertEquals(partnerName, rule.getPartnerName());
                assertEquals(account, rule.getOperatorAccount());
                assertEquals(memo, rule.getMemo());
            }
        }
        if (testId == 1002) {
            assertEquals(2, rules.size());
            assertEquals(9, rules.get(0).getValidCount());
//            assertEquals(partnerId1, rules.get(0).getId());
            assertEquals(partnerName1, rules.get(0).getPartnerName());
            assertEquals(account1, rules.get(0).getOperatorAccount());
            assertEquals(memo1, rules.get(0).getMemo());
            assertEquals(addTime2, rules.get(0).getRawAddTime());
            assertEquals(20, rules.get(1).getValidCount());
//            assertEquals(partnerId, rules.get(1).getId());
            assertEquals(partnerName, rules.get(1).getPartnerName());
            assertEquals(account, rules.get(1).getOperatorAccount());
            assertEquals(memo, rules.get(1).getMemo());
            assertEquals(addTime1, rules.get(1).getRawAddTime());
        }
        if (testId == 1003) {
            assertEquals(10, rules.get(0).getValidCount());
//            assertEquals(partnerId, rules.get(0).getId());
            assertEquals(partnerName, rules.get(0).getPartnerName());
            assertEquals(account, rules.get(0).getOperatorAccount());
            assertEquals(memo, rules.get(0).getMemo());
            assertEquals(addTime, rules.get(0).getRawAddTime());
        }
        if (testId == 1004) {
            assertEquals(3, rules.size());
            assertEquals(10, rules.get(2).getValidCount());
//            assertEquals(partnerId, rules.get(2).getId());
            assertEquals(partnerName, rules.get(2).getPartnerName());
            assertEquals(account, rules.get(2).getOperatorAccount());
            assertEquals(memo, rules.get(2).getMemo());
            assertEquals(addTime, rules.get(2).getRawAddTime());
            assertEquals(9, rules.get(1).getValidCount());
//            assertEquals(partnerId1, rules.get(1).getId());
            assertEquals(partnerName1, rules.get(1).getPartnerName());
            assertEquals(account1, rules.get(1).getOperatorAccount());
            assertEquals(memo1, rules.get(1).getMemo());
            assertEquals(addTime2, rules.get(1).getRawAddTime());
            assertEquals(20, rules.get(0).getValidCount());
//            assertEquals(partnerId, rules.get(0).getId());
            assertEquals(partnerName, rules.get(0).getPartnerName());
            assertEquals(account, rules.get(0).getOperatorAccount());
            assertEquals(memo, rules.get(0).getMemo());
            assertEquals(addTime1, rules.get(0).getRawAddTime());
        }
        // 清除数据
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId1);
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByUserId(partnerId1);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId1);
        gasMerchantTestBase.cleanGasMerchantCardRuleByPlatPartnerId(partnerId);
        gasMerchantTestBase.cleanGasMerchantCardRuleByPlatPartnerId(partnerId1);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
    }

    /**
     * 1001
     */
    @AutoTest(file = "gas_merchant/merchantCardServiceQueryPageCardRuleTestFailOne.csv")
    @DisplayName("分页查询制卡规则--参数非法")
    public void merchantCardServiceQueryPageCardRuleTestFailOne(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            CommonPageQueryOrder order
    ) {
        // 清除数据
        // 准备数据
        // 测试过程
        order.setGid(GID.newGID());
        if (testId == 1001) {
            order.setGid(null);
        }
        if (testId == 1002) {
            order = null;
        }
        // 调用接口
        PagedResult<MerchantCardRuleInfo> result = merchantCardService.QueryPageCardRule(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
//        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }
}

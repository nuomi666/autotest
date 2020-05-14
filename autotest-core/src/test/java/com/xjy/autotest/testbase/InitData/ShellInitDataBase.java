package com.xjy.autotest.testbase.InitData;

import com.google.common.collect.Maps;
import com.xjy.autotest.testbase.ShellmerchantTestBase;
import com.xjy.autotest.testbase.ShelluserTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.adk.common.util.security.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ShellInitDataBase
 * @Author noodles
 * @Date 2019/5/17 14:46
 * @Version 1.0 壳牌产品自动化测试用例专用初始化数据，非壳牌产品系统测试用例请勿使用。
 **/
@Service
public class ShellInitDataBase {

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    ShellmerchantTestBase shellmerchantTestBase;

    @Autowired
    ShelluserTestBase shelluserTestBase;

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * PARTNER_ID：业务商家会员ID，映射加好油里面的商家，壳牌就只有壳牌一个商家，神马付开通支付渠道/路由以此ID为准。
     */
    private String PARTNER_ID = "S0301901211800000914";

    /**
     * PARENT_USER_ID：会员的父级会员userId，主要解决商家层级关系，当商家没有层次需求时，其与platPartnerId一致;
     * 默认最大的父级为：S0000000000000000000（欣业邦），壳牌配置在properties中S0301901211800000914。
     * 举例说明：壳牌是一个商家，壳牌用于完成业务管理的业务会员的父级就是S0000000000000000000（欣业邦），
     * 而壳牌的会员的的父级就是壳牌的会员号S0301901211800000914。
     */
    private String PARENT_USER_ID = "S0301901211800000914";
    /**
     * PLAT_PARTNER_ID：加好油、壳牌、房产这样的平台标识。目前上游系统（油品）并没有用此设计,神马付会员系统在（api1.0.5)版本之后才有该属性，数据为空。
     */
    private String PLAT_PARTNER_ID = null;

    /**
     * merchant_user_id：神马付会员表（user）中存在。它是商家的业务会员Id，对神马付而言就是外部商户会员ID。
     * 以神马付为边界，之外的商户的会员ID(可以是加好油的会员ID，壳牌的会员ID，也可以独立对接神马付的商户的会员ID）。
     * 加好油和壳牌的会员本身就与userId一致。
     *
     */
    /**
     * 插入短信验证码至redis
     *
     * @param partnerId
     * @param mobile
     * @param smsCode
     */
    public void insertRedisVerificationCode(String partnerId, String mobile, String smsCode) {
        //yc-shell-user:是缓存的存储命名空间，应用由adk自动获取应用名称做的处理。
        String key = "yc-shell-user:" + partnerId + mobile;
        String timesKey = "yc-shell-user:" + "validate_" + partnerId + mobile;
        //验证次数
        String times = "3";
        redisTemplate.delete(key);
        redisTemplate.delete(timesKey);
//		redisTemplate.opsForValue().set(timesKey, times,10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(key, smsCode, 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(timesKey, times, 10, TimeUnit.SECONDS);
    }

    /**
     * 采用插入方式准备基础数据，partnerId采用变量被引入至CSV
     */
    public Map<String, Object> initPartnerUser() {
        /**
         * 逻辑说明：
         * ------------------------------------------------------------------------------------------------------------
         * 1.商户开户会注册会员并创建一个标准账户和一个营销账户。 。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
         * 2.授权方令牌 ：商户在微信公众号管理员授权后获得的？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
         * 3.刷新令牌：？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
         */

        //商户标准账户
        String partnerIdStandardAccountNo = "partneridaccountno11";
        //商户营销账户
        String partnerIdMarketingAccountNo = "partneridaccountno12";
        String realName = "壳牌自动化测试商户";
        String mobile = "18777777777";
        String sourceType = "WeChat";
        //微信公众号的AppId
        String sourceKey = "wx1111111111111111";
        //授权方令牌
        String authorizerAccessToken = "";
        //授权方令牌入库时间
        String authorizerAccessTokenTime = "2019-05-14 17:43:38";
        //刷新令牌
        String authorizerRefreshToken = "refreshtoken@@@sxXVEnFHF2twMP0fZ5d8irBZTUn-h8QZ9RfmU2qflIg";
        //商户微信公众号的授权的权限集
        String funcInfo = "";

        //插入神马付会员信息
        xybUserTestBase.cleanUserByUserId(PARTNER_ID);
        xybUserTestBase.insertUser(0L, PARTNER_ID, null, PARENT_USER_ID, PLAT_PARTNER_ID, null, null, "INSIDE",
                "PARTNER", "NORMAL", null, realName, null, null, null, null, null, null, null, null, null, mobile,
                null, null,
                null, PARTNER_ID, null, null, null);
        //插入神马付商户标准账户信息
        xybUserTestBase.cleanAccountByAccountNo(partnerIdStandardAccountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, PARTNER_ID, partnerIdStandardAccountNo, null, PARTNER_ID, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "YC_SHELL_DUMMY_DEFAULT", "壳牌自动化测试标准账户", null, null);
        //插入神马付商户营销账户信息
        xybUserTestBase.cleanAccountByAccountNo(partnerIdMarketingAccountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, PARTNER_ID, partnerIdMarketingAccountNo, null, PARTNER_ID,
                0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "MARKET_TAG", "壳牌自动化测试营销账户", null, null);

        //壳牌商户系统
        //插入壳牌商户信息
        shellmerchantTestBase.cleanGasMerchantByPartnerId(PARTNER_ID);
        shellmerchantTestBase.cleanGasMerchantByPartnerName(realName);
        shellmerchantTestBase.insertGasMerchant(0L, PARTNER_ID, realName, realName, mobile, "miantiao@xinyebang.com",
                partnerIdStandardAccountNo, partnerIdMarketingAccountNo, "ABLE", null, null, null, null);
        //插入商户来源信息表
        shellmerchantTestBase.cleanGasMerchantSourceDataBySourceTypeAndSourceKey(sourceType, sourceKey);
        shellmerchantTestBase.insertGasMerchantSourceData(0L, PARTNER_ID, sourceType, sourceKey, null,
                authorizerAccessToken, authorizerAccessTokenTime, authorizerRefreshToken, null, null, null, funcInfo);

        Map<String, Object> param = Maps.newHashMap();
        param.put("parentUserId", PARENT_USER_ID);
        param.put("platPartnerId", PLAT_PARTNER_ID);
        param.put("partnerId", PARTNER_ID);
        return param;
    }

    /**
     * 普通银壳级会员有绑定关系
     *
     * @return
     */
    public Map<String, Object> initShellUser() {
        //会员标准账户
        String userId = "userid11111234567890";
        String accountNo = "standardaccountno111";
        String mobile = "13389677386";
        String nickName = "撸到死";
        String realName = "壳牌自动化测试会员";
        String sex = "MAN";
        String openId = "openid11111111111111111111111111";
        String carNumber = "渝BMM111";
        String carNumber2 = "渝BMM222";
        Date birthday = DateUtil.tomorrow();
        Date rawAddTime = DateUtil.now();
        String importSource = "default";
        String payPassword = "1223456";
        String grade = "GRADE_SILVER";
        String headImgUrl = "http:www.xinyebang.com";
        String registerFrom = "AUTONOMY_GENERALIZE";
        String memberType = "NORMAL";
        //神马付会员信息
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.insertUser(0L, userId, null, PARENT_USER_ID, PLAT_PARTNER_ID, null, payPasswordMD5(userId,
                payPassword), "INSIDE",
                "PERSONAL", "NORMAL", null, realName, null, null, null, null, null, null, null, null, null, mobile,
                null, null,
                null, PARTNER_ID, "NORMAL", null, null);
        //插入神马付商户标准账户信息
        xybUserTestBase.cleanAccountByAccountNo(accountNo);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, PARTNER_ID, accountNo, null, userId, 0L, 0L, 0L, 0L, 0L,
                "ACTIVE",
                "NORMAL", "111", "YC_SHELL_DUMMY_DEFAULT", null, null, null);

        //壳牌会员信息
        shelluserTestBase.cleanUserByUserId(userId);
        shelluserTestBase.cleanUserByMobile(mobile);
        shelluserTestBase.insertUser(0L, userId, PARTNER_ID, mobile, birthday,
                DateUtil.dtSimpleFormat(birthday).substring(5), nickName, realName, headImgUrl, sex, memberType,
                registerFrom, grade, rawAddTime, null, null, "false", importSource);

        //会员卡信息
        shelluserTestBase.cleanUserCardInfoByUserId(userId);
        shelluserTestBase.insertUserCardInfo(0L, userId, PARTNER_ID, accountNo, null, null, "DUMMY", "DEFAULT",
                "YC_SHELL_DUMMY_DEFAULT", accountNo, "NORMAL", null, null);
        //会员与微信/支付宝绑定关系
        shelluserTestBase.cleanUserPayToolInfoByUserId(userId);
        shelluserTestBase.cleanUserPayToolInfoByOpenId(openId);
        shelluserTestBase.insertUserPayToolInfo(0L, userId, PARTNER_ID, "BINDING", openId, "WE_CHAT", null, null);

        //车辆信息
        shelluserTestBase.cleanUserCarInfoByUserId(userId);
        shelluserTestBase.insertUserCarInfo(0L, userId, carNumber, null, null, null, null, null, null, null);

        Map<String, Object> param = Maps.newHashMap();
        param.put("userId", userId);
        param.put("accountNo", accountNo);
        param.put("mobile", mobile);
        param.put("openId", openId);
        param.put("carNumber", carNumber);
        param.put("birthday", birthday);
        param.put("rawAddTime", rawAddTime);
        param.put("importSource", importSource);
        param.put("payPassword", payPassword);
        param.put("sex", sex);
        param.put("realName", realName);
        param.put("nickName", nickName);
        param.put("grade", grade);
        param.put("partnerId", PARTNER_ID);
        param.put("headImgUrl", headImgUrl);
        param.put("registerFrom", registerFrom);
        param.put("memberType", memberType);
        return param;
    }

    /**
     * 普通银壳级会员有绑定关系
     *
     * @return
     */
    public Map<String, Object> initShellUser2() {
        //会员标准账户
        String userId = "userid11111234567891";
        String accountNo = "standardaccountno222";
        String mobile = "13389677388";
        String nickName = "撸到死2";
        String realName = "壳牌自动化测试会员2";
        String sex = "MAN";
        String openId = "openid11111111111111111111111112";
        String carNumber = "渝BMM222";
        Date birthday = DateUtil.tomorrow();
        Date rawAddTime = DateUtil.now();
        String importSource = "default";
        String payPassword = "1223456";
        //神马付会员信息
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.insertUser(0L, userId, null, PARENT_USER_ID, PLAT_PARTNER_ID, null, payPasswordMD5(userId,
                payPassword), "INSIDE",
                "PERSONAL", "NORMAL", null, realName, null, null, null, null, null, null, null, null, null, mobile,
                null, null,
                null, PARTNER_ID, "NORMAL", null, null);
        //插入神马付商户标准账户信息
        xybUserTestBase.cleanAccountByAccountNo(accountNo);
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, PARTNER_ID, accountNo, null, userId, 0L, 0L, 0L, 0L, 0L,
                "ACTIVE",
                "NORMAL", "111", "YC_SHELL_DUMMY_DEFAULT", null, null, null);

        //壳牌会员信息
        shelluserTestBase.cleanUserByUserId(userId);
        shelluserTestBase.cleanUserByMobile(mobile);
        shelluserTestBase.insertUser(0L, userId, PARTNER_ID, mobile, birthday,
                DateUtil.dtSimpleFormat(birthday).substring(5), nickName, realName, null, sex, "NORMAL",
                "AUTONOMY_GENERALIZE", "GRADE_SILVER", rawAddTime, null, null, "false", importSource);

        //会员卡信息
        shelluserTestBase.cleanUserCardInfoByUserId(userId);
        shelluserTestBase.insertUserCardInfo(0L, userId, PARTNER_ID, accountNo, null, null, "DUMMY", "DEFAULT",
                "YC_SHELL_DUMMY_DEFAULT", accountNo, "NORMAL", null, null);
        //会员与微信/支付宝绑定关系
        shelluserTestBase.cleanUserPayToolInfoByUserId(userId);
        shelluserTestBase.cleanUserPayToolInfoByOpenId(openId);
        shelluserTestBase.insertUserPayToolInfo(0L, userId, PARTNER_ID, "BINDING", openId, "WE_CHAT", null, null);

        //车辆信息
        shelluserTestBase.cleanUserCarInfoByUserId(userId);
        shelluserTestBase.insertUserCarInfo(0L, userId, carNumber, null, null, null, null, null, null, null);

        Map<String, Object> param = Maps.newHashMap();
        param.put("userId", userId);
        param.put("accountNo", accountNo);
        param.put("mobile", mobile);
        param.put("openId", openId);
        param.put("carNumber", carNumber);
        param.put("birthday", birthday);
        param.put("rawAddTime", rawAddTime);
        param.put("importSource", importSource);
        param.put("payPassword", payPassword);
        param.put("sex", sex);
        param.put("realName", realName);
        return param;
    }

    /**
     * 支付密码和用户ID加盐
     *
     * @param userId
     * @param payPassword
     * @return
     */
    private String payPasswordMD5(String userId, String payPassword) {
        String payPasswordMD5 = null;
        if (userId != null && payPassword != null) {
            StringBuffer content = new StringBuffer();
            content.append(userId.substring(15, 20));
            content.append(payPassword);
            content.append(userId.substring(10, 14));
            payPasswordMD5 = DigestUtil.digestWithMD5(content.toString());
        }
        return payPasswordMD5;

    }
}

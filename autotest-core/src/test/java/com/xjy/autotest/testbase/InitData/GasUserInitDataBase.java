package com.xjy.autotest.testbase.InitData;

import com.google.common.collect.Maps;
import com.xjy.autotest.base.AutoTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.Gas_userTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.util.DateUtil;
import com.xyb.adk.common.util.security.DigestUtil;
import com.xyb.gas.user.api.enums.*;
import com.xyb.user.api.enums.RegisterFrom;
import com.xyb.user.api.enums.UserStatus;
import com.xyb.user.api.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author nuomi@xinyebang.com
 * Created on 2020/1/13.
 */
@Service
public class GasUserInitDataBase extends AutoTestBase {
    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    Gas_userTestBase userTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;

    @Autowired
    GasMerchantInitDataBase gasMerchantInitDataBase;

    //加好油这个平台
    String PLAT_PARTNER_ID = "S0301806081400000015";

    /**
     * 自主注册的会员则不需要填推荐人信息，员工推广的推荐人ID为操作员ID，油站ID必填，操作员信息预先造好
     * 会员推广的推荐人ID为userid，油站ID不需要填，推荐人会员需预先造好
     * 准备一个加好油会员
     */
    public Map<String, Object> initUser(String partnerId, String userId,
                                        String payPassword,
                                        String nickName, String mobile,
                                        String registerFrom, String userInviteId,
                                        String userInviteMobile, String stationId,
                                        Date birthday,
                                        Date rawAddTime, Date rawUpdateTime) {
        String passwordEnm = null;
        String shortBirthday = null;
        if (StringUtils.isNotBlank(payPassword)) {
            passwordEnm = AutoTestBase.getUserPassword(userId, payPassword);
        }
        if (birthday != null) {
            shortBirthday = DateUtil.dtSimpleFormat(birthday).substring(5);
        }
        //商户信息
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商家", "wx26129c93b476f26d2",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "658456244555", "ABLE");
        //插入神马付会员
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.insertUser(0L, userId, null, partnerId, null, null, passwordEnm,
                RegisterFrom.INSIDE.code(), UserType.PERSONAL.code(), UserStatus.NORMAL.code(), null,
                null, null, null, null, null,
                null, null, null, null, null, mobile, null, null,
                null, partnerId, null, rawAddTime, rawUpdateTime);
        //插入神马付会员标准账户信息
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.insertAccount(0L, null, partnerId, OID.newID(), null, userId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL",
                "111", "GAS_DUMMY_DEFAULT", "加好油自动化测试标准账户", rawAddTime, rawUpdateTime);
        String accountNo = xybUserTestBase.findAccountByUserId(userId).get(0).getAccountNo();
        //插入加好油会员
        userTestBase.cleanUserByUserId(userId);
        userTestBase.insertUser(0L, userId, partnerId, partnerId, mobile, birthday, shortBirthday,
                nickName, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), rawAddTime, rawUpdateTime, registerFrom, userInviteId, userInviteMobile,
                "false", "default", null, null);

        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.insertGasUser(0L, userId, partnerId, mobile, birthday, shortBirthday, nickName,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null, null,
                null, null, null, null,
                null, null, null, rawAddTime, rawUpdateTime,
                rawAddTime, rawUpdateTime);
        //插入加好油虚拟卡
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, accountNo, null,
                null, CardType.DUMMY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                accountNo, CardStatus.NORMAL.code(), rawAddTime, rawUpdateTime);
        //会员推广
        if ("USER_GENERALIZE".equals(registerFrom)) {
            userTestBase.cleanUserInviteLogByUserId(userId);
            userTestBase.insertUserInviteLog(0L, userId, partnerId, partnerId, nickName, userInviteId,
                    "推荐人", userInviteMobile, null, null);

            silverboltTestBase.cleanUserInviteLogByUserId(userId);
            silverboltTestBase.insertUserInviteLog(0L, partnerId, userId, mobile, null, nickName, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), userInviteId, "推荐人",
                    userInviteMobile, rawAddTime, null, null);
        }
        //员工推广
        if ("STAFF_GENERALIZE".equals(registerFrom)) {
            userTestBase.cleanUserSpreadLogByUserId(userId);
            userTestBase.insertUserSpreadLog(0L, userId, partnerId, partnerId, nickName, stationId,
                    "test001", "糯米测试油站", userInviteId, "油站员工", userInviteMobile,
                    null, null);

            silverboltTestBase.cleanUserSpreadLogByUserId(userId);
            silverboltTestBase.insertUserSpreadLog(0L, partnerId, userId, mobile, null, nickName,
                    null, null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), stationId,
                    "糯米测试油站", "test001", userInviteId, "油站员工", userInviteMobile,
                    rawAddTime, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("accountNo", accountNo);
        return param;
    }

    /**
     * 自主注册的会员则不需要填推荐人信息，员工推广的推荐人ID为操作员ID，油站ID必填，操作员信息预先造好
     * 会员推广的推荐人ID为userid，油站ID不需要填，推荐人会员需预先造好
     * 准备一个填写了生日的加好油会员
     */
    public Map<String, Object> initUserWithBirth(String partnerId, String userId,
                                                 String payPassword,
                                                 String nickName, String mobile,
                                                 String registerFrom, String userInviteId,
                                                 String userInviteMobile, String stationId,
                                                 Date birth,
                                                 Date rawAddTime, Date rawUpdateTime) {
        String passwordEnm = null;
        String shortBirthday = null;
        if (StringUtils.isNotBlank(payPassword)) {
            passwordEnm = DigestUtil.digestWithMD5(payPassword);
        }
        if (birth != null) {
            shortBirthday = DateUtil.dtSimpleFormat(birth).substring(5);
        }
        //商户信息
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商家", "wx26129c93b476f26d2",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "658456244555", "ABLE");
        //插入神马付会员
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.insertUser(0L, userId, null, partnerId, null, null, passwordEnm,
                RegisterFrom.INSIDE.code(), UserType.PERSONAL.code(), UserStatus.NORMAL.code(), null,
                null, null, null, null, null,
                null, null, null, null, null, mobile, null, null,
                null, partnerId, null, rawAddTime, rawUpdateTime);
        //插入神马付会员标准账户信息
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.insertAccount(0L, null, partnerId, OID.newID(), null, userId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL",
                "111", "GAS_DUMMY_DEFAULT", "加好油自动化测试标准账户", rawAddTime, rawUpdateTime);
        String accountNo = xybUserTestBase.findAccountByUserId(userId).get(0).getAccountNo();
        //插入加好油会员
        userTestBase.cleanUserByUserId(userId);
        userTestBase.insertUser(0L, userId, partnerId, partnerId, mobile, birth, shortBirthday,
                nickName, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), rawAddTime, rawUpdateTime, registerFrom, userInviteId, userInviteMobile,
                "false", "default", null, null);

        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.insertGasUser(0L, userId, partnerId, mobile, birth, shortBirthday, nickName,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                null, null, null, null, null,
                null, null, null, null, rawAddTime, rawUpdateTime,
                rawAddTime, rawUpdateTime);
        //插入加好油虚拟卡
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, accountNo, null,
                null, CardType.DUMMY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                accountNo, CardStatus.NORMAL.code(), rawAddTime, rawUpdateTime);
        //会员推广
        if ("USER_GENERALIZE".equals(registerFrom)) {
            userTestBase.cleanUserInviteLogByUserId(userId);
            userTestBase.insertUserInviteLog(0L, userId, partnerId, partnerId, nickName, userInviteId,
                    "推荐人", userInviteMobile, null, null);

            silverboltTestBase.cleanUserInviteLogByUserId(userId);
            silverboltTestBase.insertUserInviteLog(0L, partnerId, userId, mobile, null, nickName, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), userInviteId, "推荐人",
                    userInviteMobile, rawAddTime, null, null);
        }
        //员工推广
        if ("STAFF_GENERALIZE".equals(registerFrom)) {
            userTestBase.cleanUserSpreadLogByUserId(userId);
            userTestBase.insertUserSpreadLog(0L, userId, partnerId, partnerId, nickName, stationId,
                    "test001", "糯米测试油站", userInviteId, "油站员工", userInviteMobile,
                    null, null);

            silverboltTestBase.cleanUserSpreadLogByUserId(userId);
            silverboltTestBase.insertUserSpreadLog(0L, partnerId, userId, mobile, null, nickName,
                    null, null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), stationId,
                    "糯米测试油站", "test001", userInviteId, "油站员工", userInviteMobile,
                    rawAddTime, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("accountNo", accountNo);
        return param;
    }

    /**
     * 自主注册的会员则不需要填推荐人信息，员工推广的推荐人ID为操作员ID，油站ID必填，操作员信息预先造好
     * 会员推广的推荐人ID为userid，油站ID不需要填，推荐人会员需预先造好
     * 准备一个所有信息的加好油会员（包括车辆、微信等信息）
     */
    public Map<String, Object> initUserAll(String partnerId, String userId,
                                           String payPassword, String openId,
                                           String nickName, String mobile,
                                           String carNum,
                                           String registerFrom, String userInviteId,
                                           String userInviteMobile, String stationId,
                                           Date birth,
                                           Date rawAddTime, Date rawUpdateTime) {
        String passwordEnm = null;
        String shortBirthday = null;
        if (StringUtils.isNotBlank(payPassword)) {
            passwordEnm = DigestUtil.digestWithMD5(payPassword);
        }
        if (birth != null) {
            shortBirthday = DateUtil.dtSimpleFormat(birth).substring(5);
        }
        //商户信息
        gasMerchantInitDataBase.initGasMerchant(partnerId, "糯米测试商家", "wx26129c93b476f26d2",
                "糯米", OID.newID(), OID.newID(), OID.newID(), "Merchant",
                "658456244555", "ABLE");
        //插入神马付会员
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.insertUser(0L, userId, null, partnerId, null, null, passwordEnm,
                RegisterFrom.INSIDE.code(), UserType.PERSONAL.code(), UserStatus.NORMAL.code(), null,
                null, null, null, null, null,
                null, null, null, null, null, mobile, null, null,
                null, partnerId, null, rawAddTime, rawUpdateTime);
        //插入神马付会员标准账户信息
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.insertAccount(0L, null, partnerId, OID.newID(), null, userId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL",
                "111", "GAS_DUMMY_DEFAULT", "加好油自动化测试标准账户", rawAddTime, rawUpdateTime);
        String accountNo = xybUserTestBase.findAccountByUserId(userId).get(0).getAccountNo();
        //插入加好油会员
        userTestBase.cleanUserByUserId(userId);
        userTestBase.cleanUserByPlatPartnerIdAndMobile(partnerId, mobile);
        userTestBase.insertUser(0L, userId, partnerId, partnerId, mobile, birth, shortBirthday,
                nickName, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), rawAddTime, rawUpdateTime, registerFrom, null, null,
                "false", "default", null, null);

        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.cleanGasUserByPartnerIdAndMobile(partnerId, mobile);
        silverboltTestBase.insertGasUser(0L, userId, partnerId, mobile, birth, shortBirthday, nickName,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(),
                null, null, registerFrom, null, null,
                null, null, null, null, rawAddTime, rawUpdateTime,
                rawAddTime, rawUpdateTime);
        //微信信息
        if (StringUtils.isNotBlank(openId)) {
            userTestBase.cleanUserPayToolInfoByOpenId(openId);
            userTestBase.insertUserPayToolInfo(0L, userId, partnerId, partnerId,
                    openId, "WE_CHAT", null, null);
        }
        //插入加好油虚拟卡
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, accountNo, null,
                null, CardType.DUMMY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                accountNo, CardStatus.NORMAL.code(), rawAddTime, rawUpdateTime);
        //车辆信息
        if (StringUtils.isNotBlank(carNum)) {
            userTestBase.cleanUserCarInfoByUserId(userId);
            userTestBase.insertUserCarInfo(0L, userId, carNum, null, null, null,
                    null, null, null, null);
        }
        //会员推广
        if ("USER_GENERALIZE".equals(registerFrom)) {
            userTestBase.cleanUserInviteLogByUserId(userId);
            userTestBase.insertUserInviteLog(0L, userId, partnerId, partnerId, nickName, userInviteId,
                    "推荐人", userInviteMobile, null, null);

            silverboltTestBase.cleanUserInviteLogByUserId(userId);
            silverboltTestBase.insertUserInviteLog(0L, partnerId, userId, mobile, null, nickName, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), userInviteId, "推荐人",
                    userInviteMobile, rawAddTime, null, null);
        }
        //员工推广
        if ("STAFF_GENERALIZE".equals(registerFrom)) {
            userTestBase.cleanUserSpreadLogByUserId(userId);
            userTestBase.insertUserSpreadLog(0L, userId, partnerId, partnerId, nickName, stationId,
                    "test001", "糯米测试油站", userInviteId, "油站员工", userInviteMobile,
                    null, null);

            silverboltTestBase.cleanUserSpreadLogByUserId(userId);
            silverboltTestBase.insertUserSpreadLog(0L, partnerId, userId, mobile, null, nickName,
                    null, null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), stationId,
                    "糯米测试油站", "test001", userInviteId, "油站员工", userInviteMobile,
                    rawAddTime, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("accountNo", accountNo);
        return param;
    }

    /**
     * 准备加好油会员   商户信息需预先准备（页面测试使用）
     */
    public Map<String, Object> initGasUserOnly(String partnerId, String userId,
                                               String payPassword,
                                               String nickName, String mobile,
                                               String registerFrom, String userInviteId,
                                               String userInviteMobile, String stationId,
                                               Date birthday,
                                               Date rawAddTime, Date rawUpdateTime) {
        String passwordEnm = null;
        String shortBirthday = null;
        if (StringUtils.isNotBlank(payPassword)) {
            passwordEnm = AutoTestBase.getUserPassword(userId, payPassword);
        }
        if (birthday != null) {
            shortBirthday = DateUtil.dtSimpleFormat(birthday).substring(5);
        }
        //插入神马付会员
        xybUserTestBase.cleanUserByUserId(userId);
        xybUserTestBase.insertUser(0L, userId, null, partnerId, null, null, passwordEnm,
                RegisterFrom.INSIDE.code(), UserType.PERSONAL.code(), UserStatus.NORMAL.code(), null,
                null, null, null, null, null,
                null, null, null, null, null, mobile, null, null,
                null, partnerId, null, rawAddTime, rawUpdateTime);
        //插入神马付会员标准账户信息
        xybUserTestBase.cleanAccountByUserId(userId);
        xybUserTestBase.insertAccount(0L, null, partnerId, OID.newID(), null, userId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL",
                "111", "GAS_DUMMY_DEFAULT", "加好油自动化测试标准账户", rawAddTime, rawUpdateTime);
        String accountNo = xybUserTestBase.findAccountByUserId(userId).get(0).getAccountNo();
        //插入加好油会员
        userTestBase.cleanUserByUserId(userId);
        userTestBase.insertUser(0L, userId, partnerId, partnerId, mobile, birthday, shortBirthday,
                nickName, null, null, Sex.OTHER.code(), MemberType.NORMAL.code(), "false",
                UserGrade.GRADE_COMMON.code(), rawAddTime, rawUpdateTime, registerFrom, userInviteId, userInviteMobile,
                "false", "default", null, null);

        silverboltTestBase.cleanGasUserByUserId(userId);
        silverboltTestBase.insertGasUser(0L, userId, partnerId, mobile, birthday, shortBirthday, nickName,
                null, null, null, null, null, null,
                Sex.OTHER.code(), MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), null, null,
                null, null, null, null,
                null, null, null, rawAddTime, rawUpdateTime,
                rawAddTime, rawUpdateTime);
        //插入加好油虚拟卡
        userTestBase.cleanUserCardInfoByUserId(userId);
        userTestBase.insertUserCardInfo(0L, userId, partnerId, partnerId, accountNo, null,
                null, CardType.DUMMY.code(), CardBizType.DEFAULT.code(), "GAS_DUMMY_DEFAULT",
                accountNo, CardStatus.NORMAL.code(), rawAddTime, rawUpdateTime);
        //会员推广
        if ("USER_GENERALIZE".equals(registerFrom)) {
            userTestBase.cleanUserInviteLogByUserId(userId);
            userTestBase.insertUserInviteLog(0L, userId, partnerId, partnerId, nickName, userInviteId,
                    "推荐人", userInviteMobile, null, null);

            silverboltTestBase.cleanUserInviteLogByUserId(userId);
            silverboltTestBase.insertUserInviteLog(0L, partnerId, userId, mobile, null, nickName, null,
                    null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), userInviteId, "推荐人",
                    userInviteMobile, rawAddTime, null, null);
        }
        //员工推广
        if ("STAFF_GENERALIZE".equals(registerFrom)) {
            userTestBase.cleanUserSpreadLogByUserId(userId);
            userTestBase.insertUserSpreadLog(0L, userId, partnerId, partnerId, nickName, stationId,
                    "test001", "糯米测试油站", userInviteId, "油站员工", userInviteMobile,
                    null, null);

            silverboltTestBase.cleanUserSpreadLogByUserId(userId);
            silverboltTestBase.insertUserSpreadLog(0L, partnerId, userId, mobile, null, nickName,
                    null, null, MemberType.NORMAL.code(), UserGrade.GRADE_COMMON.code(), stationId,
                    "糯米测试油站", "test001", userInviteId, "油站员工", userInviteMobile,
                    rawAddTime, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("accountNo", accountNo);
        return param;
    }
}

package com.xjy.autotest.testbase.InitData;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xjy.autotest.testbase.Gas_merchantTestBase;
import com.xjy.autotest.testbase.Gas_silverboltTestBase;
import com.xjy.autotest.testbase.MerchantTestBase;
import com.xjy.autotest.testbase.UserTestBase;
import com.xjy.autotest.utils.StringUtils;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.util.money.Money;
import com.xyb.adk.common.util.security.DigestUtil;
import com.xyb.gas.merchant.api.enums.*;
import com.xyb.gas.merchant.api.order.GoodsPriceOrder;
import com.xyb.gas.merchant.api.order.ProtocolRuleDataOrder;
import com.xyb.gas.merchant.api.order.payway.MerchantPaywayAttributeOrder;
import com.xyb.gas.merchant.api.order.payway.PaywaySceneOrder;
import com.xyb.user.api.enums.RegisterFrom;
import dal.dao.gas_merchant.GasMerchantPaywayDAO;
import dal.dao.gas_merchant.RoleDAO;
import dal.dao.gas_merchant.UserUniqueKeyDAO;
import dal.dao.gas_silverbolt.GasMerchantPayWayDAO;
import dal.model.gas_merchant.GasMerchantPaywayDOExample;
import dal.model.gas_merchant.RoleDO;
import dal.model.gas_merchant.RoleDOExample;
import dal.model.gas_merchant.UserUniqueKeyDOExample;
import dal.model.gas_silverbolt.GasMerchantPayWayDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author nuomi@xinyebang.com
 * Created on 2019/8/2.
 * 数据应用场景：用于准备加好油商家相关信息。
 * 基础信息包括商家
 * 附加（有可能需要的信息）包括油站、员工、实体卡、商品、油枪、油价、一键加油等信息
 */
@Service
public class GasMerchantInitDataBase {
    @Autowired
    Gas_merchantTestBase merchantTestBase;

    @Autowired
    UserTestBase xybUserTestBase;

    @Autowired
    MerchantTestBase xybMerchantTestBase;

    @Autowired
    Gas_silverboltTestBase silverboltTestBase;
    //加好油平台
    String PLAT_PARTNER_ID = "S0301806081400000015";

    @Autowired
    GasMerchantPaywayDAO gasMerchantPaywayDAO;

    @Autowired
    GasMerchantPayWayDAO silverboltPayWayDAO;

    @Autowired
    UserUniqueKeyDAO userUniqueKeyDAO;

    @Autowired
    RoleDAO roleDAO;

    /**
     * 数据应用场景：造多个或一个未授权商户的情况用这个(最多只造了两个)，不支持一个用例里多次使用此方法来造多个商家
     * 参数设计说明：partnerId不传则不会插入对应商家的信息
     */
    public Map<String, Object> initGasMerchants(String partnerId, String partnerId1,
                                                String partnerName, String partnerName1,
                                                String shortName, String shortName1,
                                                String mobile, String mobile1,
                                                String sourceKey, String sourceKey1,
                                                String merchantStatus, String merchantStatus1,
                                                String model, String model1,
                                                Date rawAddTime, Date rawUpdateTime) {

        //资金账户
        String accountNo = "1jc7w1m29ks031hge7p8";
        String marketAccountNo = "001iys5hlniks541g00";
        String poolAccountNo = "1jhb00i98ws031hge7p0";
        String accountNo1 = "1jc81da19gs031hge7p8";
        String marketAccountNo1 = "001iys5hlniks0368h00";
        String poolAccountNo1 = "1jhb00i98ws985hge7p0";
        //第一个商家
        if (StringUtils.isNotBlank(partnerId) && StringUtils.isNotBlank(partnerName)) {
            xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
            xybMerchantTestBase.insertMerchantInfo(0L, partnerId, partnerId, null, null, partnerName, null, null,
                    "INSIDE", "PLATFORM", "ACTIVE", GID.newGID(), "MD5", null, null,
                    null);
            //插入神马付会员
            xybUserTestBase.cleanUserByUserId(partnerId);
            xybUserTestBase.insertUser(0L, partnerId, null, partnerId, PLAT_PARTNER_ID, null, null,
                    RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                    com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                    partnerName, null, null, null, null,
                    null, null, null, null, null, mobile, null, null,
                    null, partnerId, null, rawAddTime, rawUpdateTime);
            //插入神马付商户标准账户信息
            xybUserTestBase.cleanAccountByUserId(partnerId);
            xybUserTestBase.cleanAccountByAccountNo(accountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, accountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", accountNo, "加好油自动化测试标准账户", rawAddTime, rawUpdateTime);
            //插入神马付商户营销账户信息
            xybUserTestBase.cleanAccountByAccountNo(marketAccountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, marketAccountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "gas_merchant_market_account_tag", "加好油自动化测试营销账户",
                    rawAddTime, rawUpdateTime);
            //插入神马付商户资金池账户信息
            xybUserTestBase.cleanAccountByAccountNo(poolAccountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, poolAccountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试资金池账户", rawAddTime, rawUpdateTime);
            //加好油商户
            merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
            merchantTestBase.cleanGasMerchantByPartnerName(partnerName);
            merchantTestBase.insertGasMerchant(0L, partnerId, partnerId, partnerName, shortName, mobile, null,
                    accountNo, marketAccountNo, merchantStatus, null, null, model, "1", "0*60*60*1000+0*60*1000+0" +
                            "*1000", rawAddTime, rawUpdateTime);
            //商户来源信息
            merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
            merchantTestBase.insertGasMerchantSourceData(0L, partnerId, partnerId, SourceType.WeChat.code(),
                    sourceKey, Byte.valueOf("0"), null, rawAddTime, rawUpdateTime, null, null, null, null);
            //分析数据
            silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
            silverboltTestBase.insertGasMerchant(0L, partnerId, partnerName, shortName, mobile, null, accountNo,
                    marketAccountNo, merchantStatus, null, null, model, rawAddTime, rawUpdateTime, rawAddTime,
                    rawUpdateTime);
        }
        //第二个商家
        if (StringUtils.isNotBlank(partnerId1) && StringUtils.isNotBlank(partnerName1)) {
            xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId1);
            xybMerchantTestBase.insertMerchantInfo(0L, partnerId1, partnerId1, null, null, partnerName1, null, null,
                    "INSIDE", "PLATFORM", "ACTIVE", GID.newGID(), "MD5", null, null,
                    null);
            //插入神马付会员
            xybUserTestBase.cleanUserByUserId(partnerId1);
            xybUserTestBase.insertUser(0L, partnerId1, null, partnerId1, PLAT_PARTNER_ID, null, null,
                    RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                    com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                    partnerName1, null, null, null, null,
                    null, null, null, null, null, mobile1, null, null,
                    null, partnerId1, null, rawAddTime, rawUpdateTime);
            //插入神马付商户标准账户信息
            xybUserTestBase.cleanAccountByUserId(partnerId1);
            xybUserTestBase.cleanAccountByAccountNo(accountNo1);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId1, accountNo1, null, partnerId1, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", accountNo1, "加好油自动化测试标准账户", rawAddTime, rawUpdateTime);
            //插入神马付商户营销账户信息
            xybUserTestBase.cleanAccountByAccountNo(marketAccountNo1);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId1, marketAccountNo1, null, partnerId1, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "gas_merchant_market_account_tag", "加好油自动化测试营销账户",
                    rawAddTime, rawUpdateTime);
            //插入神马付商户资金池账户信息
            xybUserTestBase.cleanAccountByAccountNo(poolAccountNo1);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId1, poolAccountNo1, null, partnerId1, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试资金池账户", rawAddTime, rawUpdateTime);
            //加好油商户
            merchantTestBase.cleanGasMerchantByPartnerId(partnerId1);
            merchantTestBase.cleanGasMerchantByPartnerName(partnerName1);
            merchantTestBase.insertGasMerchant(0L, partnerId1, partnerId1, partnerName1, shortName1, mobile1, null,
                    accountNo1, marketAccountNo1, merchantStatus1, null, null, model1, "1", "0*60*60*1000+0*60*1000+0" +
                            "*1000", rawAddTime, rawUpdateTime);
            //商户来源信息
            merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId1);
            merchantTestBase.insertGasMerchantSourceData(0L, partnerId1, partnerId1, SourceType.WeChat.code(),
                    sourceKey1, Byte.valueOf("0"), null, rawAddTime, rawUpdateTime, null, null, null, null);
            //分析数据
            silverboltTestBase.cleanGasMerchantByPartnerId(partnerId1);
            silverboltTestBase.insertGasMerchant(0L, partnerId1, partnerName1, shortName1, mobile1, null, accountNo1,
                    marketAccountNo1, merchantStatus1, null, null, model1, rawAddTime, rawUpdateTime, rawAddTime,
                    rawUpdateTime);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", partnerId);
        return param;
    }

    /**
     * 数据应用场景：同一个平台商下造未授权商户用，可通过改变入参的方式重复使用此方法来造多个商家
     * 参数设计说明：partnerId：商户号，partnerName：商户名称，shortName：商户简称,sourceKey:来源标识
     * accountNo：商户标准户，marketAccountNo：商户营销账户，mobile：商户手机，merchantStatus：商户状态
     */
    public Map<String, Object> initGasMerchant(String partnerId, String partnerName, String sourceKey,
                                               String shortName, String accountNo, String marketAccountNo,
                                               String poolAccountNo, String model,
                                               String mobile, String merchantStatus) {

        //第一个商家
        if (StringUtils.isNotBlank(partnerId) && StringUtils.isNotBlank(partnerName)) {
            xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
            xybMerchantTestBase.insertMerchantInfo(0L, partnerId, partnerId, null, null, partnerName, null, null,
                    "INSIDE", "PLATFORM", "ACTIVE", GID.newGID(), "MD5", null, null,
                    null);
            //插入神马付会员
            xybUserTestBase.cleanUserByUserId(partnerId);
            xybUserTestBase.insertUser(0L, partnerId, null, partnerId, PLAT_PARTNER_ID, null, null,
                    RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                    com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                    partnerName, null, null, null, null,
                    null, null, null, null, null, mobile, null, null,
                    null, partnerId, null, null, null);
            //插入神马付商户标准账户信息
            xybUserTestBase.cleanAccountByUserId(partnerId);
            xybUserTestBase.cleanAccountByAccountNo(accountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, accountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "GAS_DUMMY_DEFAULT", "加好油自动化测试标准账户", null, null);
            //插入神马付商户营销账户信息
            xybUserTestBase.cleanAccountByAccountNo(marketAccountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, marketAccountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "gas_merchant_market_account_tag", "加好油自动化测试营销账户", null,
                    null);
            //插入神马付商户资金池账户信息
            xybUserTestBase.cleanAccountByAccountNo(poolAccountNo);
            xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, poolAccountNo, null, partnerId, 0L,
                    0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试资金池账户", null, null);
            //加好油商户
            merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
            merchantTestBase.cleanGasMerchantByPartnerName(partnerName);
            merchantTestBase.insertGasMerchant(0L, partnerId, partnerId, partnerName, shortName, mobile, null,
                    accountNo, marketAccountNo, merchantStatus, null, null, model, "1", "0*60*60*1000+0*60*1000+0" +
                            "*1000", null, null);
            //商户来源信息
            merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
            merchantTestBase.cleanGasMerchantSourceDataBySourceTypeAndSourceKey(SourceType.WeChat.code(), sourceKey);
            merchantTestBase.insertGasMerchantSourceData(0L, partnerId, partnerId, SourceType.WeChat.code(),
                    sourceKey, Byte.valueOf("0"), null, null, null, null, null, null, null);
            //分析数据
            silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
            silverboltTestBase.cleanGasMerchantByPartnerName(partnerName);
            silverboltTestBase.insertGasMerchant(0L, partnerId, partnerName, shortName, mobile, null, accountNo,
                    marketAccountNo, merchantStatus, null, null, model, null, null, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", partnerId);
        return param;
    }

    /**
     * 数据应用场景：一个商家下多个油站，商家基础数据需要预先造好
     * 参数设计说明：platPartnerId：平台商ID，partnerId：签约商ID，stationId：油站ID，stationName：油站名称
     * stationCode：油站编码，stationStatus：油站状态
     * <p>
     * 当油站能独立收银时，平台商ID和签约商ID不一样，对应的商家的数收款模式应为商家油站
     * 返回值：商家ID。可根据需要自行添加
     */
    public Map<String, Object> initStationsWithOneMerchant(String platPartnerId, String platPartnerId1,
                                                           String partnerId, String partnerId1,
                                                           String stationId, String stationId1,
                                                           String stationName, String stationName1,
                                                           String stationCode, String stationCode1,
                                                           String stationStatus, String stationStatus1) {

        //第一个商家
        if (StringUtils.isNotBlank(platPartnerId)) {
            //第一个油站
            if (StringUtils.isNotBlank(stationId)) {
                merchantTestBase.cleanGasMerchantStationByStationId(stationId);
                merchantTestBase.cleanGasMerchantStationByStationName(stationName);
                merchantTestBase.insertGasMerchantStation(0L, stationId, partnerId, platPartnerId, stationName,
                        stationCode, "6589554444", stationStatus, null, 500000L, 500100L, 500112L, "互联网产业园",
                        106.49713792,
                        29.6279712135, null, null);
                //分析数据
                silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
                silverboltTestBase.insertGasMerchantStation(0L, partnerId, platPartnerId, stationId, stationName,
                        stationCode, "6589554444", stationStatus, null, 500000L, "重庆市", 500100L, "市辖区", 500112L,
                        "渝北区", "互联网产业园"
                        , 106.49713792, 29.6279712135, null, null, null, null);
            }
            //独立收银油站需要清结算造数据
            if (platPartnerId != partnerId) {
                xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
                xybMerchantTestBase.insertMerchantInfo(0L, partnerId, platPartnerId, null, null, stationName, null,
                        null,
                        "INSIDE", "PARTNER", "ACTIVE", GID.newGID(), "MD5", null, null,
                        null);
                //插入神马付会员
                xybUserTestBase.cleanUserByUserId(partnerId);
                xybUserTestBase.insertUser(0L, partnerId, null, platPartnerId, platPartnerId, null, null,
                        RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                        com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                        stationName, null, null, null, null,
                        null, null, null, null, null, "6589554444", null, null,
                        null, partnerId, null, null, null);
                //插入神马付商户标准账户信息
                xybUserTestBase.cleanAccountByUserId(partnerId);
                xybUserTestBase.insertAccount(0L, platPartnerId, partnerId, OID.newID(), null, partnerId
                        , 0L, 0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
            }
        }
        if (StringUtils.isNotBlank(platPartnerId1)) {
            //第二个油站
            if (StringUtils.isNotBlank(stationId1)) {
                merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
                merchantTestBase.cleanGasMerchantStationByStationName(stationName1);
                merchantTestBase.insertGasMerchantStation(0L, stationId1, partnerId1, platPartnerId1, stationName1,
                        stationCode1, "6589555555", stationStatus1, null, 420000L, 420200L, 420202L, "XXXXXX",
                        116.475011048,
                        40.0015582941, null, null);
                //分析数据
                silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
                silverboltTestBase.insertGasMerchantStation(0L, partnerId1, platPartnerId1, stationId1, stationName1,
                        stationCode1, "6589555555", stationStatus1, null, 420000L, "湖北省", 420200L, "黄石市", 420202L,
                        "黄石港区",
                        "XXXXXX", 116.475011048, 40.0015582941,
                        null, null, null, null);
            }
            //独立收银油站需要清结算造数据
            if (platPartnerId1 != partnerId1) {
                xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId1);
                xybMerchantTestBase.insertMerchantInfo(0L, partnerId1, platPartnerId1, null, null, stationName1,
                        null, null, "INSIDE", "PARTNER", "ACTIVE",
                        GID.newGID(), "MD5", null, null, null);
                //插入神马付会员
                xybUserTestBase.cleanUserByUserId(partnerId1);
                xybUserTestBase.insertUser(0L, partnerId1, null, platPartnerId1, platPartnerId1, null, null,
                        RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                        com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                        stationName1, null, null, null, null,
                        null, null, null, null, null, "6589555555", null, null,
                        null, partnerId1, null, null, null);
                //插入神马付商户标准账户信息
                xybUserTestBase.cleanAccountByUserId(partnerId1);
                xybUserTestBase.insertAccount(0L, platPartnerId1, partnerId1, OID.newID(), null,
                        partnerId1, 0L, 0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
            }
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", partnerId);
        return param;
    }

    /**
     * 带有油站经纬度的，一键加油相关接口造数据建议用此方法
     * 参数设计说明：platPartnerId：平台商ID，partnerId：签约商ID，stationId：油站ID，stationName：油站名称
     * stationCode：油站编码，stationStatus：油站状态
     * <p>
     * 当油站能独立收银时，平台商ID和签约商ID不一样，对应的商家的数收款模式应为商家油站
     * 返回值：商家ID。可根据需要自行添加
     */
    public Map<String, Object> initStationsWithLocation(String platPartnerId, String platPartnerId1,
                                                        String partnerId, String partnerId1,
                                                        String stationId, String stationId1,
                                                        String stationName, String stationName1,
                                                        String stationCode, String stationCode1,
                                                        Double longitude, Double longitude1,
                                                        Double latitude, Double latitude1,
                                                        String stationStatus, String stationStatus1) {

        //第一个商家
        if (StringUtils.isNotBlank(platPartnerId)) {
            //第一个油站
            if (StringUtils.isNotBlank(stationId)) {
                merchantTestBase.cleanGasMerchantStationByStationId(stationId);
                merchantTestBase.cleanGasMerchantStationByStationName(stationName);
                merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
                merchantTestBase.insertGasMerchantStation(0L, stationId, partnerId, platPartnerId, stationName,
                        stationCode, "655555555", stationStatus, null, 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼",
                        longitude, latitude, null,
                        null);
                //分析数据
                silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
                silverboltTestBase.cleanGasMerchantStationByStationName(stationName);
                silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
                silverboltTestBase.insertGasMerchantStation(0L, partnerId, platPartnerId, stationId, stationName,
                        stationCode, "655555555", stationStatus, null, 500000L, "重庆", 500100L, "渝北", 500112L, "互联网产业园",
                        "金开大道互联网产业园13幢3楼", longitude, latitude,
                        null, null, null, null);
            }
            //独立收银油站需要清结算造数据
            if (platPartnerId != partnerId) {
                xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
                xybMerchantTestBase.insertMerchantInfo(0L, partnerId, platPartnerId, null, null, stationName,
                        null, null, "INSIDE", "PARTNER", "ACTIVE",
                        GID.newGID(), "MD5", null, null, null);
                //插入神马付会员
                xybUserTestBase.cleanUserByUserId(partnerId);
                xybUserTestBase.insertUser(0L, partnerId, null, platPartnerId, platPartnerId, null, null,
                        RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                        com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                        stationName, null, null, null, null,
                        null, null, null, null, null, "655555555", null, null,
                        null, partnerId, null, null, null);
                //插入神马付商户标准账户信息
                xybUserTestBase.cleanAccountByUserId(partnerId);
                xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, OID.newID(), null, partnerId
                        , 0L, 0L, 0L, 0L, 0L, "ACTIVE",
                        "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
            }
        }
        if (StringUtils.isNotBlank(platPartnerId1)) {
            //第二个油站
            if (StringUtils.isNotBlank(stationId1)) {
                merchantTestBase.cleanGasMerchantStationByStationId(stationId1);
                merchantTestBase.cleanGasMerchantStationByStationName(stationName1);
                merchantTestBase.cleanGasMerchantStationByStationCode(stationCode1);
                merchantTestBase.insertGasMerchantStation(0L, stationId1, partnerId1, platPartnerId1, stationName1,
                        stationCode1, "644444", stationStatus1, null, 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼",
                        longitude1, latitude1, null
                        , null);
                //分析数据
                silverboltTestBase.cleanGasMerchantStationByStationId(stationId1);
                silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode1);
                silverboltTestBase.cleanGasMerchantStationByStationName(stationName1);
                silverboltTestBase.insertGasMerchantStation(0L, partnerId1, platPartnerId1, stationId1, stationName1,
                        stationCode1, "644444", stationStatus1, null, 500000L, "重庆", 500100L, "渝北", 500112L, "互联网产业园",
                        "金开大道互联网产业园13幢3楼", longitude1, latitude1,
                        null, null, null, null);
            }
            //独立收银油站需要清结算造数据
            if (platPartnerId1 != partnerId1) {
                xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId1);
                xybMerchantTestBase.insertMerchantInfo(0L, partnerId1, platPartnerId1, null, null, stationName1,
                        null, null, "INSIDE", "PARTNER",
                        "ACTIVE", GID.newGID(), "MD5", null, null, null);
                //插入神马付会员
                xybUserTestBase.cleanUserByUserId(partnerId1);
                xybUserTestBase.insertUser(0L, partnerId1, null, platPartnerId1, platPartnerId1, null, null,
                        RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                        com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                        stationName1, null, null, null, null,
                        null, null, null, null, null, "644444", null, null,
                        null, partnerId1, null, null, null);
                //插入神马付商户标准账户信息
                xybUserTestBase.cleanAccountByUserId(partnerId1);
                xybUserTestBase.insertAccount(0L, platPartnerId1, partnerId1, OID.newID(), null,
                        partnerId1, 0L, 0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
            }
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", partnerId);
        return param;
    }

    /**
     * 数据应用场景：准备终端资源基础数据(父级)
     * 返回参数：parentId父级id。可根据需要自行添加
     */
    public Map<String, Object> initDeviceResource(String deviceType, String resourceType,
                                                  String name, String code) {
        merchantTestBase.cleanGasDeviceResourceByCode(code);
        merchantTestBase.insertGasDeviceResource(0L, deviceType, null, name, code, null, resourceType, null, null,
                null, null, null);
        Long parentId = merchantTestBase.findGasDeviceResourceByName(name).get(0).getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("partnerId", parentId);
        return param;
    }

    /**
     * 数据应用场景：准备终端资源基础数据(子级)
     * 返回参数：parentId父级id,childId子级id。可根据需要自行添加
     */
    public Map<String, Object> initDeviceResourceChild(String deviceType, String fatherType, String type,
                                                       String fatherName, String name, String fatherCode, String code) {
        Long parentId = null;
        if (StringUtils.isNotBlank(fatherName)) {
            merchantTestBase.cleanGasDeviceResourceByName(fatherName);
            merchantTestBase.insertGasDeviceResource(0L, deviceType, null, fatherName, fatherCode, null, fatherType,
                    null, null, null, null, null);
            parentId = merchantTestBase.findGasDeviceResourceByName(fatherName).get(0).getId();
        }
        merchantTestBase.cleanGasDeviceResourceByCode(code);
        merchantTestBase.insertGasDeviceResource(0L, deviceType, parentId, name, code, null, type, null, null
                , null, null, null);
        Long childId = merchantTestBase.findGasDeviceResourceByName(name).get(0).getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("parentId", parentId);
        param.put("childId", childId);
        return param;
    }

    /**
     * 数据应用场景：准备角色数据，parentName不传，则添加的角色没有上级角色
     * 返回参数：parentId父级id,childId子级id。可根据需要自行添加
     */
    public Map<String, Object> initGasRole(String roleName, String parentName,
                                           String roleType, String parentType) {
        Long parentId = null;
        if (StringUtils.isNotBlank(parentName)) {
            merchantTestBase.cleanGasRoleByRoleName(parentName);
            merchantTestBase.insertGasRole(0L, parentType, null, parentName, null, null, null);
            parentId = merchantTestBase.findGasRoleByRoleName(parentName).get(0).getId();
        }
        merchantTestBase.cleanGasRoleByRoleName(roleName);
        merchantTestBase.insertGasRole(0L, roleType, parentId, roleName, null, null, null);
        Long childId = merchantTestBase.findGasRoleByRoleName(roleName).get(0).getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("parentId", parentId);
        param.put("childId", childId);
        return param;
    }

    /**
     * 数据应用场景：一个角色关联一个或多个资源,roleId必填,资源的终端类型为BOSS
     * 返回值：根据需要自行添加
     */
    public Map<String, Object> initGasRoleResource(Long roleId, Long resourceId,
                                                   Long resourceId1, Long resourceId2) {
        if (resourceId != null && StringUtils.isNotBlank(resourceId.toString())) {
            merchantTestBase.cleanGasMerchantRoleResourceByResourceId(resourceId);
            merchantTestBase.insertGasMerchantRoleResource(0L, roleId, resourceId);
        }
        if (resourceId1 != null && StringUtils.isNotBlank(resourceId1.toString())) {
            merchantTestBase.cleanGasMerchantRoleResourceByResourceId(resourceId1);
            merchantTestBase.insertGasMerchantRoleResource(0L, roleId, resourceId1);
        }
        if (resourceId2 != null && StringUtils.isNotBlank(resourceId2.toString())) {
            merchantTestBase.cleanGasMerchantRoleResourceByResourceId(resourceId2);
            merchantTestBase.insertGasMerchantRoleResource(0L, roleId, resourceId2);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 数据应用场景：一个商户关联一个或多个资源,platPartnerId必填，资源的终端类型为POS
     * 返回值：根据需要自行添加
     */
    public Map<String, Object> initGasMerchantResource(String platPartnerId, Long resourceId,
                                                       Long resourceId1, Long resourceId2) {
        if (resourceId != null && StringUtils.isNotBlank(resourceId.toString())) {
            merchantTestBase.cleanGasMerchantResourceByResourceId(resourceId);
            merchantTestBase.insertGasMerchantResource(0L, platPartnerId, resourceId);
        }
        if (resourceId1 != null && StringUtils.isNotBlank(resourceId1.toString())) {
            merchantTestBase.cleanGasMerchantResourceByResourceId(resourceId1);
            merchantTestBase.insertGasMerchantResource(0L, platPartnerId, resourceId1);
        }
        if (resourceId2 != null && StringUtils.isNotBlank(resourceId2.toString())) {
            merchantTestBase.cleanGasMerchantResourceByResourceId(resourceId2);
            merchantTestBase.insertGasMerchantResource(0L, platPartnerId, resourceId2);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 数据应用场景：一个商户关联一个或多个角色（需要预先造商家、角色数据）
     * 返回值：根据需要自行添加
     */
    public Map<String, Object> initGasMerchantRole(String platPartnerId, Long roleId, Long roleId1, Long roleId2,
                                                   Long roleId3, Long roleId4) {
        merchantTestBase.cleanGasMerchantRoleByPlatPartnerId(platPartnerId);
        if (roleId != null && StringUtils.isNotBlank(roleId.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId);
        }
        if (roleId1 != null && StringUtils.isNotBlank(roleId1.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId1);
        }
        if (roleId2 != null && StringUtils.isNotBlank(roleId2.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId2);
        }
        if (roleId3 != null && StringUtils.isNotBlank(roleId3.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId3);
        }
        if (roleId4 != null && StringUtils.isNotBlank(roleId4.toString())) {
            merchantTestBase.insertGasMerchantRole(0L, platPartnerId, roleId4);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 数据应用场景：准备商品基础信息
     * 返回参数：商品id。可根据需要自行添加
     */
    public Map<String, Object> initGasGoods(String goodsCode, String goodsType, String goodsGroupType,
                                            String goodsName, Date rawAddTime, Date rawUpdateTime) {
        merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        merchantTestBase.insertGasGoods(0L, goodsType, goodsGroupType, null, goodsName, goodsCode, null, null, null,
                null, rawAddTime,
                rawUpdateTime);
        Long id = merchantTestBase.findGasGoodsByGoodsCode(goodsCode).get(0).getId();
        //分析数据
        silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
        silverboltTestBase.insertGasGoods(0L, goodsType, goodsGroupType, null, goodsName, goodsCode, null, rawAddTime
                , rawUpdateTime);
        Map<String, Object> param = Maps.newHashMap();
        param.put("goodsId", id);
        return param;
    }

    /**
     * 数据应用场景：准备配有油枪的油站信息,不传油枪号则只会添加油站信息
     * 返回参数：可根据需要自行添加
     */
    public Map<String, Object> initStationsWithOilGun(String partnerId, String stationId, String stationName,
                                                      String stationCode, String phoneNo, String status,
                                                      String goodsName, String goodsCode,
                                                      String oilGunNo, Date rawAddTime,
                                                      Date rawUpdateTime) {
        //油品信息（目前添加油枪时没校验油枪号对应的油品是否存在，所以可以先不用准备油品数据）
        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
        merchantTestBase.insertGasMerchantGoods(0L, partnerId, partnerId, goodsName, goodsCode, GoodsType.OIL.code(),
                null, null, null, null, null, null, "ABLE", rawAddTime, rawUpdateTime);
        //油站
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationName(stationName);
        merchantTestBase.insertGasMerchantStation(0L, stationId, partnerId, partnerId, stationName, stationCode,
                phoneNo, status, Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, rawAddTime, rawUpdateTime);
        //油枪
        if (StringUtils.isNotBlank(oilGunNo)) {
            merchantTestBase.cleanGasStationOilGunByStationId(stationId);
            merchantTestBase.insertGasStationOilGun(0L, partnerId, partnerId, stationId, oilGunNo, goodsCode,
                    rawAddTime, rawUpdateTime, 1);
        }
        //分析数据
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationName(stationName);
        silverboltTestBase.insertGasMerchantStation(0L, partnerId, partnerId, stationId, stationName, stationCode,
                phoneNo, status, Byte.valueOf("0"), 500000L, "重庆", 500100L, "渝北", 500112L, "互联网产业园", "金开大道互联网产业园13幢3" +
                        "楼", 106.489838082, 29.6219092167, rawAddTime,
                rawUpdateTime, rawAddTime, rawUpdateTime);
        Map<String, Object> param = Maps.newHashMap();
//        param.put("goodsId", id);
        return param;
    }

    /**
     * 准备带有收银员的油站信息
     */
    public Map<String, Object> initStationsWithOperator(String partnerId, String stationId, String stationName,
                                                        String stationCode, String userId, String userType,
                                                        Long roleId, String account, String password,
                                                        String phoneNo, String status,
                                                        String goodsCode, String oilGunNo,
                                                        Date loginTime, Date rawAddTime,
                                                        Date rawUpdateTime) {
        //油品信息（目前添加油枪时没校验油枪号对应的油品是否存在，所以可以先不用准备油品数据）
//        merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
//        merchantTestBase.insertGasMerchantGoods(0L, partnerId, partnerId, null, goodsCode, GoodsType.OIL.code(),
//        null, null, "ABLE", rawAddTime, rawUpdateTime);
        //油站
        merchantTestBase.cleanGasMerchantStationByStationId(stationId);
        merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        merchantTestBase.insertGasMerchantStation(0L, stationId, partnerId, partnerId, stationName, stationCode,
                phoneNo, status, Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, rawAddTime, rawUpdateTime);
        //油枪
        if (StringUtils.isNotBlank(oilGunNo)) {
            merchantTestBase.cleanGasStationOilGunByStationId(stationId);
            merchantTestBase.insertGasStationOilGun(0L, partnerId, partnerId, stationId, oilGunNo, goodsCode,
                    rawAddTime, rawUpdateTime, 1);
        }
        //分析数据
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
        silverboltTestBase.insertGasMerchantStation(0L, partnerId, partnerId, stationId, stationName, stationCode,
                phoneNo, status, Byte.valueOf("0"), 500000L, "重庆", 500100L, "渝北", 500112L, "互联网产业园", "金开大道互联网产业园13幢3" +
                        "楼", 106.489838082, 29.6219092167, rawAddTime,
                rawUpdateTime, rawAddTime, rawUpdateTime);
        //操作员
        String uqKey = null;
        if (com.xyb.gas.merchant.api.enums.UserType.BOSS.code().equals(userType)) {
            uqKey = account;
        }
        if (com.xyb.gas.merchant.api.enums.UserType.DEVICE.code().equals(userType) || com.xyb.gas.merchant.api.enums.UserType.UNLOGIN.code().equals(userType)) {
            uqKey = String.join("_", partnerId, account);
        }
        if (StringUtils.isNotBlank(partnerId)) {
            merchantTestBase.cleanGasMerchantUserByUserId(userId);
            merchantTestBase.insertGasMerchantUser(0L, userId, roleId, null, userType, partnerId, partnerId, "用户名",
                    phoneNo, account, encrypt(password, null), null,
                    com.xyb.gas.merchant.api.enums.UserStatus.NORMAL.code(),
                    uqKey, 0, 5, loginTime, loginTime, null, rawAddTime, loginTime);
            //分析
            silverboltTestBase.cleanGasMerchantUserByUserId(userId);
            silverboltTestBase.insertGasMerchantUser(0L, partnerId, userId, roleId, null, userType, "用户名",
                    phoneNo, account, encrypt(password, null), null,
                    com.xyb.gas.merchant.api.enums.UserStatus.NORMAL.code(),
                    uqKey, 0, 5, loginTime, loginTime, null, rawAddTime, loginTime, rawAddTime, loginTime);
        }
        //关系
        if (StringUtils.isNotBlank(stationId)) {
            merchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
            merchantTestBase.insertGasMerchantUserStation(0L, userId, stationId);
            //分析
            silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
            silverboltTestBase.insertGasMerchantUserStation(0L, partnerId, userId, roleId, userType, "用户名", phoneNo,
                    account, "NORMAL", stationId, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
//        param.put("goodsId", id);
        return param;
    }

    /**
     * 数据应用场景：准备商家操作员数据
     */
    public void initGasMerchantUser(String platPartnerId, String userId,
                                    String roleNo, String userType,
                                    String mobile, String password, String account) {
        String uqKey = null;
        if (com.xyb.gas.merchant.api.enums.UserType.BOSS.code().equals(userType)) {
            uqKey = account;
        }
        if (com.xyb.gas.merchant.api.enums.UserType.DEVICE.code().equals(userType) || com.xyb.gas.merchant.api.enums.UserType.UNLOGIN.code().equals(userType)) {
            uqKey = String.join("_", platPartnerId, account);
        }
        if (StringUtils.isNotBlank(platPartnerId)) {
            merchantTestBase.cleanGasMerchantUserByUserId(userId);
            merchantTestBase.insertGasMerchantUser(0L, userId, null, roleNo, userType, platPartnerId, platPartnerId,
                    "用户名",
                    mobile, account, encrypt(password, null), null,
                    com.xyb.gas.merchant.api.enums.UserStatus.NORMAL.code(),
                    uqKey, 0, 5, null, null, null, null, null);
            //分析
            silverboltTestBase.cleanGasMerchantUserByUserId(userId);
            silverboltTestBase.insertGasMerchantUser(0L, platPartnerId, userId, null, roleNo, userType, "用户名",
                    mobile, account, encrypt(password, null), null,
                    com.xyb.gas.merchant.api.enums.UserStatus.NORMAL.code(),
                    uqKey, 0, 5, null, null, null, null, null, null, null);
        }
    }

    /**
     * 数据应用场景：准备商家操作员数据
     */
    public void initGasMerchantUserWithTime(String platPartnerId, String userId,
                                            String userName, String roleNo, String userType,
                                            String mobile, String password, String account,
                                            Date lastLoginTime, Date lastLoginSuccessTime,
                                            Date lastLogOutTime) {
        String uqKey = null;
        if (com.xyb.gas.merchant.api.enums.UserType.BOSS.code().equals(userType)) {
            uqKey = account;
        }
        if (com.xyb.gas.merchant.api.enums.UserType.DEVICE.code().equals(userType) || com.xyb.gas.merchant.api.enums.UserType.UNLOGIN.code().equals(userType)) {
            uqKey = String.join("_", platPartnerId, account);
        }
        if (StringUtils.isNotBlank(platPartnerId)) {
            merchantTestBase.cleanGasMerchantUserByUserId(userId);
            merchantTestBase.insertGasMerchantUser(0L, userId, null, roleNo, userType, platPartnerId, platPartnerId,
                    userName,
                    mobile, account, encrypt(password, null), null,
                    com.xyb.gas.merchant.api.enums.UserStatus.NORMAL.code(),
                    uqKey, 0, 5, lastLoginTime, lastLoginSuccessTime, lastLogOutTime, null, null);
            //分析
            silverboltTestBase.cleanGasMerchantUserByUserId(userId);
            silverboltTestBase.insertGasMerchantUser(0L, platPartnerId, userId, null, roleNo, userType, userName,
                    mobile, account, encrypt(password, null), null,
                    com.xyb.gas.merchant.api.enums.UserStatus.NORMAL.code(),
                    uqKey, 0, 5, lastLoginTime, lastLoginSuccessTime, lastLogOutTime, null, null, null, null);
        }
    }

    /**
     * 准备商城商品数据
     * 适用场景：查询修改商城数据可用，兑换商品不建议使用此方法准备数据
     */
    public Map<String, Object> initMallExchangeGoodsSimple(String platPartnerId, String goodsId,
                                                           String goodsName, String goodsType,
                                                           String goodsImg,
                                                           String gainStyle, String stationId) {

        Long id = 0L;
        if (StringUtils.isNotBlank(goodsId)) {
            merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
            merchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId, platPartnerId, goodsType,
                    goodsName, null, goodsImg, null, null, 100, 100, 0, 1, gainStyle, stationId, 0, null, null);
            id = merchantTestBase.findGasMallExchangeGoodsByGoodsId(goodsId).get(0).getId();
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("id", id);
        return param;
    }

    /**
     * 准备商城商品数据
     * 适用场景：兑换商品准备数据
     */
    public Map<String, Object> initMallExchangeGoods(String platPartnerId, String goodsId,
                                                     String goodsName, String goodsType,
                                                     String goodsImg,
                                                     String gainStyle, String stationId) {

        Long id = 0L;
        if (StringUtils.isNotBlank(goodsId)) {
            merchantTestBase.cleanGasMallExchangeGoodsByGoodsId(goodsId);
            merchantTestBase.insertGasMallExchangeGoods(0L, goodsId, platPartnerId, platPartnerId, goodsType,
                    goodsName, null, goodsImg, null, null, 100, 100, 0, 1, gainStyle, stationId, 0, null, null);
            id = merchantTestBase.findGasMallExchangeGoodsByGoodsId(goodsId).get(0).getId();
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("id", id);
        return param;
    }

    /**
     * 准备制卡规则数据
     * 适用场景：只适用于分页查询制卡规则,一个商户下多个制卡规则
     */
    public Map<String, Object> initCardRules(String platPartnerId, String accont,
                                             String memo, Integer start, Integer start1, Integer end, Integer end1,
                                             Integer vaildCount, Integer vaildCount1,
                                             Date rawAddTime, Date rawAddTime1) {

        if (start != null && end != null) {
            merchantTestBase.insertGasMerchantCardRule(0L, platPartnerId, platPartnerId, start, end, null,
                    null, vaildCount, accont, memo, rawAddTime, rawAddTime);
        }
        if (start1 != null && end1 != null) {
            merchantTestBase.insertGasMerchantCardRule(0L, platPartnerId, platPartnerId, start1, end1, null,
                    null, vaildCount1, accont, memo, rawAddTime1, rawAddTime1);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 准备制卡卡号数据
     * 适用场景：一个商户下一个制卡规则生成的多张卡
     */
    public Map<String, Object> initGasMerchantCard(String platPartnerId, Long cardRuleId, String account,
                                                   String cardNo, String cardNo1, String cardNo2, String cardNo3) {

        if (StringUtils.isNotBlank(cardNo)) {
            merchantTestBase.cleanGasMerchantCardByCardNo(cardNo);
            merchantTestBase.insertGasMerchantCard(0L, platPartnerId, platPartnerId, null, "ENTITY", "DEFAULT",
                    null, cardNo, null, cardRuleId, account, null, null);
        }
        if (StringUtils.isNotBlank(cardNo1)) {
            merchantTestBase.cleanGasMerchantCardByCardNo(cardNo1);
            merchantTestBase.insertGasMerchantCard(0L, platPartnerId, platPartnerId, null, "ENTITY", "DEFAULT",
                    null, cardNo1, null, cardRuleId, account, null, null);
        }
        if (StringUtils.isNotBlank(cardNo2)) {
            merchantTestBase.cleanGasMerchantCardByCardNo(cardNo2);
            merchantTestBase.insertGasMerchantCard(0L, platPartnerId, platPartnerId, null, "ENTITY", "DEFAULT",
                    null, cardNo2, null, cardRuleId, account, null, null);
        }
        if (StringUtils.isNotBlank(cardNo3)) {
            merchantTestBase.cleanGasMerchantCardByCardNo(cardNo3);
            merchantTestBase.insertGasMerchantCard(0L, platPartnerId, platPartnerId, null, "ENTITY", "DEFAULT",
                    null, cardNo3, null, cardRuleId, account, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 用户登录日志表
     * 适用场景：只有登录，还未登出
     * 参数：flag用于标识是否需要删除同一操作员的登录记录；当flag为true时，之前造的相同的操作员的登录记录会被删除
     * 反之则不会
     */
    public Map<String, Object> initGasLoginLogWithLogin(boolean flag, String platPartnerId, String partnerName,
                                                        String stationId, String stationName,
                                                        String userId, String userName, String account,
                                                        String deviceCode, Date loginTime) {
        if (StringUtils.isNotBlank(platPartnerId)) {
            if (flag) {
                merchantTestBase.cleanGasLoginLogByUserId(userId);
            }
            merchantTestBase.insertGasLoginLog(0L, DeviceType.POS.code(), userId, account, platPartnerId,
                    platPartnerId, partnerName, stationId, stationName, userName, deviceCode, loginTime, null,
                    loginTime, loginTime);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 用户登录日志表
     * 适用场景：用户已经登出
     * 参数：flag用于标识是否需要删除同一操作员的登录记录；当flag为true时，之前造的相同的操作员的登录记录会被删除
     * 反之则不会
     */
    public Map<String, Object> initGasLoginLogWithLogOut(boolean flag, String platPartnerId, String partnerName,
                                                         String stationId, String stationName,
                                                         String userId, String userName, String account,
                                                         String deviceCode, Date loginTime, Date loginOutTime) {
        if (StringUtils.isNotBlank(platPartnerId)) {
            if (flag) {
                merchantTestBase.cleanGasLoginLogByUserId(userId);
            }
            merchantTestBase.insertGasLoginLog(0L, DeviceType.POS.code(), userId, account, platPartnerId,
                    platPartnerId, partnerName, stationId, stationName, userName, deviceCode, loginTime, loginOutTime,
                    loginTime, loginOutTime);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 准备商家终端配置信息
     */
    public Map<String, Object> initGasMerchantDevice(String platPartnerId, String userId,
                                                     String deviceCode, String loginStatus) {
        if (StringUtils.isNotBlank(deviceCode)) {
            merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
            merchantTestBase.insertGasMerchantDevice(0L, platPartnerId, platPartnerId,
                    DeviceType.POS.code(), deviceCode, loginStatus, userId, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 准备终端小票配置信息
     */
    public Map<String, Object> initGasDevicePrint(String platPartnerId, String printId,
                                                  String stationId, String printType,
                                                  String printTitle, int sleepTime) {
        if (StringUtils.isNotBlank(printId)) {
            merchantTestBase.cleanGasDevicePrintByPrintId(printId);
            merchantTestBase.insertGasDevicePrint(0L, printId, platPartnerId, platPartnerId, stationId,
                    DeviceType.POS.code(), printType, printTitle, sleepTime, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 准备一键加油设置信息
     */
    public Map<String, Object> initGasDeviceFunction(String platPartnerId, String userId,
                                                     String stationId, String deviceCode) {
        if (StringUtils.isNotBlank(stationId)) {
            merchantTestBase.cleanGasMerchantDeviceFunctionByStationId(stationId);
            merchantTestBase.insertGasMerchantDeviceFunction(0L, platPartnerId, platPartnerId, stationId, "ONE_KEY",
                    Byte.valueOf("1")
                    , DeviceType.POS.code(), deviceCode, userId, null, null);
        }
        Long id = merchantTestBase.findGasMerchantDeviceFunctionByStationId(stationId).get(0).getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("id", id);
        return param;
    }

    /**
     * 会员中心规则说明
     */
    public Map<String, Object> initGasRuleDesc(String platPartnerId, String ruleType,
                                               String dec) {
        if (StringUtils.isNotBlank(platPartnerId)) {
            merchantTestBase.cleanGasRuleDescriptionByPlatPartnerId(platPartnerId);
            merchantTestBase.insertGasRuleDescription(0, platPartnerId, platPartnerId, ruleType, null, null, dec);
        }
        Integer id =
                merchantTestBase.findGasRuleDescriptionByPlatPartnerId(platPartnerId).stream().filter(des -> (ruleType.equals(des.getRuleType()))).findFirst().get().getId();
        Map<String, Object> param = Maps.newHashMap();
        param.put("id", id);
        return param;
    }

    /**
     * 商家商品配置表
     */
    public Map<String, Object> initGasMerchantGoods(String platPartnerId,
                                                    String goodsGroupType, String goodsType,
                                                    String goodsName, String goodsCode,
                                                    String goodsGroupType1, String goodsType1,
                                                    String goodsName1, String goodsCode1,
                                                    String goodsGroupType2, String goodsType2,
                                                    String goodsName2, String goodsCode2) {
        if (StringUtils.isNotBlank(goodsCode)) {
            merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
            merchantTestBase.insertGasGoods(0L, goodsType, goodsGroupType, null, goodsName, goodsCode, null, null,
                    null, null, null,
                    null);
            merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
            merchantTestBase.insertGasMerchantGoods(0L, platPartnerId, platPartnerId, goodsName, goodsCode, goodsType
                    , goodsGroupType, null, null, null, null, null, "ABLE", null, null);
            silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
            silverboltTestBase.insertGasGoods(0L, goodsType, goodsGroupType, null, goodsName, goodsCode, null, null,
                    null);
            silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
            silverboltTestBase.insertGasMerchantGoods(0L, platPartnerId, goodsName, goodsCode, goodsType
                    , null, null, "ABLE", null, null, null, null);
        }
        if (StringUtils.isNotBlank(goodsCode1)) {
            merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
            merchantTestBase.insertGasGoods(0L, goodsType1, goodsGroupType1, null, goodsName1, goodsCode1, null, null
                    , null, null, null,
                    null);
            merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
            merchantTestBase.insertGasMerchantGoods(0L, platPartnerId, platPartnerId, goodsName1, goodsCode1,
                    goodsType1, null, null, null, goodsGroupType1
                    , null, null, "ABLE", null, null);
            silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode1);
            silverboltTestBase.insertGasGoods(0L, goodsType1, goodsGroupType1, null, goodsName1, goodsCode1, null, null,
                    null);
            silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode1);
            silverboltTestBase.insertGasMerchantGoods(0L, platPartnerId, goodsName1, goodsCode1, goodsType1
                    , null, null, "ABLE", null, null, null, null);
        }
        if (StringUtils.isNotBlank(goodsCode2)) {
            merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode2);
            merchantTestBase.insertGasGoods(0L, goodsType2, goodsGroupType2, null, goodsName2, goodsCode2, null, null
                    , null, null, null,
                    null);
            merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode2);
            merchantTestBase.insertGasMerchantGoods(0L, platPartnerId, platPartnerId, goodsName2, goodsCode2,
                    goodsType2, null, null, null, goodsGroupType2
                    , null, null, "ABLE", null, null);
            silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode2);
            silverboltTestBase.insertGasGoods(0L, goodsType2, goodsGroupType2, null, goodsName2, goodsCode2, null, null,
                    null);
            silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode2);
            silverboltTestBase.insertGasMerchantGoods(0L, platPartnerId, goodsName2, goodsCode2, goodsType2
                    , null, null, "ABLE", null, null, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 油站商品配置表
     */
    public Map<String, Object> initGasStationGoods(String platPartnerId, String stationId,
                                                   String goodsName, String goodsCode,
                                                   String goodsName1, String goodsCode1,
                                                   String goodsName2, String goodsCode2) {
        if (StringUtils.isNotBlank(goodsCode)) {
            merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode);
            merchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName, goodsCode,
                    GoodsType.OIL.code(), null, null, null, null);
        }
        if (StringUtils.isNotBlank(goodsCode1)) {
            merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode1);
            merchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName1, goodsCode1,
                    GoodsType.OIL.code(), null, null, null, null);
        }
        if (StringUtils.isNotBlank(goodsCode2)) {
            merchantTestBase.cleanGasStationGoodsByStationIdAndGoodsCode(stationId, goodsCode2);
            merchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, goodsName2, goodsCode2,
                    GoodsType.OIL.code(), null, null, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 一个油站配置多个油枪，油枪号不传时，表示不新增
     * 油站油枪配置表
     */
    public Map<String, Object> initGasStationOilGun(String platPartnerId, String stationId,
                                                    String oilGunNo, String goodsCode, int sortNo,
                                                    String oilGunNo1, String goodsCode1, int sortNo1,
                                                    String oilGunNo2, String goodsCode2, int sortNo2) {
        if (StringUtils.isNotBlank(oilGunNo)) {
            merchantTestBase.cleanGasStationOilGunByOilGunNo(oilGunNo);
            merchantTestBase.insertGasStationOilGun(0L, null, platPartnerId, stationId, oilGunNo, goodsCode, null,
                    null, sortNo);
        }
        if (StringUtils.isNotBlank(oilGunNo1)) {
            merchantTestBase.cleanGasStationOilGunByOilGunNo(oilGunNo1);
            merchantTestBase.insertGasStationOilGun(0L, null, platPartnerId, stationId, oilGunNo1, goodsCode1, null,
                    null, sortNo1);
        }
        if (StringUtils.isNotBlank(oilGunNo2)) {
            merchantTestBase.cleanGasStationOilGunByOilGunNo(oilGunNo2);
            merchantTestBase.insertGasStationOilGun(0L, null, platPartnerId, stationId, oilGunNo2, goodsCode2, null,
                    null, sortNo2);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 油站油价配置表
     */
    public Map<String, Object> initGasStationGoodsPrice(String platPartnerId, String stationId, String planId,
                                                        String merchantPlanId, Date effectTime,
                                                        String goodsName, String goodsCode,
                                                        Money goodsPrice, Money listedPrice,
                                                        String goodsName1, String goodsCode1,
                                                        Money goodsPrice1, Money listedPrice1,
                                                        String goodsName2, String goodsCode2,
                                                        Money goodsPrice2, Money listedPrice2) {

        Set<GoodsPriceOrder> goodsPriceOrders = Sets.newHashSet();
        GoodsPriceOrder goodsPriceOrder = new GoodsPriceOrder();
        goodsPriceOrder.setGoodsCode(goodsCode);
        goodsPriceOrder.setGoodsName(goodsName);
        goodsPriceOrder.setGoodsPrice(goodsPrice);
        goodsPriceOrder.setGoodsType(GoodsType.OIL);
        goodsPriceOrder.setListedPrice(listedPrice);
        GoodsPriceOrder goodsPriceOrder1 = new GoodsPriceOrder();
        goodsPriceOrder1.setGoodsCode(goodsCode1);
        goodsPriceOrder1.setGoodsName(goodsName1);
        goodsPriceOrder1.setGoodsPrice(goodsPrice1);
        goodsPriceOrder1.setGoodsType(GoodsType.OIL);
        goodsPriceOrder1.setListedPrice(listedPrice1);
        GoodsPriceOrder goodsPriceOrder2 = new GoodsPriceOrder();
        goodsPriceOrder2.setGoodsCode(goodsCode2);
        goodsPriceOrder2.setGoodsName(goodsName2);
        goodsPriceOrder2.setGoodsPrice(goodsPrice2);
        goodsPriceOrder2.setGoodsType(GoodsType.OIL);
        goodsPriceOrder2.setListedPrice(listedPrice2);
        if (StringUtils.isNotBlank(goodsCode)) {
            goodsPriceOrders.add(goodsPriceOrder);
        }
        if (StringUtils.isNotBlank(goodsCode1)) {
            goodsPriceOrders.add(goodsPriceOrder1);
        }
        if (StringUtils.isNotBlank(goodsCode2)) {
            goodsPriceOrders.add(goodsPriceOrder2);
        }
        String goodsInfo = JSON.toJSONString(goodsPriceOrders);
        if (StringUtils.isNotBlank(stationId)) {
            merchantTestBase.cleanGasStationGoodsPricePlanByStationId(stationId);
            merchantTestBase.insertGasStationGoodsPricePlan(0L, planId, merchantPlanId, "测试油价计划", platPartnerId,
                    platPartnerId, stationId, effectTime, "Y", null, null, null, null, goodsInfo);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 支付方式配置表
     */
    public Map<String, Object> initGasMerchantPayway(String platPartnerId, String payWayCode, String payWayName,
                                                     String payWayType, String channelCode, String barCode,
                                                     String apiPartnerId, ApplyGoodsType applyGoodsType,
                                                     PaywayTerminalType paywayTerminalType,
                                                     PaywayModelType paywayModelType, PaywayActionType paywayActionType,
                                                     String status, boolean print) {
        //支付模式
        List<String> modelList = Lists.newArrayList();
        Map<PaywayActionType, List<PaywayTerminalType>> actionTerminalMap = Maps.newHashMap();
        //终端类型
        List<PaywayTerminalType> terminalTypes = Lists.newArrayList();
        //条码规则
        List<String> barCodeList = Lists.newArrayList();
        //支付场景配置
        PaywaySceneOrder paywaySceneOrder = new PaywaySceneOrder();
        if (paywayTerminalType != null && StringUtils.isNotBlank(paywayTerminalType.code())) {
            terminalTypes.add(paywayTerminalType);
        }
        actionTerminalMap.put(paywayActionType, terminalTypes);
        if (StringUtils.isNotBlank(barCode)) {
            barCodeList.add(barCode);
        }
        if (paywayModelType != null && StringUtils.isNotBlank(paywayModelType.code())) {
            modelList.add(paywayModelType.code());
        }
        if (StringUtils.isNotBlank(apiPartnerId)) {
            paywaySceneOrder.setApiPartnerId(apiPartnerId);
        }
        paywaySceneOrder.setApplyGoodsType(applyGoodsType);
        paywaySceneOrder.setBarCodeList(barCodeList);
        paywaySceneOrder.setModelList(modelList);
        paywaySceneOrder.setActionTerminalMap(actionTerminalMap);
        //支付属性配置
        MerchantPaywayAttributeOrder attribute = new MerchantPaywayAttributeOrder();
        attribute.setPrint(print);
        if (StringUtils.isNotBlank(payWayCode)) {
            merchantTestBase.cleanGasMerchantPaywayByPlatPartnerIdAndPaywayCode(platPartnerId, payWayCode);
            merchantTestBase.insertGasMerchantPayway(0L, platPartnerId, platPartnerId, payWayCode, payWayName,
                    payWayType, null, null, channelCode, null, status, null, null,
                    JSON.toJSONString(paywaySceneOrder), JSON.toJSONString(attribute));
            //分析
            silverboltTestBase.cleanGasMerchantPayWayByPartnerIdAndPayWayCode(platPartnerId, payWayCode);
            silverboltTestBase.insertGasMerchantPayWay(0L, platPartnerId, payWayCode, payWayName, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 根据partnerId和paycode删除gas_merchant_payway表数据
     */
    public void cleanGasMerchantPaywayByPartnerIdAndCode(String partnerId, String payWayCode) {
        if (org.junit.platform.commons.util.StringUtils.isBlank(partnerId)) {
            partnerId = "test_partnerId";
        }
        if (org.junit.platform.commons.util.StringUtils.isBlank(payWayCode)) {
            payWayCode = "test_payWayCode";
        }
        GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
        exam.createCriteria().andPartnerIdEqualTo(partnerId).andPaywayCodeEqualTo(payWayCode);
        gasMerchantPaywayDAO.deleteByExample(exam);
    }

    /**
     * 根据partnerId和paycode删除gas_merchant_payway表数据(分析)
     */
    public void cleanGasMerchantPayWayByPartnerIdAndCode(String partnerId, String payWayCode) {
        if (org.junit.platform.commons.util.StringUtils.isBlank(partnerId)) {
            partnerId = "test_partnerId";
        }
        if (org.junit.platform.commons.util.StringUtils.isBlank(payWayCode)) {
            payWayCode = "test_payWayCode";
        }
        GasMerchantPayWayDOExample exam = new GasMerchantPayWayDOExample();
        exam.createCriteria().andPartnerIdEqualTo(partnerId).andPayWayCodeEqualTo(payWayCode);
        silverboltPayWayDAO.deleteByExample(exam);
    }

    /**
     * 商户协议规则配置表(目前只用于充值协议配置)
     */
    public Map<String, Object> initMerchantProtocolRule(String platPartnerId, String ruleType, String protocol,
                                                        String dec, Money amount, Integer index, Money amount1,
                                                        Integer index1,
                                                        String status) {

        //协议规则数据
        List<ProtocolRuleDataOrder> ruleDatas = Lists.newArrayList();
        ProtocolRuleDataOrder ruleData = new ProtocolRuleDataOrder();
        if (StringUtils.isNotBlank(index.toString()) && StringUtils.isNotBlank(amount.toString())) {
            ruleData.setIndex(index);
            ruleData.setAmount(amount);
        }
        ProtocolRuleDataOrder ruleData1 = new ProtocolRuleDataOrder();
        if (StringUtils.isNotBlank(index1.toString()) && StringUtils.isNotBlank(amount1.toString())) {
            ruleData1.setIndex(index1);
            ruleData1.setAmount(amount1);
        }
        ruleDatas.add(ruleData);
        ruleDatas.add(ruleData1);
        if (StringUtils.isNotBlank(platPartnerId)) {
            merchantTestBase.cleanMerchantProtocolRuleByPlatPartnerId(platPartnerId);
            merchantTestBase.insertMerchantProtocolRule(0L, platPartnerId, status, ruleType, null, null, protocol,
                    dec, JSON.toJSONString(ruleDatas));
        }
        Map<String, Object> param = Maps.newHashMap();
        return param;
    }

    /**
     * 准备一个能登录商户中台的账户
     */
    public Map<String, Object> initBossGasRole(String partnerId, String mobile,
                                               String sourceKey, String model,
                                               String merchantStatus, String userType,
                                               String userStatus, String account,
                                               String password, String operatorMobile) {
        Long parentId = null;
        //资金账户
        String accountNo = "1jc7w1m29ks031hge7p8";
        String marketAccountNo = "001iys5hlniks541g00";
        String poolAccountNo = "1jhb00i98ws031hge7p0";
        //第一个商家
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybMerchantTestBase.insertMerchantInfo(0L, partnerId, partnerId, null, null, "自动化测试商家",
                null, null, "INSIDE", "PLATFORM", "ACTIVE",
                GID.newGID(), "MD5", null, null, null);
        //插入神马付会员
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.insertUser(0L, partnerId, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                "自动化测试商家", null, null, null, null,
                null, null, null, null, null, mobile, null, null,
                null, partnerId, null, null, null);
        //插入神马付商户标准账户信息
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByAccountNo(accountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, accountNo, null, partnerId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", accountNo, "加好油自动化测试标准账户", null, null);
        //插入神马付商户营销账户信息
        xybUserTestBase.cleanAccountByAccountNo(marketAccountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, marketAccountNo, null, partnerId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "gas_merchant_market_account_tag", "加好油自动化测试营销账户",
                null, null);
        //插入神马付商户资金池账户信息
        xybUserTestBase.cleanAccountByAccountNo(poolAccountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, poolAccountNo, null, partnerId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试资金池账户", null, null);
        //加好油商户
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPartnerName("自动化测试商家");
        merchantTestBase.insertGasMerchant(0L, partnerId, partnerId, "自动化测试商家", "自动化测试", mobile, null,
                accountNo, marketAccountNo, merchantStatus, null, null, model, "1", "0*60*60*1000+0*60*1000+0" +
                        "*1000", null, null);
        //商户来源信息
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataBySourceTypeAndSourceKey(SourceType.WeChat.code(), sourceKey);
        merchantTestBase.insertGasMerchantSourceData(0L, partnerId, partnerId, SourceType.WeChat.code(),
                sourceKey, Byte.valueOf("0"), null, null, null, null, null, null, null);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerName("自动化测试商家");
        silverboltTestBase.insertGasMerchant(0L, partnerId, "自动化测试商家", "自动化测试", mobile, null, accountNo,
                marketAccountNo, merchantStatus, null, null, model, null, null, null,
                null);
        //产品
        merchantTestBase.cleanProductByProductName("油站中心");
        merchantTestBase.insertProduct(0L, OID.newID(), "油站中心", "BOSS",
                "COMMON", "ABLE", "油站中心", null, null);
        String productId = merchantTestBase.findProductByProductName("油站中心").get(0).getProductId();
        //权限
        merchantTestBase.cleanPermissionByName("油站中心");
        merchantTestBase.insertPermission(0L, "BOSS", OID.newID(), null, "油站中心",
                "MENU0529", null, "MENU", "COMMON",
                4, null, null, null, null);
        String permissionId = merchantTestBase.findPermissionByName("油站中心").get(0).getPermissionId();
        //产品权限关联关系
        merchantTestBase.insertProductPermission(0L, productId, permissionId);
        //角色
        merchantTestBase.cleanRoleByPlatPartnerId(partnerId);
        merchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", "Supplier", partnerId,
                "商家管理员", "系统预设商家管理员", null, null);
        String roleNo =
                findRoleByRoleTypeAndRoleCode(partnerId, "Supplier", "00000000000000000000").get(0).getRoleNo();
        //商家产品关联关系
        merchantTestBase.cleanMerchantProductByPlatPartnerId(partnerId);
        merchantTestBase.insertMerchantProduct(0L, productId, partnerId, "ABLE");
        //默认角色产品关系
        merchantTestBase.cleanRoleProductByRoleNo(roleNo);
        merchantTestBase.insertRoleProduct(0L, roleNo, productId);
        merchantTestBase.cleanRolePermissionByRoleNo(roleNo);
        merchantTestBase.insertRolePermission(0L, roleNo, productId, permissionId);
        //操作员
        merchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        merchantTestBase.insertGasMerchantUser(0L, OID.newID(), null, roleNo,
                userType, partnerId, partnerId, "用户名",
                operatorMobile, account, encrypt(password, null), null,
                userStatus,
                account, 0, 5, null, null, null, null, null);
        String userId = merchantTestBase.findGasMerchantUserByPlatPartnerId(partnerId).get(0).getUserId();
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.insertGasMerchantUser(0L, partnerId, partnerId, null, roleNo,
                userType, "用户名",
                operatorMobile, account, encrypt(password, null), null,
                userStatus,
                account, 0, 5, null, null, null, null, null, null, null);
        merchantTestBase.cleanUserUniqueKeyByUserId(userId);
        merchantTestBase.insertUserUniqueKey(0L, userId, UkType.ACCOUNT.code(), account);
        Map<String, Object> param = Maps.newHashMap();
        param.put("roleNo", roleNo);
        param.put("permissionId", permissionId);
        param.put("userId", userId);
        param.put("productId", productId);
        return param;
    }

    /**
     * 准备一个pos机和一个收银员账号
     */
    public Map<String, Object> initPosGasRole(String partnerId, String mobile,
                                              String sourceKey, String model,
                                              String merchantStatus, String userType,
                                              String userStatus, String account,
                                              String password, String operatorMobile,
                                              String deviceCode, String loginStatus,
                                              String oilGunNo, String goodsCode,
                                              String goodsName) {
        Long parentId = null;
        //资金账户
        String accountNo = "1jc7w1m29ks031hge7p8";
        String marketAccountNo = "001iys5hlniks541g00";
        String poolAccountNo = "1jhb00i98ws031hge7p0";
        //第一个商家
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybMerchantTestBase.insertMerchantInfo(0L, partnerId, partnerId, null, null, "自动化测试商家",
                null, null, "INSIDE", "PLATFORM", "ACTIVE",
                GID.newGID(), "MD5", null, null, null);
        //插入神马付会员
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.insertUser(0L, partnerId, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                "自动化测试商家", null, null, null, null,
                null, null, null, null, null, mobile, null, null,
                null, partnerId, null, null, null);
        //插入神马付商户标准账户信息
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByAccountNo(accountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, accountNo, null, partnerId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", accountNo, "加好油自动化测试标准账户", null, null);
        //插入神马付商户营销账户信息
        xybUserTestBase.cleanAccountByAccountNo(marketAccountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, marketAccountNo, null, partnerId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "gas_merchant_market_account_tag", "加好油自动化测试营销账户",
                null, null);
        //插入神马付商户资金池账户信息
        xybUserTestBase.cleanAccountByAccountNo(poolAccountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, poolAccountNo, null, partnerId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试资金池账户", null, null);
        //加好油商户
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPartnerName("自动化测试商家");
        merchantTestBase.insertGasMerchant(0L, partnerId, partnerId, "自动化测试商家", "自动化测试", mobile, null,
                accountNo, marketAccountNo, merchantStatus, null, null, model, "1", "0*60*60*1000+0*60*1000+0" +
                        "*1000", null, null);
        //商户来源信息
        merchantTestBase.cleanGasMerchantSourceDataByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantSourceDataBySourceTypeAndSourceKey(SourceType.WeChat.code(), sourceKey);
        merchantTestBase.insertGasMerchantSourceData(0L, partnerId, partnerId, SourceType.WeChat.code(),
                sourceKey, Byte.valueOf("0"), null, null, null, null, null, null, null);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.insertGasMerchant(0L, partnerId, "自动化测试商家", "自动化测试", mobile, null, accountNo,
                marketAccountNo, merchantStatus, null, null, model, null, null, null,
                null);
        //产品
        merchantTestBase.cleanProductByProductName("一键加油管理");
        merchantTestBase.insertProduct(0L, OID.newID(), "一键加油管理", "POS",
                "COMMON", "ABLE", "一键加油管理", null, null);
        String productId = merchantTestBase.findProductByProductName("一键加油管理").get(0).getProductId();
        //权限
        merchantTestBase.cleanPermissionByName("一键加油管理");
        merchantTestBase.insertPermission(0L, "POS", OID.newID(), null, "一键加油管理",
                "OneKeyPayManage", null, "MENU", "COMMON",
                4, null, null, null, null);
        String permissionId = merchantTestBase.findPermissionByName("一键加油管理").get(0).getPermissionId();
        //产品权限关联关系
        merchantTestBase.insertProductPermission(0L, productId, permissionId);
        //角色
        merchantTestBase.cleanRoleByPlatPartnerId(partnerId);
        merchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", "Terminal", partnerId,
                "收银员", "系统预设收银员", null, null);
        String roleNo =
                findRoleByRoleTypeAndRoleCode(partnerId, "Terminal", "00000000000000000000").get(0).getRoleNo();
        //商家产品关联关系
        merchantTestBase.cleanMerchantProductByPlatPartnerId(partnerId);
        merchantTestBase.insertMerchantProduct(0L, productId, partnerId, "ABLE");
        //默认角色产品关系
        merchantTestBase.cleanRoleProductByRoleNo(roleNo);
        merchantTestBase.insertRoleProduct(0L, roleNo, productId);
        merchantTestBase.cleanRolePermissionByRoleNo(roleNo);
        merchantTestBase.insertRolePermission(0L, roleNo, productId, permissionId);
        //操作员
        merchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantUserByUqKeyAndUserType(account, userType);
        merchantTestBase.insertGasMerchantUser(0L, OID.newID(), null, roleNo,
                userType, partnerId, partnerId, "用户名",
                operatorMobile, account, encrypt(password, null), null,
                userStatus,
                account, 0, 5, null, null, null, null, null);
        String userId = merchantTestBase.findGasMerchantUserByPlatPartnerId(partnerId).get(0).getUserId();
        silverboltTestBase.cleanGasMerchantUserByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantUserByUqKeyAndUserType(account, userType);
        silverboltTestBase.insertGasMerchantUser(0L, partnerId, userId, null, roleNo,
                userType, "用户名",
                operatorMobile, account, encrypt(password, null), null,
                userStatus,
                account, 0, 5, null, null, null, null, null, null, null);
        merchantTestBase.cleanUserUniqueKeyByUserId(userId);
        merchantTestBase.insertUserUniqueKey(0L, userId, UkType.ACCOUNT.code(), partnerId + "_" + account);
        if (StringUtils.isNotBlank(operatorMobile)) {
            merchantTestBase.insertUserUniqueKey(0L, userId, UkType.MOBILE.code(), partnerId + "_" + operatorMobile);
        }
        //油站
        merchantTestBase.cleanGasMerchantStationByStationName("自动化测试油站");
        merchantTestBase.cleanGasMerchantStationByStationCode("test001");
        merchantTestBase.insertGasMerchantStation(0L, OID.newID(), partnerId, partnerId, "自动化测试油站", "test001",
                null, "ABLE", Byte.valueOf("0"), 500000L, 500100L, 500112L, "金开大道互联网产业园13幢3楼", 106.489838082,
                29.6219092167, null, null);
        String stationId = merchantTestBase.findGasMerchantStationByStationName("自动化测试油站").get(0).getStationId();
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationCode("test001");
        silverboltTestBase.insertGasMerchantStation(0L, partnerId, partnerId, stationId, "自动化测试油站", "test001",
                null, "ABLE", Byte.valueOf("0"), 500000L, "重庆", 500100L, "渝北", 500112L, "互联网产业园", "金开大道互联网产业园13幢3" +
                        "楼", 106.489838082, 29.6219092167, null,
                null, null, null);
        //省市---用预置数据
        //油品
        if (StringUtils.isNotBlank(goodsCode)) {
            merchantTestBase.cleanGasGoodsByGoodsCode(goodsCode);
            merchantTestBase.insertGasGoods(0L, GoodsType.OIL.code(), GoodsGroupType.GASOLINE.code(), null, goodsName,
                    goodsCode, null, null
                    , null, null, null,
                    null);
            merchantTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
            merchantTestBase.insertGasMerchantGoods(0L, partnerId, partnerId, goodsName, goodsCode,
                    GoodsType.OIL.code(), GoodsGroupType.GASOLINE.code(), null, null, null
                    , null, null, "ABLE", null, null);
            silverboltTestBase.cleanGasGoodsByGoodsCode(goodsCode);
            silverboltTestBase.insertGasGoods(0L, GoodsType.OIL.code(), GoodsGroupType.GASOLINE.code(), null, goodsName,
                    goodsCode, null,
                    null,
                    null);
            silverboltTestBase.cleanGasMerchantGoodsByGoodsCode(goodsCode);
            silverboltTestBase.insertGasMerchantGoods(0L, partnerId, goodsName, goodsCode, GoodsType.OIL.code()
                    , null, null, "ABLE", null, null, null, null);
        }
        //油枪
        if (StringUtils.isNotBlank(oilGunNo)) {
            merchantTestBase.cleanGasStationOilGunByStationId(stationId);
            merchantTestBase.insertGasStationOilGun(0L, partnerId, partnerId, stationId, oilGunNo, goodsCode,
                    null, null, 1);
        }
        //关系
        merchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
        merchantTestBase.insertGasMerchantUserStation(0L, userId, stationId);
        silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
        silverboltTestBase.insertGasMerchantUserStation(0L, partnerId, userId, null, userType, "用户名", operatorMobile,
                account, "NORMAL", stationId, null, null);
        //pos机
        merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
        if (UserLoginStatus.login.code().equals(loginStatus)) {
            merchantTestBase.insertGasMerchantDevice(0L, partnerId, partnerId,
                    DeviceType.POS.code(), deviceCode, loginStatus, userId, null, null);
        } else {
            merchantTestBase.insertGasMerchantDevice(0L, partnerId, partnerId,
                    DeviceType.POS.code(), deviceCode, loginStatus, null, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("roleNo", roleNo);
        param.put("permissionId", permissionId);
        param.put("productId", productId);
        param.put("userId", userId);
        param.put("stationId", stationId);
        return param;
    }

    /**
     * 准备完整的商家操作员（未分配角色权限的）
     */
    public Map<String, Object> initMerchantUser(String partnerId, String mobile,
                                                String sourceKey, String model,
                                                String merchantStatus, String stationCode,
                                                String stationName, String userType,
                                                String userStatus, String roleType,
                                                String roleName, String deviceType,
                                                String account, String resouce,
                                                String password, String operatorMobile) {
        Long resourceId = null;
        //资金账户
        String accountNo = "1jc7w1m29ks031hge7p8";
        String marketAccountNo = "001iys5hlniks541g00";
        String poolAccountNo = "1jhb00i98ws031hge7p0";
        //商家
        xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
        xybMerchantTestBase.insertMerchantInfo(0L, partnerId, partnerId, null, null, "自动化测试商家",
                null, null, "INSIDE", "PLATFORM", "ACTIVE",
                GID.newGID(), "MD5", null, null, null);
        //插入神马付会员
        xybUserTestBase.cleanUserByUserId(partnerId);
        xybUserTestBase.insertUser(0L, partnerId, null, PLAT_PARTNER_ID, PLAT_PARTNER_ID, null, null,
                RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                "自动化测试商家", null, null, null, null,
                null, null, null, null, null, mobile, null, null,
                null, partnerId, null, null, null);
        //插入神马付商户标准账户信息
        xybUserTestBase.cleanAccountByUserId(partnerId);
        xybUserTestBase.cleanAccountByAccountNo(accountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, accountNo, null, partnerId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", accountNo, "加好油自动化测试标准账户", null, null);
        //插入神马付商户营销账户信息
        xybUserTestBase.cleanAccountByAccountNo(marketAccountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, marketAccountNo, null, partnerId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "gas_merchant_market_account_tag", "加好油自动化测试营销账户",
                null, null);
        //插入神马付商户资金池账户信息
        xybUserTestBase.cleanAccountByAccountNo(poolAccountNo);
        xybUserTestBase.insertAccount(0L, PLAT_PARTNER_ID, partnerId, poolAccountNo, null, partnerId, 0L,
                0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试资金池账户", null, null);
        //加好油商户
        merchantTestBase.cleanGasMerchantByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantByPartnerName("自动化测试商家");
        merchantTestBase.insertGasMerchant(0L, partnerId, partnerId, "自动化测试商家", "自动化测试", mobile, null,
                accountNo, marketAccountNo, merchantStatus, null, null, model, "1", "0*60*60*1000+0*60*1000+0" +
                        "*1000", null, null);
        //商户来源信息
        merchantTestBase.cleanGasMerchantSourceDataBySourceTypeAndSourceKey("WeChat", sourceKey);
        merchantTestBase.insertGasMerchantSourceData(0L, partnerId, partnerId, SourceType.WeChat.code(),
                sourceKey, Byte.valueOf("0"), null, null, null, null, null, null, null);
        silverboltTestBase.cleanGasMerchantByPartnerId(partnerId);
        silverboltTestBase.cleanGasMerchantByPartnerName("自动化测试商家");
        silverboltTestBase.insertGasMerchant(0L, partnerId, "自动化测试商家", "自动化测试", mobile, null, accountNo,
                marketAccountNo, merchantStatus, null, null, model, null, null, null,
                null);
        //油站
        merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        merchantTestBase.insertGasMerchantStation(0L, OID.newID(), partnerId, partnerId, stationName,
                stationCode, null, "ABLE", null, 500000L, 500100L, 500112L, "互联网产业园", 106.49713792,
                29.6279712135, null, null);
        String stationId = merchantTestBase.findGasMerchantStationByStationName(stationName).get(0).getStationId();
        //分析数据
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
        silverboltTestBase.insertGasMerchantStation(0L, partnerId, partnerId, stationId, stationName,
                stationCode, null, "ABLE", null, 500000L, "重庆市", 500100L, "市辖区", 500112L, "渝北区", "互联网产业园"
                , 106.49713792, 29.6279712135, null, null, null, null);
        //角色
        merchantTestBase.cleanRoleByPlatPartnerId(partnerId);
        merchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", roleType, partnerId,
                roleName, "系统预设" + roleName, null, null);
        String roleNo =
                findRoleByRoleTypeAndRoleCode(partnerId, roleType, "00000000000000000000").get(0).getRoleNo();
        //操作员
        merchantTestBase.cleanGasMerchantUserByPlatPartnerId(partnerId);
        merchantTestBase.cleanGasMerchantUserByUqKeyAndUserType(account, userType);
        merchantTestBase.insertGasMerchantUser(0L, OID.newID(), null, roleNo,
                userType, partnerId, partnerId, "用户名",
                operatorMobile, account, encrypt(password, null), null,
                userStatus,
                account, 0, 5, null, null, null, null, null);
        String userId = merchantTestBase.findGasMerchantUserByPlatPartnerId(partnerId).get(0).getUserId();
        silverboltTestBase.cleanGasMerchantUserByUserId(userId);
        silverboltTestBase.cleanGasMerchantUserByUqKeyAndUserType(account, userType);
        silverboltTestBase.insertGasMerchantUser(0L, partnerId, userId, null, roleNo,
                userType, "用户名",
                operatorMobile, account, encrypt(password, null), null,
                userStatus,
                account, 0, 5, null, null, null, null, null, null, null);
        merchantTestBase.cleanUserUniqueKeyByUserId(userId);
        if ("Supplier".equals(roleType)) {
            merchantTestBase.insertUserUniqueKey(0L, userId, UkType.ACCOUNT.code(), account);
        } else {
            merchantTestBase.insertUserUniqueKey(0L, userId, UkType.ACCOUNT.code(), partnerId + "_" + account);
            if (StringUtils.isNotBlank(operatorMobile)) {
                merchantTestBase.insertUserUniqueKey(0L, userId, UkType.MOBILE.code(),
                        partnerId + "_" + operatorMobile);
            }
        }
        //需要关联油站的操作员
        //pos机菜单是配在商家下的
//        if ("POS".equals(deviceType)) {
//            merchantTestBase.cleanGasMerchantDeviceByDeviceCode(deviceCode);
//            merchantTestBase.insertGasMerchantDevice(0L, partnerId, partnerId,
//                    deviceType, deviceCode, loginStatus, userId, null, null);
//        }
        if (RoleType.Terminal.code().equals(roleType) || RoleType.Station.code().equals(roleType) || RoleType.Nonoperation.code().equals(roleType)) {
            merchantTestBase.cleanGasMerchantUserStationByStationId(stationId);
            merchantTestBase.insertGasMerchantUserStation(0L, userId, stationId);
            silverboltTestBase.cleanGasMerchantUserStationByStationId(stationId);
            silverboltTestBase.insertGasMerchantUserStation(0L, partnerId, userId, null, userType, "用户名",
                    operatorMobile, account, userStatus, stationId, null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("roleNo", roleNo);
        param.put("resourceId", resourceId);
        param.put("userId", userId);
        param.put("stationId", stationId);
        return param;
    }

    /**
     * 数据应用场景：准备一个分配了油号的油站，商户中台页面自动化测试修改油站使用
     * 参数设计说明：platPartnerId：平台商ID，partnerId：签约商ID，stationId：油站ID，stationName：油站名称
     * stationCode：油站编码，stationStatus：油站状态
     * <p>
     * 当油站能独立收银时，平台商ID和签约商ID不一样，对应的商家的数收款模式应为商家油站
     * 返回值：油站ID。可根据需要自行添加
     */
    public Map<String, Object> initStationsForUpdate(String platPartnerId, String partnerId,
                                                     String stationCode, String stationName,
                                                     String phone, String addr,
                                                     String oilCode, String oilName,
                                                     String oilCode1, String oilName1,
                                                     String stationStatus) {

        //第一个商家
        merchantTestBase.cleanGasMerchantStationByStationCode(stationCode);
        merchantTestBase.insertGasMerchantStation(0L, OID.newID(), partnerId, platPartnerId, stationName,
                stationCode, phone, stationStatus, null, 500000L, 500100L, 500112L, addr,
                106.49713792,
                29.6279712135, null, null);
        String stationId = merchantTestBase.findGasMerchantStationByStationCode(stationCode).get(0).getStationId();
        //分析数据
        silverboltTestBase.cleanGasMerchantStationByStationCode(stationCode);
        silverboltTestBase.cleanGasMerchantStationByStationId(stationId);
        silverboltTestBase.insertGasMerchantStation(0L, partnerId, platPartnerId, stationId, stationName,
                stationCode, phone, stationStatus, null, 500000L, "重庆市", 500100L, "市辖区", 500112L,
                "渝北区", addr
                , 106.49713792, 29.6279712135, null, null, null, null);
        //分配油号
        merchantTestBase.cleanGasStationGoodsByStationId(stationId);
        if (StringUtils.isNotBlank(oilCode)) {
            merchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, oilName, oilCode,
                    "OIL", null, null, null, null);
        }
        if (StringUtils.isNotBlank(oilCode1)) {
            merchantTestBase.insertGasStationGoods(0L, platPartnerId, platPartnerId, stationId, oilName1, oilCode1,
                    "OIL", null, null, null, null);
        }
        //独立收银油站需要清结算造数据
        if (platPartnerId != partnerId) {
            xybMerchantTestBase.cleanMerchantInfoByPartnerId(partnerId);
            xybMerchantTestBase.insertMerchantInfo(0L, partnerId, platPartnerId, null, null, null, stationName,
                    null,
                    "INSIDE", "PARTNER", "ACTIVE", GID.newGID(), "MD5", null, null,
                    null);
            //插入神马付会员
            xybUserTestBase.cleanUserByUserId(partnerId);
            xybUserTestBase.insertUser(0L, partnerId, null, platPartnerId, platPartnerId, null, null,
                    RegisterFrom.INSIDE.code(), com.xyb.user.api.enums.UserType.PARTNER.code(),
                    com.xyb.user.api.enums.UserStatus.NORMAL.code(), null,
                    stationName, null, null, null, null,
                    null, null, null, null, null, "6589554444", null, null,
                    null, partnerId, null, null, null);
            //插入神马付商户标准账户信息
            xybUserTestBase.cleanAccountByUserId(partnerId);
            xybUserTestBase.insertAccount(0L, platPartnerId, partnerId, OID.newID(), null, partnerId
                    , 0L, 0L, 0L, 0L, 0L, "ACTIVE", "NORMAL", "111", "POOL", "加好油自动化测试标准账户", null, null);
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("stationId", stationId);
        return param;
    }

    /**
     * 一个产品分配给多个商家
     */
    public Map<String, Object> initMerchantProduct(String platPartnerId, String platPartnerId1,
                                                   String productName, String type,
                                                   String category, String permissionName,
                                                   String permissionCode, String resourceType,
                                                   int orderNo) {
        String merchantRoleNo = null;
        String merchantRoleNo1 = null;
        String stationRoleNo = null;
        String stationRoleNo1 = null;
        //产品
        merchantTestBase.cleanProductByProductName(productName);
        merchantTestBase.insertProduct(0L, OID.newID(), productName, type, category,
                "ABLE", productName, null, null);
        String productId = merchantTestBase.findProductByProductName(productName).get(0).getProductId();
        //权限
        merchantTestBase.cleanPermissionByName(permissionName);
        merchantTestBase.insertPermission(0L, type, OID.newID(), null, permissionName,
                permissionCode, null, resourceType, category,
                orderNo, null, null, null, null);
        String permissionId = merchantTestBase.findPermissionByName(permissionName).get(0).getPermissionId();
        //产品权限关联关系
        merchantTestBase.insertProductPermission(0L, productId, permissionId);
        //商家1
        if (StringUtils.isNotBlank(platPartnerId)) {
            merchantTestBase.cleanRoleByPlatPartnerId(platPartnerId);
            merchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", "Supplier", platPartnerId,
                    "商家管理员", "系统预设商家管理员", null, null);
            merchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", "Station", platPartnerId,
                    "站长", "系统预设站长", null, null);
            merchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", "Terminal", platPartnerId,
                    "收银员", "系统预设收银员", null, null);
            merchantRoleNo =
                    findRoleByRoleTypeAndRoleCode(platPartnerId, "Supplier", "00000000000000000000").get(0).getRoleNo();
            stationRoleNo =
                    findRoleByRoleTypeAndRoleCode(platPartnerId, "Station", "00000000000000000000").get(0).getRoleNo();
            //商家产品关联关系
            merchantTestBase.cleanMerchantProductByPlatPartnerId(platPartnerId);
            merchantTestBase.insertMerchantProduct(0L, productId, platPartnerId, "ABLE");
            //默认角色产品关系
            if ("MERCHANT".equals(category)) {
                merchantTestBase.cleanRoleProductByRoleNo(merchantRoleNo);
                merchantTestBase.insertRoleProduct(0L, merchantRoleNo, productId);
                merchantTestBase.cleanRolePermissionByRoleNo(merchantRoleNo);
                merchantTestBase.insertRolePermission(0L, merchantRoleNo, productId, permissionId);
            }
            if ("STATION".equals(category)) {
                merchantTestBase.cleanRoleProductByRoleNo(stationRoleNo);
                merchantTestBase.insertRoleProduct(0L, stationRoleNo, productId);
                merchantTestBase.cleanRolePermissionByRoleNo(stationRoleNo);
                merchantTestBase.insertRolePermission(0L, stationRoleNo, productId, permissionId);
            }
            if ("COMMON".equals(category)) {
                merchantTestBase.cleanRoleProductByRoleNo(merchantRoleNo);
                merchantTestBase.insertRoleProduct(0L, merchantRoleNo, productId);
                merchantTestBase.cleanRolePermissionByRoleNo(merchantRoleNo);
                merchantTestBase.insertRolePermission(0L, merchantRoleNo, productId, permissionId);
                merchantTestBase.cleanRoleProductByRoleNo(stationRoleNo);
                merchantTestBase.insertRoleProduct(0L, stationRoleNo, productId);
                merchantTestBase.cleanRolePermissionByRoleNo(stationRoleNo);
                merchantTestBase.insertRolePermission(0L, stationRoleNo, productId, permissionId);
            }
        }
        //商家2
        if (StringUtils.isNotBlank(platPartnerId1)) {
            merchantTestBase.cleanRoleByPlatPartnerId(platPartnerId1);
            merchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", "Supplier", platPartnerId1,
                    "商家管理员", "系统预设商家管理员", null, null);
            merchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", "Station", platPartnerId1,
                    "站长", "系统预设站长", null, null);
            merchantTestBase.insertRole(0L, OID.newID(), "00000000000000000000", "Terminal", platPartnerId1,
                    "收银员", "系统预设收银员", null, null);
            merchantRoleNo1 =
                    findRoleByRoleTypeAndRoleCode(platPartnerId1, "Supplier", "00000000000000000000").get(0).getRoleNo();
            stationRoleNo1 =
                    findRoleByRoleTypeAndRoleCode(platPartnerId1, "Station", "00000000000000000000").get(0).getRoleNo();
            //商家产品关联关系
            merchantTestBase.cleanMerchantProductByPlatPartnerId(platPartnerId);
            merchantTestBase.insertMerchantProduct(0L, productId, platPartnerId1, "ABLE");
            //默认角色产品关系
            if ("MERCHANT".equals(category)) {
                merchantTestBase.cleanRoleProductByRoleNo(merchantRoleNo1);
                merchantTestBase.insertRoleProduct(0L, merchantRoleNo1, productId);
                merchantTestBase.cleanRolePermissionByRoleNo(merchantRoleNo1);
                merchantTestBase.insertRolePermission(0L, merchantRoleNo1, productId, permissionId);
            }
            if ("STATION".equals(category)) {
                merchantTestBase.cleanRoleProductByRoleNo(stationRoleNo1);
                merchantTestBase.insertRoleProduct(0L, stationRoleNo1, productId);
                merchantTestBase.cleanRolePermissionByRoleNo(stationRoleNo1);
                merchantTestBase.insertRolePermission(0L, stationRoleNo1, productId, permissionId);
            }
            if ("COMMON".equals(category)) {
                merchantTestBase.cleanRoleProductByRoleNo(merchantRoleNo1);
                merchantTestBase.insertRoleProduct(0L, merchantRoleNo1, productId);
                merchantTestBase.cleanRolePermissionByRoleNo(merchantRoleNo1);
                merchantTestBase.insertRolePermission(0L, merchantRoleNo1, productId, permissionId);
                merchantTestBase.cleanRoleProductByRoleNo(stationRoleNo1);
                merchantTestBase.insertRoleProduct(0L, stationRoleNo1, productId);
                merchantTestBase.cleanRolePermissionByRoleNo(stationRoleNo1);
                merchantTestBase.insertRolePermission(0L, stationRoleNo1, productId, permissionId);
            }
        }
        Map<String, Object> param = Maps.newHashMap();
        param.put("permissionId", permissionId);
        param.put("productId", productId);
        param.put("merchantRoleNo", merchantRoleNo);
        param.put("merchantRoleNo1", merchantRoleNo1);
        param.put("stationRoleNo", stationRoleNo);
        param.put("stationRoleNo1", stationRoleNo1);
        return param;
    }

    /**
     * 对密码进行MD5加密
     *
     * @param password--密码明文
     * @param slat--随机的6位数
     * @return
     */
    public static String encrypt(String password, String slat) {
        if (org.springframework.util.StringUtils.isEmpty(slat)) {
            return DigestUtil.digestWithMD5(password);
        }
        return DigestUtil.digestWithMD5(password + slat.substring(2));
    }

    /**
     * 获取段时间后的时间点
     *
     * @param month
     * @param day
     * @param hour
     * @param min
     * @param second
     * @return
     */
    public static Date afterDay(Date date, int month, int day, int hour, int min, int second) {
        try {
//            Date nowDate = new Date();
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            cd.add(Calendar.DATE, day);
            cd.add(Calendar.MONTH, month);
            cd.add(Calendar.HOUR, hour);
            cd.add(Calendar.MINUTE, min);
            cd.add(Calendar.SECOND, second);
            return cd.getTime();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据uniqueKey删除user_unique_key表数据
     */
    public void cleanUserUniqueKeyByUniqueKey(String uniqueKey) {
        if (org.junit.platform.commons.util.StringUtils.isBlank(uniqueKey)) {
            uniqueKey = "test_uniqueKey";
        }
        UserUniqueKeyDOExample exam = new UserUniqueKeyDOExample();
        exam.createCriteria().andUniqueKeyEqualTo(uniqueKey);
        userUniqueKeyDAO.deleteByExample(exam);
    }

    /**
     * 根据roleType、roleCode查询role表数据
     */
    public List<RoleDO> findRoleByRoleTypeAndRoleCode(String partnerId, String roleType, String roleCode) {
        RoleDOExample exam = new RoleDOExample();
        exam.createCriteria().andPlatPartnerIdEqualTo(partnerId).andRoleTypeEqualTo(roleType).andRoleCodeEqualTo(roleCode);
        return roleDAO.selectByExample(exam);
    }
}

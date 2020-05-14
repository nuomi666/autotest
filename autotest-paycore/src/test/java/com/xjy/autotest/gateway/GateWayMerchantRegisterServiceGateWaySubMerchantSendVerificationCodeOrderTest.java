package com.xjy.autotest.gateway;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.base.SpringBootTestBase;
import com.xyb.adk.common.lang.enums.CertTypeEnum;
import com.xyb.adk.common.lang.id.GID;
import com.xyb.adk.common.lang.id.OID;
import com.xyb.adk.common.lang.result.Status;
import com.xyb.gateway.api.base.GatewayOrder;
import com.xyb.gateway.api.base.GatewayResult;
import com.xyb.gateway.api.enums.SubMerchantPropertyEnum;
import com.xyb.gateway.api.order.*;
import com.xyb.gateway.api.service.GateWayFileService;
import com.xyb.gateway.api.service.GateWayMerchantRegisterService;
import com.xyb.gateway.api.service.GateWayPayService;
import org.junit.jupiter.api.DisplayName;


/**
 * @author huairen
 * Created on 2019/09/26.
 */
public class GateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTest extends SpringBootTestBase {

    @Reference(version = DUBBO_VERSION)
    GateWayMerchantRegisterService gateWayMerchantRegisterService;

    @Reference(version = DUBBO_VERSION)
    private GateWayPayService gateWayPayService;

    @Reference(version = DUBBO_VERSION)
    private GateWayFileService gateWayFileService;

    protected void baseOrder(GatewayOrder order) {
        order.setGid(GID.newGID());
        order.setReqId(OID.newID());
        order.setPartnerId("A0000000000000000002");
        order.setMerchantOrderNo("P123456");
        order.setPlatPartnerId("A0000000000000000003");
        order.setPlatMerchantOrderNo("P123456");
        order.setChannelPartnerId("D2019103110000099");

        order.getParams().put("subChannelPartnerId", "742031");
        order.getParams().put("password", "KYNQ4WFA69c15poUY4w3Qceh");
        order.getParams().put("publicKey", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi3ra1x7pQt+auI29Tx433J6GrIbGrgm0DRV" +
                "rXkyofLXhzccns3YK+Yka0jDBHKKoUnICD/rZMWTr7OH92QzvYjXeNRXDxsjECLEzrZo01yNURKUppw" +
                "J1B5DmKfd+jizqqAVWvIn94JZCHoEC6RKQ8ZfKQPbexUPZVxajoVfDbrDhD40Mv75ONoeDKv/eOy/Qs" +
                "nEOxwdtxKYeO4gduu7H3KM+EogZZiFfOJ7psraRNvh3YfYv5koFmPoDCV0wKkus9jKJFt0k3uPSJVOQ" +
                "WwuDkOJ9430BSa6pcGDwwfHtrJronnahedpllgdE5NzJlWz7glTS4xC5Xw2SdYTu6QZ+nQIDAQAB");
        order.getParams().put("privateKey", "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCATPYe2fw2Z0+kOM0zQEh++rIPXOM/rdHDGMGwfHXn6Dmy+8Dag1CbvtDcm95sHFuer4smmn96vGFJbxLAGJsmKrGfeW7rOvrGxCkKSkKX9oiSGxEpsI8Z1CC4b7ftuJyA5HDOXjrIMuLRWc5qB7ybJTUJ5BWP7jCKMEka1myVtwSxD5EYpgOtb1cYM6zj16CayezjX9qmuk0gWI7TmMu9R5/Ff0tYnjDxOVIiG/0Z/3Ovp8s284ID3KNadtYPUf+y//W7ypqV+nEqNjligZTBmtbT9gVpYWuXWMGN0eggwORzCn9tS7Hq+Y76VUH6i3XqjV+XziZqrmirIKhvealXAgMBAAECggEAQWj7QZdY4lOhYtQiqbJoQ3SEOxjcMqbnflOsy9FoOydF414+YCj6e6y4xwAgUXXTr/9HLhMuUuCfqNSb9puU3cx+ahN63Spgl92CHuDlOpxR3Es4YMzG6CAh3mX2m5e3Em9ko5Ge3lozERB8D8qJ+X7qn3RNGegRjyI24xvWmCzQu95wO8oe7w0lBa2gp0AsLQchkDTa+ai8XGY4J+eW4BHVqpV5BxEfjr0b80wRZISdcT4XegfGGOJtdlwsYUkOQhbJvF5vY+5gJHmCtuu5zZRu5MJJvo/miZpkYwcXV5+bdeJ8x5jWw6vzu86hpE0zpk3ZYXODGmoEDV/bUMRhgQKBgQDJmKJtZ1Dmk/bysjxoe5mv8VVYLKEhOicbUyVK4APl+KqwvgUNYta1cMFtPFlZKQVn8Mh9HkCgcO4V1nlCbsq7jW/gbikY6WWmoY25Sr11fQ01wm/j2zTvbMhmVW3lkp9WQytpbAkhcQheMGo7A3gth+vP7LpWxXolESK73D11EQKBgQCi7Kr0emypLlc7GCGS45+G04o6nWGAF/1XtDu4Te7Tv/L6pDdfLZJ49YmOpt8DzYCDSbW17gr+Aovw9hRL1steaxgpBCLu+ewi7jZAhrj90jhk9ZBwrl8y0JsZMb5+kMZa3xG55IffDZTyFeAi3NmK/Ig/pw5Cd6c0X9LEVHiX5wKBgHOAC696vhMdOyMZkxqZlhgDwM3f5AFRfA5fuMIJTrJ3ofPZKrPcqP8TNv8K0HYQ1pQSlAt7RbOmgAHq+1Zge66w/iQreUhYkHDDpps+gwXJO8RNPiXh9ZYnUTmwQGKDet7FZR3lU+XhCNZODs740eXkNerOyoPkaHLMOoY/TMbBAoGAPp6iMmcffoL+KgtjVBbCyMpjlZXJ1Lbju6LdVUA27BIZrLYTRjS42F7fKQIAM3D31P4upidA+FI4QTwDnwaGkdqtpY4ecyWB2gceuPxO+9ehr0Qm6PhMRLai9jMFWZYBdwnHwWARzOxmdAluZVfnESFwqK5nr6pXjKzL0IP6+b8CgYEAnG9gnOUTdVUgThwPFYtDDIa5X23O3SplNboLxuCnLG/418oQz/KXEbdSCEZ2Rgq5rwpmvGKljAyXo8Et1uL2HzBzu66vWQqqHa1U0MSmCF+1xKKDeuV7mX/f+YExVsuyxApnrxG3gWGMwhhayMnGao8yy8/YbN4qLelsh7eUZt4=");
    }

    /**
     * 众邦银行测试
     */
    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("子商户发送验证码--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantSendVerificationCodeOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_send_verification_code");
        order.setIdentityType(CertTypeEnum.IDENTITY_CARD);
        order.setRealName("左小华");
        order.setIdentityNo("500382198912277754");
        order.setBankCardNo("6217903200006502445");
        order.setPhone("18323341930");
        print(order);
        // 测试过程
        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantSendVerificationCodeOrder(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("个人子商户注册--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantRegisterTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantRegisterOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_person_entry");
        order.setIdentityType(CertTypeEnum.IDENTITY_CARD);
        order.setRealName("左小华");
        order.setIdentityNo("500382198912277754");
        order.setBankCardNo("6217903200006502445");
        order.setPhone("18323341930");
        order.setBankName("中国银行");
        order.setBankId("104100000004");
        order.setBankNumber("104653001295");
        order.setVerificationCode("469939");
        order.setIdentityFrontUrl("http://pixiugj.oss-cn-hangzhou.aliyuncs.com/mp_pixiugj/xyb/1572515324353.jpg");
        order.setIdentityBackUrl("http://pixiugj.oss-cn-hangzhou.aliyuncs.com/mp_pixiugj/xyb/1572515359375.jpg");
        print(order);
        // 测试过程
        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("个人信息修改--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantModifyTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantRegisterOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_person_entry_modify");
        order.setIdentityType(CertTypeEnum.IDENTITY_CARD);
        order.setRealName("卞志伟");
        order.setIdentityNo("320982198311285774");
        order.setBankCardNo("6228480393434693510");
        order.setPhone("13701474776");
        order.setBankName("中国工商银行");
        order.setBankId("102100099999");
        order.setBankNumber("102312002002");
        order.setVerificationCode("000001");
        order.setIdentityFrontUrl("http://pic25.nipic.com/20121112/9252150_150552938000_2.jpg");
        order.setIdentityBackUrl("http://pic25.nipic.com/20121112/9252150_150552938000_2.jpg");

        order.setSubMerchantId("U100001253215");
        order.setSubMerchantAccount("6228480393000321500001");
        // 测试过程
        print(order);
        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }


    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("企业注册--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantCombinationRegisterTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantCombinationRegisterOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_enterprise_entry");
        order.setCompanyName("重庆欣业邦网络技术有限公司");
        order.setSubMerchantProperty(SubMerchantPropertyEnum.BUSINESS);
        order.setPhone("18580627269");
        order.setRealName("慕向洲");
        order.setLegalIDCard("622827197901174116");
        order.setTransactorName("左小华");
        order.setTransactorIdCard("500382198912277754");
        order.setTransactorPhone("18580627269");
        order.setTransactorEmail("zuozuo@xinyebang.com");
        order.setBankCardNo("114452336829");
        order.setBankProvince("重庆市");
        order.setBankCity("渝北区");
        order.setBankBranchName("两江支行");
        order.setBankId("104100000004");
        order.setBankNumber("313653000021");
        order.setAccountLicenseNo("J6530066036401");
        order.setUniCredit("91500000MA5U71U21Q");
        order.setLegalIDCardFrontUrl("exchange/M01/B1/0C/CiADsF3BND2AGt89AAJU4kgB0wU.9647e3");
        order.setNationalEmblemUrl("exchange/M01/B1/0D/CiADsF3BNJmAUsaLAAKwJjumhHE.7c38ad");
        order.setUniCreditUrl("exchange/M01/B1/0D/CiADsF3BNNaADSgtAAEaG0bJ0PA.ce2440");

        order.setTransactorIdCardFrontUrl("exchange/M01/B1/11/CiADsF3BNo2ACF4IAAVKGR7H71Y.0633e3");
        order.setTransactorNationalEmblemUrl("exchange/M01/B1/12/CiADsF3BNvOAIM5QAAb5iaqA23c.f4c1e0");
        order.setProtocol("dubbo");
        order.setDubboGroup("user");
        order.setDubboVersion("1.0.0");
        // 测试过程
        print(order);
        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantCombinationRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("企业二次开户--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantCombinationRegistersecondTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantCombinationRegisterOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_enterprise_secondary_entry");
        order.setCompanyName("欣业邦网络技术有限公司");
        order.setSubMerchantId("U100001253220");
        // 测试过程
        print(order);
        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantCombinationRegister(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("企业打款认证--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantPaymentVerificationTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantPaymentVerificationOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_enterprise_entry");
        order.setAmount(100L);
        order.setOrderNo("1jqrq4bnlwT111hge89h");
        order.setSettleChannelId("zbank_enterprise_payment_verification");
        // 测试过程
        print(order);
        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantPaymentVerification(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("商户信息查询--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantRegisterQueryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantRegisterQueryOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_entry_query");
        //order.setSubMerchantProperty(SubMerchantPropertyEnum.BUSINESS);
        //order.setReqId("1jmt3xt9xwT111hge89q");
        order.setSubMerchantProperty(SubMerchantPropertyEnum.BUSINESS);
        order.setReqId("1jr82iv75cT111hge89g");
        // 测试过程
        print(order);
        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantRegisterQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("查询余额--成功用例")
    public void gateWayMerchantRegisterServiceGateWaySubMerchantQueryBalanceTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWaySubMerchantRegisterQueryOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_balance_query");
        order.setSubMerchantId("U100000991513584");
        order.setSubMerchantAccount("1144523368151358400238029");
        order.setSubMerchantProperty(SubMerchantPropertyEnum.BUSINESS);

        //order.setSubMerchantId("U100001253220");
        //order.setSubMerchantAccount("6216693200322000235425706");
        //order.setSubMerchantProperty(SubMerchantPropertyEnum.BUSINESS);
        // 测试过程
        print(order);
        // 调用接口
        GatewayResult result = gateWayMerchantRegisterService.gateWaySubMerchantQueryBalance(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("提现--成功用例")
    public void gateWayMerchantRegisterServiceGateWayWithdrawTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWayWithdrawOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_withdraw");
        order.setTotalFee(201L);
        //order.setPaymentAccount("6228480393000321500001");
        //order.setWithdrawUserId("U100001253215");
        order.setPaymentAccount("6216693200322000235425706");
        order.setWithdrawUserId("U100001253220");

        // 测试过程
        print(order);
        // 调用接口
        GatewayResult result = gateWayPayService.gateWayWithdraw(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }

    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("提现查询--成功用例")
    public void gateWayMerchantRegisterServiceGateWayQueryTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWayQueryOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_withdraw_query");
        order.setOrderNo("1jmtb60o6cT111hge89q");
        //order.setOrderNo("1jmtbyf29sT111hge89q");
        // 测试过程
        print(order);
        // 调用接口
        GatewayResult result = gateWayPayService.gateWayQuery(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }


    @AutoTest(file = "gateway/gateWayMerchantRegisterServiceGateWaySubMerchantSendVerificationCodeOrderTestSuccess.csv")
    @DisplayName("上传图片--成功用例")
    public void gateWayMerchantRegisterServiceSingleUploadTestSuccess(
            // 基本参数
            int testId,
            Status status,
            String code,
            // 业务参数
            GateWayUploadOrder order
    ) {
        // 清除数据
        // 准备数据
        baseOrder(order);
        order.setSettleChannelId("zbank_upload");
        order.setFilePath("http://pixiugj.oss-cn-hangzhou.aliyuncs.com/mp_pixiugj/xyb/1572515359375.jpg");
        order.setFileName("nation.jpg");
        //order.setLegalIDCardFrontUrl("https://i.loli.net/2019/11/01/McefwKAFxtVRjIG.jpg");
        //order.setNationalEmblemUrl("https://i.loli.net/2019/11/05/DEPNc7MF369i2Hx.jpg");
        //order.setUniCreditUrl("https://i.loli.net/2019/11/01/uXVQPvcKjLgHIy4.jpg");
        // 测试过程
        print(order);
        // 调用接口
        GatewayResult result = gateWayFileService.singleUpload(order);
        // 结果验证
        print(result);
        assertEquals(status, result.getStatus());
        assertEquals(code, result.getCode());
        // 数据验证
        // 清除数据
    }


}

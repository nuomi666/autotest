package ${packageName};

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.xjy.autotest.testbase.openapi.OpenapiTestBasis;
import com.xjy.autotest.utils.DigestUtil;
import com.xjy.autotest.annotation.AutoTest;
import org.junit.jupiter.api.DisplayName;

/**
 * @author ${author!'huairen'}
 * Created on ${time}.
 */
public class ${className} extends OpenapiTestBasis{

	@AutoTest(file = "${projectName}/${funcName}Success.csv")
	@DisplayName("${serviceName}--成功用例")
	public void ${funcName}Success(
			int testId,
			String resultCode,
			// 基本参数
			String requestNo,
			String protocol,
			String service,
			String version,
			String partnerId,
			String securityCheckCode,
			String signType,
			String merchOrderNo,
			String context,
			String notifyUrl,
			String returnUrl,
			// 业务参数
			<#list pars as parm>
			 <#if parm.children??>
			 <#else>
			   <#if parm.secondCode??>
	        ${parm.valType} ${parm.secondCode}<#if (parm_has_next)>,</#if>
	           <#else>
			${parm.valType} ${parm.itemCode}<#if (parm_has_next)>,</#if>
			   </#if>
			 </#if>
		    </#list> 
			){
		//初始化数据
		service = "${serviceNo}";
		partnerId = PARTNER_ID_3;
		securityCheckCode = SECURITYCHECKCODE_3;
		requestNo = "requestNo" + System.currentTimeMillis();
        merchOrderNo = "merchOrderNo" + System.currentTimeMillis();
		//清除数据
		<#--cleanMerchantInfo(orderNo, partnerId, merchantName, service);-->
		//准备数据
		<#--insertMerchantInfo(merchantName, digestAlg, securityCheckCode, service, memo, bizType, partnerId);-->
		//测试过程
		<#list childlist as child>
		 <#if child ??>
		 <#list pars as parm>
		   <#if 1 == parm.layer>
		     <#if parm.secondCode ??>
		       <#if child == parm.secondCode>
	    //${parm.itemTitle}
	    List<Map<Object, Object>> ${child} = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> ${child}Map = new HashMap<Object, Object>();
				  <#list pars as parm>
				   <#if 2 == parm.layer>
				    <#if parm.father??>
				     <#if child == parm.father>
		${child}Map.put("${parm.itemCode}", ${parm.secondCode});//${parm.itemTitle}
				     </#if> 
				    </#if> 
				   </#if> 
			      </#list>
		${child}.add(${child}Map);
		       </#if>
		     </#if> 
		   </#if> 
        </#list>
		 </#if>
        </#list>
        <#list childlist as child>
		 <#if child??>
		 <#list pars as parm>
		   <#if 0 == parm.layer>
		     <#if parm.father ??>
		     <#else>
		       <#if child == parm.itemCode>
	    //${parm.itemTitle}
	    List<Map<Object, Object>> ${child} = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> ${child}Map = new HashMap<Object, Object>();
				  <#list pars as parm>
				   <#if 1 == parm.layer>
				    <#if parm.father??>
				     <#if child == parm.father>
	    ${child}Map.put("${parm.itemCode}", ${parm.secondCode});//${parm.itemTitle}
				     </#if> 
				    </#if> 
				   </#if> 
			      </#list>
		${child}.add(${child}Map);
		       </#if>
		     </#if> 
		   </#if> 
        </#list>
		 </#if>
        </#list>
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildMap(requestNo, protocol, service, version, partnerId, signType, merchOrderNo, context, notifyUrl,
				returnUrl, dataMap);
		<#list pars as parm>
		  <#if parm.father ??>
		  <#else>
		    <#if parm.children??>
		dataMap.put("${parm.itemCode}", JSON.toJSONString(${parm.itemCode}));//${parm.itemTitle}         
		    <#else>
		dataMap.put("${parm.itemCode}", ${parm.itemCode});//${parm.itemTitle}
		    </#if> 
		  </#if> 
        </#list>
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		print(map);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiTestUrl, map, String.class);
		//结果验证
    	print("${serviceName}response:" + response.toString());
		JSONObject result = JSONObject.parseObject(response.getBody().toString());
		assertEquals(resultCode, result.getString("resultCode"));
		//数据验证
		//清除数据
	}
<#--	//参数缺省
	@Test
	@JoinTestCase(file = "api/openapicatest/${projectName}/${funcName}FailOne.csv", description = "失败用例-参数缺省")
	public void ${funcName}FailOne(
			int testId,
			// 基本参数
			String protocol,
			String service,
			String version,
			String partnerId,
			String signType,
			String notifyUrl,
			String returnUrl,
			String orderNo,
			//商户参数
			String merchantName,
			String digestAlg,
			String securityCheckCode,
			String bizType,
			String memo,
			// 业务参数
			<#list pars as parm>
			 <#if parm.children??>
			 <#else>
			   <#if parm.secondCode??>
	        ${parm.valType} ${parm.secondCode}<#if (parm_has_next)>,</#if>
	           <#else>
			${parm.valType} ${parm.itemCode}<#if (parm_has_next)>,</#if>
			   </#if>
			 </#if>
		    </#list> 
			){
		// 初始化数据
		<#list pars as parm>
			 <#if "merchOrderNo" ==parm.itemCode>
		merchOrderNo ="merchOrderNo" + System.currentTimeMillis();
			 </#if>
			 <#if "orderNo" ==parm.itemCode>
		orderNo = "orderNo"+System.currentTimeMillis();
			 </#if>
		 </#list>
		//清除数据
		cleanMerchantInfo(orderNo, partnerId, merchantName, service);
		//准备数据
		insertMerchantInfo(merchantName, digestAlg, securityCheckCode, service, memo, bizType, partnerId);
		//测试过程
		<#list childlist as child>
		 <#if child ??>
		 <#list pars as parm>
		   <#if 1 == parm.layer>
		     <#if parm.secondCode ??>
		       <#if child == parm.secondCode>
	    //${parm.itemTitle}
	    List<Map<Object, Object>> ${child} = new ArrayList<Map<Object, Object>>();
		Map<Object,Object> ${child}Map = new HashMap<Object, Object>();
				  <#list pars as parm>
				   <#if 2 == parm.layer>
				    <#if parm.father??>
				     <#if child == parm.father>
		${child}Map.put("${parm.itemCode}", ${parm.secondCode});//${parm.itemTitle}
				     </#if> 
				    </#if> 
				   </#if> 
			      </#list>
		${child}.add(${child}Map);
		       </#if>
		     </#if> 
		   </#if> 
        </#list>
		 </#if>
        </#list>
        //子订单
        <#list childlist as child>
		 <#if child??>
		 <#list pars as parm>
		   <#if 0 == parm.layer>
		     <#if parm.father ??>
		     <#else>
		       <#if child == parm.itemCode>
	    //${parm.itemTitle}
	    List<Map<Object, Object>> ${child} = new ArrayList<Map<Object, Object>>();
		Map<Object,Object> ${child}Map = new HashMap<Object, Object>();
				  <#list pars as parm>
				   <#if 1 == parm.layer>
				    <#if parm.father??>
				     <#if child == parm.father>
	    ${child}Map.put("${parm.itemCode}", ${parm.secondCode});//${parm.itemTitle}
				     </#if> 
				    </#if> 
				   </#if> 
			      </#list>
		${child}.add(${child}Map);
		       </#if>
		     </#if> 
		   </#if> 
        </#list>
		 </#if>
        </#list>
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildDataMap(protocol, service, version, partnerId, signType, notifyUrl, returnUrl, orderNo, dataMap);
		<#list pars as parm>
		  <#if parm.father ??>
		  <#else>
		    <#if parm.children??>
		dataMap.put("${parm.itemCode}", JSON.toJSONString(${parm.itemCode}));//${parm.itemTitle}         
		    <#else>
		dataMap.put("${parm.itemCode}", ${parm.itemCode});//${parm.itemTitle}
		    </#if> 
		  </#if> 
        </#list>
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		System.out.println("map:" + map);
		// 调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiCaTestUrl, map, String.class);
		// 结果验证
		String responseStr = response.toString();
		System.out.println("${serviceName}response:" + responseStr);
	    assertTrue(responseStr.contains("FAIL"));
	}
	//${serviceName}失败
	@Test
	@JoinTestCase(file = "api/openapicatest/${projectName}/${funcName}FailTwo.csv", description = "失败用例-${serviceName}失败")
	public void ${funcName}FailTwo(
			int testId,
			// 基本参数
			String protocol,
			String service,
			String version,
			String partnerId,
			String signType,
			String notifyUrl,
			String returnUrl,
			String orderNo,
			//商户参数
			String merchantName,
			String digestAlg,
			String securityCheckCode,
			String bizType,
			String memo,
			// 业务参数
			<#list pars as parm>
			 <#if parm.children??>
			 <#else>
			   <#if parm.secondCode??>
	        ${parm.valType} ${parm.secondCode}<#if (parm_has_next)>,</#if>
	           <#else>
			${parm.valType} ${parm.itemCode}<#if (parm_has_next)>,</#if>
			   </#if>
			 </#if>
		    </#list> 
			){
		// 初始化数据
		<#list pars as parm>
			 <#if "merchOrderNo" ==parm.itemCode>
		merchOrderNo ="merchOrderNo" + System.currentTimeMillis();
			 </#if>
			 <#if "orderNo" ==parm.itemCode>
		orderNo = "orderNo"+System.currentTimeMillis();
			 </#if>
		 </#list>
		//清除数据
		cleanMerchantInfo(orderNo, partnerId, merchantName, service);
		//准备数据
		insertMerchantInfo(merchantName, digestAlg, securityCheckCode, service, memo, bizType, partnerId);
		//测试过程
		<#list childlist as child>
		 <#if child ??>
		 <#list pars as parm>
		   <#if 1 == parm.layer>
		     <#if parm.secondCode ??>
		       <#if child == parm.secondCode>
	    //${parm.itemTitle}
	    List<Map<Object, Object>> ${child} = new ArrayList<Map<Object, Object>>();
		Map<Object,Object> ${child}Map = new HashMap<Object, Object>();
				  <#list pars as parm>
				   <#if 2 == parm.layer>
				    <#if parm.father??>
				     <#if child == parm.father>
		${child}Map.put("${parm.itemCode}", ${parm.secondCode});//${parm.itemTitle}
				     </#if> 
				    </#if> 
				   </#if> 
			      </#list>
		${child}.add(${child}Map);
		       </#if>
		     </#if> 
		   </#if> 
        </#list>
		 </#if>
        </#list>
        //子订单
        <#list childlist as child>
		 <#if child??>
		 <#list pars as parm>
		   <#if 0 == parm.layer>
		     <#if parm.father ??>
		     <#else>
		       <#if child == parm.itemCode>
	    //${parm.itemTitle}
	    List<Map<Object, Object>> ${child} = new ArrayList<Map<Object, Object>>();
		Map<Object,Object> ${child}Map = new HashMap<Object, Object>();
				  <#list pars as parm>
				   <#if 1 == parm.layer>
				    <#if parm.father??>
				     <#if child == parm.father>
	    ${child}Map.put("${parm.itemCode}", ${parm.secondCode});//${parm.itemTitle}
				     </#if> 
				    </#if> 
				   </#if> 
			      </#list>
		${child}.add(${child}Map);
		       </#if>
		     </#if> 
		   </#if> 
        </#list>
		 </#if>
        </#list>
        //主订单
		Map<String, String> dataMap = new HashMap<String, String>();
		buildDataMap(protocol, service, version, partnerId, signType, notifyUrl, returnUrl, orderNo, dataMap);
		<#list pars as parm>
		  <#if parm.father ??>
		  <#else>
		    <#if parm.children??>
		dataMap.put("${parm.itemCode}", JSON.toJSONString(${parm.itemCode}));//${parm.itemTitle}         
		    <#else>
		dataMap.put("${parm.itemCode}", ${parm.itemCode});//${parm.itemTitle}
		    </#if> 
		  </#if> 
        </#list>
        //签名
		String sign = DigestUtil.digest(dataMap, securityCheckCode, DigestUtil.DigestALGEnum.MD5, "UTF-8");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(dataMap);
		map.add("sign", sign);
		System.out.println("map:" + map);
		// 调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(openapiCaTestUrl, map, String.class);
		// 结果验证
		String responseStr = response.toString();
		System.out.println("${serviceName}response:" + responseStr);
	    assertTrue(responseStr.contains("FAIL"));
	}-->
}

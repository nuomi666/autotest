package ${packageName};

import com.alibaba.fastjson.JSON;
import com.xjy.autotest.annotation.AutoTest;
import com.xjy.autotest.testbase.${baseName?lower_case}.${baseName}ApiTestBase;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.*;
import java.text.SimpleDateFormat;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ${author!'huairen'}
 * Created on ${time}.
 */
public class ${className} extends ${baseName}ApiTestBase {

	/**
	 * 1001 ${serviceName}
	 */
    @AutoTest(file = "${projectName}/${funcName}Success.csv")
	@DisplayName("${serviceName}--成功用例")
	void ${funcName}Success(
			int testId,
			<#if menuName??>
				<#if menuName?index_of("POS")!=-1>
            String userName,
            String password,
            String encode,
				</#if>
			</#if>
			<#if projectId??>
				<#if projectId?index_of("39")!=-1>
            String user,
            String pass,
				</#if>
			</#if>
			String url<#if 0 != pars?size>,</#if>
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
	) {
		//初始化数据
		<#list pars as parm>
            <#if "orderNo" ==parm.itemCode>
		orderNo = "orderNo" + System.currentTimeMillis();
            </#if>
            <#if "time" ==parm.itemCode>
		time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            </#if>
        </#list>
        url = ${projectName}TestUrl + "${requestUrl}"<#if requestOrder??> + ${requestOrder}</#if>;
		//清除数据
		//准备数据
		//测试过程
		<#list childlist as child>
		 <#if child ??>
		 <#list pars as parm>
		   <#if 1 == parm.layer>
		     <#if parm.secondCode ??>
		       <#if child == parm.secondCode>
		<#if parm.itemTitle??>//${parm.itemTitle}</#if>
	    List<Map<Object, Object>> ${child} = new ArrayList<Map<Object, Object>>();
		Map<Object,Object> ${child}Map = new HashMap<Object, Object>();
				  <#list pars as parm>
				   <#if 2 == parm.layer>
				    <#if parm.father??>
				     <#if child == parm.father>
		${child}Map.put("${parm.itemCode}", ${parm.secondCode});<#if parm.itemTitle??>//${parm.itemTitle}</#if>
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
		<#if parm.itemTitle??>//${parm.itemTitle}</#if>
	    List<Map<Object, Object>> ${child} = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> ${child}Map = new HashMap<Object, Object>();
				  <#list pars as parm>
				   <#if 1 == parm.layer>
				    <#if parm.father??>
				     <#if child == parm.father>
	    ${child}Map.put("${parm.itemCode}", ${parm.secondCode});<#if parm.itemTitle??>//${parm.itemTitle}</#if>
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
	    <#if requestType ??>
			<#if "1" == requestType>
				<#if 0 != pars?size>
		Map<String, String> map = new HashMap<>();
				</#if>
			<#list pars as parm>
				<#if parm.father ??>
				<#else>
                    <#if 0 == parm.layer>
					    <#if parm.children??>
		map.put("${parm.itemCode}", JSON.parseArray(JSON.toJSONString(${parm.itemCode})));<#if parm.itemTitle??>//${parm.itemTitle}</#if>
					    <#else>
		map.put("${parm.itemCode}", <#if "String" == parm.valType>${parm.itemCode}<#else>String.valueOf(${parm.itemCode})</#if>);<#if parm.itemTitle??>//${parm.itemTitle}</#if>
					    </#if>
					</#if>
				</#if>
			</#list>
		HttpHeaders headers = new HttpHeaders();
			<#if menuName??>
				<#if menuName?index_of("POS")!=-1>
		String token = loginPos(userName, password, encode);
		headers.add("param-token", token);
				</#if>
			</#if>
			<#if projectId??>
				<#if projectId?index_of("39")!=-1>
		String token = loginSquid(user, md5Digest(pass));
		headers.add("param-token", token);
				</#if>
			</#if>
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		<#if 0 != pars?size>
		url += "?" + formatUrlMap(map, false, false);
		</#if>
		//调用接口
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			<#else>
				<#if menuName??>
					<#if menuName?index_of("POS")!=-1>
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
						<#list pars as parm>
							<#if parm.father ??>
							<#else>
                                <#if 0 == parm.layer>
								    <#if parm.children??>
		map.add("${parm.itemCode}", JSON.toJSONString(${parm.itemCode}));<#if parm.itemTitle??>//${parm.itemTitle}</#if>
								    <#else>
		map.add("${parm.itemCode}", ${parm.itemCode});<#if parm.itemTitle??>//${parm.itemTitle}</#if>
								    </#if>
								</#if>
							</#if>
						</#list>
		HttpHeaders headers = new HttpHeaders();
		String token = loginPos(userName, password, encode);
		headers.add("param-token", token);
		HttpEntity<MultiValueMap> entity = new HttpEntity<>(map, headers);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
					<#else>
		Map<String, Object> map = new HashMap<>();
						<#list pars as parm>
							<#if parm.father ??>
							<#else>
                                <#if 0 == parm.layer>
								    <#if parm.children??>
		map.put("${parm.itemCode}", JSON.toJSON(${parm.itemCode}));<#if parm.itemTitle??>//${parm.itemTitle}</#if>
								    <#else>
		map.put("${parm.itemCode}", ${parm.itemCode});<#if parm.itemTitle??>//${parm.itemTitle}</#if>
								    </#if>
								</#if>
							</#if>
						</#list>
		HttpHeaders headers = new HttpHeaders();
						<#if projectId??>
							<#if projectId?index_of("39")!=-1>
		String token = loginSquid(user, md5Digest(pass));
		headers.add("param-token", token);
							</#if>
						</#if>
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> entity = new HttpEntity<>(JSON.toJSONString(map), headers);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
					</#if>
				</#if>
	    	</#if>
		<#else>
		Map<String, Object> map = new HashMap<>();
		<#list pars as parm>
			<#if parm.father ??>
			<#else>
                <#if 0 == parm.layer>
				    <#if parm.children??>
		map.put("${parm.itemCode}", JSON.toJSONString(${parm.itemCode}));<#if parm.itemTitle??>//${parm.itemTitle}</#if>
				    <#else>
		map.put("${parm.itemCode}", ${parm.itemCode});<#if parm.itemTitle??>//${parm.itemTitle}</#if>
				    </#if>
				</#if>
			</#if>
		</#list>
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> entity = new HttpEntity<>(JSON.toJSONString(map), headers);
		//调用接口
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
		</#if>
        //结果验证
        assertExecutedTrue(testId, response);
        //数据验证
		//清除数据
	}
}
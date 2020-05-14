package ${packageName};

import java.util.List;
import java.util.Date;
import com.xjy.autotest.base.AutoTestBase;
import com.xjy.autotest.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Import;
import com.xyb.adk.common.util.money.Money;
import java.math.BigDecimal;
import dal.dao.${projectName}.*;
import dal.model.${projectName}.*;
import com.xjy.autotest.config.${projectName?cap_first}DataSourceConfig;

/**
 * @author ${author!'huairen'}
 * Created on ${time}.
 */
@Service
@Import({
        ${projectName?cap_first}DataSourceConfig.class
})
public class ${className} extends AutoTestBase{
	<#list tableList as table>

	@Autowired
	${table.tableName}DAO ${table.tableName?uncap_first}DAO;
	</#list>

	<#list tableList as table>
	public ${table.tableName}DAO get${table.tableName}DAO() {
		return this.${table.tableName?uncap_first}DAO;
	}

	</#list>
    <#list tableList as table>

    <#--Assert断言方法-->
    /**
	 * 断言${table.table}表
	 */
	public void ${table.tableName?uncap_first}Assert(
	        ${table.tableName}DO ${table.tableName?uncap_first}DO,
			<#list table.pars as par>
			${par.typeName} ${par.name}<#if (par_has_next)>, </#if>
			</#list>
	) {
		<#list table.pars as par>
			<#if par.annotation ??>
        assertEquals(${par.name}, ${table.tableName?uncap_first}DO.get${par.name}());
			<#else>
        assertEquals(${par.name}, ${table.tableName?uncap_first}DO.get${par.name?cap_first}());
			</#if >
	    </#list>
	}

	/**
	 * 断言${table.table}表数据
	 */
	public void assert${table.tableName}(${table.tableName}DO expect, ${table.tableName}DO ${table.tableName?uncap_first}DO) {
		<#list table.pars as par>
			<#if "id" ==par.name>
		if (null == expect.getId() || 0L == expect.getId()) {
			${table.tableName?uncap_first}DO.setId(expect.getId());
		}
			</#if >
			<#if "rawAddTime"==par.name>
		Assertions.assertTrue(null != ${table.tableName?uncap_first}DO.get${par.name?cap_first}());
		expect.set${par.name?cap_first}(${table.tableName?uncap_first}DO.get${par.name?cap_first}());
			</#if >
			<#if "rawUpdateTime"==par.name>
        Assertions.assertTrue(null != ${table.tableName?uncap_first}DO.get${par.name?cap_first}());
		expect.set${par.name?cap_first}(${table.tableName?uncap_first}DO.get${par.name?cap_first}());
			</#if >
		</#list>
		Assertions.assertEquals(expect, ${table.tableName?uncap_first}DO);
	}

	<#--insert插入方法-->
    /**
	 * 插入${table.table}表数据
	 */
	public void insert${table.tableName}(${table.tableName}DO ${table.tableName?uncap_first}DO) {
		${table.tableName?uncap_first}DAO.insert(${table.tableName?uncap_first}DO);
	}

    <#--insert插入方法-->
    /**
	 * 插入${table.table}表数据
	 */
	public void insert${table.tableName}(
			<#list table.pars as par>
			${par.typeName} ${par.name}<#if (par_has_next)>, </#if>
			</#list>
	) {
	    <#list table.pars as par>
	      <#if "rawAddTime" == par.name || "rawUpdateTime" == par.name >
		if (${par.name} == null) {
			${par.name} = new Date();
		}
		  </#if >
	      <#if "Money"==par.typeName>
		if (${par.name} == null) {
			${par.name} = new Money(0);
		}
		  </#if >
		</#list>
		${table.tableName}DO ${table.tableName?uncap_first}DO = new ${table.tableName}DO();
		<#list table.pars as par>
			<#if par.annotation ??>
		${table.tableName?uncap_first}DO.set${par.name}(${par.name});
			<#else>
		${table.tableName?uncap_first}DO.set${par.name?cap_first}(${par.name});
			</#if >
	    </#list>
		${table.tableName?uncap_first}DAO.insert(${table.tableName?uncap_first}DO);
	}

    /**
     * 删除${table.table}表所有数据
     */
    public void clean${table.tableName}() {
        ${table.tableName}DOExample exam = new ${table.tableName}DOExample();
        exam.createCriteria();
        ${table.tableName?uncap_first}DAO.deleteByExample(exam);
    }

	<#list table.pars as par>
		<#list table.pls as pl>
          <#if pl?index_of(par.comment) == 0>
            <#list table.pars as pa>
              <#if pl?ends_with(pa.comment)>
	/**
	 * 根据${par.name},${pa.name}删除${table.table}表数据
	 */
	public void clean${table.tableName}By${par.name?cap_first}And${pa.name?cap_first}(${par.typeName} ${par.name},${pa.typeName} ${pa.name}) {
		<#if "String"==par.typeName>
        if (StringUtils.isBlank(${par.name})){
            ${par.name} = "test_${par.name}";
        }
        </#if >
		<#if "String"==pa.typeName>
        if (StringUtils.isBlank(${pa.name})){
            ${pa.name} = "test_${pa.name}";
        }
        </#if >
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name}).and${pa.name?cap_first}EqualTo(${pa.name});
		${table.tableName?uncap_first}DAO.deleteByExample(exam);
	}
              </#if>
            </#list>
          </#if>
	    </#list>
		  <#if par.name?index_of("versionId")!=-1>
			  <#continue>
		  </#if>
		  <#if par.name?index_of("Id")!=-1 || par.name?index_of("id")!=-1>

	/**
	 * 根据${par.name}删除${table.table}表数据
	 */
	public void clean${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
		<#if "String"==par.typeName>
        if (StringUtils.isBlank(${par.name})){
            ${par.name} = "test_${par.name}";
        }
        </#if >
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		${table.tableName?uncap_first}DAO.deleteByExample(exam);
	}
		  </#if>
		  <#if par.name?index_of("No")!=-1 || par.name?index_of("mobile")!=-1>

	/**
	 * 根据${par.name}删除${table.table}表数据
	 */
	public void clean${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
        <#if "String"==par.typeName>
        if (StringUtils.isBlank(${par.name})){
            ${par.name} = "test_${par.name}";
        }
        </#if >
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		${table.tableName?uncap_first}DAO.deleteByExample(exam);
	}
		  </#if>
		<#if par.name?index_of("Name")!=-1 || par.name?index_of("name")!=-1>

	/**
	* 根据${par.name}删除${table.table}表数据
	*/
	public void clean${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
        <#if "String"==par.typeName>
        if (StringUtils.isBlank(${par.name})){
            ${par.name} = "test_${par.name}";
        }
        </#if >
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		${table.tableName?uncap_first}DAO.deleteByExample(exam);
	}
		</#if>
		<#if par.name?index_of("Number")!=-1>

	/**
	* 根据${par.name}删除${table.table}表数据
	*/
	public void clean${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
        <#if "String"==par.typeName>
        if (StringUtils.isBlank(${par.name})){
            ${par.name} = "test_${par.name}";
        }
        </#if >
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		${table.tableName?uncap_first}DAO.deleteByExample(exam);
	}
		</#if>
		<#if par.name?index_of("Code")!=-1 || par.name?index_of("code")!=-1>

	/**
	* 根据${par.name}删除${table.table}表数据
	*/
	public void clean${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
        <#if "String"==par.typeName>
        if (StringUtils.isBlank(${par.name})){
            ${par.name} = "test_${par.name}";
        }
        </#if >		
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		${table.tableName?uncap_first}DAO.deleteByExample(exam);
	}
		</#if>
	</#list>

    /**
     * 查询${table.table}表所有数据
     */
    public List<${table.tableName}DO> find${table.tableName}All() {
        ${table.tableName}DOExample exam = new ${table.tableName}DOExample();
        exam.createCriteria();
		return ${table.tableName?uncap_first}DAO.selectByExample(exam);
    }
	<#list table.pars as par>
		<#list table.pls as pl>
          <#if pl?index_of(par.comment) == 0>
            <#list table.pars as pa>
              <#if pl?ends_with(pa.comment)>

	/**
	 * 根据${par.name},${pa.name}查询${table.table}表数据
	 */
	public List<${table.tableName}DO> find${table.tableName}By${par.name?cap_first}And${pa.name?cap_first}(${par.typeName} ${par.name},${pa.typeName} ${pa.name}) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name}).and${pa.name?cap_first}EqualTo(${pa.name});
		return ${table.tableName?uncap_first}DAO.selectByExample(exam);
	}
              </#if>
            </#list>
          </#if>
	    </#list>
		<#if par.name?index_of("versionId")!=-1>
			<#continue>
		</#if>
		  <#if par.name?index_of("Id")!=-1 || par.name?index_of("id")!=-1>

    /**
	 * 根据${par.name}查询${table.table}表数据
	 */
	public List<${table.tableName}DO> find${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		return ${table.tableName?uncap_first}DAO.selectByExample(exam);
	}
		  </#if>
		  <#if par.name?index_of("No")!=-1 || par.name?index_of("mobile")!=-1>

    /**
	 * 根据${par.name}查询${table.table}表数据
	 */
	public List<${table.tableName}DO> find${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		return ${table.tableName?uncap_first}DAO.selectByExample(exam);
	}
		  </#if>
		<#if par.name?index_of("Name")!=-1 || par.name?index_of("name")!=-1>

	/**
	* 根据${par.name}查询${table.table}表数据
	*/
	public List<${table.tableName}DO> find${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		return ${table.tableName?uncap_first}DAO.selectByExample(exam);
	}
		</#if>
		<#if par.name?index_of("Number")!=-1>

	/**
	* 根据${par.name}查询${table.table}表数据
	*/
	public List<${table.tableName}DO> find${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		return ${table.tableName?uncap_first}DAO.selectByExample(exam);
	}
		</#if>
        <#if par.name?index_of("Code")!=-1 || par.name?index_of("code")!=-1>

	/**
	* 根据${par.name}查询${table.table}表数据
	*/
	public List<${table.tableName}DO> find${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name}) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		return ${table.tableName?uncap_first}DAO.selectByExample(exam);
	}
		</#if>
	</#list>
    <#list table.pars as par>
		<#list table.pls as pl>
          <#if pl?index_of(par.comment) == 0>
            <#list table.pars as pa>
              <#if pl?ends_with(pa.comment)>

	/**
	 * 根据${par.name},${pa.name}更新${table.table}表数据
	 */
	public void update${table.tableName}By${par.name?cap_first}And${pa.name?cap_first}(${par.typeName} ${par.name},${pa.typeName} ${pa.name},${table.tableName}DO ${table.tableName?uncap_first}DO) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name}).and${pa.name?cap_first}EqualTo(${pa.name});
		${table.tableName?uncap_first}DAO.updateByExample(${table.tableName?uncap_first}DO, exam);
	}
              </#if>
            </#list>
          </#if>
	    </#list>
		<#if par.name?index_of("versionId")!=-1>
			<#continue>
		</#if>
		  <#if par.name?index_of("Id")!=-1 || par.name?index_of("id")!=-1>

    /**
	 * 根据${par.name}更新${table.table}表数据
	 */
	public void update${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name},${table.tableName}DO ${table.tableName?uncap_first}DO) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		${table.tableName?uncap_first}DAO.updateByExample(${table.tableName?uncap_first}DO, exam);
	}
		  </#if>
	  <#if par.name?index_of("No")!=-1 || par.name?index_of("mobile")!=-1>

    /**
	 * 根据${par.name}更新${table.table}表数据
	 */
	public void update${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name},${table.tableName}DO ${table.tableName?uncap_first}DO) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		${table.tableName?uncap_first}DAO.updateByExample(${table.tableName?uncap_first}DO, exam);
	}
	  </#if>
		<#if par.name?index_of("Name")!=-1 || par.name?index_of("name")!=-1>

	/**
	* 根据${par.name}更新${table.table}表数据
	*/
	public void update${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name},${table.tableName}DO ${table.tableName?uncap_first}DO) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		${table.tableName?uncap_first}DAO.updateByExample(${table.tableName?uncap_first}DO, exam);
	}
		</#if>
        <#if par.name?index_of("Code")!=-1 || par.name?index_of("code")!=-1>

	/**
	* 根据${par.name}更新${table.table}表数据
	*/
	public void update${table.tableName}By${par.name?cap_first}(${par.typeName} ${par.name},${table.tableName}DO ${table.tableName?uncap_first}DO) {
		${table.tableName}DOExample exam = new ${table.tableName}DOExample();
		exam.createCriteria().and${par.name?cap_first}EqualTo(${par.name});
		${table.tableName?uncap_first}DAO.updateByExample(${table.tableName?uncap_first}DO, exam);
	}
		</#if>
	</#list>
	</#list>
}

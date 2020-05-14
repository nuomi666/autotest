package ${packageName};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.xjy.autotest.base.IntegrationTestBase;
<#list tableList as table>
import dal.dao.${projectName}.${table.tableName}DAO;
</#list>

/**
 * Created by ${author!'huairen'} on ${time}.
 */
@ContextConfiguration({
        "/dal/dal-db-${projectName}.xml"
})
public class ${className} extends IntegrationTestBase{
    <#list tableList as table>
		
	@Autowired
	protected ${table.tableName}DAO ${table.tableName?uncap_first}DAO;
    </#list>
	
}

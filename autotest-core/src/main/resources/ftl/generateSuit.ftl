package ${packageName};

import com.xjy.autotest.${projectName}.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * @author ${author!'huairen'}
 * Created on ${time}.
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({
<#list list as fileName>
        ${fileName}.class,
</#list>
})
public class ${projectName?cap_first}CaseSuit {
}

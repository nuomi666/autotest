package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.RuleConditionDO;
import dal.model.gas_marketpc.RuleConditionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RuleConditionDAO extends MyMapper<RuleConditionDO> {
    long countByExample(RuleConditionDOExample example);

    int deleteByExample(RuleConditionDOExample example);

    List<RuleConditionDO> selectByExample(RuleConditionDOExample example);

    int updateByExampleSelective(@Param("record") RuleConditionDO record, @Param("example") RuleConditionDOExample example);

    int updateByExample(@Param("record") RuleConditionDO record, @Param("example") RuleConditionDOExample example);
}
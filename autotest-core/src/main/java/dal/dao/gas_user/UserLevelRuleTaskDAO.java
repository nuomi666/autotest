package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.UserLevelRuleTaskDO;
import dal.model.gas_user.UserLevelRuleTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLevelRuleTaskDAO extends MyMapper<UserLevelRuleTaskDO> {
    long countByExample(UserLevelRuleTaskDOExample example);

    int deleteByExample(UserLevelRuleTaskDOExample example);

    List<UserLevelRuleTaskDO> selectByExample(UserLevelRuleTaskDOExample example);

    int updateByExampleSelective(@Param("record") UserLevelRuleTaskDO record, @Param("example") UserLevelRuleTaskDOExample example);

    int updateByExample(@Param("record") UserLevelRuleTaskDO record, @Param("example") UserLevelRuleTaskDOExample example);
}
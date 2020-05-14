package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.UserLevelRuleDO;
import dal.model.gas_user.UserLevelRuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLevelRuleDAO extends MyMapper<UserLevelRuleDO> {
    long countByExample(UserLevelRuleDOExample example);

    int deleteByExample(UserLevelRuleDOExample example);

    List<UserLevelRuleDO> selectByExample(UserLevelRuleDOExample example);

    int updateByExampleSelective(@Param("record") UserLevelRuleDO record, @Param("example") UserLevelRuleDOExample example);

    int updateByExample(@Param("record") UserLevelRuleDO record, @Param("example") UserLevelRuleDOExample example);
}
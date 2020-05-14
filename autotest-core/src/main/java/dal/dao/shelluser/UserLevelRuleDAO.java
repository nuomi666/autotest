package dal.dao.shelluser;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shelluser.UserLevelRuleDO;
import dal.model.shelluser.UserLevelRuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLevelRuleDAO extends MyMapper<UserLevelRuleDO> {
    long countByExample(UserLevelRuleDOExample example);

    int deleteByExample(UserLevelRuleDOExample example);

    List<UserLevelRuleDO> selectByExample(UserLevelRuleDOExample example);

    int updateByExampleSelective(@Param("record") UserLevelRuleDO record, @Param("example") UserLevelRuleDOExample example);

    int updateByExample(@Param("record") UserLevelRuleDO record, @Param("example") UserLevelRuleDOExample example);
}
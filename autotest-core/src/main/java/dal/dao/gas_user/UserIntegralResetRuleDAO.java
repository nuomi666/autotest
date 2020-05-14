package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.UserIntegralResetRuleDO;
import dal.model.gas_user.UserIntegralResetRuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserIntegralResetRuleDAO extends MyMapper<UserIntegralResetRuleDO> {
    long countByExample(UserIntegralResetRuleDOExample example);

    int deleteByExample(UserIntegralResetRuleDOExample example);

    List<UserIntegralResetRuleDO> selectByExample(UserIntegralResetRuleDOExample example);

    int updateByExampleSelective(@Param("record") UserIntegralResetRuleDO record, @Param("example") UserIntegralResetRuleDOExample example);

    int updateByExample(@Param("record") UserIntegralResetRuleDO record, @Param("example") UserIntegralResetRuleDOExample example);
}
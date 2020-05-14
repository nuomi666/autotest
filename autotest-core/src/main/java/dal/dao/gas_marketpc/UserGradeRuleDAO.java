package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.UserGradeRuleDO;
import dal.model.gas_marketpc.UserGradeRuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGradeRuleDAO extends MyMapper<UserGradeRuleDO> {
    long countByExample(UserGradeRuleDOExample example);

    int deleteByExample(UserGradeRuleDOExample example);

    List<UserGradeRuleDO> selectByExample(UserGradeRuleDOExample example);

    int updateByExampleSelective(@Param("record") UserGradeRuleDO record, @Param("example") UserGradeRuleDOExample example);

    int updateByExample(@Param("record") UserGradeRuleDO record, @Param("example") UserGradeRuleDOExample example);
}
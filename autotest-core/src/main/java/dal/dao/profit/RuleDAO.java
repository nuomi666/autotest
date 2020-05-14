package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.RuleDO;
import dal.model.profit.RuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RuleDAO extends MyMapper<RuleDO> {
    long countByExample(RuleDOExample example);

    int deleteByExample(RuleDOExample example);

    List<RuleDO> selectByExample(RuleDOExample example);

    int updateByExampleSelective(@Param("record") RuleDO record, @Param("example") RuleDOExample example);

    int updateByExample(@Param("record") RuleDO record, @Param("example") RuleDOExample example);
}
package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.ConditionStrategyDO;
import dal.model.profit.ConditionStrategyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConditionStrategyDAO extends MyMapper<ConditionStrategyDO> {
    long countByExample(ConditionStrategyDOExample example);

    int deleteByExample(ConditionStrategyDOExample example);

    List<ConditionStrategyDO> selectByExampleWithBLOBs(ConditionStrategyDOExample example);

    List<ConditionStrategyDO> selectByExample(ConditionStrategyDOExample example);

    int updateByExampleSelective(@Param("record") ConditionStrategyDO record, @Param("example") ConditionStrategyDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ConditionStrategyDO record, @Param("example") ConditionStrategyDOExample example);

    int updateByExample(@Param("record") ConditionStrategyDO record, @Param("example") ConditionStrategyDOExample example);
}
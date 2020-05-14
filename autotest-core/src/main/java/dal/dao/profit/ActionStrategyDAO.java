package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.ActionStrategyDO;
import dal.model.profit.ActionStrategyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActionStrategyDAO extends MyMapper<ActionStrategyDO> {
    long countByExample(ActionStrategyDOExample example);

    int deleteByExample(ActionStrategyDOExample example);

    List<ActionStrategyDO> selectByExample(ActionStrategyDOExample example);

    int updateByExampleSelective(@Param("record") ActionStrategyDO record, @Param("example") ActionStrategyDOExample example);

    int updateByExample(@Param("record") ActionStrategyDO record, @Param("example") ActionStrategyDOExample example);
}
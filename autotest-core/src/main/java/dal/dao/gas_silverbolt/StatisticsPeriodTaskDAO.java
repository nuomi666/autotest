package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsPeriodTaskDO;
import dal.model.gas_silverbolt.StatisticsPeriodTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsPeriodTaskDAO extends MyMapper<StatisticsPeriodTaskDO> {
    long countByExample(StatisticsPeriodTaskDOExample example);

    int deleteByExample(StatisticsPeriodTaskDOExample example);

    List<StatisticsPeriodTaskDO> selectByExample(StatisticsPeriodTaskDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsPeriodTaskDO record, @Param("example") StatisticsPeriodTaskDOExample example);

    int updateByExample(@Param("record") StatisticsPeriodTaskDO record, @Param("example") StatisticsPeriodTaskDOExample example);
}
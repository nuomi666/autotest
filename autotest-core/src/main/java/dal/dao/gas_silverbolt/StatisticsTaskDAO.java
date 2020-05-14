package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsTaskDO;
import dal.model.gas_silverbolt.StatisticsTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsTaskDAO extends MyMapper<StatisticsTaskDO> {
    long countByExample(StatisticsTaskDOExample example);

    int deleteByExample(StatisticsTaskDOExample example);

    List<StatisticsTaskDO> selectByExample(StatisticsTaskDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsTaskDO record, @Param("example") StatisticsTaskDOExample example);

    int updateByExample(@Param("record") StatisticsTaskDO record, @Param("example") StatisticsTaskDOExample example);
}
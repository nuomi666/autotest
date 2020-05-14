package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsSpoutDO;
import dal.model.gas_silverbolt.StatisticsSpoutDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsSpoutDAO extends MyMapper<StatisticsSpoutDO> {
    long countByExample(StatisticsSpoutDOExample example);

    int deleteByExample(StatisticsSpoutDOExample example);

    List<StatisticsSpoutDO> selectByExample(StatisticsSpoutDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsSpoutDO record, @Param("example") StatisticsSpoutDOExample example);

    int updateByExample(@Param("record") StatisticsSpoutDO record, @Param("example") StatisticsSpoutDOExample example);
}
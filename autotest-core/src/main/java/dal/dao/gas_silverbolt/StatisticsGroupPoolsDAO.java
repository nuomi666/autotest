package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsGroupPoolsDO;
import dal.model.gas_silverbolt.StatisticsGroupPoolsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsGroupPoolsDAO extends MyMapper<StatisticsGroupPoolsDO> {
    long countByExample(StatisticsGroupPoolsDOExample example);

    int deleteByExample(StatisticsGroupPoolsDOExample example);

    List<StatisticsGroupPoolsDO> selectByExample(StatisticsGroupPoolsDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsGroupPoolsDO record, @Param("example") StatisticsGroupPoolsDOExample example);

    int updateByExample(@Param("record") StatisticsGroupPoolsDO record, @Param("example") StatisticsGroupPoolsDOExample example);
}
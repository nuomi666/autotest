package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsDataDO;
import dal.model.gas_silverbolt.StatisticsDataDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsDataDAO extends MyMapper<StatisticsDataDO> {
    long countByExample(StatisticsDataDOExample example);

    int deleteByExample(StatisticsDataDOExample example);

    List<StatisticsDataDO> selectByExampleWithBLOBs(StatisticsDataDOExample example);

    List<StatisticsDataDO> selectByExample(StatisticsDataDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsDataDO record, @Param("example") StatisticsDataDOExample example);

    int updateByExampleWithBLOBs(@Param("record") StatisticsDataDO record, @Param("example") StatisticsDataDOExample example);

    int updateByExample(@Param("record") StatisticsDataDO record, @Param("example") StatisticsDataDOExample example);
}
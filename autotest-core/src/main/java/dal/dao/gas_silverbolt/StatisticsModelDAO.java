package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsModelDO;
import dal.model.gas_silverbolt.StatisticsModelDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsModelDAO extends MyMapper<StatisticsModelDO> {
    long countByExample(StatisticsModelDOExample example);

    int deleteByExample(StatisticsModelDOExample example);

    List<StatisticsModelDO> selectByExample(StatisticsModelDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsModelDO record, @Param("example") StatisticsModelDOExample example);

    int updateByExample(@Param("record") StatisticsModelDO record, @Param("example") StatisticsModelDOExample example);
}
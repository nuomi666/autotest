package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsSourceDO;
import dal.model.gas_silverbolt.StatisticsSourceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsSourceDAO extends MyMapper<StatisticsSourceDO> {
    long countByExample(StatisticsSourceDOExample example);

    int deleteByExample(StatisticsSourceDOExample example);

    List<StatisticsSourceDO> selectByExample(StatisticsSourceDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsSourceDO record, @Param("example") StatisticsSourceDOExample example);

    int updateByExample(@Param("record") StatisticsSourceDO record, @Param("example") StatisticsSourceDOExample example);
}
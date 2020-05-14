package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsGroupColumnDO;
import dal.model.gas_silverbolt.StatisticsGroupColumnDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsGroupColumnDAO extends MyMapper<StatisticsGroupColumnDO> {
    long countByExample(StatisticsGroupColumnDOExample example);

    int deleteByExample(StatisticsGroupColumnDOExample example);

    List<StatisticsGroupColumnDO> selectByExample(StatisticsGroupColumnDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsGroupColumnDO record, @Param("example") StatisticsGroupColumnDOExample example);

    int updateByExample(@Param("record") StatisticsGroupColumnDO record, @Param("example") StatisticsGroupColumnDOExample example);
}
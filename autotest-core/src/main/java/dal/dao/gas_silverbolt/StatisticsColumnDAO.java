package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsColumnDO;
import dal.model.gas_silverbolt.StatisticsColumnDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsColumnDAO extends MyMapper<StatisticsColumnDO> {
    long countByExample(StatisticsColumnDOExample example);

    int deleteByExample(StatisticsColumnDOExample example);

    List<StatisticsColumnDO> selectByExample(StatisticsColumnDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsColumnDO record, @Param("example") StatisticsColumnDOExample example);

    int updateByExample(@Param("record") StatisticsColumnDO record, @Param("example") StatisticsColumnDOExample example);
}
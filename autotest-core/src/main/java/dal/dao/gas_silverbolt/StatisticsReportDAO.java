package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsReportDO;
import dal.model.gas_silverbolt.StatisticsReportDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsReportDAO extends MyMapper<StatisticsReportDO> {
    long countByExample(StatisticsReportDOExample example);

    int deleteByExample(StatisticsReportDOExample example);

    List<StatisticsReportDO> selectByExampleWithBLOBs(StatisticsReportDOExample example);

    List<StatisticsReportDO> selectByExample(StatisticsReportDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsReportDO record, @Param("example") StatisticsReportDOExample example);

    int updateByExampleWithBLOBs(@Param("record") StatisticsReportDO record, @Param("example") StatisticsReportDOExample example);

    int updateByExample(@Param("record") StatisticsReportDO record, @Param("example") StatisticsReportDOExample example);
}
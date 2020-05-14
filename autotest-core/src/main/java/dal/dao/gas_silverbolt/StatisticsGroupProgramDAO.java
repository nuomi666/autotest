package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.StatisticsGroupProgramDO;
import dal.model.gas_silverbolt.StatisticsGroupProgramDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsGroupProgramDAO extends MyMapper<StatisticsGroupProgramDO> {
    long countByExample(StatisticsGroupProgramDOExample example);

    int deleteByExample(StatisticsGroupProgramDOExample example);

    List<StatisticsGroupProgramDO> selectByExampleWithBLOBs(StatisticsGroupProgramDOExample example);

    List<StatisticsGroupProgramDO> selectByExample(StatisticsGroupProgramDOExample example);

    int updateByExampleSelective(@Param("record") StatisticsGroupProgramDO record, @Param("example") StatisticsGroupProgramDOExample example);

    int updateByExampleWithBLOBs(@Param("record") StatisticsGroupProgramDO record, @Param("example") StatisticsGroupProgramDOExample example);

    int updateByExample(@Param("record") StatisticsGroupProgramDO record, @Param("example") StatisticsGroupProgramDOExample example);
}
package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.ReportTaskDO;
import dal.model.gas_silverbolt.ReportTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportTaskDAO extends MyMapper<ReportTaskDO> {
    long countByExample(ReportTaskDOExample example);

    int deleteByExample(ReportTaskDOExample example);

    List<ReportTaskDO> selectByExample(ReportTaskDOExample example);

    int updateByExampleSelective(@Param("record") ReportTaskDO record, @Param("example") ReportTaskDOExample example);

    int updateByExample(@Param("record") ReportTaskDO record, @Param("example") ReportTaskDOExample example);
}
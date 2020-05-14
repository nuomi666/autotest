package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.ReportExportTaskDO;
import dal.model.gas_silverbolt.ReportExportTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportExportTaskDAO extends MyMapper<ReportExportTaskDO> {
    long countByExample(ReportExportTaskDOExample example);

    int deleteByExample(ReportExportTaskDOExample example);

    List<ReportExportTaskDO> selectByExample(ReportExportTaskDOExample example);

    int updateByExampleSelective(@Param("record") ReportExportTaskDO record, @Param("example") ReportExportTaskDOExample example);

    int updateByExample(@Param("record") ReportExportTaskDO record, @Param("example") ReportExportTaskDOExample example);
}
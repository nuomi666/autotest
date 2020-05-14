package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.TaskExecuteRecordDO;
import dal.model.profit.TaskExecuteRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskExecuteRecordDAO extends MyMapper<TaskExecuteRecordDO> {
    long countByExample(TaskExecuteRecordDOExample example);

    int deleteByExample(TaskExecuteRecordDOExample example);

    List<TaskExecuteRecordDO> selectByExample(TaskExecuteRecordDOExample example);

    int updateByExampleSelective(@Param("record") TaskExecuteRecordDO record, @Param("example") TaskExecuteRecordDOExample example);

    int updateByExample(@Param("record") TaskExecuteRecordDO record, @Param("example") TaskExecuteRecordDOExample example);
}
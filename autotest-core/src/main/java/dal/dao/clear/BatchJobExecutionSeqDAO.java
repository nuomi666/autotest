package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BatchJobExecutionSeqDO;
import dal.model.clear.BatchJobExecutionSeqDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchJobExecutionSeqDAO extends MyMapper<BatchJobExecutionSeqDO> {
    long countByExample(BatchJobExecutionSeqDOExample example);

    int deleteByExample(BatchJobExecutionSeqDOExample example);

    List<BatchJobExecutionSeqDO> selectByExample(BatchJobExecutionSeqDOExample example);

    int updateByExampleSelective(@Param("record") BatchJobExecutionSeqDO record, @Param("example") BatchJobExecutionSeqDOExample example);

    int updateByExample(@Param("record") BatchJobExecutionSeqDO record, @Param("example") BatchJobExecutionSeqDOExample example);
}
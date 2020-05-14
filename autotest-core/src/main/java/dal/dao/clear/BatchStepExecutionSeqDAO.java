package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BatchStepExecutionSeqDO;
import dal.model.clear.BatchStepExecutionSeqDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchStepExecutionSeqDAO extends MyMapper<BatchStepExecutionSeqDO> {
    long countByExample(BatchStepExecutionSeqDOExample example);

    int deleteByExample(BatchStepExecutionSeqDOExample example);

    List<BatchStepExecutionSeqDO> selectByExample(BatchStepExecutionSeqDOExample example);

    int updateByExampleSelective(@Param("record") BatchStepExecutionSeqDO record, @Param("example") BatchStepExecutionSeqDOExample example);

    int updateByExample(@Param("record") BatchStepExecutionSeqDO record, @Param("example") BatchStepExecutionSeqDOExample example);
}
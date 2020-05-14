package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BatchJobExecutionContextDO;
import dal.model.clear.BatchJobExecutionContextDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchJobExecutionContextDAO extends MyMapper<BatchJobExecutionContextDO> {
    long countByExample(BatchJobExecutionContextDOExample example);

    int deleteByExample(BatchJobExecutionContextDOExample example);

    List<BatchJobExecutionContextDO> selectByExampleWithBLOBs(BatchJobExecutionContextDOExample example);

    List<BatchJobExecutionContextDO> selectByExample(BatchJobExecutionContextDOExample example);

    int updateByExampleSelective(@Param("record") BatchJobExecutionContextDO record, @Param("example") BatchJobExecutionContextDOExample example);

    int updateByExampleWithBLOBs(@Param("record") BatchJobExecutionContextDO record, @Param("example") BatchJobExecutionContextDOExample example);

    int updateByExample(@Param("record") BatchJobExecutionContextDO record, @Param("example") BatchJobExecutionContextDOExample example);
}
package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.BatchStepExecutionContextDO;
import dal.model.pay.BatchStepExecutionContextDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchStepExecutionContextDAO extends MyMapper<BatchStepExecutionContextDO> {
    long countByExample(BatchStepExecutionContextDOExample example);

    int deleteByExample(BatchStepExecutionContextDOExample example);

    List<BatchStepExecutionContextDO> selectByExampleWithBLOBs(BatchStepExecutionContextDOExample example);

    List<BatchStepExecutionContextDO> selectByExample(BatchStepExecutionContextDOExample example);

    int updateByExampleSelective(@Param("record") BatchStepExecutionContextDO record, @Param("example") BatchStepExecutionContextDOExample example);

    int updateByExampleWithBLOBs(@Param("record") BatchStepExecutionContextDO record, @Param("example") BatchStepExecutionContextDOExample example);

    int updateByExample(@Param("record") BatchStepExecutionContextDO record, @Param("example") BatchStepExecutionContextDOExample example);
}
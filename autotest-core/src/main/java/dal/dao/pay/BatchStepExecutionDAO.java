package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.BatchStepExecutionDO;
import dal.model.pay.BatchStepExecutionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchStepExecutionDAO extends MyMapper<BatchStepExecutionDO> {
    long countByExample(BatchStepExecutionDOExample example);

    int deleteByExample(BatchStepExecutionDOExample example);

    List<BatchStepExecutionDO> selectByExample(BatchStepExecutionDOExample example);

    int updateByExampleSelective(@Param("record") BatchStepExecutionDO record, @Param("example") BatchStepExecutionDOExample example);

    int updateByExample(@Param("record") BatchStepExecutionDO record, @Param("example") BatchStepExecutionDOExample example);
}
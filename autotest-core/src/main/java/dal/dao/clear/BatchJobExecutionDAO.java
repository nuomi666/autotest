package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BatchJobExecutionDO;
import dal.model.clear.BatchJobExecutionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchJobExecutionDAO extends MyMapper<BatchJobExecutionDO> {
    long countByExample(BatchJobExecutionDOExample example);

    int deleteByExample(BatchJobExecutionDOExample example);

    List<BatchJobExecutionDO> selectByExample(BatchJobExecutionDOExample example);

    int updateByExampleSelective(@Param("record") BatchJobExecutionDO record, @Param("example") BatchJobExecutionDOExample example);

    int updateByExample(@Param("record") BatchJobExecutionDO record, @Param("example") BatchJobExecutionDOExample example);
}
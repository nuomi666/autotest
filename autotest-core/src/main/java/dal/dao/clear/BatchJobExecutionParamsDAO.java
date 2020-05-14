package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BatchJobExecutionParamsDO;
import dal.model.clear.BatchJobExecutionParamsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchJobExecutionParamsDAO extends MyMapper<BatchJobExecutionParamsDO> {
    long countByExample(BatchJobExecutionParamsDOExample example);

    int deleteByExample(BatchJobExecutionParamsDOExample example);

    List<BatchJobExecutionParamsDO> selectByExample(BatchJobExecutionParamsDOExample example);

    int updateByExampleSelective(@Param("record") BatchJobExecutionParamsDO record, @Param("example") BatchJobExecutionParamsDOExample example);

    int updateByExample(@Param("record") BatchJobExecutionParamsDO record, @Param("example") BatchJobExecutionParamsDOExample example);
}
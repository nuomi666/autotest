package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearDsgjResultLogDO;
import dal.model.clear.ClearDsgjResultLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearDsgjResultLogDAO extends MyMapper<ClearDsgjResultLogDO> {
    long countByExample(ClearDsgjResultLogDOExample example);

    int deleteByExample(ClearDsgjResultLogDOExample example);

    List<ClearDsgjResultLogDO> selectByExample(ClearDsgjResultLogDOExample example);

    int updateByExampleSelective(@Param("record") ClearDsgjResultLogDO record, @Param("example") ClearDsgjResultLogDOExample example);

    int updateByExample(@Param("record") ClearDsgjResultLogDO record, @Param("example") ClearDsgjResultLogDOExample example);
}
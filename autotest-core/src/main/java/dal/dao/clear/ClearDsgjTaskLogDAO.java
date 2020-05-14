package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearDsgjTaskLogDO;
import dal.model.clear.ClearDsgjTaskLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearDsgjTaskLogDAO extends MyMapper<ClearDsgjTaskLogDO> {
    long countByExample(ClearDsgjTaskLogDOExample example);

    int deleteByExample(ClearDsgjTaskLogDOExample example);

    List<ClearDsgjTaskLogDO> selectByExampleWithBLOBs(ClearDsgjTaskLogDOExample example);

    List<ClearDsgjTaskLogDO> selectByExample(ClearDsgjTaskLogDOExample example);

    int updateByExampleSelective(@Param("record") ClearDsgjTaskLogDO record, @Param("example") ClearDsgjTaskLogDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ClearDsgjTaskLogDO record, @Param("example") ClearDsgjTaskLogDOExample example);

    int updateByExample(@Param("record") ClearDsgjTaskLogDO record, @Param("example") ClearDsgjTaskLogDOExample example);
}
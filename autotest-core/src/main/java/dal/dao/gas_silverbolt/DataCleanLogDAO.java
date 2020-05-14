package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.DataCleanLogDO;
import dal.model.gas_silverbolt.DataCleanLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataCleanLogDAO extends MyMapper<DataCleanLogDO> {
    long countByExample(DataCleanLogDOExample example);

    int deleteByExample(DataCleanLogDOExample example);

    List<DataCleanLogDO> selectByExample(DataCleanLogDOExample example);

    int updateByExampleSelective(@Param("record") DataCleanLogDO record, @Param("example") DataCleanLogDOExample example);

    int updateByExample(@Param("record") DataCleanLogDO record, @Param("example") DataCleanLogDOExample example);
}
package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.DataCleanTaskDO;
import dal.model.gas_silverbolt.DataCleanTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataCleanTaskDAO extends MyMapper<DataCleanTaskDO> {
    long countByExample(DataCleanTaskDOExample example);

    int deleteByExample(DataCleanTaskDOExample example);

    List<DataCleanTaskDO> selectByExample(DataCleanTaskDOExample example);

    int updateByExampleSelective(@Param("record") DataCleanTaskDO record, @Param("example") DataCleanTaskDOExample example);

    int updateByExample(@Param("record") DataCleanTaskDO record, @Param("example") DataCleanTaskDOExample example);
}
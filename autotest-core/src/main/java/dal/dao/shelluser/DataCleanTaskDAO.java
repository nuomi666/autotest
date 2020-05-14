package dal.dao.shelluser;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shelluser.DataCleanTaskDO;
import dal.model.shelluser.DataCleanTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataCleanTaskDAO extends MyMapper<DataCleanTaskDO> {
    long countByExample(DataCleanTaskDOExample example);

    int deleteByExample(DataCleanTaskDOExample example);

    List<DataCleanTaskDO> selectByExample(DataCleanTaskDOExample example);

    int updateByExampleSelective(@Param("record") DataCleanTaskDO record, @Param("example") DataCleanTaskDOExample example);

    int updateByExample(@Param("record") DataCleanTaskDO record, @Param("example") DataCleanTaskDOExample example);
}
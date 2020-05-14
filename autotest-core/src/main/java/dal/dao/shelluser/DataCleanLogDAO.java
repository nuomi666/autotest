package dal.dao.shelluser;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shelluser.DataCleanLogDO;
import dal.model.shelluser.DataCleanLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataCleanLogDAO extends MyMapper<DataCleanLogDO> {
    long countByExample(DataCleanLogDOExample example);

    int deleteByExample(DataCleanLogDOExample example);

    List<DataCleanLogDO> selectByExample(DataCleanLogDOExample example);

    int updateByExampleSelective(@Param("record") DataCleanLogDO record, @Param("example") DataCleanLogDOExample example);

    int updateByExample(@Param("record") DataCleanLogDO record, @Param("example") DataCleanLogDOExample example);
}
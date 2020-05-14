package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearChannelTaskLogDO;
import dal.model.clear.ClearChannelTaskLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearChannelTaskLogDAO extends MyMapper<ClearChannelTaskLogDO> {
    long countByExample(ClearChannelTaskLogDOExample example);

    int deleteByExample(ClearChannelTaskLogDOExample example);

    List<ClearChannelTaskLogDO> selectByExample(ClearChannelTaskLogDOExample example);

    int updateByExampleSelective(@Param("record") ClearChannelTaskLogDO record, @Param("example") ClearChannelTaskLogDOExample example);

    int updateByExample(@Param("record") ClearChannelTaskLogDO record, @Param("example") ClearChannelTaskLogDOExample example);
}
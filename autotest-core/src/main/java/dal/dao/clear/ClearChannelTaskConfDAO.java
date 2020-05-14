package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearChannelTaskConfDO;
import dal.model.clear.ClearChannelTaskConfDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearChannelTaskConfDAO extends MyMapper<ClearChannelTaskConfDO> {
    long countByExample(ClearChannelTaskConfDOExample example);

    int deleteByExample(ClearChannelTaskConfDOExample example);

    List<ClearChannelTaskConfDO> selectByExample(ClearChannelTaskConfDOExample example);

    int updateByExampleSelective(@Param("record") ClearChannelTaskConfDO record, @Param("example") ClearChannelTaskConfDOExample example);

    int updateByExample(@Param("record") ClearChannelTaskConfDO record, @Param("example") ClearChannelTaskConfDOExample example);
}
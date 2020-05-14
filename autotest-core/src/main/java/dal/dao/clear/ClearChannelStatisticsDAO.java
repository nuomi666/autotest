package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearChannelStatisticsDO;
import dal.model.clear.ClearChannelStatisticsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearChannelStatisticsDAO extends MyMapper<ClearChannelStatisticsDO> {
    long countByExample(ClearChannelStatisticsDOExample example);

    int deleteByExample(ClearChannelStatisticsDOExample example);

    List<ClearChannelStatisticsDO> selectByExample(ClearChannelStatisticsDOExample example);

    int updateByExampleSelective(@Param("record") ClearChannelStatisticsDO record, @Param("example") ClearChannelStatisticsDOExample example);

    int updateByExample(@Param("record") ClearChannelStatisticsDO record, @Param("example") ClearChannelStatisticsDOExample example);
}
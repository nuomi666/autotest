package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearStatisticsDO;
import dal.model.clear.ClearStatisticsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearStatisticsDAO extends MyMapper<ClearStatisticsDO> {
    long countByExample(ClearStatisticsDOExample example);

    int deleteByExample(ClearStatisticsDOExample example);

    List<ClearStatisticsDO> selectByExample(ClearStatisticsDOExample example);

    int updateByExampleSelective(@Param("record") ClearStatisticsDO record, @Param("example") ClearStatisticsDOExample example);

    int updateByExample(@Param("record") ClearStatisticsDO record, @Param("example") ClearStatisticsDOExample example);
}
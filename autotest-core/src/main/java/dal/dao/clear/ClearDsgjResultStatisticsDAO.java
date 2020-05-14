package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearDsgjResultStatisticsDO;
import dal.model.clear.ClearDsgjResultStatisticsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearDsgjResultStatisticsDAO extends MyMapper<ClearDsgjResultStatisticsDO> {
    long countByExample(ClearDsgjResultStatisticsDOExample example);

    int deleteByExample(ClearDsgjResultStatisticsDOExample example);

    List<ClearDsgjResultStatisticsDO> selectByExampleWithBLOBs(ClearDsgjResultStatisticsDOExample example);

    List<ClearDsgjResultStatisticsDO> selectByExample(ClearDsgjResultStatisticsDOExample example);

    int updateByExampleSelective(@Param("record") ClearDsgjResultStatisticsDO record, @Param("example") ClearDsgjResultStatisticsDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ClearDsgjResultStatisticsDO record, @Param("example") ClearDsgjResultStatisticsDOExample example);

    int updateByExample(@Param("record") ClearDsgjResultStatisticsDO record, @Param("example") ClearDsgjResultStatisticsDOExample example);
}
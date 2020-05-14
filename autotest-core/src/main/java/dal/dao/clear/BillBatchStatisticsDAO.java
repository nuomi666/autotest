package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BillBatchStatisticsDO;
import dal.model.clear.BillBatchStatisticsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillBatchStatisticsDAO extends MyMapper<BillBatchStatisticsDO> {
    long countByExample(BillBatchStatisticsDOExample example);

    int deleteByExample(BillBatchStatisticsDOExample example);

    List<BillBatchStatisticsDO> selectByExample(BillBatchStatisticsDOExample example);

    int updateByExampleSelective(@Param("record") BillBatchStatisticsDO record, @Param("example") BillBatchStatisticsDOExample example);

    int updateByExample(@Param("record") BillBatchStatisticsDO record, @Param("example") BillBatchStatisticsDOExample example);
}
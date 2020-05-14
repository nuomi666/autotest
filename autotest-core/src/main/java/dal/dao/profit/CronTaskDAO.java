package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.CronTaskDO;
import dal.model.profit.CronTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CronTaskDAO extends MyMapper<CronTaskDO> {
    long countByExample(CronTaskDOExample example);

    int deleteByExample(CronTaskDOExample example);

    List<CronTaskDO> selectByExample(CronTaskDOExample example);

    int updateByExampleSelective(@Param("record") CronTaskDO record, @Param("example") CronTaskDOExample example);

    int updateByExample(@Param("record") CronTaskDO record, @Param("example") CronTaskDOExample example);
}
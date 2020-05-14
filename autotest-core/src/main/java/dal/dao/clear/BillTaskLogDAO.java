package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BillTaskLogDO;
import dal.model.clear.BillTaskLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillTaskLogDAO extends MyMapper<BillTaskLogDO> {
    long countByExample(BillTaskLogDOExample example);

    int deleteByExample(BillTaskLogDOExample example);

    List<BillTaskLogDO> selectByExample(BillTaskLogDOExample example);

    int updateByExampleSelective(@Param("record") BillTaskLogDO record, @Param("example") BillTaskLogDOExample example);

    int updateByExample(@Param("record") BillTaskLogDO record, @Param("example") BillTaskLogDOExample example);
}
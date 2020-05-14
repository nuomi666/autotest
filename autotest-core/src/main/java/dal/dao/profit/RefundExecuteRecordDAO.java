package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.RefundExecuteRecordDO;
import dal.model.profit.RefundExecuteRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundExecuteRecordDAO extends MyMapper<RefundExecuteRecordDO> {
    long countByExample(RefundExecuteRecordDOExample example);

    int deleteByExample(RefundExecuteRecordDOExample example);

    List<RefundExecuteRecordDO> selectByExample(RefundExecuteRecordDOExample example);

    int updateByExampleSelective(@Param("record") RefundExecuteRecordDO record, @Param("example") RefundExecuteRecordDOExample example);

    int updateByExample(@Param("record") RefundExecuteRecordDO record, @Param("example") RefundExecuteRecordDOExample example);
}
package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.ActionExecuteRecordDO;
import dal.model.profit.ActionExecuteRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActionExecuteRecordDAO extends MyMapper<ActionExecuteRecordDO> {
    long countByExample(ActionExecuteRecordDOExample example);

    int deleteByExample(ActionExecuteRecordDOExample example);

    List<ActionExecuteRecordDO> selectByExample(ActionExecuteRecordDOExample example);

    int updateByExampleSelective(@Param("record") ActionExecuteRecordDO record, @Param("example") ActionExecuteRecordDOExample example);

    int updateByExample(@Param("record") ActionExecuteRecordDO record, @Param("example") ActionExecuteRecordDOExample example);
}
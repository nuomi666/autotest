package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.TriggerEventDataDO;
import dal.model.gas_marketpc.TriggerEventDataDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TriggerEventDataDAO extends MyMapper<TriggerEventDataDO> {
    long countByExample(TriggerEventDataDOExample example);

    int deleteByExample(TriggerEventDataDOExample example);

    List<TriggerEventDataDO> selectByExample(TriggerEventDataDOExample example);

    int updateByExampleSelective(@Param("record") TriggerEventDataDO record, @Param("example") TriggerEventDataDOExample example);

    int updateByExample(@Param("record") TriggerEventDataDO record, @Param("example") TriggerEventDataDOExample example);
}
package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.TriggerEventDO;
import dal.model.gas_marketpc.TriggerEventDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TriggerEventDAO extends MyMapper<TriggerEventDO> {
    long countByExample(TriggerEventDOExample example);

    int deleteByExample(TriggerEventDOExample example);

    List<TriggerEventDO> selectByExample(TriggerEventDOExample example);

    int updateByExampleSelective(@Param("record") TriggerEventDO record, @Param("example") TriggerEventDOExample example);

    int updateByExample(@Param("record") TriggerEventDO record, @Param("example") TriggerEventDOExample example);
}
package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.TriggerConditionDO;
import dal.model.gas_marketpc.TriggerConditionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TriggerConditionDAO extends MyMapper<TriggerConditionDO> {
    long countByExample(TriggerConditionDOExample example);

    int deleteByExample(TriggerConditionDOExample example);

    List<TriggerConditionDO> selectByExample(TriggerConditionDOExample example);

    int updateByExampleSelective(@Param("record") TriggerConditionDO record, @Param("example") TriggerConditionDOExample example);

    int updateByExample(@Param("record") TriggerConditionDO record, @Param("example") TriggerConditionDOExample example);
}
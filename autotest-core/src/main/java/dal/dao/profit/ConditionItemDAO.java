package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.ConditionItemDO;
import dal.model.profit.ConditionItemDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConditionItemDAO extends MyMapper<ConditionItemDO> {
    long countByExample(ConditionItemDOExample example);

    int deleteByExample(ConditionItemDOExample example);

    List<ConditionItemDO> selectByExample(ConditionItemDOExample example);

    int updateByExampleSelective(@Param("record") ConditionItemDO record, @Param("example") ConditionItemDOExample example);

    int updateByExample(@Param("record") ConditionItemDO record, @Param("example") ConditionItemDOExample example);
}
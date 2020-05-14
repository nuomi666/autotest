package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.ActionItemDO;
import dal.model.profit.ActionItemDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActionItemDAO extends MyMapper<ActionItemDO> {
    long countByExample(ActionItemDOExample example);

    int deleteByExample(ActionItemDOExample example);

    List<ActionItemDO> selectByExampleWithBLOBs(ActionItemDOExample example);

    List<ActionItemDO> selectByExample(ActionItemDOExample example);

    int updateByExampleSelective(@Param("record") ActionItemDO record, @Param("example") ActionItemDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ActionItemDO record, @Param("example") ActionItemDOExample example);

    int updateByExample(@Param("record") ActionItemDO record, @Param("example") ActionItemDOExample example);
}
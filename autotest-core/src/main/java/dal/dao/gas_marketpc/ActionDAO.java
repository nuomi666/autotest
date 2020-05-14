package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.ActionDO;
import dal.model.gas_marketpc.ActionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActionDAO extends MyMapper<ActionDO> {
    long countByExample(ActionDOExample example);

    int deleteByExample(ActionDOExample example);

    List<ActionDO> selectByExample(ActionDOExample example);

    int updateByExampleSelective(@Param("record") ActionDO record, @Param("example") ActionDOExample example);

    int updateByExample(@Param("record") ActionDO record, @Param("example") ActionDOExample example);
}
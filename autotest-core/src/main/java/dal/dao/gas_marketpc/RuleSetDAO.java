package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.RuleSetDO;
import dal.model.gas_marketpc.RuleSetDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RuleSetDAO extends MyMapper<RuleSetDO> {
    long countByExample(RuleSetDOExample example);

    int deleteByExample(RuleSetDOExample example);

    List<RuleSetDO> selectByExample(RuleSetDOExample example);

    int updateByExampleSelective(@Param("record") RuleSetDO record, @Param("example") RuleSetDOExample example);

    int updateByExample(@Param("record") RuleSetDO record, @Param("example") RuleSetDOExample example);
}
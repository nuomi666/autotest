package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.SettlementTaskLogDO;
import dal.model.clear.SettlementTaskLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlementTaskLogDAO extends MyMapper<SettlementTaskLogDO> {
    long countByExample(SettlementTaskLogDOExample example);

    int deleteByExample(SettlementTaskLogDOExample example);

    List<SettlementTaskLogDO> selectByExample(SettlementTaskLogDOExample example);

    int updateByExampleSelective(@Param("record") SettlementTaskLogDO record, @Param("example") SettlementTaskLogDOExample example);

    int updateByExample(@Param("record") SettlementTaskLogDO record, @Param("example") SettlementTaskLogDOExample example);
}
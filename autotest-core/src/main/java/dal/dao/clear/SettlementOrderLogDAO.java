package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.SettlementOrderLogDO;
import dal.model.clear.SettlementOrderLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlementOrderLogDAO extends MyMapper<SettlementOrderLogDO> {
    long countByExample(SettlementOrderLogDOExample example);

    int deleteByExample(SettlementOrderLogDOExample example);

    List<SettlementOrderLogDO> selectByExample(SettlementOrderLogDOExample example);

    int updateByExampleSelective(@Param("record") SettlementOrderLogDO record, @Param("example") SettlementOrderLogDOExample example);

    int updateByExample(@Param("record") SettlementOrderLogDO record, @Param("example") SettlementOrderLogDOExample example);
}
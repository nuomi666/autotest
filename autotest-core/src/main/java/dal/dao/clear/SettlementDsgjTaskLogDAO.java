package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.SettlementDsgjTaskLogDO;
import dal.model.clear.SettlementDsgjTaskLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlementDsgjTaskLogDAO extends MyMapper<SettlementDsgjTaskLogDO> {
    long countByExample(SettlementDsgjTaskLogDOExample example);

    int deleteByExample(SettlementDsgjTaskLogDOExample example);

    List<SettlementDsgjTaskLogDO> selectByExample(SettlementDsgjTaskLogDOExample example);

    int updateByExampleSelective(@Param("record") SettlementDsgjTaskLogDO record, @Param("example") SettlementDsgjTaskLogDOExample example);

    int updateByExample(@Param("record") SettlementDsgjTaskLogDO record, @Param("example") SettlementDsgjTaskLogDOExample example);
}
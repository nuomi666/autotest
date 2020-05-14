package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.SettlementTaskConfDO;
import dal.model.clear.SettlementTaskConfDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlementTaskConfDAO extends MyMapper<SettlementTaskConfDO> {
    long countByExample(SettlementTaskConfDOExample example);

    int deleteByExample(SettlementTaskConfDOExample example);

    List<SettlementTaskConfDO> selectByExample(SettlementTaskConfDOExample example);

    int updateByExampleSelective(@Param("record") SettlementTaskConfDO record, @Param("example") SettlementTaskConfDOExample example);

    int updateByExample(@Param("record") SettlementTaskConfDO record, @Param("example") SettlementTaskConfDOExample example);
}
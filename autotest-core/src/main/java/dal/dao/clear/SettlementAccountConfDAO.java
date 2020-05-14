package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.SettlementAccountConfDO;
import dal.model.clear.SettlementAccountConfDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlementAccountConfDAO extends MyMapper<SettlementAccountConfDO> {
    long countByExample(SettlementAccountConfDOExample example);

    int deleteByExample(SettlementAccountConfDOExample example);

    List<SettlementAccountConfDO> selectByExample(SettlementAccountConfDOExample example);

    int updateByExampleSelective(@Param("record") SettlementAccountConfDO record, @Param("example") SettlementAccountConfDOExample example);

    int updateByExample(@Param("record") SettlementAccountConfDO record, @Param("example") SettlementAccountConfDOExample example);
}
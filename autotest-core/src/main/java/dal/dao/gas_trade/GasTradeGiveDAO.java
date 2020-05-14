package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeGiveDO;
import dal.model.gas_trade.GasTradeGiveDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeGiveDAO extends MyMapper<GasTradeGiveDO> {
    long countByExample(GasTradeGiveDOExample example);

    int deleteByExample(GasTradeGiveDOExample example);

    List<GasTradeGiveDO> selectByExample(GasTradeGiveDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeGiveDO record, @Param("example") GasTradeGiveDOExample example);

    int updateByExample(@Param("record") GasTradeGiveDO record, @Param("example") GasTradeGiveDOExample example);
}
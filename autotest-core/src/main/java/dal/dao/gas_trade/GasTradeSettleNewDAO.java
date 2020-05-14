package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeSettleNewDO;
import dal.model.gas_trade.GasTradeSettleNewDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeSettleNewDAO extends MyMapper<GasTradeSettleNewDO> {
    long countByExample(GasTradeSettleNewDOExample example);

    int deleteByExample(GasTradeSettleNewDOExample example);

    List<GasTradeSettleNewDO> selectByExample(GasTradeSettleNewDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeSettleNewDO record, @Param("example") GasTradeSettleNewDOExample example);

    int updateByExample(@Param("record") GasTradeSettleNewDO record, @Param("example") GasTradeSettleNewDOExample example);
}
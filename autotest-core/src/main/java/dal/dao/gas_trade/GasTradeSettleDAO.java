package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeSettleDO;
import dal.model.gas_trade.GasTradeSettleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeSettleDAO extends MyMapper<GasTradeSettleDO> {
    long countByExample(GasTradeSettleDOExample example);

    int deleteByExample(GasTradeSettleDOExample example);

    List<GasTradeSettleDO> selectByExample(GasTradeSettleDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeSettleDO record, @Param("example") GasTradeSettleDOExample example);

    int updateByExample(@Param("record") GasTradeSettleDO record, @Param("example") GasTradeSettleDOExample example);
}
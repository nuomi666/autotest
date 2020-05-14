package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeDepositDO;
import dal.model.gas_trade.GasTradeDepositDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeDepositDAO extends MyMapper<GasTradeDepositDO> {
    long countByExample(GasTradeDepositDOExample example);

    int deleteByExample(GasTradeDepositDOExample example);

    List<GasTradeDepositDO> selectByExample(GasTradeDepositDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeDepositDO record, @Param("example") GasTradeDepositDOExample example);

    int updateByExample(@Param("record") GasTradeDepositDO record, @Param("example") GasTradeDepositDOExample example);
}
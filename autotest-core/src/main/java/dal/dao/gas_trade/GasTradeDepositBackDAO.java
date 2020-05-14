package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeDepositBackDO;
import dal.model.gas_trade.GasTradeDepositBackDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeDepositBackDAO extends MyMapper<GasTradeDepositBackDO> {
    long countByExample(GasTradeDepositBackDOExample example);

    int deleteByExample(GasTradeDepositBackDOExample example);

    List<GasTradeDepositBackDO> selectByExample(GasTradeDepositBackDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeDepositBackDO record, @Param("example") GasTradeDepositBackDOExample example);

    int updateByExample(@Param("record") GasTradeDepositBackDO record, @Param("example") GasTradeDepositBackDOExample example);
}
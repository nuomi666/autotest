package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradePaymentDO;
import dal.model.gas_trade.GasTradePaymentDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradePaymentDAO extends MyMapper<GasTradePaymentDO> {
    long countByExample(GasTradePaymentDOExample example);

    int deleteByExample(GasTradePaymentDOExample example);

    List<GasTradePaymentDO> selectByExample(GasTradePaymentDOExample example);

    int updateByExampleSelective(@Param("record") GasTradePaymentDO record, @Param("example") GasTradePaymentDOExample example);

    int updateByExample(@Param("record") GasTradePaymentDO record, @Param("example") GasTradePaymentDOExample example);
}
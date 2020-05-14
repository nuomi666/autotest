package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeRefundDO;
import dal.model.gas_trade.GasTradeRefundDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeRefundDAO extends MyMapper<GasTradeRefundDO> {
    long countByExample(GasTradeRefundDOExample example);

    int deleteByExample(GasTradeRefundDOExample example);

    List<GasTradeRefundDO> selectByExample(GasTradeRefundDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeRefundDO record, @Param("example") GasTradeRefundDOExample example);

    int updateByExample(@Param("record") GasTradeRefundDO record, @Param("example") GasTradeRefundDOExample example);
}
package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeOilDO;
import dal.model.gas_trade.GasTradeOilDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeOilDAO extends MyMapper<GasTradeOilDO> {
    long countByExample(GasTradeOilDOExample example);

    int deleteByExample(GasTradeOilDOExample example);

    List<GasTradeOilDO> selectByExample(GasTradeOilDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeOilDO record, @Param("example") GasTradeOilDOExample example);

    int updateByExample(@Param("record") GasTradeOilDO record, @Param("example") GasTradeOilDOExample example);
}
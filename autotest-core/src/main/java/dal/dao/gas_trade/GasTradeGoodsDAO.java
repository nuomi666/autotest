package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeGoodsDO;
import dal.model.gas_trade.GasTradeGoodsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeGoodsDAO extends MyMapper<GasTradeGoodsDO> {
    long countByExample(GasTradeGoodsDOExample example);

    int deleteByExample(GasTradeGoodsDOExample example);

    List<GasTradeGoodsDO> selectByExample(GasTradeGoodsDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeGoodsDO record, @Param("example") GasTradeGoodsDOExample example);

    int updateByExample(@Param("record") GasTradeGoodsDO record, @Param("example") GasTradeGoodsDOExample example);
}
package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradePointsRedeemDO;
import dal.model.gas_trade.GasTradePointsRedeemDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradePointsRedeemDAO extends MyMapper<GasTradePointsRedeemDO> {
    long countByExample(GasTradePointsRedeemDOExample example);

    int deleteByExample(GasTradePointsRedeemDOExample example);

    List<GasTradePointsRedeemDO> selectByExample(GasTradePointsRedeemDOExample example);

    int updateByExampleSelective(@Param("record") GasTradePointsRedeemDO record, @Param("example") GasTradePointsRedeemDOExample example);

    int updateByExample(@Param("record") GasTradePointsRedeemDO record, @Param("example") GasTradePointsRedeemDOExample example);
}
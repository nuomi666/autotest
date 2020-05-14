package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeReviseDO;
import dal.model.gas_trade.GasTradeReviseDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeReviseDAO extends MyMapper<GasTradeReviseDO> {
    long countByExample(GasTradeReviseDOExample example);

    int deleteByExample(GasTradeReviseDOExample example);

    List<GasTradeReviseDO> selectByExample(GasTradeReviseDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeReviseDO record, @Param("example") GasTradeReviseDOExample example);

    int updateByExample(@Param("record") GasTradeReviseDO record, @Param("example") GasTradeReviseDOExample example);
}
package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeNotifyTaskWashDO;
import dal.model.gas_trade.GasTradeNotifyTaskWashDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeNotifyTaskWashDAO extends MyMapper<GasTradeNotifyTaskWashDO> {
    long countByExample(GasTradeNotifyTaskWashDOExample example);

    int deleteByExample(GasTradeNotifyTaskWashDOExample example);

    List<GasTradeNotifyTaskWashDO> selectByExample(GasTradeNotifyTaskWashDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeNotifyTaskWashDO record, @Param("example") GasTradeNotifyTaskWashDOExample example);

    int updateByExample(@Param("record") GasTradeNotifyTaskWashDO record, @Param("example") GasTradeNotifyTaskWashDOExample example);
}
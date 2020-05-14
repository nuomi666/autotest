package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeNotifyTaskDO;
import dal.model.gas_trade.GasTradeNotifyTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeNotifyTaskDAO extends MyMapper<GasTradeNotifyTaskDO> {
    long countByExample(GasTradeNotifyTaskDOExample example);

    int deleteByExample(GasTradeNotifyTaskDOExample example);

    List<GasTradeNotifyTaskDO> selectByExample(GasTradeNotifyTaskDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeNotifyTaskDO record, @Param("example") GasTradeNotifyTaskDOExample example);

    int updateByExample(@Param("record") GasTradeNotifyTaskDO record, @Param("example") GasTradeNotifyTaskDOExample example);
}
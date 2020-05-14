package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.GasTradeReviseRefundDO;
import dal.model.gas_trade.GasTradeReviseRefundDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeReviseRefundDAO extends MyMapper<GasTradeReviseRefundDO> {
    long countByExample(GasTradeReviseRefundDOExample example);

    int deleteByExample(GasTradeReviseRefundDOExample example);

    List<GasTradeReviseRefundDO> selectByExample(GasTradeReviseRefundDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeReviseRefundDO record, @Param("example") GasTradeReviseRefundDOExample example);

    int updateByExample(@Param("record") GasTradeReviseRefundDO record, @Param("example") GasTradeReviseRefundDOExample example);
}
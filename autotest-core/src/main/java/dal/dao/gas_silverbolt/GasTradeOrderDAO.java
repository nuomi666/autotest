package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasTradeOrderDO;
import dal.model.gas_silverbolt.GasTradeOrderDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeOrderDAO extends MyMapper<GasTradeOrderDO> {
    long countByExample(GasTradeOrderDOExample example);

    int deleteByExample(GasTradeOrderDOExample example);

    List<GasTradeOrderDO> selectByExample(GasTradeOrderDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeOrderDO record, @Param("example") GasTradeOrderDOExample example);

    int updateByExample(@Param("record") GasTradeOrderDO record, @Param("example") GasTradeOrderDOExample example);
}
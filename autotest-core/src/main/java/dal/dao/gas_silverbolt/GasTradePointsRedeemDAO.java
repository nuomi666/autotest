package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasTradePointsRedeemDO;
import dal.model.gas_silverbolt.GasTradePointsRedeemDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradePointsRedeemDAO extends MyMapper<GasTradePointsRedeemDO> {
    long countByExample(GasTradePointsRedeemDOExample example);

    int deleteByExample(GasTradePointsRedeemDOExample example);

    List<GasTradePointsRedeemDO> selectByExample(GasTradePointsRedeemDOExample example);

    int updateByExampleSelective(@Param("record") GasTradePointsRedeemDO record, @Param("example") GasTradePointsRedeemDOExample example);

    int updateByExample(@Param("record") GasTradePointsRedeemDO record, @Param("example") GasTradePointsRedeemDOExample example);
}
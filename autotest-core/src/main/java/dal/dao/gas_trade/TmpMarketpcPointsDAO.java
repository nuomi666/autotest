package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.TmpMarketpcPointsDO;
import dal.model.gas_trade.TmpMarketpcPointsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpMarketpcPointsDAO extends MyMapper<TmpMarketpcPointsDO> {
    long countByExample(TmpMarketpcPointsDOExample example);

    int deleteByExample(TmpMarketpcPointsDOExample example);

    List<TmpMarketpcPointsDO> selectByExample(TmpMarketpcPointsDOExample example);

    int updateByExampleSelective(@Param("record") TmpMarketpcPointsDO record, @Param("example") TmpMarketpcPointsDOExample example);

    int updateByExample(@Param("record") TmpMarketpcPointsDO record, @Param("example") TmpMarketpcPointsDOExample example);
}
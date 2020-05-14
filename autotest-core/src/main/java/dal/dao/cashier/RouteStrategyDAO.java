package dal.dao.cashier;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.cashier.RouteStrategyDO;
import dal.model.cashier.RouteStrategyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RouteStrategyDAO extends MyMapper<RouteStrategyDO> {
    long countByExample(RouteStrategyDOExample example);

    int deleteByExample(RouteStrategyDOExample example);

    List<RouteStrategyDO> selectByExample(RouteStrategyDOExample example);

    int updateByExampleSelective(@Param("record") RouteStrategyDO record, @Param("example") RouteStrategyDOExample example);

    int updateByExample(@Param("record") RouteStrategyDO record, @Param("example") RouteStrategyDOExample example);
}
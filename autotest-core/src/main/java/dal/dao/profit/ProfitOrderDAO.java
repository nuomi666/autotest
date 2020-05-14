package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.ProfitOrderDO;
import dal.model.profit.ProfitOrderDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfitOrderDAO extends MyMapper<ProfitOrderDO> {
    long countByExample(ProfitOrderDOExample example);

    int deleteByExample(ProfitOrderDOExample example);

    List<ProfitOrderDO> selectByExample(ProfitOrderDOExample example);

    int updateByExampleSelective(@Param("record") ProfitOrderDO record, @Param("example") ProfitOrderDOExample example);

    int updateByExample(@Param("record") ProfitOrderDO record, @Param("example") ProfitOrderDOExample example);
}
package dal.dao.profit;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.profit.ProfitRefundDO;
import dal.model.profit.ProfitRefundDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfitRefundDAO extends MyMapper<ProfitRefundDO> {
    long countByExample(ProfitRefundDOExample example);

    int deleteByExample(ProfitRefundDOExample example);

    List<ProfitRefundDO> selectByExample(ProfitRefundDOExample example);

    int updateByExampleSelective(@Param("record") ProfitRefundDO record, @Param("example") ProfitRefundDOExample example);

    int updateByExample(@Param("record") ProfitRefundDO record, @Param("example") ProfitRefundDOExample example);
}
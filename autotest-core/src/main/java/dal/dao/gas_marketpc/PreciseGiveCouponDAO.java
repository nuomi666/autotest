package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.PreciseGiveCouponDO;
import dal.model.gas_marketpc.PreciseGiveCouponDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PreciseGiveCouponDAO extends MyMapper<PreciseGiveCouponDO> {
    long countByExample(PreciseGiveCouponDOExample example);

    int deleteByExample(PreciseGiveCouponDOExample example);

    List<PreciseGiveCouponDO> selectByExample(PreciseGiveCouponDOExample example);

    int updateByExampleSelective(@Param("record") PreciseGiveCouponDO record, @Param("example") PreciseGiveCouponDOExample example);

    int updateByExample(@Param("record") PreciseGiveCouponDO record, @Param("example") PreciseGiveCouponDOExample example);
}
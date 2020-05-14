package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.CouponDO;
import dal.model.gas_marketpc.CouponDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponDAO extends MyMapper<CouponDO> {
    long countByExample(CouponDOExample example);

    int deleteByExample(CouponDOExample example);

    List<CouponDO> selectByExample(CouponDOExample example);

    int updateByExampleSelective(@Param("record") CouponDO record, @Param("example") CouponDOExample example);

    int updateByExample(@Param("record") CouponDO record, @Param("example") CouponDOExample example);
}
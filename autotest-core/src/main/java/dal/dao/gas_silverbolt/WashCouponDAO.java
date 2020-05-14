package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.WashCouponDO;
import dal.model.gas_silverbolt.WashCouponDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WashCouponDAO extends MyMapper<WashCouponDO> {
    long countByExample(WashCouponDOExample example);

    int deleteByExample(WashCouponDOExample example);

    List<WashCouponDO> selectByExample(WashCouponDOExample example);

    int updateByExampleSelective(@Param("record") WashCouponDO record, @Param("example") WashCouponDOExample example);

    int updateByExample(@Param("record") WashCouponDO record, @Param("example") WashCouponDOExample example);
}
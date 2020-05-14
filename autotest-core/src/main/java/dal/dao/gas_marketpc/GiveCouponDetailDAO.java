package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.GiveCouponDetailDO;
import dal.model.gas_marketpc.GiveCouponDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiveCouponDetailDAO extends MyMapper<GiveCouponDetailDO> {
    long countByExample(GiveCouponDetailDOExample example);

    int deleteByExample(GiveCouponDetailDOExample example);

    List<GiveCouponDetailDO> selectByExample(GiveCouponDetailDOExample example);

    int updateByExampleSelective(@Param("record") GiveCouponDetailDO record, @Param("example") GiveCouponDetailDOExample example);

    int updateByExample(@Param("record") GiveCouponDetailDO record, @Param("example") GiveCouponDetailDOExample example);
}
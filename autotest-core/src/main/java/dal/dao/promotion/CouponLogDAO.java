package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.CouponLogDO;
import dal.model.promotion.CouponLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponLogDAO extends MyMapper<CouponLogDO> {
    long countByExample(CouponLogDOExample example);

    int deleteByExample(CouponLogDOExample example);

    List<CouponLogDO> selectByExample(CouponLogDOExample example);

    int updateByExampleSelective(@Param("record") CouponLogDO record, @Param("example") CouponLogDOExample example);

    int updateByExample(@Param("record") CouponLogDO record, @Param("example") CouponLogDOExample example);
}
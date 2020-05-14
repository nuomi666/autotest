package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.CouponDO;
import dal.model.promotion.CouponDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponDAO extends MyMapper<CouponDO> {
    long countByExample(CouponDOExample example);

    int deleteByExample(CouponDOExample example);

    List<CouponDO> selectByExample(CouponDOExample example);

    int updateByExampleSelective(@Param("record") CouponDO record, @Param("example") CouponDOExample example);

    int updateByExample(@Param("record") CouponDO record, @Param("example") CouponDOExample example);
}
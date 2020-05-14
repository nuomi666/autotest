package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.CouponCopyDO;
import dal.model.promotion.CouponCopyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponCopyDAO extends MyMapper<CouponCopyDO> {
    long countByExample(CouponCopyDOExample example);

    int deleteByExample(CouponCopyDOExample example);

    List<CouponCopyDO> selectByExample(CouponCopyDOExample example);

    int updateByExampleSelective(@Param("record") CouponCopyDO record, @Param("example") CouponCopyDOExample example);

    int updateByExample(@Param("record") CouponCopyDO record, @Param("example") CouponCopyDOExample example);
}
package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.CouponTransferLogDO;
import dal.model.promotion.CouponTransferLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponTransferLogDAO extends MyMapper<CouponTransferLogDO> {
    long countByExample(CouponTransferLogDOExample example);

    int deleteByExample(CouponTransferLogDOExample example);

    List<CouponTransferLogDO> selectByExample(CouponTransferLogDOExample example);

    int updateByExampleSelective(@Param("record") CouponTransferLogDO record, @Param("example") CouponTransferLogDOExample example);

    int updateByExample(@Param("record") CouponTransferLogDO record, @Param("example") CouponTransferLogDOExample example);
}
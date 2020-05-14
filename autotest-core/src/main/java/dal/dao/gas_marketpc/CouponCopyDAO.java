package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.CouponCopyDO;
import dal.model.gas_marketpc.CouponCopyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponCopyDAO extends MyMapper<CouponCopyDO> {
    long countByExample(CouponCopyDOExample example);

    int deleteByExample(CouponCopyDOExample example);

    List<CouponCopyDO> selectByExample(CouponCopyDOExample example);

    int updateByExampleSelective(@Param("record") CouponCopyDO record, @Param("example") CouponCopyDOExample example);

    int updateByExample(@Param("record") CouponCopyDO record, @Param("example") CouponCopyDOExample example);
}
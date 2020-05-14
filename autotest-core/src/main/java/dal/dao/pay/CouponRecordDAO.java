package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.CouponRecordDO;
import dal.model.pay.CouponRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponRecordDAO extends MyMapper<CouponRecordDO> {
    long countByExample(CouponRecordDOExample example);

    int deleteByExample(CouponRecordDOExample example);

    List<CouponRecordDO> selectByExample(CouponRecordDOExample example);

    int updateByExampleSelective(@Param("record") CouponRecordDO record, @Param("example") CouponRecordDOExample example);

    int updateByExample(@Param("record") CouponRecordDO record, @Param("example") CouponRecordDOExample example);
}
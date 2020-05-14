package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.CouponDefinitionCopyDO;
import dal.model.promotion.CouponDefinitionCopyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponDefinitionCopyDAO extends MyMapper<CouponDefinitionCopyDO> {
    long countByExample(CouponDefinitionCopyDOExample example);

    int deleteByExample(CouponDefinitionCopyDOExample example);

    List<CouponDefinitionCopyDO> selectByExample(CouponDefinitionCopyDOExample example);

    int updateByExampleSelective(@Param("record") CouponDefinitionCopyDO record, @Param("example") CouponDefinitionCopyDOExample example);

    int updateByExample(@Param("record") CouponDefinitionCopyDO record, @Param("example") CouponDefinitionCopyDOExample example);
}
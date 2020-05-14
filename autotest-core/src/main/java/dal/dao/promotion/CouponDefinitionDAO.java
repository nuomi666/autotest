package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.CouponDefinitionDO;
import dal.model.promotion.CouponDefinitionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponDefinitionDAO extends MyMapper<CouponDefinitionDO> {
    long countByExample(CouponDefinitionDOExample example);

    int deleteByExample(CouponDefinitionDOExample example);

    List<CouponDefinitionDO> selectByExample(CouponDefinitionDOExample example);

    int updateByExampleSelective(@Param("record") CouponDefinitionDO record, @Param("example") CouponDefinitionDOExample example);

    int updateByExample(@Param("record") CouponDefinitionDO record, @Param("example") CouponDefinitionDOExample example);
}
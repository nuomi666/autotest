package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.CouponDefinitionViewDO;
import dal.model.promotion.CouponDefinitionViewDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponDefinitionViewDAO extends MyMapper<CouponDefinitionViewDO> {
    long countByExample(CouponDefinitionViewDOExample example);

    int deleteByExample(CouponDefinitionViewDOExample example);

    List<CouponDefinitionViewDO> selectByExample(CouponDefinitionViewDOExample example);

    int updateByExampleSelective(@Param("record") CouponDefinitionViewDO record, @Param("example") CouponDefinitionViewDOExample example);

    int updateByExample(@Param("record") CouponDefinitionViewDO record, @Param("example") CouponDefinitionViewDOExample example);
}
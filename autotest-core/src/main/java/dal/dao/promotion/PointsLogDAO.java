package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.PointsLogDO;
import dal.model.promotion.PointsLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PointsLogDAO extends MyMapper<PointsLogDO> {
    long countByExample(PointsLogDOExample example);

    int deleteByExample(PointsLogDOExample example);

    List<PointsLogDO> selectByExample(PointsLogDOExample example);

    int updateByExampleSelective(@Param("record") PointsLogDO record, @Param("example") PointsLogDOExample example);

    int updateByExample(@Param("record") PointsLogDO record, @Param("example") PointsLogDOExample example);
}
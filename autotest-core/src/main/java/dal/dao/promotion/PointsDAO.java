package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.PointsDO;
import dal.model.promotion.PointsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PointsDAO extends MyMapper<PointsDO> {
    long countByExample(PointsDOExample example);

    int deleteByExample(PointsDOExample example);

    List<PointsDO> selectByExample(PointsDOExample example);

    int updateByExampleSelective(@Param("record") PointsDO record, @Param("example") PointsDOExample example);

    int updateByExample(@Param("record") PointsDO record, @Param("example") PointsDOExample example);
}
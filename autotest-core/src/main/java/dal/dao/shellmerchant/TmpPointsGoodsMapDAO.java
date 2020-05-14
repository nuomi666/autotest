package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.TmpPointsGoodsMapDO;
import dal.model.shellmerchant.TmpPointsGoodsMapDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpPointsGoodsMapDAO extends MyMapper<TmpPointsGoodsMapDO> {
    long countByExample(TmpPointsGoodsMapDOExample example);

    int deleteByExample(TmpPointsGoodsMapDOExample example);

    List<TmpPointsGoodsMapDO> selectByExample(TmpPointsGoodsMapDOExample example);

    int updateByExampleSelective(@Param("record") TmpPointsGoodsMapDO record, @Param("example") TmpPointsGoodsMapDOExample example);

    int updateByExample(@Param("record") TmpPointsGoodsMapDO record, @Param("example") TmpPointsGoodsMapDOExample example);
}
package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.TmpPointsGoodsMapDO;
import dal.model.gas_merchant.TmpPointsGoodsMapDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpPointsGoodsMapDAO extends MyMapper<TmpPointsGoodsMapDO> {
    long countByExample(TmpPointsGoodsMapDOExample example);

    int deleteByExample(TmpPointsGoodsMapDOExample example);

    List<TmpPointsGoodsMapDO> selectByExample(TmpPointsGoodsMapDOExample example);

    int updateByExampleSelective(@Param("record") TmpPointsGoodsMapDO record, @Param("example") TmpPointsGoodsMapDOExample example);

    int updateByExample(@Param("record") TmpPointsGoodsMapDO record, @Param("example") TmpPointsGoodsMapDOExample example);
}
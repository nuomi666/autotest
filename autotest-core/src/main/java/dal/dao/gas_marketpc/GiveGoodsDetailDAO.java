package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.GiveGoodsDetailDO;
import dal.model.gas_marketpc.GiveGoodsDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiveGoodsDetailDAO extends MyMapper<GiveGoodsDetailDO> {
    long countByExample(GiveGoodsDetailDOExample example);

    int deleteByExample(GiveGoodsDetailDOExample example);

    List<GiveGoodsDetailDO> selectByExample(GiveGoodsDetailDOExample example);

    int updateByExampleSelective(@Param("record") GiveGoodsDetailDO record, @Param("example") GiveGoodsDetailDOExample example);

    int updateByExample(@Param("record") GiveGoodsDetailDO record, @Param("example") GiveGoodsDetailDOExample example);
}
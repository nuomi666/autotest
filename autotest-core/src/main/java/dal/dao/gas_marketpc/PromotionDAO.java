package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.PromotionDO;
import dal.model.gas_marketpc.PromotionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionDAO extends MyMapper<PromotionDO> {
    long countByExample(PromotionDOExample example);

    int deleteByExample(PromotionDOExample example);

    List<PromotionDO> selectByExample(PromotionDOExample example);

    int updateByExampleSelective(@Param("record") PromotionDO record, @Param("example") PromotionDOExample example);

    int updateByExample(@Param("record") PromotionDO record, @Param("example") PromotionDOExample example);
}
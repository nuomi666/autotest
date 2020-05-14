package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMerchantGoodsPricePlanDO;
import dal.model.shellmerchant.GasMerchantGoodsPricePlanDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantGoodsPricePlanDAO extends MyMapper<GasMerchantGoodsPricePlanDO> {
    long countByExample(GasMerchantGoodsPricePlanDOExample example);

    int deleteByExample(GasMerchantGoodsPricePlanDOExample example);

    List<GasMerchantGoodsPricePlanDO> selectByExampleWithBLOBs(GasMerchantGoodsPricePlanDOExample example);

    List<GasMerchantGoodsPricePlanDO> selectByExample(GasMerchantGoodsPricePlanDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantGoodsPricePlanDO record, @Param("example") GasMerchantGoodsPricePlanDOExample example);

    int updateByExampleWithBLOBs(@Param("record") GasMerchantGoodsPricePlanDO record, @Param("example") GasMerchantGoodsPricePlanDOExample example);

    int updateByExample(@Param("record") GasMerchantGoodsPricePlanDO record, @Param("example") GasMerchantGoodsPricePlanDOExample example);
}
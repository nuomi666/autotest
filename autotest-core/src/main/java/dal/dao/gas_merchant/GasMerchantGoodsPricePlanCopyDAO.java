package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantGoodsPricePlanCopyDO;
import dal.model.gas_merchant.GasMerchantGoodsPricePlanCopyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantGoodsPricePlanCopyDAO extends MyMapper<GasMerchantGoodsPricePlanCopyDO> {
    long countByExample(GasMerchantGoodsPricePlanCopyDOExample example);

    int deleteByExample(GasMerchantGoodsPricePlanCopyDOExample example);

    List<GasMerchantGoodsPricePlanCopyDO> selectByExampleWithBLOBs(GasMerchantGoodsPricePlanCopyDOExample example);

    List<GasMerchantGoodsPricePlanCopyDO> selectByExample(GasMerchantGoodsPricePlanCopyDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantGoodsPricePlanCopyDO record, @Param("example") GasMerchantGoodsPricePlanCopyDOExample example);

    int updateByExampleWithBLOBs(@Param("record") GasMerchantGoodsPricePlanCopyDO record, @Param("example") GasMerchantGoodsPricePlanCopyDOExample example);

    int updateByExample(@Param("record") GasMerchantGoodsPricePlanCopyDO record, @Param("example") GasMerchantGoodsPricePlanCopyDOExample example);
}
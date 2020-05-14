package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantPaywayDO;
import dal.model.gas_merchant.GasMerchantPaywayDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantPaywayDAO extends MyMapper<GasMerchantPaywayDO> {
    long countByExample(GasMerchantPaywayDOExample example);

    int deleteByExample(GasMerchantPaywayDOExample example);

    List<GasMerchantPaywayDO> selectByExampleWithBLOBs(GasMerchantPaywayDOExample example);

    List<GasMerchantPaywayDO> selectByExample(GasMerchantPaywayDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantPaywayDO record, @Param("example") GasMerchantPaywayDOExample example);

    int updateByExampleWithBLOBs(@Param("record") GasMerchantPaywayDO record, @Param("example") GasMerchantPaywayDOExample example);

    int updateByExample(@Param("record") GasMerchantPaywayDO record, @Param("example") GasMerchantPaywayDOExample example);
}
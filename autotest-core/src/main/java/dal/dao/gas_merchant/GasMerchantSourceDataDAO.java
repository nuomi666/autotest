package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantSourceDataDO;
import dal.model.gas_merchant.GasMerchantSourceDataDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantSourceDataDAO extends MyMapper<GasMerchantSourceDataDO> {
    long countByExample(GasMerchantSourceDataDOExample example);

    int deleteByExample(GasMerchantSourceDataDOExample example);

    List<GasMerchantSourceDataDO> selectByExampleWithBLOBs(GasMerchantSourceDataDOExample example);

    List<GasMerchantSourceDataDO> selectByExample(GasMerchantSourceDataDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantSourceDataDO record, @Param("example") GasMerchantSourceDataDOExample example);

    int updateByExampleWithBLOBs(@Param("record") GasMerchantSourceDataDO record, @Param("example") GasMerchantSourceDataDOExample example);

    int updateByExample(@Param("record") GasMerchantSourceDataDO record, @Param("example") GasMerchantSourceDataDOExample example);
}
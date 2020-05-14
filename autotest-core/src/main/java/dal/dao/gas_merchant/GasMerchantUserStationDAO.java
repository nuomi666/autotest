package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantUserStationDO;
import dal.model.gas_merchant.GasMerchantUserStationDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantUserStationDAO extends MyMapper<GasMerchantUserStationDO> {
    long countByExample(GasMerchantUserStationDOExample example);

    int deleteByExample(GasMerchantUserStationDOExample example);

    List<GasMerchantUserStationDO> selectByExample(GasMerchantUserStationDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantUserStationDO record, @Param("example") GasMerchantUserStationDOExample example);

    int updateByExample(@Param("record") GasMerchantUserStationDO record, @Param("example") GasMerchantUserStationDOExample example);
}
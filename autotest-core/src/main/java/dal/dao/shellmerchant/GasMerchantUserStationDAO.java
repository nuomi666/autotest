package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMerchantUserStationDO;
import dal.model.shellmerchant.GasMerchantUserStationDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantUserStationDAO extends MyMapper<GasMerchantUserStationDO> {
    long countByExample(GasMerchantUserStationDOExample example);

    int deleteByExample(GasMerchantUserStationDOExample example);

    List<GasMerchantUserStationDO> selectByExample(GasMerchantUserStationDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantUserStationDO record, @Param("example") GasMerchantUserStationDOExample example);

    int updateByExample(@Param("record") GasMerchantUserStationDO record, @Param("example") GasMerchantUserStationDOExample example);
}
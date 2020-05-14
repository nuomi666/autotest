package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasMerchantStationDO;
import dal.model.gas_silverbolt.GasMerchantStationDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantStationDAO extends MyMapper<GasMerchantStationDO> {
    long countByExample(GasMerchantStationDOExample example);

    int deleteByExample(GasMerchantStationDOExample example);

    List<GasMerchantStationDO> selectByExample(GasMerchantStationDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantStationDO record, @Param("example") GasMerchantStationDOExample example);

    int updateByExample(@Param("record") GasMerchantStationDO record, @Param("example") GasMerchantStationDOExample example);
}
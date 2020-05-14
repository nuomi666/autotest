package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasMerchantPayWayDO;
import dal.model.gas_silverbolt.GasMerchantPayWayDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantPayWayDAO extends MyMapper<GasMerchantPayWayDO> {
    long countByExample(GasMerchantPayWayDOExample example);

    int deleteByExample(GasMerchantPayWayDOExample example);

    List<GasMerchantPayWayDO> selectByExample(GasMerchantPayWayDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantPayWayDO record, @Param("example") GasMerchantPayWayDOExample example);

    int updateByExample(@Param("record") GasMerchantPayWayDO record, @Param("example") GasMerchantPayWayDOExample example);
}
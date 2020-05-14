package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantDeviceFunctionBkDO;
import dal.model.gas_merchant.GasMerchantDeviceFunctionBkDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantDeviceFunctionBkDAO extends MyMapper<GasMerchantDeviceFunctionBkDO> {
    long countByExample(GasMerchantDeviceFunctionBkDOExample example);

    int deleteByExample(GasMerchantDeviceFunctionBkDOExample example);

    List<GasMerchantDeviceFunctionBkDO> selectByExample(GasMerchantDeviceFunctionBkDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantDeviceFunctionBkDO record, @Param("example") GasMerchantDeviceFunctionBkDOExample example);

    int updateByExample(@Param("record") GasMerchantDeviceFunctionBkDO record, @Param("example") GasMerchantDeviceFunctionBkDOExample example);
}
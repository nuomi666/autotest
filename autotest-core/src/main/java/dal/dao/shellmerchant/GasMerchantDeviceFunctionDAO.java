package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMerchantDeviceFunctionDO;
import dal.model.shellmerchant.GasMerchantDeviceFunctionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantDeviceFunctionDAO extends MyMapper<GasMerchantDeviceFunctionDO> {
    long countByExample(GasMerchantDeviceFunctionDOExample example);

    int deleteByExample(GasMerchantDeviceFunctionDOExample example);

    List<GasMerchantDeviceFunctionDO> selectByExample(GasMerchantDeviceFunctionDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantDeviceFunctionDO record, @Param("example") GasMerchantDeviceFunctionDOExample example);

    int updateByExample(@Param("record") GasMerchantDeviceFunctionDO record, @Param("example") GasMerchantDeviceFunctionDOExample example);
}
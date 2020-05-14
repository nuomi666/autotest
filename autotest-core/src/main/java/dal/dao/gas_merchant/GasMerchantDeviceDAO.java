package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantDeviceDO;
import dal.model.gas_merchant.GasMerchantDeviceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantDeviceDAO extends MyMapper<GasMerchantDeviceDO> {
    long countByExample(GasMerchantDeviceDOExample example);

    int deleteByExample(GasMerchantDeviceDOExample example);

    List<GasMerchantDeviceDO> selectByExample(GasMerchantDeviceDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantDeviceDO record, @Param("example") GasMerchantDeviceDOExample example);

    int updateByExample(@Param("record") GasMerchantDeviceDO record, @Param("example") GasMerchantDeviceDOExample example);
}
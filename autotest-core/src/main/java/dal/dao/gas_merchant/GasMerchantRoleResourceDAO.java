package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantRoleResourceDO;
import dal.model.gas_merchant.GasMerchantRoleResourceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantRoleResourceDAO extends MyMapper<GasMerchantRoleResourceDO> {
    long countByExample(GasMerchantRoleResourceDOExample example);

    int deleteByExample(GasMerchantRoleResourceDOExample example);

    List<GasMerchantRoleResourceDO> selectByExample(GasMerchantRoleResourceDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantRoleResourceDO record, @Param("example") GasMerchantRoleResourceDOExample example);

    int updateByExample(@Param("record") GasMerchantRoleResourceDO record, @Param("example") GasMerchantRoleResourceDOExample example);
}
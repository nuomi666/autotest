package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantUserDO;
import dal.model.gas_merchant.GasMerchantUserDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantUserDAO extends MyMapper<GasMerchantUserDO> {
    long countByExample(GasMerchantUserDOExample example);

    int deleteByExample(GasMerchantUserDOExample example);

    List<GasMerchantUserDO> selectByExample(GasMerchantUserDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantUserDO record, @Param("example") GasMerchantUserDOExample example);

    int updateByExample(@Param("record") GasMerchantUserDO record, @Param("example") GasMerchantUserDOExample example);
}
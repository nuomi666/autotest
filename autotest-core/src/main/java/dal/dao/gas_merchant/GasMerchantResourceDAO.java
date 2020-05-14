package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantResourceDO;
import dal.model.gas_merchant.GasMerchantResourceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantResourceDAO extends MyMapper<GasMerchantResourceDO> {
    long countByExample(GasMerchantResourceDOExample example);

    int deleteByExample(GasMerchantResourceDOExample example);

    List<GasMerchantResourceDO> selectByExample(GasMerchantResourceDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantResourceDO record, @Param("example") GasMerchantResourceDOExample example);

    int updateByExample(@Param("record") GasMerchantResourceDO record, @Param("example") GasMerchantResourceDOExample example);
}
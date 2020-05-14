package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantDO;
import dal.model.gas_merchant.GasMerchantDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantDAO extends MyMapper<GasMerchantDO> {
    long countByExample(GasMerchantDOExample example);

    int deleteByExample(GasMerchantDOExample example);

    List<GasMerchantDO> selectByExample(GasMerchantDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantDO record, @Param("example") GasMerchantDOExample example);

    int updateByExample(@Param("record") GasMerchantDO record, @Param("example") GasMerchantDOExample example);
}
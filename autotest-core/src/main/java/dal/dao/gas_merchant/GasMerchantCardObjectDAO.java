package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantCardObjectDO;
import dal.model.gas_merchant.GasMerchantCardObjectDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantCardObjectDAO extends MyMapper<GasMerchantCardObjectDO> {
    long countByExample(GasMerchantCardObjectDOExample example);

    int deleteByExample(GasMerchantCardObjectDOExample example);

    List<GasMerchantCardObjectDO> selectByExample(GasMerchantCardObjectDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantCardObjectDO record, @Param("example") GasMerchantCardObjectDOExample example);

    int updateByExample(@Param("record") GasMerchantCardObjectDO record, @Param("example") GasMerchantCardObjectDOExample example);
}
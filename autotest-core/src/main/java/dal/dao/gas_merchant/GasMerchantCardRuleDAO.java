package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantCardRuleDO;
import dal.model.gas_merchant.GasMerchantCardRuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantCardRuleDAO extends MyMapper<GasMerchantCardRuleDO> {
    long countByExample(GasMerchantCardRuleDOExample example);

    int deleteByExample(GasMerchantCardRuleDOExample example);

    List<GasMerchantCardRuleDO> selectByExample(GasMerchantCardRuleDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantCardRuleDO record, @Param("example") GasMerchantCardRuleDOExample example);

    int updateByExample(@Param("record") GasMerchantCardRuleDO record, @Param("example") GasMerchantCardRuleDOExample example);
}
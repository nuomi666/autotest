package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantCardDO;
import dal.model.gas_merchant.GasMerchantCardDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantCardDAO extends MyMapper<GasMerchantCardDO> {
    long countByExample(GasMerchantCardDOExample example);

    int deleteByExample(GasMerchantCardDOExample example);

    List<GasMerchantCardDO> selectByExample(GasMerchantCardDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantCardDO record, @Param("example") GasMerchantCardDOExample example);

    int updateByExample(@Param("record") GasMerchantCardDO record, @Param("example") GasMerchantCardDOExample example);
}
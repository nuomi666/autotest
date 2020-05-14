package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantGoodsDO;
import dal.model.gas_merchant.GasMerchantGoodsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantGoodsDAO extends MyMapper<GasMerchantGoodsDO> {
    long countByExample(GasMerchantGoodsDOExample example);

    int deleteByExample(GasMerchantGoodsDOExample example);

    List<GasMerchantGoodsDO> selectByExample(GasMerchantGoodsDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantGoodsDO record, @Param("example") GasMerchantGoodsDOExample example);

    int updateByExample(@Param("record") GasMerchantGoodsDO record, @Param("example") GasMerchantGoodsDOExample example);
}
package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasMerchantGoodsDO;
import dal.model.gas_silverbolt.GasMerchantGoodsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantGoodsDAO extends MyMapper<GasMerchantGoodsDO> {
    long countByExample(GasMerchantGoodsDOExample example);

    int deleteByExample(GasMerchantGoodsDOExample example);

    List<GasMerchantGoodsDO> selectByExample(GasMerchantGoodsDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantGoodsDO record, @Param("example") GasMerchantGoodsDOExample example);

    int updateByExample(@Param("record") GasMerchantGoodsDO record, @Param("example") GasMerchantGoodsDOExample example);
}
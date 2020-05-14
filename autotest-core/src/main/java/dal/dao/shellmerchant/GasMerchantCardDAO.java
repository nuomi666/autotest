package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMerchantCardDO;
import dal.model.shellmerchant.GasMerchantCardDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantCardDAO extends MyMapper<GasMerchantCardDO> {
    long countByExample(GasMerchantCardDOExample example);

    int deleteByExample(GasMerchantCardDOExample example);

    List<GasMerchantCardDO> selectByExample(GasMerchantCardDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantCardDO record, @Param("example") GasMerchantCardDOExample example);

    int updateByExample(@Param("record") GasMerchantCardDO record, @Param("example") GasMerchantCardDOExample example);
}
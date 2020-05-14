package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMerchantPaywayDO;
import dal.model.shellmerchant.GasMerchantPaywayDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantPaywayDAO extends MyMapper<GasMerchantPaywayDO> {
    long countByExample(GasMerchantPaywayDOExample example);

    int deleteByExample(GasMerchantPaywayDOExample example);

    List<GasMerchantPaywayDO> selectByExample(GasMerchantPaywayDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantPaywayDO record, @Param("example") GasMerchantPaywayDOExample example);

    int updateByExample(@Param("record") GasMerchantPaywayDO record, @Param("example") GasMerchantPaywayDOExample example);
}
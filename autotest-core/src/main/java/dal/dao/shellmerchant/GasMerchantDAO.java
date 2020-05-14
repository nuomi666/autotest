package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMerchantDO;
import dal.model.shellmerchant.GasMerchantDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantDAO extends MyMapper<GasMerchantDO> {
    long countByExample(GasMerchantDOExample example);

    int deleteByExample(GasMerchantDOExample example);

    List<GasMerchantDO> selectByExample(GasMerchantDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantDO record, @Param("example") GasMerchantDOExample example);

    int updateByExample(@Param("record") GasMerchantDO record, @Param("example") GasMerchantDOExample example);
}
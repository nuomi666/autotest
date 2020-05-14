package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMerchantResourceDO;
import dal.model.shellmerchant.GasMerchantResourceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantResourceDAO extends MyMapper<GasMerchantResourceDO> {
    long countByExample(GasMerchantResourceDOExample example);

    int deleteByExample(GasMerchantResourceDOExample example);

    List<GasMerchantResourceDO> selectByExample(GasMerchantResourceDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantResourceDO record, @Param("example") GasMerchantResourceDOExample example);

    int updateByExample(@Param("record") GasMerchantResourceDO record, @Param("example") GasMerchantResourceDOExample example);
}
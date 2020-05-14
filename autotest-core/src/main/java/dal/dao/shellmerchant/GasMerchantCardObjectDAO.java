package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMerchantCardObjectDO;
import dal.model.shellmerchant.GasMerchantCardObjectDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantCardObjectDAO extends MyMapper<GasMerchantCardObjectDO> {
    long countByExample(GasMerchantCardObjectDOExample example);

    int deleteByExample(GasMerchantCardObjectDOExample example);

    List<GasMerchantCardObjectDO> selectByExample(GasMerchantCardObjectDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantCardObjectDO record, @Param("example") GasMerchantCardObjectDOExample example);

    int updateByExample(@Param("record") GasMerchantCardObjectDO record, @Param("example") GasMerchantCardObjectDOExample example);
}
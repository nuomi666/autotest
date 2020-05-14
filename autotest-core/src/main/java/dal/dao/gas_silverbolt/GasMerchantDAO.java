package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasMerchantDO;
import dal.model.gas_silverbolt.GasMerchantDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantDAO extends MyMapper<GasMerchantDO> {
    long countByExample(GasMerchantDOExample example);

    int deleteByExample(GasMerchantDOExample example);

    List<GasMerchantDO> selectByExample(GasMerchantDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantDO record, @Param("example") GasMerchantDOExample example);

    int updateByExample(@Param("record") GasMerchantDO record, @Param("example") GasMerchantDOExample example);
}
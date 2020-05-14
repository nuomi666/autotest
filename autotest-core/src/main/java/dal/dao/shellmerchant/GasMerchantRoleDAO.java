package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMerchantRoleDO;
import dal.model.shellmerchant.GasMerchantRoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantRoleDAO extends MyMapper<GasMerchantRoleDO> {
    long countByExample(GasMerchantRoleDOExample example);

    int deleteByExample(GasMerchantRoleDOExample example);

    List<GasMerchantRoleDO> selectByExample(GasMerchantRoleDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantRoleDO record, @Param("example") GasMerchantRoleDOExample example);

    int updateByExample(@Param("record") GasMerchantRoleDO record, @Param("example") GasMerchantRoleDOExample example);
}
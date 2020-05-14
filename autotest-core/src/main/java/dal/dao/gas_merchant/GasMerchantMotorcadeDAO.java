package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantMotorcadeDO;
import dal.model.gas_merchant.GasMerchantMotorcadeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantMotorcadeDAO extends MyMapper<GasMerchantMotorcadeDO> {
    long countByExample(GasMerchantMotorcadeDOExample example);

    int deleteByExample(GasMerchantMotorcadeDOExample example);

    List<GasMerchantMotorcadeDO> selectByExample(GasMerchantMotorcadeDOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantMotorcadeDO record, @Param("example") GasMerchantMotorcadeDOExample example);

    int updateByExample(@Param("record") GasMerchantMotorcadeDO record, @Param("example") GasMerchantMotorcadeDOExample example);
}
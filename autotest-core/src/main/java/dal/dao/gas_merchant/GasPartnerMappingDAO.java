package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasPartnerMappingDO;
import dal.model.gas_merchant.GasPartnerMappingDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasPartnerMappingDAO extends MyMapper<GasPartnerMappingDO> {
    long countByExample(GasPartnerMappingDOExample example);

    int deleteByExample(GasPartnerMappingDOExample example);

    List<GasPartnerMappingDO> selectByExample(GasPartnerMappingDOExample example);

    int updateByExampleSelective(@Param("record") GasPartnerMappingDO record, @Param("example") GasPartnerMappingDOExample example);

    int updateByExample(@Param("record") GasPartnerMappingDO record, @Param("example") GasPartnerMappingDOExample example);
}
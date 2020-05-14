package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasDistrictDO;
import dal.model.gas_merchant.GasDistrictDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDistrictDAO extends MyMapper<GasDistrictDO> {
    long countByExample(GasDistrictDOExample example);

    int deleteByExample(GasDistrictDOExample example);

    List<GasDistrictDO> selectByExample(GasDistrictDOExample example);

    int updateByExampleSelective(@Param("record") GasDistrictDO record, @Param("example") GasDistrictDOExample example);

    int updateByExample(@Param("record") GasDistrictDO record, @Param("example") GasDistrictDOExample example);
}
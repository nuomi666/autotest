package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasCityDO;
import dal.model.gas_merchant.GasCityDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasCityDAO extends MyMapper<GasCityDO> {
    long countByExample(GasCityDOExample example);

    int deleteByExample(GasCityDOExample example);

    List<GasCityDO> selectByExample(GasCityDOExample example);

    int updateByExampleSelective(@Param("record") GasCityDO record, @Param("example") GasCityDOExample example);

    int updateByExample(@Param("record") GasCityDO record, @Param("example") GasCityDOExample example);
}
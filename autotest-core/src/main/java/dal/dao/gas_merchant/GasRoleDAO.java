package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasRoleDO;
import dal.model.gas_merchant.GasRoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasRoleDAO extends MyMapper<GasRoleDO> {
    long countByExample(GasRoleDOExample example);

    int deleteByExample(GasRoleDOExample example);

    List<GasRoleDO> selectByExample(GasRoleDOExample example);

    int updateByExampleSelective(@Param("record") GasRoleDO record, @Param("example") GasRoleDOExample example);

    int updateByExample(@Param("record") GasRoleDO record, @Param("example") GasRoleDOExample example);
}
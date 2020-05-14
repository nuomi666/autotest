package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.RoleDO;
import dal.model.gas_merchant.RoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDAO extends MyMapper<RoleDO> {
    long countByExample(RoleDOExample example);

    int deleteByExample(RoleDOExample example);

    List<RoleDO> selectByExample(RoleDOExample example);

    int updateByExampleSelective(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    int updateByExample(@Param("record") RoleDO record, @Param("example") RoleDOExample example);
}
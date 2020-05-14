package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.RolePermissionDO;
import dal.model.gas_merchant.RolePermissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionDAO extends MyMapper<RolePermissionDO> {
    long countByExample(RolePermissionDOExample example);

    int deleteByExample(RolePermissionDOExample example);

    List<RolePermissionDO> selectByExample(RolePermissionDOExample example);

    int updateByExampleSelective(@Param("record") RolePermissionDO record, @Param("example") RolePermissionDOExample example);

    int updateByExample(@Param("record") RolePermissionDO record, @Param("example") RolePermissionDOExample example);
}
package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.RolePermissionCopy2DO;
import dal.model.gas_merchant.RolePermissionCopy2DOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionCopy2DAO extends MyMapper<RolePermissionCopy2DO> {
    long countByExample(RolePermissionCopy2DOExample example);

    int deleteByExample(RolePermissionCopy2DOExample example);

    List<RolePermissionCopy2DO> selectByExample(RolePermissionCopy2DOExample example);

    int updateByExampleSelective(@Param("record") RolePermissionCopy2DO record, @Param("example") RolePermissionCopy2DOExample example);

    int updateByExample(@Param("record") RolePermissionCopy2DO record, @Param("example") RolePermissionCopy2DOExample example);
}
package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.RolePermissionCopy1DO;
import dal.model.gas_merchant.RolePermissionCopy1DOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionCopy1DAO extends MyMapper<RolePermissionCopy1DO> {
    long countByExample(RolePermissionCopy1DOExample example);

    int deleteByExample(RolePermissionCopy1DOExample example);

    List<RolePermissionCopy1DO> selectByExample(RolePermissionCopy1DOExample example);

    int updateByExampleSelective(@Param("record") RolePermissionCopy1DO record, @Param("example") RolePermissionCopy1DOExample example);

    int updateByExample(@Param("record") RolePermissionCopy1DO record, @Param("example") RolePermissionCopy1DOExample example);
}
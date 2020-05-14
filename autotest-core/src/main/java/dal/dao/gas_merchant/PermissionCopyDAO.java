package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.PermissionCopyDO;
import dal.model.gas_merchant.PermissionCopyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionCopyDAO extends MyMapper<PermissionCopyDO> {
    long countByExample(PermissionCopyDOExample example);

    int deleteByExample(PermissionCopyDOExample example);

    List<PermissionCopyDO> selectByExample(PermissionCopyDOExample example);

    int updateByExampleSelective(@Param("record") PermissionCopyDO record, @Param("example") PermissionCopyDOExample example);

    int updateByExample(@Param("record") PermissionCopyDO record, @Param("example") PermissionCopyDOExample example);
}
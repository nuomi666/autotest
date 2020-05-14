package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.PermissionDO;
import dal.model.gas_merchant.PermissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionDAO extends MyMapper<PermissionDO> {
    long countByExample(PermissionDOExample example);

    int deleteByExample(PermissionDOExample example);

    List<PermissionDO> selectByExample(PermissionDOExample example);

    int updateByExampleSelective(@Param("record") PermissionDO record, @Param("example") PermissionDOExample example);

    int updateByExample(@Param("record") PermissionDO record, @Param("example") PermissionDOExample example);
}
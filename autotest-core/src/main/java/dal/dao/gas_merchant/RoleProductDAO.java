package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.RoleProductDO;
import dal.model.gas_merchant.RoleProductDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleProductDAO extends MyMapper<RoleProductDO> {
    long countByExample(RoleProductDOExample example);

    int deleteByExample(RoleProductDOExample example);

    List<RoleProductDO> selectByExample(RoleProductDOExample example);

    int updateByExampleSelective(@Param("record") RoleProductDO record, @Param("example") RoleProductDOExample example);

    int updateByExample(@Param("record") RoleProductDO record, @Param("example") RoleProductDOExample example);
}
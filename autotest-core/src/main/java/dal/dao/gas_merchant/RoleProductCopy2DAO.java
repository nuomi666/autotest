package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.RoleProductCopy2DO;
import dal.model.gas_merchant.RoleProductCopy2DOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleProductCopy2DAO extends MyMapper<RoleProductCopy2DO> {
    long countByExample(RoleProductCopy2DOExample example);

    int deleteByExample(RoleProductCopy2DOExample example);

    List<RoleProductCopy2DO> selectByExample(RoleProductCopy2DOExample example);

    int updateByExampleSelective(@Param("record") RoleProductCopy2DO record, @Param("example") RoleProductCopy2DOExample example);

    int updateByExample(@Param("record") RoleProductCopy2DO record, @Param("example") RoleProductCopy2DOExample example);
}
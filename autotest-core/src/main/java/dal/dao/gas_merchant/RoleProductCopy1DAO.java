package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.RoleProductCopy1DO;
import dal.model.gas_merchant.RoleProductCopy1DOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleProductCopy1DAO extends MyMapper<RoleProductCopy1DO> {
    long countByExample(RoleProductCopy1DOExample example);

    int deleteByExample(RoleProductCopy1DOExample example);

    List<RoleProductCopy1DO> selectByExample(RoleProductCopy1DOExample example);

    int updateByExampleSelective(@Param("record") RoleProductCopy1DO record, @Param("example") RoleProductCopy1DOExample example);

    int updateByExample(@Param("record") RoleProductCopy1DO record, @Param("example") RoleProductCopy1DOExample example);
}
package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.UserUniqueKeyDO;
import dal.model.gas_merchant.UserUniqueKeyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserUniqueKeyDAO extends MyMapper<UserUniqueKeyDO> {
    long countByExample(UserUniqueKeyDOExample example);

    int deleteByExample(UserUniqueKeyDOExample example);

    List<UserUniqueKeyDO> selectByExample(UserUniqueKeyDOExample example);

    int updateByExampleSelective(@Param("record") UserUniqueKeyDO record, @Param("example") UserUniqueKeyDOExample example);

    int updateByExample(@Param("record") UserUniqueKeyDO record, @Param("example") UserUniqueKeyDOExample example);
}
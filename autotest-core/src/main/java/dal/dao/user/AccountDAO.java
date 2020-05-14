package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.AccountDO;
import dal.model.user.AccountDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountDAO extends MyMapper<AccountDO> {
    long countByExample(AccountDOExample example);

    int deleteByExample(AccountDOExample example);

    List<AccountDO> selectByExample(AccountDOExample example);

    int updateByExampleSelective(@Param("record") AccountDO record, @Param("example") AccountDOExample example);

    int updateByExample(@Param("record") AccountDO record, @Param("example") AccountDOExample example);
}
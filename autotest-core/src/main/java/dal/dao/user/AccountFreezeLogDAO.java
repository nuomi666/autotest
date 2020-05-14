package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.AccountFreezeLogDO;
import dal.model.user.AccountFreezeLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountFreezeLogDAO extends MyMapper<AccountFreezeLogDO> {
    long countByExample(AccountFreezeLogDOExample example);

    int deleteByExample(AccountFreezeLogDOExample example);

    List<AccountFreezeLogDO> selectByExample(AccountFreezeLogDOExample example);

    int updateByExampleSelective(@Param("record") AccountFreezeLogDO record, @Param("example") AccountFreezeLogDOExample example);

    int updateByExample(@Param("record") AccountFreezeLogDO record, @Param("example") AccountFreezeLogDOExample example);
}
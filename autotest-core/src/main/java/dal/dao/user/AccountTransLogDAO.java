package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.AccountTransLogDO;
import dal.model.user.AccountTransLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountTransLogDAO extends MyMapper<AccountTransLogDO> {
    long countByExample(AccountTransLogDOExample example);

    int deleteByExample(AccountTransLogDOExample example);

    List<AccountTransLogDO> selectByExample(AccountTransLogDOExample example);

    int updateByExampleSelective(@Param("record") AccountTransLogDO record, @Param("example") AccountTransLogDOExample example);

    int updateByExample(@Param("record") AccountTransLogDO record, @Param("example") AccountTransLogDOExample example);
}
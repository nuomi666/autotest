package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.AccountBatchLogDO;
import dal.model.user.AccountBatchLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountBatchLogDAO extends MyMapper<AccountBatchLogDO> {
    long countByExample(AccountBatchLogDOExample example);

    int deleteByExample(AccountBatchLogDOExample example);

    List<AccountBatchLogDO> selectByExample(AccountBatchLogDOExample example);

    int updateByExampleSelective(@Param("record") AccountBatchLogDO record, @Param("example") AccountBatchLogDOExample example);

    int updateByExample(@Param("record") AccountBatchLogDO record, @Param("example") AccountBatchLogDOExample example);
}
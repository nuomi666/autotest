package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.AccountFreezeCodeAmountDO;
import dal.model.user.AccountFreezeCodeAmountDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountFreezeCodeAmountDAO extends MyMapper<AccountFreezeCodeAmountDO> {
    long countByExample(AccountFreezeCodeAmountDOExample example);

    int deleteByExample(AccountFreezeCodeAmountDOExample example);

    List<AccountFreezeCodeAmountDO> selectByExample(AccountFreezeCodeAmountDOExample example);

    int updateByExampleSelective(@Param("record") AccountFreezeCodeAmountDO record, @Param("example") AccountFreezeCodeAmountDOExample example);

    int updateByExample(@Param("record") AccountFreezeCodeAmountDO record, @Param("example") AccountFreezeCodeAmountDOExample example);
}
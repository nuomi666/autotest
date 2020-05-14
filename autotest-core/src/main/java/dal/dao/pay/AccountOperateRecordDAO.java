package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.AccountOperateRecordDO;
import dal.model.pay.AccountOperateRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountOperateRecordDAO extends MyMapper<AccountOperateRecordDO> {
    long countByExample(AccountOperateRecordDOExample example);

    int deleteByExample(AccountOperateRecordDOExample example);

    List<AccountOperateRecordDO> selectByExample(AccountOperateRecordDOExample example);

    int updateByExampleSelective(@Param("record") AccountOperateRecordDO record, @Param("example") AccountOperateRecordDOExample example);

    int updateByExample(@Param("record") AccountOperateRecordDO record, @Param("example") AccountOperateRecordDOExample example);
}
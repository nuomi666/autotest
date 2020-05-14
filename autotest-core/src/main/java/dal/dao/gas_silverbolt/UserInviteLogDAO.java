package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.UserInviteLogDO;
import dal.model.gas_silverbolt.UserInviteLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInviteLogDAO extends MyMapper<UserInviteLogDO> {
    long countByExample(UserInviteLogDOExample example);

    int deleteByExample(UserInviteLogDOExample example);

    List<UserInviteLogDO> selectByExample(UserInviteLogDOExample example);

    int updateByExampleSelective(@Param("record") UserInviteLogDO record, @Param("example") UserInviteLogDOExample example);

    int updateByExample(@Param("record") UserInviteLogDO record, @Param("example") UserInviteLogDOExample example);
}
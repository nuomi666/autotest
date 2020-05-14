package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.UserIntegralResetTaskDO;
import dal.model.gas_user.UserIntegralResetTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserIntegralResetTaskDAO extends MyMapper<UserIntegralResetTaskDO> {
    long countByExample(UserIntegralResetTaskDOExample example);

    int deleteByExample(UserIntegralResetTaskDOExample example);

    List<UserIntegralResetTaskDO> selectByExample(UserIntegralResetTaskDOExample example);

    int updateByExampleSelective(@Param("record") UserIntegralResetTaskDO record, @Param("example") UserIntegralResetTaskDOExample example);

    int updateByExample(@Param("record") UserIntegralResetTaskDO record, @Param("example") UserIntegralResetTaskDOExample example);
}
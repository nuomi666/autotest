package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.UserNotifyTaskDO;
import dal.model.user.UserNotifyTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserNotifyTaskDAO extends MyMapper<UserNotifyTaskDO> {
    long countByExample(UserNotifyTaskDOExample example);

    int deleteByExample(UserNotifyTaskDOExample example);

    List<UserNotifyTaskDO> selectByExample(UserNotifyTaskDOExample example);

    int updateByExampleSelective(@Param("record") UserNotifyTaskDO record, @Param("example") UserNotifyTaskDOExample example);

    int updateByExample(@Param("record") UserNotifyTaskDO record, @Param("example") UserNotifyTaskDOExample example);
}
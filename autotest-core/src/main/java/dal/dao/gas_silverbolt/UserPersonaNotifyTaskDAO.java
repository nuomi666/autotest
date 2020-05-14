package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.UserPersonaNotifyTaskDO;
import dal.model.gas_silverbolt.UserPersonaNotifyTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPersonaNotifyTaskDAO extends MyMapper<UserPersonaNotifyTaskDO> {
    long countByExample(UserPersonaNotifyTaskDOExample example);

    int deleteByExample(UserPersonaNotifyTaskDOExample example);

    List<UserPersonaNotifyTaskDO> selectByExampleWithBLOBs(UserPersonaNotifyTaskDOExample example);

    List<UserPersonaNotifyTaskDO> selectByExample(UserPersonaNotifyTaskDOExample example);

    int updateByExampleSelective(@Param("record") UserPersonaNotifyTaskDO record, @Param("example") UserPersonaNotifyTaskDOExample example);

    int updateByExampleWithBLOBs(@Param("record") UserPersonaNotifyTaskDO record, @Param("example") UserPersonaNotifyTaskDOExample example);

    int updateByExample(@Param("record") UserPersonaNotifyTaskDO record, @Param("example") UserPersonaNotifyTaskDOExample example);
}
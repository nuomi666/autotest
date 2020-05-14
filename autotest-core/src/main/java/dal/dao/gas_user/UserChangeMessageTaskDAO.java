package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.UserChangeMessageTaskDO;
import dal.model.gas_user.UserChangeMessageTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserChangeMessageTaskDAO extends MyMapper<UserChangeMessageTaskDO> {
    long countByExample(UserChangeMessageTaskDOExample example);

    int deleteByExample(UserChangeMessageTaskDOExample example);

    List<UserChangeMessageTaskDO> selectByExample(UserChangeMessageTaskDOExample example);

    int updateByExampleSelective(@Param("record") UserChangeMessageTaskDO record, @Param("example") UserChangeMessageTaskDOExample example);

    int updateByExample(@Param("record") UserChangeMessageTaskDO record, @Param("example") UserChangeMessageTaskDOExample example);
}
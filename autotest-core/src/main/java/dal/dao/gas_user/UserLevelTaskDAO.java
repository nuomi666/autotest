package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.UserLevelTaskDO;
import dal.model.gas_user.UserLevelTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLevelTaskDAO extends MyMapper<UserLevelTaskDO> {
    long countByExample(UserLevelTaskDOExample example);

    int deleteByExample(UserLevelTaskDOExample example);

    List<UserLevelTaskDO> selectByExample(UserLevelTaskDOExample example);

    int updateByExampleSelective(@Param("record") UserLevelTaskDO record, @Param("example") UserLevelTaskDOExample example);

    int updateByExample(@Param("record") UserLevelTaskDO record, @Param("example") UserLevelTaskDOExample example);
}
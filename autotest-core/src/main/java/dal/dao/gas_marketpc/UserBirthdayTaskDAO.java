package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.UserBirthdayTaskDO;
import dal.model.gas_marketpc.UserBirthdayTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBirthdayTaskDAO extends MyMapper<UserBirthdayTaskDO> {
    long countByExample(UserBirthdayTaskDOExample example);

    int deleteByExample(UserBirthdayTaskDOExample example);

    List<UserBirthdayTaskDO> selectByExample(UserBirthdayTaskDOExample example);

    int updateByExampleSelective(@Param("record") UserBirthdayTaskDO record, @Param("example") UserBirthdayTaskDOExample example);

    int updateByExample(@Param("record") UserBirthdayTaskDO record, @Param("example") UserBirthdayTaskDOExample example);
}
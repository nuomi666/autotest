package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.UserCarInfoDO;
import dal.model.gas_user.UserCarInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCarInfoDAO extends MyMapper<UserCarInfoDO> {
    long countByExample(UserCarInfoDOExample example);

    int deleteByExample(UserCarInfoDOExample example);

    List<UserCarInfoDO> selectByExample(UserCarInfoDOExample example);

    int updateByExampleSelective(@Param("record") UserCarInfoDO record, @Param("example") UserCarInfoDOExample example);

    int updateByExample(@Param("record") UserCarInfoDO record, @Param("example") UserCarInfoDOExample example);
}
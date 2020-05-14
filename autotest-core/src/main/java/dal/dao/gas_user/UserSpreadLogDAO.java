package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.UserSpreadLogDO;
import dal.model.gas_user.UserSpreadLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSpreadLogDAO extends MyMapper<UserSpreadLogDO> {
    long countByExample(UserSpreadLogDOExample example);

    int deleteByExample(UserSpreadLogDOExample example);

    List<UserSpreadLogDO> selectByExample(UserSpreadLogDOExample example);

    int updateByExampleSelective(@Param("record") UserSpreadLogDO record, @Param("example") UserSpreadLogDOExample example);

    int updateByExample(@Param("record") UserSpreadLogDO record, @Param("example") UserSpreadLogDOExample example);
}
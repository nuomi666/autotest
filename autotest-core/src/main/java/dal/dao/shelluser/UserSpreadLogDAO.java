package dal.dao.shelluser;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shelluser.UserSpreadLogDO;
import dal.model.shelluser.UserSpreadLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSpreadLogDAO extends MyMapper<UserSpreadLogDO> {
    long countByExample(UserSpreadLogDOExample example);

    int deleteByExample(UserSpreadLogDOExample example);

    List<UserSpreadLogDO> selectByExample(UserSpreadLogDOExample example);

    int updateByExampleSelective(@Param("record") UserSpreadLogDO record, @Param("example") UserSpreadLogDOExample example);

    int updateByExample(@Param("record") UserSpreadLogDO record, @Param("example") UserSpreadLogDOExample example);
}
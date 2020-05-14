package dal.dao.shelluser;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shelluser.UserPayToolInfoDO;
import dal.model.shelluser.UserPayToolInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPayToolInfoDAO extends MyMapper<UserPayToolInfoDO> {
    long countByExample(UserPayToolInfoDOExample example);

    int deleteByExample(UserPayToolInfoDOExample example);

    List<UserPayToolInfoDO> selectByExample(UserPayToolInfoDOExample example);

    int updateByExampleSelective(@Param("record") UserPayToolInfoDO record, @Param("example") UserPayToolInfoDOExample example);

    int updateByExample(@Param("record") UserPayToolInfoDO record, @Param("example") UserPayToolInfoDOExample example);
}
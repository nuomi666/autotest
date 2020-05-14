package dal.dao.shelluser;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shelluser.UserLevelUpdFailDO;
import dal.model.shelluser.UserLevelUpdFailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLevelUpdFailDAO extends MyMapper<UserLevelUpdFailDO> {
    long countByExample(UserLevelUpdFailDOExample example);

    int deleteByExample(UserLevelUpdFailDOExample example);

    List<UserLevelUpdFailDO> selectByExample(UserLevelUpdFailDOExample example);

    int updateByExampleSelective(@Param("record") UserLevelUpdFailDO record, @Param("example") UserLevelUpdFailDOExample example);

    int updateByExample(@Param("record") UserLevelUpdFailDO record, @Param("example") UserLevelUpdFailDOExample example);
}
package dal.dao.shelluser;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shelluser.UserLabelDO;
import dal.model.shelluser.UserLabelDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLabelDAO extends MyMapper<UserLabelDO> {
    long countByExample(UserLabelDOExample example);

    int deleteByExample(UserLabelDOExample example);

    List<UserLabelDO> selectByExample(UserLabelDOExample example);

    int updateByExampleSelective(@Param("record") UserLabelDO record, @Param("example") UserLabelDOExample example);

    int updateByExample(@Param("record") UserLabelDO record, @Param("example") UserLabelDOExample example);
}
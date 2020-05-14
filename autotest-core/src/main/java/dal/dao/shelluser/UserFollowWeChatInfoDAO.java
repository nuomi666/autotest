package dal.dao.shelluser;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shelluser.UserFollowWeChatInfoDO;
import dal.model.shelluser.UserFollowWeChatInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFollowWeChatInfoDAO extends MyMapper<UserFollowWeChatInfoDO> {
    long countByExample(UserFollowWeChatInfoDOExample example);

    int deleteByExample(UserFollowWeChatInfoDOExample example);

    List<UserFollowWeChatInfoDO> selectByExample(UserFollowWeChatInfoDOExample example);

    int updateByExampleSelective(@Param("record") UserFollowWeChatInfoDO record, @Param("example") UserFollowWeChatInfoDOExample example);

    int updateByExample(@Param("record") UserFollowWeChatInfoDO record, @Param("example") UserFollowWeChatInfoDOExample example);
}
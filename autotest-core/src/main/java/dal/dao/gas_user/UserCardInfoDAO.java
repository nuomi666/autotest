package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.UserCardInfoDO;
import dal.model.gas_user.UserCardInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCardInfoDAO extends MyMapper<UserCardInfoDO> {
    long countByExample(UserCardInfoDOExample example);

    int deleteByExample(UserCardInfoDOExample example);

    List<UserCardInfoDO> selectByExample(UserCardInfoDOExample example);

    int updateByExampleSelective(@Param("record") UserCardInfoDO record, @Param("example") UserCardInfoDOExample example);

    int updateByExample(@Param("record") UserCardInfoDO record, @Param("example") UserCardInfoDOExample example);
}
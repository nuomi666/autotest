package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.UserGroupDO;
import dal.model.gas_marketpc.UserGroupDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupDAO extends MyMapper<UserGroupDO> {
    long countByExample(UserGroupDOExample example);

    int deleteByExample(UserGroupDOExample example);

    List<UserGroupDO> selectByExample(UserGroupDOExample example);

    int updateByExampleSelective(@Param("record") UserGroupDO record, @Param("example") UserGroupDOExample example);

    int updateByExample(@Param("record") UserGroupDO record, @Param("example") UserGroupDOExample example);
}
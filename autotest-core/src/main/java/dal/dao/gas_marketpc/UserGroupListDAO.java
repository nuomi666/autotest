package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.UserGroupListDO;
import dal.model.gas_marketpc.UserGroupListDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupListDAO extends MyMapper<UserGroupListDO> {
    long countByExample(UserGroupListDOExample example);

    int deleteByExample(UserGroupListDOExample example);

    List<UserGroupListDO> selectByExample(UserGroupListDOExample example);

    int updateByExampleSelective(@Param("record") UserGroupListDO record, @Param("example") UserGroupListDOExample example);

    int updateByExample(@Param("record") UserGroupListDO record, @Param("example") UserGroupListDOExample example);
}
package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.UserActionEventDO;
import dal.model.gas_marketpc.UserActionEventDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserActionEventDAO extends MyMapper<UserActionEventDO> {
    long countByExample(UserActionEventDOExample example);

    int deleteByExample(UserActionEventDOExample example);

    List<UserActionEventDO> selectByExampleWithBLOBs(UserActionEventDOExample example);

    List<UserActionEventDO> selectByExample(UserActionEventDOExample example);

    int updateByExampleSelective(@Param("record") UserActionEventDO record, @Param("example") UserActionEventDOExample example);

    int updateByExampleWithBLOBs(@Param("record") UserActionEventDO record, @Param("example") UserActionEventDOExample example);

    int updateByExample(@Param("record") UserActionEventDO record, @Param("example") UserActionEventDOExample example);
}
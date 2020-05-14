package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.UserDimensionDO;
import dal.model.gas_silverbolt.UserDimensionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDimensionDAO extends MyMapper<UserDimensionDO> {
    long countByExample(UserDimensionDOExample example);

    int deleteByExample(UserDimensionDOExample example);

    List<UserDimensionDO> selectByExample(UserDimensionDOExample example);

    int updateByExampleSelective(@Param("record") UserDimensionDO record, @Param("example") UserDimensionDOExample example);

    int updateByExample(@Param("record") UserDimensionDO record, @Param("example") UserDimensionDOExample example);
}
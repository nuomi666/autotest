package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.ViewUserCarDO;
import dal.model.gas_user.ViewUserCarDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewUserCarDAO extends MyMapper<ViewUserCarDO> {
    long countByExample(ViewUserCarDOExample example);

    int deleteByExample(ViewUserCarDOExample example);

    List<ViewUserCarDO> selectByExample(ViewUserCarDOExample example);

    int updateByExampleSelective(@Param("record") ViewUserCarDO record, @Param("example") ViewUserCarDOExample example);

    int updateByExample(@Param("record") ViewUserCarDO record, @Param("example") ViewUserCarDOExample example);
}
package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.PointChangeMessageTaskDO;
import dal.model.gas_user.PointChangeMessageTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PointChangeMessageTaskDAO extends MyMapper<PointChangeMessageTaskDO> {
    long countByExample(PointChangeMessageTaskDOExample example);

    int deleteByExample(PointChangeMessageTaskDOExample example);

    List<PointChangeMessageTaskDO> selectByExample(PointChangeMessageTaskDOExample example);

    int updateByExampleSelective(@Param("record") PointChangeMessageTaskDO record, @Param("example") PointChangeMessageTaskDOExample example);

    int updateByExample(@Param("record") PointChangeMessageTaskDO record, @Param("example") PointChangeMessageTaskDOExample example);
}
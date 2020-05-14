package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasPointsChangeDO;
import dal.model.gas_silverbolt.GasPointsChangeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasPointsChangeDAO extends MyMapper<GasPointsChangeDO> {
    long countByExample(GasPointsChangeDOExample example);

    int deleteByExample(GasPointsChangeDOExample example);

    List<GasPointsChangeDO> selectByExample(GasPointsChangeDOExample example);

    int updateByExampleSelective(@Param("record") GasPointsChangeDO record, @Param("example") GasPointsChangeDOExample example);

    int updateByExample(@Param("record") GasPointsChangeDO record, @Param("example") GasPointsChangeDOExample example);
}
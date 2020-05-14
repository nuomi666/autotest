package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasUserGroupDO;
import dal.model.gas_silverbolt.GasUserGroupDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasUserGroupDAO extends MyMapper<GasUserGroupDO> {
    long countByExample(GasUserGroupDOExample example);

    int deleteByExample(GasUserGroupDOExample example);

    List<GasUserGroupDO> selectByExample(GasUserGroupDOExample example);

    int updateByExampleSelective(@Param("record") GasUserGroupDO record, @Param("example") GasUserGroupDOExample example);

    int updateByExample(@Param("record") GasUserGroupDO record, @Param("example") GasUserGroupDOExample example);
}
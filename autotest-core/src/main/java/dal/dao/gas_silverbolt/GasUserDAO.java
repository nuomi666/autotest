package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasUserDO;
import dal.model.gas_silverbolt.GasUserDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasUserDAO extends MyMapper<GasUserDO> {
    long countByExample(GasUserDOExample example);

    int deleteByExample(GasUserDOExample example);

    List<GasUserDO> selectByExample(GasUserDOExample example);

    int updateByExampleSelective(@Param("record") GasUserDO record, @Param("example") GasUserDOExample example);

    int updateByExample(@Param("record") GasUserDO record, @Param("example") GasUserDOExample example);
}
package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasTerminalLoginDO;
import dal.model.gas_silverbolt.GasTerminalLoginDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTerminalLoginDAO extends MyMapper<GasTerminalLoginDO> {
    long countByExample(GasTerminalLoginDOExample example);

    int deleteByExample(GasTerminalLoginDOExample example);

    List<GasTerminalLoginDO> selectByExample(GasTerminalLoginDOExample example);

    int updateByExampleSelective(@Param("record") GasTerminalLoginDO record, @Param("example") GasTerminalLoginDOExample example);

    int updateByExample(@Param("record") GasTerminalLoginDO record, @Param("example") GasTerminalLoginDOExample example);
}
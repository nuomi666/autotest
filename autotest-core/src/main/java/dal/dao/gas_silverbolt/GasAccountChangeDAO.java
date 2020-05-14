package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasAccountChangeDO;
import dal.model.gas_silverbolt.GasAccountChangeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasAccountChangeDAO extends MyMapper<GasAccountChangeDO> {
    long countByExample(GasAccountChangeDOExample example);

    int deleteByExample(GasAccountChangeDOExample example);

    List<GasAccountChangeDO> selectByExample(GasAccountChangeDOExample example);

    int updateByExampleSelective(@Param("record") GasAccountChangeDO record, @Param("example") GasAccountChangeDOExample example);

    int updateByExample(@Param("record") GasAccountChangeDO record, @Param("example") GasAccountChangeDOExample example);
}
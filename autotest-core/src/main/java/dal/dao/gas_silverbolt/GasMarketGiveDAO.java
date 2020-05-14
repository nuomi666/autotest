package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasMarketGiveDO;
import dal.model.gas_silverbolt.GasMarketGiveDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMarketGiveDAO extends MyMapper<GasMarketGiveDO> {
    long countByExample(GasMarketGiveDOExample example);

    int deleteByExample(GasMarketGiveDOExample example);

    List<GasMarketGiveDO> selectByExample(GasMarketGiveDOExample example);

    int updateByExampleSelective(@Param("record") GasMarketGiveDO record, @Param("example") GasMarketGiveDOExample example);

    int updateByExample(@Param("record") GasMarketGiveDO record, @Param("example") GasMarketGiveDOExample example);
}
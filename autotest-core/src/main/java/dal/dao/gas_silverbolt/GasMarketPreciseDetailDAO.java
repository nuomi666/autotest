package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasMarketPreciseDetailDO;
import dal.model.gas_silverbolt.GasMarketPreciseDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMarketPreciseDetailDAO extends MyMapper<GasMarketPreciseDetailDO> {
    long countByExample(GasMarketPreciseDetailDOExample example);

    int deleteByExample(GasMarketPreciseDetailDOExample example);

    List<GasMarketPreciseDetailDO> selectByExampleWithBLOBs(GasMarketPreciseDetailDOExample example);

    List<GasMarketPreciseDetailDO> selectByExample(GasMarketPreciseDetailDOExample example);

    int updateByExampleSelective(@Param("record") GasMarketPreciseDetailDO record, @Param("example") GasMarketPreciseDetailDOExample example);

    int updateByExampleWithBLOBs(@Param("record") GasMarketPreciseDetailDO record, @Param("example") GasMarketPreciseDetailDOExample example);

    int updateByExample(@Param("record") GasMarketPreciseDetailDO record, @Param("example") GasMarketPreciseDetailDOExample example);
}
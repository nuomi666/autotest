package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.PreciseGiveDO;
import dal.model.gas_marketpc.PreciseGiveDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PreciseGiveDAO extends MyMapper<PreciseGiveDO> {
    long countByExample(PreciseGiveDOExample example);

    int deleteByExample(PreciseGiveDOExample example);

    List<PreciseGiveDO> selectByExample(PreciseGiveDOExample example);

    int updateByExampleSelective(@Param("record") PreciseGiveDO record, @Param("example") PreciseGiveDOExample example);

    int updateByExample(@Param("record") PreciseGiveDO record, @Param("example") PreciseGiveDOExample example);
}
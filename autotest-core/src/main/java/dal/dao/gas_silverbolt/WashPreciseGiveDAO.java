package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.WashPreciseGiveDO;
import dal.model.gas_silverbolt.WashPreciseGiveDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WashPreciseGiveDAO extends MyMapper<WashPreciseGiveDO> {
    long countByExample(WashPreciseGiveDOExample example);

    int deleteByExample(WashPreciseGiveDOExample example);

    List<WashPreciseGiveDO> selectByExample(WashPreciseGiveDOExample example);

    int updateByExampleSelective(@Param("record") WashPreciseGiveDO record, @Param("example") WashPreciseGiveDOExample example);

    int updateByExample(@Param("record") WashPreciseGiveDO record, @Param("example") WashPreciseGiveDOExample example);
}
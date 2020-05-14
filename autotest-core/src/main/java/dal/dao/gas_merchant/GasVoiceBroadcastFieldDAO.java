package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasVoiceBroadcastFieldDO;
import dal.model.gas_merchant.GasVoiceBroadcastFieldDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasVoiceBroadcastFieldDAO extends MyMapper<GasVoiceBroadcastFieldDO> {
    long countByExample(GasVoiceBroadcastFieldDOExample example);

    int deleteByExample(GasVoiceBroadcastFieldDOExample example);

    List<GasVoiceBroadcastFieldDO> selectByExample(GasVoiceBroadcastFieldDOExample example);

    int updateByExampleSelective(@Param("record") GasVoiceBroadcastFieldDO record, @Param("example") GasVoiceBroadcastFieldDOExample example);

    int updateByExample(@Param("record") GasVoiceBroadcastFieldDO record, @Param("example") GasVoiceBroadcastFieldDOExample example);
}
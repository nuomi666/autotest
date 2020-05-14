package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasStationVoiceBroadcastDO;
import dal.model.gas_merchant.GasStationVoiceBroadcastDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasStationVoiceBroadcastDAO extends MyMapper<GasStationVoiceBroadcastDO> {
    long countByExample(GasStationVoiceBroadcastDOExample example);

    int deleteByExample(GasStationVoiceBroadcastDOExample example);

    List<GasStationVoiceBroadcastDO> selectByExample(GasStationVoiceBroadcastDOExample example);

    int updateByExampleSelective(@Param("record") GasStationVoiceBroadcastDO record, @Param("example") GasStationVoiceBroadcastDOExample example);

    int updateByExample(@Param("record") GasStationVoiceBroadcastDO record, @Param("example") GasStationVoiceBroadcastDOExample example);
}
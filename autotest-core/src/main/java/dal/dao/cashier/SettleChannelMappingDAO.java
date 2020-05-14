package dal.dao.cashier;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.cashier.SettleChannelMappingDO;
import dal.model.cashier.SettleChannelMappingDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettleChannelMappingDAO extends MyMapper<SettleChannelMappingDO> {
    long countByExample(SettleChannelMappingDOExample example);

    int deleteByExample(SettleChannelMappingDOExample example);

    List<SettleChannelMappingDO> selectByExample(SettleChannelMappingDOExample example);

    int updateByExampleSelective(@Param("record") SettleChannelMappingDO record, @Param("example") SettleChannelMappingDOExample example);

    int updateByExample(@Param("record") SettleChannelMappingDO record, @Param("example") SettleChannelMappingDOExample example);
}
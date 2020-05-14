package dal.dao.cashier;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.cashier.ChannelMappingDO;
import dal.model.cashier.ChannelMappingDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelMappingDAO extends MyMapper<ChannelMappingDO> {
    long countByExample(ChannelMappingDOExample example);

    int deleteByExample(ChannelMappingDOExample example);

    List<ChannelMappingDO> selectByExampleWithBLOBs(ChannelMappingDOExample example);

    List<ChannelMappingDO> selectByExample(ChannelMappingDOExample example);

    int updateByExampleSelective(@Param("record") ChannelMappingDO record, @Param("example") ChannelMappingDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ChannelMappingDO record, @Param("example") ChannelMappingDOExample example);

    int updateByExample(@Param("record") ChannelMappingDO record, @Param("example") ChannelMappingDOExample example);
}
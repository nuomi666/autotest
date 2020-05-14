package dal.dao.cashier;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.cashier.ChannelDO;
import dal.model.cashier.ChannelDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelDAO extends MyMapper<ChannelDO> {
    long countByExample(ChannelDOExample example);

    int deleteByExample(ChannelDOExample example);

    List<ChannelDO> selectByExample(ChannelDOExample example);

    int updateByExampleSelective(@Param("record") ChannelDO record, @Param("example") ChannelDOExample example);

    int updateByExample(@Param("record") ChannelDO record, @Param("example") ChannelDOExample example);
}
package dal.dao.cashier;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.cashier.SettleChannelDO;
import dal.model.cashier.SettleChannelDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettleChannelDAO extends MyMapper<SettleChannelDO> {
    long countByExample(SettleChannelDOExample example);

    int deleteByExample(SettleChannelDOExample example);

    List<SettleChannelDO> selectByExample(SettleChannelDOExample example);

    int updateByExampleSelective(@Param("record") SettleChannelDO record, @Param("example") SettleChannelDOExample example);

    int updateByExample(@Param("record") SettleChannelDO record, @Param("example") SettleChannelDOExample example);
}
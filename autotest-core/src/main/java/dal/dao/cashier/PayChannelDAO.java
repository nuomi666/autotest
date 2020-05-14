package dal.dao.cashier;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.cashier.PayChannelDO;
import dal.model.cashier.PayChannelDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayChannelDAO extends MyMapper<PayChannelDO> {
    long countByExample(PayChannelDOExample example);

    int deleteByExample(PayChannelDOExample example);

    List<PayChannelDO> selectByExample(PayChannelDOExample example);

    int updateByExampleSelective(@Param("record") PayChannelDO record, @Param("example") PayChannelDOExample example);

    int updateByExample(@Param("record") PayChannelDO record, @Param("example") PayChannelDOExample example);
}
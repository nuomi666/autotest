package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantChannelTransLogDO;
import dal.model.merchant.MerchantChannelTransLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantChannelTransLogDAO extends MyMapper<MerchantChannelTransLogDO> {
    long countByExample(MerchantChannelTransLogDOExample example);

    int deleteByExample(MerchantChannelTransLogDOExample example);

    List<MerchantChannelTransLogDO> selectByExample(MerchantChannelTransLogDOExample example);

    int updateByExampleSelective(@Param("record") MerchantChannelTransLogDO record, @Param("example") MerchantChannelTransLogDOExample example);

    int updateByExample(@Param("record") MerchantChannelTransLogDO record, @Param("example") MerchantChannelTransLogDOExample example);
}
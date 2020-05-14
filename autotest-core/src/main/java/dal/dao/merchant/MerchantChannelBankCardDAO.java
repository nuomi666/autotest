package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantChannelBankCardDO;
import dal.model.merchant.MerchantChannelBankCardDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantChannelBankCardDAO extends MyMapper<MerchantChannelBankCardDO> {
    long countByExample(MerchantChannelBankCardDOExample example);

    int deleteByExample(MerchantChannelBankCardDOExample example);

    List<MerchantChannelBankCardDO> selectByExample(MerchantChannelBankCardDOExample example);

    int updateByExampleSelective(@Param("record") MerchantChannelBankCardDO record, @Param("example") MerchantChannelBankCardDOExample example);

    int updateByExample(@Param("record") MerchantChannelBankCardDO record, @Param("example") MerchantChannelBankCardDOExample example);
}
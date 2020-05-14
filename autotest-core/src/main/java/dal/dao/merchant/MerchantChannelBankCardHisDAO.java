package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantChannelBankCardHisDO;
import dal.model.merchant.MerchantChannelBankCardHisDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantChannelBankCardHisDAO extends MyMapper<MerchantChannelBankCardHisDO> {
    long countByExample(MerchantChannelBankCardHisDOExample example);

    int deleteByExample(MerchantChannelBankCardHisDOExample example);

    List<MerchantChannelBankCardHisDO> selectByExample(MerchantChannelBankCardHisDOExample example);

    int updateByExampleSelective(@Param("record") MerchantChannelBankCardHisDO record, @Param("example") MerchantChannelBankCardHisDOExample example);

    int updateByExample(@Param("record") MerchantChannelBankCardHisDO record, @Param("example") MerchantChannelBankCardHisDOExample example);
}
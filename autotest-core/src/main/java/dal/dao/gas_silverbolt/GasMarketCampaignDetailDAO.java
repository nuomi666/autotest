package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasMarketCampaignDetailDO;
import dal.model.gas_silverbolt.GasMarketCampaignDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMarketCampaignDetailDAO extends MyMapper<GasMarketCampaignDetailDO> {
    long countByExample(GasMarketCampaignDetailDOExample example);

    int deleteByExample(GasMarketCampaignDetailDOExample example);

    List<GasMarketCampaignDetailDO> selectByExample(GasMarketCampaignDetailDOExample example);

    int updateByExampleSelective(@Param("record") GasMarketCampaignDetailDO record, @Param("example") GasMarketCampaignDetailDOExample example);

    int updateByExample(@Param("record") GasMarketCampaignDetailDO record, @Param("example") GasMarketCampaignDetailDOExample example);
}
package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.WashLuckDrawCampaignDO;
import dal.model.gas_silverbolt.WashLuckDrawCampaignDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WashLuckDrawCampaignDAO extends MyMapper<WashLuckDrawCampaignDO> {
    long countByExample(WashLuckDrawCampaignDOExample example);

    int deleteByExample(WashLuckDrawCampaignDOExample example);

    List<WashLuckDrawCampaignDO> selectByExample(WashLuckDrawCampaignDOExample example);

    int updateByExampleSelective(@Param("record") WashLuckDrawCampaignDO record, @Param("example") WashLuckDrawCampaignDOExample example);

    int updateByExample(@Param("record") WashLuckDrawCampaignDO record, @Param("example") WashLuckDrawCampaignDOExample example);
}
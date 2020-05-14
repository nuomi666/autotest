package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.LuckDrawCampaignDO;
import dal.model.gas_marketpc.LuckDrawCampaignDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuckDrawCampaignDAO extends MyMapper<LuckDrawCampaignDO> {
    long countByExample(LuckDrawCampaignDOExample example);

    int deleteByExample(LuckDrawCampaignDOExample example);

    List<LuckDrawCampaignDO> selectByExample(LuckDrawCampaignDOExample example);

    int updateByExampleSelective(@Param("record") LuckDrawCampaignDO record, @Param("example") LuckDrawCampaignDOExample example);

    int updateByExample(@Param("record") LuckDrawCampaignDO record, @Param("example") LuckDrawCampaignDOExample example);
}
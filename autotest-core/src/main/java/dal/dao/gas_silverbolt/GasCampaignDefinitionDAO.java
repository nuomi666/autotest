package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasCampaignDefinitionDO;
import dal.model.gas_silverbolt.GasCampaignDefinitionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasCampaignDefinitionDAO extends MyMapper<GasCampaignDefinitionDO> {
    long countByExample(GasCampaignDefinitionDOExample example);

    int deleteByExample(GasCampaignDefinitionDOExample example);

    List<GasCampaignDefinitionDO> selectByExample(GasCampaignDefinitionDOExample example);

    int updateByExampleSelective(@Param("record") GasCampaignDefinitionDO record, @Param("example") GasCampaignDefinitionDOExample example);

    int updateByExample(@Param("record") GasCampaignDefinitionDO record, @Param("example") GasCampaignDefinitionDOExample example);
}
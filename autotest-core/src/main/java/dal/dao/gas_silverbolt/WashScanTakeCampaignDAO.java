package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.WashScanTakeCampaignDO;
import dal.model.gas_silverbolt.WashScanTakeCampaignDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WashScanTakeCampaignDAO extends MyMapper<WashScanTakeCampaignDO> {
    long countByExample(WashScanTakeCampaignDOExample example);

    int deleteByExample(WashScanTakeCampaignDOExample example);

    List<WashScanTakeCampaignDO> selectByExampleWithBLOBs(WashScanTakeCampaignDOExample example);

    List<WashScanTakeCampaignDO> selectByExample(WashScanTakeCampaignDOExample example);

    int updateByExampleSelective(@Param("record") WashScanTakeCampaignDO record, @Param("example") WashScanTakeCampaignDOExample example);

    int updateByExampleWithBLOBs(@Param("record") WashScanTakeCampaignDO record, @Param("example") WashScanTakeCampaignDOExample example);

    int updateByExample(@Param("record") WashScanTakeCampaignDO record, @Param("example") WashScanTakeCampaignDOExample example);
}
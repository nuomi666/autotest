package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.WashSalesCampaignDO;
import dal.model.gas_silverbolt.WashSalesCampaignDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WashSalesCampaignDAO extends MyMapper<WashSalesCampaignDO> {
    long countByExample(WashSalesCampaignDOExample example);

    int deleteByExample(WashSalesCampaignDOExample example);

    List<WashSalesCampaignDO> selectByExampleWithBLOBs(WashSalesCampaignDOExample example);

    List<WashSalesCampaignDO> selectByExample(WashSalesCampaignDOExample example);

    int updateByExampleSelective(@Param("record") WashSalesCampaignDO record, @Param("example") WashSalesCampaignDOExample example);

    int updateByExampleWithBLOBs(@Param("record") WashSalesCampaignDO record, @Param("example") WashSalesCampaignDOExample example);

    int updateByExample(@Param("record") WashSalesCampaignDO record, @Param("example") WashSalesCampaignDOExample example);
}
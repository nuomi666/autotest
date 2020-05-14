package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.SalesCampaignDO;
import dal.model.gas_marketpc.SalesCampaignDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesCampaignDAO extends MyMapper<SalesCampaignDO> {
    long countByExample(SalesCampaignDOExample example);

    int deleteByExample(SalesCampaignDOExample example);

    List<SalesCampaignDO> selectByExampleWithBLOBs(SalesCampaignDOExample example);

    List<SalesCampaignDO> selectByExample(SalesCampaignDOExample example);

    int updateByExampleSelective(@Param("record") SalesCampaignDO record, @Param("example") SalesCampaignDOExample example);

    int updateByExampleWithBLOBs(@Param("record") SalesCampaignDO record, @Param("example") SalesCampaignDOExample example);

    int updateByExample(@Param("record") SalesCampaignDO record, @Param("example") SalesCampaignDOExample example);
}
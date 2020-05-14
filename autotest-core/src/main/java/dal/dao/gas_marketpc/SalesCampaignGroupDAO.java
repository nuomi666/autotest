package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.SalesCampaignGroupDO;
import dal.model.gas_marketpc.SalesCampaignGroupDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesCampaignGroupDAO extends MyMapper<SalesCampaignGroupDO> {
    long countByExample(SalesCampaignGroupDOExample example);

    int deleteByExample(SalesCampaignGroupDOExample example);

    List<SalesCampaignGroupDO> selectByExample(SalesCampaignGroupDOExample example);

    int updateByExampleSelective(@Param("record") SalesCampaignGroupDO record, @Param("example") SalesCampaignGroupDOExample example);

    int updateByExample(@Param("record") SalesCampaignGroupDO record, @Param("example") SalesCampaignGroupDOExample example);
}
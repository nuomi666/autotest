package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.CampaignTemplatePartnerListDO;
import dal.model.gas_marketpc.CampaignTemplatePartnerListDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampaignTemplatePartnerListDAO extends MyMapper<CampaignTemplatePartnerListDO> {
    long countByExample(CampaignTemplatePartnerListDOExample example);

    int deleteByExample(CampaignTemplatePartnerListDOExample example);

    List<CampaignTemplatePartnerListDO> selectByExample(CampaignTemplatePartnerListDOExample example);

    int updateByExampleSelective(@Param("record") CampaignTemplatePartnerListDO record, @Param("example") CampaignTemplatePartnerListDOExample example);

    int updateByExample(@Param("record") CampaignTemplatePartnerListDO record, @Param("example") CampaignTemplatePartnerListDOExample example);
}
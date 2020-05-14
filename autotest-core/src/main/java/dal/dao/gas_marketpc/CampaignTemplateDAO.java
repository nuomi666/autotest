package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.CampaignTemplateDO;
import dal.model.gas_marketpc.CampaignTemplateDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampaignTemplateDAO extends MyMapper<CampaignTemplateDO> {
    long countByExample(CampaignTemplateDOExample example);

    int deleteByExample(CampaignTemplateDOExample example);

    List<CampaignTemplateDO> selectByExampleWithBLOBs(CampaignTemplateDOExample example);

    List<CampaignTemplateDO> selectByExample(CampaignTemplateDOExample example);

    int updateByExampleSelective(@Param("record") CampaignTemplateDO record, @Param("example") CampaignTemplateDOExample example);

    int updateByExampleWithBLOBs(@Param("record") CampaignTemplateDO record, @Param("example") CampaignTemplateDOExample example);

    int updateByExample(@Param("record") CampaignTemplateDO record, @Param("example") CampaignTemplateDOExample example);
}
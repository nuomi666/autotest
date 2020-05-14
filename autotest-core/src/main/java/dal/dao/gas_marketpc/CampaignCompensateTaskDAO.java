package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.CampaignCompensateTaskDO;
import dal.model.gas_marketpc.CampaignCompensateTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampaignCompensateTaskDAO extends MyMapper<CampaignCompensateTaskDO> {
    long countByExample(CampaignCompensateTaskDOExample example);

    int deleteByExample(CampaignCompensateTaskDOExample example);

    List<CampaignCompensateTaskDO> selectByExample(CampaignCompensateTaskDOExample example);

    int updateByExampleSelective(@Param("record") CampaignCompensateTaskDO record, @Param("example") CampaignCompensateTaskDOExample example);

    int updateByExample(@Param("record") CampaignCompensateTaskDO record, @Param("example") CampaignCompensateTaskDOExample example);
}
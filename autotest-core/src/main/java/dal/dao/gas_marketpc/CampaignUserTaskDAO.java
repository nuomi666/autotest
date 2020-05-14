package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.CampaignUserTaskDO;
import dal.model.gas_marketpc.CampaignUserTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampaignUserTaskDAO extends MyMapper<CampaignUserTaskDO> {
    long countByExample(CampaignUserTaskDOExample example);

    int deleteByExample(CampaignUserTaskDOExample example);

    List<CampaignUserTaskDO> selectByExampleWithBLOBs(CampaignUserTaskDOExample example);

    List<CampaignUserTaskDO> selectByExample(CampaignUserTaskDOExample example);

    int updateByExampleSelective(@Param("record") CampaignUserTaskDO record, @Param("example") CampaignUserTaskDOExample example);

    int updateByExampleWithBLOBs(@Param("record") CampaignUserTaskDO record, @Param("example") CampaignUserTaskDOExample example);

    int updateByExample(@Param("record") CampaignUserTaskDO record, @Param("example") CampaignUserTaskDOExample example);
}
package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.CampaignUserTaskRetryDO;
import dal.model.gas_marketpc.CampaignUserTaskRetryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampaignUserTaskRetryDAO extends MyMapper<CampaignUserTaskRetryDO> {
    long countByExample(CampaignUserTaskRetryDOExample example);

    int deleteByExample(CampaignUserTaskRetryDOExample example);

    List<CampaignUserTaskRetryDO> selectByExampleWithBLOBs(CampaignUserTaskRetryDOExample example);

    List<CampaignUserTaskRetryDO> selectByExample(CampaignUserTaskRetryDOExample example);

    int updateByExampleSelective(@Param("record") CampaignUserTaskRetryDO record, @Param("example") CampaignUserTaskRetryDOExample example);

    int updateByExampleWithBLOBs(@Param("record") CampaignUserTaskRetryDO record, @Param("example") CampaignUserTaskRetryDOExample example);

    int updateByExample(@Param("record") CampaignUserTaskRetryDO record, @Param("example") CampaignUserTaskRetryDOExample example);
}
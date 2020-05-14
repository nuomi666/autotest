package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.CampaignBirthdayTaskDO;
import dal.model.gas_marketpc.CampaignBirthdayTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampaignBirthdayTaskDAO extends MyMapper<CampaignBirthdayTaskDO> {
    long countByExample(CampaignBirthdayTaskDOExample example);

    int deleteByExample(CampaignBirthdayTaskDOExample example);

    List<CampaignBirthdayTaskDO> selectByExample(CampaignBirthdayTaskDOExample example);

    int updateByExampleSelective(@Param("record") CampaignBirthdayTaskDO record, @Param("example") CampaignBirthdayTaskDOExample example);

    int updateByExample(@Param("record") CampaignBirthdayTaskDO record, @Param("example") CampaignBirthdayTaskDOExample example);
}
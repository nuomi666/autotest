package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.CampaignUserPartakeRecordDO;
import dal.model.gas_marketpc.CampaignUserPartakeRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampaignUserPartakeRecordDAO extends MyMapper<CampaignUserPartakeRecordDO> {
    long countByExample(CampaignUserPartakeRecordDOExample example);

    int deleteByExample(CampaignUserPartakeRecordDOExample example);

    List<CampaignUserPartakeRecordDO> selectByExampleWithBLOBs(CampaignUserPartakeRecordDOExample example);

    List<CampaignUserPartakeRecordDO> selectByExample(CampaignUserPartakeRecordDOExample example);

    int updateByExampleSelective(@Param("record") CampaignUserPartakeRecordDO record, @Param("example") CampaignUserPartakeRecordDOExample example);

    int updateByExampleWithBLOBs(@Param("record") CampaignUserPartakeRecordDO record, @Param("example") CampaignUserPartakeRecordDOExample example);

    int updateByExample(@Param("record") CampaignUserPartakeRecordDO record, @Param("example") CampaignUserPartakeRecordDOExample example);
}
package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.ActivityZoneConfigDO;
import dal.model.shellmerchant.ActivityZoneConfigDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityZoneConfigDAO extends MyMapper<ActivityZoneConfigDO> {
    long countByExample(ActivityZoneConfigDOExample example);

    int deleteByExample(ActivityZoneConfigDOExample example);

    List<ActivityZoneConfigDO> selectByExample(ActivityZoneConfigDOExample example);

    int updateByExampleSelective(@Param("record") ActivityZoneConfigDO record, @Param("example") ActivityZoneConfigDOExample example);

    int updateByExample(@Param("record") ActivityZoneConfigDO record, @Param("example") ActivityZoneConfigDOExample example);
}
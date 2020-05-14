package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasDeviceResourceDO;
import dal.model.shellmerchant.GasDeviceResourceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDeviceResourceDAO extends MyMapper<GasDeviceResourceDO> {
    long countByExample(GasDeviceResourceDOExample example);

    int deleteByExample(GasDeviceResourceDOExample example);

    List<GasDeviceResourceDO> selectByExample(GasDeviceResourceDOExample example);

    int updateByExampleSelective(@Param("record") GasDeviceResourceDO record, @Param("example") GasDeviceResourceDOExample example);

    int updateByExample(@Param("record") GasDeviceResourceDO record, @Param("example") GasDeviceResourceDOExample example);
}
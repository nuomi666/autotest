package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasDeviceResourceDO;
import dal.model.gas_merchant.GasDeviceResourceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDeviceResourceDAO extends MyMapper<GasDeviceResourceDO> {
    long countByExample(GasDeviceResourceDOExample example);

    int deleteByExample(GasDeviceResourceDOExample example);

    List<GasDeviceResourceDO> selectByExample(GasDeviceResourceDOExample example);

    int updateByExampleSelective(@Param("record") GasDeviceResourceDO record, @Param("example") GasDeviceResourceDOExample example);

    int updateByExample(@Param("record") GasDeviceResourceDO record, @Param("example") GasDeviceResourceDOExample example);
}
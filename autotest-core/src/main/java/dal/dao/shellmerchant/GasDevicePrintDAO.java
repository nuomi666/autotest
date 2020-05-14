package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasDevicePrintDO;
import dal.model.shellmerchant.GasDevicePrintDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDevicePrintDAO extends MyMapper<GasDevicePrintDO> {
    long countByExample(GasDevicePrintDOExample example);

    int deleteByExample(GasDevicePrintDOExample example);

    List<GasDevicePrintDO> selectByExample(GasDevicePrintDOExample example);

    int updateByExampleSelective(@Param("record") GasDevicePrintDO record, @Param("example") GasDevicePrintDOExample example);

    int updateByExample(@Param("record") GasDevicePrintDO record, @Param("example") GasDevicePrintDOExample example);
}
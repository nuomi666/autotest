package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasStationServiceTagDO;
import dal.model.shellmerchant.GasStationServiceTagDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasStationServiceTagDAO extends MyMapper<GasStationServiceTagDO> {
    long countByExample(GasStationServiceTagDOExample example);

    int deleteByExample(GasStationServiceTagDOExample example);

    List<GasStationServiceTagDO> selectByExample(GasStationServiceTagDOExample example);

    int updateByExampleSelective(@Param("record") GasStationServiceTagDO record, @Param("example") GasStationServiceTagDOExample example);

    int updateByExample(@Param("record") GasStationServiceTagDO record, @Param("example") GasStationServiceTagDOExample example);
}
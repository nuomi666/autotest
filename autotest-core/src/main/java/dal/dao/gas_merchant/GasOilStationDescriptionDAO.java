package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasOilStationDescriptionDO;
import dal.model.gas_merchant.GasOilStationDescriptionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasOilStationDescriptionDAO extends MyMapper<GasOilStationDescriptionDO> {
    long countByExample(GasOilStationDescriptionDOExample example);

    int deleteByExample(GasOilStationDescriptionDOExample example);

    List<GasOilStationDescriptionDO> selectByExampleWithBLOBs(GasOilStationDescriptionDOExample example);

    List<GasOilStationDescriptionDO> selectByExample(GasOilStationDescriptionDOExample example);

    int updateByExampleSelective(@Param("record") GasOilStationDescriptionDO record, @Param("example") GasOilStationDescriptionDOExample example);

    int updateByExampleWithBLOBs(@Param("record") GasOilStationDescriptionDO record, @Param("example") GasOilStationDescriptionDOExample example);

    int updateByExample(@Param("record") GasOilStationDescriptionDO record, @Param("example") GasOilStationDescriptionDOExample example);
}
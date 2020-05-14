package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasStationOilGunBakDO;
import dal.model.gas_merchant.GasStationOilGunBakDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasStationOilGunBakDAO extends MyMapper<GasStationOilGunBakDO> {
    long countByExample(GasStationOilGunBakDOExample example);

    int deleteByExample(GasStationOilGunBakDOExample example);

    List<GasStationOilGunBakDO> selectByExample(GasStationOilGunBakDOExample example);

    int updateByExampleSelective(@Param("record") GasStationOilGunBakDO record, @Param("example") GasStationOilGunBakDOExample example);

    int updateByExample(@Param("record") GasStationOilGunBakDO record, @Param("example") GasStationOilGunBakDOExample example);
}
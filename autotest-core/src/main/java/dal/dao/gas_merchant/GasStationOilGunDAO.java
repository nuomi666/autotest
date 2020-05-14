package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasStationOilGunDO;
import dal.model.gas_merchant.GasStationOilGunDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasStationOilGunDAO extends MyMapper<GasStationOilGunDO> {
    long countByExample(GasStationOilGunDOExample example);

    int deleteByExample(GasStationOilGunDOExample example);

    List<GasStationOilGunDO> selectByExample(GasStationOilGunDOExample example);

    int updateByExampleSelective(@Param("record") GasStationOilGunDO record, @Param("example") GasStationOilGunDOExample example);

    int updateByExample(@Param("record") GasStationOilGunDO record, @Param("example") GasStationOilGunDOExample example);
}
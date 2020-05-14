package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasStationGoodsDO;
import dal.model.gas_merchant.GasStationGoodsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasStationGoodsDAO extends MyMapper<GasStationGoodsDO> {
    long countByExample(GasStationGoodsDOExample example);

    int deleteByExample(GasStationGoodsDOExample example);

    List<GasStationGoodsDO> selectByExample(GasStationGoodsDOExample example);

    int updateByExampleSelective(@Param("record") GasStationGoodsDO record, @Param("example") GasStationGoodsDOExample example);

    int updateByExample(@Param("record") GasStationGoodsDO record, @Param("example") GasStationGoodsDOExample example);
}
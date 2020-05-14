package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasStationGoodsPricePlanDO;
import dal.model.shellmerchant.GasStationGoodsPricePlanDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasStationGoodsPricePlanDAO extends MyMapper<GasStationGoodsPricePlanDO> {
    long countByExample(GasStationGoodsPricePlanDOExample example);

    int deleteByExample(GasStationGoodsPricePlanDOExample example);

    List<GasStationGoodsPricePlanDO> selectByExampleWithBLOBs(GasStationGoodsPricePlanDOExample example);

    List<GasStationGoodsPricePlanDO> selectByExample(GasStationGoodsPricePlanDOExample example);

    int updateByExampleSelective(@Param("record") GasStationGoodsPricePlanDO record, @Param("example") GasStationGoodsPricePlanDOExample example);

    int updateByExampleWithBLOBs(@Param("record") GasStationGoodsPricePlanDO record, @Param("example") GasStationGoodsPricePlanDOExample example);

    int updateByExample(@Param("record") GasStationGoodsPricePlanDO record, @Param("example") GasStationGoodsPricePlanDOExample example);
}
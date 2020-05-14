package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.BaseStationDO;
import dal.model.gas_merchant.BaseStationDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseStationDAO extends MyMapper<BaseStationDO> {
    long countByExample(BaseStationDOExample example);

    int deleteByExample(BaseStationDOExample example);

    List<BaseStationDO> selectByExample(BaseStationDOExample example);

    int updateByExampleSelective(@Param("record") BaseStationDO record, @Param("example") BaseStationDOExample example);

    int updateByExample(@Param("record") BaseStationDO record, @Param("example") BaseStationDOExample example);
}
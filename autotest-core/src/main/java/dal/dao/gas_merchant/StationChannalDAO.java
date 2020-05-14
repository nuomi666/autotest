package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.StationChannalDO;
import dal.model.gas_merchant.StationChannalDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StationChannalDAO extends MyMapper<StationChannalDO> {
    long countByExample(StationChannalDOExample example);

    int deleteByExample(StationChannalDOExample example);

    List<StationChannalDO> selectByExample(StationChannalDOExample example);

    int updateByExampleSelective(@Param("record") StationChannalDO record, @Param("example") StationChannalDOExample example);

    int updateByExample(@Param("record") StationChannalDO record, @Param("example") StationChannalDOExample example);
}
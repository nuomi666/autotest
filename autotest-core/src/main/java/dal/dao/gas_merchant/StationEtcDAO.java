package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.StationEtcDO;
import dal.model.gas_merchant.StationEtcDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StationEtcDAO extends MyMapper<StationEtcDO> {
    long countByExample(StationEtcDOExample example);

    int deleteByExample(StationEtcDOExample example);

    List<StationEtcDO> selectByExample(StationEtcDOExample example);

    int updateByExampleSelective(@Param("record") StationEtcDO record, @Param("example") StationEtcDOExample example);

    int updateByExample(@Param("record") StationEtcDO record, @Param("example") StationEtcDOExample example);
}
package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasDistrictDO;
import dal.model.shellmerchant.GasDistrictDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDistrictDAO extends MyMapper<GasDistrictDO> {
    long countByExample(GasDistrictDOExample example);

    int deleteByExample(GasDistrictDOExample example);

    List<GasDistrictDO> selectByExample(GasDistrictDOExample example);

    int updateByExampleSelective(@Param("record") GasDistrictDO record, @Param("example") GasDistrictDOExample example);

    int updateByExample(@Param("record") GasDistrictDO record, @Param("example") GasDistrictDOExample example);
}
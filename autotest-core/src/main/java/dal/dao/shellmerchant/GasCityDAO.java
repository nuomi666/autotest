package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasCityDO;
import dal.model.shellmerchant.GasCityDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasCityDAO extends MyMapper<GasCityDO> {
    long countByExample(GasCityDOExample example);

    int deleteByExample(GasCityDOExample example);

    List<GasCityDO> selectByExample(GasCityDOExample example);

    int updateByExampleSelective(@Param("record") GasCityDO record, @Param("example") GasCityDOExample example);

    int updateByExample(@Param("record") GasCityDO record, @Param("example") GasCityDOExample example);
}
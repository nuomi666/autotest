package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasTradeFavourDO;
import dal.model.gas_silverbolt.GasTradeFavourDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTradeFavourDAO extends MyMapper<GasTradeFavourDO> {
    long countByExample(GasTradeFavourDOExample example);

    int deleteByExample(GasTradeFavourDOExample example);

    List<GasTradeFavourDO> selectByExample(GasTradeFavourDOExample example);

    int updateByExampleSelective(@Param("record") GasTradeFavourDO record, @Param("example") GasTradeFavourDOExample example);

    int updateByExample(@Param("record") GasTradeFavourDO record, @Param("example") GasTradeFavourDOExample example);
}
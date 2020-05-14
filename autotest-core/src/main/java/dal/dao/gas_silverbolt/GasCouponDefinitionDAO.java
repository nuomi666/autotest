package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasCouponDefinitionDO;
import dal.model.gas_silverbolt.GasCouponDefinitionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasCouponDefinitionDAO extends MyMapper<GasCouponDefinitionDO> {
    long countByExample(GasCouponDefinitionDOExample example);

    int deleteByExample(GasCouponDefinitionDOExample example);

    List<GasCouponDefinitionDO> selectByExample(GasCouponDefinitionDOExample example);

    int updateByExampleSelective(@Param("record") GasCouponDefinitionDO record, @Param("example") GasCouponDefinitionDOExample example);

    int updateByExample(@Param("record") GasCouponDefinitionDO record, @Param("example") GasCouponDefinitionDOExample example);
}
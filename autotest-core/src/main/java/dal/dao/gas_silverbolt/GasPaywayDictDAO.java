package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasPaywayDictDO;
import dal.model.gas_silverbolt.GasPaywayDictDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasPaywayDictDAO extends MyMapper<GasPaywayDictDO> {
    long countByExample(GasPaywayDictDOExample example);

    int deleteByExample(GasPaywayDictDOExample example);

    List<GasPaywayDictDO> selectByExample(GasPaywayDictDOExample example);

    int updateByExampleSelective(@Param("record") GasPaywayDictDO record, @Param("example") GasPaywayDictDOExample example);

    int updateByExample(@Param("record") GasPaywayDictDO record, @Param("example") GasPaywayDictDOExample example);
}
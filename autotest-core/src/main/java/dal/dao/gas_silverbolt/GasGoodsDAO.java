package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasGoodsDO;
import dal.model.gas_silverbolt.GasGoodsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasGoodsDAO extends MyMapper<GasGoodsDO> {
    long countByExample(GasGoodsDOExample example);

    int deleteByExample(GasGoodsDOExample example);

    List<GasGoodsDO> selectByExample(GasGoodsDOExample example);

    int updateByExampleSelective(@Param("record") GasGoodsDO record, @Param("example") GasGoodsDOExample example);

    int updateByExample(@Param("record") GasGoodsDO record, @Param("example") GasGoodsDOExample example);
}
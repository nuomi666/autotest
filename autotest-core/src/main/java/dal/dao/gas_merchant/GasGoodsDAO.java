package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasGoodsDO;
import dal.model.gas_merchant.GasGoodsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasGoodsDAO extends MyMapper<GasGoodsDO> {
    long countByExample(GasGoodsDOExample example);

    int deleteByExample(GasGoodsDOExample example);

    List<GasGoodsDO> selectByExample(GasGoodsDOExample example);

    int updateByExampleSelective(@Param("record") GasGoodsDO record, @Param("example") GasGoodsDOExample example);

    int updateByExample(@Param("record") GasGoodsDO record, @Param("example") GasGoodsDOExample example);
}
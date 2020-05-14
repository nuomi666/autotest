package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMallExchangeGoodsDO;
import dal.model.shellmerchant.GasMallExchangeGoodsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMallExchangeGoodsDAO extends MyMapper<GasMallExchangeGoodsDO> {
    long countByExample(GasMallExchangeGoodsDOExample example);

    int deleteByExample(GasMallExchangeGoodsDOExample example);

    List<GasMallExchangeGoodsDO> selectByExample(GasMallExchangeGoodsDOExample example);

    int updateByExampleSelective(@Param("record") GasMallExchangeGoodsDO record, @Param("example") GasMallExchangeGoodsDOExample example);

    int updateByExample(@Param("record") GasMallExchangeGoodsDO record, @Param("example") GasMallExchangeGoodsDOExample example);
}
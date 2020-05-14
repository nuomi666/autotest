package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.BaseTradeDO;
import dal.model.gas_merchant.BaseTradeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseTradeDAO extends MyMapper<BaseTradeDO> {
    long countByExample(BaseTradeDOExample example);

    int deleteByExample(BaseTradeDOExample example);

    List<BaseTradeDO> selectByExample(BaseTradeDOExample example);

    int updateByExampleSelective(@Param("record") BaseTradeDO record, @Param("example") BaseTradeDOExample example);

    int updateByExample(@Param("record") BaseTradeDO record, @Param("example") BaseTradeDOExample example);
}
package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.BaseTradeBkDO;
import dal.model.gas_merchant.BaseTradeBkDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseTradeBkDAO extends MyMapper<BaseTradeBkDO> {
    long countByExample(BaseTradeBkDOExample example);

    int deleteByExample(BaseTradeBkDOExample example);

    List<BaseTradeBkDO> selectByExample(BaseTradeBkDOExample example);

    int updateByExampleSelective(@Param("record") BaseTradeBkDO record, @Param("example") BaseTradeBkDOExample example);

    int updateByExample(@Param("record") BaseTradeBkDO record, @Param("example") BaseTradeBkDOExample example);
}
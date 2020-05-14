package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.TOrderDO;
import dal.model.gas_merchant.TOrderDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderDAO extends MyMapper<TOrderDO> {
    long countByExample(TOrderDOExample example);

    int deleteByExample(TOrderDOExample example);

    List<TOrderDO> selectByExample(TOrderDOExample example);

    int updateByExampleSelective(@Param("record") TOrderDO record, @Param("example") TOrderDOExample example);

    int updateByExample(@Param("record") TOrderDO record, @Param("example") TOrderDOExample example);
}
package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.TOrderItemDO;
import dal.model.gas_merchant.TOrderItemDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderItemDAO extends MyMapper<TOrderItemDO> {
    long countByExample(TOrderItemDOExample example);

    int deleteByExample(TOrderItemDOExample example);

    List<TOrderItemDO> selectByExample(TOrderItemDOExample example);

    int updateByExampleSelective(@Param("record") TOrderItemDO record, @Param("example") TOrderItemDOExample example);

    int updateByExample(@Param("record") TOrderItemDO record, @Param("example") TOrderItemDOExample example);
}
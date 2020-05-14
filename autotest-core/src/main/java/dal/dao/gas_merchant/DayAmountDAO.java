package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.DayAmountDO;
import dal.model.gas_merchant.DayAmountDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DayAmountDAO extends MyMapper<DayAmountDO> {
    long countByExample(DayAmountDOExample example);

    int deleteByExample(DayAmountDOExample example);

    List<DayAmountDO> selectByExample(DayAmountDOExample example);

    int updateByExampleSelective(@Param("record") DayAmountDO record, @Param("example") DayAmountDOExample example);

    int updateByExample(@Param("record") DayAmountDO record, @Param("example") DayAmountDOExample example);
}
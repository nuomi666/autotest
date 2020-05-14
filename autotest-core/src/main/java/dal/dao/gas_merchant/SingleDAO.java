package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.SingleDO;
import dal.model.gas_merchant.SingleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SingleDAO extends MyMapper<SingleDO> {
    long countByExample(SingleDOExample example);

    int deleteByExample(SingleDOExample example);

    List<SingleDO> selectByExample(SingleDOExample example);

    int updateByExampleSelective(@Param("record") SingleDO record, @Param("example") SingleDOExample example);

    int updateByExample(@Param("record") SingleDO record, @Param("example") SingleDOExample example);
}
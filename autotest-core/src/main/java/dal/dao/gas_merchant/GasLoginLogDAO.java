package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasLoginLogDO;
import dal.model.gas_merchant.GasLoginLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasLoginLogDAO extends MyMapper<GasLoginLogDO> {
    long countByExample(GasLoginLogDOExample example);

    int deleteByExample(GasLoginLogDOExample example);

    List<GasLoginLogDO> selectByExample(GasLoginLogDOExample example);

    int updateByExampleSelective(@Param("record") GasLoginLogDO record, @Param("example") GasLoginLogDOExample example);

    int updateByExample(@Param("record") GasLoginLogDO record, @Param("example") GasLoginLogDOExample example);
}
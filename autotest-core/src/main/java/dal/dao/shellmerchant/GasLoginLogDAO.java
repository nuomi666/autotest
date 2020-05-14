package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasLoginLogDO;
import dal.model.shellmerchant.GasLoginLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasLoginLogDAO extends MyMapper<GasLoginLogDO> {
    long countByExample(GasLoginLogDOExample example);

    int deleteByExample(GasLoginLogDOExample example);

    List<GasLoginLogDO> selectByExample(GasLoginLogDOExample example);

    int updateByExampleSelective(@Param("record") GasLoginLogDO record, @Param("example") GasLoginLogDOExample example);

    int updateByExample(@Param("record") GasLoginLogDO record, @Param("example") GasLoginLogDOExample example);
}
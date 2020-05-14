package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.LuckDrawAccountDO;
import dal.model.gas_marketpc.LuckDrawAccountDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuckDrawAccountDAO extends MyMapper<LuckDrawAccountDO> {
    long countByExample(LuckDrawAccountDOExample example);

    int deleteByExample(LuckDrawAccountDOExample example);

    List<LuckDrawAccountDO> selectByExample(LuckDrawAccountDOExample example);

    int updateByExampleSelective(@Param("record") LuckDrawAccountDO record, @Param("example") LuckDrawAccountDOExample example);

    int updateByExample(@Param("record") LuckDrawAccountDO record, @Param("example") LuckDrawAccountDOExample example);
}
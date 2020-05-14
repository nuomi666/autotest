package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.GiveLuckDrawDetailDO;
import dal.model.gas_marketpc.GiveLuckDrawDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiveLuckDrawDetailDAO extends MyMapper<GiveLuckDrawDetailDO> {
    long countByExample(GiveLuckDrawDetailDOExample example);

    int deleteByExample(GiveLuckDrawDetailDOExample example);

    List<GiveLuckDrawDetailDO> selectByExample(GiveLuckDrawDetailDOExample example);

    int updateByExampleSelective(@Param("record") GiveLuckDrawDetailDO record, @Param("example") GiveLuckDrawDetailDOExample example);

    int updateByExample(@Param("record") GiveLuckDrawDetailDO record, @Param("example") GiveLuckDrawDetailDOExample example);
}
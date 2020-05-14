package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.GiveMoneyDetailDO;
import dal.model.gas_marketpc.GiveMoneyDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiveMoneyDetailDAO extends MyMapper<GiveMoneyDetailDO> {
    long countByExample(GiveMoneyDetailDOExample example);

    int deleteByExample(GiveMoneyDetailDOExample example);

    List<GiveMoneyDetailDO> selectByExample(GiveMoneyDetailDOExample example);

    int updateByExampleSelective(@Param("record") GiveMoneyDetailDO record, @Param("example") GiveMoneyDetailDOExample example);

    int updateByExample(@Param("record") GiveMoneyDetailDO record, @Param("example") GiveMoneyDetailDOExample example);
}
package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.LuckDrawPrizeDO;
import dal.model.gas_marketpc.LuckDrawPrizeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuckDrawPrizeDAO extends MyMapper<LuckDrawPrizeDO> {
    long countByExample(LuckDrawPrizeDOExample example);

    int deleteByExample(LuckDrawPrizeDOExample example);

    List<LuckDrawPrizeDO> selectByExample(LuckDrawPrizeDOExample example);

    int updateByExampleSelective(@Param("record") LuckDrawPrizeDO record, @Param("example") LuckDrawPrizeDOExample example);

    int updateByExample(@Param("record") LuckDrawPrizeDO record, @Param("example") LuckDrawPrizeDOExample example);
}
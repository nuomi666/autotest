package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.ReissueGiveDO;
import dal.model.gas_marketpc.ReissueGiveDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReissueGiveDAO extends MyMapper<ReissueGiveDO> {
    long countByExample(ReissueGiveDOExample example);

    int deleteByExample(ReissueGiveDOExample example);

    List<ReissueGiveDO> selectByExample(ReissueGiveDOExample example);

    int updateByExampleSelective(@Param("record") ReissueGiveDO record, @Param("example") ReissueGiveDOExample example);

    int updateByExample(@Param("record") ReissueGiveDO record, @Param("example") ReissueGiveDOExample example);
}
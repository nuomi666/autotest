package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.RefundInstructionDO;
import dal.model.pay.RefundInstructionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundInstructionDAO extends MyMapper<RefundInstructionDO> {
    long countByExample(RefundInstructionDOExample example);

    int deleteByExample(RefundInstructionDOExample example);

    List<RefundInstructionDO> selectByExample(RefundInstructionDOExample example);

    int updateByExampleSelective(@Param("record") RefundInstructionDO record, @Param("example") RefundInstructionDOExample example);

    int updateByExample(@Param("record") RefundInstructionDO record, @Param("example") RefundInstructionDOExample example);
}
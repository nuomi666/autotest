package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.DepositInstructionDO;
import dal.model.pay.DepositInstructionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepositInstructionDAO extends MyMapper<DepositInstructionDO> {
    long countByExample(DepositInstructionDOExample example);

    int deleteByExample(DepositInstructionDOExample example);

    List<DepositInstructionDO> selectByExample(DepositInstructionDOExample example);

    int updateByExampleSelective(@Param("record") DepositInstructionDO record, @Param("example") DepositInstructionDOExample example);

    int updateByExample(@Param("record") DepositInstructionDO record, @Param("example") DepositInstructionDOExample example);
}
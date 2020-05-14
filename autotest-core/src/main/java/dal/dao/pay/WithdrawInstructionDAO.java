package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.WithdrawInstructionDO;
import dal.model.pay.WithdrawInstructionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithdrawInstructionDAO extends MyMapper<WithdrawInstructionDO> {
    long countByExample(WithdrawInstructionDOExample example);

    int deleteByExample(WithdrawInstructionDOExample example);

    List<WithdrawInstructionDO> selectByExample(WithdrawInstructionDOExample example);

    int updateByExampleSelective(@Param("record") WithdrawInstructionDO record, @Param("example") WithdrawInstructionDOExample example);

    int updateByExample(@Param("record") WithdrawInstructionDO record, @Param("example") WithdrawInstructionDOExample example);
}
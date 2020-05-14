package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.TransferInstructionDO;
import dal.model.pay.TransferInstructionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransferInstructionDAO extends MyMapper<TransferInstructionDO> {
    long countByExample(TransferInstructionDOExample example);

    int deleteByExample(TransferInstructionDOExample example);

    List<TransferInstructionDO> selectByExample(TransferInstructionDOExample example);

    int updateByExampleSelective(@Param("record") TransferInstructionDO record, @Param("example") TransferInstructionDOExample example);

    int updateByExample(@Param("record") TransferInstructionDO record, @Param("example") TransferInstructionDOExample example);
}
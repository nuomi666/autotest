package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.PaymentInstructionDO;
import dal.model.pay.PaymentInstructionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentInstructionDAO extends MyMapper<PaymentInstructionDO> {
    long countByExample(PaymentInstructionDOExample example);

    int deleteByExample(PaymentInstructionDOExample example);

    List<PaymentInstructionDO> selectByExample(PaymentInstructionDOExample example);

    int updateByExampleSelective(@Param("record") PaymentInstructionDO record, @Param("example") PaymentInstructionDOExample example);

    int updateByExample(@Param("record") PaymentInstructionDO record, @Param("example") PaymentInstructionDOExample example);
}
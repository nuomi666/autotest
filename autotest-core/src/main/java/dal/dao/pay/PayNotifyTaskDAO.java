package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.PayNotifyTaskDO;
import dal.model.pay.PayNotifyTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayNotifyTaskDAO extends MyMapper<PayNotifyTaskDO> {
    long countByExample(PayNotifyTaskDOExample example);

    int deleteByExample(PayNotifyTaskDOExample example);

    List<PayNotifyTaskDO> selectByExample(PayNotifyTaskDOExample example);

    int updateByExampleSelective(@Param("record") PayNotifyTaskDO record, @Param("example") PayNotifyTaskDOExample example);

    int updateByExample(@Param("record") PayNotifyTaskDO record, @Param("example") PayNotifyTaskDOExample example);
}
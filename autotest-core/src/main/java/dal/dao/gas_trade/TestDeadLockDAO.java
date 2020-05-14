package dal.dao.gas_trade;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_trade.TestDeadLockDO;
import dal.model.gas_trade.TestDeadLockDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestDeadLockDAO extends MyMapper<TestDeadLockDO> {
    long countByExample(TestDeadLockDOExample example);

    int deleteByExample(TestDeadLockDOExample example);

    List<TestDeadLockDO> selectByExample(TestDeadLockDOExample example);

    int updateByExampleSelective(@Param("record") TestDeadLockDO record, @Param("example") TestDeadLockDOExample example);

    int updateByExample(@Param("record") TestDeadLockDO record, @Param("example") TestDeadLockDOExample example);
}
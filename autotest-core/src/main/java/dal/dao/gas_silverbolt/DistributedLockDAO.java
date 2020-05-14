package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.DistributedLockDO;
import dal.model.gas_silverbolt.DistributedLockDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistributedLockDAO extends MyMapper<DistributedLockDO> {
    long countByExample(DistributedLockDOExample example);

    int deleteByExample(DistributedLockDOExample example);

    List<DistributedLockDO> selectByExample(DistributedLockDOExample example);

    int updateByExampleSelective(@Param("record") DistributedLockDO record, @Param("example") DistributedLockDOExample example);

    int updateByExample(@Param("record") DistributedLockDO record, @Param("example") DistributedLockDOExample example);
}
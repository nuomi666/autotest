package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.BatchJobSeqDO;
import dal.model.pay.BatchJobSeqDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchJobSeqDAO extends MyMapper<BatchJobSeqDO> {
    long countByExample(BatchJobSeqDOExample example);

    int deleteByExample(BatchJobSeqDOExample example);

    List<BatchJobSeqDO> selectByExample(BatchJobSeqDOExample example);

    int updateByExampleSelective(@Param("record") BatchJobSeqDO record, @Param("example") BatchJobSeqDOExample example);

    int updateByExample(@Param("record") BatchJobSeqDO record, @Param("example") BatchJobSeqDOExample example);
}
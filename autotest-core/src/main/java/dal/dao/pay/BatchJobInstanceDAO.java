package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.BatchJobInstanceDO;
import dal.model.pay.BatchJobInstanceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchJobInstanceDAO extends MyMapper<BatchJobInstanceDO> {
    long countByExample(BatchJobInstanceDOExample example);

    int deleteByExample(BatchJobInstanceDOExample example);

    List<BatchJobInstanceDO> selectByExample(BatchJobInstanceDOExample example);

    int updateByExampleSelective(@Param("record") BatchJobInstanceDO record, @Param("example") BatchJobInstanceDOExample example);

    int updateByExample(@Param("record") BatchJobInstanceDO record, @Param("example") BatchJobInstanceDOExample example);
}
package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.SysSeqDO;
import dal.model.clear.SysSeqDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSeqDAO extends MyMapper<SysSeqDO> {
    long countByExample(SysSeqDOExample example);

    int deleteByExample(SysSeqDOExample example);

    List<SysSeqDO> selectByExample(SysSeqDOExample example);

    int updateByExampleSelective(@Param("record") SysSeqDO record, @Param("example") SysSeqDOExample example);

    int updateByExample(@Param("record") SysSeqDO record, @Param("example") SysSeqDOExample example);
}
package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.SysSeqDO;
import dal.model.user.SysSeqDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSeqDAO extends MyMapper<SysSeqDO> {
    long countByExample(SysSeqDOExample example);

    int deleteByExample(SysSeqDOExample example);

    List<SysSeqDO> selectByExample(SysSeqDOExample example);

    int updateByExampleSelective(@Param("record") SysSeqDO record, @Param("example") SysSeqDOExample example);

    int updateByExample(@Param("record") SysSeqDO record, @Param("example") SysSeqDOExample example);
}
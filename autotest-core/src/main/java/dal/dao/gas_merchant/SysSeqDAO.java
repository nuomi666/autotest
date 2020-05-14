package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.SysSeqDO;
import dal.model.gas_merchant.SysSeqDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSeqDAO extends MyMapper<SysSeqDO> {
    long countByExample(SysSeqDOExample example);

    int deleteByExample(SysSeqDOExample example);

    List<SysSeqDO> selectByExample(SysSeqDOExample example);

    int updateByExampleSelective(@Param("record") SysSeqDO record, @Param("example") SysSeqDOExample example);

    int updateByExample(@Param("record") SysSeqDO record, @Param("example") SysSeqDOExample example);
}
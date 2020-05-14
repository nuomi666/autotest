package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.SysSequenceDO;
import dal.model.merchant.SysSequenceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSequenceDAO extends MyMapper<SysSequenceDO> {
    long countByExample(SysSequenceDOExample example);

    int deleteByExample(SysSequenceDOExample example);

    List<SysSequenceDO> selectByExample(SysSequenceDOExample example);

    int updateByExampleSelective(@Param("record") SysSequenceDO record, @Param("example") SysSequenceDOExample example);

    int updateByExample(@Param("record") SysSequenceDO record, @Param("example") SysSequenceDOExample example);
}
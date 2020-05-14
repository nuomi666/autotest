package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GroupScriptDO;
import dal.model.gas_silverbolt.GroupScriptDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupScriptDAO extends MyMapper<GroupScriptDO> {
    long countByExample(GroupScriptDOExample example);

    int deleteByExample(GroupScriptDOExample example);

    List<GroupScriptDO> selectByExample(GroupScriptDOExample example);

    int updateByExampleSelective(@Param("record") GroupScriptDO record, @Param("example") GroupScriptDOExample example);

    int updateByExample(@Param("record") GroupScriptDO record, @Param("example") GroupScriptDOExample example);
}
package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.PersonaTaskDO;
import dal.model.gas_silverbolt.PersonaTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonaTaskDAO extends MyMapper<PersonaTaskDO> {
    long countByExample(PersonaTaskDOExample example);

    int deleteByExample(PersonaTaskDOExample example);

    List<PersonaTaskDO> selectByExample(PersonaTaskDOExample example);

    int updateByExampleSelective(@Param("record") PersonaTaskDO record, @Param("example") PersonaTaskDOExample example);

    int updateByExample(@Param("record") PersonaTaskDO record, @Param("example") PersonaTaskDOExample example);
}
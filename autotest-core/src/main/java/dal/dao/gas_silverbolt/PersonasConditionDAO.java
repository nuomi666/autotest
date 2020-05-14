package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.PersonasConditionDO;
import dal.model.gas_silverbolt.PersonasConditionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonasConditionDAO extends MyMapper<PersonasConditionDO> {
    long countByExample(PersonasConditionDOExample example);

    int deleteByExample(PersonasConditionDOExample example);

    List<PersonasConditionDO> selectByExample(PersonasConditionDOExample example);

    int updateByExampleSelective(@Param("record") PersonasConditionDO record, @Param("example") PersonasConditionDOExample example);

    int updateByExample(@Param("record") PersonasConditionDO record, @Param("example") PersonasConditionDOExample example);
}
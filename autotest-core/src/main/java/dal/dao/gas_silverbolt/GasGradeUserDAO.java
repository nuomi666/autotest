package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasGradeUserDO;
import dal.model.gas_silverbolt.GasGradeUserDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasGradeUserDAO extends MyMapper<GasGradeUserDO> {
    long countByExample(GasGradeUserDOExample example);

    int deleteByExample(GasGradeUserDOExample example);

    List<GasGradeUserDO> selectByExample(GasGradeUserDOExample example);

    int updateByExampleSelective(@Param("record") GasGradeUserDO record, @Param("example") GasGradeUserDOExample example);

    int updateByExample(@Param("record") GasGradeUserDO record, @Param("example") GasGradeUserDOExample example);
}
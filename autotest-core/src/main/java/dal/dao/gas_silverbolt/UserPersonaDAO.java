package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.UserPersonaDO;
import dal.model.gas_silverbolt.UserPersonaDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPersonaDAO extends MyMapper<UserPersonaDO> {
    long countByExample(UserPersonaDOExample example);

    int deleteByExample(UserPersonaDOExample example);

    List<UserPersonaDO> selectByExampleWithBLOBs(UserPersonaDOExample example);

    List<UserPersonaDO> selectByExample(UserPersonaDOExample example);

    int updateByExampleSelective(@Param("record") UserPersonaDO record, @Param("example") UserPersonaDOExample example);

    int updateByExampleWithBLOBs(@Param("record") UserPersonaDO record, @Param("example") UserPersonaDOExample example);

    int updateByExample(@Param("record") UserPersonaDO record, @Param("example") UserPersonaDOExample example);
}
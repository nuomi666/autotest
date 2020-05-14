package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.TempUserCarDO;
import dal.model.gas_silverbolt.TempUserCarDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempUserCarDAO extends MyMapper<TempUserCarDO> {
    long countByExample(TempUserCarDOExample example);

    int deleteByExample(TempUserCarDOExample example);

    List<TempUserCarDO> selectByExample(TempUserCarDOExample example);

    int updateByExampleSelective(@Param("record") TempUserCarDO record, @Param("example") TempUserCarDOExample example);

    int updateByExample(@Param("record") TempUserCarDO record, @Param("example") TempUserCarDOExample example);
}
package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearDsgjRequestLogDO;
import dal.model.clear.ClearDsgjRequestLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearDsgjRequestLogDAO extends MyMapper<ClearDsgjRequestLogDO> {
    long countByExample(ClearDsgjRequestLogDOExample example);

    int deleteByExample(ClearDsgjRequestLogDOExample example);

    List<ClearDsgjRequestLogDO> selectByExample(ClearDsgjRequestLogDOExample example);

    int updateByExampleSelective(@Param("record") ClearDsgjRequestLogDO record, @Param("example") ClearDsgjRequestLogDOExample example);

    int updateByExample(@Param("record") ClearDsgjRequestLogDO record, @Param("example") ClearDsgjRequestLogDOExample example);
}
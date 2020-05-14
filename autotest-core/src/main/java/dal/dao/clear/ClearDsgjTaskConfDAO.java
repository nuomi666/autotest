package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearDsgjTaskConfDO;
import dal.model.clear.ClearDsgjTaskConfDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearDsgjTaskConfDAO extends MyMapper<ClearDsgjTaskConfDO> {
    long countByExample(ClearDsgjTaskConfDOExample example);

    int deleteByExample(ClearDsgjTaskConfDOExample example);

    List<ClearDsgjTaskConfDO> selectByExample(ClearDsgjTaskConfDOExample example);

    int updateByExampleSelective(@Param("record") ClearDsgjTaskConfDO record, @Param("example") ClearDsgjTaskConfDOExample example);

    int updateByExample(@Param("record") ClearDsgjTaskConfDO record, @Param("example") ClearDsgjTaskConfDOExample example);
}
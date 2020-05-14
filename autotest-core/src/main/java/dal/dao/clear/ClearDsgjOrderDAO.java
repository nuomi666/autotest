package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearDsgjOrderDO;
import dal.model.clear.ClearDsgjOrderDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearDsgjOrderDAO extends MyMapper<ClearDsgjOrderDO> {
    long countByExample(ClearDsgjOrderDOExample example);

    int deleteByExample(ClearDsgjOrderDOExample example);

    List<ClearDsgjOrderDO> selectByExample(ClearDsgjOrderDOExample example);

    int updateByExampleSelective(@Param("record") ClearDsgjOrderDO record, @Param("example") ClearDsgjOrderDOExample example);

    int updateByExample(@Param("record") ClearDsgjOrderDO record, @Param("example") ClearDsgjOrderDOExample example);
}
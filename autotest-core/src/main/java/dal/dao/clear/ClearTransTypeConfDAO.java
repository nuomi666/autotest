package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearTransTypeConfDO;
import dal.model.clear.ClearTransTypeConfDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearTransTypeConfDAO extends MyMapper<ClearTransTypeConfDO> {
    long countByExample(ClearTransTypeConfDOExample example);

    int deleteByExample(ClearTransTypeConfDOExample example);

    List<ClearTransTypeConfDO> selectByExample(ClearTransTypeConfDOExample example);

    int updateByExampleSelective(@Param("record") ClearTransTypeConfDO record, @Param("example") ClearTransTypeConfDOExample example);

    int updateByExample(@Param("record") ClearTransTypeConfDO record, @Param("example") ClearTransTypeConfDOExample example);
}
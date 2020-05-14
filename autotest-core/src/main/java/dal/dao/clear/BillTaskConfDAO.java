package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BillTaskConfDO;
import dal.model.clear.BillTaskConfDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillTaskConfDAO extends MyMapper<BillTaskConfDO> {
    long countByExample(BillTaskConfDOExample example);

    int deleteByExample(BillTaskConfDOExample example);

    List<BillTaskConfDO> selectByExample(BillTaskConfDOExample example);

    int updateByExampleSelective(@Param("record") BillTaskConfDO record, @Param("example") BillTaskConfDOExample example);

    int updateByExample(@Param("record") BillTaskConfDO record, @Param("example") BillTaskConfDOExample example);
}
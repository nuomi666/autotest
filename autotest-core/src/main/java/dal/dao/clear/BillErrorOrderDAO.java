package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BillErrorOrderDO;
import dal.model.clear.BillErrorOrderDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillErrorOrderDAO extends MyMapper<BillErrorOrderDO> {
    long countByExample(BillErrorOrderDOExample example);

    int deleteByExample(BillErrorOrderDOExample example);

    List<BillErrorOrderDO> selectByExample(BillErrorOrderDOExample example);

    int updateByExampleSelective(@Param("record") BillErrorOrderDO record, @Param("example") BillErrorOrderDOExample example);

    int updateByExample(@Param("record") BillErrorOrderDO record, @Param("example") BillErrorOrderDOExample example);
}
package dal.dao.openapi;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.openapi.OrderInfoDO;
import dal.model.openapi.OrderInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderInfoDAO extends MyMapper<OrderInfoDO> {
    long countByExample(OrderInfoDOExample example);

    int deleteByExample(OrderInfoDOExample example);

    List<OrderInfoDO> selectByExampleWithBLOBs(OrderInfoDOExample example);

    List<OrderInfoDO> selectByExample(OrderInfoDOExample example);

    int updateByExampleSelective(@Param("record") OrderInfoDO record, @Param("example") OrderInfoDOExample example);

    int updateByExampleWithBLOBs(@Param("record") OrderInfoDO record, @Param("example") OrderInfoDOExample example);

    int updateByExample(@Param("record") OrderInfoDO record, @Param("example") OrderInfoDOExample example);
}
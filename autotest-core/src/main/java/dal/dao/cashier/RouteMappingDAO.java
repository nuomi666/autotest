package dal.dao.cashier;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.cashier.RouteMappingDO;
import dal.model.cashier.RouteMappingDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RouteMappingDAO extends MyMapper<RouteMappingDO> {
    long countByExample(RouteMappingDOExample example);

    int deleteByExample(RouteMappingDOExample example);

    List<RouteMappingDO> selectByExample(RouteMappingDOExample example);

    int updateByExampleSelective(@Param("record") RouteMappingDO record, @Param("example") RouteMappingDOExample example);

    int updateByExample(@Param("record") RouteMappingDO record, @Param("example") RouteMappingDOExample example);
}
package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.PointSchemeDO;
import dal.model.gas_marketpc.PointSchemeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PointSchemeDAO extends MyMapper<PointSchemeDO> {
    long countByExample(PointSchemeDOExample example);

    int deleteByExample(PointSchemeDOExample example);

    List<PointSchemeDO> selectByExample(PointSchemeDOExample example);

    int updateByExampleSelective(@Param("record") PointSchemeDO record, @Param("example") PointSchemeDOExample example);

    int updateByExample(@Param("record") PointSchemeDO record, @Param("example") PointSchemeDOExample example);
}
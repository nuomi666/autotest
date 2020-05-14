package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.DistinctDetailDO;
import dal.model.gas_silverbolt.DistinctDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistinctDetailDAO extends MyMapper<DistinctDetailDO> {
    long countByExample(DistinctDetailDOExample example);

    int deleteByExample(DistinctDetailDOExample example);

    List<DistinctDetailDO> selectByExampleWithBLOBs(DistinctDetailDOExample example);

    List<DistinctDetailDO> selectByExample(DistinctDetailDOExample example);

    int updateByExampleSelective(@Param("record") DistinctDetailDO record, @Param("example") DistinctDetailDOExample example);

    int updateByExampleWithBLOBs(@Param("record") DistinctDetailDO record, @Param("example") DistinctDetailDOExample example);

    int updateByExample(@Param("record") DistinctDetailDO record, @Param("example") DistinctDetailDOExample example);
}
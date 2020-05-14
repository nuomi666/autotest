package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.DetailModelProgramDO;
import dal.model.gas_silverbolt.DetailModelProgramDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailModelProgramDAO extends MyMapper<DetailModelProgramDO> {
    long countByExample(DetailModelProgramDOExample example);

    int deleteByExample(DetailModelProgramDOExample example);

    List<DetailModelProgramDO> selectByExampleWithBLOBs(DetailModelProgramDOExample example);

    List<DetailModelProgramDO> selectByExample(DetailModelProgramDOExample example);

    int updateByExampleSelective(@Param("record") DetailModelProgramDO record, @Param("example") DetailModelProgramDOExample example);

    int updateByExampleWithBLOBs(@Param("record") DetailModelProgramDO record, @Param("example") DetailModelProgramDOExample example);

    int updateByExample(@Param("record") DetailModelProgramDO record, @Param("example") DetailModelProgramDOExample example);
}
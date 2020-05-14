package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.DetailModelDO;
import dal.model.gas_silverbolt.DetailModelDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailModelDAO extends MyMapper<DetailModelDO> {
    long countByExample(DetailModelDOExample example);

    int deleteByExample(DetailModelDOExample example);

    List<DetailModelDO> selectByExample(DetailModelDOExample example);

    int updateByExampleSelective(@Param("record") DetailModelDO record, @Param("example") DetailModelDOExample example);

    int updateByExample(@Param("record") DetailModelDO record, @Param("example") DetailModelDOExample example);
}
package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.DetailHeadDO;
import dal.model.gas_silverbolt.DetailHeadDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetailHeadDAO extends MyMapper<DetailHeadDO> {
    long countByExample(DetailHeadDOExample example);

    int deleteByExample(DetailHeadDOExample example);

    List<DetailHeadDO> selectByExample(DetailHeadDOExample example);

    int updateByExampleSelective(@Param("record") DetailHeadDO record, @Param("example") DetailHeadDOExample example);

    int updateByExample(@Param("record") DetailHeadDO record, @Param("example") DetailHeadDOExample example);
}
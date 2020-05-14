package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.WashRecommendGasUserDO;
import dal.model.gas_silverbolt.WashRecommendGasUserDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WashRecommendGasUserDAO extends MyMapper<WashRecommendGasUserDO> {
    long countByExample(WashRecommendGasUserDOExample example);

    int deleteByExample(WashRecommendGasUserDOExample example);

    List<WashRecommendGasUserDO> selectByExample(WashRecommendGasUserDOExample example);

    int updateByExampleSelective(@Param("record") WashRecommendGasUserDO record, @Param("example") WashRecommendGasUserDOExample example);

    int updateByExample(@Param("record") WashRecommendGasUserDO record, @Param("example") WashRecommendGasUserDOExample example);
}
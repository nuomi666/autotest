package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.GivePointsDetailDO;
import dal.model.gas_marketpc.GivePointsDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GivePointsDetailDAO extends MyMapper<GivePointsDetailDO> {
    long countByExample(GivePointsDetailDOExample example);

    int deleteByExample(GivePointsDetailDOExample example);

    List<GivePointsDetailDO> selectByExample(GivePointsDetailDOExample example);

    int updateByExampleSelective(@Param("record") GivePointsDetailDO record, @Param("example") GivePointsDetailDOExample example);

    int updateByExample(@Param("record") GivePointsDetailDO record, @Param("example") GivePointsDetailDOExample example);
}
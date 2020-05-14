package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.GivePointsDetailBk20190116DO;
import dal.model.gas_marketpc.GivePointsDetailBk20190116DOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GivePointsDetailBk20190116DAO extends MyMapper<GivePointsDetailBk20190116DO> {
    long countByExample(GivePointsDetailBk20190116DOExample example);

    int deleteByExample(GivePointsDetailBk20190116DOExample example);

    List<GivePointsDetailBk20190116DO> selectByExample(GivePointsDetailBk20190116DOExample example);

    int updateByExampleSelective(@Param("record") GivePointsDetailBk20190116DO record, @Param("example") GivePointsDetailBk20190116DOExample example);

    int updateByExample(@Param("record") GivePointsDetailBk20190116DO record, @Param("example") GivePointsDetailBk20190116DOExample example);
}
package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GunsDO;
import dal.model.shellmerchant.GunsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GunsDAO extends MyMapper<GunsDO> {
    long countByExample(GunsDOExample example);

    int deleteByExample(GunsDOExample example);

    List<GunsDO> selectByExample(GunsDOExample example);

    int updateByExampleSelective(@Param("record") GunsDO record, @Param("example") GunsDOExample example);

    int updateByExample(@Param("record") GunsDO record, @Param("example") GunsDOExample example);
}
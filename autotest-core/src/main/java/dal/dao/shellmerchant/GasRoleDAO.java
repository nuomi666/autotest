package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasRoleDO;
import dal.model.shellmerchant.GasRoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasRoleDAO extends MyMapper<GasRoleDO> {
    long countByExample(GasRoleDOExample example);

    int deleteByExample(GasRoleDOExample example);

    List<GasRoleDO> selectByExample(GasRoleDOExample example);

    int updateByExampleSelective(@Param("record") GasRoleDO record, @Param("example") GasRoleDOExample example);

    int updateByExample(@Param("record") GasRoleDO record, @Param("example") GasRoleDOExample example);
}
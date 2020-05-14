package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasAppVersionDO;
import dal.model.gas_merchant.GasAppVersionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasAppVersionDAO extends MyMapper<GasAppVersionDO> {
    long countByExample(GasAppVersionDOExample example);

    int deleteByExample(GasAppVersionDOExample example);

    List<GasAppVersionDO> selectByExample(GasAppVersionDOExample example);

    int updateByExampleSelective(@Param("record") GasAppVersionDO record, @Param("example") GasAppVersionDOExample example);

    int updateByExample(@Param("record") GasAppVersionDO record, @Param("example") GasAppVersionDOExample example);
}
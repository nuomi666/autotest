package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasLoginLogCopyDO;
import dal.model.gas_merchant.GasLoginLogCopyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasLoginLogCopyDAO extends MyMapper<GasLoginLogCopyDO> {
    long countByExample(GasLoginLogCopyDOExample example);

    int deleteByExample(GasLoginLogCopyDOExample example);

    List<GasLoginLogCopyDO> selectByExample(GasLoginLogCopyDOExample example);

    int updateByExampleSelective(@Param("record") GasLoginLogCopyDO record, @Param("example") GasLoginLogCopyDOExample example);

    int updateByExample(@Param("record") GasLoginLogCopyDO record, @Param("example") GasLoginLogCopyDOExample example);
}
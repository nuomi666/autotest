package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasWechatTokenDO;
import dal.model.gas_merchant.GasWechatTokenDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasWechatTokenDAO extends MyMapper<GasWechatTokenDO> {
    long countByExample(GasWechatTokenDOExample example);

    int deleteByExample(GasWechatTokenDOExample example);

    List<GasWechatTokenDO> selectByExample(GasWechatTokenDOExample example);

    int updateByExampleSelective(@Param("record") GasWechatTokenDO record, @Param("example") GasWechatTokenDOExample example);

    int updateByExample(@Param("record") GasWechatTokenDO record, @Param("example") GasWechatTokenDOExample example);
}
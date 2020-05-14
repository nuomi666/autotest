package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantOperatorLoginLogDO;
import dal.model.merchant.MerchantOperatorLoginLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantOperatorLoginLogDAO extends MyMapper<MerchantOperatorLoginLogDO> {
    long countByExample(MerchantOperatorLoginLogDOExample example);

    int deleteByExample(MerchantOperatorLoginLogDOExample example);

    List<MerchantOperatorLoginLogDO> selectByExample(MerchantOperatorLoginLogDOExample example);

    int updateByExampleSelective(@Param("record") MerchantOperatorLoginLogDO record, @Param("example") MerchantOperatorLoginLogDOExample example);

    int updateByExample(@Param("record") MerchantOperatorLoginLogDO record, @Param("example") MerchantOperatorLoginLogDOExample example);
}
package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantOperatorDO;
import dal.model.merchant.MerchantOperatorDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantOperatorDAO extends MyMapper<MerchantOperatorDO> {
    long countByExample(MerchantOperatorDOExample example);

    int deleteByExample(MerchantOperatorDOExample example);

    List<MerchantOperatorDO> selectByExample(MerchantOperatorDOExample example);

    int updateByExampleSelective(@Param("record") MerchantOperatorDO record, @Param("example") MerchantOperatorDOExample example);

    int updateByExample(@Param("record") MerchantOperatorDO record, @Param("example") MerchantOperatorDOExample example);
}
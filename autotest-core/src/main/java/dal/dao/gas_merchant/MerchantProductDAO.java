package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.MerchantProductDO;
import dal.model.gas_merchant.MerchantProductDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantProductDAO extends MyMapper<MerchantProductDO> {
    long countByExample(MerchantProductDOExample example);

    int deleteByExample(MerchantProductDOExample example);

    List<MerchantProductDO> selectByExample(MerchantProductDOExample example);

    int updateByExampleSelective(@Param("record") MerchantProductDO record, @Param("example") MerchantProductDOExample example);

    int updateByExample(@Param("record") MerchantProductDO record, @Param("example") MerchantProductDOExample example);
}
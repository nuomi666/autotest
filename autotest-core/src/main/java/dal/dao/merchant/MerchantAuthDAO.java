package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantAuthDO;
import dal.model.merchant.MerchantAuthDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantAuthDAO extends MyMapper<MerchantAuthDO> {
    long countByExample(MerchantAuthDOExample example);

    int deleteByExample(MerchantAuthDOExample example);

    List<MerchantAuthDO> selectByExample(MerchantAuthDOExample example);

    int updateByExampleSelective(@Param("record") MerchantAuthDO record, @Param("example") MerchantAuthDOExample example);

    int updateByExample(@Param("record") MerchantAuthDO record, @Param("example") MerchantAuthDOExample example);
}
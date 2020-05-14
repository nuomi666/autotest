package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantDO;
import dal.model.merchant.MerchantDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantDAO extends MyMapper<MerchantDO> {
    long countByExample(MerchantDOExample example);

    int deleteByExample(MerchantDOExample example);

    List<MerchantDO> selectByExample(MerchantDOExample example);

    int updateByExampleSelective(@Param("record") MerchantDO record, @Param("example") MerchantDOExample example);

    int updateByExample(@Param("record") MerchantDO record, @Param("example") MerchantDOExample example);
}
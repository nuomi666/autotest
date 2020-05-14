package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantInfoDO;
import dal.model.merchant.MerchantInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantInfoDAO extends MyMapper<MerchantInfoDO> {
    long countByExample(MerchantInfoDOExample example);

    int deleteByExample(MerchantInfoDOExample example);

    List<MerchantInfoDO> selectByExampleWithBLOBs(MerchantInfoDOExample example);

    List<MerchantInfoDO> selectByExample(MerchantInfoDOExample example);

    int updateByExampleSelective(@Param("record") MerchantInfoDO record, @Param("example") MerchantInfoDOExample example);

    int updateByExampleWithBLOBs(@Param("record") MerchantInfoDO record, @Param("example") MerchantInfoDOExample example);

    int updateByExample(@Param("record") MerchantInfoDO record, @Param("example") MerchantInfoDOExample example);
}
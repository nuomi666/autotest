package dal.dao.gas_marketpc;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_marketpc.MerchantExtendInfoDO;
import dal.model.gas_marketpc.MerchantExtendInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantExtendInfoDAO extends MyMapper<MerchantExtendInfoDO> {
    long countByExample(MerchantExtendInfoDOExample example);

    int deleteByExample(MerchantExtendInfoDOExample example);

    List<MerchantExtendInfoDO> selectByExample(MerchantExtendInfoDOExample example);

    int updateByExampleSelective(@Param("record") MerchantExtendInfoDO record, @Param("example") MerchantExtendInfoDOExample example);

    int updateByExample(@Param("record") MerchantExtendInfoDO record, @Param("example") MerchantExtendInfoDOExample example);
}
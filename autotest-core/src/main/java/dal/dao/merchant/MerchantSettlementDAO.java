package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantSettlementDO;
import dal.model.merchant.MerchantSettlementDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantSettlementDAO extends MyMapper<MerchantSettlementDO> {
    long countByExample(MerchantSettlementDOExample example);

    int deleteByExample(MerchantSettlementDOExample example);

    List<MerchantSettlementDO> selectByExample(MerchantSettlementDOExample example);

    int updateByExampleSelective(@Param("record") MerchantSettlementDO record, @Param("example") MerchantSettlementDOExample example);

    int updateByExample(@Param("record") MerchantSettlementDO record, @Param("example") MerchantSettlementDOExample example);
}
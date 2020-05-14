package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.MerchantProtocolRuleDO;
import dal.model.shellmerchant.MerchantProtocolRuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantProtocolRuleDAO extends MyMapper<MerchantProtocolRuleDO> {
    long countByExample(MerchantProtocolRuleDOExample example);

    int deleteByExample(MerchantProtocolRuleDOExample example);

    List<MerchantProtocolRuleDO> selectByExampleWithBLOBs(MerchantProtocolRuleDOExample example);

    List<MerchantProtocolRuleDO> selectByExample(MerchantProtocolRuleDOExample example);

    int updateByExampleSelective(@Param("record") MerchantProtocolRuleDO record, @Param("example") MerchantProtocolRuleDOExample example);

    int updateByExampleWithBLOBs(@Param("record") MerchantProtocolRuleDO record, @Param("example") MerchantProtocolRuleDOExample example);

    int updateByExample(@Param("record") MerchantProtocolRuleDO record, @Param("example") MerchantProtocolRuleDOExample example);
}
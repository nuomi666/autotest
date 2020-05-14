package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantRoleDO;
import dal.model.merchant.MerchantRoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantRoleDAO extends MyMapper<MerchantRoleDO> {
    long countByExample(MerchantRoleDOExample example);

    int deleteByExample(MerchantRoleDOExample example);

    List<MerchantRoleDO> selectByExample(MerchantRoleDOExample example);

    int updateByExampleSelective(@Param("record") MerchantRoleDO record, @Param("example") MerchantRoleDOExample example);

    int updateByExample(@Param("record") MerchantRoleDO record, @Param("example") MerchantRoleDOExample example);
}
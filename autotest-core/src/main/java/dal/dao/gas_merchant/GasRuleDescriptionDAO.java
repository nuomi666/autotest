package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasRuleDescriptionDO;
import dal.model.gas_merchant.GasRuleDescriptionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasRuleDescriptionDAO extends MyMapper<GasRuleDescriptionDO> {
    long countByExample(GasRuleDescriptionDOExample example);

    int deleteByExample(GasRuleDescriptionDOExample example);

    List<GasRuleDescriptionDO> selectByExampleWithBLOBs(GasRuleDescriptionDOExample example);

    List<GasRuleDescriptionDO> selectByExample(GasRuleDescriptionDOExample example);

    int updateByExampleSelective(@Param("record") GasRuleDescriptionDO record, @Param("example") GasRuleDescriptionDOExample example);

    int updateByExampleWithBLOBs(@Param("record") GasRuleDescriptionDO record, @Param("example") GasRuleDescriptionDOExample example);

    int updateByExample(@Param("record") GasRuleDescriptionDO record, @Param("example") GasRuleDescriptionDOExample example);
}
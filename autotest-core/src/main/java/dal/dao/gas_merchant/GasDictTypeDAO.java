package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasDictTypeDO;
import dal.model.gas_merchant.GasDictTypeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDictTypeDAO extends MyMapper<GasDictTypeDO> {
    long countByExample(GasDictTypeDOExample example);

    int deleteByExample(GasDictTypeDOExample example);

    List<GasDictTypeDO> selectByExample(GasDictTypeDOExample example);

    int updateByExampleSelective(@Param("record") GasDictTypeDO record, @Param("example") GasDictTypeDOExample example);

    int updateByExample(@Param("record") GasDictTypeDO record, @Param("example") GasDictTypeDOExample example);
}
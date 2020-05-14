package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.DianxinDO;
import dal.model.gas_merchant.DianxinDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DianxinDAO extends MyMapper<DianxinDO> {
    long countByExample(DianxinDOExample example);

    int deleteByExample(DianxinDOExample example);

    List<DianxinDO> selectByExample(DianxinDOExample example);

    int updateByExampleSelective(@Param("record") DianxinDO record, @Param("example") DianxinDOExample example);

    int updateByExample(@Param("record") DianxinDO record, @Param("example") DianxinDOExample example);
}
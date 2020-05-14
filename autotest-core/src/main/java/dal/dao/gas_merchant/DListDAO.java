package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.DListDO;
import dal.model.gas_merchant.DListDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DListDAO extends MyMapper<DListDO> {
    long countByExample(DListDOExample example);

    int deleteByExample(DListDOExample example);

    List<DListDO> selectByExample(DListDOExample example);

    int updateByExampleSelective(@Param("record") DListDO record, @Param("example") DListDOExample example);

    int updateByExample(@Param("record") DListDO record, @Param("example") DListDOExample example);
}
package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.SListDO;
import dal.model.gas_merchant.SListDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SListDAO extends MyMapper<SListDO> {
    long countByExample(SListDOExample example);

    int deleteByExample(SListDOExample example);

    List<SListDO> selectByExample(SListDOExample example);

    int updateByExampleSelective(@Param("record") SListDO record, @Param("example") SListDOExample example);

    int updateByExample(@Param("record") SListDO record, @Param("example") SListDOExample example);
}
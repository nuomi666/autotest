package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.BankDictionaryDO;
import dal.model.merchant.BankDictionaryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankDictionaryDAO extends MyMapper<BankDictionaryDO> {
    long countByExample(BankDictionaryDOExample example);

    int deleteByExample(BankDictionaryDOExample example);

    List<BankDictionaryDO> selectByExample(BankDictionaryDOExample example);

    int updateByExampleSelective(@Param("record") BankDictionaryDO record, @Param("example") BankDictionaryDOExample example);

    int updateByExample(@Param("record") BankDictionaryDO record, @Param("example") BankDictionaryDOExample example);
}
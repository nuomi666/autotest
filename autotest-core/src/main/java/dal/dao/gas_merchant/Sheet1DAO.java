package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.Sheet1DO;
import dal.model.gas_merchant.Sheet1DOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sheet1DAO extends MyMapper<Sheet1DO> {
    long countByExample(Sheet1DOExample example);

    int deleteByExample(Sheet1DOExample example);

    List<Sheet1DO> selectByExample(Sheet1DOExample example);

    int updateByExampleSelective(@Param("record") Sheet1DO record, @Param("example") Sheet1DOExample example);

    int updateByExample(@Param("record") Sheet1DO record, @Param("example") Sheet1DOExample example);
}
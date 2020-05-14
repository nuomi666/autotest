package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.BaseTradeCopy1DO;
import dal.model.gas_merchant.BaseTradeCopy1DOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseTradeCopy1DAO extends MyMapper<BaseTradeCopy1DO> {
    long countByExample(BaseTradeCopy1DOExample example);

    int deleteByExample(BaseTradeCopy1DOExample example);

    List<BaseTradeCopy1DO> selectByExample(BaseTradeCopy1DOExample example);

    int updateByExampleSelective(@Param("record") BaseTradeCopy1DO record, @Param("example") BaseTradeCopy1DOExample example);

    int updateByExample(@Param("record") BaseTradeCopy1DO record, @Param("example") BaseTradeCopy1DOExample example);
}
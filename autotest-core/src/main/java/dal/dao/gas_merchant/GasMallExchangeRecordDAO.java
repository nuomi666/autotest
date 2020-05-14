package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMallExchangeRecordDO;
import dal.model.gas_merchant.GasMallExchangeRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMallExchangeRecordDAO extends MyMapper<GasMallExchangeRecordDO> {
    long countByExample(GasMallExchangeRecordDOExample example);

    int deleteByExample(GasMallExchangeRecordDOExample example);

    List<GasMallExchangeRecordDO> selectByExample(GasMallExchangeRecordDOExample example);

    int updateByExampleSelective(@Param("record") GasMallExchangeRecordDO record, @Param("example") GasMallExchangeRecordDOExample example);

    int updateByExample(@Param("record") GasMallExchangeRecordDO record, @Param("example") GasMallExchangeRecordDOExample example);
}
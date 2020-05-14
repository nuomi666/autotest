package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasMallExchangeRecordDO;
import dal.model.shellmerchant.GasMallExchangeRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMallExchangeRecordDAO extends MyMapper<GasMallExchangeRecordDO> {
    long countByExample(GasMallExchangeRecordDOExample example);

    int deleteByExample(GasMallExchangeRecordDOExample example);

    List<GasMallExchangeRecordDO> selectByExample(GasMallExchangeRecordDOExample example);

    int updateByExampleSelective(@Param("record") GasMallExchangeRecordDO record, @Param("example") GasMallExchangeRecordDOExample example);

    int updateByExample(@Param("record") GasMallExchangeRecordDO record, @Param("example") GasMallExchangeRecordDOExample example);
}
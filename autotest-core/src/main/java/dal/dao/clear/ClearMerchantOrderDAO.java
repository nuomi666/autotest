package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.ClearMerchantOrderDO;
import dal.model.clear.ClearMerchantOrderDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClearMerchantOrderDAO extends MyMapper<ClearMerchantOrderDO> {
    long countByExample(ClearMerchantOrderDOExample example);

    int deleteByExample(ClearMerchantOrderDOExample example);

    List<ClearMerchantOrderDO> selectByExample(ClearMerchantOrderDOExample example);

    int updateByExampleSelective(@Param("record") ClearMerchantOrderDO record, @Param("example") ClearMerchantOrderDOExample example);

    int updateByExample(@Param("record") ClearMerchantOrderDO record, @Param("example") ClearMerchantOrderDOExample example);
}
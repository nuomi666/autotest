package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.MerchantReportDO;
import dal.model.gas_silverbolt.MerchantReportDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantReportDAO extends MyMapper<MerchantReportDO> {
    long countByExample(MerchantReportDOExample example);

    int deleteByExample(MerchantReportDOExample example);

    List<MerchantReportDO> selectByExample(MerchantReportDOExample example);

    int updateByExampleSelective(@Param("record") MerchantReportDO record, @Param("example") MerchantReportDOExample example);

    int updateByExample(@Param("record") MerchantReportDO record, @Param("example") MerchantReportDOExample example);
}
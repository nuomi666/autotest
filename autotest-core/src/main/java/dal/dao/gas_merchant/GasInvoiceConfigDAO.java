package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasInvoiceConfigDO;
import dal.model.gas_merchant.GasInvoiceConfigDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasInvoiceConfigDAO extends MyMapper<GasInvoiceConfigDO> {
    long countByExample(GasInvoiceConfigDOExample example);

    int deleteByExample(GasInvoiceConfigDOExample example);

    List<GasInvoiceConfigDO> selectByExample(GasInvoiceConfigDOExample example);

    int updateByExampleSelective(@Param("record") GasInvoiceConfigDO record, @Param("example") GasInvoiceConfigDOExample example);

    int updateByExample(@Param("record") GasInvoiceConfigDO record, @Param("example") GasInvoiceConfigDOExample example);
}
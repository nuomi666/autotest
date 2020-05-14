package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasInvoiceCompanyDO;
import dal.model.gas_merchant.GasInvoiceCompanyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasInvoiceCompanyDAO extends MyMapper<GasInvoiceCompanyDO> {
    long countByExample(GasInvoiceCompanyDOExample example);

    int deleteByExample(GasInvoiceCompanyDOExample example);

    List<GasInvoiceCompanyDO> selectByExample(GasInvoiceCompanyDOExample example);

    int updateByExampleSelective(@Param("record") GasInvoiceCompanyDO record, @Param("example") GasInvoiceCompanyDOExample example);

    int updateByExample(@Param("record") GasInvoiceCompanyDO record, @Param("example") GasInvoiceCompanyDOExample example);
}
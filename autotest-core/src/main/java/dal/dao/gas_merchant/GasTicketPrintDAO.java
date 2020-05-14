package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasTicketPrintDO;
import dal.model.gas_merchant.GasTicketPrintDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasTicketPrintDAO extends MyMapper<GasTicketPrintDO> {
    long countByExample(GasTicketPrintDOExample example);

    int deleteByExample(GasTicketPrintDOExample example);

    List<GasTicketPrintDO> selectByExample(GasTicketPrintDOExample example);

    int updateByExampleSelective(@Param("record") GasTicketPrintDO record, @Param("example") GasTicketPrintDOExample example);

    int updateByExample(@Param("record") GasTicketPrintDO record, @Param("example") GasTicketPrintDOExample example);
}
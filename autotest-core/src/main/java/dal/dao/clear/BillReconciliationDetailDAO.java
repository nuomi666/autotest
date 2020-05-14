package dal.dao.clear;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.clear.BillReconciliationDetailDO;
import dal.model.clear.BillReconciliationDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillReconciliationDetailDAO extends MyMapper<BillReconciliationDetailDO> {
    long countByExample(BillReconciliationDetailDOExample example);

    int deleteByExample(BillReconciliationDetailDOExample example);

    List<BillReconciliationDetailDO> selectByExample(BillReconciliationDetailDOExample example);

    int updateByExampleSelective(@Param("record") BillReconciliationDetailDO record, @Param("example") BillReconciliationDetailDOExample example);

    int updateByExample(@Param("record") BillReconciliationDetailDO record, @Param("example") BillReconciliationDetailDOExample example);
}
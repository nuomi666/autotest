package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.ReportConfigDO;
import dal.model.gas_silverbolt.ReportConfigDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportConfigDAO extends MyMapper<ReportConfigDO> {
    long countByExample(ReportConfigDOExample example);

    int deleteByExample(ReportConfigDOExample example);

    List<ReportConfigDO> selectByExampleWithBLOBs(ReportConfigDOExample example);

    List<ReportConfigDO> selectByExample(ReportConfigDOExample example);

    int updateByExampleSelective(@Param("record") ReportConfigDO record, @Param("example") ReportConfigDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ReportConfigDO record, @Param("example") ReportConfigDOExample example);

    int updateByExample(@Param("record") ReportConfigDO record, @Param("example") ReportConfigDOExample example);
}
package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.TransOrderRecordDO;
import dal.model.pay.TransOrderRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransOrderRecordDAO extends MyMapper<TransOrderRecordDO> {
    long countByExample(TransOrderRecordDOExample example);

    int deleteByExample(TransOrderRecordDOExample example);

    List<TransOrderRecordDO> selectByExample(TransOrderRecordDOExample example);

    int updateByExampleSelective(@Param("record") TransOrderRecordDO record, @Param("example") TransOrderRecordDOExample example);

    int updateByExample(@Param("record") TransOrderRecordDO record, @Param("example") TransOrderRecordDOExample example);
}
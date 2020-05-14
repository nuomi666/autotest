package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.MqMessageRecordDO;
import dal.model.pay.MqMessageRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MqMessageRecordDAO extends MyMapper<MqMessageRecordDO> {
    long countByExample(MqMessageRecordDOExample example);

    int deleteByExample(MqMessageRecordDOExample example);

    List<MqMessageRecordDO> selectByExample(MqMessageRecordDOExample example);

    int updateByExampleSelective(@Param("record") MqMessageRecordDO record, @Param("example") MqMessageRecordDOExample example);

    int updateByExample(@Param("record") MqMessageRecordDO record, @Param("example") MqMessageRecordDOExample example);
}
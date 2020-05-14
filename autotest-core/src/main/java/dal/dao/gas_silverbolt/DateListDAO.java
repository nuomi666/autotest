package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.DateListDO;
import dal.model.gas_silverbolt.DateListDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DateListDAO extends MyMapper<DateListDO> {
    long countByExample(DateListDOExample example);

    int deleteByExample(DateListDOExample example);

    List<DateListDO> selectByExample(DateListDOExample example);

    int updateByExampleSelective(@Param("record") DateListDO record, @Param("example") DateListDOExample example);

    int updateByExample(@Param("record") DateListDO record, @Param("example") DateListDOExample example);
}
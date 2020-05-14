package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.BusinessLogDO;
import dal.model.merchant.BusinessLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessLogDAO extends MyMapper<BusinessLogDO> {
    long countByExample(BusinessLogDOExample example);

    int deleteByExample(BusinessLogDOExample example);

    List<BusinessLogDO> selectByExample(BusinessLogDOExample example);

    int updateByExampleSelective(@Param("record") BusinessLogDO record, @Param("example") BusinessLogDOExample example);

    int updateByExample(@Param("record") BusinessLogDO record, @Param("example") BusinessLogDOExample example);
}
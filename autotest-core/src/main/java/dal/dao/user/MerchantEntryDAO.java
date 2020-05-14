package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.MerchantEntryDO;
import dal.model.user.MerchantEntryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantEntryDAO extends MyMapper<MerchantEntryDO> {
    long countByExample(MerchantEntryDOExample example);

    int deleteByExample(MerchantEntryDOExample example);

    List<MerchantEntryDO> selectByExample(MerchantEntryDOExample example);

    int updateByExampleSelective(@Param("record") MerchantEntryDO record, @Param("example") MerchantEntryDOExample example);

    int updateByExample(@Param("record") MerchantEntryDO record, @Param("example") MerchantEntryDOExample example);
}
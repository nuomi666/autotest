package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.UserBankCardHisDO;
import dal.model.user.UserBankCardHisDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBankCardHisDAO extends MyMapper<UserBankCardHisDO> {
    long countByExample(UserBankCardHisDOExample example);

    int deleteByExample(UserBankCardHisDOExample example);

    List<UserBankCardHisDO> selectByExample(UserBankCardHisDOExample example);

    int updateByExampleSelective(@Param("record") UserBankCardHisDO record, @Param("example") UserBankCardHisDOExample example);

    int updateByExample(@Param("record") UserBankCardHisDO record, @Param("example") UserBankCardHisDOExample example);
}
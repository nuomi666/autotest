package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.UserBankCardDO;
import dal.model.user.UserBankCardDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBankCardDAO extends MyMapper<UserBankCardDO> {
    long countByExample(UserBankCardDOExample example);

    int deleteByExample(UserBankCardDOExample example);

    List<UserBankCardDO> selectByExample(UserBankCardDOExample example);

    int updateByExampleSelective(@Param("record") UserBankCardDO record, @Param("example") UserBankCardDOExample example);

    int updateByExample(@Param("record") UserBankCardDO record, @Param("example") UserBankCardDOExample example);
}
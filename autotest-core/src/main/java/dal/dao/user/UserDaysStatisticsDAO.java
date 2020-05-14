package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.UserDaysStatisticsDO;
import dal.model.user.UserDaysStatisticsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDaysStatisticsDAO extends MyMapper<UserDaysStatisticsDO> {
    long countByExample(UserDaysStatisticsDOExample example);

    int deleteByExample(UserDaysStatisticsDOExample example);

    List<UserDaysStatisticsDO> selectByExample(UserDaysStatisticsDOExample example);

    int updateByExampleSelective(@Param("record") UserDaysStatisticsDO record, @Param("example") UserDaysStatisticsDOExample example);

    int updateByExample(@Param("record") UserDaysStatisticsDO record, @Param("example") UserDaysStatisticsDOExample example);
}
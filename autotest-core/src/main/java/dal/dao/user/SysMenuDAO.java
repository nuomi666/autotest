package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.SysMenuDO;
import dal.model.user.SysMenuDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuDAO extends MyMapper<SysMenuDO> {
    long countByExample(SysMenuDOExample example);

    int deleteByExample(SysMenuDOExample example);

    List<SysMenuDO> selectByExample(SysMenuDOExample example);

    int updateByExampleSelective(@Param("record") SysMenuDO record, @Param("example") SysMenuDOExample example);

    int updateByExample(@Param("record") SysMenuDO record, @Param("example") SysMenuDOExample example);
}
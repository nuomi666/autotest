package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.SysMenuDO;
import dal.model.pay.SysMenuDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuDAO extends MyMapper<SysMenuDO> {
    long countByExample(SysMenuDOExample example);

    int deleteByExample(SysMenuDOExample example);

    List<SysMenuDO> selectByExample(SysMenuDOExample example);

    int updateByExampleSelective(@Param("record") SysMenuDO record, @Param("example") SysMenuDOExample example);

    int updateByExample(@Param("record") SysMenuDO record, @Param("example") SysMenuDOExample example);
}
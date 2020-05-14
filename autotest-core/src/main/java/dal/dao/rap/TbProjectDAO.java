package dal.dao.rap;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.rap.TbProjectDO;
import dal.model.rap.TbProjectDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbProjectDAO extends MyMapper<TbProjectDO> {
    long countByExample(TbProjectDOExample example);

    int deleteByExample(TbProjectDOExample example);

    List<TbProjectDO> selectByExample(TbProjectDOExample example);

    int updateByExampleSelective(@Param("record") TbProjectDO record, @Param("example") TbProjectDOExample example);

    int updateByExample(@Param("record") TbProjectDO record, @Param("example") TbProjectDOExample example);
}
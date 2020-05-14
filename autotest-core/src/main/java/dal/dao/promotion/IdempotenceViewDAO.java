package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.IdempotenceViewDO;
import dal.model.promotion.IdempotenceViewDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdempotenceViewDAO extends MyMapper<IdempotenceViewDO> {
    long countByExample(IdempotenceViewDOExample example);

    int deleteByExample(IdempotenceViewDOExample example);

    List<IdempotenceViewDO> selectByExample(IdempotenceViewDOExample example);

    int updateByExampleSelective(@Param("record") IdempotenceViewDO record, @Param("example") IdempotenceViewDOExample example);

    int updateByExample(@Param("record") IdempotenceViewDO record, @Param("example") IdempotenceViewDOExample example);
}
package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.DomainEventEntryDO;
import dal.model.promotion.DomainEventEntryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DomainEventEntryDAO extends MyMapper<DomainEventEntryDO> {
    long countByExample(DomainEventEntryDOExample example);

    int deleteByExample(DomainEventEntryDOExample example);

    List<DomainEventEntryDO> selectByExampleWithBLOBs(DomainEventEntryDOExample example);

    List<DomainEventEntryDO> selectByExample(DomainEventEntryDOExample example);

    int updateByExampleSelective(@Param("record") DomainEventEntryDO record, @Param("example") DomainEventEntryDOExample example);

    int updateByExampleWithBLOBs(@Param("record") DomainEventEntryDO record, @Param("example") DomainEventEntryDOExample example);

    int updateByExample(@Param("record") DomainEventEntryDO record, @Param("example") DomainEventEntryDOExample example);
}
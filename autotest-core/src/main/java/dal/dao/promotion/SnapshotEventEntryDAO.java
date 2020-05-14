package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.SnapshotEventEntryDO;
import dal.model.promotion.SnapshotEventEntryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SnapshotEventEntryDAO extends MyMapper<SnapshotEventEntryDO> {
    long countByExample(SnapshotEventEntryDOExample example);

    int deleteByExample(SnapshotEventEntryDOExample example);

    List<SnapshotEventEntryDO> selectByExampleWithBLOBs(SnapshotEventEntryDOExample example);

    List<SnapshotEventEntryDO> selectByExample(SnapshotEventEntryDOExample example);

    int updateByExampleSelective(@Param("record") SnapshotEventEntryDO record, @Param("example") SnapshotEventEntryDOExample example);

    int updateByExampleWithBLOBs(@Param("record") SnapshotEventEntryDO record, @Param("example") SnapshotEventEntryDOExample example);

    int updateByExample(@Param("record") SnapshotEventEntryDO record, @Param("example") SnapshotEventEntryDOExample example);
}
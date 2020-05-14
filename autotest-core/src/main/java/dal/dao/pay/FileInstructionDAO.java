package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.FileInstructionDO;
import dal.model.pay.FileInstructionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileInstructionDAO extends MyMapper<FileInstructionDO> {
    long countByExample(FileInstructionDOExample example);

    int deleteByExample(FileInstructionDOExample example);

    List<FileInstructionDO> selectByExample(FileInstructionDOExample example);

    int updateByExampleSelective(@Param("record") FileInstructionDO record, @Param("example") FileInstructionDOExample example);

    int updateByExample(@Param("record") FileInstructionDO record, @Param("example") FileInstructionDOExample example);
}
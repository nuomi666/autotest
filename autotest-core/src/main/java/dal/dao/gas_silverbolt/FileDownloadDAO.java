package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.FileDownloadDO;
import dal.model.gas_silverbolt.FileDownloadDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileDownloadDAO extends MyMapper<FileDownloadDO> {
    long countByExample(FileDownloadDOExample example);

    int deleteByExample(FileDownloadDOExample example);

    List<FileDownloadDO> selectByExampleWithBLOBs(FileDownloadDOExample example);

    List<FileDownloadDO> selectByExample(FileDownloadDOExample example);

    int updateByExampleSelective(@Param("record") FileDownloadDO record, @Param("example") FileDownloadDOExample example);

    int updateByExampleWithBLOBs(@Param("record") FileDownloadDO record, @Param("example") FileDownloadDOExample example);

    int updateByExample(@Param("record") FileDownloadDO record, @Param("example") FileDownloadDOExample example);
}
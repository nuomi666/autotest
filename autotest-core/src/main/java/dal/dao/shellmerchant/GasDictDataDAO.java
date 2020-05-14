package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasDictDataDO;
import dal.model.shellmerchant.GasDictDataDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDictDataDAO extends MyMapper<GasDictDataDO> {
    long countByExample(GasDictDataDOExample example);

    int deleteByExample(GasDictDataDOExample example);

    List<GasDictDataDO> selectByExample(GasDictDataDOExample example);

    int updateByExampleSelective(@Param("record") GasDictDataDO record, @Param("example") GasDictDataDOExample example);

    int updateByExample(@Param("record") GasDictDataDO record, @Param("example") GasDictDataDOExample example);
}
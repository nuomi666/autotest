package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasDictDataDO;
import dal.model.gas_merchant.GasDictDataDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasDictDataDAO extends MyMapper<GasDictDataDO> {
    long countByExample(GasDictDataDOExample example);

    int deleteByExample(GasDictDataDOExample example);

    List<GasDictDataDO> selectByExample(GasDictDataDOExample example);

    int updateByExampleSelective(@Param("record") GasDictDataDO record, @Param("example") GasDictDataDOExample example);

    int updateByExample(@Param("record") GasDictDataDO record, @Param("example") GasDictDataDOExample example);
}
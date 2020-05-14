package dal.dao.shellmerchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shellmerchant.GasProvinceDO;
import dal.model.shellmerchant.GasProvinceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasProvinceDAO extends MyMapper<GasProvinceDO> {
    long countByExample(GasProvinceDOExample example);

    int deleteByExample(GasProvinceDOExample example);

    List<GasProvinceDO> selectByExample(GasProvinceDOExample example);

    int updateByExampleSelective(@Param("record") GasProvinceDO record, @Param("example") GasProvinceDOExample example);

    int updateByExample(@Param("record") GasProvinceDO record, @Param("example") GasProvinceDOExample example);
}
package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.GasMerchantPaywayCopy1DO;
import dal.model.gas_merchant.GasMerchantPaywayCopy1DOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasMerchantPaywayCopy1DAO extends MyMapper<GasMerchantPaywayCopy1DO> {
    long countByExample(GasMerchantPaywayCopy1DOExample example);

    int deleteByExample(GasMerchantPaywayCopy1DOExample example);

    List<GasMerchantPaywayCopy1DO> selectByExampleWithBLOBs(GasMerchantPaywayCopy1DOExample example);

    List<GasMerchantPaywayCopy1DO> selectByExample(GasMerchantPaywayCopy1DOExample example);

    int updateByExampleSelective(@Param("record") GasMerchantPaywayCopy1DO record, @Param("example") GasMerchantPaywayCopy1DOExample example);

    int updateByExampleWithBLOBs(@Param("record") GasMerchantPaywayCopy1DO record, @Param("example") GasMerchantPaywayCopy1DOExample example);

    int updateByExample(@Param("record") GasMerchantPaywayCopy1DO record, @Param("example") GasMerchantPaywayCopy1DOExample example);
}
package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.ProductPermissionDO;
import dal.model.gas_merchant.ProductPermissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPermissionDAO extends MyMapper<ProductPermissionDO> {
    long countByExample(ProductPermissionDOExample example);

    int deleteByExample(ProductPermissionDOExample example);

    List<ProductPermissionDO> selectByExample(ProductPermissionDOExample example);

    int updateByExampleSelective(@Param("record") ProductPermissionDO record, @Param("example") ProductPermissionDOExample example);

    int updateByExample(@Param("record") ProductPermissionDO record, @Param("example") ProductPermissionDOExample example);
}
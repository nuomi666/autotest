package dal.dao.gas_merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_merchant.ProductDO;
import dal.model.gas_merchant.ProductDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDAO extends MyMapper<ProductDO> {
    long countByExample(ProductDOExample example);

    int deleteByExample(ProductDOExample example);

    List<ProductDO> selectByExample(ProductDOExample example);

    int updateByExampleSelective(@Param("record") ProductDO record, @Param("example") ProductDOExample example);

    int updateByExample(@Param("record") ProductDO record, @Param("example") ProductDOExample example);
}
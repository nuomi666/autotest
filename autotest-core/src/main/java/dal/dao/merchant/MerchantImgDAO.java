package dal.dao.merchant;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.merchant.MerchantImgDO;
import dal.model.merchant.MerchantImgDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantImgDAO extends MyMapper<MerchantImgDO> {
    long countByExample(MerchantImgDOExample example);

    int deleteByExample(MerchantImgDOExample example);

    List<MerchantImgDO> selectByExample(MerchantImgDOExample example);

    int updateByExampleSelective(@Param("record") MerchantImgDO record, @Param("example") MerchantImgDOExample example);

    int updateByExample(@Param("record") MerchantImgDO record, @Param("example") MerchantImgDOExample example);
}
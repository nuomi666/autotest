package dal.dao.pay;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.pay.PayGwRelaDO;
import dal.model.pay.PayGwRelaDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayGwRelaDAO extends MyMapper<PayGwRelaDO> {
    long countByExample(PayGwRelaDOExample example);

    int deleteByExample(PayGwRelaDOExample example);

    List<PayGwRelaDO> selectByExample(PayGwRelaDOExample example);

    int updateByExampleSelective(@Param("record") PayGwRelaDO record, @Param("example") PayGwRelaDOExample example);

    int updateByExample(@Param("record") PayGwRelaDO record, @Param("example") PayGwRelaDOExample example);
}
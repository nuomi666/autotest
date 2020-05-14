package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import com.xjy.autotest.mybatis.SimpleSelectInDriver;
import dal.model.gas_silverbolt.GasTradeOilDO;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GasTradeOilMapper {

    @Select("select sum(b.oil_liter) from gas_trade_oil b where " +
            "b.biz_no in (#{bizNos})"
    )
    @Lang(SimpleSelectInDriver.class)
    public String findOilsByBizNos(@Param("bizNos") List<String> bizNos);
}
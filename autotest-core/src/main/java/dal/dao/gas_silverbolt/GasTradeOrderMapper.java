package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import com.xjy.autotest.mybatis.SimpleSelectInDriver;
import dal.model.gas_silverbolt.GasTradeOrderDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface GasTradeOrderMapper {

    /**
     * 根据商户、时间等查询订单号汇总
     *
     * @param partnerId
     * @param operateName
     * @param tradeType
     * @param beginTime
     * @param finishTime
     * @return
     */
    @Select("select  a.biz_no from gas_trade_order  a where " +
            "a.partner_id = #{partnerId}" +
            "and a.trade_type = #{tradeType} " +
            "and a.operate_name = #{operateName} " +
            "and a.finish_time >= #{beginTime} " +
            "and a.finish_time <= #{finishTime} "
    )
    List<String> findbizNosByTime(String partnerId, String operateName, String tradeType,
                                  String beginTime, String finishTime);

    /**
     * 根据订单号查询统计信息
     *
     * @param bizNos
     * @return
     */
    @Select("select " +
            "sum(a.amount) amounts, " +
            "count(*) counts, " +
            "a.station_name stationName, " +
            "sum(a.favour_amount) favourAmounts, " +
            "(sum(a.amount)-sum(a.favour_amount)) settleAmounts " +
            "from gas_trade_order  a where " +
            "a.biz_no in (#{bizNos})"
    )
    @Lang(SimpleSelectInDriver.class)
    public Map<String, Object> findGasTradeOrderByBizNos(@Param("bizNos") List<String> bizNos);

    /**
     * 根据商户号，时间等查询订单
     *
     * @param partnerId
     * @param stationId
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("<script> " +
            "select * from gas_trade_order t where " +
            "t.partner_id = #{partnerId} " +
            "and t.station_id = #{stationId} " +
            "<if test='startTime != null'> " +
            "and t.finish_time <![CDATA[ >= ]]> #{startTime} " +
            "</if> " +
            "<if test='endTime != null'> " +
            "and t.finish_time <![CDATA[ <= ]]>  #{endTime} " +
            "</if> " +
            "</script> ")
    public List<GasTradeOrderDO> findGasTradeOrderByPartnerIdAndStationId(
            @Param("partnerId") String partnerId,
            @Param("stationId") String stationId,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime);


    /**
     * 根据商户、订单类型、油站Id查询订单
     *
     * @param partnerId
     * @param tradeType
     * @param stationId
     * @return
     */
    @Select("select * from gas_trade_order t where " +
            "t.partner_id =#{partnerId} " +
            "and t.trade_type =#{tradeType} " +
            "and t.station_id =#{stationId} ")
    public List<GasTradeOrderDO> findGasTradeOrderByPartnerIdAndTradeTypeAndStationId(
            @Param("partnerId") String partnerId,
            @Param("tradeType") String tradeType,
            @Param("stationId") String stationId);


}
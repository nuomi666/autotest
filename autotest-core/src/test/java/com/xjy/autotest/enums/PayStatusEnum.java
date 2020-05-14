package com.xjy.autotest.enums;


/**
 * @author 黄飞
 * @project pay-gather-model
 * @title PayStatusEnum
 * @Description: TODO
 * @date 2016年7月6日 下午2:07:43
 * @Company 重庆爱车联信息科技技术有限公司
 * @Copyright 2016
 * @version V1.0
 */
public enum PayStatusEnum {

	
	WAIT_PAY("WAIT_PAY","待支付"),
	BILL_FAIL("FAIL","交易失败"),
	SUCCESS("SUCCESS","交易成功"),
	CLOSE("CLOSE","交易关闭"),
	WAIT_BANK_BACK("WAIT_BANK_BACK","待银行返回处理结果"),
	NEW("NEW","新建交易"),
	REFUND("REFUND","已退款") //微信对账专用 by yangxiu
	;
	/**
	 * 构造一个<code>PayStatusEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private PayStatusEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	/**
	 * 枚举值
	 */
	private final String code;
	
	/**
	 * 枚举描述	
	 */
	private final String message;
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	public static String getValue(String code){
		for(PayStatusEnum genum :PayStatusEnum.values()){
			if(genum.code.equals(code)){
				return genum.message;
			}
		}
		return null;
	}
}

package com.xjy.autotest.coverage;

/**
 * @author 面条
 * @mail miantiao@yiji.com 修订记录： 面条 2017-3-15 下午5:09:07 创建
 * 
 * 服务应用场景：该服务是在用户在电商平台完成额度申请审核通过后，接着在电商平台成功下单需要支付时，跳到易极付收银台，点击所显示“白条支付”按钮，
 * 会调该服务完成贷款申请， 贷款申请成功后完成交易订单支付。
 * 
 * 开发实现逻辑：订单幂等性校验=>校验用户是否存在=>校验消金公司保证金是否足额=>校验用户授信余额是否充足=>过风控审核=>减少信用额度=>
 * 持久化订单并返回=>异步同步数据至数据中心（不影响成功） 计息公式xxxx；
 * 
 * 用例整体设计：（非用例项设计）该用例执行需开发的基础数据xxxx.sql；该用例的xxx数据采用sql/动态插入数据准备；
 * 
 * 涉及系统（表名）：系统英文名{表名（作用）}
 * 
 * 特别注意：
 * 
 */
public enum SystemConfig {
	/**
	 * address:vm 参数中配置端口地址
	 * dumpFile:从远程虚拟机中获取代码覆盖率文件，cbcustomer_dump是将要获取生成的文件名，你不能去创建这个名字的文件夹或文件
	 * reportBaseDir:D:\\code-coverage-plugin\\report\\cbcustomer
	 * projectBaseDir:D:\\coverage\\cbcustomer\\trunk
	 */
	//会员账务系统
	xybUser("localhost:1111", "D:\\cov\\dump\\xybUser_dump",
				"D:\\cov\\report\\xybUser", "D:\\work\\xyb-user"),
	//商户系统
//	CBMERCHANT("localhost:5502", "D:\\code-coverage-plugin\\dump\\cbcustomer_dump",
//				"D:\\code-coverage-plugin\\report\\cbcustomer", "D:\\coverage\\cbcustomer\\trunk");
	;
	
	/**
	 * vm 参数中配置地址和端口 ，如localhost:55500
	 */
	private final String address;
	
	/**
	 * 从远程虚拟机中获取代码覆盖率文件，cbcustomer_dump是将要获取生成的文件名，你不能去创建这个名字的文件夹或文件
	 * 如D:\\code-coverage-plugin\\dump\\cbcustomer_dump
	 */
	private final String dumpFile;
	/**
	 * 根据dump文件生成报告存放的路径，cbcustomer这个一定得创建
	 * 如D:\\code-coverage-plugin\\report\\cbcustomer
	 */
	private final String reportBaseDir;
	
	/**
	 * 被测试的应用的源代码地址，如D:\\coverage\\cbcustomer\\trunk
	 */
	private final String projectBaseDir;
	
	/**
	 * 
	 * @param address 枚举值
	 * @param dumpFile 枚举描述
	 */
	private SystemConfig(String address, String dumpFile, String reportBaseDir,
							String projectBaseDir) {
		this.address = address;
		this.dumpFile = dumpFile;
		this.reportBaseDir = reportBaseDir;
		this.projectBaseDir = projectBaseDir;
	}
	
	/**
	 * @return Returns the address.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @return Returns the dumpFile.
	 */
	public String getDumpFile() {
		return dumpFile;
	}
	
	public String getReportBaseDir() {
		return reportBaseDir;
	}
	
	public String getProjectBaseDir() {
		return projectBaseDir;
	}
	
	/**
	 * @return Returns the address.
	 */
	public String address() {
		return address;
	}
	
	/**
	 * @return Returns the dumpFile.
	 */
	public String dumpFile() {
		return dumpFile;
	}
	
	/**
	 * @return Returns the address.
	 */
	public String reportBaseDir() {
		return address;
	}
	
	/**
	 * @return Returns the dumpFile.
	 */
	public String projectBaseDir() {
		return dumpFile;
	}
	
	/**
	 * 通过枚举<address>address</address>获得枚举
	 * 
	 * @param address
	 * @return SystemConfig
	 */
	public static SystemConfig getByAddress(String address) {
		for (SystemConfig _enum : values()) {
			if (_enum.getAddress().equals(address)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<SystemConfig>
	 */
	public java.util.List<SystemConfig> getAllEnum() {
		java.util.List<SystemConfig> list = new java.util.ArrayList<SystemConfig>();
		for (SystemConfig _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public java.util.List<String> getAllEnumAddress() {
		java.util.List<String> list = new java.util.ArrayList<String>();
		for (SystemConfig _enum : values()) {
			list.add(_enum.address());
		}
		return list;
	}
}

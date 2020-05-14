package com.xjy.autotest.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by yu on 2017/9/27.
 */
public class JSchUtil {

	private static final Log logger = LogFactory.getLog(JSchUtil.class);

	private static Session session;

	private JSch jsch;

	public void go() {
		String user = "root";//SSH连接用户名
		String password = "Xjiye2016";//SSH连接密码
		String host = "47.98.103.58";//SSH服务器
		int port = 22;//SSH访问端口
		try {
			if (null == session || !session.isConnected()) {
				jsch = new JSch();
				session = jsch.getSession(user, host, port);
				session.setPassword(password);
				session.setConfig("StrictHostKeyChecking", "no");
				session.connect();
				System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息
				int assinged_port = session.setPortForwardingL(3308, "127.0.0.1", 3306);
				System.out.println("localhost:" + assinged_port + " -> " + "127.0.0.1" + ":" + 3306);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		if (null != session && session.isConnected()) {
			session.disconnect();
		}
	}

}

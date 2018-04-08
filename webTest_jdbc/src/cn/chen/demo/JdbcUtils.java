package cn.chen.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

	private static Properties prop = null;
	static {
		try {
			// 加载配置文件
			InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop = new Properties();
			prop.load(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try {
			//加载驱动类
			Class.forName(prop.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// 加载驱动类
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(prop.getProperty("url"), 
				prop.getProperty("sqlusername"),
				prop.getProperty("sqlpassword"));
	}

}

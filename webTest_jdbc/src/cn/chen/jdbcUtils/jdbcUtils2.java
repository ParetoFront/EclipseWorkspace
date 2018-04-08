 package cn.chen.jdbcUtils;

import java.sql.Connection;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcUtils2 {
	//使用的是默认配置
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	public static Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}
	public static DataSource getDataSource() {
		return dataSource;
	}
}

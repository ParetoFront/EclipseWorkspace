package cn.chen.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	/**
	 * Factory的getDaoUser方法应 返回一个具体的UserDao的实现类对象
	 * 使用配置文件，文件中给出UserDao接口的实现类名称
	 * 通过反射获得该实现类的实例对象，并返回
	 * 
	 * 这样，我们就实现了实现类与程序主体的分离
	 * 下次更改实现类只需要修改配置文件即可
	 * 目前可以使用的有UserDaoImpl和JdbcUserDaoImpl
	 * @return
	 */

	private static Properties prop = null;
	static {
		try {
			InputStream is = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			prop = new Properties();
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public static UserDao getUserDao() {
		String daoClassName=prop.getProperty("cn.chen.user.dao.UserDao");
		try {
			return (UserDao) Class.forName(daoClassName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}

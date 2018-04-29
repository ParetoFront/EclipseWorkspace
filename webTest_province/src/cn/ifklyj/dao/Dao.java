package cn.ifklyj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.mchange.v2.codegen.bean.BeangenUtils;

import cn.ifklyj.domain.City;
import cn.ifklyj.domain.Province;
import cn.itcast.jdbc.TxQueryRunner;

public class Dao {
	private QueryRunner qr=new TxQueryRunner();
	public List<Province> findAllProvince(){
		String sql="select * from provinces";
		try {
			return qr.query(sql, new BeanListHandler<Province>(Province.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<City> findByProvince(int pid){
		String sql="select * from cities where pid=?";
		try {
			//一行记录,每列可以转化为一个map，则一行记录包含多个map对象，组合为一个List<Map>
			//若数据库中存在外链，需要将一行记录转化为多个对象，如此例中需要将由查询记录生成province和city
			
			return qr.query(sql, new BeanListHandler<City>(City.class),pid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

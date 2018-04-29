package cn.ifklyj.service;

import java.util.List;

import cn.ifklyj.dao.Dao;
import cn.ifklyj.domain.City;
import cn.ifklyj.domain.Province;

public class Service {
	private Dao dao=new Dao();
	public List<Province> findAllProvince() {
		return dao.findAllProvince();
	}
	public List<City> findByProvince(int pid){
		return dao.findByProvince(pid);
	}
}

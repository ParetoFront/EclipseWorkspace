package cn.ifklyj.domain;

import java.util.List;

public class Province {
	private int pid;
	private String pname;
	private List<City> cityList;  //一方关联多方
	public Province(int pid, String pname, List<City> cityList) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cityList = cityList;
	}
	public Province() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	@Override
	public String toString() {
		return "Province [pid=" + pid + ", pname=" + pname + "]";
	}
	
}

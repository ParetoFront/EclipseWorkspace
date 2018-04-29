package cn.ifklyj.domain;

public class City {
	private int cid;
	private String cname;
	private Province province;  //多方关联一方
	public City(int cid, String cname, Province province) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.province = province;
	}
	public City() {
		super();
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	@Override
	public String toString() {
		return "City [cid=" + cid + ", cname=" + cname + ", province=" + province + "]";
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	
}

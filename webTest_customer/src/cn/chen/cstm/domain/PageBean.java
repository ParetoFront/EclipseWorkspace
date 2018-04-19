package cn.chen.cstm.domain;

import java.util.List;

public class PageBean<T> {
	private int pc; // page code当前页码
	// private int tp; //total page,总页数是计算得到的，不需要set方法，考虑到bean，直接取消创建该变量，只保留set方法
	private int tr; // total record
	private int ps; // page size
	private List<T> beanList;
	private String url; // 检索条件

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	// 计算总页数
	public int getTp() {
		int tp = tr / ps;
		return tr % ps == 0 ? tp : tp + 1;
	}

	// public void setTp(int tp) {
	// this.tp = tp;
	// }
	public int getTr() {
		return tr;
	}

	public void setTr(int tr) {
		this.tr = tr;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

}

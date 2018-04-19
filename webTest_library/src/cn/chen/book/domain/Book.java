package cn.chen.book.domain;

public class Book {
	private String bid;
	private String price;
	private String bname;
	private String category;
	public String getBid() {
		return price;
	}
	public void setBid(String bid) {
		this.price = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", price=" + price + ", bname=" + bname + ", category=" + category + "]";
	}
	
	
	
}

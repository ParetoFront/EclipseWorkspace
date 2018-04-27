package cn.ifklyj.XStream;

import java.util.ArrayList;
import java.util.List;

public class Province {
	private String name;
	private String description;
	private List<City> cities=new ArrayList<>();
	public void addCity(City city) {
		cities.add(city);
		
	}
	public Province(String name, String description, List<City> cities) {
		super();
		this.name = name;
		this.description = description;
		this.cities = cities;
	}
	public Province() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	@Override
	public String toString() {
		return "Province [name=" + name + ", description=" + description + ", cities=" + cities + "]";
	}
	
}

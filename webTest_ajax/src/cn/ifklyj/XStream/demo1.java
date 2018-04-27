package cn.ifklyj.XStream;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class demo1 {
	public List<Province> getProvinceList(){
		Province p1=new Province();
		p1.setName("北京");
		p1.addCity(new City("东城区","DongChengQu"));
		p1.addCity(new City("昌平区","ChangPingQu"));
		
		Province p2=new Province();
		p2.setName("天津");
		p2.addCity(new City("沈阳","ShenYang"));
		p2.addCity(new City("葫芦岛","HuLuDao"));
		
		List<Province> list=new ArrayList<>();
		list.add(p1);
		list.add(p2);
		return list;
	}
	@Test
	public void fun1() {
		List<Province> proList =getProvinceList();
		XStream xstream=new XStream();
		String s=xstream.toXML(proList);
		System.out.println(s);
	}
	@Test
	public void fun2() {
		List<Province> proList=getProvinceList();
		XStream xstream=new XStream();
		//为特定类型指定别名，如将<cn.ifklyj.Province>指定为<province>
		xstream.alias("china", List.class);
		xstream.alias("province", Province.class);
		xstream.alias("city", City.class);
		//将Province类型的name属性改为province元素的属性,即形式为<province name="xxx">
		xstream.useAttributeFor(Province.class,"name");
		//去除<cities>这样的collection类型的属性
		xstream.addImplicitCollection(Province.class, "cities");
		//去除某些不需要显示的属性，如city类中的description属性
		xstream.omitField(City.class, "description");
		String s=xstream.toXML(proList);
		System.out.println(s);
	}
}

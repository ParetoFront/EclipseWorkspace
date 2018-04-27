package cn.ifklyj.json;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class JSON_lib_test {
	//JSONObject的使用
	@Test
	public void fun() {
		JSONObject map=new JSONObject();
		map.put("name", "mike");
		map.put("age", "18");
		String s=map.toString();
		System.out.println(s);
	}
	//已有一个对象时，可以将该对象转化为JSONObject对象
	@Test
	public void fun1() {
		Person p=new Person("mike","18");
		JSONObject map=JSONObject.fromObject(p);
		System.out.println(map.toString());
	}
	//JSONArray的使用
	@Test
	public void fun2() {
		Person p1=new Person("mike","18");
		Person p2=new Person("jack","22");
		JSONArray list=new JSONArray();
		list.add(p1);
		list.add(p2);
		System.out.println(list.toString());
	}
	//已有list时，可以将该list转化为JSONArray对象
	@Test
	public void fun3() {
		List<Person> list=new ArrayList<>();
		Person p1=new Person("mike","18");
		Person p2=new Person("jack","22");
		list.add(p1);
		list.add(p2);
		JSONArray arr=JSONArray.fromObject(list);
		System.out.println(arr.toString());
	}
}

package cn.chen.user.dao;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.chen.user.domain.User;

public class UserDao {
	private String path = "E://users.xml";

	public User findByUsername(String username) {
		// 1.创建解析器
		SAXReader reader=new SAXReader();
		try {
			//得到document
			Document doc=reader.read(path);
			// 2.xpath查询
			Element ele=(Element)doc.selectSingleNode("//user[@username='"+username+"']");
			// 3.校验查询结果是否为null,若为null则返回null
			if(ele==null) return null;
			//返回user
			User user=new User();
			user.setUsername(ele.attributeValue("username"));
			user.setPassword(ele.attributeValue("password"));
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(User user) {
		//1 得到document
		SAXReader reader=new SAXReader();
		try {
			Document doc=reader.read(path);
			//获得根元素
			Element root=doc.getRootElement();
			//通过根元素创建新元素
			Element userEle=root.addElement("user");
			//将新用户信息输入该元素
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());
			//保存文档
			//创建输出格式化器
			OutputFormat format=new OutputFormat("\t",true);//缩进使用\t，是否换行为true
			format.setTrimText(true);//清空原有的换行和缩进
			//创建XMLWriter
			XMLWriter writer=new XMLWriter(new OutputStreamWriter(
					new FileOutputStream(path), "utf-8"),format);
			writer.write(doc);
			writer.close();
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2 得到root元素
		//3 将user转化为element并添加到root中
		//4 保存document
		
	}
}

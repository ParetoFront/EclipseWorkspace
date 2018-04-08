package jaxptest;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class testJaxp {
	public static void main(String[] args) throws Exception {
//		selectAll();
		addNode();
		
	}

	private static void addNode() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/jaxptest/person.xml");
		NodeList list=document.getElementsByTagName("p1");
		Node p1=list.item(0);
		Element sex1=document.createElement("sex");
		Text text1=document.createTextNode("女");
		sex1.appendChild(text1);
		p1.appendChild(sex1);
		TransformerFactory transFac=TransformerFactory.newInstance();
		Transformer trans=transFac.newTransformer();
		trans.transform(new DOMSource(document), new StreamResult("src/jaxptest/person.xml"));
	}

	private static void selectAll() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("src/jaxptest/person.xml");
		NodeList list = document.getElementsByTagName("name");
		for (int i = 0; i < list.getLength(); i++) {
			Node name1 = list.item(i);
			System.out.println(name1.getTextContent());
		}
	}
}

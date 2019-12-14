package by.bsuir.fando.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.bsuir.fando.entity.FullName;
import by.bsuir.fando.entity.Product;

public class XML {
	public static List<Product> parse(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		List<Product> resultList = new ArrayList<Product>();
		Node rootElement = getRootElement(xmlFile);
		NodeList nlist = getNodeList(rootElement);
		String attribute;
		String title;
		FullName fullName;
		double price;
		int amount;
		
		for (int i = 0 ; i < nlist.getLength() ; i++) {
			if (i % 2 == 0) continue;
		    Node node = nlist.item(i);
		    NodeList productChilds = getNodeList(node);
		    NodeList fullNameChilds = getNodeList(productChilds.item(3));
		    
		    attribute = parseNode(node.getAttributes().item(0));
		    title = parseNode(productChilds.item(1));
		    fullName = new FullName(parseNode(fullNameChilds.item(1)), parseNode(fullNameChilds.item(3)));
		    price = Double.parseDouble(parseNode(productChilds.item(5)));
		    amount = Integer.parseInt(parseNode(productChilds.item(7)));
		    resultList.add(new Product(attribute, title, fullName, price, amount));
		}
		return resultList;
		
	}
	private static Node getRootElement(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xmlDoc = builder.parse(xmlFile);
		return xmlDoc.getFirstChild();
	}
	
	private static NodeList getNodeList(Node node) {
		return node.getChildNodes();
	}
	
	private static String parseNode(Node node) {
		return node.getTextContent();
	}
	
	
	
	
	
	
	
	
	
}


package by.bsuir.fando.DL;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import by.bsuir.fando.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class SAXParser extends DefaultHandler {
	private List<Product> list = null;
	private Product product;
	private String tagName;

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<Product>();
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("product".equals(qName)) {
			product = new Product(attributes.getValue(0), null, null, null, 0, 0);
		}
		tagName = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ("product".equals(qName)) {
			list.add(product);
		}
		tagName = null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (tagName != null && !tagName.trim().equals("")) {
			String data = new String(ch, start, length);
			if (tagName.equals("title")) {
				product.setTitle(data);
			} else if (tagName.equals("manufacturer")) {
				product.setManufacturer(data);
			} else if (tagName.equals("model")) {
				product.setModel(data);
			} else if (tagName.equals("price")) {
				product.setPrice(Double.parseDouble(data));
			} else if (tagName.equals("amount")) {
				product.setAmount(Integer.parseInt(data));
			}
		}
	}
}
package by.bsuir.fando.DL;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import by.bsuir.fando.entity.Product;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StAXParser implements AutoCloseable {

	
	
	 
	
	private static XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
	
	private static Logger log = Logger.getLogger(String.valueOf(StAXParser.class));
	private XMLEventReader reader = null;
	private ArrayList<Product> products = new ArrayList<Product>();

	public List<Product> parse() throws XMLStreamException {
		log.info("StAX: Parsing started");
		Product product = null;
		while (reader.hasNext()) {
		    XMLEvent nextEvent = reader.nextEvent();
		    if (nextEvent.isStartElement()) {
		        StartElement startElement = nextEvent.asStartElement();
		        switch (startElement.getName().getLocalPart()) {
		            case "product":
		                product = new Product(null, null, null, null, 0, 0);
		                Attribute id = startElement.getAttributeByName(new QName("id"));
		                if (id != null) {
		                    product.setAttribute(id.getValue());
		                }
		                break;
		            case "title":
		            	nextEvent = reader.nextEvent();
		                product.setTitle(nextEvent.asCharacters().getData());
						break;
					case "manufacturer":
						nextEvent = reader.nextEvent();
						product.setManufacturer(nextEvent.asCharacters().getData());
						break;
					case "model":
						nextEvent = reader.nextEvent();
						product.setModel(nextEvent.asCharacters().getData());
						break;
					case "price":
						nextEvent = reader.nextEvent();
						product.setPrice(Double.parseDouble(nextEvent.asCharacters().getData()));
						break;
					case "amount":
						nextEvent = reader.nextEvent();
						product.setAmount(Integer.parseInt(nextEvent.asCharacters().getData()));
						break;
		        }
		    }
		    if (nextEvent.isEndElement()) {
		        EndElement endElement = nextEvent.asEndElement();
		        if (endElement.getName().getLocalPart().equals("product")) {
		            products.add(product);
		        }
			}
		}
		log.info("StAX: Parsing completed");
		return products;
	}

	public StAXParser(InputStream is) throws XMLStreamException {
		
		reader = xmlInputFactory.createXMLEventReader(is);
	}

	public XMLEventReader getReader() {
		return reader;
	}

	@Override
	public void close() {
		if (reader != null) {
			try {
				reader.close();
			} catch (XMLStreamException e) { // empty
			}
		}
	}
}
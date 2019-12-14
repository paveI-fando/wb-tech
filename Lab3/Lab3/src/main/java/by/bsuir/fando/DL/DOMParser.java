package by.bsuir.fando.DL;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.bsuir.fando.entity.Product;

import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class DOMParser {
    public static final String PRODUCT = "product";
    private List<Product> products;
    private static Logger log = Logger.getLogger(String.valueOf(DOMParser.class));

    public List<Product> parse(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {

        log.info("DOM: Parsing started");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);

        NodeList productElements = document.getDocumentElement().getElementsByTagName(PRODUCT);

        products = new ArrayList<>();
        for (int i = 0; i < productElements.getLength(); i++) {

            Node nNode = productElements.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println();
                Product product = new Product(null, null, null, null, 0, 0);
                product.setAttribute(eElement.getAttributes().getNamedItem("id").getNodeValue());
                product.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
                product.setManufacturer(eElement.getElementsByTagName("manufacturer").item(0).getTextContent());
                product.setModel(eElement.getElementsByTagName("model").item(0).getTextContent());
                product.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));                
                product.setAmount(Integer.parseInt(eElement.getElementsByTagName("amount").item(0).getTextContent()));


                products.add(product);
            }
        }
        log.info("DOM: Parsing completed");
        return products;
    }
}
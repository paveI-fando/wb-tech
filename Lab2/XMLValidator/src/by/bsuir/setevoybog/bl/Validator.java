package by.bsuir.fando.bl;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class Validator {
	public static boolean validateXMLByXSD(File xml, File xsd) throws SAXException, IOException {
		  try {
		      SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
		      .newSchema(xsd)
		      .newValidator()
		      .validate(new StreamSource(xml));
		  } catch (Exception e) {
		      e.printStackTrace();
		      return false;
		  }
		  return true;
		}
}

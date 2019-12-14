package by.bsuir.fando;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import by.bsuir.fando.dao.DB;
import by.bsuir.fando.dao.Table;
import by.bsuir.fando.dao.XML;
import by.bsuir.fando.entity.Product;

public class Main {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, SQLException {
		//File xmlFile = new File(args[0]);
		File xmlFile = new File("C:\\Data\\GIT\\Web-Technologies-Lab2\\products.xml");
		List<Product> products = XML.parse(xmlFile);
		String dbUrl = "jdbc:mysql://localhost:3306/wt2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Connection connection = DB.connect(dbUrl, "root", "skadjfhKFHiuugf924gfhKFLUGpf248yh8fi323*#(YR(&Y$792y94rf2yhf");
		
		DatabaseMetaData md = connection.getMetaData();
		ResultSet rs = md.getTables(null, null, "products", null);
		if (connection != null) {
			logger.info("Connected");
			if (rs.next() == false) {
				Table.create(connection);
				logger.info("Table created");
			} else {
				logger.info("Table already exist");
			}
			for (Product product : products) {
				try {
					Table.insert(connection, product);
					logger.info("Product "+product.toString()+" added to DB");
				} catch (SQLException e) {
					logger.info(e);
				}
			}
			connection.close();
		}
		
		
	}
}
